package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_ExtendVal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_ExtendVal Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_ExtendValMapper extends BaseMapper<LexmisN6_ExtendVal> {

    /**
     * 查询所有扩展值信息
     */
    @Select("SELECT * FROM LexmisN6_ExtendVal")
    List<LexmisN6_ExtendVal> selectAll();

}