package com.springbootTz.ZNYY.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 实体类：HUM_STAFF_CORP
 * 对应Oracle表HUM_STAFF_CORP
 */
@Data
@TableName("HUM_STAFF_CORP")
public class OracleStaffCorp implements Serializable {
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
    /** 社团名称 */
    @TableField("CORP_NAME")
    private String corpName;
    /** 社团级别代码 */
    @TableField("CORP_LEVEL_CODE")
    private String corpLevelCode;
    /** 社团级别名称 */
    @TableField("CORP_LEVEL_NAME")
    private String corpLevelName;
    /** 兼职届数 */
    @TableField("DUTY_COUNT")
    private String dutyCount;
    /** 描述 */
    @TableField("AWARDS_DEMO")
    private String awardsDemo;
    /** 批准文号 */
    @TableField("APRVNO")
    private String aprvno;
    /** 聘任（担任）职务 */
    @TableField("EMP_PROFTECHTTL")
    private String empProftechttl;
    /** 开始日期 */
    @TableField("BEGNDATE")
    private Date begndate;
    /** 结束日期 */
    @TableField("ENDDATE")
    private Date enddate;
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
}