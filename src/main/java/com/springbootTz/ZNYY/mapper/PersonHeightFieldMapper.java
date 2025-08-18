package com.springbootTz.ZNYY.mapper;

import com.springbootTz.ZNYY.entity.PostgresPersonDetailCustom;
import com.springbootTz.ZNYY.entity.OraclePersonHeigth;
import com.springbootTz.ZNYY.entity.PostgresPerson;
import com.springbootTz.ZNYY.tool.DepartmentQueryTool;
import com.springbootTz.ZNYY.tool.OrgCodeConcatTool;
import com.springbootTz.ZNYY.tool.OrgCodeQueryTool;
import com.springbootTz.ZNYY.tool.JsonKeyValueTool;
import com.springbootTz.ZNYY.tool.FieldSetterTool;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonDetailCustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class PersonHeightFieldMapper {
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
            put("CRTE_TIME", toSafeString(p -> p.getCreateTime() == null ? " " : p.getCreateTime().toString()));
            put("UPDT_TIME", toSafeString(p -> p.getModifyTime() == null ? " " : p.getModifyTime().toString()));
            put("DELETED", toSafeString(p -> {
                Integer delFlag = p.getDelFlag();
                return (delFlag != null && delFlag == 1) ? "0" : "1";
            }));
            put("DELETED_TIME", toSafeString(p -> " "));
            put("HEIGTH_TYPE_CODE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_U70xmuEa");
                return v == null ? " " : v;
            }));
            put("HEIGTH_TYPE_NAME", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_U70xmuEa");
                return v == null ? " " : v;
            }));
            put("HEIGTH_NAME", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_7DlbEz1i");
                return v == null ? " " : v;
            }));
            put("HEIGTH_TIME", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_s165rnZo");
                return v == null ? LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : v;
            }));
            put("HEIGTH_DEMO", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_Jduog8eJ");
                return v == null ? " " : v;
            }));
            put("DEPT_CODE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_UdICIK1o");
                return v == null ? " " : v;
            }));
            put("DEPT_NAME", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_UdICIK1o");
                return v == null ? " " : v;
            }));
        }
    };

    /**
     * 反射设置OraclePersonHeigth属性（字段名需与OraclePersonHeigth属性一致，支持下划线转驼峰）
     */
    public void setOracleField(OraclePersonHeigth oracleHeight, String field, String value) {
        FieldSetterTool.setField(oracleHeight, field, value);
    }
}
