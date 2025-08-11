package com.springbootTz.ZNYY.Equipment.entity.znyy;

import lombok.Data;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import org.apache.ibatis.type.JdbcType;

@Data
@TableName("equip_reg_info")
public class EquipRegInfo {
    /**
     * 数据唯一记录号
     * 唯一索引，生成规则：医疗机构统一社会信用代码（18位）uscid+系统建设厂商代码sys_prdr_code+设备代码equip_code
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

    /** 设备代码 复合主键，系统中标识一个设备唯一代码 */
    @TableField("equip_code")
    private String equipCode;

    /** 设备名称 */
    @TableField("equip_name")
    private String equipName;

    /** 类别代码 遵循《GB/T14885-2010》标准 */
    @TableField("fixed_assets_type")
    private String fixedAssetsType;

    /** 类别名称 */
    @TableField("fixed_assets_name")
    private String fixedAssetsName;

    /** 项目规格 */
    @TableField("spec")
    private String spec;

    /** 设备型号 设备的型号 */
    @TableField("equip_model")
    private String equipModel;

    /** 计量单位 遵循《GB3100-93》标准 */
    @TableField("unit")
    private String unit;

    /** 计量单位名称 */
    @TableField("unit_name")
    private String unitName;

    /** 停用标志 1是，0否 */
    @TableField("disable_flag")
    private String disableFlag;

    /** 生产厂商代码 生产厂商编码 */
    @TableField("manufacturer_code")
    private String manufacturerCode;

    /** 生产厂商名称 生产厂商名称 */
    @TableField("manufacturer_name")
    private String manufacturerName;

    /** 设备使用年限 使用年限 */
    @TableField(value = "dev_useful_life", jdbcType = JdbcType.DATE)
    private Date devUsefulLife;

    /** 产地信息 产地 */
    @TableField("prodplac_info")
    private String prodplacInfo;

    /** 用途 例如：科研,医疗,教学,办公等等 */
    @TableField("use_code")
    private String useCode;

    /** 用途名称 */
    @TableField("use_name")
    private String useName;

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