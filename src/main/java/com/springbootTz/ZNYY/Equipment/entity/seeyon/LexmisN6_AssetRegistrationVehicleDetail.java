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
 * 资产登记单-车辆明细表实体类
 * 对应数据库表：formson_1196
 */
@Data
@TableName("formson_1196")
public class LexmisN6_AssetRegistrationVehicleDetail {

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

    /**
     * 使用科室
     */
    @TableField("field0017")
    private String field0017;

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
     * 资产编制情况
     */
    @TableField("field0041")
    private String field0041;

    /**
     * 车辆行驶证
     */
    @TableField("field0042")
    private String field0042;

    /**
     * 车辆类型
     */
    @TableField("field0043")
    private String field0043;

    /**
     * 车牌号
     */
    @TableField("field0044")
    private String field0044;

    /**
     * 车辆所有人
     */
    @TableField("field0045")
    private String field0045;

    /**
     * 发动机号
     */
    @TableField("field0046")
    private String field0046;

    /**
     * 车辆识别代码
     */
    @TableField("field0047")
    private String field0047;

    /**
     * 车辆产地
     */
    @TableField("field0048")
    private String field0048;

    /**
     * 汽车排气量
     */
    @TableField("field0049")
    private String field0049;

    /**
     * 保修截止日期
     */
    @TableField(value = "field0050", jdbcType = JdbcType.TIMESTAMP)
    private Date field0050;

    /**
     * 注册日期
     */
    @TableField(value = "field0051", jdbcType = JdbcType.TIMESTAMP)
    private Date field0051;

    /**
     * 序号1
     */
    @TableField("field0052")
    private BigDecimal field0052;

    /**
     * 价值类型
     */
    @TableField("field0054")
    private BigDecimal field0054;

    /**
     * 采购组织形式
     */
    @TableField("field0055")
    private BigDecimal field0055;

    /**
     * 财务入账状态
     */
    @TableField("field0056")
    private BigDecimal field0056;

    /**
     * 记账日期
     */
    @TableField(value = "field0057", jdbcType = JdbcType.TIMESTAMP)
    private Date field0057;

    /**
     * 记账凭证号
     */
    @TableField("field0058")
    private String field0058;

    /**
     * 资产用途
     */
    @TableField("field0059")
    private BigDecimal field0059;

    /**
     * 预计使用月数
     */
    @TableField("field0065")
    private BigDecimal field0065;

    /**
     * 经费来源-文本
     */
    @TableField("field0066")
    private String field0066;

    /**
     * 上传发票
     */
    @TableField("field0069")
    private String field0069;

    /**
     * 单位
     */
    @TableField("field0070")
    private String field0070;

    /**
     * 金额
     */
    @TableField("field0071")
    private BigDecimal field0071;

    /**
     * 管理人
     */
    @TableField("field0074")
    private String field0074;

    /**
     * 关联主表的ID
     */
    @TableField("formmain_id")
    private Long formmainId;
}