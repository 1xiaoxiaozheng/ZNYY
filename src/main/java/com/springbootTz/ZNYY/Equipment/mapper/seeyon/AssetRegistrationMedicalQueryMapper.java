package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.springbootTz.ZNYY.Equipment.dto.AssetRegistrationMedicalWithDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 资产登记单-医疗专用设备关联查询Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface AssetRegistrationMedicalQueryMapper {

        /**
         * 查询所有医疗专用设备资产登记单与明细的关联信息（只查正常数据）
         */
        @Select("SELECT " +
                        "m.ID as id, " +
                        "m.field0001, " +
                        "m.field0002, " +
                        "m.field0003, " +
                        "m.field0004, " +
                        "m.field0005, " +
                        "m.field0041, " +
                        "m.field0047, " +
                        "m.field0048, " +
                        "m.field0049, " +
                        "m.field0050, " +
                        "m.field0061, " +
                        "m.field0065, " +
                        "m.field0066, " +
                        "m.field0067, " +
                        "m.field0069, " +
                        "m.start_date as startDate, " +
                        "d.ID as detailId, " +
                        "d.field0006, " +
                        "d.field0007, " +
                        "d.field0008, " +
                        "d.field0009, " +
                        "d.field0011, " +
                        "d.field0012, " +
                        "d.field0013, " +
                        "d.field0014, " +
                        "d.field0015, " +
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
                        "d.field0042, " +
                        "d.field0045, " +
                        "d.field0046, " +
                        "d.field0051, " +
                        "d.field0052, " +
                        "d.field0053, " +
                        "d.field0054, " +
                        "d.field0055, " +
                        "d.field0056, " +
                        "d.field0058, " +
                        "d.field0059, " +
                        "d.field0060, " +
                        "d.field0062, " +
                        "d.field0063, " +
                        "d.field0064, " +
                        "d.field0068, " +
                        "d.field0070, " +
                        "d.formmain_id " +
                        "FROM formmain_1193 m " +
                        "LEFT JOIN formson_1194 d ON m.ID = d.formmain_id " +
                        "WHERE m.state = 1")
        List<AssetRegistrationMedicalWithDetailDTO> selectAll();

        /**
         * 查询已删除的医疗器械设备资产登记单信息（用于生成要删除的RID）
         */
        @Select("SELECT " +
                        "m.field0005, " + // 单位ID，用于生成unitCode
                        "d.field0006 " + // 设备代码，用于生成RID
                        "FROM formmain_1193 m " +
                        "LEFT JOIN formson_1194 d ON m.ID = d.formmain_id " +
                        "WHERE m.state = 0 AND d.field0006 IS NOT NULL")
        List<DeletedMedicalInfo> selectDeletedMedicalInfo();

        // 内部类：已删除医疗器械信息
        class DeletedMedicalInfo {
                private Long field0005; // 单位ID
                private String field0006; // 设备代码

                public Long getField0005() {
                        return field0005;
                }

                public void setField0005(Long field0005) {
                        this.field0005 = field0005;
                }

                public String getField0006() {
                        return field0006;
                }

                public void setField0006(String field0006) {
                        this.field0006 = field0006;
                }
        }
}