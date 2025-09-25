package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetRegistrationMedical;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_AssetRegistrationMedical Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetRegistrationMedicalMapper extends BaseMapper<LexmisN6_AssetRegistrationMedical> {

    /**
     * 查询所有医疗专用设备资产登记单信息
     */
    @Select("SELECT * FROM ormmain_1193")
    List<LexmisN6_AssetRegistrationMedical> selectAll();

    /**
     * 根据单据编号查询医疗专用设备资产登记单信息
     */
    @Select("SELECT * FROM ormmain_1193 WHERE field0001 = #{field0001}")
    LexmisN6_AssetRegistrationMedical selectByField0001(String field0001);

    /**
     * 根据填报人查询医疗专用设备资产登记单信息
     */
    @Select("SELECT * FROM ormmain_1193 WHERE field0002 = #{field0002}")
    List<LexmisN6_AssetRegistrationMedical> selectByField0002(String field0002);

    /**
     * 根据所属科室查询医疗专用设备资产登记单信息
     */
    @Select("SELECT * FROM ormmain_1193 WHERE field0003 = #{field0003}")
    List<LexmisN6_AssetRegistrationMedical> selectByField0003(String field0003);

    /**
     * 根据单位查询医疗专用设备资产登记单信息
     */
    @Select("SELECT * FROM ormmain_1193 WHERE field0005 = #{field0005}")
    List<LexmisN6_AssetRegistrationMedical> selectByField0005(String field0005);

    /**
     * 根据实际采购人员查询医疗专用设备资产登记单信息
     */
    @Select("SELECT * FROM ormmain_1193 WHERE field0047 = #{field0047}")
    List<LexmisN6_AssetRegistrationMedical> selectByField0047(String field0047);

    /**
     * 查询指定日期范围内的医疗专用设备资产登记单信息
     */
    @Select("SELECT * FROM ormmain_1193 WHERE field0004 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetRegistrationMedical> selectByDateRange(String startDate, String endDate);
}