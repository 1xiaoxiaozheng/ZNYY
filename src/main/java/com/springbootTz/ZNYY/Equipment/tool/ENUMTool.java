package com.springbootTz.ZNYY.Equipment.tool;

import com.springbootTz.ZNYY.Equipment.mapper.seeyon.ENUMToolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 用于查询seeyon系统的枚举值
 */
@Component
public class ENUMTool {
    @Autowired
    private ENUMToolMapper enumToolMapper;

    /**
     * 方法一：接收枚举值，返回枚举名称
     * 
     * @param enumValue 枚举值
     * @return 枚举名称
     */
    public String getEnumName(BigDecimal enumValue) {
        String enumName = enumToolMapper.getShowValueById(enumValue);
        return enumName;
    }
}
