package com.springbootTz.ZNYY.Equipment.service;

import com.springbootTz.ZNYY.Equipment.mapper.seeyon.LexmisN6_DepreciationMapper;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.UnitInfoToolMapper;
import com.springbootTz.ZNYY.Equipment.mapper.znyy.EquipCardInfoMapper;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.AssetCardDepreciationQueryMapper;
import com.springbootTz.ZNYY.Equipment.entity.znyy.EquipCardInfo;
import com.springbootTz.ZNYY.Equipment.dto.AssetCardWithDepreciationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class EquipCardInfoService {
    @Autowired
    private UnitInfoToolMapper unitInfoToolMapper;

    @Autowired
    private EquipCardInfoMapper equipCardInfoMapper;

    @Autowired
    private AssetCardDepreciationQueryMapper assetCardDepreciationQueryMapper;

    @Autowired
    private LexmisN6_DepreciationMapper lexmisN6_DepreciationMapper;

    /**
     * 设备卡片信息映射关系
     * 厂商名称的判断逻辑是，如果单位名称是周宁总医院，类型是车辆 / 房屋土地 / 家居设备 / 医疗专用设备 / 无形资产；以及单位名称是周宁县医院，类型是
     * 家居设备 / 网络信息设备 / 医疗专用设备 / 无形资产 / 车辆 /
     * 房屋土地，就用字段ev_field6的值，如果是周宁总医院类型是： 网络信息设备那就用字段ev_field7的值，否则用“无”
     *
     * sysPrdrCode=FJZZZYKJYXGS
     *
     * equip_card_info表，LexmisN6_AssetCard与LexmisN6_ExtendVal的join查询
     * rid，unitInfoToolMapper.selectUnitCodeByName(acBudgetOrg)+"FJZZZYKJYXGS"+cardRecno
     * orgName，unitInfoToolMapper.selectUnitNameById(acBudgetOrg)
     * uscid,unitInfoToolMapper.selectUnitCodeByName(acBudgetOrg)
     * uploadTime,当前时间YYYY-MM-DD HH:MM:SS
     * sysPrdrCode，"FJZZZYKJYXGS"
     * sysPrdrName，"福建众智政友科技有限公司"
     * cardRecno，acId
     * equipCardNo，acNo
     * applyNo，acNo
     * billSubNo，acNo
     * batchNo，默认第一次上传到数据库的时间，后续update的时候就不更新此字段，除非有insert才更新
     * equipCode，acNo
     * equipName，acName
     * buyCost，acOriMoney
     * nowCost，acMoney
     * buyDate，acGetDate
     * startUseDate，根据acBvName1判断，如果是房屋土地、网络信息设备、医疗专用设备、固定资产，则取关联表的ev_field101；否则取ev_field102
     * expireDate，由开始时间 + 折旧年限计算得出到期时间：<br />
     * 以下是折旧年限：（查询出的类型是Date）<br />
     * 1. 若 acBvName1 是家居设备、网络信息设备、医疗专用设备、无形资产、车辆、房屋土地且 orgName 为周宁县医院，用 ev_field81
     * 2. 若 acBvName1 是车辆、房屋土地、家具设备、网络信息设备、医疗专用设备、无形资产且 orgName 为周宁总医院，用
     * ev_field83<br />
     * 2.开始时间是startUseDate使用时间
     * useDeptCode，acUseDeptNo
     * useDeptName，acUseDeptNm
     * usefulLife，空字符串
     * manufacturerCode，空字符串
     * manufacturerName，如果是我缩写了：ev_field6（周总-车辆，周总-房屋土地，周总-家居设备，周总-医疗专用设备，周总-无形资产，周县-家居设备，周县-网络信息设备，周县-医疗专用设备，周县-无形资产，周县-车辆，周县-房屋土地），ev_field7（周总-网络信息设备）
     * manufactureNo，只有周宁总医院和周宁医院的医疗专用设备有，ev_field7;否则都是空字符串
     * purchaseOperator，空字符串
     * acceptOperator，空字符串
     * manageOperator，空字符串
     * invoNo，ev_field3（周总-车辆，周总-房屋土地，周总-家居设备，周总-医疗专用设备，周总-无形资产，周县-家居设备，周县-网络信息设备，周县-医疗专业设备，周县-无形资产，周县-车辆，周县-房屋土地）ev_field4(周总-网络信息设备)
     * equipHospitalCode，空字符串
     * measureCode，空字符串
     * retestPeriod，空字符串
     * retestUnit，空字符串
     * financeFund，空字符串
     * scienceFund，空字符串
     * selfFund，空字符串
     * receiveNo，空字符串
     * receiveDate，空字符串
     * receiveOperator，空字符串
     * houseAreaSquare，空字符串
     * deprecStartDate，空字符串
     * deprecFlag，1
     * deprecTypeCode，acDeprKind
     * deprecTypeName，根据acDeprKind判断，0=不计提
     * 1=平均年限法二
     * 2=工作量法
     * 3=双倍余额递减法
     * 4=年限总和法
     * 5=平均年限法一
     * 6＝平均年限法三
     *
     * deprecRate，acDeprRate
     * monDerpAmt，需要根据AC_NO=D_NO计算出当前AC_NO对应的折旧金额的总和，LexmisN6_DepreciationMapper.sumDeprAmountByAssetNo（D_NO）
     * netSalvageRate，空字符串
     * netSalvageCost， 空字符串
     * equipStatusCode，acBvCode2
     * equipStatusName，acBVName2
     * auditFlag，0
     * reserve1，空字符串
     * reserve2，空字符串
     * dataClctPrdrName，福建众智政友科技有限公司
     * crteTime，默认时间2025-08-06 00:00:00
     * updtTime，acUpdateTime
     * deleted，默认是0.除非下次update的时候没有更新这条，那就为1
     * deletedTime，空字符串
     */

    /**
     * 同步设备卡片信息
     */
    public void syncEquipCardInfo() {
        // 获取所有资产卡片与扩展值的关联数据
        List<AssetCardWithDepreciationDTO> assetCardList = assetCardDepreciationQueryMapper
                .selectAssetCardWithDepreciation();

        System.out.println("=== 推送数据统计 ===");
        System.out.println("从 seeyon 查询到的总数据量: " + assetCardList.size());

        int insertCount = 0;
        int updateCount = 0;
        int skipCount = 0;
        int errorCount = 0;

        for (AssetCardWithDepreciationDTO assetCard : assetCardList) {
            try {
                // 数据已经在 seeyon 层面过滤掉了周宁总医院，这里直接处理
                EquipCardInfo equipCardInfo = mapToEquipCardInfo(assetCard);

                // 检查是否已存在
                int exists = equipCardInfoMapper.checkEquipCardExists(equipCardInfo.getEquipCardNo());

                if (exists > 0) {
                    // 存在则更新 - 使用 RID 进行更新，避免数据覆盖
                    equipCardInfoMapper.updateEquipCardInfo(equipCardInfo);
                    updateCount++;
                } else {
                    // 不存在则插入
                    equipCardInfoMapper.insert(equipCardInfo);
                    insertCount++;
                }
            } catch (Exception e) {
                System.out.println("处理资产卡片失败，AC_NO: " + assetCard.getAcNo() + ", 错误: " + e.getMessage());
                errorCount++;
            }
        }

        System.out.println("=== 设备卡片信息推送完成统计 ===");
        System.out.println("新增: " + insertCount + " 条");
        System.out.println("更新: " + updateCount + " 条");
        System.out.println("跳过: " + skipCount + " 条");
        System.out.println("错误: " + errorCount + " 条");
        System.out.println("总计处理: " + (insertCount + updateCount + skipCount + errorCount) + " 条");
    }

    /**
     * 将AssetCardWithDepreciationDTO映射为EquipCardInfo
     */
    private EquipCardInfo mapToEquipCardInfo(AssetCardWithDepreciationDTO assetCard) {
        EquipCardInfo equipCardInfo = new EquipCardInfo();

        // 获取单位信息
        String unitCode = String.valueOf(unitInfoToolMapper.selectUnitCodeByName(assetCard.getAcBudgetOrg()));
        String unitName = unitInfoToolMapper.selectUnitNameById(assetCard.getAcBudgetOrg());

        // 生成RID
        String rid = unitCode + "FJZZZYKJYXGS" + assetCard.getAcId();

        // 设置基本信息
        equipCardInfo.setRid(rid);
        equipCardInfo.setOrgName(unitName);
        equipCardInfo.setUscid(unitCode);
        equipCardInfo.setUploadTime(getCurrentTime());
        equipCardInfo.setSysPrdrCode("FJZZZYKJYXGS");
        equipCardInfo.setSysPrdrName("福建众智政友科技有限公司");
        equipCardInfo.setCardRecno(assetCard.getAcId().toString());
        equipCardInfo.setEquipCardNo(assetCard.getAcNo());
        equipCardInfo.setApplyNo(assetCard.getAcNo());
        equipCardInfo.setBillSubNo(assetCard.getAcNo());
        equipCardInfo.setBatchNo(getCurrentTime()); // 第一次上传时间
        equipCardInfo.setEquipCode(assetCard.getAcNo());
        equipCardInfo.setEquipName(assetCard.getAcName());
        // 处理金额字段，如果为null则使用0
        BigDecimal buyCost = assetCard.getAcOriMoney();
        equipCardInfo.setBuyCost(buyCost != null ? buyCost : BigDecimal.ZERO);
        equipCardInfo.setNowCost(buyCost != null ? buyCost : BigDecimal.ZERO);
        // 处理购买日期，如果为null则使用默认日期
        Date buyDate = assetCard.getAcGetDate();
        equipCardInfo.setBuyDate(buyDate != null ? formatDate(buyDate) : parseDate("1900-01-01 00:00:00"));

        // 设置开始使用日期
        Date startUseDate = getStartUseDate(assetCard);
        equipCardInfo.setStartUseDate(startUseDate != null ? startUseDate : parseDate("1900-01-01 00:00:00"));

        // 设置到期日期
        // 设置到期日期，如果为null则使用默认日期
        Date expireDate = getExpireDate(assetCard, unitName);
        equipCardInfo.setExpireDate(expireDate != null ? expireDate : parseDate("1900-01-01 00:00:00"));

        // 设置科室信息
        equipCardInfo.setUseDeptCode(assetCard.getAcUseDeptNo());
        equipCardInfo.setUseDeptName(assetCard.getAcUseDeptNm());
        // 计算使用年限
        equipCardInfo
                .setUsefulLife(calculateUsefulLife(getStartUseDate(assetCard), getExpireDate(assetCard, unitName)));
        equipCardInfo.setManufacturerCode("");

        // 设置厂商名称
        equipCardInfo.setManufacturerName(getManufacturerName(assetCard, unitName));

        // 设置厂商编号
        equipCardInfo.setManufactureNo(getManufactureNo(assetCard, unitName));

        // 设置操作员信息
        equipCardInfo.setPurchaseOperator(" ");
        equipCardInfo.setAcceptOperator("   ");
        equipCardInfo.setManageOperator("   ");

        // 设置发票号
        equipCardInfo.setInvoNo(getInvoNo(assetCard, unitName));

        // 设置其他字段
        equipCardInfo.setEquipHospitalCode(" ");
        equipCardInfo.setMeasureCode(" ");
        equipCardInfo.setRetestPeriod(" ");
        equipCardInfo.setRetestUnit(" ");
        equipCardInfo.setFinanceFund(BigDecimal.ZERO);
        equipCardInfo.setScienceFund(BigDecimal.ZERO);
        equipCardInfo.setSelfFund(BigDecimal.ZERO);
        equipCardInfo.setHouseAreaSquare(BigDecimal.ZERO);
        equipCardInfo.setNetSalvageRate(BigDecimal.ZERO);
        equipCardInfo.setNetSalvageCost(BigDecimal.ZERO);
        equipCardInfo.setReceiveNo(" ");
        // 避免设置 null，使用默认日期防止 Oracle 报错
        equipCardInfo.setReceiveDate(parseDate("1900-01-01 00:00:00"));
        equipCardInfo.setReceiveOperator(" ");
        equipCardInfo.setHouseAreaSquare(BigDecimal.ZERO);
        // 避免设置 null，使用默认日期防止 Oracle 报错
        equipCardInfo.setDeprecStartDate(parseDate("1900-01-01 00:00:00"));
        equipCardInfo.setDeprecFlag("1");
        // 处理折旧类型，如果为null则使用默认值
        Integer deprecKind = assetCard.getAcDeprKind();
        equipCardInfo.setDeprecTypeCode(deprecKind != null ? deprecKind.toString() : "0");
        equipCardInfo.setDeprecTypeName(getDeprecTypeName(deprecKind));
        // 处理折旧率，如果为null则使用0
        BigDecimal deprecRate = assetCard.getAcDeprRate();
        equipCardInfo.setDeprecRate(deprecRate != null ? deprecRate : BigDecimal.ZERO);

        // 计算折旧金额总和
        BigDecimal totalDeprAmount = lexmisN6_DepreciationMapper.sumDeprAmountByAssetNo(assetCard.getAcNo());
        equipCardInfo.setMonDerpAmt(totalDeprAmount != null ? totalDeprAmount : BigDecimal.ZERO);

        equipCardInfo.setNetSalvageRate(BigDecimal.ZERO);
        equipCardInfo.setNetSalvageCost(BigDecimal.ZERO);
        equipCardInfo.setEquipStatusCode(assetCard.getAcBvCode2());
        equipCardInfo.setEquipStatusName(assetCard.getAcBvName2());
        equipCardInfo.setAuditFlag("0");
        equipCardInfo.setReserve1("");
        equipCardInfo.setReserve2("");
        equipCardInfo.setDataClctPrdrName("福建众智政友科技有限公司");
        equipCardInfo.setCrteTime(parseDate("1900-01-01 00:00:00"));
        // 处理更新时间，如果为null则使用当前时间
        Date updateTime = assetCard.getAcUpdateTime();
        equipCardInfo.setUpdtTime(updateTime != null ? updateTime : getCurrentTime());
        equipCardInfo.setDeleted("0");
        // 直接使用默认日期，避免 Oracle null 值错误
        equipCardInfo.setDeletedTime(parseDate("1900-01-01 00:00:00"));

        return equipCardInfo;
    }

    /**
     * 获取开始使用日期（返回Date类型，按规则提取并格式化）
     */
    private Date getStartUseDate(AssetCardWithDepreciationDTO assetCard) {
        String assetType = assetCard.getAcBvName1();

        // 1. 优先判断资产类型，使用acBvDate1（原逻辑中误用了acUpdateTime，这里修正为正确字段）
        if (assetType != null && (assetType.contains("房屋土地") ||
                assetType.contains("网络信息设备") ||
                assetType.contains("医疗专用设备") ||
                assetType.contains("固定资产"))) {
            // 若acBvDate1不为null，格式化后返回；否则返回当前时间
            return formatDate(
                    assetCard.getEvField101() != null ? assetCard.getEvField101() : parseDate("1900-01-01 00:00:00"));
        }
        // 2. 不满足上述类型，使用扩展字段ev_field101/102
        else {
            return formatDate(
                    assetCard.getEvField102() != null ? assetCard.getEvField102() : parseDate("1900-01-01 00:00:00"));
        }
    }

    /**
     * 获取到期日期
     * expireDate由开始时间 + 折旧年限计算得出到期时间
     * 折旧年限规则：
     * 1. 若 acBvName1 是家居设备、网络信息设备、医疗专用设备、无形资产、车辆；房屋土地且 orgName 为周宁县医院，用 ev_field81
     * 2. 若 acBvName1 是车辆、房屋土地、家具设备、网络信息设备、医疗专用设备；无形资产且 orgName 为周宁总医院，用 ev_field83
     * 开始时间优先级：
     * 1. 优先使用 getStartUseDate() 返回的开始使用时间
     * 2. 如果开始使用时间为空，则使用 ev_field101 作为备选
     * 3. 如果 ev_field101 也为空，则使用 ev_field102 作为备选
     */
    private Date getExpireDate(AssetCardWithDepreciationDTO assetCard, String orgName) {
        String assetType = assetCard.getAcBvName1();
        Integer depreciationYears = null;

        // 1. 判断是否使用ev_field81（折旧年限字段）
        // 适用场景：周宁县医院的多种设备类型 + 周宁总医院的固定资产(财政拨款)
        if (orgName != null && assetType != null) {
            // 周宁县医院的设备类型
            if (orgName.contains("周宁县医院")) {
                // if (assetType.contains("家具设备") ||
                // assetType.contains("网络信息设备") ||
                // assetType.contains("医疗专用设备") ||
                // assetType.contains("无形资产") ||
                // assetType.contains("车辆") ||
                // assetType.contains("房屋土地")) {
                // depreciationYears = assetCard.getEvField81() != null ?
                // assetCard.getEvField81().intValue() : null;
                // }
                depreciationYears = assetCard.getEvField81() != null ? assetCard.getEvField81().intValue() : null;
            }
            // 周宁总医院的固定资产(财政拨款)
            else if (orgName.contains("周宁总医院") && assetType.contains("固定资产")) {
                depreciationYears = assetCard.getEvField81() != null ? assetCard.getEvField81().intValue() : null;
            }
        }

        // 2. 判断是否使用ev_field83（折旧年限字段）
        // 适用场景：周宁总医院的多种设备类型
        if (depreciationYears == null && orgName != null && orgName.contains("周宁总医院") && assetType != null) {
            if (assetType.contains("车辆") ||
                    assetType.contains("房屋土地") ||
                    assetType.contains("家具设备") ||
                    assetType.contains("网络信息设备") ||
                    assetType.contains("医疗专用设备") ||
                    assetType.contains("无形资产")) {
                depreciationYears = assetCard.getEvField83() != null ? assetCard.getEvField83().intValue() : null;
            }
        }

        // 3. 获取开始使用时间（按优先级）
        Date startUseDate = getStartUseDate(assetCard);
        if (startUseDate == null) {
            if (assetCard.getEvField101() != null) {
                startUseDate = assetCard.getEvField101();
            } else if (assetCard.getEvField102() != null) {
                startUseDate = assetCard.getEvField102();
            }
        }

        // 4. 计算到期日期
        if (depreciationYears != null && startUseDate != null) {
            try {
                LocalDate startDate = startUseDate.toInstant()
                        .atZone(java.time.ZoneId.systemDefault())
                        .toLocalDate();
                LocalDate expireDate = startDate.plusYears(depreciationYears);
                return Date.from(expireDate.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
            } catch (Exception e) {
                // 如果计算失败，返回当前时间加1年作为默认值
                return Date
                        .from(LocalDate.now().plusYears(1).atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
            }
        }

        // 如果无法计算到期日期，返回当前时间加1年作为默认值
        return Date.from(LocalDate.now().plusYears(1).atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取厂商名称————field6（周宁总医院停用）
     */
    private String getManufacturerName(AssetCardWithDepreciationDTO assetCard, String orgName) {
        // String assetType = assetCard.getAcBvName1();
        // String prefix = orgName.contains("周宁总医院") ? "周总" : "周县";

        if (!orgName.contains("周宁总医院")) {
            // 确保不返回 null，如果 evField6 为 null 则返回空字符串
            String evField6 = assetCard.getEvField6();
            return evField6 != null ? evField6 : "无";
        }

        // if (assetType != null) {
        // if (assetType.contains("车辆"))
        // return prefix + "-车辆";
        // if (assetType.contains("房屋土地"))
        // return prefix + "-房屋土地";
        // if (assetType.contains("家居设备"))
        // return prefix + "-家居设备";
        // if (assetType.contains("医疗专用设备"))
        // return prefix + "-医疗专用设备";
        // if (assetType.contains("无形资产"))
        // return prefix + "-无形资产";
        // if (assetType.contains("网络信息设备"))
        // return prefix + "-网络信息设备";
        // }

        return "无";
    }

    /**
     * 获取厂商编号————fiel7（周宁总医院停用）
     */
    private String getManufactureNo(AssetCardWithDepreciationDTO assetCard, String orgName) {
        if (!orgName.contains("周宁总医院")) {
            // 确保不返回 null，如果 evField7 为 null 则返回空字符串
            String evField7 = assetCard.getEvField7();
            return evField7 != null ? evField7 : "无";
        }
        // String assetType = assetCard.getAcBvName1();
        // if (assetType != null && assetType.contains("医疗专用设备") &&
        // (orgName.contains("周宁总医院") || orgName.contains("周宁县医院"))) {
        // return assetCard.getEvField7() != null ? assetCard.getEvField7() : "";
        // }

        return "无";
    }

    /**
     * 获取发票号
     */
    private String getInvoNo(AssetCardWithDepreciationDTO assetCard, String orgName) {
        // String assetType = assetCard.getAcBvName1();
        // String prefix = orgName.contains("周宁总医院") ? "周总" : "周县";
        //
        // if (assetType != null) {
        // if (assetType.contains("网络信息设备") && orgName.contains("周宁总医院")) {
        // return assetCard.getEvField4() != null ? assetCard.getEvField4() : "";
        // } else {
        // return assetCard.getEvField3() != null ? assetCard.getEvField3() : "";
        // }
        // }

        if (!orgName.contains("周宁总医院")) {
            // 确保不返回 null，如果 evField3 为 null 则返回空字符串
            String evField3 = assetCard.getEvField3();
            return evField3 != null ? evField3 : "无";
        }

        return "无";
    }

    /**
     * 获取折旧类型名称
     */
    private String getDeprecTypeName(Integer deprKind) {
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
                return "";
        }
    }

    /**
     * 获取当前时间（返回Date类型）
     */
    private Date getCurrentTime() {
        return new Date(); // 直接返回当前时间的Date对象
    }

    /**
     * 格式化日期（保留日期部分，忽略时间，返回Date类型）
     */
    private Date formatDate(Date date) {
        if (date == null) {
            return null; // 输入为null时返回null（Date类型不能返回空字符串""）
        }
        try {
            // 1. 将原Date转为"yyyy-MM-dd"格式的字符串（只保留日期部分）
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = sdf.format(date);

            // 2. 将格式化后的字符串转回Date类型（此时时间部分会默认设为00:00:00）
            return sdf.parse(dateStr);
        } catch (Exception e) {
            // 异常时返回原日期，避免报错
            return date;
        }
    }

    /**
     * 解析日期字符串
     */
    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 计算使用年限
     * 规则：
     * 1. 如果当前时间小于到期日期：使用年限 = 当前年份 - 开始使用日期的年份
     * 2. 如果当前时间大于等于到期日期：使用年限 = 到期日期年份 - 开始使用日期的年份
     * 3. 如果无法计算：使用年限 = 1（默认值）
     */
    private Integer calculateUsefulLife(Date startUseDate, Date expireDate) {
        try {
            if (startUseDate == null || expireDate == null) {
                return 1; // 默认值
            }

            // 获取当前时间
            Date currentTime = getCurrentTime();

            // 转换为LocalDate以便计算年份
            LocalDate startDate = startUseDate.toInstant()
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate expireLocalDate = expireDate.toInstant()
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate currentLocalDate = currentTime.toInstant()
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate();

            int startYear = startDate.getYear();
            int expireYear = expireLocalDate.getYear();
            int currentYear = currentLocalDate.getYear();

            // 如果当前时间小于到期日期
            if (currentLocalDate.isBefore(expireLocalDate)) {
                return currentYear - startYear;
            } else {
                // 如果当前时间大于等于到期日期
                return expireYear - startYear;
            }
        } catch (Exception e) {
            // 异常时返回默认值
            return 1;
        }
    }
}
