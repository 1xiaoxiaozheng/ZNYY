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

    /**
     * 根据ID查询扩展值信息
     */
    @Select("SELECT * FROM LexmisN6_ExtendVal WHERE EV_ID = #{evId}")
    LexmisN6_ExtendVal selectByEvId(Long evId);

    /**
     * 查询指定日期范围内的扩展值信息
     */
    @Select("SELECT * FROM LexmisN6_ExtendVal WHERE EV_Field101 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_ExtendVal> selectByField101DateRange(String startDate, String endDate);

    /**
     * 查询指定日期范围内的扩展值信息（Field102）
     */
    @Select("SELECT * FROM LexmisN6_ExtendVal WHERE EV_Field102 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_ExtendVal> selectByField102DateRange(String startDate, String endDate);

    /**
     * 根据数值字段查询（Field81）
     */
    @Select("SELECT * FROM LexmisN6_ExtendVal WHERE EV_Field81 > #{minValue}")
    List<LexmisN6_ExtendVal> selectByField81MinValue(Double minValue);

    /**
     * 根据数值字段查询（Field83）
     */
    @Select("SELECT * FROM LexmisN6_ExtendVal WHERE EV_Field83 > #{minValue}")
    List<LexmisN6_ExtendVal> selectByField83MinValue(Double minValue);

    /**
     * 根据文本字段查询（Field6）
     */
    @Select("SELECT * FROM LexmisN6_ExtendVal WHERE EV_Field6 LIKE '%' + #{text} + '%'")
    List<LexmisN6_ExtendVal> selectByField6Text(String text);

    /**
     * 根据文本字段查询（Field7）
     */
    @Select("SELECT * FROM LexmisN6_ExtendVal WHERE EV_Field7 LIKE '%' + #{text} + '%'")
    List<LexmisN6_ExtendVal> selectByField7Text(String text);

    /**
     * 根据文本字段查询（Field3）
     */
    @Select("SELECT * FROM LexmisN6_ExtendVal WHERE EV_Field3 LIKE '%' + #{text} + '%'")
    List<LexmisN6_ExtendVal> selectByField3Text(String text);

    /**
     * 根据文本字段查询（Field4）
     */
    @Select("SELECT * FROM LexmisN6_ExtendVal WHERE EV_Field4 LIKE '%' + #{text} + '%'")
    List<LexmisN6_ExtendVal> selectByField4Text(String text);
}