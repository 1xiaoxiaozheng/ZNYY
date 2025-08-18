package com.springbootTz.ZNYY.Equipment.service;

import com.springbootTz.ZNYY.Equipment.entity.znyy.EquipDeprRecord;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_Depreciation;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetCard;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.UnitInfoToolMapper;
import com.springbootTz.ZNYY.Equipment.mapper.znyy.EquipDeprRecordMapper;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.LexmisN6_DepreciationMapper;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.LexmisN6_AssetCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class EquipDeprRecordService {
    @Autowired
    private UnitInfoToolMapper unitInfoToolMapper;

    @Autowired
    private EquipDeprRecordMapper equipDeprRecordMapper;

    @Autowired
    private LexmisN6_DepreciationMapper lexmisN6_DepreciationMapper;

    @Autowired
    private LexmisN6_AssetCardMapper lexmisN6_AssetCardMapper;

    /**
     * 同步折旧记录数据从seeyon到ZNYY
     */
    public void syncEquipDeprRecord() {
        // 获取所有折旧记录
        List<LexmisN6_Depreciation> depreciationList = lexmisN6_DepreciationMapper.selectAll();

        System.out.println("=== 折旧记录推送统计 ===");
        System.out.println("从 seeyon 查询到的折旧记录总数: " + depreciationList.size());

        if (depreciationList.isEmpty()) {
            System.out.println("警告: 没有查询到任何折旧记录！");
            return;
        }

        int insertCount = 0;
        int updateCount = 0;
        int errorCount = 0;

        for (LexmisN6_Depreciation depreciation : depreciationList) {
            try {
                // 映射数据
                EquipDeprRecord equipDeprRecord = mapToEquipDeprRecord(depreciation);

                // 检查是否已存在
                int exists = equipDeprRecordMapper.checkEquipDeprRecordExists(equipDeprRecord.getRid());

                if (exists > 0) {
                    // 存在则更新
                    equipDeprRecordMapper.updateEquipDeprRecord(equipDeprRecord);
                    updateCount++;
                } else {
                    // 不存在则插入
                    equipDeprRecordMapper.insertEquipDeprRecord(equipDeprRecord);
                    insertCount++;
                }
            } catch (Exception e) {
                // 记录错误日志，继续处理下一条
                System.err.println("处理折旧记录失败: " + depreciation.getDId() + ", 错误: " + e.getMessage());
                errorCount++;
            }
        }

        System.out.println("=== 设备折旧记录推送完成统计 ===");
        System.out.println("新增: " + insertCount + " 条");
        System.out.println("更新: " + updateCount + " 条");
        System.out.println("错误: " + errorCount + " 条");
        System.out.println("总计处理: " + (insertCount + updateCount + errorCount) + " 条");
    }

    /**
     * 将LexmisN6_Depreciation映射为EquipDeprRecord
     */
    private EquipDeprRecord mapToEquipDeprRecord(LexmisN6_Depreciation depreciation) {
        EquipDeprRecord equipDeprRecord = new EquipDeprRecord();

        // 获取单位信息
        String unitCode = String.valueOf(unitInfoToolMapper.selectUnitCodeByName(depreciation.getDBudgetOrg()));
        String unitName = unitInfoToolMapper.selectUnitNameById(depreciation.getDBudgetOrg());

        // 生成RID: uscid+FJZZZYKJYXGS+depr_month+equip_card_no
        String rid = unitCode + "FJZZZYKJYXGS" + depreciation.getDDeprBeginMonth() + depreciation.getDId();

        // 设置基本信息
        equipDeprRecord.setRid(rid);
        equipDeprRecord.setOrgName(unitName);
        equipDeprRecord.setUscid(unitCode);
        equipDeprRecord.setUploadTime(getCurrentTime());
        equipDeprRecord.setSysPrdrCode("FJZZZYKJYXGS");
        equipDeprRecord.setSysPrdrName("福建众智政友科技有限公司");
        equipDeprRecord.setDeprMonth(String.valueOf(depreciation.getDDeprBeginMonth())); // Integer转String
        equipDeprRecord.setEquipCardNo(String.valueOf(depreciation.getDId())); // Long转String
        equipDeprRecord.setEquipCode(depreciation.getDNo());
        equipDeprRecord.setEquipName(depreciation.getDName());
        equipDeprRecord.setDeprPeriod(depreciation.getDDeprMonthTotal());
        equipDeprRecord.setFundsSoucCode(depreciation.getDFundNo());
        equipDeprRecord.setFundsSoucName(depreciation.getDFundNm());
        equipDeprRecord.setUseDeptCode(String.valueOf(depreciation.getDUseDeptNo())); // Long转String
        equipDeprRecord.setUseDeptName(depreciation.getDUseDeptNm());
        equipDeprRecord.setCurrentDepr(depreciation.getDDeprAmount());
        equipDeprRecord.setDeprCumAmt(BigDecimal.ZERO); // 无对应字段
        equipDeprRecord.setOperatorName(depreciation.getDCreateName());
        if (depreciation.getDVoucherDate() == null) {
            equipDeprRecord.setDealDate(parseDate("1900-01-01 00:00:00")); // 无对应字段
        } else {
            equipDeprRecord.setDealDate(depreciation.getDVoucherDate());// 如果为空那就使用默认值，
        }
        equipDeprRecord.setCreateCertFlag("无"); // 无对应字段，设为空字符串
        equipDeprRecord.setCreateCertDate(parseDate("1900-01-01 00:00:00")); // 无对应字段
        equipDeprRecord.setAccruedCostFlag("无"); // 无对应字段，设为空字符串
        equipDeprRecord.setAccruedCostDate(parseDate("1900-01-01 00:00:00")); // 无对应字段
        equipDeprRecord.setDeprMean(depreciation.getDDeprKind().toString());
        equipDeprRecord.setDeprMeanName(getDeprMeanName(depreciation.getDDeprKind()));
        equipDeprRecord.setStroomCode("无"); // 无对应字段，设为空字符串
        equipDeprRecord.setStroomName("无"); // 无对应字段，设为空字符串

        // 查询折旧率：D_NO=A_NO，查询LexmisN6_AssetCard的AC_DeprRate
        BigDecimal deprecRate = getDeprecRate(depreciation.getDNo());
        equipDeprRecord.setDeprecRate(deprecRate);

        equipDeprRecord.setState("0");
        equipDeprRecord.setReserve1("无");
        equipDeprRecord.setReserve2("无");
        equipDeprRecord.setDataClctPrdrName("福建众智政友科技有限公司");
        equipDeprRecord.setCrteTime(depreciation.getDCreateDate());
        equipDeprRecord.setUpdtTime(parseDate("1900-01-01 00:00:00"));
        equipDeprRecord.setDeleted("0");
        equipDeprRecord.setDeletedTime(parseDate("1900-01-01 00:00:00"));

        return equipDeprRecord;
    }

    /**
     * 根据折旧方法代码获取折旧方法名称
     */
    private String getDeprMeanName(Integer deprKind) {
        if (deprKind == null)
            return "";

        switch (deprKind) {
            case 0:
                return "不计提";
            case 1:
                return "平均年限法二";
            case 2:
                return "工作量法";
            case 3:
                return "双倍余额递减法";
            case 4:
                return "年限总和法";
            case 5:
                return "平均年限法一";
            case 6:
                return "平均年限法三";
            default:
                return "未知";
        }
    }

    /**
     * 根据设备编号查询折旧率
     */
    private BigDecimal getDeprecRate(String equipNo) {
        try {
            LexmisN6_AssetCard assetCard = lexmisN6_AssetCardMapper.selectByAcNo(equipNo);
            return assetCard != null ? assetCard.getAcDeprRate() : BigDecimal.ZERO;
        } catch (Exception e) {
            return BigDecimal.ZERO;
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