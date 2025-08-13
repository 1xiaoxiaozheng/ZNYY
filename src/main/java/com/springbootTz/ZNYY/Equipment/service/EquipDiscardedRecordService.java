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
     * sysPrdrCode,FJZZZYKJGS
     * sysPrdrName,福建众智政友有限公司
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
     * dataClctPrdrName,福建众智政友有限公司
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

        System.out.println("=== 报废记录推送完成统计 ===");
        System.out.println("新增: " + insertCount + " 条");
        System.out.println("更新: " + updateCount + " 条");
        System.out.println("跳过: " + skipCount + " 条");
        System.out.println("错误: " + errorCount + " 条");
        System.out.println("总计处理: " + (insertCount + updateCount + skipCount + errorCount) + " 条");
    }

    /**
     * 将AssetDisposalWithDetailDTO映射为EquipDiscardedRecord
     */
    private EquipDiscardedRecord mapToEquipDiscardedRecord(AssetDisposalWithDetailDTO disposal) {
        EquipDiscardedRecord equipDiscardedRecord = new EquipDiscardedRecord();

        // 获取单位信息
        String unitCode = String.valueOf(unitInfoToolMapper.selectUnitCodeByName(Long.parseLong(disposal.getField0034())));
        String unitName = unitInfoToolMapper.selectUnitNameById(Long.parseLong((disposal.getField0034())));

        // 生成RID: uscid+FJZZZYKJGS+discarded_no
        String rid = unitCode + "FJZZZYKJGS" + disposal.getField0001();

        // 设置基本信息
        equipDiscardedRecord.setRid(rid);
        equipDiscardedRecord.setOrgName(unitName);
        equipDiscardedRecord.setUscid(unitCode);
        equipDiscardedRecord.setUploadTime(getCurrentTime());
        equipDiscardedRecord.setSysPrdrCode("FJZZZYKJGS");
        equipDiscardedRecord.setSysPrdrName("福建众智政友有限公司");
        equipDiscardedRecord.setDiscardedNo(disposal.getField0001());
        equipDiscardedRecord.setEquipCode(disposal.getField0023());
        equipDiscardedRecord.setEquipName(disposal.getField0006());

        // 获取规格
        equipDiscardedRecord.setSpec("无");

        equipDiscardedRecord.setEquipModel(disposal.getField0013() != null ? disposal.getField0013() : "无");
        equipDiscardedRecord.setUnit("1");
        equipDiscardedRecord.setUnitName("个");
        equipDiscardedRecord.setUseDep(disposal.getField0019() != null ? disposal.getField0019() : "无");

        // 处理设备价格，如果为null则使用0
        BigDecimal equipPric = disposal.getField0015();
        equipDiscardedRecord.setEquipPric(equipPric != null ? equipPric : BigDecimal.ZERO);

        // 处理购买日期，如果为null则使用默认时间
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
                // 解析失败时使用默认日期
                purcDate = parseDate("1900-01-01 00:00:00");
            }
        } else {
            // 日期字符串为null或空时使用默认日期
            purcDate = parseDate("1900-01-01 00:00:00");
        }
        equipDiscardedRecord.setPurcDate(purcDate);

        // 计算已用年限
        Integer usedLife = calculateUsedLife(purcDate);
        equipDiscardedRecord.setUsedLife(usedLife);

        // 设置其他字段
        equipDiscardedRecord.setEstimaResidualValue(BigDecimal.ZERO);
        equipDiscardedRecord.setDiscardedRea(disposal.getField0009() != null ? disposal.getField0009() : "");
        equipDiscardedRecord.setApplyerName("无");
        equipDiscardedRecord.setApplyDate(getCurrentTime()); // 使用当前时间
        equipDiscardedRecord.setAuditOperatorName("无");
        equipDiscardedRecord.setAuditDate(disposal.getStartDate() != null ? disposal.getStartDate() : getCurrentTime());
        equipDiscardedRecord.setManufacturerCode("无");

        // 获取厂商名称
        String manufacturerName = getManufacturerName(disposal.getField0023());
        equipDiscardedRecord.setManufacturerName(manufacturerName);

        equipDiscardedRecord.setState("0");
        equipDiscardedRecord.setReserve1("无");
        equipDiscardedRecord.setReserve2("无");
        equipDiscardedRecord.setDataClctPrdrName("福建众智政友有限公司");
        equipDiscardedRecord.setCrteTime(disposal.getStartDate() != null ? disposal.getStartDate() : getCurrentTime());
        equipDiscardedRecord.setUpdtTime(disposal.getStartDate() != null ? disposal.getStartDate() : getCurrentTime());
        equipDiscardedRecord.setDeleted("0");
        equipDiscardedRecord.setDeletedTime(parseDate("1900-01-01 00:00:00"));

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
