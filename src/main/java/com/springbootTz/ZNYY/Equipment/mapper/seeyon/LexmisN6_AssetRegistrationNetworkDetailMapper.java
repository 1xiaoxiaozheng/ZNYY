package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetRegistrationNetworkDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.math.BigDecimal;

/**
 * LexmisN6_AssetRegistrationNetworkDetail Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetRegistrationNetworkDetailMapper
        extends BaseMapper<LexmisN6_AssetRegistrationNetworkDetail> {

    /**
     * 查询所有资产登记-网络信息设备明细信息
     */
    @Select("SELECT * FROM formson_1061")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectAll();

    /**
     * 根据主表ID查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE formmain_id = #{formmainId}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByFormmainId(Long formmainId);

    /**
     * 根据资产编号查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0007 = #{field0007}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByField0007(String field0007);

    /**
     * 根据资产名称查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0008 = #{field0008}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByField0008(String field0008);

    /**
     * 根据资产类型查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0009 = #{field0009}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByField0009(String field0009);

    /**
     * 根据资产分类查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0010 = #{field0010}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByField0010(String field0010);

    /**
     * 根据供应商查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0037 = #{field0037}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByField0037(String field0037);

    /**
     * 根据管理科室查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0017 = #{field0017}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByField0017(String field0017);

    /**
     * 根据归属科室查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0018 = #{field0018}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByField0018(String field0018);

    /**
     * 根据归属单位查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0019 = #{field0019}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByField0019(String field0019);

    /**
     * 根据品牌查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0039 = #{field0039}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByField0039(String field0039);

    /**
     * 根据生产厂家查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0043 = #{field0043}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByField0043(String field0043);

    /**
     * 根据取得日期范围查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0044 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByDateRange(String startDate, String endDate);

    /**
     * 根据原始价值范围查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0014 BETWEEN #{minValue} AND #{maxValue}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByValueRange(String minValue, String maxValue);

    /**
     * 根据财务入账状态查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0023 = #{field0023}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByField0023(BigDecimal field0023);

    /**
     * 根据资产用途查询明细信息
     */
    @Select("SELECT * FROM formson_1061 WHERE field0026 = #{field0026}")
    List<LexmisN6_AssetRegistrationNetworkDetail> selectByField0026(BigDecimal field0026);
}