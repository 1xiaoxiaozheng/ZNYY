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
    @Select("SELECT * FROM formson_1072")
    List<LexmisN6_AssetRegistrationDetail> selectAll();

    /**
     * 根据主表ID查询明细信息
     */
    @Select("SELECT * FROM formson_1072 WHERE formmain_id = #{formmainId}")
    List<LexmisN6_AssetRegistrationDetail> selectByFormmainId(Long formmainId);

    /**
     * 根据资产编号查询明细信息
     */
    @Select("SELECT * FROM formson_1072 WHERE field0001 = #{field0001}")
    List<LexmisN6_AssetRegistrationDetail> selectByField0001(String field0001);

    /**
     * 根据资产名称查询明细信息
     */
    @Select("SELECT * FROM formson_1072 WHERE field0002 = #{field0002}")
    List<LexmisN6_AssetRegistrationDetail> selectByField0002(String field0002);

    /**
     * 根据供应商查询明细信息
     */
    @Select("SELECT * FROM formson_1072 WHERE field0013 = #{field0013}")
    List<LexmisN6_AssetRegistrationDetail> selectByField0013(String field0013);

    /**
     * 根据管理科室查询明细信息
     */
    @Select("SELECT * FROM formson_1072 WHERE field0041 = #{field0041}")
    List<LexmisN6_AssetRegistrationDetail> selectByField0041(String field0041);

    /**
     * 根据归属科室查询明细信息
     */
    @Select("SELECT * FROM formson_1072 WHERE field0134 = #{field0134}")
    List<LexmisN6_AssetRegistrationDetail> selectByField0134(String field0134);

    /**
     * 根据归属单位查询明细信息
     */
    @Select("SELECT * FROM formson_1072 WHERE field0153 = #{field0153}")
    List<LexmisN6_AssetRegistrationDetail> selectByField0153(String field0153);

    /**
     * 根据资产类型查询明细信息
     */
    @Select("SELECT * FROM formson_1072 WHERE field0131 = #{field0131}")
    List<LexmisN6_AssetRegistrationDetail> selectByField0131(String field0131);

    /**
     * 根据资产分类查询明细信息
     */
    @Select("SELECT * FROM formson_1072 WHERE field0126 = #{field0126}")
    List<LexmisN6_AssetRegistrationDetail> selectByField0126(String field0126);

    /**
     * 根据资产状态查询明细信息
     */
    @Select("SELECT * FROM formson_1072 WHERE field0174 = #{field0174}")
    List<LexmisN6_AssetRegistrationDetail> selectByField0174(String field0174);

    /**
     * 根据取得日期范围查询明细信息
     */
    @Select("SELECT * FROM formson_1072 WHERE field0032 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetRegistrationDetail> selectByDateRange(String startDate, String endDate);
}