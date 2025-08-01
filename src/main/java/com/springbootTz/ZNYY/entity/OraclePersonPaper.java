package com.springbootTz.ZNYY.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 实体类：HUM_PSN_PAPER
 * 对应Oracle表HUM_PSN_PAPER
 */
@Data
@TableName("HUM_PSN_PAPER")
public class OraclePersonPaper implements Serializable {
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
    /** 论文发表日期 */
    @TableField("PAPER_DATE")
    private Date paperDate;
    /** 刊物名称 */
    @TableField("PERIODICAL_NAME")
    private String periodicalName;
    /** 刊物级别代码 */
    @TableField("PERIODICAL_LEV_CODE")
    private String periodicalLevCode;
    /** 刊物级别名称 */
    @TableField("PERIODICAL_LEV_NAME")
    private String periodicalLevName;
    /** 论文标题 */
    @TableField("PAPER_TITLE")
    private String paperTitle;
    /** 是否SCI收录 */
    @TableField("IS_SCI")
    private String isSci;
    /** SCI论文影响因子 */
    @TableField("PAPER_FACTORS")
    private String paperFactors;
    /** 作者排名 */
    @TableField("PAPER_SORT")
    private String paperSort;
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