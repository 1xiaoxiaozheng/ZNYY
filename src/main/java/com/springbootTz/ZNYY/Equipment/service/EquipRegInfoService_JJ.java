package com.springbootTz.ZNYY.Equipment.service;

import com.springbootTz.ZNYY.Equipment.dto.AssetRegistrationHomeWithDetailDTO;
import com.springbootTz.ZNYY.Equipment.entity.znyy.EquipRegInfo;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.AssetRegistrationHomeQueryMapper;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.UnitInfoToolMapper;
import com.springbootTz.ZNYY.Equipment.mapper.znyy.EquipRegInfoMapper;
import com.springbootTz.ZNYY.Equipment.tool.ENUMTool;
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
public class EquipRegInfoService_JJ {
    @Autowired
    private UnitInfoToolMapper unitInfoToolMapper;

    @Autowired
    private ENUMTool enumTool;

    @Autowired
    private AssetRegistrationHomeQueryMapper assetRegistrationHomeQueryMapper;

    @Autowired
    private EquipRegInfoMapper equipRegInfoMapper;

    /**
     * znyy设备登记表equip_reg_info，seeyon设备登记表——家居设备登记表AssetRegistrationHomeWithDetailDTO
     * rid，uscid+FJZZZYKJYXGS+equipCode
     * uploadTime，默认当前时间
     * orgName，unitInfoToolMapper.selectUnitNameById(field0152)
     * uscid，unitInfoToolMapper.selectUnitCodeByName(field0152)
     * sysPrdrCode，FJZZZYKJYXGS
     * sysPrdrName，福建众智政友科技有限公司
     * equipCode，field0001
     * equipName，field0002
     * fixedAssetsType，field0133
     * fixedAssetsName，field0126
     * spec，“无”
     * equipModel，field0006
     * unit，“1“
     * unitName，”个“
     * disableFlag，“0”
     * manufacturerCode，”无“
     * manufacturerName，field0161
     * devUsefulLife，field0156
     * prodplacInfo，“无“
     * useCode，field0171
     * useName，enumTool.getEnumName(field0171)
     * state，“0”
     * reserve1，“无“
     * reserve2，“无“
     * dataClctPrdrName，福建众智政友科技有限公司
     * crteTime，startDate
     * updtTime，startDate
     * deleted，“0”
     * deletedTime，使用默认时间2025-08-18 00:00:00
     */

    /**
     * 同步家居设备登记数据从seeyon到ZNYY
     *
     */
    public void syncEquipRegInfoFromSeeyonToZNYY() {
        // 获取所有家具设备登记表
        List<AssetRegistrationHomeWithDetailDTO> HomeList = assetRegistrationHomeQueryMapper.selectAll();

        System.out.println("=== 家具设备登记推送统计 ===");
        System.out.println("家居设备登记表总数：" + HomeList.size());

        if (HomeList.isEmpty()) {
            System.out.println("警告:没有查询到任何家具设备登记记录！");
            return;
        }

        int insertCount = 0;
        int updateCount = 0;
        int skipCount = 0;
        int errorCount = 0;
        int deleteCount = 0;

        // 收集本次推送的所有RID
        Set<String> currentRids = new HashSet<>();

        for (AssetRegistrationHomeWithDetailDTO Home : HomeList) {
            try {
                // 获取单位信息
                String unitName = unitInfoToolMapper.selectUnitNameById(Long.parseLong(Home.getField0152()));

                // 跳过”周宁县总医院“的数据，修复空指针判断顺序
                if (unitName != null && unitName.equals("周宁县总医院")) {
                    // System.out.println("跳过周宁县总医院数据，单据编号：" + Home.getField0017() + "单位：" +
                    // unitName);
                    skipCount++;
                    continue;
                }

                // 映射数据
                EquipRegInfo equipRegInfo = mapToEquipRegInfo(Home);

                // 如果rid为null则跳过
                if (Home.getField0017() == null) {
                    // System.out.println("跳过单据编号为空: " + Home.getField0017());
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
                System.out.println("处理家具设备登记失败，单据编号：" + Home.getField0017() + " 异常信息：" + e.getMessage());
                errorCount++;
            }
        }

        // 处理删除逻辑
        try {
            List<String> existingRids = equipRegInfoMapper.selectActiveRidsBySysPrdrCode("FJZZZYKJYXGS");
            Set<String> existingRidSet = new HashSet<>(existingRids);

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

        System.out.println("=== 家具设备登记推送结果 ===");
        System.out.println("新增：" + insertCount);
        System.out.println("更新：" + updateCount);
        System.out.println("删除：" + deleteCount);
        System.out.println("跳过：" + skipCount);
        System.out.println("错误：" + errorCount);
        System.out.println("总计处理：" + (insertCount + updateCount + deleteCount + skipCount + errorCount) + "条");
    }

    /**
     * 将AssetRegistrationHomeWithDetailDTO映射为EquipRegInfo
     */
    private EquipRegInfo mapToEquipRegInfo(AssetRegistrationHomeWithDetailDTO Home) {
        EquipRegInfo equipRegInfo = new EquipRegInfo();

        // 获取单位信息
        String unitCode = String.valueOf(unitInfoToolMapper.selectUnitCodeByName(Long.parseLong(Home.getField0152())));
        String unitName = unitInfoToolMapper.selectUnitCodeByName(Long.parseLong(Home.getField0152()));

        // 生成RID：uscid+FJZZZYKJYXGS+equipCode
        String rid = unitCode + "FJZZZYKJYXGS" + Home.getField0001();

        // 设置基本信息
        equipRegInfo.setRid(rid);
        equipRegInfo.setUploadTime(getCurrentTime());
        equipRegInfo.setOrgName(unitName);
        equipRegInfo.setUscid(unitCode);
        equipRegInfo.setUpdtTime(getCurrentTime());
        equipRegInfo.setSysPrdrCode("FJZZZYKJYXGS");
        equipRegInfo.setSysPrdrName("福建众智政友科技有限公司");
        equipRegInfo.setEquipCode(Home.getField0001());
        equipRegInfo.setEquipName(Home.getField0002());
        equipRegInfo.setFixedAssetsType(Home.getField0133());
        equipRegInfo.setFixedAssetsName(Home.getField0126());
        equipRegInfo.setSpec("无");
        equipRegInfo.setEquipModel(Home.getField0006());
        equipRegInfo.setUnit("1");
        equipRegInfo.setUnitName("个");
        equipRegInfo.setDisableFlag("0");
        equipRegInfo.setManufacturerCode("无");
        equipRegInfo.setManufacturerName(Home.getField0161());

        // 处理设备使用年限，如果为null则使用默认值
        BigDecimal devUsefulLife = Home.getField0156();
        if (devUsefulLife != null) {
            // 将年限转为日期（假设当前日期开始计算）
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusYears(devUsefulLife.longValue());
            Date usefulLifeDate = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            equipRegInfo.setDevUsefulLife(usefulLifeDate);
        } else {
            // 使用默认日期
            equipRegInfo.setDevUsefulLife(parseDate("2025-08-18 00:00:00"));
        }

        equipRegInfo.setProdplacInfo("无");
        // 处理用途代码和名称
        BigDecimal useCode = Home.getField0171();
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
        equipRegInfo.setCrteTime(parseDate("2025-08-18 00:00:00"));
        equipRegInfo.setUpdtTime(Home.getStartDate() != null ? Home.getStartDate() : getCurrentTime());
        equipRegInfo.setDeleted("0");
        equipRegInfo.setDeletedTime(parseDate("2025-08-18 00:00:00"));

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
