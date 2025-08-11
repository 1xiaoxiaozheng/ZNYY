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
     * 根据主表ID查询明细信息
     */
    @Select("SELECT * FROM formson_1083 WHERE formmain_id = #{formmainId}")
    List<LexmisN6_AssetDisposalDetail> selectByFormmainId(Long formmainId);

    /**
     * 根据资产编号查询明细信息
     */
    @Select("SELECT * FROM formson_1083 WHERE field0023 = #{field0023}")
    List<LexmisN6_AssetDisposalDetail> selectByField0023(String field0023);

    /**
     * 根据资产名称查询明细信息
     */
    @Select("SELECT * FROM formson_1083 WHERE field0006 = #{field0006}")
    List<LexmisN6_AssetDisposalDetail> selectByField0006(String field0006);

    /**
     * 根据资产类型查询明细信息
     */
    @Select("SELECT * FROM formson_1083 WHERE field0008 = #{field0008}")
    List<LexmisN6_AssetDisposalDetail> selectByField0008(String field0008);

    /**
     * 根据处置方式查询明细信息
     */
    @Select("SELECT * FROM formson_1083 WHERE field0010 = #{field0010}")
    List<LexmisN6_AssetDisposalDetail> selectByField0010(String field0010);

    /**
     * 根据原使用科室查询明细信息
     */
    @Select("SELECT * FROM formson_1083 WHERE field0019 = #{field0019}")
    List<LexmisN6_AssetDisposalDetail> selectByField0019(String field0019);

    /**
     * 根据原管理人查询明细信息
     */
    @Select("SELECT * FROM formson_1083 WHERE field0029 = #{field0029}")
    List<LexmisN6_AssetDisposalDetail> selectByField0029(String field0029);

    /**
     * 查询指定日期范围内的明细信息
     */
    @Select("SELECT * FROM formson_1083 WHERE field0032 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetDisposalDetail> selectByDateRange(String startDate, String endDate);
}