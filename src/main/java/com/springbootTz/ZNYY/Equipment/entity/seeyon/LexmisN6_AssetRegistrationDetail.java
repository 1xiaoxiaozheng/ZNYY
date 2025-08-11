package com.springbootTz.ZNYY.Equipment.entity.seeyon;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import org.apache.ibatis.type.JdbcType;

@Data
@TableName("formson_1072")
public class LexmisN6_AssetRegistrationDetail {

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private Long id;

    /**
     * 资产编号
     */
    @TableField("field0001")
    private String field0001;

    /**
     * 资产名称
     */
    @TableField("field0002")
    private String field0002;

    /**
     * 规格型号
     */
    @TableField("field0006")
    private String field0006;

    /**
     * 原始价值
     */
    @TableField("field0007")
    private BigDecimal field0007;

    /**
     * 折旧起始日期
     */
    @TableField(value = "field0010", jdbcType = JdbcType.TIMESTAMP)
    private Date field0010;

    /**
     * 供应商
     */
    @TableField("field0013")
    private String field0013;

    /**
     * 联系人
     */
    @TableField("field0014")
    private String field0014;

    /**
     * 联系方式
     */
    @TableField("field0031")
    private String field0031;

    /**
     * 取得日期
     */
    @TableField(value = "field0032", jdbcType = JdbcType.TIMESTAMP)
    private Date field0032;

    /**
     * 预计使用月数
     */
    @TableField("field0036")
    private BigDecimal field0036;

    /**
     * 管理科室
     */
    @TableField("field0041")
    private String field0041;

    /**
     * 折旧小数位数
     */
    @TableField("field0047")
    private BigDecimal field0047;

    /**
     * 期初累计折旧
     */
    @TableField("field0048")
    private BigDecimal field0048;

    /**
     * 资产图片
     */
    @TableField("field0058")
    private String field0058;

    /**
     * 资产附件
     */
    @TableField("field0059")
    private String field0059;

    /**
     * 资产数量
     */
    @TableField("field0066")
    private BigDecimal field0066;

    /**
     * 资产说明
     */
    @TableField("field0072")
    private String field0072;

    /**
     * 期初折旧起始日期
     */
    @TableField(value = "field0099", jdbcType = JdbcType.TIMESTAMP)
    private Date field0099;

    /**
     * 资产简称
     */
    @TableField("field0102")
    private String field0102;

    /**
     * 期初已折旧期间
     */
    @TableField("field0108")
    private BigDecimal field0108;

    /**
     * 资产来源
     */
    @TableField("field0125")
    private String field0125;

    /**
     * 资产分类
     */
    @TableField("field0126")
    private String field0126;

    /**
     * 折旧方法
     */
    @TableField("field0128")
    private String field0128;

    /**
     * 资产类型
     */
    @TableField("field0131")
    private String field0131;

    /**
     * 资产分类代码
     */
    @TableField("field0133")
    private String field0133;

    /**
     * 归属科室
     */
    @TableField("field0134")
    private String field0134;

    /**
     * 存放地点隐藏
     */
    @TableField("field0145")
    private String field0145;

    /**
     * 存放地点
     */
    @TableField("field0150")
    private String field0150;

    /**
     * 期初累计
     */
    @TableField("field0151")
    private BigDecimal field0151;

    /**
     * 归属单位
     */
    @TableField("field0153")
    private String field0153;

    /**
     * 发票号
     */
    @TableField("field0154")
    private String field0154;

    /**
     * 合同编号
     */
    @TableField("field0155")
    private String field0155;

    /**
     * 预计使用年限
     */
    @TableField("field0156")
    private BigDecimal field0156;

    /**
     * 经费来源
     */
    @TableField("field0158")
    private String field0158;

    /**
     * 财政名称
     */
    @TableField("field0159")
    private String field0159;

    /**
     * 品牌
     */
    @TableField("field0160")
    private String field0160;

    /**
     * 生产厂家
     */
    @TableField("field0161")
    private String field0161;

    /**
     * 价值类型
     */
    @TableField("field0166")
    private BigDecimal field0166;

    /**
     * 采购组织形式
     */
    @TableField("field0167")
    private BigDecimal field0167;

    /**
     * 财务入账状态
     */
    @TableField("field0168")
    private BigDecimal field0168;

    /**
     * 记账日期
     */
    @TableField(value = "field0169", jdbcType = JdbcType.TIMESTAMP)
    private Date field0169;

    /**
     * 记账凭证号
     */
    @TableField("field0170")
    private String field0170;

    /**
     * 资产用途
     */
    @TableField("field0171")
    private BigDecimal field0171;

    /**
     * 序号1
     */
    @TableField("field0172")
    private BigDecimal field0172;

    /**
     * 经费来源-文本
     */
    @TableField("field0173")
    private String field0173;

    /**
     * 资产状态
     */
    @TableField("field0174")
    private String field0174;

    /**
     * 关联主表的ID
     */
    @TableField("formmain_id")
    private Long formmainId;
}