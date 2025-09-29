package com.springbootTz.ZNYY.Equipment.mapper.znyy;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.znyy.EquipRegInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

/**
 * EquipRegInfo Mapper接口
 * 用于Oracle数据库操作
 */
@Mapper
public interface EquipRegInfoMapper extends BaseMapper<EquipRegInfo> {

        /**
         * 插入设备注册信息
         */
        @Insert("INSERT INTO equip_reg_info (" +
                        "rid, org_name, uscid, upload_time, sys_prdr_code, sys_prdr_name, " +
                        "equip_code, equip_name, fixed_assets_type, fixed_assets_name, spec, " +
                        "equip_model, unit, unit_name, disable_flag, manufacturer_code, " +
                        "manufacturer_name, dev_useful_life, prodplac_info, use_code, use_name, " +
                        "state, reserve1, reserve2, data_clct_prdr_name, crte_time, updt_time, " +
                        "deleted, deleted_time" +
                        ") VALUES (" +
                        "#{rid}, #{orgName}, #{uscid}, #{uploadTime}, #{sysPrdrCode}, #{sysPrdrName}, " +
                        "#{equipCode}, #{equipName}, #{fixedAssetsType}, #{fixedAssetsName}, #{spec}, " +
                        "#{equipModel}, #{unit}, #{unitName}, #{disableFlag}, #{manufacturerCode}, " +
                        "#{manufacturerName}, " +
                        "CASE WHEN #{devUsefulLife} IS NULL THEN NULL ELSE #{devUsefulLife} END, " + // 设备使用年限，null时设置为NULL
                        "#{prodplacInfo}, #{useCode}, #{useName}, " +
                        "#{state}, #{reserve1}, #{reserve2}, #{dataClctPrdrName}, " +
                        "SYSDATE, " + // crte_time 使用当前时间
                        "SYSDATE, #{deleted}, " +
                        "NULL" + // deleted_time 设置为 NULL
                        ")")
        int insertEquipRegInfo(EquipRegInfo equipRegInfo);

        /**
         * 根据RID更新设备注册信息
         */
        @Update("UPDATE equip_reg_info SET " +
                        "org_name = #{orgName}, uscid = #{uscid}, upload_time = #{uploadTime}, " +
                        "sys_prdr_code = #{sysPrdrCode}, sys_prdr_name = #{sysPrdrName}, " +
                        "equip_code = #{equipCode}, equip_name = #{equipName}, fixed_assets_type = #{fixedAssetsType}, "
                        +
                        "fixed_assets_name = #{fixedAssetsName}, spec = #{spec}, equip_model = #{equipModel}, " +
                        "unit = #{unit}, unit_name = #{unitName}, disable_flag = #{disableFlag}, " +
                        "manufacturer_code = #{manufacturerCode}, manufacturer_name = #{manufacturerName}, " +
                        "dev_useful_life = CASE WHEN #{devUsefulLife} IS NULL THEN NULL ELSE #{devUsefulLife} END, " + // 设备使用年限，null时设置为NULL
                        "prodplac_info = #{prodplacInfo}, " +
                        "use_code = #{useCode}, use_name = #{useName}, state = #{state}, " +
                        "reserve1 = #{reserve1}, reserve2 = #{reserve2}, data_clct_prdr_name = #{dataClctPrdrName}, " +
                        "crte_time = CASE WHEN crte_time IS NULL THEN SYSDATE ELSE crte_time END, " + // 如果存在就不更改，不存在就设置成当前时间
                        "updt_time = SYSDATE, deleted = #{deleted}, " +
                        "deleted_time = NULL " + // deleted_time 设置为 NULL
                        "WHERE rid = #{rid}")
        int updateEquipRegInfo(EquipRegInfo equipRegInfo);

        /**
         * 检查设备注册信息是否存在（包括已删除的记录）
         */
        @Select("SELECT COUNT(*) FROM equip_reg_info WHERE rid = #{rid}")
        int checkEquipRegInfoExists(String rid);

        /**
         * 根据系统厂商代码查询所有未删除的设备RID
         */
        @Select("SELECT rid FROM equip_reg_info WHERE sys_prdr_code = #{sysPrdrCode} AND (deleted IS NULL OR deleted = '0')")
        List<String> selectActiveRidsBySysPrdrCode(String sysPrdrCode);

        /**
         * 批量标记设备为已删除
         */
        @Update("UPDATE equip_reg_info SET deleted = '1', deleted_time = SYSDATE WHERE rid IN (${rids})")
        int batchMarkAsDeleted(String rids);
}