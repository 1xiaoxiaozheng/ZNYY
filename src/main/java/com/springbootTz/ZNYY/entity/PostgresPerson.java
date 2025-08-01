package com.springbootTz.ZNYY.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("ehr_org_person")
public class PostgresPerson {
    /** 主键id */
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
    /** 正式账号ID */
    private String accountId;
    /** 现居住地 */
    private String address;
    /** 人脸识别信息 */
    private String aiFace;
    /** 预置1 */
    private String auth1;
    /** 预置2 */
    private String auth2;
    /** 预置3 */
    private String auth3;
    /** 生育状态 */
    private Integer babyState;
    /** 入职前工龄时长 */
    private BigDecimal beforeStartWorkAgeTime;
    /** 创建时间 */
    private Timestamp birthday;
    /** 拉黑日期 */
    private Timestamp blackDate;
    /** 拉黑备注 */
    private String blackNotes;
    /** 拉黑原因 */
    private String blackReason;
    /** 分公司 */
    private String branchCompany;
    /** 调动人员id */
    private String changeId;
    /** 父id */
    private String changeParentId;
    /** 原始人员Id */
    private String changeSourceId;
    /** 调动日期 */
    private Timestamp changeTime;
    /** 改变类型 */
    private String changeType;
    /** 工作所在城市 */
    private String city;
    /** 端类型 */
    private String clientType;
    /** 司龄调整值 */
    private BigDecimal companyAgeAdjustMonth;
    /** 合同公司 */
    private String contractCompany;
    /** 合同签订时间 */
    private Timestamp contractCreateTime;
    /** 合同结束时间 */
    private Timestamp contractEndTime;
    /** 合同编码 */
    private String contractNumber;
    /** 合同开始时间 */
    private Timestamp contractStartTime;
    /** 合同类型 */
    private Integer contractType;
    /** 自定义字段 */
    private String customFields; // jsonb，建议用String或Map
    /** 点滴关怀id */
    private String ddghId;
    /** 删除标记 */
    private Long delFlag;
    /** 所属主部门ID，删除人员后部门ID为空，存在为空的情况 */
    private String deptId;
    /** 描述 */
    private String description;
    /** 学历 */
    private Integer educationType;
    /** 企业邮箱 */
    private String email;
    /** 离职申请日期 */
    private Timestamp endCreateTime;
    /** 离职原因 */
    private String endReason;
    /** 离职原因分类 */
    private String endReasonType;
    /** 薪资结算日 */
    private Timestamp endSalaryDay;
    /** 离职时间 */
    private Timestamp endTime;
    /** 预计离职时间 */
    private Timestamp expectEndTime;
    /** 预计退休时间 */
    private Timestamp expectRetireTime;
    /** 转正日期 */
    private Timestamp formalTime;
    /** 公积金账户 */
    private String fundAccount;
    /** 性别 */
    private Integer gender;
    /** 考勤居家打卡地址 */
    private String homeAddress;
    /** 户籍地址 */
    private String householdAddress;
    /** 户籍城市 */
    private String householdCity;
    /** 户口性质 */
    private Integer householdType;
    /** 证件类型 */
    private Integer idCardType;
    /** 证件号码 */
    private String idNumber;
    /** 邀请状态 */
    private Integer invitedState;
    /** 是否是单位管理员，roles中不包含单位管理员，用此属性记录 */
    private Integer isadmin;
    /** 是否拉入黑名单 */
    private Integer isBlack;
    /** 是否外部人员 */
    private Integer isOuter;
    /** 职级Id */
    private String jobGradeId;
    /** 职位信息，关联OrgJobObject对应表的ID */
    private String jobId;
    /** 职等 */
    private Integer jobLevel;
    /** 职位信息，关联OrgJobObject对应表的name */
    private String jobName;
    /** 职位序列 */
    private String jobSequenceId;
    /** 标签id以逗号隔开 */
    private String label;
    /** 干部类型 */
    private String leaderType;
    /** 离职状态 */
    private Long leaveState;
    /** 离职分类 */
    private Integer leaveSubState;
    /** 婚姻状况 */
    private Integer maritalState;
    /** 所属多维组织部门ID和维度ID */
    private String multiOrg; // jsonb，建议用String或Map
    /** 该单位下员工姓名 */
    private String name;
    /** 民族 */
    private String nationType;
    /** 籍贯 */
    private String nativePlace;
    /** 新员工入职负责人Id,用在入职管理列表，如果为空代表没有负责人所有人事管理员都能管理 */
    private String newPersonChargerId;
    /** 新员工登记表模板Id */
    private String newRegTemplateId;
    /** 放弃入职原因 */
    private String notJoinReason;
    /** 工号 */
    private String number;
    /** 办公电话 */
    private String officePhone;
    /** 排序号 */
    private Integer orderNo;
    /** 主部门里的人员排序号 */
    private Long orgOrder;
    /** 外部组织 */
    private String outerDeptId;
    /** 人员编号 */
    private String outerNumber;
    /** 加入时间 */
    private Timestamp outerStartTime;
    /** 该单位下的手机号 */
    private String phone;
    /** 政治面貌 */
    private Integer politicalType;
    /** 待入职标签id以逗号隔开 */
    private String regLabel;
    /** 直接上级 */
    private String reportPersonId;
    /** 间断工龄时长 */
    private BigDecimal restWorkTime;
    /** 退休申请日期 */
    private Timestamp retireCreateTime;
    /** 退休原因 */
    private String retireReason;
    /** 退休日期 */
    private Timestamp retireTime;
    /** 退休类型 */
    private Integer retireType;
    /** 所属角色信息，roles中不包含单位管理员 */
    private String roles;
    /** 工资卡开户行 */
    private String salaryCardBank;
    /** 工资卡开户城市 */
    private String salaryCardCity;
    /** 工资卡号 */
    private String salaryCardNumber;
    /** 社保账户 */
    private String socialSecurityAccount;
    /** 来源 */
    private Integer sourceType;
    /** 入职集团时间 */
    private Timestamp startGroupTime;
    /** 入职时间 */
    private Timestamp startTime;
    /** 首次参加工作时间 */
    private Timestamp startWorkTime;
    /** 人员状态 */
    private Integer state;
    /** 兼职部门列表 */
    private String subDepts;
    /** 职称 */
    private String technicalTitle;
    /** thirdId */
    private String thirdId;
    /** 魔学院id */
    private String trainingId;
    /** 试用期 0-6月 */
    private Integer trialMonth;
    /** 工作性质 */
    private Integer workType;
    /** 是否死亡 */
    private Integer deathState;
    /** 死亡时间 */
    private Timestamp deathTime;
    /** 返聘结束时间 */
    private Timestamp rehireEndTime;
    /** 返聘状态 */
    private Integer rehireState;
    /** 返聘时间 */
    private Timestamp rehireTime;

    public String getId() {
        return id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getOrgId() {
        return orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public String getModifiedId() {
        return modifiedId;
    }

    public String getModifiedName() {
        return modifiedName;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAddress() {
        return address;
    }

    public String getAiFace() {
        return aiFace;
    }

    public String getAuth1() {
        return auth1;
    }

    public String getAuth2() {
        return auth2;
    }

    public String getAuth3() {
        return auth3;
    }

    public Integer getBabyState() {
        return babyState;
    }

    public BigDecimal getBeforeStartWorkAgeTime() {
        return beforeStartWorkAgeTime;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public Timestamp getBlackDate() {
        return blackDate;
    }

    public String getBlackNotes() {
        return blackNotes;
    }

    public String getBlackReason() {
        return blackReason;
    }

    public String getBranchCompany() {
        return branchCompany;
    }

    public String getChangeId() {
        return changeId;
    }

    public String getChangeParentId() {
        return changeParentId;
    }

    public String getChangeSourceId() {
        return changeSourceId;
    }

    public Timestamp getChangeTime() {
        return changeTime;
    }

    public String getChangeType() {
        return changeType;
    }

    public String getCity() {
        return city;
    }

    public String getClientType() {
        return clientType;
    }

    public BigDecimal getCompanyAgeAdjustMonth() {
        return companyAgeAdjustMonth;
    }

    public String getContractCompany() {
        return contractCompany;
    }

    public Timestamp getContractCreateTime() {
        return contractCreateTime;
    }

    public Timestamp getContractEndTime() {
        return contractEndTime;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public Timestamp getContractStartTime() {
        return contractStartTime;
    }

    public Integer getContractType() {
        return contractType;
    }

    public String getCustomFields() {
        return customFields;
    }

    public String getDdghId() {
        return ddghId;
    }

    public Long getDelFlag() {
        return delFlag;
    }

    public String getDeptId() {
        return deptId;
    }

    public String getDescription() {
        return description;
    }

    public Integer getEducationType() {
        return educationType;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getEndCreateTime() {
        return endCreateTime;
    }

    public String getEndReason() {
        return endReason;
    }

    public String getEndReasonType() {
        return endReasonType;
    }

    public Timestamp getEndSalaryDay() {
        return endSalaryDay;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public Timestamp getExpectEndTime() {
        return expectEndTime;
    }

    public Timestamp getExpectRetireTime() {
        return expectRetireTime;
    }

    public Timestamp getFormalTime() {
        return formalTime;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public Integer getGender() {
        return gender;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getHouseholdAddress() {
        return householdAddress;
    }

    public String getHouseholdCity() {
        return householdCity;
    }

    public Integer getHouseholdType() {
        return householdType;
    }

    public Integer getIdCardType() {
        return idCardType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public Integer getInvitedState() {
        return invitedState;
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public Integer getIsBlack() {
        return isBlack;
    }

    public Integer getIsOuter() {
        return isOuter;
    }

    public String getJobGradeId() {
        return jobGradeId;
    }

    public String getJobId() {
        return jobId;
    }

    public Integer getJobLevel() {
        return jobLevel;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobSequenceId() {
        return jobSequenceId;
    }

    public String getLabel() {
        return label;
    }

    public String getLeaderType() {
        return leaderType;
    }

    public Long getLeaveState() {
        return leaveState;
    }

    public Integer getLeaveSubState() {
        return leaveSubState;
    }

    public Integer getMaritalState() {
        return maritalState;
    }

    public String getMultiOrg() {
        return multiOrg;
    }

    public String getName() {
        return name;
    }

    public String getNationType() {
        return nationType;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public String getNewPersonChargerId() {
        return newPersonChargerId;
    }

    public String getNewRegTemplateId() {
        return newRegTemplateId;
    }

    public String getNotJoinReason() {
        return notJoinReason;
    }

    public String getNumber() {
        return number;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public Long getOrgOrder() {
        return orgOrder;
    }

    public String getOuterDeptId() {
        return outerDeptId;
    }

    public String getOuterNumber() {
        return outerNumber;
    }

    public Timestamp getOuterStartTime() {
        return outerStartTime;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getPoliticalType() {
        return politicalType;
    }

    public String getRegLabel() {
        return regLabel;
    }

    public String getReportPersonId() {
        return reportPersonId;
    }

    public BigDecimal getRestWorkTime() {
        return restWorkTime;
    }

    public Timestamp getRetireCreateTime() {
        return retireCreateTime;
    }

    public String getRetireReason() {
        return retireReason;
    }

    public Timestamp getRetireTime() {
        return retireTime;
    }

    public Integer getRetireType() {
        return retireType;
    }

    public String getRoles() {
        return roles;
    }

    public String getSalaryCardBank() {
        return salaryCardBank;
    }

    public String getSalaryCardCity() {
        return salaryCardCity;
    }

    public String getSalaryCardNumber() {
        return salaryCardNumber;
    }

    public String getSocialSecurityAccount() {
        return socialSecurityAccount;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public Timestamp getStartGroupTime() {
        return startGroupTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getStartWorkTime() {
        return startWorkTime;
    }

    public Integer getState() {
        return state;
    }

    public String getSubDepts() {
        return subDepts;
    }

    public String getTechnicalTitle() {
        return technicalTitle;
    }

    public String getThirdId() {
        return thirdId;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public Integer getTrialMonth() {
        return trialMonth;
    }

    public Integer getWorkType() {
        return workType;
    }

    public Integer getDeathState() {
        return deathState;
    }

    public Timestamp getDeathTime() {
        return deathTime;
    }

    public Timestamp getRehireEndTime() {
        return rehireEndTime;
    }

    public Integer getRehireState() {
        return rehireState;
    }

    public Timestamp getRehireTime() {
        return rehireTime;
    }
}