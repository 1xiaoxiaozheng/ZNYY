package com.springbootTz.ZNYY.mapper;

import com.springbootTz.ZNYY.entity.OraclePerson;
import com.springbootTz.ZNYY.entity.OraclePersonEmpType;
import com.springbootTz.ZNYY.entity.PostgresPersonDetailWorkExperience;
import com.springbootTz.ZNYY.entity.PostgresPerson;
import com.springbootTz.ZNYY.tool.*;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonDetailWorkExperienceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 用于OraclePersonEmpType与PostgresPersonDetailWorkExperience字段映射的工具类
 * hum_psn_emp_tpye表接收PostgresPersonDetailWorkExperience的字段映射
 */
@Component
public class PersonEmpFieldMapper {

    private static final Logger logger = LoggerFactory.getLogger(PersonEmpFieldMapper.class);

    @Autowired
    private DepartmentQueryTool departmentQueryTool;
    @Autowired
    private OrgCodeQueryTool orgCodeQueryTool;
    @Autowired
    private OrgCodeConcatTool orgCodeConcatTool;
    @Autowired
    private JsonKeyValueTool jsonKeyValueTool;
    @Autowired
    private PostgresPersonMapper postgresPersonMapper;
    @Autowired
    private PostgresPersonDetailWorkExperienceMapper postgresPersonDetailWorkExperienceMapper;

    // 直接定义常量，避免配置文件中文乱码
    private static final String SYS_PRDR_CODE = "FJZZZYKJGS";
    private static final String SYS_PRDR_NAME = "福建众智政友科技公司";
    private static final String DATA_CLCT_PRDR_NAME = "福建众智政友科技公司";

    private static <T> Function<T, String> toSafeString(Function<T, ?> func) {
        return t -> {
            Object v = func.apply(t);
            return v == null ? "" : v.toString();
        };
    }

    // 自定义：通过personId查orgName（通过PostgresPerson查deptId再查orgName）
    private String getOrgNameByPersonId(String personId) {
        if (personId == null || personId.isEmpty()) {
            return null;
        }
        PostgresPerson person = postgresPersonMapper.selectById(personId);
        if (person == null) {
            return null;
        }
        String deptId = person.getDeptId();
        if (deptId == null || deptId.isEmpty()) {
            return null;
        }
        return departmentQueryTool.getOrgNameByDeptId(deptId);
    }

    /**
     * Oracle字段名 -> 映射逻辑（输入PostgresPersonDetailWorkExperience，输出String）
     * 对应关系如下（格式：Oracle字段名 → Postgres数据来源）：
     *
     * 基础关联字段： RID → 根据personId查询机构名称，再通过orgCodeConcatTool生成（格式：机构代码+厂商代码+记录ID）
     * ORG_NAME → 根据personId查询机构名称 USCID → 根据机构名称查询对应的统一社会信用代码
     *
     * 系统固定值： UPLOAD_TIME → 当前系统时间（格式：yyyy-MM-dd HH:mm:ss） SYS_PRDR_CODE →
     * 固定值"1" SYS_PRDR_NAME → 固定值"福建众智政友科技公司" DATA_CLCT_PRDR_NAME →
     * 固定值"福建众智政友科技公司"
     *
     * 人员信息： ORIGINAL_ID → ehr_org_person_detail_work_experience表的id字段 STAFF_ID
     * → person_id字段 STAFF_NO → 关联PostgresPerson表的number字段 STAFF_NAME →
     * 关联PostgresPerson表的name字段
     *
     * 时间字段： CRTE_TIME → create_time字段 UPDT_TIME → modify_time字段 DELETED_TIME →
     * 空字符串
     *
     * 状态字段： DELETED → 根据del_flag判断：1正常则DELETED为0，其他情况为1
     *
     * 扩展字段： FIRST_EMP_START_DATE → 从customFields中提取person_vXaQxFNe的值
     * APPOINT_LEVEL_CODE → 关联PostgresPerson表的jobLevel字段 APPOINT_LEVEL_NAME →
     * 关联PostgresPerson表的jobGradeId字段 JOB_DESC → des字段 EMP_START_DATE →
     * startTime字段 EMP_END_DATE → endTime字段 TECH_JOB_TITLE_CODE → jobName字段
     * TECH_JOB_TITLE_NAME → jobName字段
     */
    public final Map<String, Function<PostgresPersonDetailWorkExperience, String>> FIELD_MAPPING = new LinkedHashMap<String, Function<PostgresPersonDetailWorkExperience, String>>() {
        {
            put("RID", toSafeString(p -> {
                String orgName = getOrgNameByPersonId(p.getPersonId());
                if (orgName == null || orgName.isEmpty()) {
                    return " ";
                }
                return orgCodeConcatTool.concatCodeAndParams(orgName, SYS_PRDR_CODE, p.getId());
            }));
            put("ORG_NAME", toSafeString(p -> {
                String orgName = getOrgNameByPersonId(p.getPersonId());
                return orgName == null ? " " : orgName;
            }));
            put("USCID", toSafeString(p -> {
                String orgName = getOrgNameByPersonId(p.getPersonId());
                if (orgName == null || orgName.isEmpty()) {
                    return " ";
                }
                String uscid = orgCodeQueryTool.getCodeByDisplay(orgName);
                return uscid == null ? " " : uscid;
            }));
            put("UPLOAD_TIME",
                    toSafeString(p -> new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
            put("SYS_PRDR_CODE", toSafeString(p -> SYS_PRDR_CODE));
            put("SYS_PRDR_NAME", toSafeString(p -> SYS_PRDR_NAME));
            put("ORIGINAL_ID", toSafeString(p -> p.getId() == null ? " " : p.getId()));
            put("STAFF_ID", toSafeString(p -> p.getPersonId() == null ? " " : p.getPersonId()));
            put("STAFF_NO", toSafeString(p -> {
                PostgresPerson person = postgresPersonMapper.selectById(p.getPersonId());
                return person == null ? " " : person.getNumber();
            }));
            put("STAFF_NAME", toSafeString(p -> {
                PostgresPerson person = postgresPersonMapper.selectById(p.getPersonId());
                return person == null ? " " : person.getName();
            }));
            put("CRTE_TIME", toSafeString(p -> p.getCreateTime() == null ? " " : p.getCreateTime().toString()));
            put("UPDT_TIME", toSafeString(p -> p.getModifyTime() == null ? " " : p.getModifyTime().toString()));
            put("DELETED", toSafeString(p -> {
                // 根据delFlag判断：1正常则DELETED为0，其他情况DELETED为1
                Integer delFlag = p.getDelFlag();
                return (delFlag != null && delFlag == 1) ? "0" : "1";
            }));
            put("DELETED_TIME", toSafeString(p -> " "));
            put("DATA_CLCT_PRDR_NAME", toSafeString(p -> DATA_CLCT_PRDR_NAME));
            put("FIRST_EMP_START_DATE", toSafeString(p -> {
                String firstEmpStartDate = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_vXaQxFNe");
                return firstEmpStartDate == null ? " " : firstEmpStartDate;
            }));
            put("APPOINT_LEVEL_CODE", toSafeString(p -> {
                PostgresPerson person = postgresPersonMapper.selectById(p.getPersonId());
                return person == null || person.getJobLevel() == null ? " " : person.getJobLevel();
            }));
            put("APPOINT_LEVEL_NAME", toSafeString(p -> {
                PostgresPerson person = postgresPersonMapper.selectById(p.getPersonId());
                return person == null || person.getJobGradeId() == null ? " " : person.getJobGradeId();
            }));
            put("JOB_DESC", toSafeString(p -> p.getDes() == null ? " " : p.getDes()));
            put("EMP_START_DATE", toSafeString(p -> p.getStartTime() == null ? " " : p.getStartTime()));
            put("EMP_END_DATE", toSafeString(p -> p.getEndTime() == null ? " " : p.getEndTime()));
            put("TECH_JOB_TITLE_CODE", toSafeString(p -> p.getJobName() == null ? " " : p.getJobName()));
            put("TECH_JOB_TITLE_NAME", toSafeString(p -> p.getJobName() == null ? " " : p.getJobName()));
        }
    };

    /**
     * 反射设置OraclePersonEmpType属性（字段名需与OraclePersonEmpType属性一致，支持下划线转驼峰）
     * String类型赋值为字符串，Date/BigDecimal类型空字符串赋null，日期自动识别格式
     */
    public void setOracleField(OraclePersonEmpType oraclePersonEmpType, String field, String value) {
        FieldSetterTool.setField(oraclePersonEmpType, field, value);
    }

    private String toCamelCase(String s) {
        StringBuilder sb = new StringBuilder();
        boolean upper = false;
        for (char c : s.toCharArray()) {
            if (c == '_') {
                upper = true;
            } else {
                sb.append(upper ? Character.toUpperCase(c) : Character.toLowerCase(c));
                upper = false;
            }
        }
        return sb.toString();
    }
}
