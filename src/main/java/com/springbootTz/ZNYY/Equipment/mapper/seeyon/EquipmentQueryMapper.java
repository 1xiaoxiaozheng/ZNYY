package com.springbootTz.ZNYY.Equipment.mapper.seeyon;

import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_AssetCard;
import com.springbootTz.ZNYY.Equipment.entity.seeyon.LexmisN6_ExtendVal;
import com.springbootTz.ZNYY.Equipment.dto.AssetCardWithExtendValDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import java.util.List;
import java.util.Map;

/**
 * 设备综合查询Mapper接口
 * 用于SQL Server数据库的复杂查询操作
 */
@Mapper
public interface EquipmentQueryMapper {

        /**
         * 关联查询资产卡片和扩展值信息
         * 通过AC_ID和EV_ID关联
         */
        @Select("SELECT " +
                        "ac.AC_ID, ac.AC_NO, ac.AC_Name, ac.AC_OriMoney, " +
                        "ac.AC_GetDate, ac.AC_UseDeptNo, ac.AC_UseDeptNm, ac.AC_DeprKind, " +
                        "ac.AC_DeprRate, ac.AC_BVCode2, ac.AC_BVName1, ac.AC_BudgetOrg, ac.AC_BVName2, ac.AC_UpdateTime, "
                        +
                        "ev.EV_Field101, ev.EV_Field102, ev.EV_Field81, ev.EV_Field83, " +
                        "ev.EV_Field6, ev.EV_Field7, ev.EV_Field3, ev.EV_Field4 " +
                        "FROM LexmisN6_AssetCard ac " +
                        "LEFT JOIN LexmisN6_ExtendVal ev ON ac.AC_ID = ev.EV_ID")
        @Results({
                        @Result(property = "acId", column = "AC_ID"),
                        @Result(property = "acNo", column = "AC_NO"),
                        @Result(property = "acName", column = "AC_Name"),
                        @Result(property = "acOriMoney", column = "AC_OriMoney"),
                        @Result(property = "acGetDate", column = "AC_GetDate"),
                        @Result(property = "acUseDeptNo", column = "AC_UseDeptNo"),
                        @Result(property = "acUseDeptNm", column = "AC_UseDeptNm"),
                        @Result(property = "acDeprKind", column = "AC_DeprKind"),
                        @Result(property = "acDeprRate", column = "AC_DeprRate"),
                        @Result(property = "acBvCode2", column = "AC_BVCode2"),
                        @Result(property = "acBvName1", column = "AC_BVName1"),
                        @Result(property = "acBudgetOrg", column = "AC_BudgetOrg"),
                        @Result(property = "acBvName2", column = "AC_BVName2"),
                        @Result(property = "acUpdateTime", column = "AC_UpdateTime"),
                        @Result(property = "evField101", column = "EV_Field101"),
                        @Result(property = "evField102", column = "EV_Field102"),
                        @Result(property = "evField81", column = "EV_Field81"),
                        @Result(property = "evField83", column = "EV_Field83"),
                        @Result(property = "evField6", column = "EV_Field6"),
                        @Result(property = "evField7", column = "EV_Field7"),
                        @Result(property = "evField3", column = "EV_Field3"),
                        @Result(property = "evField4", column = "EV_Field4")
        })
        List<AssetCardWithExtendValDTO> selectAssetCardWithExtendVal();

        /**
         * 根据科室查询资产卡片和扩展值信息
         */
        @Select("SELECT " +
                        "ac.AC_ID, ac.AC_NO, ac.AC_Name, ac.AC_OriMoney, " +
                        "ac.AC_GetDate, ac.AC_UseDeptNo, ac.AC_UseDeptNm, ac.AC_DeprKind, " +
                        "ac.AC_DeprRate, ac.AC_BVCode2, ac.AC_BVName1, ac.AC_BudgetOrg, ac.AC_BVName2, ac.AC_UpdateTime, "
                        +
                        "ev.EV_Field101, ev.EV_Field102, ev.EV_Field81, ev.EV_Field83, " +
                        "ev.EV_Field6, ev.EV_Field7, ev.EV_Field3, ev.EV_Field4 " +
                        "FROM LexmisN6_AssetCard ac " +
                        "LEFT JOIN LexmisN6_ExtendVal ev ON ac.AC_ID = ev.EV_ID " +
                        "WHERE ac.AC_UseDeptNo = #{deptNo}")
        @Results({
                        @Result(property = "acId", column = "AC_ID"),
                        @Result(property = "acNo", column = "AC_NO"),
                        @Result(property = "acName", column = "AC_Name"),
                        @Result(property = "acOriMoney", column = "AC_OriMoney"),
                        @Result(property = "acGetDate", column = "AC_GetDate"),
                        @Result(property = "acUseDeptNo", column = "AC_UseDeptNo"),
                        @Result(property = "acUseDeptNm", column = "AC_UseDeptNm"),
                        @Result(property = "acDeprKind", column = "AC_DeprKind"),
                        @Result(property = "acDeprRate", column = "AC_DeprRate"),
                        @Result(property = "acBvCode2", column = "AC_BVCode2"),
                        @Result(property = "acBvName1", column = "AC_BVName1"),
                        @Result(property = "acBudgetOrg", column = "AC_BudgetOrg"),
                        @Result(property = "acBvName2", column = "AC_BVName2"),
                        @Result(property = "acUpdateTime", column = "AC_UpdateTime"),
                        @Result(property = "evField101", column = "EV_Field101"),
                        @Result(property = "evField102", column = "EV_Field102"),
                        @Result(property = "evField81", column = "EV_Field81"),
                        @Result(property = "evField83", column = "EV_Field83"),
                        @Result(property = "evField6", column = "EV_Field6"),
                        @Result(property = "evField7", column = "EV_Field7"),
                        @Result(property = "evField3", column = "EV_Field3"),
                        @Result(property = "evField4", column = "EV_Field4")
        })
        List<AssetCardWithExtendValDTO> selectAssetCardWithExtendValByDept(String deptNo);

        /**
         * 根据资产状态查询资产卡片和扩展值信息
         */
        @Select("SELECT " +
                        "ac.AC_ID, ac.AC_NO, ac.AC_Name, ac.AC_OriMoney, " +
                        "ac.AC_GetDate, ac.AC_UseDeptNo, ac.AC_UseDeptNm, ac.AC_DeprKind, " +
                        "ac.AC_DeprRate, ac.AC_BVCode2, ac.AC_BVName1, ac.AC_BudgetOrg, ac.AC_BVName2, ac.AC_UpdateTime, "
                        +
                        "ev.EV_Field101, ev.EV_Field102, ev.EV_Field81, ev.EV_Field83, " +
                        "ev.EV_Field6, ev.EV_Field7, ev.EV_Field3, ev.EV_Field4 " +
                        "FROM LexmisN6_AssetCard ac " +
                        "LEFT JOIN LexmisN6_ExtendVal ev ON ac.AC_ID = ev.EV_ID " +
                        "WHERE ac.AC_BVCode2 = #{statusCode}")
        @Results({
                        @Result(property = "acId", column = "AC_ID"),
                        @Result(property = "acNo", column = "AC_NO"),
                        @Result(property = "acName", column = "AC_Name"),
                        @Result(property = "acOriMoney", column = "AC_OriMoney"),
                        @Result(property = "acGetDate", column = "AC_GetDate"),
                        @Result(property = "acUseDeptNo", column = "AC_UseDeptNo"),
                        @Result(property = "acUseDeptNm", column = "AC_UseDeptNm"),
                        @Result(property = "acDeprKind", column = "AC_DeprKind"),
                        @Result(property = "acDeprRate", column = "AC_DeprRate"),
                        @Result(property = "acBvCode2", column = "AC_BVCode2"),
                        @Result(property = "acBvName1", column = "AC_BVName1"),
                        @Result(property = "acBudgetOrg", column = "AC_BudgetOrg"),
                        @Result(property = "acBvName2", column = "AC_BVName2"),
                        @Result(property = "acUpdateTime", column = "AC_UpdateTime"),
                        @Result(property = "evField101", column = "EV_Field101"),
                        @Result(property = "evField102", column = "EV_Field102"),
                        @Result(property = "evField81", column = "EV_Field81"),
                        @Result(property = "evField83", column = "EV_Field83"),
                        @Result(property = "evField6", column = "EV_Field6"),
                        @Result(property = "evField7", column = "EV_Field7"),
                        @Result(property = "evField3", column = "EV_Field3"),
                        @Result(property = "evField4", column = "EV_Field4")
        })
        List<AssetCardWithExtendValDTO> selectAssetCardWithExtendValByStatus(String statusCode);

        /**
         * 查询指定日期范围内的资产信息（包含扩展值）
         */
        @Select("SELECT " +
                        "ac.AC_ID, ac.AC_NO, ac.AC_Name, ac.AC_OriMoney, " +
                        "ac.AC_GetDate, ac.AC_UseDeptNo, ac.AC_UseDeptNm, ac.AC_DeprKind, " +
                        "ac.AC_DeprRate, ac.AC_BVCode2, ac.AC_BVName1, ac.AC_BudgetOrg, ac.AC_BVName2, ac.AC_UpdateTime, "
                        +
                        "ev.EV_Field101, ev.EV_Field102, ev.EV_Field81, ev.EV_Field83, " +
                        "ev.EV_Field6, ev.EV_Field7, ev.EV_Field3, ev.EV_Field4 " +
                        "FROM LexmisN6_AssetCard ac " +
                        "LEFT JOIN LexmisN6_ExtendVal ev ON ac.AC_ID = ev.EV_ID " +
                        "WHERE ac.AC_GetDate BETWEEN #{startDate} AND #{endDate}")
        @Results({
                        @Result(property = "acId", column = "AC_ID"),
                        @Result(property = "acNo", column = "AC_NO"),
                        @Result(property = "acName", column = "AC_Name"),
                        @Result(property = "acOriMoney", column = "AC_OriMoney"),
                        @Result(property = "acGetDate", column = "AC_GetDate"),
                        @Result(property = "acUseDeptNo", column = "AC_UseDeptNo"),
                        @Result(property = "acUseDeptNm", column = "AC_UseDeptNm"),
                        @Result(property = "acDeprKind", column = "AC_DeprKind"),
                        @Result(property = "acDeprRate", column = "AC_DeprRate"),
                        @Result(property = "acBvCode2", column = "AC_BVCode2"),
                        @Result(property = "acBvName1", column = "AC_BVName1"),
                        @Result(property = "acBudgetOrg", column = "AC_BudgetOrg"),
                        @Result(property = "acBvName2", column = "AC_BVName2"),
                        @Result(property = "acUpdateTime", column = "AC_UpdateTime"),
                        @Result(property = "evField101", column = "EV_Field101"),
                        @Result(property = "evField102", column = "EV_Field102"),
                        @Result(property = "evField81", column = "EV_Field81"),
                        @Result(property = "evField83", column = "EV_Field83"),
                        @Result(property = "evField6", column = "EV_Field6"),
                        @Result(property = "evField7", column = "EV_Field7"),
                        @Result(property = "evField3", column = "EV_Field3"),
                        @Result(property = "evField4", column = "EV_Field4")
        })
        List<AssetCardWithExtendValDTO> selectAssetCardWithExtendValByDateRange(String startDate, String endDate);

        /**
         * 统计各科室资产数量
         */
        @Select("SELECT " +
                        "AC_UseDeptNm as deptName, " +
                        "COUNT(*) as assetCount, " +
                        "SUM(AC_OriMoney) as totalValue " +
                        "FROM LexmisN6_AssetCard " +
                        "GROUP BY AC_UseDeptNm, AC_UseDeptNo " +
                        "ORDER BY assetCount DESC")
        List<Map<String, Object>> selectAssetStatisticsByDept();

        /**
         * 统计各状态资产数量
         */
        @Select("SELECT " +
                        "AC_BVName2 as statusName, " +
                        "COUNT(*) as assetCount, " +
                        "SUM(AC_OriMoney) as totalValue " +
                        "FROM LexmisN6_AssetCard " +
                        "GROUP BY AC_BVName2, AC_BVCode2 " +
                        "ORDER BY assetCount DESC")
        List<Map<String, Object>> selectAssetStatisticsByStatus();
}