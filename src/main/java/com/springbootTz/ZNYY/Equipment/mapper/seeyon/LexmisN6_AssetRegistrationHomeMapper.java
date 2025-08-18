package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetRegistrationHome;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_AssetRegistrationHome Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetRegistrationHomeMapper extends BaseMapper<LexmisN6_AssetRegistrationHome> {

    /**
     * 查询所有家居设备资产登记单信息
     */
    @Select("SELECT * FROM formmain_0988")
    List<LexmisN6_AssetRegistrationHome> selectAll();

    /**
     * 根据单据编号查询家居设备资产登记单信息
     */
    @Select("SELECT * FROM formmain_0988 WHERE field0017 = #{field0017}")
    LexmisN6_AssetRegistrationHome selectByField0017(String field0017);

    /**
     * 根据填报人查询家居设备资产登记单信息
     */
    @Select("SELECT * FROM formmain_0988 WHERE field0026 = #{field0026}")
    List<LexmisN6_AssetRegistrationHome> selectByField0026(String field0026);

    /**
     * 根据所属科室查询家居设备资产登记单信息
     */
    @Select("SELECT * FROM formmain_0988 WHERE field0027 = #{field0027}")
    List<LexmisN6_AssetRegistrationHome> selectByField0027(String field0027);

    /**
     * 根据单位查询家居设备资产登记单信息
     */
    @Select("SELECT * FROM formmain_0988 WHERE field0152 = #{field0152}")
    List<LexmisN6_AssetRegistrationHome> selectByField0152(String field0152);

    /**
     * 根据实际采购人员查询家居设备资产登记单信息
     */
    @Select("SELECT * FROM formmain_0988 WHERE field0162 = #{field0162}")
    List<LexmisN6_AssetRegistrationHome> selectByField0162(String field0162);

    /**
     * 查询指定日期范围内的家居设备资产登记单信息
     */
    @Select("SELECT * FROM formmain_0988 WHERE field0028 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetRegistrationHome> selectByDateRange(String startDate, String endDate);
}