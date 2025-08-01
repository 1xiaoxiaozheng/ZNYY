package com.springbootTz.ZNYY.Equipment.entity.znyy;


import java.math.BigDecimal;
import java.util.Date;

/**
 * 设备卡片信息实体类
 * 对应表名：equip_card_info
 */
public class EquipCardInfo {
    // 数据唯一记录号
    private String rid;
    // 医疗机构名称
    private String orgName;
    // 医疗机构统一社会信用代码（复合主键）
    private String uscid;
    // 数据上传时间（复合主键）
    private Date uploadTime;
    // 系统建设厂商代码（复合主键）
    private String sysPrdrCode;
    // 系统建设厂商名称
    private String sysPrdrName;
    // 设备卡片记录单（复合主键）
    private String cardRecno;
    // 设备卡片号
    private String equipCardNo;
    // 单据号
    private String applyNo;
    // 单据序号
    private String billSubNo;
    // 批次
    private String batchNo;
    // 设备代码
    private String equipCode;
    // 设备名称
    private String equipName;
    // 购入金额
    private BigDecimal buyCost;
    // 当前金额
    private BigDecimal nowCost;
    // 购买日期
    private Date buyDate;
    // 启用日期
    private Date startUseDate;
    // 到期日期
    private Date expireDate;
    // 使用科室代码
    private String useDeptCode;
    // 使用科室名称
    private String useDeptName;
    // 使用年限
    private Integer usefulLife;
    // 生产厂商代码
    private String manufacturerCode;
    // 生产厂商名称
    private String manufacturerName;
    // 出厂编号
    private String manufactureNo;
    // 采购人员
    private String purchaseOperator;
    // 验收人员
    private String acceptOperator;
    // 管理人员
    private String manageOperator;
    // 发票号
    private String invoNo;
    // 设备医院编码
    private String equipHospitalCode;
    // 计量编码
    private String measureCode;
    // 检定周期
    private String retestPeriod;
    // 检定单位
    private String retestUnit;
    // 财政资金
    private BigDecimal financeFund;
    // 科教资金
    private BigDecimal scienceFund;
    // 自有资金
    private BigDecimal selfFund;
    // 领用单号
    private String receiveNo;
    // 领用日期
    private Date receiveDate;
    // 领用人员
    private String receiveOperator;
    // 房屋面积
    private BigDecimal houseAreaSquare;
    // 折旧起始日期
    private Date deprecStartDate;
    // 折旧标志（1是，0否）
    private String deprecFlag;
    // 折旧方式代码
    private String deprecTypeCode;
    // 折旧方式名称
    private String deprecTypeName;
    // 月折旧率
    private BigDecimal deprecRate;
    // 月折旧金额
    private BigDecimal monDerpAmt;
    // 净残值率
    private BigDecimal netSalvageRate;
    // 净残值金额
    private BigDecimal netSalvageCost;
    // 设备状态代码
    private String equipStatusCode;
    // 设备状态名称
    private String equipStatusName;
    // 审核标志（0:正常; 1:撤销）
    private String auditFlag;
    // 预留一
    private String reserve1;
    // 预留二
    private String reserve2;
    // 数据改造厂商名称
    private String dataClctPrdrName;
    // 数据创建时间
    private Date crteTime;
    // 数据更新时间
    private Date updtTime;
    // 数据删除状态
    private String deleted;
    // 数据删除时间
    private Date deletedTime;

    // getters and setters
    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUscid() {
        return uscid;
    }

    public void setUscid(String uscid) {
        this.uscid = uscid;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getSysPrdrCode() {
        return sysPrdrCode;
    }

    public void setSysPrdrCode(String sysPrdrCode) {
        this.sysPrdrCode = sysPrdrCode;
    }

    public String getSysPrdrName() {
        return sysPrdrName;
    }

    public void setSysPrdrName(String sysPrdrName) {
        this.sysPrdrName = sysPrdrName;
    }

    public String getCardRecno() {
        return cardRecno;
    }

    public void setCardRecno(String cardRecno) {
        this.cardRecno = cardRecno;
    }

    public String getEquipCardNo() {
        return equipCardNo;
    }

    public void setEquipCardNo(String equipCardNo) {
        this.equipCardNo = equipCardNo;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getBillSubNo() {
        return billSubNo;
    }

    public void setBillSubNo(String billSubNo) {
        this.billSubNo = billSubNo;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getEquipCode() {
        return equipCode;
    }

    public void setEquipCode(String equipCode) {
        this.equipCode = equipCode;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public BigDecimal getBuyCost() {
        return buyCost;
    }

    public void setBuyCost(BigDecimal buyCost) {
        this.buyCost = buyCost;
    }

    public BigDecimal getNowCost() {
        return nowCost;
    }

    public void setNowCost(BigDecimal nowCost) {
        this.nowCost = nowCost;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getStartUseDate() {
        return startUseDate;
    }

    public void setStartUseDate(Date startUseDate) {
        this.startUseDate = startUseDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getUseDeptCode() {
        return useDeptCode;
    }

    public void setUseDeptCode(String useDeptCode) {
        this.useDeptCode = useDeptCode;
    }

    public String getUseDeptName() {
        return useDeptName;
    }

    public void setUseDeptName(String useDeptName) {
        this.useDeptName = useDeptName;
    }

    public Integer getUsefulLife() {
        return usefulLife;
    }

    public void setUsefulLife(Integer usefulLife) {
        this.usefulLife = usefulLife;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufactureNo() {
        return manufactureNo;
    }

    public void setManufactureNo(String manufactureNo) {
        this.manufactureNo = manufactureNo;
    }

    public String getPurchaseOperator() {
        return purchaseOperator;
    }

    public void setPurchaseOperator(String purchaseOperator) {
        this.purchaseOperator = purchaseOperator;
    }

    public String getAcceptOperator() {
        return acceptOperator;
    }

    public void setAcceptOperator(String acceptOperator) {
        this.acceptOperator = acceptOperator;
    }

    public String getManageOperator() {
        return manageOperator;
    }

    public void setManageOperator(String manageOperator) {
        this.manageOperator = manageOperator;
    }

    public String getInvoNo() {
        return invoNo;
    }

    public void setInvoNo(String invoNo) {
        this.invoNo = invoNo;
    }

    public String getEquipHospitalCode() {
        return equipHospitalCode;
    }

    public void setEquipHospitalCode(String equipHospitalCode) {
        this.equipHospitalCode = equipHospitalCode;
    }

    public String getMeasureCode() {
        return measureCode;
    }

    public void setMeasureCode(String measureCode) {
        this.measureCode = measureCode;
    }

    public String getRetestPeriod() {
        return retestPeriod;
    }

    public void setRetestPeriod(String retestPeriod) {
        this.retestPeriod = retestPeriod;
    }

    public String getRetestUnit() {
        return retestUnit;
    }

    public void setRetestUnit(String retestUnit) {
        this.retestUnit = retestUnit;
    }

    public BigDecimal getFinanceFund() {
        return financeFund;
    }

    public void setFinanceFund(BigDecimal financeFund) {
        this.financeFund = financeFund;
    }

    public BigDecimal getScienceFund() {
        return scienceFund;
    }

    public void setScienceFund(BigDecimal scienceFund) {
        this.scienceFund = scienceFund;
    }

    public BigDecimal getSelfFund() {
        return selfFund;
    }

    public void setSelfFund(BigDecimal selfFund) {
        this.selfFund = selfFund;
    }

    public String getReceiveNo() {
        return receiveNo;
    }

    public void setReceiveNo(String receiveNo) {
        this.receiveNo = receiveNo;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getReceiveOperator() {
        return receiveOperator;
    }

    public void setReceiveOperator(String receiveOperator) {
        this.receiveOperator = receiveOperator;
    }

    public BigDecimal getHouseAreaSquare() {
        return houseAreaSquare;
    }

    public void setHouseAreaSquare(BigDecimal houseAreaSquare) {
        this.houseAreaSquare = houseAreaSquare;
    }

    public Date getDeprecStartDate() {
        return deprecStartDate;
    }

    public void setDeprecStartDate(Date deprecStartDate) {
        this.deprecStartDate = deprecStartDate;
    }

    public String getDeprecFlag() {
        return deprecFlag;
    }

    public void setDeprecFlag(String deprecFlag) {
        this.deprecFlag = deprecFlag;
    }

    public String getDeprecTypeCode() {
        return deprecTypeCode;
    }

    public void setDeprecTypeCode(String deprecTypeCode) {
        this.deprecTypeCode = deprecTypeCode;
    }

    public String getDeprecTypeName() {
        return deprecTypeName;
    }

    public void setDeprecTypeName(String deprecTypeName) {
        this.deprecTypeName = deprecTypeName;
    }

    public BigDecimal getDeprecRate() {
        return deprecRate;
    }

    public void setDeprecRate(BigDecimal deprecRate) {
        this.deprecRate = deprecRate;
    }

    public BigDecimal getMonDerpAmt() {
        return monDerpAmt;
    }

    public void setMonDerpAmt(BigDecimal monDerpAmt) {
        this.monDerpAmt = monDerpAmt;
    }

    public BigDecimal getNetSalvageRate() {
        return netSalvageRate;
    }

    public void setNetSalvageRate(BigDecimal netSalvageRate) {
        this.netSalvageRate = netSalvageRate;
    }

    public BigDecimal getNetSalvageCost() {
        return netSalvageCost;
    }

    public void setNetSalvageCost(BigDecimal netSalvageCost) {
        this.netSalvageCost = netSalvageCost;
    }

    public String getEquipStatusCode() {
        return equipStatusCode;
    }

    public void setEquipStatusCode(String equipStatusCode) {
        this.equipStatusCode = equipStatusCode;
    }

    public String getEquipStatusName() {
        return equipStatusName;
    }

    public void setEquipStatusName(String equipStatusName) {
        this.equipStatusName = equipStatusName;
    }

    public String getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(String auditFlag) {
        this.auditFlag = auditFlag;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    public String getDataClctPrdrName() {
        return dataClctPrdrName;
    }

    public void setDataClctPrdrName(String dataClctPrdrName) {
        this.dataClctPrdrName = dataClctPrdrName;
    }

    public Date getCrteTime() {
        return crteTime;
    }

    public void setCrteTime(Date crteTime) {
        this.crteTime = crteTime;
    }

    public Date getUpdtTime() {
        return updtTime;
    }

    public void setUpdtTime(Date updtTime) {
        this.updtTime = updtTime;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Date getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Date deletedTime) {
        this.deletedTime = deletedTime;
    }
}
