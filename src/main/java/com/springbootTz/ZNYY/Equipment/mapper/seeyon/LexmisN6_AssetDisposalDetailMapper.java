package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetDisposalDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_AssetDisposalDetail Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetDisposalDetailMapper extends BaseMapper<LexmisN6_AssetDisposalDetail> {

    /**
     * 查询所有资产处置单明细信息
     */
    @Select("SELECT * FROM formson_1083")
    List<LexmisN6_AssetDisposalDetail> selectAll();


    /**
     * 查询指定日期范围内的明细信息
     */
    @Select("SELECT * FROM formson_1083 WHERE field0032 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetDisposalDetail> selectByDateRange(String startDate, String endDate);
}