package com.springbootTz.ZNYY.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 实体类：ehr_org_person_detail_training
 * 对应PostgreSQL表ehr_org_person_detail_training
 */
@Data
@TableName("ehr_org_person_detail_training")
public class PostgresPersonDetailTraining implements Serializable {
    /** 主键id */
    @TableId
    private String id;

    /** 创建时间 */
    private Timestamp createTime;

    /** 记录集团的Id */
    private String groupId;

    /** 单位ID */
    private String orgId;

    /** 单位名称 */
    private String orgName;

    /** 创建人ID */
    private String creatorId;

    /** 创建人姓名 */
    private String creatorName;

    /** 最后修改人ID */
    private String modifiedId;

    /** 最后修改人名称 */
    private String modifiedName;

    /** 最后修改时间 */
    private Timestamp modifyTime;

    /** 删除标记(1正常,2回收站,3永久删除) */
    private Integer delFlag;

    /** 自定义字段 */
    private String customFields;

    /** 人员ID */
    private String personId;

    /** 排序 */
    private Integer sort;

    /** 是否同步到基础库 */
    private Integer sync2basic;

    /** 证书名称 */
    private String certName;

    /** 证书编号 */
    private String certNo;

    /** 培训单位 */
    private String company;

    /** 备注 */
    private String des;

    /** 结束时间 */
    private Timestamp endTime;

    /** 培训学时 */
    private String hours;

    /** 培训名称 */
    private String name;

    /** 培训结果 */
    private String result;

    /** 开始时间 */
    private Timestamp startTime;

    /** 培训时间（字符串） */
    private String time;

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getModifiedId() {
        return modifiedId;
    }

    public void setModifiedId(String modifiedId) {
        this.modifiedId = modifiedId;
    }

    public String getModifiedName() {
        return modifiedName;
    }

    public void setModifiedName(String modifiedName) {
        this.modifiedName = modifiedName;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCustomFields() {
        return customFields;
    }

    public void setCustomFields(String customFields) {
        this.customFields = customFields;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSync2basic() {
        return sync2basic;
    }

    public void setSync2basic(Integer sync2basic) {
        this.sync2basic = sync2basic;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // 添加jobName字段的getter方法，用于映射
    public String getJobName() {
        return name; // 使用培训名称作为jobName
    }
}