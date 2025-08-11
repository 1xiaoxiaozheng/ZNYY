package com.springbootTz.ZNYY.Equipment.tool;

import com.springbootTz.ZNYY.Equipment.mapper.znyy.UnitInfoToolMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用于单位信息的查询的方法
 */
public class UnitInfoTool {

    @Autowired
    private UnitInfoToolMapper unitInfoToolMapper;

    /**
     * 单位ID，查询单位名
     */
    public String getUnitName(Long unitId) {
        String name = unitInfoToolMapper.selectUnitNameById(unitId);
        return name;
    }

    /**
     * 方法二，接收单位ID，查询统一社会信用代码
     */
    public Long getUnitCreditCode(Long unitId) {
        Long code = unitInfoToolMapper.selectUnitCodeByName(unitId);
        return code;
    }

}
