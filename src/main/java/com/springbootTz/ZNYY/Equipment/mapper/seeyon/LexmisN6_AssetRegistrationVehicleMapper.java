package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetRegistrationVehicle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_AssetRegistrationVehicle Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetRegistrationVehicleMapper extends BaseMapper<LexmisN6_AssetRegistrationVehicle> {

    /**
     * 查询所有资产登记-车辆信息
     */
    @Select("SELECT * FROM formmain_1195")
    List<LexmisN6_AssetRegistrationVehicle> selectAll();

    /**
     * 根据单据编号查询资产登记-车辆信息
     */
    @Select("SELECT * FROM formmain_1195 WHERE field0001 = #{field0001}")
    LexmisN6_AssetRegistrationVehicle selectByField0001(String field0001);

    /**
     * 根据填报人查询资产登记-车辆信息
     */
    @Select("SELECT * FROM formmain_1195 WHERE field0002 = #{field0002}")
    List<LexmisN6_AssetRegistrationVehicle> selectByField0002(String field0002);

    /**
     * 根据所属科室查询资产登记-车辆信息
     */
    @Select("SELECT * FROM formmain_1195 WHERE field0003 = #{field0003}")
    List<LexmisN6_AssetRegistrationVehicle> selectByField0003(String field0003);

    /**
     * 根据单位查询资产登记-车辆信息
     */
    @Select("SELECT * FROM formmain_1195 WHERE field0005 = #{field0005}")
    List<LexmisN6_AssetRegistrationVehicle> selectByField0005(String field0005);

    /**
     * 根据实际采购员查询资产登记-车辆信息
     */
    @Select("SELECT * FROM formmain_1195 WHERE field0064 = #{field0064}")
    List<LexmisN6_AssetRegistrationVehicle> selectByField0064(String field0064);

    /**
     * 查询指定日期范围内的资产登记-车辆信息
     */
    @Select("SELECT * FROM formmain_1195 WHERE field0004 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetRegistrationVehicle> selectByDateRange(String startDate, String endDate);

    /**
     * 根据财务审核状态查询资产登记-车辆信息
     */
    @Select("SELECT * FROM formmain_1195 WHERE field0061 = #{field0061}")
    List<LexmisN6_AssetRegistrationVehicle> selectByField0061(String field0061);

    /**
     * 根据采购人员确认状态查询资产登记-车辆信息
     */
    @Select("SELECT * FROM formmain_1195 WHERE field0060 = #{field0060}")
    List<LexmisN6_AssetRegistrationVehicle> selectByField0060(String field0060);
}