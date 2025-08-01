package com.springbootTz.ZNYY.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 实体类：HUM_PSN_EDU_INFO
 * 对应Oracle表HUM_PSN_EDU_INFO
 */
@Data
@TableName("HUM_PSN_EDU_INFO")
public class OraclePersonEduInfo implements Serializable {
    /** 数据唯一记录号 */
    @TableId(value = "RID", type = IdType.INPUT)
    private String rid;
    /** 医疗机构名称 */
    private String orgName;
    /** 医疗机构统一社会信用代码 */
    private String uscid;
    /** 数据上传时间 */
    private Date uploadTime;
    /** 系统建设厂商代码 */
    private String sysPrdrCode;
    /** 系统建设厂商名称 */
    private String sysPrdrName;
    /** 系统原始ID */
    private String originalId;
    /** 员工id */
    private String staffId;
    /** 机构内人员工号 */
    private String staffNo;
    /** 机构内人员姓名 */
    private String staffName;
    /** 毕业学校 */
    private String graduatSch;
    /** 入学日期 */
    private Date enrDate;
    /** 毕业日期 */
    private Date graduatDate;
    /** 学历代码 */
    private String eduBackgroundCode;
    /** 学历名称 */
    private String eduBackgroundName;
    /** 学位代码 */
    private String degreeCode;
    /** 学位名称 */
    private String degreeName;
    /** 学制 */
    private Long variant;
    /** 教育类别代码 */
    private String eduTypeCode;
    /** 教育类别名称 */
    private String eduTypeName;
    /** 所学专业代码 */
    private String majorCode;
    /** 所学专业名称 */
    private String majorName;
    /** 数据改造厂商名称 */
    private String dataClctPrdrName;
    /** 数据创建时间 */
    private Date crteTime;
    /** 数据更新时间 */
    private Date updtTime;
    /** 数据删除状态 */
    private String deleted;
    /** 数据删除时间 */
    private Date deletedTime;

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

    public String getGraduatSch() {
        return graduatSch;
    }

    public void setGraduatSch(String graduatSch) {
        this.graduatSch = graduatSch;
    }

    public Date getEnrDate() {
        return enrDate;
    }

    public void setEnrDate(Date enrDate) {
        this.enrDate = enrDate;
    }

    public Date getGraduatDate() {
        return graduatDate;
    }

    public void setGraduatDate(Date graduatDate) {
        this.graduatDate = graduatDate;
    }

    public String getEduBackgroundCode() {
        return eduBackgroundCode;
    }

    public void setEduBackgroundCode(String eduBackgroundCode) {
        this.eduBackgroundCode = eduBackgroundCode;
    }

    public String getEduBackgroundName() {
        return eduBackgroundName;
    }

    public void setEduBackgroundName(String eduBackgroundName) {
        this.eduBackgroundName = eduBackgroundName;
    }

    public String getDegreeCode() {
        return degreeCode;
    }

    public void setDegreeCode(String degreeCode) {
        this.degreeCode = degreeCode;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public Long getVariant() {
        return variant;
    }

    public void setVariant(Long variant) {
        this.variant = variant;
    }

    public String getEduTypeCode() {
        return eduTypeCode;
    }

    public void setEduTypeCode(String eduTypeCode) {
        this.eduTypeCode = eduTypeCode;
    }

    public String getEduTypeName() {
        return eduTypeName;
    }

    public void setEduTypeName(String eduTypeName) {
        this.eduTypeName = eduTypeName;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
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