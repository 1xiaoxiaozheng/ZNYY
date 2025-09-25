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
 * 资产登记单-家居设备主表实体类
 * 对应数据库表：formmain_1189
 */
@Data
@TableName("formmain_1189")
public class LexmisN6_AssetRegistrationHome {

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private Long id;

    /**
     * 单据编号
     */
    @TableField("field0017")
    private String field0017;

    /**
     * 财务审核-废
     */
    @TableField("field0024")
    private String field0024;

    /**
     * 填报人
     */
    @TableField("field0026")
    private String field0026;

    /**
     * 归属科室
     */
    @TableField("field0027")
    private String field0027;

    /**
     * 填报日期
     */
    @TableField(value = "field0028", jdbcType = JdbcType.TIMESTAMP)
    private Date field0028;

    /**
     * 所属单位
     */
    @TableField("field0152")
    private String field0152;

    /**
     * 实际采购人员
     */
    @TableField("field0162")
    private String field0162;

    /**
     * 采购人员确认
     */
    @TableField("field0163")
    private String field0163;

    /**
     * 填报人-文本
     */
    @TableField("field0164")
    private String field0164;

    /**
     * 实际采购人员-文本
     */
    @TableField("field0165")
    private String field0165;

    /**
     * 管理科室
     */
    @TableField("field0173")
    private String field0173;

    /**
     * 供应商
     */
    @TableField("field0177")
    private String field0177;

    /**
     * 采购科室负责人
     */
    @TableField("field0178")
    private String field0178;

    /**
     * 合计金额
     */
    @TableField("field0179")
    private BigDecimal field0179;

    /**
     * 供应商查询
     */
    @TableField("field0181")
    private String field0181;

    /**
     * 财务审核
     */
    @TableField("field0182")
    private String field0182;

    /**
     * 开始日期
     */
    @TableField(value = "start_date", jdbcType = JdbcType.DATE)
    private Date startDate;
}