package com.springbootTz.ZNYY.mapper;

import com.springbootTz.ZNYY.entity.*;
import com.springbootTz.ZNYY.tool.*;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonDetailCustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;

/**
 * 5. PersonHeightAward - 高层次人才科技奖励信息
 * 数据说明：高层次人才获得的科技奖励信息
 * PostgreSQL表：ehr_org_person_detail_custom (detail_id =
 * "person_detail_iMSAH8eL")
 * Oracle表：HUM_PSN_HEIGHT_AWARD
 * 同步方法：syncHeightAwardInfoAll()
 */
@Component
public class PersonHeightAward {
    private static final Logger logger = LoggerFactory.getLogger(PersonHeightAward.class);

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
            return v == null ? " " : v.toString();
        };
    }

    private static <T> Function<T, Date> toSafeDate(Function<T, ?> func) {
        return t -> {
            try {
                Object v = func.apply(t);
                if (v == null) {
                    return formatDate(new Date());
                }
                if (v instanceof Date) {
                    return formatDate((Date) v);
                }
                if (v instanceof String) {
                    String dateStr = ((String) v).trim();
                    if (dateStr.isEmpty()) {
                        return formatDate(new Date());
                    }
                    // 尝试解析日期
                    java.text.SimpleDateFormat[] possibleFormats = {
                            new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
                            new java.text.SimpleDateFormat("yyyy-MM-dd"),
                            new java.text.SimpleDateFormat("yyyy/MM/dd"),
                            new java.text.SimpleDateFormat("yyyyMMdd")
                    };

                    for (java.text.SimpleDateFormat format : possibleFormats) {
                        try {
                            return formatDate(format.parse(dateStr));
                        } catch (Exception e) {
                            continue;
                        }
                    }
                }
                return formatDate(new Date());
            } catch (Exception e) {
                return formatDate(new Date());
            }
        };
    }

    private static Date formatDate(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            return sdf.parse(sdf.format(date));
        } catch (Exception e) {
            return date;
        }
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
     * Oracle字段名 -> 映射逻辑（输入PostgresPersonDetailCustom，输出String或Date）
     */
    public final Map<String, Function<PostgresPersonDetailCustom, ?>> FIELD_MAPPING = new LinkedHashMap<String, Function<PostgresPersonDetailCustom, ?>>() {
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
            put("UPLOAD_TIME", toSafeDate(p -> new Date()));
            put("SYS_PRDR_CODE", toSafeString(p -> SYS_PRDR_CODE));
            put("SYS_PRDR_NAME", toSafeString(p -> SYS_PRDR_NAME));
            put("DATA_CLCT_PRDR_NAME", toSafeString(p -> DATA_CLCT_PRDR_NAME));
            put("ORIGINAL_ID", toSafeString(p -> p.getId() == null ? " " : p.getId()));
            put("STAFF_ID", toSafeString(p -> p.getPersonId() == null ? " " : p.getPersonId()));
            put("SCIENCE_AWARDS_GRADE_CODE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_zK4fDuka");
                return v == null ? " " : v;
            }));
            put("SCIENCE_AWARDS_GRADE_NAME", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_zK4fDuka");
                return v == null ? " " : v;
            }));
            put("AWARDS_NO", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_QOS86mNK");
                return v == null ? " " : v;
            }));
            put("AWARDS_NAME", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_AXbCipcU");
                return v == null ? " " : v;
            }));
            put("AWARDS_TIME", toSafeDate(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_I7Uku5w7");
                if (v == null || v.trim().isEmpty())
                    return new Date();
                try {
                    // 尝试解析日期
                    java.text.SimpleDateFormat[] possibleFormats = {
                            new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
                            new java.text.SimpleDateFormat("yyyy-MM-dd"),
                            new java.text.SimpleDateFormat("yyyy/MM/dd"),
                            new java.text.SimpleDateFormat("yyyyMMdd")
                    };

                    Date date = null;
                    for (java.text.SimpleDateFormat format : possibleFormats) {
                        try {
                            date = format.parse(v.trim());
                            break;
                        } catch (Exception e) {
                            continue;
                        }
                    }

                    return date == null ? new Date() : date;
                } catch (Exception e) {
                    logger.warn("处理AWARDS_TIME日期值时出错: {}, 错误: {}", v, e.getMessage());
                    return new Date();
                }
            }));
            put("AWARDS_UNIT", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_SujORd4G");
                return v == null ? " " : v;
            }));
            put("MEMBER_SORT", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_AVmXFSOP");
                if (v == null || v.trim().isEmpty())
                    return "0";
                try {
                    return Long.parseLong(v.trim());
                } catch (NumberFormatException e) {
                    return "0";
                }
            }));
            put("AWARDS_DEMO", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_O7cDBWG7");
                return v == null ? " " : v;
            }));
            put("STAFF_NO", toSafeString(p -> {
                PostgresPerson person = postgresPersonMapper.selectById(p.getPersonId());
                return person == null ? " " : person.getNumber();
            }));
            put("STAFF_NAME", toSafeString(p -> {
                PostgresPerson person = postgresPersonMapper.selectById(p.getPersonId());
                return person == null ? " " : person.getName();
            }));
            put("DEPT_CODE", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_jyBN4wl3");
                return v == null ? " " : v;
            }));
            put("DEPT_NAME", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_jyBN4wl3");
                return v == null ? " " : v;
            }));
            put("CRTE_TIME", toSafeString(p -> "2025-06-30 00:00:00"));
            put("UPDT_TIME", toSafeDate(p -> {
                if (p.getModifyTime() == null)
                    return new Date();
                return p.getModifyTime();
            }));
            put("DELETED", toSafeString(p -> {
                Integer delFlag = p.getDelFlag();
                return (delFlag != null && delFlag == 1) ? "0" : "1";
            }));
            put("DELETED_TIME", toSafeDate(p -> {
                String deleted = p.getDelFlag() != null && p.getDelFlag() == 1 ? "1" : "0";
                return "1".equals(deleted) ? new Date() : null;
            }));
        }
    };

    public void setOracleField(OraclePersonHeigthAward oracle, String field, Object value) {
        if (value instanceof Date) {
            FieldSetterTool.setField(oracle, field, value);
        } else {
            FieldSetterTool.setField(oracle, field, value == null ? " " : value.toString());
        }
    }
}
