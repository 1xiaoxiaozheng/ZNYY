package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_AssetRegistration Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetRegistrationMapper extends BaseMapper<LexmisN6_AssetRegistration> {

    /**
     * 查询所有资产登记单信息
     */
    @Select("SELECT * FROM formmain_1199")
    List<LexmisN6_AssetRegistration> selectAll();

    /**
     * 根据单据编号查询资产登记单信息
     */
    @Select("SELECT * FROM formmain_1199 WHERE field0017 = #{field0017}")
    LexmisN6_AssetRegistration selectByField0017(String field0017);

    /**
     * 根据填报人查询资产登记单信息
     */
    @Select("SELECT * FROM formmain_1199 WHERE field0026 = #{field0026}")
    List<LexmisN6_AssetRegistration> selectByField0026(String field0026);

    /**
     * 根据所属科室查询资产登记单信息
     */
    @Select("SELECT * FROM formmain_1199 WHERE field0027 = #{field0027}")
    List<LexmisN6_AssetRegistration> selectByField0027(String field0027);

    /**
     * 根据单位查询资产登记单信息
     */
    @Select("SELECT * FROM formmain_1199 WHERE field0152 = #{field0152}")
    List<LexmisN6_AssetRegistration> selectByField0152(String field0152);

    /**
     * 根据实际采购人员查询资产登记单信息
     */
    @Select("SELECT * FROM formmain_1199 WHERE field0162 = #{field0162}")
    List<LexmisN6_AssetRegistration> selectByField0162(String field0162);

    /**
     * 查询指定日期范围内的资产登记单信息
     */
    @Select("SELECT * FROM formmain_1199 WHERE field0028 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetRegistration> selectByDateRange(String startDate, String endDate);
}