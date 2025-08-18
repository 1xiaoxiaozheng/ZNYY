package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

@Mapper
public interface ENUMToolMapper {
    /**
     * 根据ID获取显示值
     * @param id 枚举项ID
     * @return 对应的显示值ShowValue
     */
    @Select("SELECT ShowValue " +
            "FROM ctp_enum_item " +
            "WHERE ID = #{id} ")
    String getShowValueById(@Param("id") BigDecimal id);

}
