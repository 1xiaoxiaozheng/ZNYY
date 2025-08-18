package com.springbootTz.ZNYY.Equipment.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 资产登记单-家居设备与明细关联查询DTO
 */
@Data
public class AssetRegistrationHomeWithDetailDTO {

    // 主表信息
    private Long id; // 主表ID
    private String field0017; // 单据编号
    private String field0024; // 财务审核
    private String field0026; // 填报人
    private String field0027; // 所属科室
    private Date field0028; // 填报日期
    private String field0152; // 单位
    private String field0162; // 实际采购人员
    private String field0163; // 采购人员确认
    private String field0164; // 填报人-文本
    private String field0165; // 实际采购人员-文本
    private Date startDate; // 开始日期

    // 明细表信息
    private Long detailId; // 明细表ID
    private String field0001; // 资产编号
    private String field0002; // 资产名称
    private String field0006; // 规格型号
    private BigDecimal field0007; // 原始价值
    private Date field0010; // 折旧起始日期
    private String field0013; // 供应商
    private String field0014; // 联系人
    private String field0031; // 联系方式
    private Date field0032; // 取得日期
    private BigDecimal field0036; // 预计使用月数
    private String field0041; // 管理科室
    private BigDecimal field0047; // 折旧小数位数
    private BigDecimal field0048; // 期初累计折旧
    private String field0058; // 资产图片
    private String field0059; // 资产附件
    private BigDecimal field0066; // 资产数量
    private String field0072; // 资产说明
    private Date field0099; // 期初折旧起始日期
    private String field0102; // 资产简称
    private BigDecimal field0108; // 期初已折旧期间
    private String field0125; // 资产来源
    private String field0126; // 资产分类
    private String field0128; // 折旧方法
    private String field0131; // 资产类型
    private String field0133; // 资产分类代码
    private String field0134; // 归属科室
    private String field0145; // 存放地点隐藏
    private String field0150; // 存放地点
    private BigDecimal field0151; // 期初累计
    private String field0153; // 归属单位
    private String field0154; // 发票号
    private String field0155; // 合同编号
    private BigDecimal field0156; // 预计使用年限
    private String field0158; // 经费来源
    private String field0159; // 财政名称
    private String field0160; // 品牌
    private String field0161; // 生产厂家
    private BigDecimal field0166; // 价值类型
    private BigDecimal field0167; // 采购组织形式
    private BigDecimal field0168; // 财务入账状态
    private Date field0169; // 记账日期
    private String field0170; // 记账凭证号
    private BigDecimal field0171; // 资产用途
    private String field0172; // 经费来源-文本
    private Long formmainId; // 关联主表的ID
}