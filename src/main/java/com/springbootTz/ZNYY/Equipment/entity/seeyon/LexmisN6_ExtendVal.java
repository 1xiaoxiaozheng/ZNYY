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
@TableName("LexmisN6_ExtendVal")
public class LexmisN6_ExtendVal {

    /**
     * UUID
     */
    @TableId(value = "EV_ID", type = IdType.INPUT)
    private Long evId;

    /**
     * 自定义栏 101 (日期)
     */
    @TableField(value = "EV_Field101", jdbcType = JdbcType.DATE)
    private Date evField101;

    /**
     * 自定义栏 102 (日期)
     */
    @TableField(value = "EV_Field102", jdbcType = JdbcType.DATE)
    private Date evField102;

    /**
     * 自定义栏 81 (数值)
     */
    @TableField("EV_Field81")
    private BigDecimal evField81;

    /**
     * 自定义栏 83 (数值)
     */
    @TableField("EV_Field83")
    private BigDecimal evField83;

    /**
     * 自定义栏 6 (输入文本)
     */
    @TableField("EV_Field6")
    private String evField6;

    /**
     * 自定义栏 7 (输入文本)
     */
    @TableField("EV_Field7")
    private String evField7;

    /**
     * 自定义栏 3 (输入文本)
     */
    @TableField("EV_Field3")
    private String evField3;

    /**
     * 自定义栏 4 (输入文本)
     */
    @TableField("EV_Field4")
    private String evField4;
}
