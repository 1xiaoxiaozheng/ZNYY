package com.springbootTz.ZNYY.Equipment.service;

import com.springbootTz.ZNYY.Equipment.dto.AssetRegistrationHouseWithDetailDTO;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.AssetRegistrationHouseQueryMapper;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.UnitInfoToolMapper;
import com.springbootTz.ZNYY.Equipment.mapper.znyy.EquipRegInfoMapper;
import com.springbootTz.ZNYY.Equipment.tool.ENUMTool;
import com.springbootTz.ZNYY.Equipment.entity.znyy.EquipRegInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

@Service
public class EquipRegInfoService_TD {
    @Autowired
    private UnitInfoToolMapper unitInfoToolMapper;

    @Autowired
    private ENUMTool enumTool;

    @Autowired
    private EquipRegInfoMapper equipRegInfoMapper;

    @Autowired
    private AssetRegistrationHouseQueryMapper assetRegistrationHouseQueryMapper;

    /**
     * znyy设备登记表equip_reg_info，seeyon设备登记表——房屋土地AssetRegistrationHouseWithDetailDTO
     * rid，uscid+FJZZZYKJYXGS+equipCode
     * orgName，unitInfoToolMapper.selectUnitNameById(field0005)
     * uscid，unitInfoToolMapper.selectUnitCodeByName(field0005)
     * uploadTime，默认当前时间
     * sysPrdrCode，FJZZZYKJYXGS
     * sysPrdrName，福建众智政友科技有限公司
     * equipCode，field0006
     * equipName，field0007
     * fixedAssetsType，field0010
     * fixedAssetsName，field0009
     * spec，"无"
     * equipModel，field0014
     * unit，"1"
     * unitName，"个"
     * disableFlag，"0"
     * manufacturerCode，"无"
     * manufacturerName，field0037
     * devUsefulLife，field0025
     * prodplacInfo，"无"
     * useCode，field0053
     * useName，enumTool.getEnumName(field0053)
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
     * 同步房屋土地登记数据从seeyon到znyy
     */
    public void syncEquipRegInfo() {
        // 获取所有房屋土地登记记录
        List<AssetRegistrationHouseWithDetailDTO> houseList = assetRegistrationHouseQueryMapper.selectAll();

        System.out.println("=== 房屋土地设备登记推送统计 ===");
        System.out.println("从 seeyon 查询到的房屋土地登记总数: " + houseList.size());

        if (houseList.isEmpty()) {
            System.out.println("警告: 没有查询到任何房屋土地登记记录！");
            return;
        }

        int insertCount = 0;
        int updateCount = 0;
        int skipCount = 0;
        int errorCount = 0;
        int deleteCount = 0;

        // 收集本次推送的所有RID
        Set<String> currentRids = new HashSet<>();

        for (AssetRegistrationHouseWithDetailDTO house : houseList) {
            try {
                // 获取单位信息
                String unitName = unitInfoToolMapper.selectUnitNameById(Long.parseLong(house.getField0005()));

                // 跳过"周宁总医院"的数据
                if (unitName != null && unitName.contains("周宁总医院")) {
                    skipCount++;
                    continue;
                }

                // 映射数据
                EquipRegInfo equipRegInfo = mapToEquipRegInfo(house);

                // 如果rid为null则跳过
                if (house.getField0001() == null) {
                    skipCount++;
                    continue;
                }

                // 添加到当前RID集合
                currentRids.add(equipRegInfo.getRid());

                // 检查是否已存在（包括已删除的记录）
                int exists = equipRegInfoMapper.checkEquipRegInfoExists(equipRegInfo.getRid());

                if (exists > 0) {
                    // 存在则更新（包括恢复已删除的记录）
                    equipRegInfo.setDeleted("0"); // 确保标记为未删除
                    equipRegInfoMapper.updateEquipRegInfo(equipRegInfo);
                    updateCount++;
                } else {
                    // 不存在则插入
                    equipRegInfoMapper.insertEquipRegInfo(equipRegInfo);
                    insertCount++;
                }
            } catch (Exception e) {
                System.out.println("处理房屋土地登记失败，单据编号: " + house.getField0001() + ", 错误: " + e.getMessage());
                errorCount++;
            }
        }

        // 处理删除逻辑：基于seeyon中state=0的已删除数据
        try {
            // 获取seeyon中已删除的房屋土地信息
            List<AssetRegistrationHouseQueryMapper.DeletedHouseInfo> deletedHouseInfoList = assetRegistrationHouseQueryMapper
                    .selectDeletedHouseInfo();

            if (!deletedHouseInfoList.isEmpty()) {
                // 生成被删除的RID
                List<String> deletedRids = new ArrayList<>();
                for (AssetRegistrationHouseQueryMapper.DeletedHouseInfo deletedInfo : deletedHouseInfoList) {
                    if (deletedInfo.getField0006() != null && !deletedInfo.getField0006().trim().isEmpty()) {
                        // 获取单位代码（就像正常数据处理一样）
                        String unitCode = String
                                .valueOf(unitInfoToolMapper.selectUnitCodeByName(deletedInfo.getField0005()));
                        String deletedRid = unitCode + "FJZZZYKJYXGS" + deletedInfo.getField0006();
                        deletedRids.add(deletedRid);
                    }
                }

                if (!deletedRids.isEmpty()) {
                    String ridsToDelete = String.join("','", deletedRids);
                    deleteCount = equipRegInfoMapper.batchMarkAsDeleted("'" + ridsToDelete + "'");
                    System.out.println("基于seeyon删除状态标记删除的房屋土地RID数量: " + deleteCount);
                    System.out.println("被删除的房屋土地RID: " + deletedRids);
                }
            }
        } catch (Exception e) {
            System.out.println("处理删除逻辑时发生错误: " + e.getMessage());
        }

        System.out.println("=== 房屋土地设备登记推送完成统计 ===");
        System.out.println("新增: " + insertCount + " 条");
        System.out.println("更新: " + updateCount + " 条");
        System.out.println("删除: " + deleteCount + " 条");
        System.out.println("跳过: " + skipCount + " 条");
        System.out.println("错误: " + errorCount + " 条");
        System.out.println("总计处理: " + (insertCount + updateCount + deleteCount + skipCount + errorCount) + " 条");
    }

    /**
     * 将AssetRegistrationHouseWithDetailDTO映射为EquipRegInfo
     */
    private EquipRegInfo mapToEquipRegInfo(AssetRegistrationHouseWithDetailDTO house) {
        EquipRegInfo equipRegInfo = new EquipRegInfo();

        // 获取单位信息
        String unitCode = String.valueOf(unitInfoToolMapper.selectUnitCodeByName(Long.parseLong(house.getField0005())));
        String unitName = unitInfoToolMapper.selectUnitNameById(Long.parseLong(house.getField0005()));

        // 生成RID: uscid+FJZZZYKJYXGS+equipCode
        String rid = unitCode + "FJZZZYKJYXGS" + house.getField0006();

        // 设置基本信息
        equipRegInfo.setRid(rid);
        equipRegInfo.setOrgName(unitName);
        equipRegInfo.setUscid(unitCode);
        equipRegInfo.setUploadTime(getCurrentTime());
        equipRegInfo.setSysPrdrCode("FJZZZYKJYXGS");
        equipRegInfo.setSysPrdrName("福建众智政友科技有限公司");
        equipRegInfo.setEquipCode(house.getField0006());
        equipRegInfo.setEquipName(house.getField0007());
        equipRegInfo.setFixedAssetsType(house.getField0010() != null ? house.getField0010() : "");
        equipRegInfo.setFixedAssetsName(house.getField0009() != null ? house.getField0009() : "");
        equipRegInfo.setSpec("无");
        equipRegInfo.setEquipModel(house.getField0014() != null ? house.getField0014() : "无");
        equipRegInfo.setUnit("1");
        equipRegInfo.setUnitName("个");
        equipRegInfo.setDisableFlag("0");
        equipRegInfo.setManufacturerCode("无");
        equipRegInfo.setManufacturerName(house.getField0037() != null ? house.getField0037() : "无");

        // 处理设备使用年限，如果为null则设置为null
        BigDecimal devUsefulLife = house.getField0025();
        if (devUsefulLife != null) {
            // 将年限转换为日期（假设从当前日期开始计算）
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusYears(devUsefulLife.longValue());
            Date usefulLifeDate = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            equipRegInfo.setDevUsefulLife(usefulLifeDate);
        } else {
            // 设置为null，让SQL处理
            // equipRegInfo.setDevUsefulLife(null);
        }

        equipRegInfo.setProdplacInfo("无");

        // 处理用途代码和名称
        BigDecimal useCode = house.getField0053();
        if (useCode != null) {
            equipRegInfo.setUseCode(useCode.toString());
            // 通过枚举工具获取用途名称
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

        // 不设置时间字段，让SQL处理
        // equipRegInfo.setCrteTime(null);
        // equipRegInfo.setUpdtTime(null);
        equipRegInfo.setDeleted("0");
        // equipRegInfo.setDeletedTime(null);

        return equipRegInfo;
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
