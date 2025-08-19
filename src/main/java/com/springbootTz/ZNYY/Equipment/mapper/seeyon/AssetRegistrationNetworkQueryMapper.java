package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.springbootTz.ZNYY.Equipment.dto.AssetRegistrationNetworkWithDetailDTO;

/**
 * 资产登记-网络信息设备关联查询Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface AssetRegistrationNetworkQueryMapper {

        /**
         * 根据主表ID查询资产登记-网络信息设备与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0001, " +
                        "m.field0002, " +
                        "m.field0003, " +
                        "m.field0004, " +
                        "m.field0005, " +
                        "m.field0006, " +
                        "m.field0047, " +
                        "m.field0048, " +
                        "m.field0051, " +
                        "m.field0052, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0007, " +
                        "d.field0008, " +
                        "d.field0009, " +
                        "d.field0010, " +
                        "d.field0011, " +
                        "d.field0012, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0015, " +
                        "d.field0016, " +
                        "d.field0018, " +
                        "d.field0019, " +
                        "d.field0020, " +
                        "d.field0021, " +
                        "d.field0022, " +
                        "d.field0023, " +
                        "d.field0024, " +
                        "d.field0025, " +
                        "d.field0026, " +
                        "d.field0027, " +
                        "d.field0028, " +
                        "d.field0029, " +
                        "d.field0030, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0033, " +
                        "d.field0034, " +
                        "d.field0035, " +
                        "d.field0036, " +
                        "d.field0037, " +
                        "d.field0038, " +
                        "d.field0039, " +
                        "d.field0040, " +
                        "d.field0041, " +
                        "d.field0042, " +
                        "d.field0043, " +
                        "d.field0044, " +
                        "d.field0045, " +
                        "d.field0046, " +
                        "d.field0049, " +
                        "d.field0050, " +
                        "d.field0053, " +
                        "d.formmain_id " +
                        "FROM formmain_1060 m " +
                        "LEFT JOIN formson_1061 d ON m.ID = d.formmain_id " +
                        "WHERE m.ID = #{id}")
        List<AssetRegistrationNetworkWithDetailDTO> selectByMainId(Long id);

        /**
         * 根据单据编号查询资产登记-网络信息设备与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0001, " +
                        "m.field0002, " +
                        "m.field0003, " +
                        "m.field0004, " +
                        "m.field0005, " +
                        "m.field0006, " +
                        "m.field0047, " +
                        "m.field0048, " +
                        "m.field0051, " +
                        "m.field0052, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0007, " +
                        "d.field0008, " +
                        "d.field0009, " +
                        "d.field0010, " +
                        "d.field0011, " +
                        "d.field0012, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0015, " +
                        "d.field0016, " +
                        "d.field0018, " +
                        "d.field0019, " +
                        "d.field0020, " +
                        "d.field0021, " +
                        "d.field0022, " +
                        "d.field0023, " +
                        "d.field0024, " +
                        "d.field0025, " +
                        "d.field0026, " +
                        "d.field0027, " +
                        "d.field0028, " +
                        "d.field0029, " +
                        "d.field0030, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0033, " +
                        "d.field0034, " +
                        "d.field0035, " +
                        "d.field0036, " +
                        "d.field0037, " +
                        "d.field0038, " +
                        "d.field0039, " +
                        "d.field0040, " +
                        "d.field0041, " +
                        "d.field0042, " +
                        "d.field0043, " +
                        "d.field0044, " +
                        "d.field0045, " +
                        "d.field0046, " +
                        "d.field0049, " +
                        "d.field0050, " +
                        "d.field0053, " +
                        "d.formmain_id " +
                        "FROM formmain_1060 m " +
                        "LEFT JOIN formson_1061 d ON m.ID = d.formmain_id " +
                        "WHERE m.field0001 = #{field0001}")
        List<AssetRegistrationNetworkWithDetailDTO> selectByField0001(String field0001);

        /**
         * 根据填报人查询资产登记-网络信息设备与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0001, " +
                        "m.field0002, " +
                        "m.field0003, " +
                        "m.field0004, " +
                        "m.field0005, " +
                        "m.field0006, " +
                        "m.field0047, " +
                        "m.field0048, " +
                        "m.field0051, " +
                        "m.field0052, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0007, " +
                        "d.field0008, " +
                        "d.field0009, " +
                        "d.field0010, " +
                        "d.field0011, " +
                        "d.field0012, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0015, " +
                        "d.field0016, " +
                        "d.field0018, " +
                        "d.field0019, " +
                        "d.field0020, " +
                        "d.field0021, " +
                        "d.field0022, " +
                        "d.field0023, " +
                        "d.field0024, " +
                        "d.field0025, " +
                        "d.field0026, " +
                        "d.field0027, " +
                        "d.field0028, " +
                        "d.field0029, " +
                        "d.field0030, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0033, " +
                        "d.field0034, " +
                        "d.field0035, " +
                        "d.field0036, " +
                        "d.field0037, " +
                        "d.field0038, " +
                        "d.field0039, " +
                        "d.field0040, " +
                        "d.field0041, " +
                        "d.field0042, " +
                        "d.field0043, " +
                        "d.field0044, " +
                        "d.field0045, " +
                        "d.field0046, " +
                        "d.field0049, " +
                        "d.field0050, " +
                        "d.field0053, " +
                        "d.formmain_id " +
                        "FROM formmain_1060 m " +
                        "LEFT JOIN formson_1061 d ON m.ID = d.formmain_id " +
                        "WHERE m.field0002 = #{field0002}")
        List<AssetRegistrationNetworkWithDetailDTO> selectByField0002(String field0002);

        /**
         * 根据所属科室查询资产登记-网络信息设备与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0001, " +
                        "m.field0002, " +
                        "m.field0003, " +
                        "m.field0004, " +
                        "m.field0005, " +
                        "m.field0006, " +
                        "m.field0047, " +
                        "m.field0048, " +
                        "m.field0051, " +
                        "m.field0052, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0007, " +
                        "d.field0008, " +
                        "d.field0009, " +
                        "d.field0010, " +
                        "d.field0011, " +
                        "d.field0012, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0015, " +
                        "d.field0016, " +
                        "d.field0018, " +
                        "d.field0019, " +
                        "d.field0020, " +
                        "d.field0021, " +
                        "d.field0022, " +
                        "d.field0023, " +
                        "d.field0024, " +
                        "d.field0025, " +
                        "d.field0026, " +
                        "d.field0027, " +
                        "d.field0028, " +
                        "d.field0029, " +
                        "d.field0030, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0033, " +
                        "d.field0034, " +
                        "d.field0035, " +
                        "d.field0036, " +
                        "d.field0037, " +
                        "d.field0038, " +
                        "d.field0039, " +
                        "d.field0040, " +
                        "d.field0041, " +
                        "d.field0042, " +
                        "d.field0043, " +
                        "d.field0044, " +
                        "d.field0045, " +
                        "d.field0046, " +
                        "d.field0049, " +
                        "d.field0050, " +
                        "d.field0053, " +
                        "d.formmain_id " +
                        "FROM formmain_1060 m " +
                        "LEFT JOIN formson_1061 d ON m.ID = d.formmain_id " +
                        "WHERE m.field0003 = #{field0003}")
        List<AssetRegistrationNetworkWithDetailDTO> selectByField0003(String field0003);

        /**
         * 根据单位查询资产登记-网络信息设备与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0001, " +
                        "m.field0002, " +
                        "m.field0003, " +
                        "m.field0004, " +
                        "m.field0005, " +
                        "m.field0006, " +
                        "m.field0047, " +
                        "m.field0048, " +
                        "m.field0051, " +
                        "m.field0052, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0007, " +
                        "d.field0008, " +
                        "d.field0009, " +
                        "d.field0010, " +
                        "d.field0011, " +
                        "d.field0012, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0015, " +
                        "d.field0016, " +
                        "d.field0018, " +
                        "d.field0019, " +
                        "d.field0020, " +
                        "d.field0021, " +
                        "d.field0022, " +
                        "d.field0023, " +
                        "d.field0024, " +
                        "d.field0025, " +
                        "d.field0026, " +
                        "d.field0027, " +
                        "d.field0028, " +
                        "d.field0029, " +
                        "d.field0030, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0033, " +
                        "d.field0034, " +
                        "d.field0035, " +
                        "d.field0036, " +
                        "d.field0037, " +
                        "d.field0038, " +
                        "d.field0039, " +
                        "d.field0040, " +
                        "d.field0041, " +
                        "d.field0042, " +
                        "d.field0043, " +
                        "d.field0044, " +
                        "d.field0045, " +
                        "d.field0046, " +
                        "d.field0049, " +
                        "d.field0050, " +
                        "d.field0053, " +
                        "d.formmain_id " +
                        "FROM formmain_1060 m " +
                        "LEFT JOIN formson_1061 d ON m.ID = d.formmain_id " +
                        "WHERE m.field0006 = #{field0006}")
        List<AssetRegistrationNetworkWithDetailDTO> selectByField0006(String field0006);

        /**
         * 根据填报日期范围查询资产登记-网络信息设备与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0001, " +
                        "m.field0002, " +
                        "m.field0003, " +
                        "m.field0004, " +
                        "m.field0005, " +
                        "m.field0006, " +
                        "m.field0047, " +
                        "m.field0048, " +
                        "m.field0051, " +
                        "m.field0052, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0007, " +
                        "d.field0008, " +
                        "d.field0009, " +
                        "d.field0010, " +
                        "d.field0011, " +
                        "d.field0012, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0015, " +
                        "d.field0016, " +
                        "d.field0018, " +
                        "d.field0019, " +
                        "d.field0020, " +
                        "d.field0021, " +
                        "d.field0022, " +
                        "d.field0023, " +
                        "d.field0024, " +
                        "d.field0025, " +
                        "d.field0026, " +
                        "d.field0027, " +
                        "d.field0028, " +
                        "d.field0029, " +
                        "d.field0030, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0033, " +
                        "d.field0034, " +
                        "d.field0035, " +
                        "d.field0036, " +
                        "d.field0037, " +
                        "d.field0038, " +
                        "d.field0039, " +
                        "d.field0040, " +
                        "d.field0041, " +
                        "d.field0042, " +
                        "d.field0043, " +
                        "d.field0044, " +
                        "d.field0045, " +
                        "d.field0046, " +
                        "d.field0049, " +
                        "d.field0050, " +
                        "d.field0053, " +
                        "d.formmain_id " +
                        "FROM formmain_1060 m " +
                        "LEFT JOIN formson_1061 d ON m.ID = d.formmain_id " +
                        "WHERE m.field0004 BETWEEN #{startDate} AND #{endDate}")
        List<AssetRegistrationNetworkWithDetailDTO> selectByDateRange(String startDate, String endDate);

        /**
         * 查询所有资产登记-网络信息设备与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0001, " +
                        "m.field0002, " +
                        "m.field0003, " +
                        "m.field0004, " +
                        "m.field0005, " +
                        "m.field0006, " +
                        "m.field0047, " +
                        "m.field0048, " +
                        "m.field0051, " +
                        "m.field0052, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0007, " +
                        "d.field0008, " +
                        "d.field0009, " +
                        "d.field0010, " +
                        "d.field0011, " +
                        "d.field0012, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0015, " +
                        "d.field0016, " +
                        "d.field0018, " +
                        "d.field0019, " +
                        "d.field0020, " +
                        "d.field0021, " +
                        "d.field0022, " +
                        "d.field0023, " +
                        "d.field0024, " +
                        "d.field0025, " +
                        "d.field0026, " +
                        "d.field0027, " +
                        "d.field0028, " +
                        "d.field0029, " +
                        "d.field0030, " +
                        "d.field0031, " +
                        "d.field0032, " +
                        "d.field0033, " +
                        "d.field0034, " +
                        "d.field0035, " +
                        "d.field0036, " +
                        "d.field0037, " +
                        "d.field0038, " +
                        "d.field0039, " +
                        "d.field0040, " +
                        "d.field0041, " +
                        "d.field0042, " +
                        "d.field0043, " +
                        "d.field0044, " +
                        "d.field0045, " +
                        "d.field0046, " +
                        "d.field0049, " +
                        "d.field0050, " +
                        "d.field0053, " +
                        "d.formmain_id " +
                        "FROM formmain_1060 m " +
                        "LEFT JOIN formson_1061 d ON m.ID = d.formmain_id")
        List<AssetRegistrationNetworkWithDetailDTO> selectAll();
}