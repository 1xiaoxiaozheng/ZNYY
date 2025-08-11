package com.springbootTz.ZNYY.Equipment.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 资产卡片与扩展值关联查询结果DTO
 */
@Data
public class AssetCardWithExtendValDTO {

    // 资产卡片字段
    private Long acId;
    private String acNo;
    private String acName;
    private BigDecimal acOriMoney;
    private Date acGetDate;
    private String acUseDeptNo;
    private String acUseDeptNm;
    private Integer acDeprKind;
    private BigDecimal acDeprRate;
    private String acBvCode2;
    private String acBvName1;
    private Long acBudgetOrg;
    private String acBvName2;
    private Date acUpdateTime;

    // 扩展值字段
    private Date evField101;
    private Date evField102;
    private BigDecimal evField81;
    private BigDecimal evField83;
    private String evField6;
    private String evField7;
    private String evField3;
    private String evField4;
}