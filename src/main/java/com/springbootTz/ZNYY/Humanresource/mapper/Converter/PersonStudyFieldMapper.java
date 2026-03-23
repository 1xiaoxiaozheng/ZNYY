package com.springbootTz.ZNYY.Humanresource.mapper.Converter;

import com.springbootTz.ZNYY.Humanresource.entity.PostgresPersonDetailTraining;
import com.springbootTz.ZNYY.Humanresource.entity.PostgresPerson;
import com.springbootTz.ZNYY.Humanresource.entity.OracleStaffStudy;
import com.springbootTz.ZNYY.Humanresource.tool.DepartmentQueryTool;
import com.springbootTz.ZNYY.Humanresource.tool.OrgCodeConcatTool;
import com.springbootTz.ZNYY.Humanresource.tool.OrgCodeQueryTool;
import com.springbootTz.ZNYY.Humanresource.tool.JsonKeyValueTool;
import com.springbootTz.ZNYY.Humanresource.tool.FieldSetterTool;
import com.springbootTz.ZNYY.Humanresource.mapper.postgresql.PostgresPersonMapper;
import com.springbootTz.ZNYY.Humanresource.mapper.postgresql.PostgresPersonDetailTrainingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 13. PersonStudyFieldMapper - 人员外出培训及学术活动信息
 * 数据说明：人员参加的外出培训和学术活动信息
 * PostgreSQL表：ehr_org_person_detail_training
 * Oracle表：HUM_STAFF_STUDY
 * 同步方法：syncOutInfoAll()
 */
@Component
public class PersonStudyFieldMapper {
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
    private PostgresPersonDetailTrainingMapper postgresPersonDetailTrainingMapper;

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
     * Oracle字段名 -> 映射逻辑（输入PostgresPersonDetailTraining，输出String）
     */
    public final Map<String, Function<PostgresPersonDetailTraining, String>> FIELD_MAPPING = new LinkedHashMap<String, Function<PostgresPersonDetailTraining, String>>() {
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
            put("ORIGINAL_ID", toSafeString(p -> p.getId() == null ? " " : p.getPersonId()));
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
            put("STUDY_TYPE_CODE", p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_q4BUYeeI");
                // 培训类型代码不能为空，如果为空返回"-"
                if (v == null || v.trim().isEmpty()) {
                    return "-";
                }
                return v.trim();
            });
            put("STUDY_TYPE_NAME", p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_q4BUYeeI");
                // 培训类型名称不能为空，如果为空返回"-"
                if (v == null || v.trim().isEmpty()) {
                    return "-";
                }
                return v.trim();
            });
            put("STUDY_EMPR_NAME", p -> {
                String v = p.getCompany();
                // 培训主办单位不能为空，如果为空返回"-"
                if (v == null || v.trim().isEmpty()) {
                    return "-";
                }
                return v.trim();
            });
            put("STUDY_ADDR", toSafeString(p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_6Hv4n1Xz");
                return v == null ? " " : v;
            }));
            put("STUDY_CERTIFICATE_NO", toSafeString(p -> p.getCertNo() == null ? " " : p.getCertNo()));
            put("STUDY_MAJOR", toSafeString(p -> p.getName() == null ? " " : p.getName()));
            put("BEGNDATE", p -> {
                // 开始日期不能为空，日期字段为空时返回默认无效日期
                if (p.getStartTime() == null) {
                    return "1900-01-01 00:00:00";
                }
                try {
                    // 使用 SimpleDateFormat 格式化 Timestamp
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    return sdf.format(p.getStartTime());
                } catch (Exception e) {
                    return "1900-01-01 00:00:00";
                }
            });
            put("ENDDATE", p -> {
                // 结束日期为空时返回默认无效日期
                if (p.getEndTime() == null) {
                    return "1900-01-01 00:00:00";
                }
                try {
                    // 使用 SimpleDateFormat 格式化 Timestamp
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    return sdf.format(p.getEndTime());
                } catch (Exception e) {
                    return "1900-01-01 00:00:00";
                }
            });
            put("STUDY_ITEM", p -> {
                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_i24s5S5D");
                // 培训内容不能为空，如果为空返回"-"
                if (v == null || v.trim().isEmpty()) {
                    return "-";
                }
                return v.trim();
            });
        }
    };

    /**
     * 反射设置OracleStaffStudy属性（字段名需与OracleStaffStudy属性一致，支持下划线转驼峰）
     * String类型赋值为字符串，Date/BigDecimal类型空字符串赋null，日期自动识别格式
     */
    public void setOracleField(OracleStaffStudy oracle, String field, String value) {
        FieldSetterTool.setField(oracle, field, value);
    }
}
