package com.springbootTz.ZNYY.Equipment.service;

import com.springbootTz.ZNYY.Equipment.mapper.seeyon.UnitInfoToolMapper;
import com.springbootTz.ZNYY.Equipment.tool.ENUMTool;
import com.springbootTz.ZNYY.Equipment.entity.znyy.EquipRegInfo;
import com.springbootTz.ZNYY.Equipment.mapper.znyy.EquipRegInfoMapper;
import com.springbootTz.ZNYY.Equipment.dto.AssetRegistrationWithDetailDTO;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.AssetRegistrationQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

@Service
public class EquipRegInfoService_WX {

    @Autowired
    private UnitInfoToolMapper unitInfoToolMapper;

    @Autowired
    private ENUMTool enumTool;

    @Autowired
    private EquipRegInfoMapper equipRegInfoMapper;

    @Autowired
    private AssetRegistrationQueryMapper assetRegistrationQueryMapper;

    /**
     * znyy设备登记信息表equip_reg_info，seeyon设备登记——无形资产formmain_1199与formson_1200关联的表AssetRegistrationWithDetailDTO
     * rid，uscid+FJZZZYKJYXGS+equipCode
     * orgName，unitInfoToolMapper.selectUnitNameById(field0152)
     * uscid，unitInfoToolMapper.selectUnitCodeByName(field0152)
     * uploadTime，当前时间
     * sysPrdrCode，FJZZZYKJYXGS
     * sysPrdrName，福建众智政友科技有限公司
     * equipCode，field0001
     * equipName，field0002
     * fixedAssetsType，field0133
     * fixedAssetsName，field0126
     * spec，"无"
     * equipModel，field0006
     * unit，"1"
     * unitName，"个"
     * disableFlag，"0"
     * manufacturerCode，"无"
     * manufacturerName，field0161
     * devUsefulLife，field0156
     * prodplacInfo，"无"
     * useCode，field0171
     * useName，enumTool.getEnumName(field0171)
     * state，"0"
     * reserve1，"无"
     * reserve2，"无"
     * dataClctPrdrName，福建众智政友科技有限公司
     * crteTime，startDate
     * updtTime，startDate
     * deleted，"0"
     * deletedTime，使用默认时间2025-08-18 00:00:00
     */

    /**
     * 同步无形资产登记数据从seeyon到ZNYY
     */
    public void syncEquipRegInfo() {
        // 获取所有无形资产登记记录
        List<AssetRegistrationWithDetailDTO> list = assetRegistrationQueryMapper.selectAll();

        System.out.println("=== 无形资产登记推送统计 ===");
        System.out.println("从 seeyon 查询到的无形资产登记总数: " + list.size());

        if (list.isEmpty()) {
            System.out.println("警告: 没有查询到任何无形资产登记记录！");
            return;
        }

        int insertCount = 0;
        int updateCount = 0;
        int skipCount = 0;
        int errorCount = 0;
        int deleteCount = 0;

        // 收集本次推送的所有RID
        Set<String> currentRids = new HashSet<>();

        for (AssetRegistrationWithDetailDTO dto : list) {
            try {
                // 获取单位信息（主表 field0152）
                String unitName = unitInfoToolMapper.selectUnitNameById(Long.parseLong(dto.getField0152()));

                // 跳过"周宁总医院"的数据
                if (unitName != null && unitName.contains("周宁总医院")) {
                    System.out.println("跳过周宁总医院数据，单据编号: " + dto.getField0017() + ", 单位: " + unitName);
                    skipCount++;
                    continue;
                }

                // 映射数据
                EquipRegInfo equipRegInfo = mapToEquipRegInfo(dto);

                // 若rid为null则跳过当前记录
                if (dto.getField0017() == null) {
                    System.out.println("跳过单据编号为空: " + dto.getField0017());
                    skipCount++;
                    continue;
                }

                // 添加到当前RID集合
                currentRids.add(equipRegInfo.getRid());

                // 检查是否已存在
                int exists = equipRegInfoMapper.checkEquipRegInfoExists(equipRegInfo.getRid());

                if (exists > 0) {
                    // 存在则更新
                    equipRegInfoMapper.updateEquipRegInfo(equipRegInfo);
                    updateCount++;
                } else {
                    // 不存在则插入
                    equipRegInfoMapper.insertEquipRegInfo(equipRegInfo);
                    insertCount++;
                }
            } catch (Exception e) {
                System.out.println("处理无形资产登记失败，单据编号: " + dto.getField0017() + ", 错误: " + e.getMessage());
                errorCount++;
            }
        }

        // 处理删除逻辑：标记目标库中存在但源库中不存在的记录为已删除
        try {
            // 查询目标库中所有未删除的RID
            List<String> existingRids = equipRegInfoMapper.selectActiveRidsBySysPrdrCode("FJZZZYKJYXGS");
            Set<String> existingRidSet = new HashSet<>(existingRids);

            // 找出需要删除的RID（目标库有但源库没有的）
            Set<String> toDeleteRids = new HashSet<>(existingRidSet);
            toDeleteRids.removeAll(currentRids);

            if (!toDeleteRids.isEmpty()) {
                String ridsToDelete = String.join("','", toDeleteRids);
                deleteCount = equipRegInfoMapper.batchMarkAsDeleted("'" + ridsToDelete + "'");
                System.out.println("标记删除的RID数量: " + deleteCount);
                System.out.println("被删除的RID: " + toDeleteRids);
            }
        } catch (Exception e) {
            System.out.println("处理删除逻辑时发生错误: " + e.getMessage());
        }

        System.out.println("=== 无形资产登记推送完成统计 ===");
        System.out.println("新增: " + insertCount + " 条");
        System.out.println("更新: " + updateCount + " 条");
        System.out.println("删除: " + deleteCount + " 条");
        System.out.println("跳过: " + skipCount + " 条");
        System.out.println("错误: " + errorCount + " 条");
        System.out.println("总计处理: " + (insertCount + updateCount + deleteCount + skipCount + errorCount) + " 条");
    }

    /**
     * 将AssetRegistrationWithDetailDTO映射为EquipRegInfo
     */
    private EquipRegInfo mapToEquipRegInfo(AssetRegistrationWithDetailDTO dto) {
        EquipRegInfo equipRegInfo = new EquipRegInfo();

        // 获取单位信息（主表 field0152）
        String unitCode = String.valueOf(unitInfoToolMapper.selectUnitCodeByName(Long.parseLong(dto.getField0152())));
        String unitName = unitInfoToolMapper.selectUnitNameById(Long.parseLong(dto.getField0152()));

        // 生成RID: uscid+FJZZZYKJYXGS+equipCode（明细 field0001）
        String rid = unitCode + "FJZZZYKJYXGS" + dto.getField0001();

        // 设置基本信息
        equipRegInfo.setRid(rid);
        equipRegInfo.setOrgName(unitName);
        equipRegInfo.setUscid(unitCode);
        equipRegInfo.setUploadTime(getCurrentTime());
        equipRegInfo.setSysPrdrCode("FJZZZYKJYXGS");
        equipRegInfo.setSysPrdrName("福建众智政友科技有限公司");
        equipRegInfo.setEquipCode(dto.getField0001());
        equipRegInfo.setEquipName(dto.getField0002());
        equipRegInfo.setFixedAssetsType(dto.getField0133());
        equipRegInfo.setFixedAssetsName(dto.getField0126());
        equipRegInfo.setSpec("无");
        equipRegInfo.setEquipModel(dto.getField0006() != null ? dto.getField0006() : "无");
        equipRegInfo.setUnit("1");
        equipRegInfo.setUnitName("个");
        equipRegInfo.setDisableFlag("0");
        equipRegInfo.setManufacturerCode("无");
        equipRegInfo.setManufacturerName(dto.getField0161() != null ? dto.getField0161() : "无");

        // 处理设备使用年限（主表/明细：field0156 年）
        BigDecimal devUsefulLife = dto.getField0156();
        if (devUsefulLife != null) {
            LocalDate start = LocalDate.now();
            LocalDate end = start.plusYears(devUsefulLife.longValue());
            Date usefulLifeDate = Date.from(end.atStartOfDay(ZoneId.systemDefault()).toInstant());
            equipRegInfo.setDevUsefulLife(usefulLifeDate);
        } else {
            equipRegInfo.setDevUsefulLife(parseDate("2025-08-18 00:00:00"));
        }

        equipRegInfo.setProdplacInfo("无");

        // 用途代码与名称（明细 field0171）
        BigDecimal useCode = dto.getField0171();
        if (useCode != null) {
            equipRegInfo.setUseCode(useCode.toString());
            String useName = enumTool.getEnumName(useCode);
            equipRegInfo.setUseName(useName != null ? useName : "无");
        } else {
            equipRegInfo.setUseCode("无");
            equipRegInfo.setUseName("无");
        }

        equipRegInfo.setState("0");
        equipRegInfo.setReserve1("无");
        equipRegInfo.setReserve2("无");
        equipRegInfo.setDataClctPrdrName("福建众智政友科技有限公司");
        equipRegInfo.setCrteTime(parseDate("2025-08-18 00:00:00"));
        equipRegInfo.setUpdtTime(dto.getStartDate() != null ? dto.getStartDate() : getCurrentTime());
        equipRegInfo.setDeleted("0");
        equipRegInfo.setDeletedTime(parseDate("2025-08-18 00:00:00"));

        return equipRegInfo;
    }

    private Date getCurrentTime() {
        return new Date();
    }

    private Date parseDate(String dateStr) {
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
        } catch (Exception e) {
            return new Date();
        }
    }
}
