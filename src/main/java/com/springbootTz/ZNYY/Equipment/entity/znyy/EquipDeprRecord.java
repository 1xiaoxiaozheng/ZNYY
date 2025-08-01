package com.springbootTz.ZNYY.Equipment.entity.znyy;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 设备折旧记录实体类
 * 对应表名：equip_depr_record
 */
public class EquipDeprRecord {
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
    // 折旧月（复合主键）
    private String deprMonth;
    // 设备卡片号（复合主键）
    private String equipCardNo;
    // 设备代码
    private String equipCode;
    // 设备名称
    private String equipName;
    // 折旧期间
    private Integer deprPeriod;
    // 资金来源代码
    private String fundsSoucCode;
    // 资金来源名称
    private String fundsSoucName;
    // 使用科室代码
    private String useDeptCode;
    // 使用科室名称
    private String useDeptName;
    // 本期折旧
    private BigDecimal currentDepr;
    // 累计折旧金额
    private BigDecimal deprCumAmt;
    // 操作人姓名
    private String operatorName;
    // 处理日期
    private Date dealDate;
    // 是否生成凭证（1是，0否）
    private String createCertFlag;
    // 生成凭证日期
    private Date createCertDate;
    // 是否计提成本
    private String accruedCostFlag;
    // 计提成本日期
    private Date accruedCostDate;
    // 使用折旧方法
    private String deprMean;
    // 使用折旧方法名称
    private String deprMeanName;
    // 仓库代码
    private String stroomCode;
    // 仓库名称
    private String stroomName;
    // 月折旧率
    private BigDecimal deprecRate;
    // 修改标志（0:正常; 1:撤销）
    private String state;
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

    public String getDeprMonth() {
        return deprMonth;
    }

    public void setDeprMonth(String deprMonth) {
        this.deprMonth = deprMonth;
    }

    public String getEquipCardNo() {
        return equipCardNo;
    }

    public void setEquipCardNo(String equipCardNo) {
        this.equipCardNo = equipCardNo;
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

    public Integer getDeprPeriod() {
        return deprPeriod;
    }

    public void setDeprPeriod(Integer deprPeriod) {
        this.deprPeriod = deprPeriod;
    }

    public String getFundsSoucCode() {
        return fundsSoucCode;
    }

    public void setFundsSoucCode(String fundsSoucCode) {
        this.fundsSoucCode = fundsSoucCode;
    }

    public String getFundsSoucName() {
        return fundsSoucName;
    }

    public void setFundsSoucName(String fundsSoucName) {
        this.fundsSoucName = fundsSoucName;
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

    public BigDecimal getCurrentDepr() {
        return currentDepr;
    }

    public void setCurrentDepr(BigDecimal currentDepr) {
        this.currentDepr = currentDepr;
    }

    public BigDecimal getDeprCumAmt() {
        return deprCumAmt;
    }

    public void setDeprCumAmt(BigDecimal deprCumAmt) {
        this.deprCumAmt = deprCumAmt;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public String getCreateCertFlag() {
        return createCertFlag;
    }

    public void setCreateCertFlag(String createCertFlag) {
        this.createCertFlag = createCertFlag;
    }

    public Date getCreateCertDate() {
        return createCertDate;
    }

    public void setCreateCertDate(Date createCertDate) {
        this.createCertDate = createCertDate;
    }

    public String getAccruedCostFlag() {
        return accruedCostFlag;
    }

    public void setAccruedCostFlag(String accruedCostFlag) {
        this.accruedCostFlag = accruedCostFlag;
    }

    public Date getAccruedCostDate() {
        return accruedCostDate;
    }

    public void setAccruedCostDate(Date accruedCostDate) {
        this.accruedCostDate = accruedCostDate;
    }

    public String getDeprMean() {
        return deprMean;
    }

    public void setDeprMean(String deprMean) {
        this.deprMean = deprMean;
    }

    public String getDeprMeanName() {
        return deprMeanName;
    }

    public void setDeprMeanName(String deprMeanName) {
        this.deprMeanName = deprMeanName;
    }

    public String getStroomCode() {
        return stroomCode;
    }

    public void setStroomCode(String stroomCode) {
        this.stroomCode = stroomCode;
    }

    public String getStroomName() {
        return stroomName;
    }

    public void setStroomName(String stroomName) {
        this.stroomName = stroomName;
    }

    public BigDecimal getDeprecRate() {
        return deprecRate;
    }

    public void setDeprecRate(BigDecimal deprecRate) {
        this.deprecRate = deprecRate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
