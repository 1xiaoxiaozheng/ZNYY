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
@TableName("formson_1061")
public class LexmisN6_AssetRegistrationNetworkDetail {

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private Long id;

    /**
     * 资产编号
     */
    @TableField("field0007")
    private String field0007;

    /**
     * 资产名称
     */
    @TableField("field0008")
    private String field0008;

    /**
     * 资产类型
     */
    @TableField("field0009")
    private String field0009;

    /**
     * 资产分类
     */
    @TableField("field0010")
    private String field0010;

    /**
     * 资产分类代码
     */
    @TableField("field0011")
    private String field0011;

    /**
     * 取得方式
     */
    @TableField("field0012")
    private String field0012;

    /**
     * 资产简称
     */
    @TableField("field0013")
    private String field0013;

    /**
     * 原始价值
     */
    @TableField("field0014")
    private BigDecimal field0014;

    /**
     * 规格型号
     */
    @TableField("field0015")
    private String field0015;

    /**
     * 资产数量
     */
    @TableField("field0016")
    private BigDecimal field0016;

//    /**
//     * 管理科室
//     */
//    @TableField("field0017")
//    private String field0017;

    /**
     * 归属科室
     */
    @TableField("field0018")
    private String field0018;

    /**
     * 归属单位
     */
    @TableField("field0019")
    private String field0019;

    /**
     * 存放地点
     */
    @TableField("field0020")
    private String field0020;

    /**
     * 价值类型
     */
    @TableField("field0021")
    private BigDecimal field0021;

    /**
     * 采购组织形式
     */
    @TableField("field0022")
    private BigDecimal field0022;

    /**
     * 财务入账状态
     */
    @TableField("field0023")
    private BigDecimal field0023;

    /**
     * 记账日期
     */
    @TableField(value = "field0024", jdbcType = JdbcType.TIMESTAMP)
    private Date field0024;

    /**
     * 记账凭证号
     */
    @TableField("field0025")
    private String field0025;

    /**
     * 资产用途
     */
    @TableField("field0026")
    private BigDecimal field0026;

    /**
     * 经费来源
     */
    @TableField("field0027")
    private String field0027;

    /**
     * 财政名称
     */
    @TableField("field0028")
    private String field0028;

    /**
     * 折旧方法
     */
    @TableField("field0029")
    private String field0029;

    /**
     * 折旧小数位数
     */
    @TableField("field0030")
    private BigDecimal field0030;

    /**
     * 预计使用年限
     */
    @TableField("field0031")
    private BigDecimal field0031;

    /**
     * 期初折旧起始日期
     */
    @TableField(value = "field0032", jdbcType = JdbcType.TIMESTAMP)
    private Date field0032;

    /**
     * 期初已折旧期间
     */
    @TableField("field0033")
    private BigDecimal field0033;

    /**
     * 期初累计折旧
     */
    @TableField("field0034")
    private BigDecimal field0034;

    /**
     * 折旧起始日期
     */
    @TableField(value = "field0035", jdbcType = JdbcType.TIMESTAMP)
    private Date field0035;

    /**
     * 资产说明
     */
    @TableField("field0036")
    private String field0036;

    /**
     * 供应商
     */
    @TableField("field0037")
    private String field0037;

    /**
     * 发票号
     */
    @TableField("field0038")
    private String field0038;

    /**
     * 品牌
     */
    @TableField("field0039")
    private String field0039;

    /**
     * 合同编号
     */
    @TableField("field0040")
    private String field0040;

    /**
     * 联系人
     */
    @TableField("field0041")
    private String field0041;

    /**
     * 联系方式
     */
    @TableField("field0042")
    private String field0042;

    /**
     * 生产厂家
     */
    @TableField("field0043")
    private String field0043;

    /**
     * 取得日期
     */
    @TableField(value = "field0044", jdbcType = JdbcType.TIMESTAMP)
    private Date field0044;

    /**
     * 资产图片
     */
    @TableField("field0045")
    private String field0045;

    /**
     * 资产附件
     */
    @TableField("field0046")
    private String field0046;

    /**
     * 序号1
     */
    @TableField("field0049")
    private BigDecimal field0049;

    /**
     * 预计使用月数
     */
    @TableField("field0050")
    private BigDecimal field0050;

    /**
     * 经费来源-文本
     */
    @TableField("field0053")
    private String field0053;

    /**
     * 关联主表的ID
     */
    @TableField("formmain_id")
    private Long formmainId;
}