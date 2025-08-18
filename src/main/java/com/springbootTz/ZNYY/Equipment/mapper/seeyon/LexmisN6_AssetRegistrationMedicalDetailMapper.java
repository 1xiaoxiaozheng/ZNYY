package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetRegistrationMedicalDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_AssetRegistrationMedicalDetail Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetRegistrationMedicalDetailMapper
        extends BaseMapper<LexmisN6_AssetRegistrationMedicalDetail> {

    /**
     * 查询所有医疗专用设备资产登记单明细信息
     */
    @Select("SELECT * FROM formson_1058")
    List<LexmisN6_AssetRegistrationMedicalDetail> selectAll();

    /**
     * 根据主表ID查询明细信息
     */
    @Select("SELECT * FROM formson_1058 WHERE formmain_id = #{formmainId}")
    List<LexmisN6_AssetRegistrationMedicalDetail> selectByFormmainId(Long formmainId);

    /**
     * 根据资产编号查询明细信息
     */
    @Select("SELECT * FROM formson_1058 WHERE field0006 = #{field0006}")
    List<LexmisN6_AssetRegistrationMedicalDetail> selectByField0006(String field0006);

    /**
     * 根据资产名称查询明细信息
     */
    @Select("SELECT * FROM formson_1058 WHERE field0007 = #{field0007}")
    List<LexmisN6_AssetRegistrationMedicalDetail> selectByField0007(String field0007);

    /**
     * 根据资产类型查询明细信息
     */
    @Select("SELECT * FROM formson_1058 WHERE field0008 = #{field0008}")
    List<LexmisN6_AssetRegistrationMedicalDetail> selectByField0008(String field0008);

    /**
     * 根据资产分类查询明细信息
     */
    @Select("SELECT * FROM formson_1058 WHERE field0009 = #{field0009}")
    List<LexmisN6_AssetRegistrationMedicalDetail> selectByField0009(String field0009);

    /**
     * 根据供应商查询明细信息
     */
    @Select("SELECT * FROM formson_1058 WHERE field0031 = #{field0031}")
    List<LexmisN6_AssetRegistrationMedicalDetail> selectByField0031(String field0031);

    /**
     * 根据管理科室查询明细信息
     */
    @Select("SELECT * FROM formson_1058 WHERE field0016 = #{field0016}")
    List<LexmisN6_AssetRegistrationMedicalDetail> selectByField0016(String field0016);

    /**
     * 根据归属科室查询明细信息
     */
    @Select("SELECT * FROM formson_1058 WHERE field0018 = #{field0018}")
    List<LexmisN6_AssetRegistrationMedicalDetail> selectByField0018(String field0018);

    /**
     * 根据归属单位查询明细信息
     */
    @Select("SELECT * FROM formson_1058 WHERE field0019 = #{field0019}")
    List<LexmisN6_AssetRegistrationMedicalDetail> selectByField0019(String field0019);

    /**
     * 根据取得日期范围查询明细信息
     */
    @Select("SELECT * FROM formson_1058 WHERE field0038 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetRegistrationMedicalDetail> selectByDateRange(String startDate, String endDate);
}