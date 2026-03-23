package com.springbootTz.ZNYY.Humanresource.mapper.postgresql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.Humanresource.entity.PostgresPersonDetailEducationExperience;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Mapper接口：ehr_org_person_detail_education_experience
 */
@Mapper
public interface PostgresPersonDetailEducationExperienceMapper
                extends BaseMapper<PostgresPersonDetailEducationExperience> {
        @Select("SELECT * FROM ehr_org_person_detail_education_experience ORDER BY id DESC LIMIT 1")
        PostgresPersonDetailEducationExperience selectLastOne();

        /**
         * SELECT degree_type from ehr_org_person_detail_education_experience  WHERE person_id
         */
        @Select("SELECT degree_type FROM ehr_org_person_detail_education_experience WHERE person_id = #{personId} ORDER BY id DESC LIMIT 1")
        String selectDegreeTypeByPersonId(@Param("personId") String personId);
}