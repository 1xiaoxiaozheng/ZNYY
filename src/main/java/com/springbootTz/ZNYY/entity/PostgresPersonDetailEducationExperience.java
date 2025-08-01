package com.springbootTz.ZNYY.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 实体类：ehr_org_person_detail_education_experience
 * 对应PostgreSQL表ehr_org_person_detail_education_experience
 */
@Data
@TableName("ehr_org_person_detail_education_experience")
public class PostgresPersonDetailEducationExperience implements Serializable {
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

    /** 学位类型 */
    private Integer degreeType;

    /** 备注 */
    private String des;

    /** 学历类型 */
    private Integer educationType;

    /** 结束时间 */
    private Timestamp endTime;

    /** 学习类型 */
    private Integer learnType;

    /** 专业 */
    private String major;

    /** 学校 */
    private String school;

    /** 开始时间 */
    private Timestamp startTime;

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

    public Integer getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(Integer degreeType) {
        this.degreeType = degreeType;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getEducationType() {
        return educationType;
    }

    public void setEducationType(Integer educationType) {
        this.educationType = educationType;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getLearnType() {
        return learnType;
    }

    public void setLearnType(Integer learnType) {
        this.learnType = learnType;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
}