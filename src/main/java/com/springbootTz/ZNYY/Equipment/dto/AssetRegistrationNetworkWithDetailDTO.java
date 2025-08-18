package com.springbootTz.ZNYY.Equipment.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 资产登记-网络信息设备主表与明细表关联查询DTO
 */
@Data
public class AssetRegistrationNetworkWithDetailDTO {

    // 主表信息
    private Long id; // 主表ID
    private String field0001; // 单据编号
    private String field0002; // 填报人
    private String field0003; // 所属科室
    private Date field0004; // 填报日期
    private String field0005; // 实际采购人员
    private String field0006; // 单位
    private String field0047; // 采购人员确认
    private String field0048; // 财务审核
    private String field0051; // 填报人-文本
    private String field0052; // 实际采购人员-文本
    private Date startDate; // 开始日期

    // 明细表信息
    private Long detailId; // 明细表ID
    private String field0007; // 资产编号
    private String field0008; // 资产名称
    private String field0009; // 资产类型
    private String field0010; // 资产分类
    private String field0011; // 资产分类代码
    private String field0012; // 取得方式
    private String field0013; // 资产简称
    private BigDecimal field0014; // 原始价值
    private String field0015; // 规格型号
    private BigDecimal field0016; // 资产数量
    private String field0017; // 管理科室
    private String field0018; // 归属科室
    private String field0019; // 归属单位
    private String field0020; // 存放地点
    private BigDecimal field0021; // 价值类型
    private BigDecimal field0022; // 采购组织形式
    private BigDecimal field0023; // 财务入账状态
    private Date field0024; // 记账日期
    private String field0025; // 记账凭证号
    private BigDecimal field0026; // 资产用途
    private String field0027; // 经费来源
    private String field0028; // 财政名称
    private String field0029; // 折旧方法
    private BigDecimal field0030; // 折旧小数位数
    private BigDecimal field0031; // 预计使用年限
    private Date field0032; // 期初折旧起始日期
    private BigDecimal field0033; // 期初已折旧期间
    private BigDecimal field0034; // 期初累计折旧
    private Date field0035; // 折旧起始日期
    private String field0036; // 资产说明
    private String field0037; // 供应商
    private String field0038; // 发票号
    private String field0039; // 品牌
    private String field0040; // 合同编号
    private String field0041; // 联系人
    private String field0042; // 联系方式
    private String field0043; // 生产厂家
    private Date field0044; // 取得日期
    private String field0045; // 资产图片
    private String field0046; // 资产附件
    private BigDecimal field0049; // 序号1
    private BigDecimal field0050; // 预计使用月数
    private String field0053; // 经费来源-文本
    private Long formmainId; // 关联主表的ID
}