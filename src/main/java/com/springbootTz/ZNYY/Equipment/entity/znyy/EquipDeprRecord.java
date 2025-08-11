package com.springbootTz.ZNYY.Equipment.entity.znyy;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import org.apache.ibatis.type.JdbcType;

@Data
@TableName("equip_depr_record")
public class EquipDeprRecord {
    /**
     * 数据唯一记录号
     * 唯一索引，生成规则：医疗机构统一社会信用代码（18位）uscid+系统建设厂商代码sys_prdr_code+折旧月depr_month+设备卡片号equip_card_no
     */
    @TableId(value = "rid", type = IdType.INPUT)
    private String rid;

    /** 医疗机构名称 */
    @TableField("org_name")
    private String orgName;

    /** 医疗机构统一社会信用代码 复合主键，见公共字段【医疗机构统一社会信用代码】说明 */
    @TableField("uscid")
    private String uscid;

    /** 数据上传时间 复合主键，唯一索引，见公共字段【数据上传时间】说明 */
    @TableField(value = "upload_time", jdbcType = JdbcType.DATE)
    private Date uploadTime;

    /** 系统建设厂商代码 复合主键，系统建设厂商名称首字母大写 */
    @TableField("sys_prdr_code")
    private String sysPrdrCode;

    /** 系统建设厂商名称 见公共字段【系统建设厂商名称】说明 */
    @TableField("sys_prdr_name")
    private String sysPrdrName;

    /** 折旧月 复合主键，固定资产开始计提折旧的月份 */
    @TableField("depr_month")
    private String deprMonth;

    /** 设备卡片号 复合主键 */
    @TableField("equip_card_no")
    private String equipCardNo;

    /**
     * 设备代码
     * 例如：800mA及以上数字减影血管造影X线机,800mA及以上医用X线诊断机（不含DSA),500-800mA医用X线诊断机,移动式X线诊断机等等
     */
    @TableField("equip_code")
    private String equipCode;

    /** 设备名称 */
    @TableField("equip_name")
    private String equipName;

    /** 折旧期间 开始计提折旧时依次顺延的以年为单位的时间 */
    @TableField("depr_period")
    private Integer deprPeriod;

    /** 资金来源代码 */
    @TableField("funds_souc_code")
    private String fundsSoucCode;

    /** 资金来源名称 */
    @TableField("funds_souc_name")
    private String fundsSoucName;

    /** 使用科室代码 */
    @TableField("use_dept_code")
    private String useDeptCode;

    /** 使用科室名称 */
    @TableField("use_dept_name")
    private String useDeptName;

    /** 本期折旧 */
    @TableField("current_depr")
    private BigDecimal currentDepr;

    /** 累计折旧金额 */
    @TableField("depr_cum_amt")
    private BigDecimal deprCumAmt;

    /** 操作人姓名 操作人员姓名 */
    @TableField("operator_name")
    private String operatorName;

    /** 处理日期 固定资产折旧处理日期 */
    @TableField(value = "deal_date", jdbcType = JdbcType.DATE)
    private Date dealDate;

    /** 是否生成凭证 1是，0否 */
    @TableField("create_cert_flag")
    private String createCertFlag;

    /** 生成凭证日期 凭证的生成日期 */
    @TableField(value = "create_cert_date", jdbcType = JdbcType.DATE)
    private Date createCertDate;

    /** 是否计提成本 */
    @TableField("accrued_cost_flag")
    private String accruedCostFlag;

    /** 计提成本日期 计提成本的开始时间 */
    @TableField(value = "accrued_cost_date", jdbcType = JdbcType.DATE)
    private Date accruedCostDate;

    /** 使用折旧方法 */
    @TableField("depr_mean")
    private String deprMean;

    /** 使用折旧方法名称 */
    @TableField("depr_mean_name")
    private String deprMeanName;

    /** 仓库代码 */
    @TableField("stroom_code")
    private String stroomCode;

    /** 仓库名称 */
    @TableField("stroom_name")
    private String stroomName;

    /** 月折旧率 月度会计期间资产折旧比例 */
    @TableField("deprec_rate")
    private BigDecimal deprecRate;

    /** 修改标志 0:正常; 1:撤销 */
    @TableField("state")
    private String state;

    /** 预留一 为系统处理该数据而预留 */
    @TableField("reserve1")
    private String reserve1;

    /** 预留二 为系统处理该数据而预留 */
    @TableField("reserve2")
    private String reserve2;

    /** 数据改造厂商名称 见公共字段【数据改造厂商名称】说明 */
    @TableField("data_clct_prdr_name")
    private String dataClctPrdrName;

    /** 数据创建时间 见公共字段【数据创建时间】说明 */
    @TableField(value = "crte_time", jdbcType = JdbcType.DATE)
    private Date crteTime;

    /** 数据更新时间 见公共字段【数据更新时间】说明 */
    @TableField(value = "updt_time", jdbcType = JdbcType.DATE)
    private Date updtTime;

    /** 数据删除状态 见公共字段【数据删除状态】说明 */
    @TableField("deleted")
    private String deleted;

    /** 数据删除时间 见公共字段【数据删除时间】说明 */
    @TableField(value = "deleted_time", jdbcType = JdbcType.DATE)
    private Date deletedTime;
}
