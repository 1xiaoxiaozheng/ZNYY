package com.springbootTz.ZNYY.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 实体类：ehr_org_person_detail_contract
 * 对应PostgreSQL表ehr_org_person_detail_contract
 */
@Data
@TableName("ehr_org_person_detail_contract")
public class PostgresPersonDetailContract implements Serializable {
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

    /** 是否续签 */
    private Integer continued;

    /** 合同附件 */
    private String contractAttachments;

    /** 合同公司 */
    private String contractCompany;

    /** 合同创建时间 */
    private Timestamp contractCreateTime;

    /** 合同期限（月） */
    private Integer contractDueTime;

    /** 合同结束时间 */
    private Timestamp contractEndTime;

    /** 合同编号 */
    private String contractNumber;

    /** 合同开始时间 */
    private Timestamp contractStartTime;

    /** 合同中止时间 */
    private Timestamp contractStopTime;

    /** 合同类型 */
    private Integer contractType;

    /** 备注 */
    private String des;
}