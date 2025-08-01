package com.springbootTz.ZNYY.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类：HUM_PSN_HEIGTH_AWARD
 * 对应Oracle表HUM_PSN_HEIGTH_AWARD
 */
@Data
@TableName("\"HUM_PSN_HEIGTH_AWARD\"")
public class OraclePersonHeigthAward implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 数据唯一记录号 */
    @TableId("RID")
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
    /** 数据改造厂商名称 */
    @TableField("DATA_CLCT_PRDR_NAME")
    private String dataClctPrdrName;
    /** 系统原始ID */
    @TableField("ORIGINAL_ID")
    private String originalId;
    /** 员工ID */
    @TableField("STAFF_ID")
    private String staffId;
    /** 科技奖励级别代码 */
    @TableField("SCIENCE_AWARDS_GRADE_CODE")
    private String scienceAwardsGradeCode;
    /** 科技奖励级别名称 */
    @TableField("SCIENCE_AWARDS_GRADE_NAME")
    private String scienceAwardsGradeName;
    /** 证书编号 */
    @TableField("AWARDS_NO")
    private String awardsNo;
    /** 科技奖励项目 */
    @TableField("AWARDS_NAME")
    private String awardsName;
    /** 获得时间 */
    @TableField("AWARDS_TIME")
    private Date awardsTime;
    /** 授予单位 */
    @TableField("AWARDS_UNIT")
    private String awardsUnit;
    /** 获奖排名 */
    @TableField("MEMBER_SORT")
    private Long memberSort;
    /** 描述 */
    @TableField("AWARDS_DEMO")
    private String awardsDemo;
    /** 机构内人员工号 */
    @TableField("STAFF_NO")
    private String staffNo;
    /** 机构内人员姓名 */
    @TableField("STAFF_NAME")
    private String staffName;
    /** 科室代码 */
    @TableField("DEPT_CODE")
    private String deptCode;
    /** 科室名称 */
    @TableField("DEPT_NAME")
    private String deptName;
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

    // Getters and Setters
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

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}