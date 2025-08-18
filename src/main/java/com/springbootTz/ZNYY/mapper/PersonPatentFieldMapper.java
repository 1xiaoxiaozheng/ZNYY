package com.springbootTz.ZNYY.mapper;

import com.springbootTz.ZNYY.entity.PostgresPerson;
import com.springbootTz.ZNYY.entity.PostgresPersonDetailCustom;
import com.springbootTz.ZNYY.entity.OraclePersonPatent;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonDetailCustomMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonMapper;
import com.springbootTz.ZNYY.tool.DepartmentQueryTool;
import com.springbootTz.ZNYY.tool.JsonKeyValueTool;
import com.springbootTz.ZNYY.tool.OrgCodeConcatTool;
import com.springbootTz.ZNYY.tool.OrgCodeQueryTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class PersonPatentFieldMapper {
    @Autowired
    private JsonKeyValueTool jsonKeyValueTool;
    @Autowired
    private DepartmentQueryTool departmentQueryTool;
    @Autowired
    private OrgCodeQueryTool orgCodeQueryTool;
    @Autowired
    private OrgCodeConcatTool orgCodeConcatTool;
    @Autowired
    private PostgresPersonMapper postgresPersonMapper;
    @Autowired
    private PostgresPersonDetailCustomMapper postgresPersonDetailCustomMapper;

    private static final String SYS_PRDR_CODE = "FJZZZYKJYXGS";
    private static final String SYS_PRDR_NAME = "福建众智政友科技有限公司";
    private static final String DATA_CLCT_PRDR_NAME = "福建众智政友科技有限公司";

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

    private static <T> Function<T, String> toSafeString(Function<T, ?> func) {
        return t -> {
            Object v = func.apply(t);
            return v == null ? "" : v.toString();
        };
    }

    public final Map<String, Function<PostgresPersonDetailCustom, String>> FIELD_MAPPING = new HashMap<String, Function<PostgresPersonDetailCustom, String>>() {
        {
            put("RID", toSafeString(p -> {
                String orgName = getOrgNameByPersonId(p.getPersonId());
                if (orgName == null || orgName.isEmpty()) {
                    return " ";
                }
                String result = orgCodeConcatTool.concatCodeAndParams(orgName, SYS_PRDR_CODE, p.getId());
                return result == null || result.isEmpty() ? " " : result;
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
            put("UPLOAD_TIME", toSafeString(p -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
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

            put("PATENT_NO",
                    toSafeString(p -> {
                        String value = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_5d4Z1ya6");
                        return value == null ? " " : value;
                    }));
            put("PATENT_NAME",
                    toSafeString(p -> {
                        String value = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_1usMcNg5");
                        return value == null ? " " : value;
                    }));
            put("PATENT_OWNER",
                    toSafeString(p -> {
                        String value = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_j1jOhHTs");
                        return value == null ? " " : value;
                    }));
            put("PATENT_COUNTRY",
                    toSafeString(p -> {
                        String value = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_rUwvap3U");
                        return value == null ? " " : value;
                    }));
            put("GRANT_DATE",
                    toSafeString(p -> {
                        String value = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_LOMpR2rG");
                        return value == null ? new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                                : value;
                    }));
            put("PATENT_PROFIT",
                    toSafeString(p -> {
                        String value = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_mKx7OpkU");
                        return value == null ? " " : value;
                    }));
            put("GRANT_TYPE_CODE",
                    toSafeString(p -> {
                        String value = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_K6se4wHn");
                        return value == null ? " " : value;
                    }));
            put("GRANT_TYPE_NAME",
                    toSafeString(p -> {
                        String value = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_K6se4wHn");
                        return value == null ? " " : value;
                    }));
            put("PATENT_ROLE_CODE",
                    toSafeString(p -> {
                        String value = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_eFCWIVT3");
                        return value == null ? " " : value;
                    }));
            put("PATENT_ROLE_NAME",
                    toSafeString(p -> {
                        String value = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_eFCWIVT3");
                        return value == null ? " " : value;
                    }));

            put("DATA_CLCT_PRDR_NAME", toSafeString(p -> DATA_CLCT_PRDR_NAME));
            put("CRTE_TIME", toSafeString(p -> {
                Date createTime = p.getCreateTime();
                return createTime == null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                        : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime);
            }));
            put("UPDT_TIME", toSafeString(p -> {
                Date modifyTime = p.getModifyTime();
                return modifyTime == null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                        : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(modifyTime);
            }));
            put("DELETED", toSafeString(p -> p.getDelFlag() == 1 ? "0" : "1"));
            put("DELETED_TIME", p -> {
                // 如果记录已删除（delFlag != 1），使用当前时间
                // 否则使用当前时间作为默认值，确保不会返回null
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            });
        }
    };

    public void setOracleField(OraclePersonPatent oracle, String fieldName, String value) {
        try {
            // 将数据库字段名转换为Java字段名
            String javaFieldName = convertToJavaFieldName(fieldName);
            java.lang.reflect.Field field = OraclePersonPatent.class.getDeclaredField(javaFieldName);
            field.setAccessible(true);

            // 如果值为null或空字符串
            if (value == null || value.trim().isEmpty()) {
                if (field.getType() == Date.class) {
                    field.set(oracle, new Date()); // 日期类型使用当前时间
                } else if (field.getType() == String.class) {
                    field.set(oracle, " "); // 字符串类型使用空格
                } else {
                    field.set(oracle, null); // 其他类型使用null
                }
                return;
            }

            // 处理非空值
            if (field.getType() == Date.class) {
                try {
                    field.set(oracle, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value));
                } catch (Exception e) {
                    field.set(oracle, new Date()); // 如果解析失败，使用当前时间
                }
            } else if (field.getType() == String.class) {
                // 确保字符串值不超过Oracle VARCHAR2(255)的限制
                if (value.length() > 255) {
                    value = value.substring(0, 255);
                }
                field.set(oracle, value);
            } else {
                field.set(oracle, value);
            }
        } catch (Exception e) {
            System.err.println("设置字段 " + fieldName + " 时出错，值为: " + value);
            e.printStackTrace();
        }
    }

    // 将数据库字段名转换为Java字段名
    private String convertToJavaFieldName(String dbFieldName) {
        // 特殊处理一些字段
        switch (dbFieldName) {
            case "RID":
                return "rid";
            case "ORG_NAME":
                return "orgName";
            case "USCID":
                return "uscid";
            case "UPLOAD_TIME":
                return "uploadTime";
            case "SYS_PRDR_CODE":
                return "sysPrdrCode";
            case "SYS_PRDR_NAME":
                return "sysPrdrName";
            case "ORIGINAL_ID":
                return "originalId";
            case "STAFF_ID":
                return "staffId";
            case "STAFF_NO":
                return "staffNo";
            case "STAFF_NAME":
                return "staffName";
            case "PATENT_NO":
                return "patentNo";
            case "PATENT_NAME":
                return "patentName";
            case "PATENT_OWNER":
                return "patentOwner";
            case "PATENT_COUNTRY":
                return "patentCountry";
            case "GRANT_DATE":
                return "grantDate";
            case "PATENT_PROFIT":
                return "patentProfit";
            case "GRANT_TYPE_CODE":
                return "grantTypeCode";
            case "GRANT_TYPE_NAME":
                return "grantTypeName";
            case "PATENT_ROLE_CODE":
                return "patentRoleCode";
            case "PATENT_ROLE_NAME":
                return "patentRoleName";
            case "DATA_CLCT_PRDR_NAME":
                return "dataClctPrdrName";
            case "CRTE_TIME":
                return "crteTime";
            case "UPDT_TIME":
                return "updtTime";
            case "DELETED":
                return "deleted";
            case "DELETED_TIME":
                return "deletedTime";
            default:
                return dbFieldName.toLowerCase();
        }
    }
}
