package com.springbootTz.ZNYY.mapper.postgresql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.entity.OursEnumValue;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 标记为 MyBatis Mapper 接口
public interface OursEnumValueMapper extends BaseMapper<OursEnumValue> {
    // 无需额外定义方法，BaseMapper 已包含 selectById 方法
}