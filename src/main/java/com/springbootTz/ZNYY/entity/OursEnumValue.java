package com.springbootTz.ZNYY.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

// 表名与数据库表一致
@TableName("ours_enum_value")
@Data // Lombok 注解，自动生成 getter/setter
public class OursEnumValue {
    // 主键字段：对应 SQL 中的 id（注意字段类型与数据库一致，若为字符串用 String）
    @TableId
    private String id;

    // 目标查询字段：对应 SQL 中的 display
    private String display;

    // 添加code字段
    private String code;

    // 添加enum_id字段
    private String enumId;
}