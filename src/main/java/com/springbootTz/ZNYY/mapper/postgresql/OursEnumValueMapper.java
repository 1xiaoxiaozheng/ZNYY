package com.springbootTz.ZNYY.mapper.postgresql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.entity.OursEnumValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // 标记为 MyBatis Mapper 接口
public interface OursEnumValueMapper extends BaseMapper<OursEnumValue> {
    // 无需额外定义方法，BaseMapper 已包含 selectById 方法

    /**
     * 根据enum_id查询所有code值
     * 
     * @param display 枚举类型ID
     * @return code值列表
     */
    @Select("SELECT code FROM ours_enum_value WHERE display = #{display}")
    List<String> selectCodesByDisplay(String display);

    /**
     * 根据enum_id查询单个code值（如果确定只有一个）
     * 
     * @param display 枚举类型ID
     * @return code值
     */
    @Select("SELECT code FROM ours_enum_value WHERE display = #{enumId} LIMIT 1")
    String selectCodeByDisplay(String display);
}