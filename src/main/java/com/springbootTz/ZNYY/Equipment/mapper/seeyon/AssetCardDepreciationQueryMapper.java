package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.springbootTz.ZNYY.Equipment.dto.AssetCardWithDepreciationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

/**
 * 资产卡片与折旧明细关联查询Mapper接口
 * 用于SQL Server数据库的复杂关联查询操作
 */
@Mapper
public interface AssetCardDepreciationQueryMapper {

        /**
         * 关联查询资产卡片和折旧明细信息
         * 通过AC_NO=D_NO关联
         */
        @Select("SELECT " +
                        "ac.AC_ID, ac.AC_NO, ac.AC_Name, ac.AC_OriMoney, " +
                        "ac.AC_GetDate, ac.AC_UseDeptNo, ac.AC_UseDeptNm, ac.AC_DeprKind, " +
                        "ac.AC_DeprRate, ac.AC_BVCode2, ac.AC_BVName1, ac.AC_BudgetOrg, ac.AC_BVName2, ac.AC_UpdateTime, "
                        +
                        "d.D_ID, d.D_BudgetOrg, d.D_DeprBeginMonth, d.D_NO, d.D_Name, " +
                        "d.D_DeprMonthTotal, d.D_FundNo, d.D_FundNm, d.D_UseDeptNo, d.D_UseDeptNm, " +
                        "d.D_DeprAmount, d.D_CreateName, d.D_VoucherDate, d.D_DeprKind, d.D_CreateDate " +
                        "FROM LexmisN6_AssetCard ac " +
                        "LEFT JOIN LexmisN6_Depreciation d ON ac.AC_NO = d.D_NO " +
                        "WHERE ac.AC_BudgetOrg NOT IN (SELECT ID FROM ORG_UNIT WHERE NAME LIKE '%周宁总医院%')")
        @Results({
                        // 资产卡片字段映射
                        @Result(property = "acId", column = "AC_ID"),
                        @Result(property = "acNo", column = "AC_NO"),
                        @Result(property = "acName", column = "AC_Name"),
                        @Result(property = "acOriMoney", column = "AC_OriMoney"),
                        @Result(property = "acGetDate", column = "AC_GetDate"),
                        @Result(property = "acUseDeptNo", column = "AC_UseDeptNo"),
                        @Result(property = "acUseDeptNm", column = "AC_UseDeptNm"),
                        @Result(property = "acDeprKind", column = "AC_DeprKind"),
                        @Result(property = "acDeprRate", column = "AC_DeprRate"),
                        @Result(property = "acBvCode2", column = "AC_BVCode2"),
                        @Result(property = "acBvName1", column = "AC_BVName1"),
                        @Result(property = "acBudgetOrg", column = "AC_BudgetOrg"),
                        @Result(property = "acBvName2", column = "AC_BVName2"),
                        @Result(property = "acUpdateTime", column = "AC_UpdateTime"),
                        // 折旧明细字段映射
                        @Result(property = "dId", column = "D_ID"),
                        @Result(property = "dBudgetOrg", column = "D_BudgetOrg"),
                        @Result(property = "dDeprBeginMonth", column = "D_DeprBeginMonth"),
                        @Result(property = "dNo", column = "D_NO"),
                        @Result(property = "dName", column = "D_Name"),
                        @Result(property = "dDeprMonthTotal", column = "D_DeprMonthTotal"),
                        @Result(property = "dFundNo", column = "D_FundNo"),
                        @Result(property = "dFundNm", column = "D_FundNm"),
                        @Result(property = "dUseDeptNo", column = "D_UseDeptNo"),
                        @Result(property = "dUseDeptNm", column = "D_UseDeptNm"),
                        @Result(property = "dDeprAmount", column = "D_DeprAmount"),
                        @Result(property = "dCreateName", column = "D_CreateName"),
                        @Result(property = "dVoucherDate", column = "D_VoucherDate"),
                        @Result(property = "dDeprKind", column = "D_DeprKind"),
                        @Result(property = "dCreateDate", column = "D_CreateDate")
        })
        List<AssetCardWithDepreciationDTO> selectAssetCardWithDepreciation();
}