package com.springbootTz.ZNYY.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 实体类：HUM_PSN_WORK
 * 对应Oracle表HUM_PSN_WORK
 */
@Data
@TableName("HUM_PSN_WORK")
public class OraclePersonWork implements Serializable {
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
    /** 著作名称 */
    @TableField("WORK_NAME")
    private String workName;
    /** 著作类型代码 */
    @TableField("WORK_TYPE_CODE")
    private String workTypeCode;
    /** 著作类型名称 */
    @TableField("WORK_TYPE_NAME")
    private String workTypeName;
    /** 出版社 */
    @TableField("WORK_PUBLISH")
    private String workPublish;
    /** 出版日期 */
    @TableField("WORK_YEAR")
    private Date workYear;
    /** 个人撰写字数 */
    @TableField("WORK_FONTS")
    private BigDecimal workFonts;
    /** 著作总字数 */
    @TableField("WORK_WORDS")
    private BigDecimal workWords;
    /** 著作身份 */
    @TableField("RESEARCH_ID")
    private String researchId;
    /** 机构内人员工号 */
    @TableField("STAFF_NO")
    private String staffNo;
    /** 机构内人员姓名 */
    @TableField("STAFF_NAME")
    private String staffName;
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