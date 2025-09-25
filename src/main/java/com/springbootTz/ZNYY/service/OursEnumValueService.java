package com.springbootTz.ZNYY.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootTz.ZNYY.entity.OursEnumValue;
import com.springbootTz.ZNYY.mapper.postgresql.OursEnumValueMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 标记为 Spring 服务类
public class OursEnumValueService extends ServiceImpl<OursEnumValueMapper, OursEnumValue> {

    /**
     * 根据 id 查询 ours_enum_value 表的 display 值（无需 MongoDB，直接查数据库）
     * 
     * @param id 表中 id 字段值（如 "67c515c0f4a20921698a48e9"）
     * @return display 值，查不到返回空字符串
     */
    public String getDisplayById(String id) {
        // 调用 MyBatis-Plus 内置方法 selectById：根据主键 id 查询
        OursEnumValue enumValue = baseMapper.selectById(id);

        // 处理结果：查到则返回 display，否则返回空字符串
        return enumValue != null ? enumValue.getDisplay() : "";
    }

    /**
     * 根据display查询所有code值
     * 
     * @param display 显示名称
     * @return code值列表
     */
    public List<String> getCodesByDisplay(String display) {
        return baseMapper.selectCodesByDisplay(display);
    }

    /**
     * 根据display查询单个code值
     * 
     * @param display 显示名称
     * @return code值，查不到返回空字符串
     */
    public String getCodeByDisplay(String display) {
        String code = baseMapper.selectCodeByDisplay(display);
        return code != null ? code : "";
    }
}
