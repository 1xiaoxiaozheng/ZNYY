package com.springbootTz.ZNYY.Equipment.mapper.znyy;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.znyy.EquipCardInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import java.util.List;

/**
 * EquipCardInfo Mapper接口
 * 用于Oracle数据库操作
 */
@Mapper
public interface EquipCardInfoMapper extends BaseMapper<EquipCardInfo> {

        /**
         * 插入设备卡片信息
         * 使用 MyBatis-Plus 的 BaseMapper.insert() 方法，让 @TableField 注解生效
         */
        // 删除自定义的 @Insert 注解，使用 BaseMapper.insert() 方法

        /**
         * 根据RID查询设备卡片信息
         */
        @Select("SELECT * FROM equip_card_info WHERE rid = #{rid}")
        EquipCardInfo selectByRid(String rid);

        /**
         * 根据设备卡片号查询
         */
        @Select("SELECT * FROM equip_card_info WHERE equip_card_no = #{equipCardNo}")
        EquipCardInfo selectByEquipCardNo(String equipCardNo);

        /**
         * 根据使用科室查询
         */
        @Select("SELECT * FROM equip_card_info WHERE use_dept_code = #{deptCode}")
        List<EquipCardInfo> selectByDeptCode(String deptCode);

        /**
         * 根据设备状态查询
         */
        @Select("SELECT * FROM equip_card_info WHERE equip_status_code = #{statusCode}")
        List<EquipCardInfo> selectByStatusCode(String statusCode);

        /**
         * 根据购买日期范围查询
         */
        @Select("SELECT * FROM equip_card_info WHERE buy_date BETWEEN #{startDate} AND #{endDate}")
        List<EquipCardInfo> selectByBuyDateRange(String startDate, String endDate);

        /**
         * 逻辑删除设备卡片信息
         */
        @Update("UPDATE equip_card_info SET deleted = '1', deleted_time = SYSDATE WHERE rid = #{rid}")
        int deleteEquipCardInfo(String rid);

        /**
         * 查询所有未删除的设备卡片信息
         */
        @Select("SELECT * FROM equip_card_info WHERE deleted IS NULL OR deleted = '0'")
        List<EquipCardInfo> selectAllActive();

        /**
         * 根据RID更新设备卡片信息
         */
        @Update("UPDATE equip_card_info SET " +
                        "org_name = #{orgName}, uscid = #{uscid}, upload_time = #{uploadTime}, " +
                        "sys_prdr_code = #{sysPrdrCode}, sys_prdr_name = #{sysPrdrName}, " +
                        "card_recno = #{cardRecno}, equip_card_no = #{equipCardNo}, apply_no = #{applyNo}, " +
                        "bill_sub_no = #{billSubNo}, batch_no = #{batchNo}, equip_code = #{equipCode}, " +
                        "equip_name = #{equipName}, buy_cost = #{buyCost}, now_cost = #{nowCost}, " +
                        "buy_date = #{buyDate}, start_use_date = #{startUseDate}, expire_date = #{expireDate}, " +
                        "use_dept_code = #{useDeptCode}, use_dept_name = #{useDeptName}, useful_life = #{usefulLife}, "
                        +
                        "manufacturer_code = #{manufacturerCode}, manufacturer_name = #{manufacturerName}, " +
                        "manufacture_no = #{manufactureNo}, purchase_operator = #{purchaseOperator}, " +
                        "accept_operator = #{acceptOperator}, manage_operator = #{manageOperator}, " +
                        "invo_no = #{invoNo}, equip_hospital_code = #{equipHospitalCode}, measure_code = #{measureCode}, "
                        +
                        "retest_period = #{retestPeriod}, retest_unit = #{retestUnit}, finance_fund = #{financeFund}, "
                        +
                        "science_fund = #{scienceFund}, self_fund = #{selfFund}, receive_no = #{receiveNo}, " +
                        "receive_date = #{receiveDate}, receive_operator = #{receiveOperator}, " +
                        "house_area_square = #{houseAreaSquare}, deprec_start_date = #{deprecStartDate}, " +
                        "deprec_flag = #{deprecFlag}, deprec_type_code = #{deprecTypeCode}, " +
                        "deprec_type_name = #{deprecTypeName}, deprec_rate = #{deprecRate}, " +
                        "mon_derp_amt = #{monDerpAmt}, net_salvage_rate = #{netSalvageRate}, " +
                        "net_salvage_cost = #{netSalvageCost}, equip_status_code = #{equipStatusCode}, " +
                        "equip_status_name = #{equipStatusName}, audit_flag = #{auditFlag}, " +
                        "reserve1 = #{reserve1}, reserve2 = #{reserve2}, data_clct_prdr_name = #{dataClctPrdrName}, " +
                        "updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateEquipCardInfo(EquipCardInfo equipCardInfo);

        /**
         * 根据设备卡片号更新设备卡片信息
         */
        @Update("UPDATE equip_card_info SET " +
                        "org_name = #{orgName}, uscid = #{uscid}, upload_time = #{uploadTime}, " +
                        "sys_prdr_code = #{sysPrdrCode}, sys_prdr_name = #{sysPrdrName}, " +
                        "card_recno = #{cardRecno}, apply_no = #{applyNo}, bill_sub_no = #{billSubNo}, " +
                        "batch_no = #{batchNo}, equip_code = #{equipCode}, equip_name = #{equipName}, " +
                        "buy_cost = #{buyCost}, now_cost = #{nowCost}, buy_date = #{buyDate}, " +
                        "start_use_date = #{startUseDate}, expire_date = #{expireDate}, " +
                        "use_dept_code = #{useDeptCode}, use_dept_name = #{useDeptName}, useful_life = #{usefulLife}, "
                        +
                        "manufacturer_code = #{manufacturerCode}, manufacturer_name = #{manufacturerName}, " +
                        "manufacture_no = #{manufactureNo}, purchase_operator = #{purchaseOperator}, " +
                        "accept_operator = #{acceptOperator}, manage_operator = #{manageOperator}, " +
                        "invo_no = #{invoNo}, equip_hospital_code = #{equipHospitalCode}, measure_code = #{measureCode}, "
                        +
                        "retest_period = #{retestPeriod}, retest_unit = #{retestUnit}, finance_fund = #{financeFund}, "
                        +
                        "science_fund = #{scienceFund}, self_fund = #{selfFund}, receive_no = #{receiveNo}, " +
                        "receive_date = #{receiveDate}, receive_operator = #{receiveOperator}, " +
                        "house_area_square = #{houseAreaSquare}, deprec_start_date = #{deprecStartDate}, " +
                        "deprec_flag = #{deprecFlag}, deprec_type_code = #{deprecTypeCode}, " +
                        "deprec_type_name = #{deprecTypeName}, deprec_rate = #{deprecRate}, " +
                        "mon_derp_amt = #{monDerpAmt}, net_salvage_rate = #{netSalvageRate}, " +
                        "net_salvage_cost = #{netSalvageCost}, equip_status_code = #{equipStatusCode}, " +
                        "equip_status_name = #{equipStatusName}, audit_flag = #{auditFlag}, " +
                        "reserve1 = #{reserve1}, reserve2 = #{reserve2}, data_clct_prdr_name = #{dataClctPrdrName}, " +
                        "updt_time = SYSDATE " +
                        "WHERE equip_card_no = #{equipCardNo}")
        int updateEquipCardInfoByCardNo(EquipCardInfo equipCardInfo);

        /**
         * 批量更新设备卡片信息
         */
        @Update("UPDATE equip_card_info SET " +
                        "org_name = #{orgName}, uscid = #{uscid}, upload_time = #{uploadTime}, " +
                        "sys_prdr_code = #{sysPrdrCode}, sys_prdr_name = #{sysPrdrName}, " +
                        "card_recno = #{cardRecno}, apply_no = #{applyNo}, bill_sub_no = #{billSubNo}, " +
                        "batch_no = #{batchNo}, equip_code = #{equipCode}, equip_name = #{equipName}, " +
                        "buy_cost = #{buyCost}, now_cost = #{nowCost}, buy_date = #{buyDate}, " +
                        "start_use_date = #{startUseDate}, expire_date = #{expireDate}, " +
                        "use_dept_code = #{useDeptCode}, use_dept_name = #{useDeptName}, useful_life = #{usefulLife}, "
                        +
                        "manufacturer_code = #{manufacturerCode}, manufacturer_name = #{manufacturerName}, " +
                        "manufacture_no = #{manufactureNo}, purchase_operator = #{purchaseOperator}, " +
                        "accept_operator = #{acceptOperator}, manage_operator = #{manageOperator}, " +
                        "invo_no = #{invoNo}, equip_hospital_code = #{equipHospitalCode}, measure_code = #{measureCode}, "
                        +
                        "retest_period = #{retestPeriod}, retest_unit = #{retestUnit}, finance_fund = #{financeFund}, "
                        +
                        "science_fund = #{scienceFund}, self_fund = #{selfFund}, receive_no = #{receiveNo}, " +
                        "receive_date = #{receiveDate}, receive_operator = #{receiveOperator}, " +
                        "house_area_square = #{houseAreaSquare}, deprec_start_date = #{deprecStartDate}, " +
                        "deprec_flag = #{deprecFlag}, deprec_type_code = #{deprecTypeCode}, " +
                        "deprec_type_name = #{deprecTypeName}, deprec_rate = #{deprecRate}, " +
                        "mon_derp_amt = #{monDerpAmt}, net_salvage_rate = #{netSalvageRate}, " +
                        "net_salvage_cost = #{netSalvageCost}, equip_status_code = #{equipStatusCode}, " +
                        "equip_status_name = #{equipStatusName}, audit_flag = #{auditFlag}, " +
                        "reserve1 = #{reserve1}, reserve2 = #{reserve2}, data_clct_prdr_name = #{dataClctPrdrName}, " +
                        "updt_time = SYSDATE " +
                        "WHERE equip_card_no = #{equipCardNo} AND (deleted IS NULL OR deleted = '0')")
        int updateEquipCardInfoActive(EquipCardInfo equipCardInfo);

        /**
         * 更新设备状态
         */
        @Update("UPDATE equip_card_info SET " +
                        "equip_status_code = #{equipStatusCode}, equip_status_name = #{equipStatusName}, " +
                        "updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateEquipStatus(String rid, String equipStatusCode, String equipStatusName);

        /**
         * 更新折旧信息
         */
        @Update("UPDATE equip_card_info SET " +
                        "deprec_flag = #{deprecFlag}, deprec_type_code = #{deprecTypeCode}, " +
                        "deprec_type_name = #{deprecTypeName}, deprec_rate = #{deprecRate}, " +
                        "mon_derp_amt = #{monDerpAmt}, net_salvage_rate = #{netSalvageRate}, " +
                        "net_salvage_cost = #{netSalvageCost}, deprec_start_date = #{deprecStartDate}, " +
                        "updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateDepreciationInfo(EquipCardInfo equipCardInfo);

        /**
         * 更新使用科室信息
         */
        @Update("UPDATE equip_card_info SET " +
                        "use_dept_code = #{useDeptCode}, use_dept_name = #{useDeptName}, " +
                        "updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateDeptInfo(String rid, String useDeptCode, String useDeptName);

        /**
         * 根据上传时间查询需要同步的数据
         */
        @Select("SELECT * FROM equip_card_info WHERE upload_time >= #{lastSyncTime} AND (deleted IS NULL OR deleted = '0')")
        List<EquipCardInfo> selectByUploadTime(String lastSyncTime);

        /**
         * 查询需要更新的数据（根据更新时间）
         */
        @Select("SELECT * FROM equip_card_info WHERE updt_time >= #{lastUpdateTime} AND (deleted IS NULL OR deleted = '0')")
        List<EquipCardInfo> selectByUpdateTime(String lastUpdateTime);

        /**
         * 检查设备卡片是否存在
         */
        @Select("SELECT COUNT(*) FROM equip_card_info WHERE equip_card_no = #{equipCardNo} AND (deleted IS NULL OR deleted = '0')")
        int checkEquipCardExists(String equipCardNo);
}