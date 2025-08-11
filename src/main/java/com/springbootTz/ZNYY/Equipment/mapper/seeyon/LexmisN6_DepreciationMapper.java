package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_Depreciation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.math.BigDecimal;

/**
 * LexmisN6_Depreciation Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_DepreciationMapper extends BaseMapper<LexmisN6_Depreciation> {

    /**
     * 查询所有折旧明细信息
     */
    @Select("SELECT * FROM LexmisN6_Depreciation")
    List<LexmisN6_Depreciation> selectAll();

    /**
     * 根据UUID查询折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_ID = #{dId}")
    LexmisN6_Depreciation selectById(Long dId);

    /**
     * 根据资产编号查询折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_NO = #{dNo}")
    List<LexmisN6_Depreciation> selectByAssetNo(String dNo);

    /**
     * 根据单位代号查询折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_BudgetOrg = #{budgetOrg}")
    List<LexmisN6_Depreciation> selectByBudgetOrg(Long budgetOrg);

    /**
     * 根据使用科室ID查询折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_UseDeptNo = #{deptNo}")
    List<LexmisN6_Depreciation> selectByDeptNo(Long deptNo);

    /**
     * 根据折旧方法查询折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_DeprKind = #{deprKind}")
    List<LexmisN6_Depreciation> selectByDeprKind(Integer deprKind);

    /**
     * 根据经费来源编码查询折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_FundNo = #{fundNo}")
    List<LexmisN6_Depreciation> selectByFundNo(String fundNo);

    /**
     * 根据建立人查询折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_CreateName = #{createName}")
    List<LexmisN6_Depreciation> selectByCreateName(String createName);

    /**
     * 查询指定日期范围内的折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_VoucherDate BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_Depreciation> selectByVoucherDateRange(String startDate, String endDate);

    /**
     * 查询指定建立日期范围内的折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_CreateDate BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_Depreciation> selectByCreateDateRange(String startDate, String endDate);

    /**
     * 查询折旧金额大于指定值的折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_DeprAmount > #{minAmount}")
    List<LexmisN6_Depreciation> selectByMinDeprAmount(BigDecimal minAmount);

    /**
     * 查询折旧金额小于指定值的折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_DeprAmount < #{maxAmount}")
    List<LexmisN6_Depreciation> selectByMaxDeprAmount(BigDecimal maxAmount);

    /**
     * 根据折旧开始月查询折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_DeprBeginMonth = #{beginMonth}")
    List<LexmisN6_Depreciation> selectByBeginMonth(Integer beginMonth);

    /**
     * 根据折旧月数查询折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_DeprMonthTotal = #{monthTotal}")
    List<LexmisN6_Depreciation> selectByMonthTotal(Integer monthTotal);

    /**
     * 查询指定资产在指定日期范围内的折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_NO = #{dNo} AND D_VoucherDate BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_Depreciation> selectByAssetNoAndDateRange(String dNo, String startDate, String endDate);

    /**
     * 查询指定科室在指定日期范围内的折旧明细
     */
    @Select("SELECT * FROM LexmisN6_Depreciation WHERE D_UseDeptNo = #{deptNo} AND D_VoucherDate BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_Depreciation> selectByDeptNoAndDateRange(Long deptNo, String startDate, String endDate);

    /**
     * 统计指定资产的折旧总额
     */
    @Select("SELECT SUM(D_DeprAmount) FROM LexmisN6_Depreciation WHERE D_NO = #{dNo}")
    BigDecimal sumDeprAmountByAssetNo(String dNo);

    /**
     * 统计指定科室的折旧总额
     */
    @Select("SELECT SUM(D_DeprAmount) FROM LexmisN6_Depreciation WHERE D_UseDeptNo = #{deptNo}")
    BigDecimal sumDeprAmountByDeptNo(Long deptNo);

    /**
     * 统计指定日期范围内的折旧总额
     */
    @Select("SELECT SUM(D_DeprAmount) FROM LexmisN6_Depreciation WHERE D_VoucherDate BETWEEN #{startDate} AND #{endDate}")
    BigDecimal sumDeprAmountByDateRange(String startDate, String endDate);
}