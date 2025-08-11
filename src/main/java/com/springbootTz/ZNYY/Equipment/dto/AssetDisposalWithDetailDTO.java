package com.springbootTz.ZNYY.Equipment.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 资产处置单与明细关联查询DTO
 */
@Data
public class AssetDisposalWithDetailDTO {

    // 主表信息
    private Long id; // 主表ID
    private String field0001; // 单据编号
    private String field0002; // 申请人
    private String field0003; // 申请科室
    private Date field0004; // 申请日期
    private String field0026; // 仓管意见
    private String field0033; // 仓库
    private String field0034; // 所属单位
    private Date startDate; // 开始日期

    // 明细表信息
    private Long detailId; // 明细表ID
    private String field0006; // 资产名称
    private String field0008; // 资产类型
    private String field0009; // 处置事由
    private String field0010; // 处置方式
    private String field0011; // 资产分类
    private String field0013; // 规格型号
    private String field0014; // 取得日期
    private BigDecimal field0015; // 原始价值
    private String field0016; // 折旧方法
    private String field0017; // 折旧起始日期
    private BigDecimal field0018; // 预计使用月数
    private String field0019; // 原使用科室
    private String field0020; // 原使用地点
    private String field0021; // 原使用人
    private String field0023; // 资产编号
    private String field0024; // 资产状态
    private BigDecimal field0028; // 资产数量
    private String field0029; // 原管理人
    private String field0030; // 原管理科室
    private String field0031; // 资产说明
    private Date field0032; // 处置日期
    private Long formmainId; // 关联主表的ID
}