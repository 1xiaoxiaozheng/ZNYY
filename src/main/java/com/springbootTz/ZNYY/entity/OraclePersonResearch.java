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
 * 实体类：HUM_PSN_RESEARCH
 * 对应Oracle表HUM_PSN_RESEARCH
 */
@Data
@TableName("HUM_PSN_RESEARCH")
public class OraclePersonResearch implements Serializable {
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
    /** 课题代码 */
    @TableField("TOPIC_CODE")
    private String topicCode;
    /** 课题名称 */
    @TableField("TOPIC_NAME")
    private String topicName;
    /** 立项年度 */
    @TableField("PROJECT_YEAR")
    private Date projectYear;
    /** 科研开始日期 */
    @TableField("RESEARCH_BEGNDATE")
    private Date researchBegndate;
    /** 完成日期 */
    @TableField("FINISH_DATE")
    private Date finishDate;
    /** 科研经费 */
    @TableField("RESEARCH_FEE")
    private BigDecimal researchFee;
    /** 科研级别代码 */
    @TableField("RESEARCH_LEV_CODE")
    private String researchLevCode;
    /** 科研级别名称 */
    @TableField("RESEARCH_LEV_NAME")
    private String researchLevName;
    /** 参与人角色 */
    @TableField("RESEARCH_ROLE")
    private String researchRole;
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

    // Getter and Setter methods
    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getUscid() {
        return uscid;
    }

    public void setUscid(String uscid) {
        this.uscid = uscid;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    // 其他getter和setter方法由@Data注解自动生成
}