package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetDisposal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_AssetDisposal Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetDisposalMapper extends BaseMapper<LexmisN6_AssetDisposal> {

    /**
     * 查询所有资产处置单信息
     */
    @Select("SELECT * FROM formmain_1082")
    List<LexmisN6_AssetDisposal> selectAll();

    /**
     * 查询指定日期范围内的资产处置单信息
     */
    @Select("SELECT * FROM formmain_1082 WHERE field0004 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetDisposal> selectByDateRange(String startDate, String endDate);
}