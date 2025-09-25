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
 * 资产登记单-房屋土地主表实体类
 * 对应数据库表：formmain_1197
 */
@Data
@TableName("formmain_1197")
public class LexmisN6_AssetRegistrationHouse {

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
     * 采购员确认
     */
    @TableField("field0041")
    private String field0041;

    /**
     * 本次登记实际采购员
     */
    @TableField("field0047")
    private String field0047;

    /**
     * 财务审核
     */
    @TableField("field0066")
    private String field0066;

    /**
     * 填报人-文本
     */
    @TableField("field0067")
    private String field0067;

    /**
     * 本次登记实际采购员-文本
     */
    @TableField("field0068")
    private String field0068;

    /**
     * 管理科室
     */
    @TableField("field0071")
    private String field0071;

    /**
     * 采购科室负责人
     */
    @TableField("field0075")
    private String field0075;

    /**
     * 供应商入库
     */
    @TableField("field0077")
    private String field0077;

    /**
     * 合计金额
     */
    @TableField("field0078")
    private BigDecimal field0078;

    /**
     * 开始日期
     */
    @TableField(value = "start_date", jdbcType = JdbcType.DATE)
    private Date startDate;
}