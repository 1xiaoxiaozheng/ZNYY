package com.springbootTz.ZNYY.Equipment.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 资产登记-医疗专用设备与明细关联查询DTO
 */
@Data
public class AssetRegistrationMedicalWithDetailDTO {

    // 主表信息
    private Long id; // 主表ID
    private String field0001; // 单据编号
    private String field0002; // 填报人
    private String field0003; // 所属科室
    private Date field0004; // 填报日期
    private String field0005; // 单位
    private String field0041; // 财务审核
    private String field0047; // 实际采购人员
    private String field0048; // 填报人-文本
    private String field0049; // 实际采购人员-文本
    private String field0050; // 采购人员确认
    private Date startDate; // 开始日期

    // 明细表信息
    private Long detailId; // 明细表ID
    private String field0006; // 资产编号
    private String field0007; // 资产名称
    private String field0008; // 资产类型
    private String field0009; // 资产分类
    private String field0011; // 资产来源
    private String field0012; // 资产简称
    private BigDecimal field0013; // 原始价值
    private String field0014; // 规格型号
    private BigDecimal field0015; // 资产数量
    private String field0016; // 管理科室
    private String field0018; // 归属科室
    private String field0019; // 归属单位
    private String field0020; // 存放地点
    private String field0021; // 经费来源
    private String field0022; // 财政名称
    private String field0023; // 折旧方法
    private BigDecimal field0024; // 折旧小数位数
    private BigDecimal field0025; // 预计使用年限
    private Date field0026; // 期初折旧起始日期
    private BigDecimal field0027; // 期初已折旧期间
    private BigDecimal field0028; // 期初累计折旧
    private Date field0029; // 折旧起始日期
    private String field0030; // 资产说明
    private String field0031; // 供应商
    private String field0032; // 发票号
    private String field0033; // 品牌
    private String field0034; // 合同编号
    private String field0035; // 联系人
    private String field0036; // 联系方式
    private String field0037; // 生产厂家
    private Date field0038; // 取得日期
    private String field0039; // 资产图片
    private String field0040; // 资产附件
    private BigDecimal field0042; // 序号1
    private String field0045; // 出厂编号
    private BigDecimal field0046; // 出厂使用年限
    private BigDecimal field0051; // 价值类型
    private BigDecimal field0052; // 采购组织形式
    private BigDecimal field0053; // 财务入账状态
    private Date field0054; // 记账日期
    private String field0055; // 记账凭证号
    private BigDecimal field0056; // 资产用途
    private String field0058; // 资产分类代码
    private BigDecimal field0059; // 预计使用月数
    private String field0060; // 经费来源-文本
    private Long formmainId; // 关联主表的ID
}