package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetRegistrationDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_AssetRegistrationDetail Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetRegistrationDetailMapper extends BaseMapper<LexmisN6_AssetRegistrationDetail> {

    /**
     * 查询所有资产登记单明细信息
     */
    @Select("SELECT * FROM formson_1200")
    List<LexmisN6_AssetRegistrationDetail> selectAll();

    /**
     * 根据取得日期范围查询明细信息
     */
    @Select("SELECT * FROM formson_1200 WHERE field0032 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetRegistrationDetail> selectByDateRange(String startDate, String endDate);
}