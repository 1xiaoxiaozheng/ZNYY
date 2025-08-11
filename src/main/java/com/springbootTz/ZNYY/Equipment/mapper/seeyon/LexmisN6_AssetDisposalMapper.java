package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetDisposal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * LexmisN6_AssetDisposal Mapper接口
 * 用于SQL Server数据库操作
 */
@Mapper
public interface LexmisN6_AssetDisposalMapper extends BaseMapper<LexmisN6_AssetDisposal> {

    /**
     * 查询所有资产处置单信息
     */
    @Select("SELECT * FROM formmain_1082")
    List<LexmisN6_AssetDisposal> selectAll();

    /**
     * 根据单据编号查询资产处置单信息
     */
    @Select("SELECT * FROM formmain_1082 WHERE field0001 = #{field0001}")
    LexmisN6_AssetDisposal selectByField0001(String field0001);

    /**
     * 根据申请人查询资产处置单信息
     */
    @Select("SELECT * FROM formmain_1082 WHERE field0002 = #{field0002}")
    List<LexmisN6_AssetDisposal> selectByField0002(String field0002);

    /**
     * 根据申请科室查询资产处置单信息
     */
    @Select("SELECT * FROM formmain_1082 WHERE field0003 = #{field0003}")
    List<LexmisN6_AssetDisposal> selectByField0003(String field0003);

    /**
     * 根据所属单位查询资产处置单信息
     */
    @Select("SELECT * FROM formmain_1082 WHERE field0034 = #{field0034}")
    List<LexmisN6_AssetDisposal> selectByField0034(String field0034);

    /**
     * 查询指定日期范围内的资产处置单信息
     */
    @Select("SELECT * FROM formmain_1082 WHERE field0004 BETWEEN #{startDate} AND #{endDate}")
    List<LexmisN6_AssetDisposal> selectByDateRange(String startDate, String endDate);
}