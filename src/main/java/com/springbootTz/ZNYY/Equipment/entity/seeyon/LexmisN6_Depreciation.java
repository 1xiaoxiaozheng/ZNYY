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
@TableName("LexmisN6_Depreciation")
public class LexmisN6_Depreciation {

    /**
     * UUID
     */
    @TableId(value = "D_ID", type = IdType.INPUT)
    private Long dId;

    /**
     * 单位代号
     */
    @TableField("D_BudgetOrg")
    private Long dBudgetOrg;

    /**
     * 本次折旧开始月
     */
    @TableField("D_DeprBeginMonth")
    private Integer dDeprBeginMonth;

    /**
     * 资产编号
     */
    @TableField("D_NO")
    private String dNo;

    /**
     * 资产名称
     */
    @TableField("D_Name")
    private String dName;

    /**
     * 本次折旧月数
     */
    @TableField("D_DeprMonthTotal")
    private Integer dDeprMonthTotal;

    /**
     * 经费来源编码
     */
    @TableField("D_FundNo")
    private String dFundNo;

    /**
     * 经费来源
     */
    @TableField("D_FundNm")
    private String dFundNm;

    /**
     * 使用科室ID
     */
    @TableField("D_UseDeptNo")
    private Long dUseDeptNo;

    /**
     * 使用科室
     */
    @TableField("D_UseDeptNm")
    private String dUseDeptNm;

    /**
     * 本次实际折旧额
     */
    @TableField("D_DeprAmount")
    private BigDecimal dDeprAmount;

    /**
     * 建立人
     */
    @TableField("D_CreateName")
    private String dCreateName;

    /**
     * 制单日期
     */
    @TableField(value = "D_VoucherDate", jdbcType = JdbcType.DATE)
    private Date dVoucherDate;

    /**
     * 本次折旧方法
     * 0=不计提
     * 1=平均年限法二
     * 2=工作量法
     * 3=双倍余额递减法
     * 4=年限总和法
     * 5=平均年限法一
     * 6=平均年限法三
     */
    @TableField("D_DeprKind")
    private Integer dDeprKind;

    /**
     * 建立日期
     */
    @TableField(value = "D_CreateDate", jdbcType = JdbcType.DATE)
    private Date dCreateDate;
}