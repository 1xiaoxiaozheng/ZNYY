package com.springbootTz.ZNYY.mapper.postgresql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.entity.PostgresPerson;
import org.apache.ibatis.annotations.Mapper;

/**
 * PostgreSQL ehr_org_person表对应的Mapper接口
 * 支持基本CRUD和扩展查询
 */
@Mapper
public interface PostgresPersonMapper extends BaseMapper<PostgresPerson> {
    // 可在此添加自定义SQL方法
}