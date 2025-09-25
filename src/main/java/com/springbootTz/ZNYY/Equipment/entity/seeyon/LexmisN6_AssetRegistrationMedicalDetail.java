package com.springbootTz.ZNYY.Equipment.entity.seeyon;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import org.apache.ibatis.type.JdbcType;

/**
 * 资产登记-医疗专用设备明细表实体类
 * 对应数据库表：formson_1194
 */
@Data
@TableName("formson_1194")
public class LexmisN6_AssetRegistrationMedicalDetail {

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private Long id;

    /**
     * 资产编号
     */
    @TableField("field0006")
    private String field0006;

    /**
     * 资产名称
     */
    @TableField("field0007")
    private String field0007;

    /**
     * 资产类型
     */
    @TableField("field0008")
    private String field0008;

    /**
     * 资产分类
     */
    @TableField("field0009")
    private String field0009;

    /**
     * 资产来源
     */
    @TableField("field0011")
    private String field0011;

    /**
     * 资产简称
     */
    @TableField("field0012")
    private String field0012;

    /**
     * 原始价值
     */
    @TableField("field0013")
    private BigDecimal field0013;

    /**
     * 规格型号
     */
    @TableField("field0014")
    private String field0014;

    /**
     * 资产数量
     */
    @TableField("field0015")
    private BigDecimal field0015;

    /**
     * 管理科室2
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
     * 经费来源
     */
    @TableField("field0021")
    private String field0021;

    /**
     * 财政名称
     */
    @TableField("field0022")
    private String field0022;

    /**
     * 折旧方法
     */
    @TableField("field0023")
    private String field0023;

    /**
     * 折旧小数位数
     */
    @TableField("field0024")
    private BigDecimal field0024;

    /**
     * 预计使用年限
     */
    @TableField("field0025")
    private BigDecimal field0025;

    /**
     * 期初折旧起始日期
     */
    @TableField(value = "field0026", jdbcType = JdbcType.TIMESTAMP)
    private Date field0026;

    /**
     * 期初已折旧期间
     */
    @TableField("field0027")
    private BigDecimal field0027;

    /**
     * 期初累计折旧
     */
    @TableField("field0028")
    private BigDecimal field0028;

    /**
     * 折旧起始日期
     */
    @TableField(value = "field0029", jdbcType = JdbcType.TIMESTAMP)
    private Date field0029;

    /**
     * 资产说明
     */
    @TableField("field0030")
    private String field0030;

    /**
     * 发票号
     */
    @TableField("field0032")
    private String field0032;

    /**
     * 品牌
     */
    @TableField("field0033")
    private String field0033;

    /**
     * 合同编号
     */
    @TableField("field0034")
    private String field0034;

    /**
     * 联系人
     */
    @TableField("field0035")
    private String field0035;

    /**
     * 联系方式
     */
    @TableField("field0036")
    private String field0036;

    /**
     * 生产厂家
     */
    @TableField("field0037")
    private String field0037;

    /**
     * 取得日期
     */
    @TableField(value = "field0038", jdbcType = JdbcType.TIMESTAMP)
    private Date field0038;

    /**
     * 资产图片
     */
    @TableField("field0039")
    private String field0039;

    /**
     * 资产附件
     */
    @TableField("field0040")
    private String field0040;

    /**
     * 序号1
     */
    @TableField("field0042")
    private BigDecimal field0042;

    /**
     * 出厂编号
     */
    @TableField("field0045")
    private String field0045;

    /**
     * 出厂使用年限
     */
    @TableField("field0046")
    private BigDecimal field0046;

    /**
     * 价值类型
     */
    @TableField("field0051")
    private BigDecimal field0051;

    /**
     * 采购组织形式
     */
    @TableField("field0052")
    private BigDecimal field0052;

    /**
     * 财务入账状态
     */
    @TableField("field0053")
    private BigDecimal field0053;

    /**
     * 记账日期
     */
    @TableField(value = "field0054", jdbcType = JdbcType.TIMESTAMP)
    private Date field0054;

    /**
     * 记账凭证号
     */
    @TableField("field0055")
    private String field0055;

    /**
     * 资产用途
     */
    @TableField("field0056")
    private BigDecimal field0056;

    /**
     * 资产分类代码
     */
    @TableField("field0058")
    private String field0058;

    /**
     * 预计使用月数
     */
    @TableField("field0059")
    private BigDecimal field0059;

    /**
     * 经费来源-文本
     */
    @TableField("field0060")
    private String field0060;

    /**
     * 上传发票
     */
    @TableField("field0062")
    private String field0062;

    /**
     * 金额
     */
    @TableField("field0063")
    private BigDecimal field0063;

    /**
     * 单位
     */
    @TableField("field0064")
    private String field0064;

    /**
     * 管理人
     */
    @TableField("field0068")
    private String field0068;

    /**
     * 生产日期
     */
    @TableField(value = "field0070", jdbcType = JdbcType.TIMESTAMP)
    private Date field0070;

    /**
     * 关联主表的ID
     */
    @TableField("formmain_id")
    private Long formmainId;
}