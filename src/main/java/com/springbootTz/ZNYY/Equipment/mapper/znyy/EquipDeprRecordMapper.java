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
                        "#{currentDepr}, #{deprCumAmt}, #{operatorName}, #{dealDate}, #{createCertFlag}, " +
                        "#{createCertDate}, #{accruedCostFlag}, #{accruedCostDate}, #{deprMean}, " +
                        "#{deprMeanName}, #{stroomCode}, #{stroomName}, #{deprecRate}, #{state}, " +
                        "#{reserve1}, #{reserve2}, #{dataClctPrdrName}, #{crteTime}, #{updtTime}, " +
                        "#{deleted}, #{deletedTime}" +
                        ")")
        int insertEquipDeprRecord(EquipDeprRecord equipDeprRecord);

        /**
         * 根据RID查询设备折旧记录
         */
        @Select("SELECT * FROM equip_depr_record WHERE rid = #{rid}")
        EquipDeprRecord selectByRid(String rid);

        /**
         * 根据设备卡片号查询折旧记录
         */
        @Select("SELECT * FROM equip_depr_record WHERE equip_card_no = #{equipCardNo}")
        List<EquipDeprRecord> selectByEquipCardNo(String equipCardNo);

        /**
         * 根据折旧月份查询
         */
        @Select("SELECT * FROM equip_depr_record WHERE depr_month = #{deprMonth}")
        List<EquipDeprRecord> selectByDeprMonth(String deprMonth);

        /**
         * 根据使用科室查询
         */
        @Select("SELECT * FROM equip_depr_record WHERE use_dept_code = #{deptCode}")
        List<EquipDeprRecord> selectByDeptCode(String deptCode);

        /**
         * 根据处理日期范围查询
         */
        @Select("SELECT * FROM equip_depr_record WHERE deal_date BETWEEN #{startDate} AND #{endDate}")
        List<EquipDeprRecord> selectByDealDateRange(String startDate, String endDate);

        /**
         * 根据折旧期间查询
         */
        @Select("SELECT * FROM equip_depr_record WHERE depr_period = #{deprPeriod}")
        List<EquipDeprRecord> selectByDeprPeriod(Integer deprPeriod);

        /**
         * 根据资金来源查询
         */
        @Select("SELECT * FROM equip_depr_record WHERE funds_souc_code = #{fundsSoucCode}")
        List<EquipDeprRecord> selectByFundsSoucCode(String fundsSoucCode);

        /**
         * 根据折旧方法查询
         */
        @Select("SELECT * FROM equip_depr_record WHERE depr_mean = #{deprMean}")
        List<EquipDeprRecord> selectByDeprMean(String deprMean);

        /**
         * 查询指定设备在指定月份的折旧记录
         */
        @Select("SELECT * FROM equip_depr_record WHERE equip_card_no = #{equipCardNo} AND depr_month = #{deprMonth}")
        EquipDeprRecord selectByEquipCardNoAndMonth(String equipCardNo, String deprMonth);

        /**
         * 查询指定设备的累计折旧记录
         */
        @Select("SELECT * FROM equip_depr_record WHERE equip_card_no = #{equipCardNo} ORDER BY depr_period ASC")
        List<EquipDeprRecord> selectByEquipCardNoOrderByPeriod(String equipCardNo);

        /**
         * 逻辑删除设备折旧记录
         */
        @Update("UPDATE equip_depr_record SET deleted = '1', deleted_time = SYSDATE WHERE rid = #{rid}")
        int deleteEquipDeprRecord(String rid);

        /**
         * 查询所有未删除的设备折旧记录
         */
        @Select("SELECT * FROM equip_depr_record WHERE deleted IS NULL OR deleted = '0'")
        List<EquipDeprRecord> selectAllActive();

        /**
         * 统计各科室折旧记录数量
         */
        @Select("SELECT " +
                        "use_dept_name as deptName, " +
                        "COUNT(*) as recordCount, " +
                        "SUM(current_depr) as totalDepr " +
                        "FROM equip_depr_record " +
                        "WHERE deleted IS NULL OR deleted = '0' " +
                        "GROUP BY use_dept_name, use_dept_code " +
                        "ORDER BY recordCount DESC")
        List<Object> selectDeprStatisticsByDept();

        /**
         * 统计各折旧方法记录数量
         */
        @Select("SELECT " +
                        "depr_mean_name as deprMeanName, " +
                        "COUNT(*) as recordCount, " +
                        "SUM(current_depr) as totalDepr " +
                        "FROM equip_depr_record " +
                        "WHERE deleted IS NULL OR deleted = '0' " +
                        "GROUP BY depr_mean_name, depr_mean " +
                        "ORDER BY recordCount DESC")
        List<Object> selectDeprStatisticsByMethod();

        /**
         * 查询指定设备的累计折旧总额
         */
        @Select("SELECT SUM(depr_cum_amt) as totalCumDepr " +
                        "FROM equip_depr_record " +
                        "WHERE equip_card_no = #{equipCardNo} " +
                        "AND (deleted IS NULL OR deleted = '0')")
        Object selectTotalCumDeprByEquipCardNo(String equipCardNo);

        /**
         * 根据RID更新设备折旧记录信息
         */
        @Update("UPDATE equip_depr_record SET " +
                        "org_name = #{orgName}, uscid = #{uscid}, upload_time = #{uploadTime}, " +
                        "sys_prdr_code = #{sysPrdrCode}, sys_prdr_name = #{sysPrdrName}, " +
                        "depr_month = #{deprMonth}, equip_card_no = #{equipCardNo}, equip_code = #{equipCode}, " +
                        "equip_name = #{equipName}, depr_period = #{deprPeriod}, funds_souc_code = #{fundsSoucCode}, " +
                        "funds_souc_name = #{fundsSoucName}, use_dept_code = #{useDeptCode}, use_dept_name = #{useDeptName}, "
                        +
                        "current_depr = #{currentDepr}, depr_cum_amt = #{deprCumAmt}, operator_name = #{operatorName}, "
                        +
                        "deal_date = #{dealDate}, create_cert_flag = #{createCertFlag}, create_cert_date = #{createCertDate}, "
                        +
                        "accrued_cost_flag = #{accruedCostFlag}, accrued_cost_date = #{accruedCostDate}, " +
                        "depr_mean = #{deprMean}, depr_mean_name = #{deprMeanName}, stroom_code = #{stroomCode}, " +
                        "stroom_name = #{stroomName}, deprec_rate = #{deprecRate}, state = #{state}, " +
                        "reserve1 = #{reserve1}, reserve2 = #{reserve2}, data_clct_prdr_name = #{dataClctPrdrName}, " +
                        "updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateEquipDeprRecord(EquipDeprRecord equipDeprRecord);

        /**
         * 根据设备卡片号和折旧月份更新折旧记录
         */
        @Update("UPDATE equip_depr_record SET " +
                        "org_name = #{orgName}, uscid = #{uscid}, upload_time = #{uploadTime}, " +
                        "sys_prdr_code = #{sysPrdrCode}, sys_prdr_name = #{sysPrdrName}, " +
                        "equip_code = #{equipCode}, equip_name = #{equipName}, depr_period = #{deprPeriod}, " +
                        "funds_souc_code = #{fundsSoucCode}, funds_souc_name = #{fundsSoucName}, " +
                        "use_dept_code = #{useDeptCode}, use_dept_name = #{useDeptName}, " +
                        "current_depr = #{currentDepr}, depr_cum_amt = #{deprCumAmt}, operator_name = #{operatorName}, "
                        +
                        "deal_date = #{dealDate}, create_cert_flag = #{createCertFlag}, create_cert_date = #{createCertDate}, "
                        +
                        "accrued_cost_flag = #{accruedCostFlag}, accrued_cost_date = #{accruedCostDate}, " +
                        "depr_mean = #{deprMean}, depr_mean_name = #{deprMeanName}, stroom_code = #{stroomCode}, " +
                        "stroom_name = #{stroomName}, deprec_rate = #{deprecRate}, state = #{state}, " +
                        "reserve1 = #{reserve1}, reserve2 = #{reserve2}, data_clct_prdr_name = #{dataClctPrdrName}, " +
                        "updt_time = SYSDATE " +
                        "WHERE equip_card_no = #{equipCardNo} AND depr_month = #{deprMonth}")
        int updateEquipDeprRecordByCardNoAndMonth(EquipDeprRecord equipDeprRecord);

        /**
         * 更新未删除的折旧记录
         */
        @Update("UPDATE equip_depr_record SET " +
                        "org_name = #{orgName}, uscid = #{uscid}, upload_time = #{uploadTime}, " +
                        "sys_prdr_code = #{sysPrdrCode}, sys_prdr_name = #{sysPrdrName}, " +
                        "depr_month = #{deprMonth}, equip_code = #{equipCode}, equip_name = #{equipName}, " +
                        "depr_period = #{deprPeriod}, funds_souc_code = #{fundsSoucCode}, " +
                        "funds_souc_name = #{fundsSoucName}, use_dept_code = #{useDeptCode}, use_dept_name = #{useDeptName}, "
                        +
                        "current_depr = #{currentDepr}, depr_cum_amt = #{deprCumAmt}, operator_name = #{operatorName}, "
                        +
                        "deal_date = #{dealDate}, create_cert_flag = #{createCertFlag}, create_cert_date = #{createCertDate}, "
                        +
                        "accrued_cost_flag = #{accruedCostFlag}, accrued_cost_date = #{accruedCostDate}, " +
                        "depr_mean = #{deprMean}, depr_mean_name = #{deprMeanName}, stroom_code = #{stroomCode}, " +
                        "stroom_name = #{stroomName}, deprec_rate = #{deprecRate}, state = #{state}, " +
                        "reserve1 = #{reserve1}, reserve2 = #{reserve2}, data_clct_prdr_name = #{dataClctPrdrName}, " +
                        "updt_time = SYSDATE " +
                        "WHERE equip_card_no = #{equipCardNo} AND depr_month = #{deprMonth} " +
                        "AND (deleted IS NULL OR deleted = '0')")
        int updateEquipDeprRecordActive(EquipDeprRecord equipDeprRecord);

        /**
         * 更新折旧金额信息
         */
        @Update("UPDATE equip_depr_record SET " +
                        "current_depr = #{currentDepr}, depr_cum_amt = #{deprCumAmt}, " +
                        "deprec_rate = #{deprecRate}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateDeprAmountInfo(EquipDeprRecord equipDeprRecord);

        /**
         * 更新处理状态
         */
        @Update("UPDATE equip_depr_record SET " +
                        "state = #{state}, operator_name = #{operatorName}, deal_date = #{dealDate}, " +
                        "updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateProcessStatus(String rid, String state, String operatorName, String dealDate);

        /**
         * 更新制证信息
         */
        @Update("UPDATE equip_depr_record SET " +
                        "create_cert_flag = #{createCertFlag}, create_cert_date = #{createCertDate}, " +
                        "updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateCertInfo(String rid, String createCertFlag, String createCertDate);

        /**
         * 更新计提信息
         */
        @Update("UPDATE equip_depr_record SET " +
                        "accrued_cost_flag = #{accruedCostFlag}, accrued_cost_date = #{accruedCostDate}, " +
                        "updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateAccruedCostInfo(String rid, String accruedCostFlag, String accruedCostDate);

        /**
         * 根据上传时间查询需要同步的数据
         */
        @Select("SELECT * FROM equip_depr_record WHERE upload_time >= #{lastSyncTime} AND (deleted IS NULL OR deleted = '0')")
        List<EquipDeprRecord> selectByUploadTime(String lastSyncTime);

        /**
         * 根据更新时间查询需要更新的数据
         */
        @Select("SELECT * FROM equip_depr_record WHERE updt_time >= #{lastUpdateTime} AND (deleted IS NULL OR deleted = '0')")
        List<EquipDeprRecord> selectByUpdateTime(String lastUpdateTime);

        /**
         * 检查折旧记录是否存在
         */
        @Select("SELECT COUNT(*) FROM equip_depr_record WHERE equip_card_no = #{equipCardNo} AND depr_month = #{deprMonth} AND (deleted IS NULL OR deleted = '0')")
        int checkDeprRecordExists(String equipCardNo, String deprMonth);

        /**
         * 根据设备卡片号和折旧期间查询折旧记录
         */
        @Select("SELECT * FROM equip_depr_record WHERE equip_card_no = #{equipCardNo} AND depr_period = #{deprPeriod} AND (deleted IS NULL OR deleted = '0')")
        EquipDeprRecord selectByEquipCardNoAndPeriod(String equipCardNo, Integer deprPeriod);

        /**
         * 更新折旧期间信息
         */
        @Update("UPDATE equip_depr_record SET " +
                        "depr_period = #{deprPeriod}, depr_month = #{deprMonth}, " +
                        "updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateDeprPeriodInfo(String rid, Integer deprPeriod, String deprMonth);

        /**
         * 批量更新折旧记录状态
         */
        @Update("UPDATE equip_depr_record SET " +
                        "state = #{state}, updt_time = SYSDATE " +
                        "WHERE equip_card_no = #{equipCardNo} AND depr_period <= #{maxPeriod} " +
                        "AND (deleted IS NULL OR deleted = '0')")
        int batchUpdateDeprRecordStatus(String equipCardNo, String state, Integer maxPeriod);

        /**
         * 根据RID检查折旧记录是否存在
         */
        @Select("SELECT COUNT(*) FROM equip_depr_record WHERE rid = #{rid}")
        int checkEquipDeprRecordExists(String rid);
}