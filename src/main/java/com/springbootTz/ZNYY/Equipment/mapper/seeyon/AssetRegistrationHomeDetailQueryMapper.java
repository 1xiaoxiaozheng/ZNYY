package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetRegistrationHomeDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 资产登记单-家居设备明细查询Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface AssetRegistrationHomeDetailQueryMapper {

    /**
     * 根据主表ID查询家居设备明细信息
     */
    @Select("SELECT " +
            "ID, " +
            "field0001, " +
            "field0002, " +
            "field0006, " +
            "field0007, " +
            "field0010, " +
            "field0014, " +
            "field0031, " +
            "field0032, " +
            "field0036, " +
            "field0047, " +
            "field0048, " +
            "field0058, " +
            "field0059, " +
            "field0066, " +
            "field0072, " +
            "field0099, " +
            "field0102, " +
            "field0108, " +
            "field0125, " +
            "field0126, " +
            "field0128, " +
            "field0131, " +
            "field0133, " +
            "field0134, " +
            "field0145, " +
            "field0150, " +
            "field0151, " +
            "field0153, " +
            "field0154, " +
            "field0155, " +
            "field0156, " +
            "field0158, " +
            "field0159, " +
            "field0160, " +
            "field0161, " +
            "field0171, " +
            "field0172, " +
            "field0173, " +
            "field0174, " +
            "field0175, " +
            "field0176, " +
            "field0177, " +
            "field0178, " +
            "field0179, " +
            "field0180 " +
            "FROM formson_1190 " +
            "WHERE ID = #{id}")
    List<LexmisN6_AssetRegistrationHomeDetail> selectHomeDetailById(Long id);

    /**
     * 查询所有家居设备明细信息
     */
    @Select("SELECT " +
            "ID, " +
            "field0001, " +
            "field0002, " +
            "field0006, " +
            "field0007, " +
            "field0010, " +
            "field0014, " +
            "field0031, " +
            "field0032, " +
            "field0036, " +
            "field0047, " +
            "field0048, " +
            "field0058, " +
            "field0059, " +
            "field0066, " +
            "field0072, " +
            "field0099, " +
            "field0102, " +
            "field0108, " +
            "field0125, " +
            "field0126, " +
            "field0128, " +
            "field0131, " +
            "field0133, " +
            "field0134, " +
            "field0145, " +
            "field0150, " +
            "field0151, " +
            "field0153, " +
            "field0154, " +
            "field0155, " +
            "field0156, " +
            "field0158, " +
            "field0159, " +
            "field0160, " +
            "field0161, " +
            "field0171, " +
            "field0172, " +
            "field0173, " +
            "field0174, " +
            "field0175, " +
            "field0176, " +
            "field0177, " +
            "field0178, " +
            "field0179, " +
            "field0180 " +
            "FROM formson_1190")
    List<LexmisN6_AssetRegistrationHomeDetail> selectAllHomeDetail();

    /**
     * 根据资产编号查询家居设备明细信息
     */
    @Select("SELECT " +
            "ID, " +
            "field0001, " +
            "field0002, " +
            "field0006, " +
            "field0007, " +
            "field0010, " +
            "field0014, " +
            "field0031, " +
            "field0032, " +
            "field0036, " +
            "field0047, " +
            "field0048, " +
            "field0058, " +
            "field0059, " +
            "field0066, " +
            "field0072, " +
            "field0099, " +
            "field0102, " +
            "field0108, " +
            "field0125, " +
            "field0126, " +
            "field0128, " +
            "field0131, " +
            "field0133, " +
            "field0134, " +
            "field0145, " +
            "field0150, " +
            "field0151, " +
            "field0153, " +
            "field0154, " +
            "field0155, " +
            "field0156, " +
            "field0158, " +
            "field0159, " +
            "field0160, " +
            "field0161, " +
            "field0171, " +
            "field0172, " +
            "field0173, " +
            "field0174, " +
            "field0175, " +
            "field0176, " +
            "field0177, " +
            "field0178, " +
            "field0179, " +
            "field0180 " +
            "FROM formson_1190 " +
            "WHERE field0001 = #{assetCode}")
    List<LexmisN6_AssetRegistrationHomeDetail> selectHomeDetailByAssetCode(String assetCode);
}