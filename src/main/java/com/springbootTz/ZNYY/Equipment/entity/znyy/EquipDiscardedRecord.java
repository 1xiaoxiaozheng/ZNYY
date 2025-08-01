package com.springbootTz.ZNYY.Equipment.entity.znyy;

import java.math.BigDecimal;
import java.util.Date;;

/**
 设备报废记录实体类
 对应表名：equip_discarded_record
 */
public class EquipDiscardedRecord {
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
    // 报废单号（复合主键）
    private String discardedNo;
    // 设备代码
    private String equipCode;
    // 设备名称
    private String equipName;
    // 项目规格
    private String spec;
    // 设备型号
    private String equipModel;
    // 计量单位
    private String unit;
    // 计量单位名称
    private String unitName;
    // 使用部门
    private String useDep;
    // 设备单价
    private BigDecimal equipPric;
    // 采购日期
    private Date purcDate;
    // 已用年限
    private Integer usedLife;
    // 估计残值
    private BigDecimal estimaResidualValue;
    // 报废原因
    private String discardedRea;
    // 申请人姓名
    private String applyerName;
    // 申请日期
    private Date applyDate;
    // 审核人姓名
    private String auditOperatorName;
    // 审核日期
    private Date auditDate;
    // 生产厂商代码
    private String manufacturerCode;
    // 生产厂商名称
    private String manufacturerName;
    // 修改标志（0: 正常；1: 撤销）
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
    public String getDiscardedNo() {
        return discardedNo;
    }
    public void setDiscardedNo(String discardedNo) {
        this.discardedNo = discardedNo;
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
    public String getSpec() {
        return spec;
    }
    public void setSpec(String spec) {
        this.spec = spec;
    }
    public String getEquipModel() {
        return equipModel;
    }
    public void setEquipModel(String equipModel) {
        this.equipModel = equipModel;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getUnitName() {
        return unitName;
    }
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    public String getUseDep() {
        return useDep;
    }
    public void setUseDep(String useDep) {
        this.useDep = useDep;
    }
    public BigDecimal getEquipPric() {
        return equipPric;
    }
    public void setEquipPric(BigDecimal equipPric) {
        this.equipPric = equipPric;
    }
    public Date getPurcDate() {
        return purcDate;
    }
    public void setPurcDate(Date purcDate) {
        this.purcDate = purcDate;
    }
    public Integer getUsedLife() {
        return usedLife;
    }
    public void setUsedLife(Integer usedLife) {
        this.usedLife = usedLife;
    }
    public BigDecimal getEstimaResidualValue() {
        return estimaResidualValue;
    }
    public void setEstimaResidualValue(BigDecimal estimaResidualValue) {
        this.estimaResidualValue = estimaResidualValue;
    }
    public String getDiscardedRea() {
        return discardedRea;
    }
    public void setDiscardedRea(String discardedRea) {
        this.discardedRea = discardedRea;
    }
    public String getApplyerName() {
        return applyerName;
    }
    public void setApplyerName(String applyerName) {
        this.applyerName = applyerName;
    }
    public Date getApplyDate() {
        return applyDate;
    }
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
    public String getAuditOperatorName() {
        return auditOperatorName;
    }
    public void setAuditOperatorName(String auditOperatorName) {
        this.auditOperatorName = auditOperatorName;
    }
    public Date getAuditDate() {
        return auditDate;
    }
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
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
