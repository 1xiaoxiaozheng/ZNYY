package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetRegistrationVehicleDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_AssetRegistrationVehicleDetail Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetRegistrationVehicleDetailMapper
        extends BaseMapper<LexmisN6_AssetRegistrationVehicleDetail> {

    /**
     * 查询所有资产登记-车辆明细信息
     */
    @Select("SELECT * FROM formson_1056")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectAll();

    /**
     * 根据主表ID查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE formmain_id = #{formmainId}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByFormmainId(Long formmainId);

    /**
     * 根据资产编号查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0006 = #{field0006}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByField0006(String field0006);

    /**
     * 根据资产名称查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0007 = #{field0007}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByField0007(String field0007);

    /**
     * 根据车牌号查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0044 = #{field0044}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByField0044(String field0044);

    /**
     * 根据发动机号查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0046 = #{field0046}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByField0046(String field0046);

    /**
     * 根据车辆识别代码查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0047 = #{field0047}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByField0047(String field0047);

    /**
     * 根据供应商查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0031 = #{field0031}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByField0031(String field0031);

    /**
     * 根据管理科室查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0016 = #{field0016}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByField0016(String field0016);

    /**
     * 根据使用科室查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0017 = #{field0017}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByField0017(String field0017);

    /**
     * 根据归属科室查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0018 = #{field0018}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByField0018(String field0018);

    /**
     * 根据归属单位查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0019 = #{field0019}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByField0019(String field0019);

    /**
     * 根据资产类型查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0008 = #{field0008}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByField0008(String field0008);

    /**
     * 根据资产分类查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0009 = #{field0009}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByField0009(String field0009);

    /**
     * 根据车辆类型查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0043 = #{field0043}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByField0043(String field0043);

    /**
     * 根据取得日期范围查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0038 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByDateRange(String startDate, String endDate);

    /**
     * 根据原始价值范围查询明细信息
     */
    @Select("SELECT * FROM formson_1056 WHERE field0013 BETWEEN #{minValue} AND #{maxValue}")
    List<LexmisN6_AssetRegistrationVehicleDetail> selectByValueRange(String minValue, String maxValue);
}