package com.springbootTz.ZNYY.Equipment.service;

import com.springbootTz.ZNYY.Equipment.entity.znyy.EquipDeprRecord;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_Depreciation;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetCard;
import com.springbootTz.ZNYY.Equipment.mapper.znyy.EquipDeprRecordMapper;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.LexmisN6_DepreciationMapper;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.LexmisN6_AssetCardMapper;
import com.springbootTz.ZNYY.Equipment.mapper.znyy.UnitInfoToolMapper;
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

        for (LexmisN6_Depreciation depreciation : depreciationList) {
            try {
                // 映射数据
                EquipDeprRecord equipDeprRecord = mapToEquipDeprRecord(depreciation);

                // 检查是否已存在
                int exists = equipDeprRecordMapper.checkEquipDeprRecordExists(equipDeprRecord.getRid());

                if (exists > 0) {
                    // 存在则更新
                    equipDeprRecordMapper.updateEquipDeprRecord(equipDeprRecord);
                } else {
                    // 不存在则插入
                    equipDeprRecordMapper.insertEquipDeprRecord(equipDeprRecord);
                }
            } catch (Exception e) {
                // 记录错误日志，继续处理下一条
                System.err.println("处理折旧记录失败: " + depreciation.getDId() + ", 错误: " + e.getMessage());
            }
        }
    }

    /**
     * 将LexmisN6_Depreciation映射为EquipDeprRecord
     */
    private EquipDeprRecord mapToEquipDeprRecord(LexmisN6_Depreciation depreciation) {
        EquipDeprRecord equipDeprRecord = new EquipDeprRecord();

        // 获取单位信息
        String unitCode = String.valueOf(unitInfoToolMapper.selectUnitCodeByName(depreciation.getDBudgetOrg()));
        String unitName = unitInfoToolMapper.selectUnitNameById(depreciation.getDBudgetOrg());

        // 生成RID: uscid+FJZZZYKJGS+depr_month+equip_card_no
        String rid = unitCode + "FJZZZYKJGS" + depreciation.getDDeprBeginMonth() + depreciation.getDId();

        // 设置基本信息
        equipDeprRecord.setRid(rid);
        equipDeprRecord.setOrgName(unitName);
        equipDeprRecord.setUscid(unitCode);
        equipDeprRecord.setUploadTime(getCurrentTime());
        equipDeprRecord.setSysPrdrCode("FJZZZYKJGS");
        equipDeprRecord.setSysPrdrName("福建众智政友有限公司");
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
        equipDeprRecord.setDeprCumAmt(null); // 无对应字段
        equipDeprRecord.setOperatorName(depreciation.getDCreateName());
        equipDeprRecord.setDealDate(depreciation.getDVoucherDate());
        equipDeprRecord.setCreateCertFlag(""); // 无对应字段，设为空字符串
        equipDeprRecord.setCreateCertDate(null); // 无对应字段
        equipDeprRecord.setAccruedCostFlag(""); // 无对应字段，设为空字符串
        equipDeprRecord.setAccruedCostDate(null); // 无对应字段
        equipDeprRecord.setDeprMean(depreciation.getDDeprKind().toString());
        equipDeprRecord.setDeprMeanName(getDeprMeanName(depreciation.getDDeprKind()));
        equipDeprRecord.setStroomCode(""); // 无对应字段，设为空字符串
        equipDeprRecord.setStroomName(""); // 无对应字段，设为空字符串

        // 查询折旧率：D_NO=A_NO，查询LexmisN6_AssetCard的AC_DeprRate
        BigDecimal deprecRate = getDeprecRate(depreciation.getDNo());
        equipDeprRecord.setDeprecRate(deprecRate);

        equipDeprRecord.setState("0");
        equipDeprRecord.setReserve1("");
        equipDeprRecord.setReserve2("");
        equipDeprRecord.setDataClctPrdrName("福建众智政友有限公司");
        equipDeprRecord.setCrteTime(depreciation.getDCreateDate());
        equipDeprRecord.setUpdtTime(parseDate("2025-08-06 00:00:00"));
        equipDeprRecord.setDeleted("0");
        equipDeprRecord.setDeletedTime(null);

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