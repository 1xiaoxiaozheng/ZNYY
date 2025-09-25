package com.springbootTz.ZNYY.mapper;

import com.springbootTz.ZNYY.entity.PostgresPersonDetailCustom;
import com.springbootTz.ZNYY.entity.PostgresPerson;
import com.springbootTz.ZNYY.entity.OraclePersonProf;
import com.springbootTz.ZNYY.tool.*;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonDetailCustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.lang.reflect.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 9. PersonPsnProfFieldMapper - 人员专业技术资格信息
 * 数据说明：人员的专业技术资格认证信息，包括资格名称、获得时间等
 * PostgreSQL表：ehr_org_person_detail_custom (detail_id =
 * "person_detail_kX9wywgy")
 * Oracle表：HUM_PSN_PROF
 * 同步方法：syncTechInfoAll()
 */
@Component
public class PersonPsnProfFieldMapper {
    private static final Logger logger = LoggerFactory.getLogger(PersonPsnProfFieldMapper.class);

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
    private PostgresPersonDetailCustomMapper postgresPersonDetailCustomMapper;
    @Autowired
    private EnumValueQueryTool enumValueQueryTool;

    private static final String SYS_PRDR_CODE = "FJZZZYKJYXGS";
    private static final String SYS_PRDR_NAME = "福建众智政友科技有限公司";
    private static final String DATA_CLCT_PRDR_NAME = "福建众智政友科技有限公司";

    private static <T> Function<T, String> toSafeString(Function<T, ?> func) {
        return t -> {
            Object v = func.apply(t);
            return v == null ? "" : v.toString();
        };
    }

    private String getOrgNameByPersonId(String personId) {
        if (personId == null || personId.isEmpty())
            return null;
        PostgresPerson person = postgresPersonMapper.selectById(personId);
        if (person == null)
            return null;
        String deptId = person.getDeptId();
        if (deptId == null || deptId.isEmpty())
            return null;
        return departmentQueryTool.getOrgNameByDeptId(deptId);
    }

    /**
     * Oracle字段名 -> 映射逻辑（输入PostgresPersonDetailCustom，输出String）
     */
    public final Map<String, Function<PostgresPersonDetailCustom, String>> FIELD_MAPPING = new LinkedHashMap<String, Function<PostgresPersonDetailCustom, String>>() {
        {
            put("RID", toSafeString(p -> {
                String orgName = getOrgNameByPersonId(p.getPersonId());
                if (orgName == null || orgName.isEmpty())
                    return " ";
                return orgCodeConcatTool.concatCodeAndParams(orgName, SYS_PRDR_CODE, p.getId());
            }));
            put("ORG_NAME", toSafeString(p -> {
                String orgName = getOrgNameByPersonId(p.getPersonId());
                return orgName == null ? " " : orgName;
            }));
            put("USCID", toSafeString(p -> {
                String orgName = getOrgNameByPersonId(p.getPersonId());
                if (orgName == null || orgName.isEmpty())
                    return " ";
                String uscid = orgCodeQueryTool.getCodeByDisplay(orgName);
                return uscid == null ? " " : uscid;
            }));
            put("UPLOAD_TIME",
                    toSafeString(p -> new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
            put("SYS_PRDR_CODE", toSafeString(p -> SYS_PRDR_CODE));
            put("SYS_PRDR_NAME", toSafeString(p -> SYS_PRDR_NAME));
            put("DATA_CLCT_PRDR_NAME", toSafeString(p -> DATA_CLCT_PRDR_NAME));
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
                Integer delFlag = p.getDelFlag();
                return (delFlag != null && delFlag == 1) ? "0" : "1";
            }));
            put("DELETED_TIME", toSafeString(p -> " "));
            put("PROFTECHTTL_CERTIFICATE_NO", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_GFWRWZIK");
                return v == null ? " " : v;
            }));
            put("PROFTECHTTL_CERTIFICATE_CODE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_8kWse64O");
                return v == null ? " " : v;
            }));
            put("PROFTECHTTL_CERTIFICATE_NAME", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_8kWse64O");
                return v == null ? " " : v;
            }));

            put("MAJOR_CODE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_E3lUuJ5q");
                return v == null ? " " : v;
            }));
            put("MAJOR_NAME", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_E3lUuJ5q");
                return v == null ? " " : v;
            }));

            put("SKILL_GRADE_CODE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_nV1qvUMb");
                return v == null ? " " : v;
            }));
            put("SKILL_GRADE_NAME", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_xp9DuAvb");
                return v == null ? " " : enumValueQueryTool.getDisplayByEnumNameAndValue("职称级别", Long.parseLong(v));
            }));

            put("GET_DATE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_JaN9bnJf");
                return v == null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) : v;
            }));
            put("EXPYSTARTTIME", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_c5zbuL20");
                return v == null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) : v;
            }));
            put("CERTIFICATE_MECHANISM", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_akmmGFLC");
                return v == null ? " " : v;
            }));
            put("EXCH_CERTIFICATE_SN", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_1m7qNAon");
                return v == null ? " " : v;
            }));

        }
    };

    private static final Map<String, String> FIELD_NAME_MAPPING = new HashMap<String, String>() {
        {
            put("EXPYSTARTTIME", "expyStartTime");
            put("MAJOR_CODE", "majorCode");
            put("MAJOR_NAME", "majorName");
            put("SKILL_GRADE_CODE", "skillGradeCode");
            put("SKILL_GRADE_NAME", "skillGradeName");
            put("GET_DATE", "getDate");
            put("CERTIFICATE_MECHANISM", "certificateMechanism");
            put("EXCH_CERTIFICATE_SN", "exchCertificateSn");
            put("PROFTECHTTL_CERTIFICATE_NO", "proftechttlCertificateNo");
            put("PROFTECHTTL_CERTIFICATE_CODE", "proftechttlCertificateCode");
            put("PROFTECHTTL_CERTIFICATE_NAME", "proftechttlCertificateName");
        }
    };

    public void setOracleField(OraclePersonProf oracle, String fieldName, String fieldValue) {
        String javaFieldName = null;
        try {
            // 获取Java字段名
            javaFieldName = FIELD_NAME_MAPPING.containsKey(fieldName)
                    ? FIELD_NAME_MAPPING.get(fieldName)
                    : convertToJavaFieldName(fieldName);

            logger.debug("设置字段: {} -> {}", fieldName, javaFieldName);

            // 获取字段
            Field field = null;
            try {
                field = OraclePersonProf.class.getDeclaredField(javaFieldName);
            } catch (NoSuchFieldException e) {
                logger.error("找不到字段: {} (Java名称: {})", fieldName, javaFieldName);
                return;
            }

            field.setAccessible(true);

            // 处理空值
            if (fieldValue == null || fieldValue.trim().isEmpty()) {
                if (field.getType() == Date.class) {
                    field.set(oracle, new Date());
                } else if (field.getType() == String.class) {
                    field.set(oracle, " ");
                } else {
                    field.set(oracle, null);
                }
                return;
            }

            // 处理非空值
            if (field.getType() == Date.class) {
                try {
                    field.set(oracle, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fieldValue.trim()));
                } catch (Exception e) {
                    field.set(oracle, new Date());
                    logger.warn("日期解析失败，使用当前时间。字段: {}, 值: [{}]", fieldName, fieldValue);
                }
            } else if (field.getType() == String.class) {
                if (fieldValue.length() > 255) {
                    fieldValue = fieldValue.substring(0, 255);
                }
                field.set(oracle, fieldValue);
            } else {
                field.set(oracle, fieldValue);
            }
        } catch (Exception e) {
            logger.error("字段设置失败: {} -> {} ({})", fieldName, javaFieldName, e.getMessage());
        }
    }

    private String convertToJavaFieldName(String dbFieldName) {
        if (dbFieldName == null || dbFieldName.isEmpty()) {
            return dbFieldName;
        }

        // 如果字段名包含下划线，按下划线分割处理
        if (dbFieldName.contains("_")) {
            String[] parts = dbFieldName.toLowerCase().split("_");
            StringBuilder result = new StringBuilder(parts[0]);
            for (int i = 1; i < parts.length; i++) {
                if (parts[i].length() > 0) {
                    result.append(Character.toUpperCase(parts[i].charAt(0)))
                            .append(parts[i].substring(1).toLowerCase());
                }
            }
            return result.toString();
        }

        // 处理不包含下划线的字段名（如EXPYSTARTTIME）
        // 1. 转换为小写
        String lowerCase = dbFieldName.toLowerCase();

        // 2. 找出原字段名中的大写字母位置
        List<Integer> upperCasePositions = new ArrayList<>();
        char[] originalChars = dbFieldName.toCharArray();
        for (int i = 1; i < originalChars.length; i++) {
            if (Character.isUpperCase(originalChars[i]) &&
                    !Character.isUpperCase(originalChars[i - 1])) {
                upperCasePositions.add(i);
            }
        }

        // 3. 在这些位置的字符转为大写
        StringBuilder result = new StringBuilder(lowerCase);
        for (int pos : upperCasePositions) {
            if (pos < result.length()) {
                result.setCharAt(pos, Character.toUpperCase(result.charAt(pos)));
            }
        }

        return result.toString();
    }
}
