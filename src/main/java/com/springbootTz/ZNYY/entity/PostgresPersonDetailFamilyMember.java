package com.springbootTz.ZNYY.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 实体类：ehr_org_person_detail_family_member
 * 对应PostgreSQL表ehr_org_person_detail_family_member
 */
@Data
@TableName("ehr_org_person_detail_family_member")
public class PostgresPersonDetailFamilyMember implements Serializable {
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

    /** 出生日期 */
    private Timestamp birthdate;

    /** 生日 */
    private Timestamp birthday;

    /** 工作单位 */
    private String company;

    /** 家庭成员身份证号 */
    private String memberIdNumber;

    /** 家庭成员编号 */
    private String memberNumber;

    /** 姓名 */
    private String name;

    /** 政治面貌 */
    private Integer politicalType;

    /** 关系 */
    private Integer relation;
}