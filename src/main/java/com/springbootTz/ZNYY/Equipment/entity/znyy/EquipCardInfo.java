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
@TableName("equip_card_info")
public class EquipCardInfo {
    /**
     * 数据唯一记录号
     * 唯一索引，生成规则：医疗机构统一社会信用代码（18位）uscid+系统建设厂商代码sys_prdr_code+设备卡片记录单card_recno
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

    /** 设备卡片记录单 复合主键，全表唯一标识码，保证唯一 */
    @TableField("card_recno")
    private String cardRecno;

    /** 设备卡片号 */
    @TableField("equip_card_no")
    private String equipCardNo;

    /** 单据号 */
    @TableField("apply_no")
    private String applyNo;

    /** 单据序号 */
    @TableField("bill_sub_no")
    private String billSubNo;

    /** 批次 */
    @TableField(value = "batch_no", jdbcType = JdbcType.DATE)
    private Date batchNo;

    /** 设备代码 系统中标识一个设备唯一代码 */
    @TableField("equip_code")
    private String equipCode;

    /** 设备名称 */
    @TableField("equip_name")
    private String equipName;

    /** 购入金额 */
    @TableField(value = "buy_cost", jdbcType = JdbcType.NUMERIC)
    private BigDecimal buyCost;

    /** 当前金额 */
    @TableField(value = "now_cost", jdbcType = JdbcType.NUMERIC)
    private BigDecimal nowCost;

    /** 购买日期 */
    @TableField(value = "buy_date", jdbcType = JdbcType.DATE)
    private Date buyDate;

    /** 启用日期 */
    @TableField(value = "start_use_date", jdbcType = JdbcType.DATE)
    private Date startUseDate;

    /** 到期日期 */
    @TableField(value = "expire_date", jdbcType = JdbcType.DATE)
    private Date expireDate;

    /** 使用科室代码 */
    @TableField("use_dept_code")
    private String useDeptCode;

    /** 使用科室名称 */
    @TableField("use_dept_name")
    private String useDeptName;

    /** 使用年限 */
    @TableField("useful_life")
    private Integer usefulLife;

    /** 生产厂商代码 生产厂商编码 */
    @TableField("manufacturer_code")
    private String manufacturerCode;

    /** 生产厂商名称 */
    @TableField("manufacturer_name")
    private String manufacturerName;

    /** 出厂编号 */
    @TableField("manufacture_no")
    private String manufactureNo;

    /** 采购人员 */
    @TableField("purchase_operator")
    private String purchaseOperator;

    /** 验收人员 */
    @TableField("accept_operator")
    private String acceptOperator;

    /** 管理人员 */
    @TableField("manage_operator")
    private String manageOperator;

    /** 发票号 */
    @TableField("invo_no")
    private String invoNo;

    /** 设备医院编码 */
    @TableField("equip_hospital_code")
    private String equipHospitalCode;

    /** 计量编码 */
    @TableField("measure_code")
    private String measureCode;

    /** 检定周期 */
    @TableField("retest_period")
    private String retestPeriod;

    /** 检定单位 */
    @TableField("retest_unit")
    private String retestUnit;

    /** 财政资金 */
    @TableField(value = "finance_fund", jdbcType = JdbcType.NUMERIC)
    private BigDecimal financeFund;

    /** 科教资金 */
    @TableField(value = "science_fund", jdbcType = JdbcType.NUMERIC)
    private BigDecimal scienceFund;

    /** 自有资金 */
    @TableField(value = "self_fund", jdbcType = JdbcType.NUMERIC)
    private BigDecimal selfFund;

    /** 领用单号 */
    @TableField("receive_no")
    private String receiveNo;

    /** 领用日期 */
    @TableField(value = "receive_date", jdbcType = JdbcType.DATE)
    private Date receiveDate;

    /** 领用人员 */
    @TableField("receive_operator")
    private String receiveOperator;

    /** 房屋面积 */
    @TableField(value = "house_area_square", jdbcType = JdbcType.DECIMAL)
    private BigDecimal houseAreaSquare;

    /** 折旧起始日期 */
    @TableField(value = "deprec_start_date", jdbcType = JdbcType.DATE)
    private Date deprecStartDate;

    /** 折旧标志 1是，0否 */
    @TableField("deprec_flag")
    private String deprecFlag;

    /** 折旧方式代码 */
    @TableField("deprec_type_code")
    private String deprecTypeCode;

    /** 折旧方式名称 */
    @TableField("deprec_type_name")
    private String deprecTypeName;

    /** 月折旧率 */
    @TableField(value = "deprec_rate", jdbcType = JdbcType.NUMERIC)
    private BigDecimal deprecRate;

    /** 月折旧金额 */
    @TableField(value = "mon_derp_amt", jdbcType = JdbcType.NUMERIC)
    private BigDecimal monDerpAmt;

    /** 净残值率 */
    @TableField(value = "net_salvage_rate", jdbcType = JdbcType.DECIMAL)
    private BigDecimal netSalvageRate;

    /** 净残值金额 */
    @TableField(value = "net_salvage_cost", jdbcType = JdbcType.DECIMAL)
    private BigDecimal netSalvageCost;

    /** 设备状态代码 */
    @TableField("equip_status_code")
    private String equipStatusCode;

    /** 设备状态名称 */
    @TableField("equip_status_name")
    private String equipStatusName;

    /** 审核标志 0:正常; 1:撤销 */
    @TableField("audit_flag")
    private String auditFlag;

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
