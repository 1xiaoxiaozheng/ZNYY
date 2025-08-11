package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.springbootTz.ZNYY.Equipment.dto.AssetDisposalWithDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 资产处置单关联查询Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface AssetDisposalQueryMapper {

    /**
     * 根据主表ID查询资产处置单与明细的关联信息
     */
    @Select("SELECT " +
            "m.ID as id, " +
            "m.field0001, " +
            "m.field0002, " +
            "m.field0003, " +
            "m.field0004, " +
            "m.field0026, " +
            "m.field0033, " +
            "m.field0034, " +
            "m.start_date as startDate, " +
            "d.ID as detailId, " +
            "d.field0006, " +
            "d.field0008, " +
            "d.field0009, " +
            "d.field0010, " +
            "d.field0011, " +
            "d.field0013, " +
            "d.field0014, " +
            "d.field0015, " +
            "d.field0016, " +
            "d.field0017, " +
            "d.field0018, " +
            "d.field0019, " +
            "d.field0020, " +
            "d.field0021, " +
            "d.field0023, " +
            "d.field0024, " +
            "d.field0028, " +
            "d.field0029, " +
            "d.field0030, " +
            "d.field0031, " +
            "d.field0032, " +
            "d.formmain_id " +
            "FROM formmain_1082 m " +
            "LEFT JOIN formson_1083 d ON m.ID = d.formmain_id " +
            "WHERE m.ID = #{id}")
    List<AssetDisposalWithDetailDTO> selectByMainId(Long id);

    /**
     * 根据单据编号查询资产处置单与明细的关联信息
     */
    @Select("SELECT " +
            "m.ID as id, " +
            "m.field0001, " +
            "m.field0002, " +
            "m.field0003, " +
            "m.field0004, " +
            "m.field0026, " +
            "m.field0033, " +
            "m.field0034, " +
            "m.start_date as startDate, " +
            "d.ID as detailId, " +
            "d.field0006, " +
            "d.field0008, " +
            "d.field0009, " +
            "d.field0010, " +
            "d.field0011, " +
            "d.field0013, " +
            "d.field0014, " +
            "d.field0015, " +
            "d.field0016, " +
            "d.field0017, " +
            "d.field0018, " +
            "d.field0019, " +
            "d.field0020, " +
            "d.field0021, " +
            "d.field0023, " +
            "d.field0024, " +
            "d.field0028, " +
            "d.field0029, " +
            "d.field0030, " +
            "d.field0031, " +
            "d.field0032, " +
            "d.formmain_id " +
            "FROM formmain_1082 m " +
            "LEFT JOIN formson_1083 d ON m.ID = d.formmain_id " +
            "WHERE m.field0001 = #{field0001}")
    List<AssetDisposalWithDetailDTO> selectByField0001(String field0001);

    /**
     * 根据申请人查询资产处置单与明细的关联信息
     */
    @Select("SELECT " +
            "m.ID as id, " +
            "m.field0001, " +
            "m.field0002, " +
            "m.field0003, " +
            "m.field0004, " +
            "m.field0026, " +
            "m.field0033, " +
            "m.field0034, " +
            "m.start_date as startDate, " +
            "d.ID as detailId, " +
            "d.field0006, " +
            "d.field0008, " +
            "d.field0009, " +
            "d.field0010, " +
            "d.field0011, " +
            "d.field0013, " +
            "d.field0014, " +
            "d.field0015, " +
            "d.field0016, " +
            "d.field0017, " +
            "d.field0018, " +
            "d.field0019, " +
            "d.field0020, " +
            "d.field0021, " +
            "d.field0023, " +
            "d.field0024, " +
            "d.field0028, " +
            "d.field0029, " +
            "d.field0030, " +
            "d.field0031, " +
            "d.field0032, " +
            "d.formmain_id " +
            "FROM formmain_1082 m " +
            "LEFT JOIN formson_1083 d ON m.ID = d.formmain_id " +
            "WHERE m.field0002 = #{field0002}")
    List<AssetDisposalWithDetailDTO> selectByField0002(String field0002);

    /**
     * 根据申请科室查询资产处置单与明细的关联信息
     */
    @Select("SELECT " +
            "m.ID as id, " +
            "m.field0001, " +
            "m.field0002, " +
            "m.field0003, " +
            "m.field0004, " +
            "m.field0026, " +
            "m.field0033, " +
            "m.field0034, " +
            "m.start_date as startDate, " +
            "d.ID as detailId, " +
            "d.field0006, " +
            "d.field0008, " +
            "d.field0009, " +
            "d.field0010, " +
            "d.field0011, " +
            "d.field0013, " +
            "d.field0014, " +
            "d.field0015, " +
            "d.field0016, " +
            "d.field0017, " +
            "d.field0018, " +
            "d.field0019, " +
            "d.field0020, " +
            "d.field0021, " +
            "d.field0023, " +
            "d.field0024, " +
            "d.field0028, " +
            "d.field0029, " +
            "d.field0030, " +
            "d.field0031, " +
            "d.field0032, " +
            "d.formmain_id " +
            "FROM formmain_1082 m " +
            "LEFT JOIN formson_1083 d ON m.ID = d.formmain_id " +
            "WHERE m.field0003 = #{field0003}")
    List<AssetDisposalWithDetailDTO> selectByField0003(String field0003);

    /**
     * 根据所属单位查询资产处置单与明细的关联信息
     */
    @Select("SELECT " +
            "m.ID as id, " +
            "m.field0001, " +
            "m.field0002, " +
            "m.field0003, " +
            "m.field0004, " +
            "m.field0026, " +
            "m.field0033, " +
            "m.field0034, " +
            "m.start_date as startDate, " +
            "d.ID as detailId, " +
            "d.field0006, " +
            "d.field0008, " +
            "d.field0009, " +
            "d.field0010, " +
            "d.field0011, " +
            "d.field0013, " +
            "d.field0014, " +
            "d.field0015, " +
            "d.field0016, " +
            "d.field0017, " +
            "d.field0018, " +
            "d.field0019, " +
            "d.field0020, " +
            "d.field0021, " +
            "d.field0023, " +
            "d.field0024, " +
            "d.field0028, " +
            "d.field0029, " +
            "d.field0030, " +
            "d.field0031, " +
            "d.field0032, " +
            "d.formmain_id " +
            "FROM formmain_1082 m " +
            "LEFT JOIN formson_1083 d ON m.ID = d.formmain_id " +
            "WHERE m.field0034 = #{field0034}")
    List<AssetDisposalWithDetailDTO> selectByField0034(String field0034);

    /**
     * 根据申请日期范围查询资产处置单与明细的关联信息
     */
    @Select("SELECT " +
            "m.ID as id, " +
            "m.field0001, " +
            "m.field0002, " +
            "m.field0003, " +
            "m.field0004, " +
            "m.field0026, " +
            "m.field0033, " +
            "m.field0034, " +
            "m.start_date as startDate, " +
            "d.ID as detailId, " +
            "d.field0006, " +
            "d.field0008, " +
            "d.field0009, " +
            "d.field0010, " +
            "d.field0011, " +
            "d.field0013, " +
            "d.field0014, " +
            "d.field0015, " +
            "d.field0016, " +
            "d.field0017, " +
            "d.field0018, " +
            "d.field0019, " +
            "d.field0020, " +
            "d.field0021, " +
            "d.field0023, " +
            "d.field0024, " +
            "d.field0028, " +
            "d.field0029, " +
            "d.field0030, " +
            "d.field0031, " +
            "d.field0032, " +
            "d.formmain_id " +
            "FROM formmain_1082 m " +
            "LEFT JOIN formson_1083 d ON m.ID = d.formmain_id " +
            "WHERE m.field0004 BETWEEN #{startDate} AND #{endDate}")
    List<AssetDisposalWithDetailDTO> selectByDateRange(String startDate, String endDate);

    /**
     * 查询所有资产处置单与明细的关联信息
     */
    @Select("SELECT " +
            "m.ID as id, " +
            "m.field0001, " +
            "m.field0002, " +
            "m.field0003, " +
            "m.field0004, " +
            "m.field0026, " +
            "m.field0033, " +
            "m.field0034, " +
            "m.start_date as startDate, " +
            "d.ID as detailId, " +
            "d.field0006, " +
            "d.field0008, " +
            "d.field0009, " +
            "d.field0010, " +
            "d.field0011, " +
            "d.field0013, " +
            "d.field0014, " +
            "d.field0015, " +
            "d.field0016, " +
            "d.field0017, " +
            "d.field0018, " +
            "d.field0019, " +
            "d.field0020, " +
            "d.field0021, " +
            "d.field0023, " +
            "d.field0024, " +
            "d.field0028, " +
            "d.field0029, " +
            "d.field0030, " +
            "d.field0031, " +
            "d.field0032, " +
            "d.formmain_id " +
            "FROM formmain_1082 m " +
            "LEFT JOIN formson_1083 d ON m.ID = d.formmain_id")
    List<AssetDisposalWithDetailDTO> selectAll();
}