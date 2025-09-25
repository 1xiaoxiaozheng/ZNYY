package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.springbootTz.ZNYY.Equipment.dto.AssetRegistrationVehicleWithDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 资产登记单-车辆关联查询Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface AssetRegistrationVehicleQueryMapper {

        /**
         * 查询所有车辆资产登记单与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0001, " +
                        "m.field0002, " +
                        "m.field0003, " +
                        "m.field0004, " +
                        "m.field0005, " +
                        "m.field0060, " +
                        "m.field0061, " +
                        "m.field0062, " +
                        "m.field0063, " +
                        "m.field0064, " +
                        "m.field0067, " +
                        "m.field0068, " +
                        "m.field0072, " +
                        "m.field0073, " +
                        "m.field0075, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0006, " +
                        "d.field0007, " +
                        "d.field0008, " +
                        "d.field0009, " +
                        "d.field0010, " +
                        "d.field0011, " +
                        "d.field0012, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0015, " +
                        "d.field0017, " +
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
                        "d.field0047, " +
                        "d.field0048, " +
                        "d.field0049, " +
                        "d.field0050, " +
                        "d.field0051, " +
                        "d.field0052, " +
                        "d.field0054, " +
                        "d.field0055, " +
                        "d.field0056, " +
                        "d.field0057, " +
                        "d.field0058, " +
                        "d.field0059, " +
                        "d.field0065, " +
                        "d.field0066, " +
                        "d.field0069, " +
                        "d.field0070, " +
                        "d.field0071, " +
                        "d.field0074, " +
                        "d.formmain_id " +
                        "FROM formmain_1195 m " +
                        "LEFT JOIN formson_1196 d ON m.ID = d.formmain_id")
        List<AssetRegistrationVehicleWithDetailDTO> selectAll();

        /**
         * 根据主表ID查询车辆资产登记单与明细的关联信息
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0001, " +
                        "m.field0002, " +
                        "m.field0003, " +
                        "m.field0004, " +
                        "m.field0005, " +
                        "m.field0060, " +
                        "m.field0061, " +
                        "m.field0062, " +
                        "m.field0063, " +
                        "m.field0064, " +
                        "m.field0067, " +
                        "m.field0068, " +
                        "m.field0072, " +
                        "m.field0073, " +
                        "m.field0075, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0006, " +
                        "d.field0007, " +
                        "d.field0008, " +
                        "d.field0009, " +
                        "d.field0010, " +
                        "d.field0011, " +
                        "d.field0012, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0015, " +
                        "d.field0017, " +
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
                        "d.field0047, " +
                        "d.field0048, " +
                        "d.field0049, " +
                        "d.field0050, " +
                        "d.field0051, " +
                        "d.field0052, " +
                        "d.field0054, " +
                        "d.field0055, " +
                        "d.field0056, " +
                        "d.field0057, " +
                        "d.field0058, " +
                        "d.field0059, " +
                        "d.field0065, " +
                        "d.field0066, " +
                        "d.field0069, " +
                        "d.field0070, " +
                        "d.field0071, " +
                        "d.field0074, " +
                        "d.formmain_id " +
                        "FROM formmain_1195 m " +
                        "LEFT JOIN formson_1196 d ON m.ID = d.formmain_id " +
                        "WHERE m.ID = #{id}")
        AssetRegistrationVehicleWithDetailDTO selectById(Long id);
}