package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;

/**
 * 单位信息工具Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface UnitInfoToolMapper {

    /**
     * 根据单位ID查询单位名称
     * 
     * @param unitId 单位ID
     * @return 单位名称
     */
    @Select("SELECT name FROM ORG_UNIT WHERE ID = #{unitId}")
    String selectUnitNameById(@Param("unitId") Long unitId);

    /**
     * 根据单位ID查询单位code
     *
     * @param unitId 单位ID
     * @return 单位code
     */
    @Select("SELECT code FROM ORG_UNIT WHERE ID = #{unitId}")
    String selectUnitCodeByName(@Param("unitId") Long unitId);

    /**
     * 查询所有单位信息
     * 
     * @return 单位名称列表
     */
    @Select("SELECT name FROM ORG_UNIT")
    java.util.List<String> selectAllUnitNames();

    /**
     * 根据单位名称模糊查询
     * 
     * @param unitName 单位名称（支持模糊查询）
     * @return 匹配的单位名称列表
     */
    @Select("SELECT name FROM ORG_UNIT WHERE name LIKE '%' + #{unitName} + '%'")
    java.util.List<String> selectUnitNamesByFuzzyName(@Param("unitName") String unitName);
}