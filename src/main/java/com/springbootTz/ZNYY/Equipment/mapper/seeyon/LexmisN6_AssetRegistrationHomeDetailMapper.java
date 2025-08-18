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
    @Select("SELECT * FROM formson_0989")
    List<LexmisN6_AssetRegistrationHomeDetail> selectAll();

    /**
     * 根据主表ID查询明细信息
     */
    @Select("SELECT * FROM formson_0989 WHERE formmain_id = #{formmainId}")
    List<LexmisN6_AssetRegistrationHomeDetail> selectByFormmainId(Long formmainId);

    /**
     * 根据资产编号查询明细信息
     */
    @Select("SELECT * FROM formson_0989 WHERE field0001 = #{field0001}")
    List<LexmisN6_AssetRegistrationHomeDetail> selectByField0001(String field0001);

    /**
     * 根据资产名称查询明细信息
     */
    @Select("SELECT * FROM formson_0989 WHERE field0002 = #{field0002}")
    List<LexmisN6_AssetRegistrationHomeDetail> selectByField0002(String field0002);

    /**
     * 根据供应商查询明细信息
     */
    @Select("SELECT * FROM formson_0989 WHERE field0013 = #{field0013}")
    List<LexmisN6_AssetRegistrationHomeDetail> selectByField0013(String field0013);

    /**
     * 根据管理科室查询明细信息
     */
    @Select("SELECT * FROM formson_0989 WHERE field0041 = #{field0041}")
    List<LexmisN6_AssetRegistrationHomeDetail> selectByField0041(String field0041);

    /**
     * 根据归属科室查询明细信息
     */
    @Select("SELECT * FROM formson_0989 WHERE field0134 = #{field0134}")
    List<LexmisN6_AssetRegistrationHomeDetail> selectByField0134(String field0134);

    /**
     * 根据归属单位查询明细信息
     */
    @Select("SELECT * FROM formson_0989 WHERE field0153 = #{field0153}")
    List<LexmisN6_AssetRegistrationHomeDetail> selectByField0153(String field0153);

    /**
     * 根据资产类型查询明细信息
     */
    @Select("SELECT * FROM formson_0989 WHERE field0131 = #{field0131}")
    List<LexmisN6_AssetRegistrationHomeDetail> selectByField0131(String field0131);

    /**
     * 根据资产分类查询明细信息
     */
    @Select("SELECT * FROM formson_0989 WHERE field0126 = #{field0126}")
    List<LexmisN6_AssetRegistrationHomeDetail> selectByField0126(String field0126);

    /**
     * 根据取得日期范围查询明细信息
     */
    @Select("SELECT * FROM formson_0989 WHERE field0032 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetRegistrationHomeDetail> selectByDateRange(String startDate, String endDate);
}