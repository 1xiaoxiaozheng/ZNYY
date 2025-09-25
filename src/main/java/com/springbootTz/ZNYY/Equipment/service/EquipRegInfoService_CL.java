package com.springbootTz.ZNYY.Equipment.service;

import com.springbootTz.ZNYY.Equipment.mapper.seeyon.UnitInfoToolMapper;
import com.springbootTz.ZNYY.Equipment.tool.ENUMTool;
import com.springbootTz.ZNYY.Equipment.entity.znyy.EquipRegInfo;
import com.springbootTz.ZNYY.Equipment.mapper.znyy.EquipRegInfoMapper;
import com.springbootTz.ZNYY.Equipment.dto.AssetRegistrationVehicleWithDetailDTO;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.AssetRegistrationVehicleQueryMapper;
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
public class EquipRegInfoService_CL {
    @Autowired
    private UnitInfoToolMapper unitInfoToolMapper;

    @Autowired
    private ENUMTool enumTool;

    @Autowired
    private EquipRegInfoMapper equipRegInfoMapper;

    @Autowired
    private AssetRegistrationVehicleQueryMapper assetRegistrationVehicleQueryMapper;

    /**
     * 映射关系
     * equip_reg_info表，formmain_1195和formson_1196的关联表AssetRegistrationVehicleWithDetailDTO
     * rid，uscid+FJZZZYKJYXGS+equipCode
     * orgName，unitInfoToolMapper.selectUnitNameById(field0005)
     * uscid，unitInfoToolMapper.selectUnitCodeByName(field0005)
     * uploadTime，当前时间
     * sysPrdrCode，FJZZZYKJYXGS
     * sysPrdrName，福建众智政友科技有限公司
     * equipCode，field0006
     * equipName，field0007
     * fixedAssetsType，field0010
     * fixedAssetsName，field0009
     * spec，"无"
     * equipModel，field0014
     * unit，"1"
     * unitName,"个"
     * disableFlag,"0"
     * manufacturerCode,"无"
     * manufacturerName,field0037
     * devUsefulLife,field0025
     * prodplacInfo，"无"
     * useCode，field0059
     * useName，enumTool.getEnumName(field0059)
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
     * 同步车辆设备登记数据从seeyon到ZNYY
     */
    public void syncEquipRegInfo() {
        // 获取所有车辆登记记录
        List<AssetRegistrationVehicleWithDetailDTO> vehicleList = assetRegistrationVehicleQueryMapper.selectAll();

        System.out.println("=== 车辆设备登记推送统计 ===");
        System.out.println("从 seeyon 查询到的车辆登记总数: " + vehicleList.size());

        if (vehicleList.isEmpty()) {
            System.out.println("警告: 没有查询到任何车辆登记记录！");
            return;
        }

        int insertCount = 0;
        int updateCount = 0;
        int skipCount = 0;
        int errorCount = 0;

        for (AssetRegistrationVehicleWithDetailDTO vehicle : vehicleList) {
            try {
                // 获取单位信息
                String unitName = unitInfoToolMapper.selectUnitNameById(Long.parseLong(vehicle.getField0005()));

                // 跳过"周宁总医院"的数据
                if (unitName != null && unitName.contains("周宁总医院")) {
//                    System.out.println("跳过周宁总医院数据，单据编号: " + vehicle.getField0001() + ", 单位: " + unitName);
                    skipCount++;
                    continue;
                }

                // 映射数据
                EquipRegInfo equipRegInfo = mapToEquipRegInfo(vehicle);

                // 如果rid为null则跳过
                if (vehicle.getField0001() == null) {
//                    System.out.println("跳过单据编号为空的内容: " + vehicle.getField0001());
                    skipCount++;
                    continue;
                }

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
                System.out.println("处理车辆登记失败，单据编号: " + vehicle.getField0001() + ", 错误: " + e.getMessage());
                errorCount++;
            }
        }

        System.out.println("=== 车辆设备登记推送完成统计 ===");
        System.out.println("新增: " + insertCount + " 条");
        System.out.println("更新: " + updateCount + " 条");
        System.out.println("跳过: " + skipCount + " 条");
        System.out.println("错误: " + errorCount + " 条");
        System.out.println("总计处理: " + (insertCount + updateCount + skipCount + errorCount) + " 条");
    }
    /**
     * 将AssetRegistrationVehicleWithDetailDTO映射为EquipRegInfo
     */
    private EquipRegInfo mapToEquipRegInfo(AssetRegistrationVehicleWithDetailDTO vehicle) {
        EquipRegInfo equipRegInfo = new EquipRegInfo();

        // 获取单位信息
        String unitCode = String
                .valueOf(unitInfoToolMapper.selectUnitCodeByName(Long.parseLong(vehicle.getField0005())));
        String unitName = unitInfoToolMapper.selectUnitNameById(Long.parseLong(vehicle.getField0005()));

        // 生成RID: uscid+FJZZZYKJYXGS+equipCode
        String rid = unitCode + "FJZZZYKJYXGS" + vehicle.getField0006();

        // 设置基本信息
        equipRegInfo.setRid(rid);
        equipRegInfo.setOrgName(unitName);
        equipRegInfo.setUscid(unitCode);
        equipRegInfo.setUploadTime(getCurrentTime());
        equipRegInfo.setSysPrdrCode("FJZZZYKJYXGS");
        equipRegInfo.setSysPrdrName("福建众智政友科技有限公司");
        equipRegInfo.setEquipCode(vehicle.getField0006());
        equipRegInfo.setEquipName(vehicle.getField0007());
        equipRegInfo.setFixedAssetsType(vehicle.getField0010() != null ? vehicle.getField0010() : "");
        equipRegInfo.setFixedAssetsName(vehicle.getField0009() != null ? vehicle.getField0009() : "");
        equipRegInfo.setSpec("无");
        equipRegInfo.setEquipModel(vehicle.getField0014() != null ? vehicle.getField0014() : "无");
        equipRegInfo.setUnit("1");
        equipRegInfo.setUnitName("个");
        equipRegInfo.setDisableFlag("0");
        equipRegInfo.setManufacturerCode("无");
        equipRegInfo.setManufacturerName(vehicle.getField0037() != null ? vehicle.getField0037() : "无");

        // 处理设备使用年限，如果为null则使用默认值
        BigDecimal devUsefulLife = vehicle.getField0025();
        if (devUsefulLife != null) {
            // 将年限转换为日期（假设从当前日期开始计算）
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
        BigDecimal useCode = vehicle.getField0059();
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
        equipRegInfo.setUpdtTime(vehicle.getStartDate() != null ? vehicle.getStartDate() : getCurrentTime());
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
