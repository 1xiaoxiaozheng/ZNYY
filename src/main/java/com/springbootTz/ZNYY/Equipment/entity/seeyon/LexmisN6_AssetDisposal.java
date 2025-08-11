package com.springbootTz.ZNYY.Equipment.entity.seeyon;

import lombok.Data;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import org.apache.ibatis.type.JdbcType;

@Data
@TableName("formmain_1082")
public class LexmisN6_AssetDisposal {

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
     * 申请人
     */
    @TableField("field0002")
    private String field0002;

    /**
     * 申请科室
     */
    @TableField("field0003")
    private String field0003;

    /**
     * 申请日期
     */
    @TableField(value = "field0004", jdbcType = JdbcType.TIMESTAMP)
    private Date field0004;

    /**
     * 仓管意见
     */
    @TableField("field0026")
    private String field0026;

    /**
     * 仓库
     */
    @TableField("field0033")
    private String field0033;

    /**
     * 所属单位
     */
    @TableField("field0034")
    private String field0034;

    /**
     * 开始日期
     */
    @TableField(value = "start_date", jdbcType = JdbcType.DATE)
    private Date startDate;
}