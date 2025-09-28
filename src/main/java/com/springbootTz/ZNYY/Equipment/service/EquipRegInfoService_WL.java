package com.springbootTz.ZNYY.Equipment.service;

import com.springbootTz.ZNYY.Equipment.mapper.seeyon.UnitInfoToolMapper;
import com.springbootTz.ZNYY.Equipment.tool.ENUMTool;
import com.springbootTz.ZNYY.Equipment.entity.znyy.EquipRegInfo;
import com.springbootTz.ZNYY.Equipment.mapper.znyy.EquipRegInfoMapper;
import com.springbootTz.ZNYY.Equipment.dto.AssetRegistrationNetworkWithDetailDTO;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.AssetRegistrationNetworkQueryMapper;
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
public class EquipRegInfoService_WL {
    @Autowired
    private UnitInfoToolMapper unitInfoToolMapper;

    @Autowired
    private ENUMTool enumTool;

    @Autowired
    private EquipRegInfoMapper equipRegInfoMapper;

    @Autowired
    private AssetRegistrationNetworkQueryMapper assetRegistrationNetworkQueryMapper;

    /**
     * znyy设备登记表equip_reg_info，seeyon设备登记表———网络信息设备AssetRegistrationNetworkWithDetailDTO
     * rid，uscid+FJZZZYKJYXGS+equipCode
     * orgName，unitInfoToolMapper.selectUnitNameById(field0006)
     * uscid，unitInfoToolMapper.selectUnitCodeByName(field0006)
     * uploadTime，当前时间
     * sysPrdrCode，FJZZZYKJYXGS
     * sysPrdrName，福建众智政友科技有限公司
     * equipCode，field0007
     * equipName，field0008
     * fixedAssetsType，field0011
     * fixedAssetsName，field0010
     * spec，"无"
     * equipModel，field0015
     * unit，"1"
     * unitName，"个"
     * disableFlag，"0"
     * manufacturerCode，"无"
     * manufacturerName，field0043
     * devUsefulLife，field0031
     * prodplacInfo，"无"
     * useCode，field0026
     * useName，enumTool.getEnumName(field0026)
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
     * 同步网络信息设备登记数据从seeyon到znyy
     */
    public void syncEquipRegInfo() {
        // 获取所有网络信息设备登记记录
        List<AssetRegistrationNetworkWithDetailDTO> networkList = assetRegistrationNetworkQueryMapper.selectAll();

        System.out.println("=== 网络信息设备登记推送统计 ===");
        System.out.println("从 seeyon 查询到的网络信息设备登记总数: " + networkList.size());

        if (networkList.isEmpty()) {
            System.out.println("警告: 没有查询到任何网络信息设备登记记录！");
            return;
        }

        int insertCount = 0;
        int updateCount = 0;
        int skipCount = 0;
        int errorCount = 0;
        int deleteCount = 0;

        // 收集本次推送的所有RID
        Set<String> currentRids = new HashSet<>();

        for (AssetRegistrationNetworkWithDetailDTO network : networkList) {
            try {
                // 获取单位信息
                String unitName = unitInfoToolMapper.selectUnitNameById(Long.parseLong(network.getField0006()));

                // 跳过"周宁总医院"的数据
                if (unitName != null && unitName.contains("周宁总医院")) {
                    skipCount++;
                    continue;
                }

                // 映射数据
                EquipRegInfo equipRegInfo = mapToEquipRegInfo(network);

                // 如果rid为null则跳过
                if (network.getField0001() == null) {
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
                System.out.println("处理网络信息设备登记失败，单据编号: " + network.getField0001() + ", 错误: " + e.getMessage());
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

        System.out.println("=== 网络信息设备登记推送完成统计 ===");
        System.out.println("新增: " + insertCount + " 条");
        System.out.println("更新: " + updateCount + " 条");
        System.out.println("删除: " + deleteCount + " 条");
        System.out.println("跳过: " + skipCount + " 条");
        System.out.println("错误: " + errorCount + " 条");
        System.out.println("总计处理: " + (insertCount + updateCount + deleteCount + skipCount + errorCount) + " 条");
    }

    /**
     * 将AssetRegistrationNetworkWithDetailDTO映射为EquipRegInfo
     */
    private EquipRegInfo mapToEquipRegInfo(AssetRegistrationNetworkWithDetailDTO network) {
        EquipRegInfo equipRegInfo = new EquipRegInfo();

        // 获取单位信息
        String unitCode = String
                .valueOf(unitInfoToolMapper.selectUnitCodeByName(Long.parseLong(network.getField0006())));
        String unitName = unitInfoToolMapper.selectUnitNameById(Long.parseLong(network.getField0006()));

        // 生成RID: uscid+FJZZZYKJYXGS+equipCode
        String rid = unitCode + "FJZZZYKJYXGS" + network.getField0007();

        // 设置基本信息
        equipRegInfo.setRid(rid);
        equipRegInfo.setOrgName(unitName);
        equipRegInfo.setUscid(unitCode);
        equipRegInfo.setUploadTime(getCurrentTime());
        equipRegInfo.setSysPrdrCode("FJZZZYKJYXGS");
        equipRegInfo.setSysPrdrName("福建众智政友科技有限公司");
        equipRegInfo.setEquipCode(network.getField0007());
        equipRegInfo.setEquipName(network.getField0008());
        equipRegInfo.setFixedAssetsType(network.getField0011() != null ? network.getField0011() : "");
        equipRegInfo.setFixedAssetsName(network.getField0010() != null ? network.getField0010() : "");
        equipRegInfo.setSpec("无");
        equipRegInfo.setEquipModel(network.getField0015() != null ? network.getField0015() : "无");
        equipRegInfo.setUnit("1");
        equipRegInfo.setUnitName("个");
        equipRegInfo.setDisableFlag("0");
        equipRegInfo.setManufacturerCode("无");
        equipRegInfo.setManufacturerName(network.getField0043() != null ? network.getField0043() : "无");

        // 处理设备使用年限，如果为null则使用默认值
        BigDecimal devUsefulLife = network.getField0031();
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
        BigDecimal useCode = network.getField0026();
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
        equipRegInfo.setUpdtTime(network.getStartDate() != null ? network.getStartDate() : getCurrentTime());
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
