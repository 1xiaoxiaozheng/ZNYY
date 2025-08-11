package com.springbootTz.ZNYY.mapper;

import com.springbootTz.ZNYY.entity.PostgresPersonDetailCustom;
import com.springbootTz.ZNYY.entity.PostgresPerson;
import com.springbootTz.ZNYY.tool.DepartmentQueryTool;
import com.springbootTz.ZNYY.tool.OrgCodeConcatTool;
import com.springbootTz.ZNYY.tool.OrgCodeQueryTool;
import com.springbootTz.ZNYY.tool.JsonKeyValueTool;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonDetailCustomMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.springbootTz.ZNYY.entity.OraclePersonResearch;
import com.springbootTz.ZNYY.tool.EnumValueQueryTool;

@Component
public class PersonResearchMapper {
    private static final Logger logger = LoggerFactory.getLogger(PersonResearchMapper.class);

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

    private static final String SYS_PRDR_CODE = "FJZZZYKJGS";
    private static final String SYS_PRDR_NAME = "福建众智政友科技公司";
    private static final String DATA_CLCT_PRDR_NAME = "福建众智政友科技公司";

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
            put("CRTE_TIME", toSafeString(p -> p.getCreateTime() == null ? " " : p.getCreateTime().toString()));
            put("UPDT_TIME", toSafeString(p -> p.getModifyTime() == null ? " " : p.getModifyTime().toString()));
            put("DELETED", toSafeString(p -> {
                Integer delFlag = p.getDelFlag();
                return (delFlag != null && delFlag == 1) ? "0" : "1";
            }));
            put("DELETED_TIME", toSafeString(p -> " "));
            put("TOPIC_CODE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_tvaG7rie");
                return v == null ? " " : v;
            }));
            put("TOPIC_NAME", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_tvaG7rie");
                return v == null ? " " : v;
            }));
            put("PROJECT_YEAR", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_BZZmnwUi");
                return v == null ? " " : v;
            }));
            put("RESEARCH_BEGNDATE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_5124lcvi");
                return v == null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) : v;
            }));
            put("FINISH_DATE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_VU9tCjTL");
                return v == null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) : v;
            }));
            put("RESEARCH_FEE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_uCCcJb5p");
                return v == null ? " " : v;
            }));
            put("RESEARCH_LEV_CODE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_zyNAxAXo");
                return v == null ? " " : v;
            }));
            put("RESEARCH_LEV_NAME", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_zyNAxAXo");
                return v == null ? " " : v;
            }));
            put("RESEARCH_ROLE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_Utir03Hd");
                return v == null ? " " : v;
            }));
        }
    };

    public void setOracleField(OraclePersonResearch oracle, String fieldName, String fieldValue) {
        try {
            String javaFieldName = underlineToCamel(fieldName); // 新增：字段名转换
            Field field = OraclePersonResearch.class.getDeclaredField(javaFieldName);
            field.setAccessible(true);
            if (field.getType() == Date.class && fieldValue != null && !fieldValue.trim().isEmpty()
                    && !" ".equals(fieldValue.trim())) {
                field.set(oracle, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fieldValue));
            } else if (field.getType() == BigDecimal.class && fieldValue != null
                    && !fieldValue.trim().isEmpty() && !" ".equals(fieldValue.trim())) {
                field.set(oracle, new BigDecimal(fieldValue));
            } else {
                field.set(oracle, fieldValue);
            }
        } catch (Exception e) {
            logger.error("字段设置失败: {} - {}", fieldName, e.getMessage());
        }
    }

    public static String underlineToCamel(String name) {
        StringBuilder result = new StringBuilder();
        boolean nextUpper = false;
        for (char c : name.toCharArray()) {
            if (c == '_') {
                nextUpper = true;
            } else {
                result.append(nextUpper ? Character.toUpperCase(c) : Character.toLowerCase(c));
                nextUpper = false;
            }
        }
        return result.toString();
    }
}
