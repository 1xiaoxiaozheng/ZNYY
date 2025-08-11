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
@TableName("equip_discarded_record")
public class EquipDiscardedRecord {
    /**
     * 数据唯一记录号
     * 唯一索引，生成规则：医疗机构统一社会信用代码（18位）uscid+系统建设厂商代码sys_prdr_code+报废单号discarded_no
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

    /** 报废单号 复合主键，系统标识报废的唯一标识码 */
    @TableField("discarded_no")
    private String discardedNo;

    /**
     * 设备代码
     * 例如：800mA及以上数字减影血管造影X线机,800mA及以上医用X线诊断机（不含DSA),500-800mA医用X线诊断机,移动式X线诊断机等等
     */
    @TableField("equip_code")
    private String equipCode;

    /** 设备名称 */
    @TableField("equip_name")
    private String equipName;

    /** 项目规格 设备的出厂规格 */
    @TableField("spec")
    private String spec;

    /** 设备型号 注册证上注明的出厂型号 */
    @TableField("equip_model")
    private String equipModel;

    /** 计量单位 遵循《GB3100-93》标准 */
    @TableField("unit")
    private String unit;

    /** 计量单位名称 */
    @TableField("unit_name")
    private String unitName;

    /** 使用部门 */
    @TableField("use_dep")
    private String useDep;

    /** 设备单价 固定资产设备的单价 */
    @TableField("equip_pric")
    private BigDecimal equipPric;

    /** 采购日期 采购资产的合同或协议日期 */
    @TableField(value = "purc_date", jdbcType = JdbcType.DATE)
    private Date purcDate;

    /** 已用年限 固定资产已用年限 */
    @TableField("used_life")
    private Integer usedLife;

    /** 估计残值 指被评估资产在清理报废时净收回的金额 */
    @TableField("estima_residual_value")
    private BigDecimal estimaResidualValue;

    /** 报废原因 报废的原因描述 */
    @TableField("discarded_rea")
    private String discardedRea;

    /** 申请人姓名 申请人员姓名 */
    @TableField("applyer_name")
    private String applyerName;

    /** 申请日期 */
    @TableField(value = "apply_date", jdbcType = JdbcType.DATE)
    private Date applyDate;

    /** 审核人姓名 单位或机构某项运营活动或单据的执行审核工作的人员 */
    @TableField("audit_operator_name")
    private String auditOperatorName;

    /** 审核日期 单位或机构某项运营活动或单据的执行审核工作的日期 */
    @TableField(value = "audit_date", jdbcType = JdbcType.DATE)
    private Date auditDate;

    /** 生产厂商代码 标记资产的生产厂商的唯一代码 */
    @TableField("manufacturer_code")
    private String manufacturerCode;

    /** 生产厂商名称 注册证上名称 */
    @TableField("manufacturer_name")
    private String manufacturerName;

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
