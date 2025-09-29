package com.springbootTz.ZNYY.Equipment.mapper.znyy;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.znyy.EquipDeprRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

/**
 * EquipDeprRecord Mapper接口
 * 用于Oracle数据库操作
 */
@Mapper
public interface EquipDeprRecordMapper extends BaseMapper<EquipDeprRecord> {

        /**
         * 插入设备折旧记录信息
         */
        @Insert("INSERT INTO equip_depr_record (" +
                        "rid, org_name, uscid, upload_time, sys_prdr_code, sys_prdr_name, " +
                        "depr_month, equip_card_no, equip_code, equip_name, depr_period, " +
                        "funds_souc_code, funds_souc_name, use_dept_code, use_dept_name, " +
                        "current_depr, depr_cum_amt, operator_name, deal_date, create_cert_flag, " +
                        "create_cert_date, accrued_cost_flag, accrued_cost_date, depr_mean, " +
                        "depr_mean_name, stroom_code, stroom_name, deprec_rate, state, " +
                        "reserve1, reserve2, data_clct_prdr_name, crte_time, updt_time, " +
                        "deleted, deleted_time" +
                        ") VALUES (" +
                        "#{rid}, #{orgName}, #{uscid}, #{uploadTime}, #{sysPrdrCode}, #{sysPrdrName}, " +
                        "#{deprMonth}, #{equipCardNo}, #{equipCode}, #{equipName}, #{deprPeriod}, " +
                        "#{fundsSoucCode}, #{fundsSoucName}, #{useDeptCode}, #{useDeptName}, " +
                        "#{currentDepr}, #{deprCumAmt}, #{operatorName}, " +
                        "CASE WHEN  #{dealDate, jdbcType=TIMESTAMP}  IS NULL THEN SYSDATE ELSE #{dealDate} END, " + // 必填字段，null时用当前时间
                        "#{createCertFlag}, " +
                        "CASE WHEN #{createCertDate} IS NULL THEN SYSDATE ELSE #{createCertDate} END, " + // 必填字段，null时用当前时间
                        "#{accruedCostFlag}, " +
                        "CASE WHEN #{accruedCostDate} IS NULL THEN SYSDATE ELSE #{accruedCostDate} END, " + // 必填字段，null时用当前时间
                        "#{deprMean}, #{deprMeanName}, #{stroomCode}, #{stroomName}, #{deprecRate}, #{state}, " +
                        "#{reserve1}, #{reserve2}, #{dataClctPrdrName}, " +
                        "SYSDATE, " + // crte_time 使用当前时间
                        "SYSDATE, #{deleted}, " +
                        "NULL" + // deleted_time 设置为 NULL
                        ")")
        int insertEquipDeprRecord(EquipDeprRecord equipDeprRecord);

        @Update("UPDATE equip_depr_record SET " +
                        "org_name = #{orgName}, uscid = #{uscid}, upload_time = #{uploadTime}, " +
                        "sys_prdr_code = #{sysPrdrCode}, sys_prdr_name = #{sysPrdrName}, " +
                        "depr_month = #{deprMonth}, equip_card_no = #{equipCardNo}, equip_code = #{equipCode}, " +
                        "equip_name = #{equipName}, depr_period = #{deprPeriod}, funds_souc_code = #{fundsSoucCode}, " +
                        "funds_souc_name = #{fundsSoucName}, use_dept_code = #{useDeptCode}, use_dept_name = #{useDeptName}, "
                        +
                        "current_depr = #{currentDepr}, depr_cum_amt = #{deprCumAmt}, operator_name = #{operatorName}, "
                        +
                        "deal_date = #{dealDate}, " +
                        "create_cert_flag = #{createCertFlag}, " +
                        "create_cert_date = #{createCertDate}, " +
                        "accrued_cost_flag = #{accruedCostFlag}, " +
                        "accrued_cost_date = #{accruedCostDate}, " +
                        "depr_mean = #{deprMean}, depr_mean_name = #{deprMeanName}, stroom_code = #{stroomCode}, " +
                        "stroom_name = #{stroomName}, deprec_rate = #{deprecRate}, state = #{state}, " +
                        "reserve1 = #{reserve1}, reserve2 = #{reserve2}, data_clct_prdr_name = #{dataClctPrdrName}, " +
                        "crte_time = CASE WHEN crte_time IS NULL THEN SYSDATE ELSE crte_time END, " +
                        "updt_time = SYSDATE, deleted = #{deleted}, " +
                        "deleted_time = NULL " +
                        "WHERE rid = #{rid}")
        int updateEquipDeprRecord(EquipDeprRecord equipDeprRecord);

        /**
         * 根据RID检查折旧记录是否存在
         */
        @Select("SELECT COUNT(*) FROM equip_depr_record WHERE rid = #{rid} AND (deleted IS NULL OR deleted = '0')")
        int checkEquipDeprRecordExists(String rid);

        /**
         * 根据系统提供商代码查询所有活跃的RID
         */
        @Select("SELECT rid FROM equip_depr_record WHERE sys_prdr_code = #{sysPrdrCode} AND (deleted IS NULL OR deleted = '0')")
        List<String> selectActiveRidsBySysPrdrCode(String sysPrdrCode);

        /**
         * 批量标记为已删除
         */
        @Update("UPDATE equip_depr_record SET deleted = '1', deleted_time = SYSDATE WHERE rid IN (${rids})")
        int batchMarkAsDeleted(String rids);
}