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
 * 资产登记单-车辆主表实体类
 * 对应数据库表：formmain_1195
 */
@Data
@TableName("formmain_1195")
public class LexmisN6_AssetRegistrationVehicle {

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private Long id;

    /**
     * 单据编号
     */
    @TableField("field0001")
    private String field0001;

    /**
     * 填报人
     */
    @TableField("field0002")
    private String field0002;

    /**
     * 归属科室
     */
    @TableField("field0003")
    private String field0003;

    /**
     * 填报日期
     */
    @TableField(value = "field0004", jdbcType = JdbcType.TIMESTAMP)
    private Date field0004;

    /**
     * 所属单位
     */
    @TableField("field0005")
    private String field0005;

    /**
     * 采购人员确认
     */
    @TableField("field0060")
    private String field0060;

    /**
     * 财务审核
     */
    @TableField("field0061")
    private String field0061;

    /**
     * 填报人-文本
     */
    @TableField("field0062")
    private String field0062;

    /**
     * 实际采购员-文本
     */
    @TableField("field0063")
    private String field0063;

    /**
     * 实际采购人员
     */
    @TableField("field0064")
    private String field0064;

    /**
     * 管理科室
     */
    @TableField("field0067")
    private String field0067;

    /**
     * 采购科室负责人
     */
    @TableField("field0068")
    private String field0068;

    /**
     * 合计金额
     */
    @TableField("field0072")
    private BigDecimal field0072;

    /**
     * 供应商
     */
    @TableField("field0073")
    private String field0073;

    /**
     * 供应商查询
     */
    @TableField("field0075")
    private String field0075;

    /**
     * 开始日期
     */
    @TableField(value = "start_date", jdbcType = JdbcType.DATE)
    private Date startDate;
}