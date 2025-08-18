package com.springbootTz.ZNYY.Equipment.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 资产登记单-房屋土地与明细关联查询DTO
 */
@Data
public class AssetRegistrationHouseWithDetailDTO {

    // 主表信息
    private Long id; // 主表ID
    private String field0001; // 单据编号
    private String field0002; // 填报人
    private String field0003; // 所属科室
    private Date field0004; // 填报日期
    private String field0005; // 单位
    private String field0041; // 采购员确认
    private String field0047; // 本次登记实际采购员
    private String field0066; // 财务审核
    private String field0067; // 填报人-文本
    private String field0068; // 本次登记实际采购员-文本
    private Date startDate; // 开始日期

    // 明细表信息
    private Long detailId; // 明细表ID
    private String field0006; // 资产编号
    private String field0007; // 资产名称
    private String field0008; // 资产类型
    private String field0009; // 资产分类
    private String field0010; // 资产分类代码
    private String field0011; // 取得方式
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
    private BigDecimal field0042; // 数量面积
    private BigDecimal field0043; // 产权形式
    private BigDecimal field0044; // 权属性质
    private String field0045; // 权属证号
    private BigDecimal field0046; // 序号1
    private BigDecimal field0048; // 价值类型
    private BigDecimal field0049; // 采购组织形式
    private BigDecimal field0050; // 财务入账状态
    private Date field0051; // 记账日期
    private String field0052; // 记账凭证号
    private BigDecimal field0053; // 资产用途
    private String field0054; // 权属证明
    private String field0055; // 权属人
    private Date field0056; // 发证日期
    private Date field0057; // 竣工决算日期
    private String field0058; // 建筑结构
    private BigDecimal field0059; // 权属面积
    private BigDecimal field0060; // 占地面积
    private String field0061; // 坐落位置
    private BigDecimal field0062; // 办公用房
    private BigDecimal field0063; // 其中办公用房
    private BigDecimal field0064; // 业务用房
    private BigDecimal field0065; // 其他用房
    private BigDecimal field0069; // 预计使用月数
    private String field0070; // 经费来源-文本
    private Long formmainId; // 关联主表的ID
}