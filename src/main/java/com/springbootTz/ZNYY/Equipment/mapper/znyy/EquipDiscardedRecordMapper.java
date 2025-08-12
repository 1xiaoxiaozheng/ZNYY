package com.springbootTz.ZNYY.Equipment.mapper.znyy;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.znyy.EquipDiscardedRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

/**
 * EquipDiscardedRecord Mapper接口
 * 用于Oracle数据库操作
 */
@Mapper
public interface EquipDiscardedRecordMapper extends BaseMapper<EquipDiscardedRecord> {

        /**
         * 插入设备报废记录信息
         */
        @Insert("INSERT INTO equip_discarded_record (" +
                        "rid, org_name, uscid, upload_time, sys_prdr_code, sys_prdr_name, " +
                        "discarded_no, equip_code, equip_name, spec, equip_model, unit, " +
                        "unit_name, use_dep, equip_pric, purc_date, used_life, " +
                        "estima_residual_value, discarded_rea, applyer_name, apply_date, " +
                        "audit_operator_name, audit_date, manufacturer_code, manufacturer_name, " +
                        "state, reserve1, reserve2, data_clct_prdr_name, crte_time, updt_time, " +
                        "deleted, deleted_time" +
                        ") VALUES (" +
                        "#{rid}, #{orgName}, #{uscid}, #{uploadTime}, #{sysPrdrCode}, #{sysPrdrName}, " +
                        "#{discardedNo}, #{equipCode}, #{equipName}, #{spec}, #{equipModel}, #{unit}, " +
                        "#{unitName}, #{useDep}, #{equipPric}, #{purcDate}, #{usedLife}, " +
                        "#{estimaResidualValue}, #{discardedRea}, #{applyerName}, #{applyDate}, " +
                        "#{auditOperatorName}, #{auditDate}, #{manufacturerCode}, #{manufacturerName}, " +
                        "#{state}, #{reserve1}, #{reserve2}, #{dataClctPrdrName}, #{crteTime}, #{updtTime}, " +
                        "#{deleted}, #{deletedTime}" +
                        ")")
        int insertEquipDiscardedRecord(EquipDiscardedRecord equipDiscardedRecord);

        /**
         * 根据RID查询设备报废记录
         */
        @Select("SELECT * FROM equip_discarded_record WHERE rid = #{rid}")
        EquipDiscardedRecord selectByRid(String rid);

        /**
         * 根据报废单号查询
         */
        @Select("SELECT * FROM equip_discarded_record WHERE discarded_no = #{discardedNo}")
        EquipDiscardedRecord selectByDiscardedNo(String discardedNo);

        /**
         * 根据设备代码查询报废记录
         */
        @Select("SELECT * FROM equip_discarded_record WHERE equip_code = #{equipCode}")
        List<EquipDiscardedRecord> selectByEquipCode(String equipCode);

        /**
         * 根据设备名称查询报废记录
         */
        @Select("SELECT * FROM equip_discarded_record WHERE equip_name LIKE '%' || #{equipName} || '%'")
        List<EquipDiscardedRecord> selectByEquipName(String equipName);

        /**
         * 根据使用部门查询
         */
        @Select("SELECT * FROM equip_discarded_record WHERE use_dep = #{useDep}")
        List<EquipDiscardedRecord> selectByUseDep(String useDep);

        /**
         * 根据申请日期范围查询
         */
        @Select("SELECT * FROM equip_discarded_record WHERE apply_date BETWEEN #{startDate} AND #{endDate}")
        List<EquipDiscardedRecord> selectByApplyDateRange(String startDate, String endDate);

        /**
         * 根据审核日期范围查询
         */
        @Select("SELECT * FROM equip_discarded_record WHERE audit_date BETWEEN #{startDate} AND #{endDate}")
        List<EquipDiscardedRecord> selectByAuditDateRange(String startDate, String endDate);

        /**
         * 根据采购日期范围查询
         */
        @Select("SELECT * FROM equip_discarded_record WHERE purc_date BETWEEN #{startDate} AND #{endDate}")
        List<EquipDiscardedRecord> selectByPurcDateRange(String startDate, String endDate);

        /**
         * 根据生产厂商查询
         */
        @Select("SELECT * FROM equip_discarded_record WHERE manufacturer_code = #{manufacturerCode}")
        List<EquipDiscardedRecord> selectByManufacturerCode(String manufacturerCode);

        /**
         * 根据申请人查询
         */
        @Select("SELECT * FROM equip_discarded_record WHERE applyer_name = #{applyerName}")
        List<EquipDiscardedRecord> selectByApplyerName(String applyerName);

        /**
         * 检查设备报废记录是否存在
         */
        @Select("SELECT COUNT(*) FROM equip_discarded_record WHERE rid = #{rid}")
        int checkEquipDiscardedRecordExists(String rid);

        /**
         * 根据审核人查询
         */
        @Select("SELECT * FROM equip_discarded_record WHERE audit_operator_name = #{auditOperatorName}")
        List<EquipDiscardedRecord> selectByAuditOperatorName(String auditOperatorName);

        /**
         * 根据报废原因查询
         */
        @Select("SELECT * FROM equip_discarded_record WHERE discarded_rea LIKE '%' || #{discardedRea} || '%'")
        List<EquipDiscardedRecord> selectByDiscardedRea(String discardedRea);

        /**
         * 根据已用年限查询
         */
        @Select("SELECT * FROM equip_discarded_record WHERE used_life >= #{minUsedLife}")
        List<EquipDiscardedRecord> selectByMinUsedLife(Integer minUsedLife);

        /**
         * 逻辑删除设备报废记录
         */
        @Update("UPDATE equip_discarded_record SET deleted = '1', deleted_time = SYSDATE WHERE rid = #{rid}")
        int deleteEquipDiscardedRecord(String rid);

        /**
         * 查询所有未删除的设备报废记录
         */
        @Select("SELECT * FROM equip_discarded_record WHERE deleted IS NULL OR deleted = '0'")
        List<EquipDiscardedRecord> selectAllActive();

        /**
         * 统计各使用部门报废记录数量
         */
        @Select("SELECT " +
                        "use_dep as useDep, " +
                        "COUNT(*) as recordCount, " +
                        "SUM(equip_pric) as totalValue " +
                        "FROM equip_discarded_record " +
                        "WHERE deleted IS NULL OR deleted = '0' " +
                        "GROUP BY use_dep " +
                        "ORDER BY recordCount DESC")
        List<Object> selectDiscardedStatisticsByDept();

        /**
         * 统计各生产厂商报废记录数量
         */
        @Select("SELECT " +
                        "manufacturer_name as manufacturerName, " +
                        "COUNT(*) as recordCount, " +
                        "SUM(equip_pric) as totalValue " +
                        "FROM equip_discarded_record " +
                        "WHERE deleted IS NULL OR deleted = '0' " +
                        "GROUP BY manufacturer_name, manufacturer_code " +
                        "ORDER BY recordCount DESC")
        List<Object> selectDiscardedStatisticsByManufacturer();

        /**
         * 统计各报废原因记录数量
         */
        @Select("SELECT " +
                        "discarded_rea as discardedRea, " +
                        "COUNT(*) as recordCount, " +
                        "SUM(equip_pric) as totalValue " +
                        "FROM equip_discarded_record " +
                        "WHERE deleted IS NULL OR deleted = '0' " +
                        "GROUP BY discarded_rea " +
                        "ORDER BY recordCount DESC")
        List<Object> selectDiscardedStatisticsByReason();

        /**
         * 查询指定年份的报废记录
         */
        @Select("SELECT * FROM equip_discarded_record " +
                        "WHERE EXTRACT(YEAR FROM apply_date) = #{year} " +
                        "AND (deleted IS NULL OR deleted = '0')")
        List<EquipDiscardedRecord> selectByYear(Integer year);

        /**
         * 查询报废总价值
         */
        @Select("SELECT SUM(equip_pric) as totalDiscardedValue " +
                        "FROM equip_discarded_record " +
                        "WHERE deleted IS NULL OR deleted = '0'")
        Object selectTotalDiscardedValue();

        /**
         * 根据RID更新设备报废记录信息
         */
        @Update("UPDATE equip_discarded_record SET " +
                        "org_name = #{orgName}, uscid = #{uscid}, upload_time = #{uploadTime}, " +
                        "sys_prdr_code = #{sysPrdrCode}, sys_prdr_name = #{sysPrdrName}, " +
                        "discarded_no = #{discardedNo}, equip_code = #{equipCode}, equip_name = #{equipName}, " +
                        "spec = #{spec}, equip_model = #{equipModel}, unit = #{unit}, unit_name = #{unitName}, " +
                        "use_dep = #{useDep}, equip_pric = #{equipPric}, purc_date = #{purcDate}, " +
                        "used_life = #{usedLife}, estima_residual_value = #{estimaResidualValue}, " +
                        "discarded_rea = #{discardedRea}, applyer_name = #{applyerName}, apply_date = #{applyDate}, " +
                        "audit_operator_name = #{auditOperatorName}, audit_date = #{auditDate}, " +
                        "manufacturer_code = #{manufacturerCode}, manufacturer_name = #{manufacturerName}, " +
                        "state = #{state}, reserve1 = #{reserve1}, reserve2 = #{reserve2}, " +
                        "data_clct_prdr_name = #{dataClctPrdrName}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateEquipDiscardedRecord(EquipDiscardedRecord equipDiscardedRecord);

        /**
         * 根据报废单号更新设备报废记录信息
         */
        @Update("UPDATE equip_discarded_record SET " +
                        "org_name = #{orgName}, uscid = #{uscid}, upload_time = #{uploadTime}, " +
                        "sys_prdr_code = #{sysPrdrCode}, sys_prdr_name = #{sysPrdrName}, " +
                        "equip_code = #{equipCode}, equip_name = #{equipName}, spec = #{spec}, " +
                        "equip_model = #{equipModel}, unit = #{unit}, unit_name = #{unitName}, " +
                        "use_dep = #{useDep}, equip_pric = #{equipPric}, purc_date = #{purcDate}, " +
                        "used_life = #{usedLife}, estima_residual_value = #{estimaResidualValue}, " +
                        "discarded_rea = #{discardedRea}, applyer_name = #{applyerName}, apply_date = #{applyDate}, " +
                        "audit_operator_name = #{auditOperatorName}, audit_date = #{auditDate}, " +
                        "manufacturer_code = #{manufacturerCode}, manufacturer_name = #{manufacturerName}, " +
                        "state = #{state}, reserve1 = #{reserve1}, reserve2 = #{reserve2}, " +
                        "data_clct_prdr_name = #{dataClctPrdrName}, updt_time = SYSDATE " +
                        "WHERE discarded_no = #{discardedNo}")
        int updateEquipDiscardedRecordByDiscardedNo(EquipDiscardedRecord equipDiscardedRecord);

        /**
         * 更新未删除的报废记录
         */
        @Update("UPDATE equip_discarded_record SET " +
                        "org_name = #{orgName}, uscid = #{uscid}, upload_time = #{uploadTime}, " +
                        "sys_prdr_code = #{sysPrdrCode}, sys_prdr_name = #{sysPrdrName}, " +
                        "discarded_no = #{discardedNo}, equip_code = #{equipCode}, equip_name = #{equipName}, " +
                        "spec = #{spec}, equip_model = #{equipModel}, unit = #{unit}, unit_name = #{unitName}, " +
                        "use_dep = #{useDep}, equip_pric = #{equipPric}, purc_date = #{purcDate}, " +
                        "used_life = #{usedLife}, estima_residual_value = #{estimaResidualValue}, " +
                        "discarded_rea = #{discardedRea}, applyer_name = #{applyerName}, apply_date = #{applyDate}, " +
                        "audit_operator_name = #{auditOperatorName}, audit_date = #{auditDate}, " +
                        "manufacturer_code = #{manufacturerCode}, manufacturer_name = #{manufacturerName}, " +
                        "state = #{state}, reserve1 = #{reserve1}, reserve2 = #{reserve2}, " +
                        "data_clct_prdr_name = #{dataClctPrdrName}, updt_time = SYSDATE " +
                        "WHERE discarded_no = #{discardedNo} AND (deleted IS NULL OR deleted = '0')")
        int updateEquipDiscardedRecordActive(EquipDiscardedRecord equipDiscardedRecord);

        /**
         * 更新报废申请信息
         */
        @Update("UPDATE equip_discarded_record SET " +
                        "applyer_name = #{applyerName}, apply_date = #{applyDate}, " +
                        "discarded_rea = #{discardedRea}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateApplyInfo(String rid, String applyerName, String applyDate, String discardedRea);

        /**
         * 更新审核信息
         */
        @Update("UPDATE equip_discarded_record SET " +
                        "audit_operator_name = #{auditOperatorName}, audit_date = #{auditDate}, " +
                        "state = #{state}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateAuditInfo(String rid, String auditOperatorName, String auditDate, String state);

        /**
         * 更新设备基本信息
         */
        @Update("UPDATE equip_discarded_record SET " +
                        "equip_name = #{equipName}, spec = #{spec}, equip_model = #{equipModel}, " +
                        "unit = #{unit}, unit_name = #{unitName}, manufacturer_code = #{manufacturerCode}, " +
                        "manufacturer_name = #{manufacturerName}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateEquipBasicInfo(EquipDiscardedRecord equipDiscardedRecord);

        /**
         * 更新报废价值信息
         */
        @Update("UPDATE equip_discarded_record SET " +
                        "equip_pric = #{equipPric}, estima_residual_value = #{estimaResidualValue}, " +
                        "used_life = #{usedLife}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateValueInfo(String rid, Double equipPric, Double estimaResidualValue, Integer usedLife);

        /**
         * 更新使用部门信息
         */
        @Update("UPDATE equip_discarded_record SET " +
                        "use_dep = #{useDep}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateUseDepInfo(String rid, String useDep);

        /**
         * 根据上传时间查询需要同步的数据
         */
        @Select("SELECT * FROM equip_discarded_record WHERE upload_time >= #{lastSyncTime} AND (deleted IS NULL OR deleted = '0')")
        List<EquipDiscardedRecord> selectByUploadTime(String lastSyncTime);

        /**
         * 根据更新时间查询需要更新的数据
         */
        @Select("SELECT * FROM equip_discarded_record WHERE updt_time >= #{lastUpdateTime} AND (deleted IS NULL OR deleted = '0')")
        List<EquipDiscardedRecord> selectByUpdateTime(String lastUpdateTime);

        /**
         * 检查报废记录是否存在
         */
        @Select("SELECT COUNT(*) FROM equip_discarded_record WHERE discarded_no = #{discardedNo} AND (deleted IS NULL OR deleted = '0')")
        int checkDiscardedRecordExists(String discardedNo);

        /**
         * 根据设备代码查询报废记录（未删除）
         */
        @Select("SELECT * FROM equip_discarded_record WHERE equip_code = #{equipCode} AND (deleted IS NULL OR deleted = '0')")
        List<EquipDiscardedRecord> selectByEquipCodeActive(String equipCode);

        /**
         * 批量更新报废记录状态
         */
        @Update("UPDATE equip_discarded_record SET " +
                        "state = #{state}, updt_time = SYSDATE " +
                        "WHERE equip_code = #{equipCode} AND (deleted IS NULL OR deleted = '0')")
        int batchUpdateDiscardedRecordStatus(String equipCode, String state);

        /**
         * 更新报废记录状态
         */
        @Update("UPDATE equip_discarded_record SET " +
                        "state = #{state}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateDiscardedRecordStatus(String rid, String state);

        /**
         * 根据申请日期范围查询报废记录（未删除）
         */
        @Select("SELECT * FROM equip_discarded_record WHERE apply_date BETWEEN #{startDate} AND #{endDate} AND (deleted IS NULL OR deleted = '0')")
        List<EquipDiscardedRecord> selectByApplyDateRangeActive(String startDate, String endDate);

        /**
         * 根据审核日期范围查询报废记录（未删除）
         */
        @Select("SELECT * FROM equip_discarded_record WHERE audit_date BETWEEN #{startDate} AND #{endDate} AND (deleted IS NULL OR deleted = '0')")
        List<EquipDiscardedRecord> selectByAuditDateRangeActive(String startDate, String endDate);
}