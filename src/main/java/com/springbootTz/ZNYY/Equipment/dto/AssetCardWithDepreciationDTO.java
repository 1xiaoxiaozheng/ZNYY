package com.springbootTz.ZNYY.Equipment.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 资产卡片与折旧明细关联查询DTO
 */
@Data
public class AssetCardWithDepreciationDTO {

    // 资产卡片信息
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

    // 折旧明细信息
    private Long dId;
    private Long dBudgetOrg;
    private Integer dDeprBeginMonth;
    private String dNo;
    private String dName;
    private Integer dDeprMonthTotal;
    private String dFundNo;
    private String dFundNm;
    private Long dUseDeptNo;
    private String dUseDeptNm;
    private BigDecimal dDeprAmount;
    private String dCreateName;
    private Date dVoucherDate;
    private Integer dDeprKind;
    private Date dCreateDate;

    // 扩展值信息
    private Date evField101;
    private Date evField102;
    private BigDecimal evField81;
    private BigDecimal evField83;
    private String evField6;
    private String evField7;
    private String evField3;
    private String evField4;

}