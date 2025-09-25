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

}