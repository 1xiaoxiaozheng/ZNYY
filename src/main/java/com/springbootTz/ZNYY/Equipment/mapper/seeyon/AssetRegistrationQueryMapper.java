package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.springbootTz.ZNYY.Equipment.dto.AssetRegistrationWithDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 资产登记单-无形资产关联查询Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface AssetRegistrationQueryMapper {

        //
        // /**
        // * 根据填报日期范围查询资产登记单与明细的关联信息
        // */
        // @Select("SELECT " +
        // "m.ID as id, " +
        // "m.field0017, " +
        // "m.field0024, " +
        // "m.field0026, " +
        // "m.field0027, " +
        // "m.field0028, " +
        // "m.field0152, " +
        // "m.field0162, " +
        // "m.field0163, " +
        // "m.field0164, " +
        // "m.field0165, " +
        // "m.field0175, " +
        // "m.field0179, " +
        // "m.field0181, " +
        // "m.field0182, " +
        // "m.field0183, " +
        // "m.start_date as startDate, " +
        // "d.ID as detailId, " +
        // "d.field0001, " +
        // "d.field0002, " +
        // "d.field0006, " +
        // "d.field0007, " +
        // "d.field0010, " +
        // "d.field0014, " +
        // "d.field0031, " +
        // "d.field0032, " +
        // "d.field0036, " +
        // "d.field0047, " +
        // "d.field0048, " +
        // "d.field0058, " +
        // "d.field0059, " +
        // "d.field0066, " +
        // "d.field0072, " +
        // "d.field0099, " +
        // "d.field0102, " +
        // "d.field0108, " +
        // "d.field0125, " +
        // "d.field0126, " +
        // "d.field0128, " +
        // "d.field0131, " +
        // "d.field0133, " +
        // "d.field0134, " +
        // "d.field0145, " +
        // "d.field0150, " +
        // "d.field0151, " +
        // "d.field0153, " +
        // "d.field0154, " +
        // "d.field0155, " +
        // "d.field0156, " +
        // "d.field0158, " +
        // "d.field0159, " +
        // "d.field0160, " +
        // "d.field0161, " +
        // "d.field0166, " +
        // "d.field0167, " +
        // "d.field0168, " +
        // "d.field0169, " +
        // "d.field0170, " +
        // "d.field0171, " +
        // "d.field0172, " +
        // "d.field0173, " +
        // "d.field0174, " +
        // "d.field0176, " +
        // "d.field0177, " +
        // "d.field0178, " +
        // "d.field0180, " +
        // "d.formmain_id " +
        // "FROM formmain_1199 m " +
        // "LEFT JOIN formson_1200 d ON m.ID = d.formmain_id " +
        // "WHERE m.field0028 BETWEEN #{startDate} AND #{endDate}")
        // List<AssetRegistrationWithDetailDTO> selectByDateRange(String startDate,
        // String endDate);

        /**
         * 查询所有资产登记单-无形资产与明细的关联信息（只查正常数据）
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
                        "m.field0175, " +
                        "m.field0179, " +
                        "m.field0181, " +
                        "m.field0182, " +
                        "m.field0183, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0001, " +
                        "d.field0002, " +
                        "d.field0006, " +
                        "d.field0007, " +
                        "d.field0010, " +
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
                        "d.field0173, " +
                        "d.field0174, " +
                        "d.field0176, " +
                        "d.field0177, " +
                        "d.field0178, " +
                        "d.field0180, " +
                        "d.formmain_id " +
                        "FROM formmain_1199 m " +
                        "LEFT JOIN formson_1200 d ON m.ID = d.formmain_id " +
                        "WHERE m.state = 1")
        List<AssetRegistrationWithDetailDTO> selectAll();

        /**
         * 查询已删除的无形资产设备资产登记单信息（用于生成要删除的RID）
         */
        @Select("SELECT " +
                        "m.field0152, " + // 单位ID，用于生成unitCode
                        "d.field0001 " + // 设备代码，用于生成RID
                        "FROM formmain_1199 m " +
                        "LEFT JOIN formson_1200 d ON m.ID = d.formmain_id " +
                        "WHERE m.state = 0 AND d.field0001 IS NOT NULL")
        List<DeletedAssetInfo> selectDeletedAssetInfo();

        // 内部类：已删除无形资产信息
        class DeletedAssetInfo {
                private Long field0152; // 单位ID
                private String field0001; // 设备代码

                public Long getField0152() {
                        return field0152;
                }

                public void setField0152(Long field0152) {
                        this.field0152 = field0152;
                }

                public String getField0001() {
                        return field0001;
                }

                public void setField0001(String field0001) {
                        this.field0001 = field0001;
                }
        }
}