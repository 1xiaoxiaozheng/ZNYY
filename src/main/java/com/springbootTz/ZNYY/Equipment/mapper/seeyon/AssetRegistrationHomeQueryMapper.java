package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.springbootTz.ZNYY.Equipment.dto.AssetRegistrationHomeWithDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 资产登记单-家居设备关联查询Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface AssetRegistrationHomeQueryMapper {

        /**
         * 根据主表ID查询家居设备资产登记单与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0017, " +
                        "m.field0024, " +
                        "m.field0026, " +
                        "m.field0027, " +
                        "m.field0028, " +
                        "m.field0152, " +
                        "m.field0162, " +
                        "m.field0163, " +
                        "m.field0164, " +
                        "m.field0165, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0001, " +
                        "d.field0002, " +
                        "d.field0006, " +
                        "d.field0007, " +
                        "d.field0010, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0036, " +
                        "d.field0047, " +
                        "d.field0048, " +
                        "d.field0058, " +
                        "d.field0059, " +
                        "d.field0066, " +
                        "d.field0072, " +
                        "d.field0099, " +
                        "d.field0102, " +
                        "d.field0108, " +
                        "d.field0125, " +
                        "d.field0126, " +
                        "d.field0128, " +
                        "d.field0131, " +
                        "d.field0133, " +
                        "d.field0134, " +
                        "d.field0145, " +
                        "d.field0150, " +
                        "d.field0151, " +
                        "d.field0153, " +
                        "d.field0154, " +
                        "d.field0155, " +
                        "d.field0156, " +
                        "d.field0158, " +
                        "d.field0159, " +
                        "d.field0160, " +
                        "d.field0161, " +
                        "d.field0166, " +
                        "d.field0167, " +
                        "d.field0168, " +
                        "d.field0169, " +
                        "d.field0170, " +
                        "d.field0171, " +
                        "d.field0172, " +
                        "d.formmain_id " +
                        "FROM formmain_0988 m " +
                        "LEFT JOIN formson_0989 d ON m.ID = d.formmain_id " +
                        "WHERE m.ID = #{id}")
        List<AssetRegistrationHomeWithDetailDTO> selectByMainId(Long id);

        /**
         * 根据单据编号查询家居设备资产登记单与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0017, " +
                        "m.field0024, " +
                        "m.field0026, " +
                        "m.field0027, " +
                        "m.field0028, " +
                        "m.field0152, " +
                        "m.field0162, " +
                        "m.field0163, " +
                        "m.field0164, " +
                        "m.field0165, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0001, " +
                        "d.field0002, " +
                        "d.field0006, " +
                        "d.field0007, " +
                        "d.field0010, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0036, " +
                        "d.field0047, " +
                        "d.field0048, " +
                        "d.field0058, " +
                        "d.field0059, " +
                        "d.field0066, " +
                        "d.field0072, " +
                        "d.field0099, " +
                        "d.field0102, " +
                        "d.field0108, " +
                        "d.field0125, " +
                        "d.field0126, " +
                        "d.field0128, " +
                        "d.field0131, " +
                        "d.field0133, " +
                        "d.field0134, " +
                        "d.field0145, " +
                        "d.field0150, " +
                        "d.field0151, " +
                        "d.field0153, " +
                        "d.field0154, " +
                        "d.field0155, " +
                        "d.field0156, " +
                        "d.field0158, " +
                        "d.field0159, " +
                        "d.field0160, " +
                        "d.field0161, " +
                        "d.field0166, " +
                        "d.field0167, " +
                        "d.field0168, " +
                        "d.field0169, " +
                        "d.field0170, " +
                        "d.field0171, " +
                        "d.field0172, " +
                        "d.formmain_id " +
                        "FROM formmain_0988 m " +
                        "LEFT JOIN formson_0989 d ON m.ID = d.formmain_id " +
                        "WHERE m.field0017 = #{field0017}")
        List<AssetRegistrationHomeWithDetailDTO> selectByField0017(String field0017);

        /**
         * 根据填报人查询家居设备资产登记单与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0017, " +
                        "m.field0024, " +
                        "m.field0026, " +
                        "m.field0027, " +
                        "m.field0028, " +
                        "m.field0152, " +
                        "m.field0162, " +
                        "m.field0163, " +
                        "m.field0164, " +
                        "m.field0165, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0001, " +
                        "d.field0002, " +
                        "d.field0006, " +
                        "d.field0007, " +
                        "d.field0010, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0036, " +
                        "d.field0047, " +
                        "d.field0048, " +
                        "d.field0058, " +
                        "d.field0059, " +
                        "d.field0066, " +
                        "d.field0072, " +
                        "d.field0099, " +
                        "d.field0102, " +
                        "d.field0108, " +
                        "d.field0125, " +
                        "d.field0126, " +
                        "d.field0128, " +
                        "d.field0131, " +
                        "d.field0133, " +
                        "d.field0134, " +
                        "d.field0145, " +
                        "d.field0150, " +
                        "d.field0151, " +
                        "d.field0153, " +
                        "d.field0154, " +
                        "d.field0155, " +
                        "d.field0156, " +
                        "d.field0158, " +
                        "d.field0159, " +
                        "d.field0160, " +
                        "d.field0161, " +
                        "d.field0166, " +
                        "d.field0167, " +
                        "d.field0168, " +
                        "d.field0169, " +
                        "d.field0170, " +
                        "d.field0171, " +
                        "d.field0172, " +
                        "d.formmain_id " +
                        "FROM formmain_0988 m " +
                        "LEFT JOIN formson_0989 d ON m.ID = d.formmain_id " +
                        "WHERE m.field0026 = #{field0026}")
        List<AssetRegistrationHomeWithDetailDTO> selectByField0026(String field0026);

        /**
         * 根据所属科室查询家居设备资产登记单与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0017, " +
                        "m.field0024, " +
                        "m.field0026, " +
                        "m.field0027, " +
                        "m.field0028, " +
                        "m.field0152, " +
                        "m.field0162, " +
                        "m.field0163, " +
                        "m.field0164, " +
                        "m.field0165, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0001, " +
                        "d.field0002, " +
                        "d.field0006, " +
                        "d.field0007, " +
                        "d.field0010, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0036, " +
                        "d.field0047, " +
                        "d.field0048, " +
                        "d.field0058, " +
                        "d.field0059, " +
                        "d.field0066, " +
                        "d.field0072, " +
                        "d.field0099, " +
                        "d.field0102, " +
                        "d.field0108, " +
                        "d.field0125, " +
                        "d.field0126, " +
                        "d.field0128, " +
                        "d.field0131, " +
                        "d.field0133, " +
                        "d.field0134, " +
                        "d.field0145, " +
                        "d.field0150, " +
                        "d.field0151, " +
                        "d.field0153, " +
                        "d.field0154, " +
                        "d.field0155, " +
                        "d.field0156, " +
                        "d.field0158, " +
                        "d.field0159, " +
                        "d.field0160, " +
                        "d.field0161, " +
                        "d.field0166, " +
                        "d.field0167, " +
                        "d.field0168, " +
                        "d.field0169, " +
                        "d.field0170, " +
                        "d.field0171, " +
                        "d.field0172, " +
                        "d.formmain_id " +
                        "FROM formmain_0988 m " +
                        "LEFT JOIN formson_0989 d ON m.ID = d.formmain_id " +
                        "WHERE m.field0027 = #{field0027}")
        List<AssetRegistrationHomeWithDetailDTO> selectByField0027(String field0027);

        /**
         * 根据单位查询家居设备资产登记单与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0017, " +
                        "m.field0024, " +
                        "m.field0026, " +
                        "m.field0027, " +
                        "m.field0028, " +
                        "m.field0152, " +
                        "m.field0162, " +
                        "m.field0163, " +
                        "m.field0164, " +
                        "m.field0165, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0001, " +
                        "d.field0002, " +
                        "d.field0006, " +
                        "d.field0007, " +
                        "d.field0010, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0036, " +
                        "d.field0047, " +
                        "d.field0048, " +
                        "d.field0058, " +
                        "d.field0059, " +
                        "d.field0066, " +
                        "d.field0072, " +
                        "d.field0099, " +
                        "d.field0102, " +
                        "d.field0108, " +
                        "d.field0125, " +
                        "d.field0126, " +
                        "d.field0128, " +
                        "d.field0131, " +
                        "d.field0133, " +
                        "d.field0134, " +
                        "d.field0145, " +
                        "d.field0150, " +
                        "d.field0151, " +
                        "d.field0153, " +
                        "d.field0154, " +
                        "d.field0155, " +
                        "d.field0156, " +
                        "d.field0158, " +
                        "d.field0159, " +
                        "d.field0160, " +
                        "d.field0161, " +
                        "d.field0166, " +
                        "d.field0167, " +
                        "d.field0168, " +
                        "d.field0169, " +
                        "d.field0170, " +
                        "d.field0171, " +
                        "d.field0172, " +
                        "d.formmain_id " +
                        "FROM formmain_0988 m " +
                        "LEFT JOIN formson_0989 d ON m.ID = d.formmain_id " +
                        "WHERE m.field0152 = #{field0152}")
        List<AssetRegistrationHomeWithDetailDTO> selectByField0152(String field0152);

        /**
         * 根据填报日期范围查询家居设备资产登记单与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0017, " +
                        "m.field0024, " +
                        "m.field0026, " +
                        "m.field0027, " +
                        "m.field0028, " +
                        "m.field0152, " +
                        "m.field0162, " +
                        "m.field0163, " +
                        "m.field0164, " +
                        "m.field0165, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0001, " +
                        "d.field0002, " +
                        "d.field0006, " +
                        "d.field0007, " +
                        "d.field0010, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0036, " +
                        "d.field0047, " +
                        "d.field0048, " +
                        "d.field0058, " +
                        "d.field0059, " +
                        "d.field0066, " +
                        "d.field0072, " +
                        "d.field0099, " +
                        "d.field0102, " +
                        "d.field0108, " +
                        "d.field0125, " +
                        "d.field0126, " +
                        "d.field0128, " +
                        "d.field0131, " +
                        "d.field0133, " +
                        "d.field0134, " +
                        "d.field0145, " +
                        "d.field0150, " +
                        "d.field0151, " +
                        "d.field0153, " +
                        "d.field0154, " +
                        "d.field0155, " +
                        "d.field0156, " +
                        "d.field0158, " +
                        "d.field0159, " +
                        "d.field0160, " +
                        "d.field0161, " +
                        "d.field0166, " +
                        "d.field0167, " +
                        "d.field0168, " +
                        "d.field0169, " +
                        "d.field0170, " +
                        "d.field0171, " +
                        "d.field0172, " +
                        "d.formmain_id " +
                        "FROM formmain_0988 m " +
                        "LEFT JOIN formson_0989 d ON m.ID = d.formmain_id " +
                        "WHERE m.field0028 BETWEEN #{startDate} AND #{endDate}")
        List<AssetRegistrationHomeWithDetailDTO> selectByDateRange(String startDate, String endDate);

        /**
         * 查询所有家居设备资产登记单与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0017, " +
                        "m.field0024, " +
                        "m.field0026, " +
                        "m.field0027, " +
                        "m.field0028, " +
                        "m.field0152, " +
                        "m.field0162, " +
                        "m.field0163, " +
                        "m.field0164, " +
                        "m.field0165, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0001, " +
                        "d.field0002, " +
                        "d.field0006, " +
                        "d.field0007, " +
                        "d.field0010, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0036, " +
                        "d.field0047, " +
                        "d.field0048, " +
                        "d.field0058, " +
                        "d.field0059, " +
                        "d.field0066, " +
                        "d.field0072, " +
                        "d.field0099, " +
                        "d.field0102, " +
                        "d.field0108, " +
                        "d.field0125, " +
                        "d.field0126, " +
                        "d.field0128, " +
                        "d.field0131, " +
                        "d.field0133, " +
                        "d.field0134, " +
                        "d.field0145, " +
                        "d.field0150, " +
                        "d.field0151, " +
                        "d.field0153, " +
                        "d.field0154, " +
                        "d.field0155, " +
                        "d.field0156, " +
                        "d.field0158, " +
                        "d.field0159, " +
                        "d.field0160, " +
                        "d.field0161, " +
                        "d.field0166, " +
                        "d.field0167, " +
                        "d.field0168, " +
                        "d.field0169, " +
                        "d.field0170, " +
                        "d.field0171, " +
                        "d.field0172, " +
                        "d.formmain_id " +
                        "FROM formmain_0988 m " +
                        "LEFT JOIN formson_0989 d ON m.ID = d.formmain_id")
        List<AssetRegistrationHomeWithDetailDTO> selectAll();
}