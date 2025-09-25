package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetRegistrationNetwork;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_AssetRegistrationNetwork Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetRegistrationNetworkMapper extends BaseMapper<LexmisN6_AssetRegistrationNetwork> {

    /**
     * 查询所有资产登记-网络信息设备信息
     */
    @Select("SELECT * FROM formmain_1187")
    List<LexmisN6_AssetRegistrationNetwork> selectAll();

    /**
     * 根据单据编号查询资产登记-网络信息设备信息
     */
    @Select("SELECT * FROM formmain_1187 WHERE field0001 = #{field0001}")
    LexmisN6_AssetRegistrationNetwork selectByField0001(String field0001);

    /**
     * 根据填报人查询资产登记-网络信息设备信息
     */
    @Select("SELECT * FROM formmain_1187 WHERE field0002 = #{field0002}")
    List<LexmisN6_AssetRegistrationNetwork> selectByField0002(String field0002);

    /**
     * 根据所属科室查询资产登记-网络信息设备信息
     */
    @Select("SELECT * FROM formmain_1187 WHERE field0003 = #{field0003}")
    List<LexmisN6_AssetRegistrationNetwork> selectByField0003(String field0003);

    /**
     * 根据实际采购人员查询资产登记-网络信息设备信息
     */
    @Select("SELECT * FROM formmain_1187 WHERE field0005 = #{field0005}")
    List<LexmisN6_AssetRegistrationNetwork> selectByField0005(String field0005);

    /**
     * 根据单位查询资产登记-网络信息设备信息
     */
    @Select("SELECT * FROM formmain_1187 WHERE field0006 = #{field0006}")
    List<LexmisN6_AssetRegistrationNetwork> selectByField0006(String field0006);

    /**
     * 查询指定日期范围内的资产登记-网络信息设备信息
     */
    @Select("SELECT * FROM formmain_1187 WHERE field0004 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetRegistrationNetwork> selectByDateRange(String startDate, String endDate);

    /**
     * 根据财务审核状态查询资产登记-网络信息设备信息
     */
    @Select("SELECT * FROM formmain_1187 WHERE field0048 = #{field0048}")
    List<LexmisN6_AssetRegistrationNetwork> selectByField0048(String field0048);

    /**
     * 根据采购人员确认状态查询资产登记-网络信息设备信息
     */
    @Select("SELECT * FROM formmain_1187 WHERE field0047 = #{field0047}")
    List<LexmisN6_AssetRegistrationNetwork> selectByField0047(String field0047);
}