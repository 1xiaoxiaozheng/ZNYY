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
@TableName("formson_1083")
public class LexmisN6_AssetDisposalDetail {

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private Long id;

    /**
     * 资产名称
     */
    @TableField("field0006")
    private String field0006;

    /**
     * 资产类型
     */
    @TableField("field0008")
    private String field0008;

    /**
     * 处置事由
     */
    @TableField("field0009")
    private String field0009;

    /**
     * 处置方式
     */
    @TableField("field0010")
    private String field0010;

    /**
     * 资产分类
     */
    @TableField("field0011")
    private String field0011;

    /**
     * 规格型号
     */
    @TableField("field0013")
    private String field0013;

    /**
     * 取得日期
     */
    @TableField("field0014")
    private String field0014;

    /**
     * 原始价值
     */
    @TableField("field0015")
    private BigDecimal field0015;

    /**
     * 折旧方法
     */
    @TableField("field0016")
    private String field0016;

    /**
     * 折旧起始日期
     */
    @TableField("field0017")
    private String field0017;

    /**
     * 预计使用月数
     */
    @TableField("field0018")
    private BigDecimal field0018;

    /**
     * 原使用科室
     */
    @TableField("field0019")
    private String field0019;

    /**
     * 原使用地点
     */
    @TableField("field0020")
    private String field0020;

    /**
     * 原使用人
     */
    @TableField("field0021")
    private String field0021;

    /**
     * 资产编号
     */
    @TableField("field0023")
    private String field0023;

    /**
     * 资产状态
     */
    @TableField("field0024")
    private String field0024;

    /**
     * 资产数量
     */
    @TableField("field0028")
    private BigDecimal field0028;

    /**
     * 原管理人
     */
    @TableField("field0029")
    private String field0029;

//    /**
//     * 原管理科室
//     */
//    @TableField("field0030")
//    private String field0030;

    /**
     * 资产说明
     */
    @TableField("field0031")
    private String field0031;

    /**
     * 处置日期
     */
    @TableField(value = "field0032", jdbcType = JdbcType.TIMESTAMP)
    private Date field0032;

    /**
     * 关联主表的ID
     */
    @TableField("formmain_id")
    private Long formmainId;
}