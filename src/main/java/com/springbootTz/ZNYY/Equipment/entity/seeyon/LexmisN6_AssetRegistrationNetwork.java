package com.springbootTz.ZNYY.Equipment.entity.seeyon;

import lombok.Data;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import org.apache.ibatis.type.JdbcType;

@Data
@TableName("formmain_1060")
public class LexmisN6_AssetRegistrationNetwork {

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
     * 所属科室
     */
    @TableField("field0003")
    private String field0003;

    /**
     * 填报日期
     */
    @TableField(value = "field0004", jdbcType = JdbcType.TIMESTAMP)
    private Date field0004;

    /**
     * 实际采购人员
     */
    @TableField("field0005")
    private String field0005;

    /**
     * 单位
     */
    @TableField("field0006")
    private String field0006;

    /**
     * 采购人员确认
     */
    @TableField("field0047")
    private String field0047;

    /**
     * 财务审核
     */
    @TableField("field0048")
    private String field0048;

    /**
     * 填报人-文本
     */
    @TableField("field0051")
    private String field0051;

    /**
     * 实际采购人员-文本
     */
    @TableField("field0052")
    private String field0052;

    /**
     * 开始日期
     */
    @TableField(value = "start_date", jdbcType = JdbcType.DATE)
    private Date startDate;
}