package com.springbootTz.ZNYY.Equipment.service;

import com.springbootTz.ZNYY.Equipment.entity.znyy.EquipDiscardedRecord;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetCard;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.LexmisN6_AssetCardMapper;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.UnitInfoToolMapper;
import com.springbootTz.ZNYY.Equipment.mapper.znyy.EquipCardInfoMapper;
import com.springbootTz.ZNYY.Equipment.mapper.znyy.EquipDiscardedRecordMapper;
import com.springbootTz.ZNYY.Equipment.dto.AssetDisposalWithDetailDTO;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.AssetDisposalQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

@Service
public class EquipDiscardedRecordService {
    @Autowired
    private UnitInfoToolMapper unitInfoToolMapper;

    @Autowired
    private LexmisN6_AssetCardMapper lexmisN6_AssetCardMapper;

    @Autowired
    private EquipCardInfoMapper equipCardInfoMapper;

    @Autowired
    private EquipDiscardedRecordMapper equipDiscardedRecordMapper;

    @Autowired
    private AssetDisposalQueryMapper assetDisposalQueryMapper;

    /**
     * 映射关系
     * equip_discarded_record表，formmain_1082和formson_1083的关联表AssetDisposalWithDetailDTO
     * rid，uscid+sys_prdr_code+discarded_no
     * orgName,unitInfoToolMapper.selectUnitNameById(field0034)
     * uscid,unitInfoToolMapper.selectUnitCodeByName(field0034)
     * uploadTime,当前上传时间
     * sysPrdrCode,FJZZZYKJYXGS
     * sysPrdrName,福建众智政友科技有限公司
     * discardedNo,field0001
     * equipCode,field0023
     * equipName,field0006
     * spec,equipCardInfoMapper.selectByEquipCardNo(field0023).getusefulLife()如果不存在则为0
     * equipModel,field0013
     * unit,1
     * unitName,个
     * useDep,field0019
     * equipPric,field0015
     * purcDate,field0014
     * usedLife,当前日期-field0015获取已用年限
     * estimaResidualValue,0
     * discardedRea,field0009
     * applyerName,无
     * applyDate,无
     * auditOperatorName,无
     * auditDate,startDate
     * manufacturerCode,无
     * manufacturerName,equipCardInfoMapper.selectByEquipCardNo(field0023).getmanufacturerName()如果不存在则为"无"
     * state,0
     * reserve1,无
     * reserve2,无
     * dataClctPrdrName,福建众智政友科技有限公司
     * crteTime,startDate
     * updtTime,startDate
     * deleted,默认0，除非update的时候没有这条记录需要update，那就把deleted设为1，表示该条记录被删除了
     * deletedTime，默认时间2025-08-06 00:00:00
     */

    /**
     * 同步设备报废记录数据从seeyon到ZNYY
     */
    public void syncEquipDiscardedRecord() {
        // 获取所有报废记录
        List<AssetDisposalWithDetailDTO> disposalList = assetDisposalQueryMapper.selectAllAssetDisposals();

        System.out.println("=== 报废记录推送统计 ===");
        System.out.println("从 seeyon 查询到的报废记录总数: " + disposalList.size());

        if (disposalList.isEmpty()) {
            System.out.println("警告: 没有查询到任何报废记录！");
            return;
        }

        int insertCount = 0;
        int updateCount = 0;
        int skipCount = 0;
        int errorCount = 0;
        int deleteCount = 0;

        // 收集本次推送的所有RID
        Set<String> currentRids = new HashSet<>();

        for (AssetDisposalWithDetailDTO disposal : disposalList) {
            try {
                // 获取单位信息
                String unitName = unitInfoToolMapper.selectUnitNameById(Long.parseLong(disposal.getField0034()));

                // 跳过"周宁总医院"的数据
                if (unitName != null && unitName.contains("周宁总医院")) {
                    System.out.println("跳过周宁总医院数据，报废编号: " + disposal.getField0001() + ", 单位: " + unitName);
                    skipCount++;
                    continue;
                }

                // 映射数据
                EquipDiscardedRecord equipDiscardedRecord = mapToEquipDiscardedRecord(disposal);

                // 添加到当前RID集合
                currentRids.add(equipDiscardedRecord.getRid());

                // 检查是否已存在
                int exists = equipDiscardedRecordMapper.checkEquipDiscardedRecordExists(equipDiscardedRecord.getRid());

                if (exists > 0) {
                    // 存在则更新
                    equipDiscardedRecordMapper.updateEquipDiscardedRecord(equipDiscardedRecord);
                    updateCount++;
                } else {
                    // 不存在则插入
                    equipDiscardedRecordMapper.insertEquipDiscardedRecord(equipDiscardedRecord);
                    insertCount++;
                }
            } catch (Exception e) {
                System.out.println("处理报废记录失败，报废编号: " + disposal.getField0001() + ", 错误: " + e.getMessage());
                errorCount++;
            }
        }

        // 处理删除逻辑：标记目标库中存在但源库中不存在的记录为已删除
        try {
            // 查询目标库中所有未删除的RID
            List<String> existingRids = equipDiscardedRecordMapper.selectActiveRidsBySysPrdrCode("FJZZZYKJYXGS");
            Set<String> existingRidSet = new HashSet<>(existingRids);

            // 找出需要删除的RID（目标库有但源库没有的）
            Set<String> toDeleteRids = new HashSet<>(existingRidSet);
            toDeleteRids.removeAll(currentRids);

            if (!toDeleteRids.isEmpty()) {
                String ridsToDelete = String.join("','", toDeleteRids);
                deleteCount = equipDiscardedRecordMapper.batchMarkAsDeleted("'" + ridsToDelete + "'");
                System.out.println("标记删除的RID数量: " + deleteCount);
                System.out.println("被删除的RID: " + toDeleteRids);
            }
        } catch (Exception e) {
            System.out.println("处理删除逻辑时发生错误: " + e.getMessage());
        }

        System.out.println("=== 报废记录推送完成统计 ===");
        System.out.println("新增: " + insertCount + " 条");
        System.out.println("更新: " + updateCount + " 条");
        System.out.println("删除: " + deleteCount + " 条");
        System.out.println("跳过: " + skipCount + " 条");
        System.out.println("错误: " + errorCount + " 条");
        System.out.println("总计处理: " + (insertCount + updateCount + deleteCount + skipCount + errorCount) + " 条");
    }

    /**
     * 将AssetDisposalWithDetailDTO映射为EquipDiscardedRecord
     */
    private EquipDiscardedRecord mapToEquipDiscardedRecord(AssetDisposalWithDetailDTO disposal) {
        EquipDiscardedRecord equipDiscardedRecord = new EquipDiscardedRecord();

        // 获取单位信息
        String unitCode = String
                .valueOf(unitInfoToolMapper.selectUnitCodeByName(Long.parseLong(disposal.getField0034())));
        String unitName = unitInfoToolMapper.selectUnitNameById(Long.parseLong((disposal.getField0034())));

        // 生成RID: uscid+FJZZZYKJYXGS+discarded_no
        String rid = unitCode + "FJZZZYKJYXGS" + disposal.getField0001();

        // 设置基本信息
        equipDiscardedRecord.setRid(rid);
        equipDiscardedRecord.setOrgName(unitName);
        equipDiscardedRecord.setUscid(unitCode);
        equipDiscardedRecord.setUploadTime(getCurrentTime());
        equipDiscardedRecord.setSysPrdrCode("FJZZZYKJYXGS");
        equipDiscardedRecord.setSysPrdrName("福建众智政友科技有限公司");
        equipDiscardedRecord.setDiscardedNo(disposal.getField0001());
        equipDiscardedRecord.setEquipCode(disposal.getField0023());
        equipDiscardedRecord.setEquipName(disposal.getField0006());

        // 必填字段：项目规格
        equipDiscardedRecord.setSpec("无");

        // 必填字段：设备型号
        equipDiscardedRecord.setEquipModel(disposal.getField0013() != null ? disposal.getField0013() : "无");

        // 必填字段：计量单位
        equipDiscardedRecord.setUnit("1");

        // 必填字段：计量单位名称
        equipDiscardedRecord.setUnitName("个");

        // 必填字段：使用部门
        equipDiscardedRecord.setUseDep(disposal.getField0019() != null ? disposal.getField0019() : "无");

        // 必填字段：设备单价
        BigDecimal equipPric = disposal.getField0015();
        equipDiscardedRecord.setEquipPric(equipPric != null ? equipPric : BigDecimal.ZERO);

        // 必填字段：采购日期
        String dateStr = disposal.getField0014();
        Date purcDate = null;

        if (dateStr != null && !dateStr.trim().isEmpty()) {
            // 去除首尾空格
            dateStr = dateStr.trim();
            // 如果是纯日期格式（长度为10，格式 yyyy-MM-dd），补充时间部分
            if (dateStr.length() == 10 && dateStr.contains("-")) {
                dateStr += " 00:00:00";
            }
            try {
                // 使用带时间的格式解析
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.parse(dateStr, formatter);
                purcDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
            } catch (DateTimeParseException e) {
                // 解析失败时使用当前时间
                purcDate = getCurrentTime();
            }
        } else {
            // 日期字符串为null或空时使用当前时间
            purcDate = getCurrentTime();
        }
        equipDiscardedRecord.setPurcDate(purcDate);

        // 必填字段：已用年限
        Integer usedLife = calculateUsedLife(purcDate);
        equipDiscardedRecord.setUsedLife(usedLife);

        // 必填字段：估计残值
        equipDiscardedRecord.setEstimaResidualValue(BigDecimal.ZERO);

        // 必填字段：报废原因
        equipDiscardedRecord.setDiscardedRea(disposal.getField0009() != null ? disposal.getField0009() : "无");

        // 可选字段：申请人姓名
        equipDiscardedRecord.setApplyerName("无");
        // 可选字段：申请日期 - 不设置，让 SQL 中的 NULL 处理

        // 可选字段：审核人姓名
        equipDiscardedRecord.setAuditOperatorName("无");

        // 必填字段：审核日期
        if (disposal.getStartDate() != null) {
            equipDiscardedRecord.setAuditDate(disposal.getStartDate());
        }
        // 如果 startDate 为 null，让 SQL 中的 CASE 语句处理（使用当前时间）

        // 必填字段：生产厂商代码
        equipDiscardedRecord.setManufacturerCode("无");

        // 必填字段：生产厂商名称
        String manufacturerName = getManufacturerName(disposal.getField0023());
        equipDiscardedRecord.setManufacturerName(manufacturerName);

        // 必填字段：修改标志
        equipDiscardedRecord.setState("0");

        // 可选字段：预留一
        equipDiscardedRecord.setReserve1("无");

        // 可选字段：预留二
        equipDiscardedRecord.setReserve2("无");

        // 必填字段：数据改造厂商名称
        equipDiscardedRecord.setDataClctPrdrName("福建众智政友科技有限公司");

        // 必填字段：数据创建时间 - 不设置，让 SQL 中的 SYSDATE 处理
        // 必填字段：数据更新时间 - 不设置，让 SQL 中的 SYSDATE 处理
        // 必填字段：数据删除状态
        equipDiscardedRecord.setDeleted("0");
        // 可选字段：数据删除时间 - 不设置，让 SQL 中的 NULL 处理

        return equipDiscardedRecord;
    }

    /**
     * 根据设备编号获取使用年限
     */
    private Integer getUsefulLife(String equipCode) {
        try {
            // 这里需要根据实际的 EquipCardInfo 实体类来调用
            // 暂时返回默认值，需要根据实际情况调整
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 计算已用年限
     */
    private Integer calculateUsedLife(Date purcDate) {
        try {
            if (purcDate == null) {
                return 0;
            }

            LocalDate purchaseDate = purcDate.toInstant()
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate currentDate = LocalDate.now();

            long years = ChronoUnit.YEARS.between(purchaseDate, currentDate);
            return (int) years;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 根据设备编号获取厂商名称
     */
    private String getManufacturerName(String equipCode) {
        try {
            // 这里需要根据实际的 EquipCardInfo 实体类来调用
            // 暂时返回默认值，需要根据实际情况调整
            return "无";
        } catch (Exception e) {
            return "无";
        }
    }

    /**
     * 获取当前时间
     */
    private Date getCurrentTime() {
        return new Date();
    }

    /**
     * 解析日期字符串
     */
    private Date parseDate(String dateStr) {
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
        } catch (Exception e) {
            return new Date();
        }
    }
}
