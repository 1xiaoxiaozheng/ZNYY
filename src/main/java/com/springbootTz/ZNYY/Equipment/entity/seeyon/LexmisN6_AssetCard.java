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
@TableName("LexmisN6_AssetCard")
public class LexmisN6_AssetCard {

    /**
     * UUID
     */
    @TableId(value = "AC_ID", type = IdType.INPUT)
    private Long acId;

    /**
     * 资产编号
     */
    @TableField("AC_NO")
    private String acNo;

    /**
     * 资产名称
     */
    @TableField("AC_Name")
    private String acName;

    /**
     * 原始价值
     */
    @TableField("AC_OriMoney")
    private BigDecimal acOriMoney;

    /**
     * 取得日期
     */
    @TableField(value = "AC_GetDate", jdbcType = JdbcType.DATE)
    private Date acGetDate;

    /**
     * 使用科室ID
     */
    @TableField("AC_UseDeptNo")
    private String acUseDeptNo;

    /**
     * 使用科室
     */
    @TableField("AC_UseDeptNm")
    private String acUseDeptNm;

    /**
     * 折旧方法
     * 0=不计提
     * 1=平均年限法二
     * 2=工作量法
     * 3=双倍余额递减法
     * 4=年限总和法
     * 5=平均年限法一
     * 6=平均年限法三
     */
    @TableField("AC_DeprKind")
    private Integer acDeprKind;

    /**
     * 月折旧率
     */
    @TableField("AC_DeprRate")
    private BigDecimal acDeprRate;

    /**
     * 资产状态编号
     */
    @TableField("AC_BVCode2")
    private String acBvCode2;

    /**
     * 资产类型
     */
    @TableField("AC_BVName1")
    private String acBvName1;

    /**
     * 单位代号
     */
    @TableField("AC_BudgetOrg")
    private Long acBudgetOrg;

    /**
     * 资产状态
     */
    @TableField("AC_BVName2")
    private String acBvName2;

    /**
     * 最近修改时间
     */
    @TableField(value = "AC_UpdateTime", jdbcType = JdbcType.DATE)
    private Date acUpdateTime;
}
