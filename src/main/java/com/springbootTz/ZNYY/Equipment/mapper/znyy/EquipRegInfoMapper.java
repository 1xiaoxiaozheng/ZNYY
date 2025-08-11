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
                        "#{manufacturerName}, #{devUsefulLife}, #{prodplacInfo}, #{useCode}, #{useName}, " +
                        "#{state}, #{reserve1}, #{reserve2}, #{dataClctPrdrName}, #{crteTime}, #{updtTime}, " +
                        "#{deleted}, #{deletedTime}" +
                        ")")
        int insertEquipRegInfo(EquipRegInfo equipRegInfo);

        /**
         * 根据RID查询设备注册信息
         */
        @Select("SELECT * FROM equip_reg_info WHERE rid = #{rid}")
        EquipRegInfo selectByRid(String rid);

        /**
         * 根据设备代码查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE equip_code = #{equipCode}")
        EquipRegInfo selectByEquipCode(String equipCode);

        /**
         * 根据设备名称查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE equip_name LIKE '%' || #{equipName} || '%'")
        List<EquipRegInfo> selectByEquipName(String equipName);

        /**
         * 根据固定资产类别查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE fixed_assets_type = #{fixedAssetsType}")
        List<EquipRegInfo> selectByFixedAssetsType(String fixedAssetsType);

        /**
         * 根据固定资产类别名称查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE fixed_assets_name LIKE '%' || #{fixedAssetsName} || '%'")
        List<EquipRegInfo> selectByFixedAssetsName(String fixedAssetsName);

        /**
         * 根据设备型号查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE equip_model LIKE '%' || #{equipModel} || '%'")
        List<EquipRegInfo> selectByEquipModel(String equipModel);

        /**
         * 根据生产厂商代码查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE manufacturer_code = #{manufacturerCode}")
        List<EquipRegInfo> selectByManufacturerCode(String manufacturerCode);

        /**
         * 根据生产厂商名称查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE manufacturer_name LIKE '%' || #{manufacturerName} || '%'")
        List<EquipRegInfo> selectByManufacturerName(String manufacturerName);

        /**
         * 根据用途代码查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE use_code = #{useCode}")
        List<EquipRegInfo> selectByUseCode(String useCode);

        /**
         * 根据用途名称查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE use_name LIKE '%' || #{useName} || '%'")
        List<EquipRegInfo> selectByUseName(String useName);

        /**
         * 根据停用标志查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE disable_flag = #{disableFlag}")
        List<EquipRegInfo> selectByDisableFlag(String disableFlag);

        /**
         * 查询启用的设备（停用标志为0）
         */
        @Select("SELECT * FROM equip_reg_info WHERE disable_flag = '0' OR disable_flag IS NULL")
        List<EquipRegInfo> selectActiveEquipments();

        /**
         * 查询停用的设备（停用标志为1）
         */
        @Select("SELECT * FROM equip_reg_info WHERE disable_flag = '1'")
        List<EquipRegInfo> selectDisabledEquipments();

        /**
         * 根据产地信息查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE prodplac_info LIKE '%' || #{prodplacInfo} || '%'")
        List<EquipRegInfo> selectByProdplacInfo(String prodplacInfo);

        /**
         * 根据规格查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE spec LIKE '%' || #{spec} || '%'")
        List<EquipRegInfo> selectBySpec(String spec);

        /**
         * 根据计量单位查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE unit = #{unit}")
        List<EquipRegInfo> selectByUnit(String unit);

        /**
         * 根据计量单位名称查询
         */
        @Select("SELECT * FROM equip_reg_info WHERE unit_name LIKE '%' || #{unitName} || '%'")
        List<EquipRegInfo> selectByUnitName(String unitName);

        /**
         * 逻辑删除设备注册信息
         */
        @Update("UPDATE equip_reg_info SET deleted = '1', deleted_time = SYSDATE WHERE rid = #{rid}")
        int deleteEquipRegInfo(String rid);

        /**
         * 查询所有未删除的设备注册信息
         */
        @Select("SELECT * FROM equip_reg_info WHERE deleted IS NULL OR deleted = '0'")
        List<EquipRegInfo> selectAllActive();

        /**
         * 统计各固定资产类别设备数量
         */
        @Select("SELECT " +
                        "fixed_assets_name as fixedAssetsName, " +
                        "COUNT(*) as equipCount " +
                        "FROM equip_reg_info " +
                        "WHERE deleted IS NULL OR deleted = '0' " +
                        "GROUP BY fixed_assets_name, fixed_assets_type " +
                        "ORDER BY equipCount DESC")
        List<Object> selectEquipStatisticsByAssetsType();

        /**
         * 统计各生产厂商设备数量
         */
        @Select("SELECT " +
                        "manufacturer_name as manufacturerName, " +
                        "COUNT(*) as equipCount " +
                        "FROM equip_reg_info " +
                        "WHERE deleted IS NULL OR deleted = '0' " +
                        "GROUP BY manufacturer_name, manufacturer_code " +
                        "ORDER BY equipCount DESC")
        List<Object> selectEquipStatisticsByManufacturer();

        /**
         * 统计各用途设备数量
         */
        @Select("SELECT " +
                        "use_name as useName, " +
                        "COUNT(*) as equipCount " +
                        "FROM equip_reg_info " +
                        "WHERE deleted IS NULL OR deleted = '0' " +
                        "GROUP BY use_name, use_code " +
                        "ORDER BY equipCount DESC")
        List<Object> selectEquipStatisticsByUse();

        /**
         * 统计启用和停用设备数量
         */
        @Select("SELECT " +
                        "CASE WHEN disable_flag = '1' THEN '停用' ELSE '启用' END as status, " +
                        "COUNT(*) as equipCount " +
                        "FROM equip_reg_info " +
                        "WHERE deleted IS NULL OR deleted = '0' " +
                        "GROUP BY disable_flag " +
                        "ORDER BY equipCount DESC")
        List<Object> selectEquipStatisticsByStatus();

        /**
         * 根据设备代码和名称组合查询
         */
        @Select("SELECT * FROM equip_reg_info " +
                        "WHERE equip_code = #{equipCode} AND equip_name = #{equipName} " +
                        "AND (deleted IS NULL OR deleted = '0')")
        EquipRegInfo selectByEquipCodeAndName(String equipCode, String equipName);

        /**
         * 查询所有设备代码
         */
        @Select("SELECT DISTINCT equip_code FROM equip_reg_info WHERE deleted IS NULL OR deleted = '0'")
        List<String> selectAllEquipCodes();

        /**
         * 查询所有设备名称
         */
        @Select("SELECT DISTINCT equip_name FROM equip_reg_info WHERE deleted IS NULL OR deleted = '0'")
        List<String> selectAllEquipNames();

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
                        "dev_useful_life = #{devUsefulLife}, prodplac_info = #{prodplacInfo}, " +
                        "use_code = #{useCode}, use_name = #{useName}, state = #{state}, " +
                        "reserve1 = #{reserve1}, reserve2 = #{reserve2}, data_clct_prdr_name = #{dataClctPrdrName}, " +
                        "updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateEquipRegInfo(EquipRegInfo equipRegInfo);

        /**
         * 根据设备代码更新设备注册信息
         */
        @Update("UPDATE equip_reg_info SET " +
                        "org_name = #{orgName}, uscid = #{uscid}, upload_time = #{uploadTime}, " +
                        "sys_prdr_code = #{sysPrdrCode}, sys_prdr_name = #{sysPrdrName}, " +
                        "equip_name = #{equipName}, fixed_assets_type = #{fixedAssetsType}, " +
                        "fixed_assets_name = #{fixedAssetsName}, spec = #{spec}, equip_model = #{equipModel}, " +
                        "unit = #{unit}, unit_name = #{unitName}, disable_flag = #{disableFlag}, " +
                        "manufacturer_code = #{manufacturerCode}, manufacturer_name = #{manufacturerName}, " +
                        "dev_useful_life = #{devUsefulLife}, prodplac_info = #{prodplacInfo}, " +
                        "use_code = #{useCode}, use_name = #{useName}, state = #{state}, " +
                        "reserve1 = #{reserve1}, reserve2 = #{reserve2}, data_clct_prdr_name = #{dataClctPrdrName}, " +
                        "updt_time = SYSDATE " +
                        "WHERE equip_code = #{equipCode}")
        int updateEquipRegInfoByEquipCode(EquipRegInfo equipRegInfo);

        /**
         * 更新未删除的设备注册信息
         */
        @Update("UPDATE equip_reg_info SET " +
                        "org_name = #{orgName}, uscid = #{uscid}, upload_time = #{uploadTime}, " +
                        "sys_prdr_code = #{sysPrdrCode}, sys_prdr_name = #{sysPrdrName}, " +
                        "equip_name = #{equipName}, fixed_assets_type = #{fixedAssetsType}, " +
                        "fixed_assets_name = #{fixedAssetsName}, spec = #{spec}, equip_model = #{equipModel}, " +
                        "unit = #{unit}, unit_name = #{unitName}, disable_flag = #{disableFlag}, " +
                        "manufacturer_code = #{manufacturerCode}, manufacturer_name = #{manufacturerName}, " +
                        "dev_useful_life = #{devUsefulLife}, prodplac_info = #{prodplacInfo}, " +
                        "use_code = #{useCode}, use_name = #{useName}, state = #{state}, " +
                        "reserve1 = #{reserve1}, reserve2 = #{reserve2}, data_clct_prdr_name = #{dataClctPrdrName}, " +
                        "updt_time = SYSDATE " +
                        "WHERE equip_code = #{equipCode} AND (deleted IS NULL OR deleted = '0')")
        int updateEquipRegInfoActive(EquipRegInfo equipRegInfo);

        /**
         * 更新设备基本信息
         */
        @Update("UPDATE equip_reg_info SET " +
                        "equip_name = #{equipName}, spec = #{spec}, equip_model = #{equipModel}, " +
                        "unit = #{unit}, unit_name = #{unitName}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateEquipBasicInfo(EquipRegInfo equipRegInfo);

        /**
         * 更新固定资产类别信息
         */
        @Update("UPDATE equip_reg_info SET " +
                        "fixed_assets_type = #{fixedAssetsType}, fixed_assets_name = #{fixedAssetsName}, " +
                        "updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateFixedAssetsInfo(String rid, String fixedAssetsType, String fixedAssetsName);

        /**
         * 更新生产厂商信息
         */
        @Update("UPDATE equip_reg_info SET " +
                        "manufacturer_code = #{manufacturerCode}, manufacturer_name = #{manufacturerName}, " +
                        "prodplac_info = #{prodplacInfo}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateManufacturerInfo(String rid, String manufacturerCode, String manufacturerName, String prodplacInfo);

        /**
         * 更新用途信息
         */
        @Update("UPDATE equip_reg_info SET " +
                        "use_code = #{useCode}, use_name = #{useName}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateUseInfo(String rid, String useCode, String useName);

        /**
         * 更新停用标志
         */
        @Update("UPDATE equip_reg_info SET " +
                        "disable_flag = #{disableFlag}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateDisableFlag(String rid, String disableFlag);

        /**
         * 更新设备状态
         */
        @Update("UPDATE equip_reg_info SET " +
                        "state = #{state}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateEquipState(String rid, String state);

        /**
         * 更新设备使用寿命
         */
        @Update("UPDATE equip_reg_info SET " +
                        "dev_useful_life = #{devUsefulLife}, updt_time = SYSDATE " +
                        "WHERE rid = #{rid}")
        int updateDevUsefulLife(String rid, Integer devUsefulLife);

        /**
         * 根据上传时间查询需要同步的数据
         */
        @Select("SELECT * FROM equip_reg_info WHERE upload_time >= #{lastSyncTime} AND (deleted IS NULL OR deleted = '0')")
        List<EquipRegInfo> selectByUploadTime(String lastSyncTime);

        /**
         * 根据更新时间查询需要更新的数据
         */
        @Select("SELECT * FROM equip_reg_info WHERE updt_time >= #{lastUpdateTime} AND (deleted IS NULL OR deleted = '0')")
        List<EquipRegInfo> selectByUpdateTime(String lastUpdateTime);

        /**
         * 检查设备注册信息是否存在
         */
        @Select("SELECT COUNT(*) FROM equip_reg_info WHERE equip_code = #{equipCode} AND (deleted IS NULL OR deleted = '0')")
        int checkEquipRegInfoExists(String equipCode);

        /**
         * 根据设备代码查询设备注册信息（未删除）
         */
        @Select("SELECT * FROM equip_reg_info WHERE equip_code = #{equipCode} AND (deleted IS NULL OR deleted = '0')")
        EquipRegInfo selectByEquipCodeActive(String equipCode);

        /**
         * 批量更新设备停用标志
         */
        @Update("UPDATE equip_reg_info SET " +
                        "disable_flag = #{disableFlag}, updt_time = SYSDATE " +
                        "WHERE equip_code IN (${equipCodes}) AND (deleted IS NULL OR deleted = '0')")
        int batchUpdateDisableFlag(String equipCodes, String disableFlag);

        /**
         * 批量更新设备状态
         */
        @Update("UPDATE equip_reg_info SET " +
                        "state = #{state}, updt_time = SYSDATE " +
                        "WHERE equip_code IN (${equipCodes}) AND (deleted IS NULL OR deleted = '0')")
        int batchUpdateEquipState(String equipCodes, String state);

        /**
         * 根据固定资产类别查询设备注册信息（未删除）
         */
        @Select("SELECT * FROM equip_reg_info WHERE fixed_assets_type = #{fixedAssetsType} AND (deleted IS NULL OR deleted = '0')")
        List<EquipRegInfo> selectByFixedAssetsTypeActive(String fixedAssetsType);

        /**
         * 根据生产厂商代码查询设备注册信息（未删除）
         */
        @Select("SELECT * FROM equip_reg_info WHERE manufacturer_code = #{manufacturerCode} AND (deleted IS NULL OR deleted = '0')")
        List<EquipRegInfo> selectByManufacturerCodeActive(String manufacturerCode);

        /**
         * 根据用途代码查询设备注册信息（未删除）
         */
        @Select("SELECT * FROM equip_reg_info WHERE use_code = #{useCode} AND (deleted IS NULL OR deleted = '0')")
        List<EquipRegInfo> selectByUseCodeActive(String useCode);

        /**
         * 查询启用的设备注册信息（未删除）
         */
        @Select("SELECT * FROM equip_reg_info WHERE (disable_flag = '0' OR disable_flag IS NULL) AND (deleted IS NULL OR deleted = '0')")
        List<EquipRegInfo> selectActiveEquipmentsRegInfo();

        /**
         * 查询停用的设备注册信息（未删除）
         */
        @Select("SELECT * FROM equip_reg_info WHERE disable_flag = '1' AND (deleted IS NULL OR deleted = '0')")
        List<EquipRegInfo> selectDisabledEquipmentsRegInfo();
}