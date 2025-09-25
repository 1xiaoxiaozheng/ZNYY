package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetRegistrationHomeDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_AssetRegistrationHomeDetail Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetRegistrationHomeDetailMapper extends BaseMapper<LexmisN6_AssetRegistrationHomeDetail> {

    /**
     * 查询所有家居设备资产登记单明细信息
     */
    @Select("SELECT * FROM formson_1198")
    List<LexmisN6_AssetRegistrationHomeDetail> selectAll();

    /**
     * 根据取得日期范围查询明细信息
     */
    @Select("SELECT * FROM formson_1198 WHERE field0032 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetRegistrationHomeDetail> selectByDateRange(String startDate, String endDate);
}