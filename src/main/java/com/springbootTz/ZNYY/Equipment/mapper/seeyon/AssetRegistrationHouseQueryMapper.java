package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.springbootTz.ZNYY.Equipment.dto.AssetRegistrationHouseWithDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 资产登记-房屋土地关联查询Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface AssetRegistrationHouseQueryMapper {

    /**
     * 查询所有资产登记-房屋土地与明细的关联信息
     */
    @Select("SELECT " +
            "m.ID as id, " +
            "m.field0001, " +
            "m.field0002, " +
            "m.field0003, " +
            "m.field0004, " +
            "m.field0005, " +
            "m.field0047, " +
            "m.field0066, " +
            "m.field0067, " +
            "m.field0068, " +
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
            "d.field0042, " +
            "d.field0043, " +
            "d.field0044, " +
            "d.field0045, " +
            "d.field0046, " +
            "d.field0048, " +
            "d.field0049, " +
            "d.field0050, " +
            "d.field0051, " +
            "d.field0052, " +
            "d.field0053, " +
            "d.field0054, " +
            "d.field0055, " +
            "d.field0056, " +
            "d.field0057, " +
            "d.field0058, " +
            "d.field0059, " +
            "d.field0060, " +
            "d.field0061, " +
            "d.field0062, " +
            "d.field0063, " +
            "d.field0064, " +
            "d.field0065, " +
            "d.field0069, " +
            "d.field0070, " +
            "d.formmain_id " +
            "FROM formmain_1053 m " +
            "LEFT JOIN formson_1054 d ON m.ID = d.formmain_id")
    List<AssetRegistrationHouseWithDetailDTO> selectAll();
}