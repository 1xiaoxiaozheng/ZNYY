package com.springbootTz.ZNYY.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 实体类：HUM_PSN_EMPR_INFO
 * 对应Oracle表HUM_PSN_EMPR_INFO
 */
@Data
@TableName("HUM_PSN_EMPR_INFO")
public class OraclePersonEmprInfo implements Serializable {
    /** 数据唯一记录号 */
    @TableId(value = "RID", type = IdType.INPUT)
    private String rid;
    /** 医疗机构名称 */
    @TableField("ORG_NAME")
    private String orgName;
    /** 医疗机构统一社会信用代码 */
    @TableField("USCID")
    private String uscid;
    /** 数据上传时间 */
    @TableField("UPLOAD_TIME")
    private Date uploadTime;
    /** 系统建设厂商代码 */
    @TableField("SYS_PRDR_CODE")
    private String sysPrdrCode;
    /** 系统建设厂商名称 */
    @TableField("SYS_PRDR_NAME")
    private String sysPrdrName;
    /** 系统原始ID */
    @TableField("ORIGINAL_ID")
    private String originalId;
    /** 员工id */
    @TableField("STAFF_ID")
    private String staffId;
    /** 机构内人员工号 */
    @TableField("STAFF_NO")
    private String staffNo;
    /** 机构内人员姓名 */
    @TableField("STAFF_NAME")
    private String staffName;
    /** 工作开始日期 */
    @TableField("WKBEGN_DATE")
    private Date wkbegnDate;
    /** 工作结束日期 */
    @TableField("WKEND_DATE")
    private Date wkendDate;
    /** 工作单位名称 */
    @TableField("EMPR_NAME")
    private String emprName;
    /** 任职科室 */
    @TableField("POST_DEPT")
    private String postDept;
    /** 聘任职称、职务 */
    @TableField("APPOINT_NAME")
    private String appointName;
    /** 数据改造厂商名称 */
    @TableField("DATA_CLCT_PRDR_NAME")
    private String dataClctPrdrName;
    /** 数据创建时间 */
    @TableField("CRTE_TIME")
    private Date crteTime;
    /** 数据更新时间 */
    @TableField("UPDT_TIME")
    private Date updtTime;
    /** 数据删除状态 */
    @TableField("DELETED")
    private String deleted;
    /** 数据删除时间 */
    @TableField("DELETED_TIME")
    private Date deletedTime;

    // Getter and Setter methods
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

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Date getWkbegnDate() {
        return wkbegnDate;
    }

    public void setWkbegnDate(Date wkbegnDate) {
        this.wkbegnDate = wkbegnDate;
    }

    public Date getWkendDate() {
        return wkendDate;
    }

    public void setWkendDate(Date wkendDate) {
        this.wkendDate = wkendDate;
    }

    public String getEmprName() {
        return emprName;
    }

    public void setEmprName(String emprName) {
        this.emprName = emprName;
    }

    public String getPostDept() {
        return postDept;
    }

    public void setPostDept(String postDept) {
        this.postDept = postDept;
    }

    public String getAppointName() {
        return appointName;
    }

    public void setAppointName(String appointName) {
        this.appointName = appointName;
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