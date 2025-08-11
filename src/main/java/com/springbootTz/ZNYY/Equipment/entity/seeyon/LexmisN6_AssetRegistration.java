package com.springbootTz.ZNYY.Equipment.entity.seeyon;

import lombok.Data;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import org.apache.ibatis.type.JdbcType;

@Data
@TableName("formmain_1071")
public class LexmisN6_AssetRegistration {

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
     * 财务审核
     */
    @TableField("field0024")
    private String field0024;

    /**
     * 填报人
     */
    @TableField("field0026")
    private String field0026;

    /**
     * 所属科室
     */
    @TableField("field0027")
    private String field0027;

    /**
     * 填报日期
     */
    @TableField(value = "field0028", jdbcType = JdbcType.TIMESTAMP)
    private Date field0028;

    /**
     * 单位
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
     * 开始日期
     */
    @TableField(value = "start_date", jdbcType = JdbcType.DATE)
    private Date startDate;
}