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
 * 资产登记单-房屋土地明细表实体类
 * 对应数据库表：formson_1054
 */
@Data
@TableName("formson_1054")
public class LexmisN6_AssetRegistrationHouseDetail {

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
     * 资产分类代码
     */
    @TableField("field0010")
    private String field0010;

    /**
     * 取得方式
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

//    /**
//     * 管理科室
//     */
//    @TableField("field0016")
//    private String field0016;

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
     * 供应商
     */
    @TableField("field0031")
    private String field0031;

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
     * 数量面积
     */
    @TableField("field0042")
    private BigDecimal field0042;

    /**
     * 产权形式
     */
    @TableField("field0043")
    private BigDecimal field0043;

    /**
     * 权属性质
     */
    @TableField("field0044")
    private BigDecimal field0044;

    /**
     * 权属证号
     */
    @TableField("field0045")
    private String field0045;

    /**
     * 序号1
     */
    @TableField("field0046")
    private BigDecimal field0046;

    /**
     * 价值类型
     */
    @TableField("field0048")
    private BigDecimal field0048;

    /**
     * 采购组织形式
     */
    @TableField("field0049")
    private BigDecimal field0049;

    /**
     * 财务入账状态
     */
    @TableField("field0050")
    private BigDecimal field0050;

    /**
     * 记账日期
     */
    @TableField(value = "field0051", jdbcType = JdbcType.TIMESTAMP)
    private Date field0051;

    /**
     * 记账凭证号
     */
    @TableField("field0052")
    private String field0052;

    /**
     * 资产用途
     */
    @TableField("field0053")
    private BigDecimal field0053;

    /**
     * 权属证明
     */
    @TableField("field0054")
    private String field0054;

    /**
     * 权属人
     */
    @TableField("field0055")
    private String field0055;

    /**
     * 发证日期
     */
    @TableField(value = "field0056", jdbcType = JdbcType.TIMESTAMP)
    private Date field0056;

    /**
     * 竣工决算日期
     */
    @TableField(value = "field0057", jdbcType = JdbcType.TIMESTAMP)
    private Date field0057;

    /**
     * 建筑结构
     */
    @TableField("field0058")
    private String field0058;

    /**
     * 权属面积
     */
    @TableField("field0059")
    private BigDecimal field0059;

    /**
     * 占地面积
     */
    @TableField("field0060")
    private BigDecimal field0060;

    /**
     * 坐落位置
     */
    @TableField("field0061")
    private String field0061;

    /**
     * 办公用房
     */
    @TableField("field0062")
    private BigDecimal field0062;

    /**
     * 其中办公用房
     */
    @TableField("field0063")
    private BigDecimal field0063;

    /**
     * 业务用房
     */
    @TableField("field0064")
    private BigDecimal field0064;

    /**
     * 其他用房
     */
    @TableField("field0065")
    private BigDecimal field0065;

    /**
     * 预计使用月数
     */
    @TableField("field0069")
    private BigDecimal field0069;

    /**
     * 经费来源-文本
     */
    @TableField("field0070")
    private String field0070;

    /**
     * 关联主表的ID
     */
    @TableField("formmain_id")
    private Long formmainId;
}