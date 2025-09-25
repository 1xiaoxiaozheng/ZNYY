package com.springbootTz.ZNYY.mapper;

import com.springbootTz.ZNYY.entity.OraclePersonEmprInfo;
import com.springbootTz.ZNYY.entity.PostgresPersonDetailCustom;
import com.springbootTz.ZNYY.entity.PostgresPerson;
import com.springbootTz.ZNYY.tool.DepartmentQueryTool;
import com.springbootTz.ZNYY.tool.OrgCodeConcatTool;
import com.springbootTz.ZNYY.tool.OrgCodeQueryTool;
import com.springbootTz.ZNYY.tool.JsonKeyValueTool;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonDetailCustomMapper;
import com.springbootTz.ZNYY.tool.FieldSetterTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 用于OraclePersonEmprInfo与PostgresPersonDetailCustom字段映射的工具类
 * hum_psn_empr_info表的同步，该表对应内容为自定义字段表ehr_org_person_detail_custom
 */
/**
 * 3. PersonEmperFieldMapper - 人员工作经历
 * 数据说明：人员的工作履历信息，包括工作单位、岗位、工作时间等
 * PostgreSQL表：ehr_org_person_detail_custom (detail_id =
 * "person_detail_DFIXZgBn")
 * Oracle表：HUM_PSN_EMPR_INFO
 * 同步方法：syncWorkInfoAll()
 */
@Component
public class PersonEmperFieldMapper {
    private static final Logger logger = LoggerFactory.getLogger(PersonEmperFieldMapper.class);

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
     * 对应关系如下：
     * RID，ORG_NAME，USCID，与PersonEduinfoMapper中的一样和ehr_person内容关联，只不过自己这张表不一样而已
     * UPLOAD_TIME为当前时间
     * SYS_PRDR_CODE为1，SYS_PRDR_NAME为福建众智政友科技有限公司
     * DATA_CLCT_PRDR_NAME为福建众智政友科技有限公司
     * ORIGINAL_ID为ehr_org_person_detail_custom的id
     * STAFF_ID为person_id
     * STAFF_NO为关联表的number字段
     * STAFF_NAME为关联表的name字段
     * crte_time为create_time
     * updt_time为modify_time
     * delet_time为" "
     * delete为del_flag对应
     * wkbegn_date为jsonKeyValueTool.getValueByKey(p.getCustomFields(),
     * person_duqtB5bp);
     * wkend_date为jsonKeyValueTool.getValueByKey(p.getCustomFields(),
     * person_7SwcKsXi);
     * empr_name为jsonKeyValueTool.getValueByKey(p.getCustomFields(),
     * person_lpdeGEnj);
     * post_dept_name为jsonKeyValueTool.getValueByKey(p.getCustomFields(),
     * person_mSyEbqbD);
     * appoint_name为jsonKeyValueTool.getValueByKey(p.getCustomFields(),
     * person_XURDm7wV);
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
            put("WKBEGN_DATE", toSafeString(p -> {
                String wkbegnDate = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_duqtB5bp");
                return wkbegnDate == null ? " " : wkbegnDate;
            }));
            put("WKEND_DATE", toSafeString(p -> {
                String wkendDate = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_7SwcKsXi");
                return wkendDate == null ? " " : wkendDate;
            }));
            put("EMPR_NAME", toSafeString(p -> {
                String emprName = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_lpdeGEnj");
                return emprName == null ? " " : emprName;
            }));
            put("POST_DEPT_NAME", toSafeString(p -> {
                String postDeptName = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_mSyEbqbD");
                return postDeptName == null ? " " : postDeptName;
            }));
            put("APPOINT_NAME", toSafeString(p -> {
                String appointName = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_XURDm7wV");
                return appointName == null ? " " : appointName;
            }));
        }
    };

    /**
     * 反射设置OraclePersonEmprInfo属性（字段名需与OraclePersonEmprInfo属性一致，支持下划线转驼峰）
     * String类型赋值为字符串，Date/BigDecimal类型空字符串赋null，日期自动识别格式
     */
    public void setOracleField(OraclePersonEmprInfo oracle, String field, String value) {
        FieldSetterTool.setField(oracle, field, value);
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
