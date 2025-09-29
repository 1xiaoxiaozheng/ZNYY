package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.springbootTz.ZNYY.Equipment.dto.AssetRegistrationNetworkWithDetailDTO;

/**
 * 资产登记单-网络信息设备关联查询Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface AssetRegistrationNetworkQueryMapper {

        /**
         * 查询所有网络信息设备资产登记单与明细的关联信息（只查正常数据）
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
                        "m.field0054, " +
                        "m.field0058, " +
                        "m.field0059, " +
                        "m.field0060, " +
                        "m.field0063, " +
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
                        "d.field0055, " +
                        "d.field0056, " +
                        "d.field0057, " +
                        "d.field0061, " +
                        "d.formmain_id " +
                        "FROM formmain_1187 m " +
                        "LEFT JOIN formson_1188 d ON m.ID = d.formmain_id " +
                        "WHERE m.state = 1")
        List<AssetRegistrationNetworkWithDetailDTO> selectAll();

        /**
         * 查询已删除的网络信息设备资产登记单信息（用于生成要删除的RID）
         */
        @Select("SELECT " +
                        "m.field0006, " + // 单位ID，用于生成unitCode
                        "d.field0007 " + // 设备代码，用于生成RID
                        "FROM formmain_1187 m " +
                        "LEFT JOIN formson_1188 d ON m.ID = d.formmain_id " +
                        "WHERE m.state = 0 AND d.field0007 IS NOT NULL")
        List<DeletedNetworkInfo> selectDeletedNetworkInfo();

        // 内部类：已删除网络信息设备信息
        class DeletedNetworkInfo {
                private Long field0006; // 单位ID
                private String field0007; // 设备代码

                public Long getField0006() {
                        return field0006;
                }

                public void setField0006(Long field0006) {
                        this.field0006 = field0006;
                }

                public String getField0007() {
                        return field0007;
                }

                public void setField0007(String field0007) {
                        this.field0007 = field0007;
                }
        }
}