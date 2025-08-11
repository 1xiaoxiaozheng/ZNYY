package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_AssetCard Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetCardMapper extends BaseMapper<LexmisN6_AssetCard> {

    /**
     * 查询所有资产卡片信息
     */
    @Select("SELECT * FROM LexmisN6_AssetCard")
    List<LexmisN6_AssetCard> selectAll();

    /**
     * 根据资产编号查询资产信息
     */
    @Select("SELECT * FROM LexmisN6_AssetCard WHERE AC_NO = #{acNo}")
    LexmisN6_AssetCard selectByAcNo(String acNo);

    /**
     * 根据使用科室查询资产信息
     */
    @Select("SELECT * FROM LexmisN6_AssetCard WHERE AC_UseDeptNo = #{deptNo}")
    List<LexmisN6_AssetCard> selectByDeptNo(String deptNo);

    /**
     * 根据资产状态查询资产信息
     */
    @Select("SELECT * FROM LexmisN6_AssetCard WHERE AC_BVCode2 = #{statusCode}")
    List<LexmisN6_AssetCard> selectByStatusCode(String statusCode);

    /**
     * 根据资产类型查询资产信息
     */
    @Select("SELECT * FROM LexmisN6_AssetCard WHERE AC_BVName1 = #{assetType}")
    List<LexmisN6_AssetCard> selectByAssetType(String assetType);

    /**
     * 根据单位代号查询资产信息
     */
    @Select("SELECT * FROM LexmisN6_AssetCard WHERE AC_BudgetOrg = #{budgetOrg}")
    List<LexmisN6_AssetCard> selectByBudgetOrg(Long budgetOrg);

    /**
     * 查询指定日期范围内的资产信息
     */
    @Select("SELECT * FROM LexmisN6_AssetCard WHERE AC_GetDate BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetCard> selectByDateRange(String startDate, String endDate);

    /**
     * 查询价值大于指定金额的资产
     */
    @Select("SELECT * FROM LexmisN6_AssetCard WHERE AC_Money > #{minValue}")
    List<LexmisN6_AssetCard> selectByMinValue(Double minValue);
}