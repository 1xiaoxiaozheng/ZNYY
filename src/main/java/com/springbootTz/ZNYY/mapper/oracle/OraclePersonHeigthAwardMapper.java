package com.springbootTz.ZNYY.mapper.oracle;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootTz.ZNYY.entity.OraclePersonHeigthAward;
import org.apache.ibatis.annotations.*;

/**
 * Mapper接口：HUM_PSN_HEIGTH_AWARD
 */
@Mapper
public interface OraclePersonHeigthAwardMapper extends BaseMapper<OraclePersonHeigthAward> {

    @Select("SELECT * FROM \"HUM_PSN_HEIGTH_AWARD\" WHERE \"ORIGINAL_ID\" = #{originalId}")
    OraclePersonHeigthAward selectByOriginalId(@Param("originalId") String originalId);

    @Insert({ "INSERT INTO \"HUM_PSN_HEIGTH_AWARD\" (",
            "\"RID\", \"ORG_NAME\", \"USCID\", \"UPLOAD_TIME\", \"SYS_PRDR_CODE\", ",
            "\"SYS_PRDR_NAME\", \"DATA_CLCT_PRDR_NAME\", \"ORIGINAL_ID\", \"STAFF_ID\", ",
            "\"SCIENCE_AWARDS_GRADE_CODE\", \"SCIENCE_AWARDS_GRADE_NAME\", \"AWARDS_NO\", ",
            "\"AWARDS_NAME\", \"AWARDS_TIME\", \"AWARDS_UNIT\", \"MEMBER_SORT\", \"AWARDS_DEMO\", ",
            "\"STAFF_NO\", \"STAFF_NAME\", \"DEPT_CODE\", \"DEPT_NAME\", \"CRTE_TIME\", ",
            "\"UPDT_TIME\", \"DELETED\", \"DELETED_TIME\")",
            "VALUES (",
            "#{rid}, #{orgName}, #{uscid}, #{uploadTime}, #{sysPrdrCode}, ",
            "#{sysPrdrName}, #{dataClctPrdrName}, #{originalId}, #{staffId}, ",
            "#{scienceAwardsGradeCode}, #{scienceAwardsGradeName}, #{awardsNo}, ",
            "#{awardsName}, #{awardsTime}, #{awardsUnit}, #{memberSort}, #{awardsDemo}, ",
            "#{staffNo}, #{staffName}, #{deptCode}, #{deptName}, #{crteTime}, ",
            "#{updtTime}, #{deleted}, #{deletedTime})" })
    int insert(OraclePersonHeigthAward record);

    @Update({ "UPDATE \"HUM_PSN_HEIGTH_AWARD\" SET ",
            "\"ORG_NAME\" = #{orgName}, ",
            "\"USCID\" = #{uscid}, ",
            "\"UPLOAD_TIME\" = #{uploadTime}, ",
            "\"SYS_PRDR_CODE\" = #{sysPrdrCode}, ",
            "\"SYS_PRDR_NAME\" = #{sysPrdrName}, ",
            "\"DATA_CLCT_PRDR_NAME\" = #{dataClctPrdrName}, ",
            "\"STAFF_ID\" = #{staffId}, ",
            "\"SCIENCE_AWARDS_GRADE_CODE\" = #{scienceAwardsGradeCode}, ",
            "\"SCIENCE_AWARDS_GRADE_NAME\" = #{scienceAwardsGradeName}, ",
            "\"AWARDS_NO\" = #{awardsNo}, ",
            "\"AWARDS_NAME\" = #{awardsName}, ",
            "\"AWARDS_TIME\" = #{awardsTime}, ",
            "\"AWARDS_UNIT\" = #{awardsUnit}, ",
            "\"MEMBER_SORT\" = #{memberSort}, ",
            "\"AWARDS_DEMO\" = #{awardsDemo}, ",
            "\"STAFF_NO\" = #{staffNo}, ",
            "\"STAFF_NAME\" = #{staffName}, ",
            "\"DEPT_CODE\" = #{deptCode}, ",
            "\"DEPT_NAME\" = #{deptName}, ",
            "\"CRTE_TIME\" = #{crteTime}, ",
            "\"UPDT_TIME\" = #{updtTime}, ",
            "\"DELETED\" = #{deleted}, ",
            "\"DELETED_TIME\" = #{deletedTime} ",
            "WHERE \"ORIGINAL_ID\" = #{originalId}" })
    int updateByOriginalId(OraclePersonHeigthAward record);
}