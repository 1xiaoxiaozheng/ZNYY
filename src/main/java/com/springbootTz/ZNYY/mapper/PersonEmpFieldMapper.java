package com.springbootTz.ZNYY.mapper;

import com.springbootTz.ZNYY.entity.*;
import com.springbootTz.ZNYY.service.OursEnumValueService;
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
 * 4. PersonEmpFieldMapper - 人员岗位聘任信息
 *
 * 数据说明：人员的岗位聘任记录，包括聘任岗位、聘任时间等
 * PostgreSQL表：ehr_org_person_detail_work_experience
 * Oracle表：HUM_PSN_EMP_TYPE
 * 同步方法：syncEmpTypeInfoAll()
 *
 * 要修改成新势力的聘任信息表,需要更改对应的postgresql的表为ehr_org_person
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

    @Autowired
    private EnumValueQueryTool enumValueQueryTool;

    @Autowired
    private OursEnumValueService oursEnumValueService;

    // 直接定义常量，避免配置文件中文乱码
    private static final String SYS_PRDR_CODE = "FJZZZYKJYXGS";
    private static final String SYS_PRDR_NAME = "福建众智政友科技有限公司";
    private static final String DATA_CLCT_PRDR_NAME = "福建众智政友科技有限公司";

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

    public final Map<String, Function<PostgresPersonDetailCustom, String>> FIELD_MAPPING = new LinkedHashMap<String, Function<PostgresPersonDetailCustom, String>>() {
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
            put("CRTE_TIME", toSafeString(p -> "2025-06-30 00:00:00"));
            put("UPDT_TIME", toSafeString(p -> p.getModifyTime() == null ? " " : p.getModifyTime().toString()));
            put("DELETED", toSafeString(p -> {
                // 根据delFlag判断：1正常则DELETED为0，其他情况DELETED为1
                Integer delFlag = p.getDelFlag();
                return (delFlag != null && delFlag == 1) ? "0" : "1";
            }));
            put("DELETED_TIME", toSafeString(p -> " "));
            put("DATA_CLCT_PRDR_NAME", toSafeString(p -> DATA_CLCT_PRDR_NAME));
            put("FIRST_EMP_START_DATE", toSafeString(p -> {
                String firstEmpStartDate = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_oeHnCJMI");
                return firstEmpStartDate == null ? " " : firstEmpStartDate;
            }));
            put("APPOINT_LEVEL_CODE", toSafeString(p -> {
               String appointLevelCode = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_1H50BR2W");
               return appointLevelCode == null ? " " : appointLevelCode;
            }));
            put("APPOINT_LEVEL_NAME", toSafeString(p -> {
                String appointLevelName = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_1H50BR2W");
                return appointLevelName == null ? " " :oursEnumValueService.getDisplayById(appointLevelName);
            }));
            put("JOB_DESC", toSafeString(p -> {
                String jobDesc = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_Ahbu58hq");
                return jobDesc == null ? " " : oursEnumValueService.getDisplayById(jobDesc);
            }));
            put("EMP_START_DATE", toSafeString(p -> {
                     String empStartDate   =  jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_oeHnCJMI");
                        return empStartDate == null ? " " : empStartDate;
                            }
            ));
            put("EMP_END_DATE", toSafeString(p ->{
                        String empEndDate = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_SqvXuxOU");
                        return empEndDate == null ? " " : empEndDate;
                    }
            ));
            put("TECH_JOB_TITLE_CODE", toSafeString(p ->
            {
                String techJobTitleCode = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_gd4dwPAf");
                return techJobTitleCode == null ? " " : techJobTitleCode;
            }));
            put("TECH_JOB_TITLE_NAME", toSafeString(p ->
            {
                String techJobTitleName = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_gd4dwPAf");
                return techJobTitleName == null ? " " :oursEnumValueService.getDisplayById(techJobTitleName);
            }));
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
