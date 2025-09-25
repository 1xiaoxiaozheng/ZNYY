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
 * 资产登记-医疗专用设备主表实体类
 * 对应数据库表：formmain_1193
 */
@Data
@TableName("formmain_1193")
public class LexmisN6_AssetRegistrationMedical {

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
     * 财务审核
     */
    @TableField("field0041")
    private String field0041;

    /**
     * 实际采购人员
     */
    @TableField("field0047")
    private String field0047;

    /**
     * 填报人-文本
     */
    @TableField("field0048")
    private String field0048;

    /**
     * 实际采购人员-文本
     */
    @TableField("field0049")
    private String field0049;

    /**
     * 采购人员确认
     */
    @TableField("field0050")
    private String field0050;

    /**
     * 管理科室
     */
    @TableField("field0061")
    private String field0061;

    /**
     * 采购科室负责人
     */
    @TableField("field0065")
    private String field0065;

    /**
     * 供应商
     */
    @TableField("field0066")
    private String field0066;

    /**
     * 金额合计
     */
    @TableField("field0067")
    private BigDecimal field0067;

    /**
     * 供应商查询
     */
    @TableField("field0069")
    private String field0069;

    /**
     * 开始日期
     */
    @TableField(value = "start_date", jdbcType = JdbcType.DATE)
    private Date startDate;
}