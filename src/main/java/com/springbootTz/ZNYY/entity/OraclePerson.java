package com.springbootTz.ZNYY.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import org.apache.ibatis.type.JdbcType;

@Data
@TableName("HUM_PSN_INFO")
public class OraclePerson {
    /**
     * 数据唯一记录号
     * 唯一索引，生成规则：医疗机构统一社会信用代码（18位）uscid+系统建设厂商代码sys_prdr_code+系统原始IDoriginal_id
     */
    @TableId(value = "RID", type = IdType.INPUT)
    private String rid;
    /** 医疗机构名称 */
    @TableField("ORG_NAME")
    private String orgName;
    /** 医疗机构统一社会信用代码 见公共字段【医疗机构统一社会信用代码】说明 */
    @TableField("USCID")
    private String uscid;
    /** 数据上传时间 复合主键，唯一索引，见公共字段【数据上传时间】说明 */
    @TableField(value = "UPLOAD_TIME", jdbcType = JdbcType.DATE)
    private Date uploadTime;
    /** 系统建设厂商代码 复合主键，系统建设厂商名称首字母大写 */
    @TableField("SYS_PRDR_CODE")
    private String sysPrdrCode;
    /** 系统建设厂商名称 见公共字段【系统建设厂商名称】说明 */
    @TableField("SYS_PRDR_NAME")
    private String sysPrdrName;
    /** 系统原始ID 复合主键，系统中记录的机构内人员记录的原始ID */
    @TableField("ORIGINAL_ID")
    private String originalId;
    /** 机构内人员姓名 */
    @TableField("STAFF_NAME")
    private String staffName;
    /** 机构内人员工号 */
    @TableField("STAFF_NO")
    private String staffNo;
    /** 身份证件类别代码 例如：居民身份证,居民户口簿,临时居民身份证,外国人护照,残疾人证等 */
    @TableField("PSNCERT_TYPE_CODE")
    private String psncertTypeCode;
    /** 身份证件类别名称 */
    @TableField("PSNCERT_TYPE_NAME")
    private String psncertTypeName;
    /** 身份证件号码 */
    @TableField("CERTNO")
    private String certno;
    /** 出生日期 */
    @TableField(value = "BRDY", jdbcType = JdbcType.DATE)
    private Date brdy;
    /** 性别代码 例如：男性、女性、未说明的性别等 */
    @TableField("GENDER_CODE")
    private String genderCode;
    /** 性别名称 */
    @TableField("GENDER_NAME")
    private String genderName;
    /** 民族代码 例如：汉族、蒙古族、回族、藏族等 */
    @TableField("NATION_CODE")
    private String nationCode;
    /** 民族名称 */
    @TableField("NATION_NAME")
    private String nationName;
    /** 居住地址详细地址 */
    @TableField("CURR_ADDR")
    private String currAddr;
    /** 本人电话号码 */
    @TableField("PSN_TEL")
    private String psnTel;
    /** 工作单位邮编 */
    @TableField("EMPR_POSCODE")
    private String emprPoscode;
    /** 政治面貌代码 例如：共产党、团员、国民党、群众等等 */
    @TableField("POLITICAL_CODE")
    private String politicalCode;
    /** 政治面貌名称 */
    @TableField("POLITICAL_NAME")
    private String politicalName;
    /** 入党团年月 */
    @TableField("JOIN_PARTY_YM")
    private String joinPartyYm;
    /** 科室代码 例如：预防保健科、全科医疗科、内科等 */
    @TableField("DEPT_CODE")
    private String deptCode;
    /** 科室名称 */
    @TableField("DEPT_NAME")
    private String deptName;
    /** 从事专业类别代码 例如：执业医师、执业助理医师、见习医师、注册护士、助产士等等 */
    @TableField("MAJOR_TYPE_CODE")
    private String majorTypeCode;
    /** 从事专业类别名称 */
    @TableField("MAJOR_TYPE_NAME")
    private String majorTypeName;
    /** 编制情况代码 例如：编制内、合同制、劳务派遣、参公管理 等等 */
    @TableField("PERSON_PROP_CODE")
    private String personPropCode;
    /** 编制情况名称 */
    @TableField("PERSON_PROP_NAME")
    private String personPropName;
    /** 劳务派遣公司名称 （劳务派遣人员填写） */
    @TableField("COME_FROM_ORG")
    private String comeFromOrg;
    /** 入伍单位 */
    @TableField("WORK_UNIT")
    private String workUnit;
    /** 入伍时间/参加工作年月 */
    @TableField("WORK_YM")
    private String workYm;
    /** 入现单位日期 */
    @TableField(value = "COME_HOS_DATE", jdbcType = JdbcType.DATE)
    private Date comeHosDate;
    /** 进本单位方式代码 例如：高等、中等院校毕业生、其他卫生机构调入、非卫生机构调入等等 */
    @TableField("COME_PROP_CODE")
    private String comePropCode;
    /** 进本单位方式名称 */
    @TableField("COME_PROP_NAME")
    private String comePropName;
    /** 流入形式代码 例如：调动、考录、公开招聘、选调生等等 */
    @TableField("COME_TYPE_CODE")
    private String comeTypeCode;
    /** 流入形式名称 */
    @TableField("COME_TYPE_NAME")
    private String comeTypeName;
    /** 行政/业务管理职务代码 例如：党委（副） 书记、单位行政负责人（正职）等等 */
    @TableField("DUTY_CODE")
    private String dutyCode;
    /** 行政/业务管理职务名称 */
    @TableField("DUTY_NAME")
    private String dutyName;
    /** 第一学历代码 例如：研究生教育、大学本科毕业、初中毕业等等 */
    @TableField("FIRST_EDU_BACKGROUND_CODE")
    private String firstEduBackgroundCode;
    /** 第一学历名称 */
    @TableField("FIRST_EDU_BACKGROUND_NAME")
    private String firstEduBackgroundName;
    /** 最高学历代码 例如：研究生教育、大学本科毕业、初中毕业等等 */
    @TableField("MAX_EDU_BACKGROUND_CODE")
    private String maxEduBackgroundCode;
    /** 最高学历名称 */
    @TableField("MAX_EDU_BACKGROUND_NAME")
    private String maxEduBackgroundName;
    /** 学位代码 例如：博士、硕士、学士等等 */
    @TableField("DEGREE_CODE")
    private String degreeCode;
    /** 学位名称 */
    @TableField("DEGREE_NAME")
    private String degreeName;
    /** 一级学科代码 例如：教育学、体育科学、统计学等等 */
    @TableField("FIRST_LEVEL_DISC_CODE")
    private String firstLevelDiscCode;
    /** 一级学科名称 */
    @TableField("FIRST_LEVEL_DISC_NAME")
    private String firstLevelDiscName;
    /** 所学专业代码 例如：哲学、经济学、法学等等 */
    @TableField("MAJOR_CODE")
    private String majorCode;
    /** 所学专业名称 */
    @TableField("MAJOR_NAME")
    private String majorName;
    /** 专科特长 （仅要求医院主任、副主任医师填写） */
    @TableField("LEVEL_SPECIAL")
    private String levelSpecial;
    /** 现取得专业技术资格（评）代码 例如：主任医师、副主任医师、医师等等 */
    @TableField("TECHNOLOGY_GET_CODE")
    private String technologyGetCode;
    /** 现取得专业技术资格（评）名称 */
    @TableField("TECHNOLOGY_GET_NAME")
    private String technologyGetName;
    /** 现取得专业技术资格（评）级别代码 例如：正高、基层正高、副高等等 */
    @TableField("TECHNOLOGY_GET_LEVEL_CODE")
    private String technologyGetLevelCode;
    /** 现取得专业技术资格（评）级别名称 */
    @TableField("TECHNOLOGY_GET_LEVEL_NAME")
    private String technologyGetLevelName;
    /** 现取得专业技术资格（评）年月 */
    @TableField("TECHNOLOGY_GET_YM")
    private String technologyGetYm;
    /** 专业技术职务（聘）代码 例如：卫生专业技术人员、律师、数学人员等等 */
    @TableField("PROFTECHTTL_APPO_CODE")
    private String proftechttlAppoCode;
    /** 专业技术职务（聘）名称 */
    @TableField("PROFTECHTTL_APPO_NAME")
    private String proftechttlAppoName;
    /** 专业技术岗职务（聘）级别代码 例如：正高、基层正高、副高等等 */
    @TableField("RES_PROFTECHTTL_CODE")
    private String resProftechttlCode;
    /** 专业技术岗职务（聘）级别名称 */
    @TableField("RES_PROFTECHTTL_NAME")
    private String resProftechttlName;
    /** 专业技术职务（聘）年月 */
    @TableField("PROFTECHTTL_APPO_YM")
    private String proftechttlAppoYm;
    /** 执业证号 */
    @TableField("PRACTICE_NUMBER")
    private String practiceNumber;
    /** 医师执业类别代码 例如：临床、口腔、公共卫生、中医等等 */
    @TableField("PRACTICE_TYPE_CODE")
    private String practiceTypeCode;
    /** 医师执业类别名称 */
    @TableField("PRACTICE_TYPE_NAME")
    private String practiceTypeName;
    /** 医师执业范围代码 例如：内科专业、外科专业、麻醉学专业、儿科专业等等 */
    @TableField("PRACTICE_SCOPE_CODE")
    private String practiceScopeCode;
    /** 医师执业范围名称 */
    @TableField("PRACTICE_SCOPE_NAME")
    private String practiceScopeName;
    /** 是否注册为多机构执业医师 1是 0否 */
    @TableField("IS_MANY_ORG_DOC")
    private String isManyOrgDoc;
    /** 第2执业单位的机构代码 */
    @TableField("SEC_ORG")
    private String secOrg;
    /** 第2执业单位的机构名称 */
    @TableField("SEC_ORG_NAME")
    private String secOrgName;
    /** 第3执业单位的机构代码 */
    @TableField("THRD_ORG")
    private String thrdOrg;
    /** 第3执业单位的机构名称 */
    @TableField("THRD_ORG_NAME")
    private String thrdOrgName;
    /** 是否注册为全科医学专业 1是 0否 */
    @TableField("IS_ALL_MAJOR")
    private String isAllMajor;
    /** 是否注册为乡村全科执业助理医师 1是 0否 */
    @TableField("IS_COUNTRY_DOC")
    private String isCountryDoc;
    /** 是否由乡镇卫生院或社区卫生服务机构派驻村卫生室工作 1是 0否 */
    @TableField("COMMUNITY_SERVICE_FLAG")
    private String communityServiceFlag;
    /** 从事乡村医生工作年限 */
    @TableField("WORK_YEARS_VALLIGE")
    private String workYearsVallige;
    /** 派驻村卫生室工作的时间（周） */
    @TableField(value = "WORK_COUNTRY_TIMER", jdbcType = JdbcType.DECIMAL)
    private BigDecimal workCountryTimer;
    /** 是否从事统计信息化业务工作 1是 0否 */
    @TableField("IS_INFORMATION_STATISTIAL")
    private String isInformationStatistial;
    /** 统计信息化业务工作代码 例如：综合管理、卫生统计等等 */
    @TableField("INFORMATION_STATISTIAL_CODE")
    private String informationStatistialCode;
    /** 统计信息化业务工作名称 */
    @TableField("INFORMATION_STATISTIAL_NAME")
    private String informationStatistialName;
    /** 高中及以下学历乡村医生是否为在职培训合格者 1是 0否 */
    @TableField("ON_WORK_TRAIN")
    private String onWorkTrain;
    /** 人员流出日期 */
    @TableField(value = "INOROUT_DATE", jdbcType = JdbcType.DATE)
    private Date inoroutDate;
    /** 聘用状态代码 例如：在职、调离、离退休等等 */
    @TableField("HIRE_STATUS_CODE")
    private String hireStatusCode;
    /** 聘用状态名称 */
    @TableField("HIRE_STATUS_NAME")
    private String hireStatusName;
    /** 人员流出形式代码 例如：调往其他卫生机构、考取研究生、出国留学、退休等等 */
    @TableField("OUT_TYPE_CODE")
    private String outTypeCode;
    /** 人员流出形式名称 */
    @TableField("OUT_TYPE_NAME")
    private String outTypeName;
    /** 人员流出地 */
    @TableField("OUTPLACE")
    private String outplace;
    /** 数据改造厂商名称 见公共字段【数据改造厂商名称】说明 */
    @TableField("DATA_CLCT_PRDR_NAME")
    private String dataClctPrdrName;
    /** 数据创建时间 见公共字段【数据创建时间】说明 */
    @TableField(value = "CRTE_TIME", jdbcType = JdbcType.DATE)
    private Date crteTime;
    /** 数据更新时间 见公共字段【数据更新时间】说明 */
    @TableField(value = "UPDT_TIME", jdbcType = JdbcType.DATE)
    private Date updtTime;
    /** 数据删除状态 见公共字段【数据删除状态】说明 */
    @TableField("DELETED")
    private String deleted;
    /** 数据删除时间 见公共字段【数据删除时间】说明 */
    @TableField(value = "DELETED_TIME", jdbcType = JdbcType.DATE)
    private Date deletedTime;

    public String getRid() {
        return rid;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getUscid() {
        return uscid;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public String getSysPrdrCode() {
        return sysPrdrCode;
    }

    public String getSysPrdrName() {
        return sysPrdrName;
    }

    public String getOriginalId() {
        return originalId;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public String getPsncertTypeCode() {
        return psncertTypeCode;
    }

    public String getPsncertTypeName() {
        return psncertTypeName;
    }

    public String getCertno() {
        return certno;
    }

    public Date getBrdy() {
        return brdy;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public String getGenderName() {
        return genderName;
    }

    public String getNationCode() {
        return nationCode;
    }

    public String getNationName() {
        return nationName;
    }

    public String getCurrAddr() {
        return currAddr;
    }

    public String getPsnTel() {
        return psnTel;
    }

    public String getEmprPoscode() {
        return emprPoscode;
    }

    public String getPoliticalCode() {
        return politicalCode;
    }

    public String getPoliticalName() {
        return politicalName;
    }

    public String getJoinPartyYm() {
        return joinPartyYm;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getMajorTypeCode() {
        return majorTypeCode;
    }

    public String getMajorTypeName() {
        return majorTypeName;
    }

    public String getPersonPropCode() {
        return personPropCode;
    }

    public String getPersonPropName() {
        return personPropName;
    }

    public String getComeFromOrg() {
        return comeFromOrg;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public String getWorkYm() {
        return workYm;
    }

    public Date getComeHosDate() {
        return comeHosDate;
    }

    public String getComePropCode() {
        return comePropCode;
    }

    public String getComePropName() {
        return comePropName;
    }

    public String getComeTypeCode() {
        return comeTypeCode;
    }

    public String getComeTypeName() {
        return comeTypeName;
    }

    public String getDutyCode() {
        return dutyCode;
    }

    public String getDutyName() {
        return dutyName;
    }

    public String getFirstEduBackgroundCode() {
        return firstEduBackgroundCode;
    }

    public String getFirstEduBackgroundName() {
        return firstEduBackgroundName;
    }

    public String getMaxEduBackgroundCode() {
        return maxEduBackgroundCode;
    }

    public String getMaxEduBackgroundName() {
        return maxEduBackgroundName;
    }

    public String getDegreeCode() {
        return degreeCode;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public String getFirstLevelDiscCode() {
        return firstLevelDiscCode;
    }

    public String getFirstLevelDiscName() {
        return firstLevelDiscName;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public String getLevelSpecial() {
        return levelSpecial;
    }

    public String getTechnologyGetCode() {
        return technologyGetCode;
    }

    public String getTechnologyGetName() {
        return technologyGetName;
    }

    public String getTechnologyGetLevelCode() {
        return technologyGetLevelCode;
    }

    public String getTechnologyGetLevelName() {
        return technologyGetLevelName;
    }

    public String getTechnologyGetYm() {
        return technologyGetYm;
    }

    public String getProftechttlAppoCode() {
        return proftechttlAppoCode;
    }

    public String getProftechttlAppoName() {
        return proftechttlAppoName;
    }

    public String getResProftechttlCode() {
        return resProftechttlCode;
    }

    public String getResProftechttlName() {
        return resProftechttlName;
    }

    public String getProftechttlAppoYm() {
        return proftechttlAppoYm;
    }

    public String getPracticeNumber() {
        return practiceNumber;
    }

    public String getPracticeTypeCode() {
        return practiceTypeCode;
    }

    public String getPracticeTypeName() {
        return practiceTypeName;
    }

    public String getPracticeScopeCode() {
        return practiceScopeCode;
    }

    public String getPracticeScopeName() {
        return practiceScopeName;
    }

    public String getIsManyOrgDoc() {
        return isManyOrgDoc;
    }

    public String getSecOrg() {
        return secOrg;
    }

    public String getSecOrgName() {
        return secOrgName;
    }

    public String getThrdOrg() {
        return thrdOrg;
    }

    public String getThrdOrgName() {
        return thrdOrgName;
    }

    public String getIsAllMajor() {
        return isAllMajor;
    }

    public String getIsCountryDoc() {
        return isCountryDoc;
    }

    public String getCommunityServiceFlag() {
        return communityServiceFlag;
    }

    public String getWorkYearsVallige() {
        return workYearsVallige;
    }

    public BigDecimal getWorkCountryTimer() {
        return workCountryTimer;
    }

    public String getIsInformationStatistial() {
        return isInformationStatistial;
    }

    public String getInformationStatistialCode() {
        return informationStatistialCode;
    }

    public String getInformationStatistialName() {
        return informationStatistialName;
    }

    public String getOnWorkTrain() {
        return onWorkTrain;
    }

    public Date getInoroutDate() {
        return inoroutDate;
    }

    public String getHireStatusCode() {
        return hireStatusCode;
    }

    public String getHireStatusName() {
        return hireStatusName;
    }

    public String getOutTypeCode() {
        return outTypeCode;
    }

    public String getOutTypeName() {
        return outTypeName;
    }

    public String getOutplace() {
        return outplace;
    }

    public String getDataClctPrdrName() {
        return dataClctPrdrName;
    }

    public Date getCrteTime() {
        return crteTime;
    }

    public Date getUpdtTime() {
        return updtTime;
    }

    public String getDeleted() {
        return deleted;
    }

    public Date getDeletedTime() {
        return deletedTime;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}