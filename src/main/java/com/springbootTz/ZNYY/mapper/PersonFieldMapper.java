package com.springbootTz.ZNYY.mapper;

import com.springbootTz.ZNYY.entity.PostgresPerson;
import com.springbootTz.ZNYY.entity.OraclePerson;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonMapper;
import com.springbootTz.ZNYY.tool.DepartmentQueryTool;
import com.springbootTz.ZNYY.tool.OrgCodeConcatTool;
import com.springbootTz.ZNYY.tool.OrgCodeQueryTool;
import com.springbootTz.ZNYY.tool.EnumValueQueryTool;
import com.springbootTz.ZNYY.tool.JsonKeyValueTool;
import com.springbootTz.ZNYY.tool.FieldSetterTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Qualifier;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import javax.sql.DataSource;

/**
 * 人员基本信息表对应字段映射器
 * . PersonFieldMapper - 人员基本信息
 * 数据说明：人员的基本档案信息，包括姓名、身份证、性别、民族、学历等基础信息
 * PostgreSQL表：ehr_org_person
 * Oracle表：HUM_PSN_INFO
 */
@Component
public class PersonFieldMapper {
        private static final Logger logger = LoggerFactory.getLogger(PersonFieldMapper.class);
        @Autowired
        private DepartmentQueryTool departmentQueryTool;
        @Autowired
        private OrgCodeQueryTool orgCodeQueryTool;
        @Autowired
        private OrgCodeConcatTool orgCodeConcatTool;
        @Autowired
        private EnumValueQueryTool enumValueQueryTool;
        @Autowired
        @Qualifier("postgresDataSource")
        private DataSource postgresqlDataSource;
        @Autowired
        private PostgresPersonMapper postgresPersonMapper;
        @Autowired
        private OraclePersonMapper oraclePersonMapper;
        // 直接定义常量，避免配置文件中文乱码
        private static final String SYS_PRDR_CODE = "FJZZZYKJYXGS";
        private static final String SYS_PRDR_NAME = "福建众智政友科技有限公司";
        private static final String COME_FROM_ORG = "未知";
        private static final String DATA_CLCT_PRDR_NAME = "福建众智政友科技有限公司";

        /**
         * 包装映射函数，保证输出为String且null转""
         */
        private static <T> Function<T, String> toSafeString(Function<T, ?> func) {
                return t -> {
                        Object v = func.apply(t);
                        return v == null ? "" : v.toString();
                };
        }

        /**
         * Oracle字段名 -> 映射逻辑（输入PostgresPerson，输出String）
         */
        public final Map<String, Function<PostgresPerson, String>> FIELD_MAPPING = new LinkedHashMap<String, Function<PostgresPerson, String>>() {
                {
                        put("RID", toSafeString(p -> {
                                String orgName = departmentQueryTool.getOrgNameByDeptId(p.getDeptId());
                                if (orgName == null || orgName.isEmpty()) {
                                        return null;
                                }
                                return orgCodeConcatTool.concatCodeAndParams(orgName, SYS_PRDR_CODE, p.getId());
                        }));
                        put("ORG_NAME", toSafeString(p -> departmentQueryTool.getOrgNameByDeptId(p.getDeptId())));
                        put("USCID", toSafeString(p -> {
                                String orgName = departmentQueryTool.getOrgNameByDeptId(p.getDeptId());
                                if (orgName == null || orgName.isEmpty()) {
                                        return "";
                                }
                                String uscid = orgCodeQueryTool.getCodeByDisplay(orgName);
                                return uscid == null ? "" : uscid;
                        }));
                        put("SYS_PRDR_CODE", toSafeString(p -> SYS_PRDR_CODE));
                        put("SYS_PRDR_NAME", toSafeString(p -> SYS_PRDR_NAME));
                        put("ORIGINAL_ID", toSafeString(PostgresPerson::getId));
                        put("STAFF_NAME", toSafeString(PostgresPerson::getName));
                        put("STAFF_NO", toSafeString(PostgresPerson::getNumber));
                        put("PSNCERT_TYPE_CODE", toSafeString(p -> p.getIdCardType()));
                        put("PSNCERT_TYPE_NAME",
                                        toSafeString(p -> enumValueQueryTool.getDisplayByEnumNameAndValue("证件类型",
                                                        p.getIdCardType() == null ? -1 : p.getIdCardType())));
                        put("CERTNO", toSafeString(PostgresPerson::getIdNumber));
                        put("BRDY", toSafeString(p -> p.getBirthday() == null ? null : p.getBirthday().toString()));
                        put("GENDER_CODE", toSafeString(p -> p.getGender()));
                        put("GENDER_NAME", toSafeString(p -> {
                                if (p.getGender() == null)
                                        return "";
                                switch (p.getGender()) {
                                        case 0:
                                                return "保密";
                                        case 1:
                                                return "男";
                                        case 2:
                                                return "女";
                                        default:
                                                return "";
                                }
                        }));
                        put("NATION_CODE", toSafeString(PostgresPerson::getNationType));
                        put("NATION_NAME", toSafeString(PostgresPerson::getNationType));
                        put("POLITICAL_CODE", toSafeString(p -> p.getPoliticalType()));
                        put("POLITICAL_NAME", toSafeString(p -> p.getPoliticalType()));
                        put("DEPT_CODE", toSafeString(PostgresPerson::getDeptId));
                        put("DEPT_NAME", toSafeString(p -> departmentQueryTool.getOrgNameByDeptId(p.getDeptId())));
                        put("PERSON_PROP_CODE", toSafeString(p -> p.getWorkType()));
                        put("PERSON_PROP_NAME", toSafeString(p -> p.getWorkType() == null ? null
                                        : enumValueQueryTool.getDisplayByEnumNameAndValue("工作性质-标准", p.getWorkType())));
                        put("COME_FROM_ORG", toSafeString(p -> COME_FROM_ORG));
                        put("WORK_YM", toSafeString(p -> {
                                if (p.getStartWorkTime() == null)
                                        return null;
                                java.time.LocalDateTime ldt = p.getStartWorkTime().toLocalDateTime();
                                return String.format("%04d%02d", ldt.getYear(), ldt.getMonthValue());
                        }));
                        put("COME_HOS_DATE", toSafeString(p -> {
                                if (p.getStartTime() == null)
                                        return null;
                                return p.getStartTime().toLocalDateTime().toLocalDate().toString();
                        }));
                        put("DUTY_CODE", toSafeString(PostgresPerson::getJobId));
                        put("DUTY_NAME", toSafeString(PostgresPerson::getJobName));
                        put("MAX_EDU_BACKGROUND_CODE", toSafeString(p -> p.getEducationType()));
                        put("MAX_EDU_BACKGROUND_NAME", toSafeString(p -> p.getEducationType() == null ? null
                                        : enumValueQueryTool.getDisplayByEnumNameAndValue("学历类型枚举",
                                                        p.getEducationType())));
                        put("INOROUT_DATE", toSafeString(p -> {
                                if (p.getEndTime() == null)
                                        return null;
                                return p.getEndTime().toLocalDateTime().toLocalDate().toString();
                        }));
                        put("HIRE_STATUS_CODE", toSafeString(p -> p.getState()));
                        put("HIRE_STATUS_NAME", toSafeString(p -> p.getState() == null ? null
                                        : enumValueQueryTool.getDisplayByEnumNameAndValue("人员状态枚举", p.getState())));
                        put("OUT_TYPE_CODE", toSafeString(p -> p.getEndReasonType()));
                        put("OUT_TYPE_NAME", toSafeString(p -> {
                                if (p.getEndReasonType() == null)
                                        return null;
                                int type;
                                try {
                                        type = Integer.parseInt(p.getEndReasonType());
                                } catch (NumberFormatException e) {
                                        return "";
                                }
                                switch (type) {
                                        case 0:
                                                return "离职";
                                        case 1:
                                                return "调离";
                                        default:
                                                return "";
                                }
                        }));
                        put("DATA_CLCT_PRDR_NAME", toSafeString(p -> DATA_CLCT_PRDR_NAME));
                        put("CRTE_TIME", toSafeString(p -> "2025-06-30 00:00:00"));
                        put("UPDT_TIME", toSafeString(
                                        p -> p.getModifyTime() == null ? null : p.getModifyTime().toString()));
                        put("DELETED", toSafeString(p -> {
                                Long delFlag = p.getDelFlag();
                                if (delFlag != null && String.valueOf(delFlag).length() == 1) {
                                        return "0";
                                } else {
                                        return "1";
                                }
                        }));
                        put("DELETED_TIME", toSafeString(p -> ""));
                        put("UPLOAD_TIME", toSafeString(p -> java.time.LocalDateTime.now()
                                        .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
                        put("CURR_ADDR", toSafeString(PostgresPerson::getAddress));
                        put("PSN_TEL", toSafeString(PostgresPerson::getPhone));
                        put("EMPR_POSCODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_caena0g0")));
                        put("JOIN_PARTY_YM",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_hvsLnzBc")));
                        put("MAJOR_TYPE_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_uJhLfKxb")));
                        put("MAJOR_TYPE_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_uJhLfKxb")));
                        put("WORK_UNIT", toSafeString(
                                        p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_xsM0Ez44")));
                        put("COME_PROP_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_kdU0XGy6")));
                        put("COME_PROP_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_kdU0XGy6")));
                        put("COME_TYPE_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_danhI3wb")));
                        put("COME_TYPE_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_danhI3wb")));
                        put("FIRST_EDU_BACKGROUND_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_8Rvwg5q1")));
                        put("FIRST_EDU_BACKGROUND_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_8Rvwg5q1")));
                        put("DEGREE_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_DkRk64Sq")));
                        put("DEGREE_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_DkRk64Sq")));
                        put("FIRST_LEVEL_DISC_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_j4dW8oSZ")));
                        put("FIRST_LEVEL_DISC_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_j4dW8oSZ")));
                        put("MAJOR_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_AgyJjAtX")));
                        put("MAJOR_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_AgyJjAtX")));
                        put("LEVEL_SPECIAL",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_x3S8YcGe")));
                        put("TECHNOLOGY_GET_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_bfyynNCJ")));
                        put("TECHNOLOGY_GET_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_bfyynNCJ")));
                        put("TECHNOLOGY_GET_LEVEL_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_NdOd7wLk")));
                        put("TECHNOLOGY_GET_LEVEL_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_NdOd7wLk")));
                        put("TECHNOLOGY_GET_YM",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_10Eltjqi")));
                        put("PROFTECHTTL_APPO_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_BCrHmhQg")));
                        put("PROFTECHTTL_APPO_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_BCrHmhQg")));
                        put("RES_PROFTECHTTL_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_MEPKPpNn")));
                        put("RES_PROFTECHTTL_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_MEPKPpNn")));
                        put("PROFTECHTTL_APPO_YM",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_tb3prk1G")));
                        put("PRACTICE_NUMBER",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_9Rmob2Sg")));
                        put("PRACTICE_TYPE_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_lyPwFOMV")));
                        put("PRACTICE_TYPE_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_lyPwFOMV")));
                        put("PRACTICE_SCOPE_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_wdN4kD3G")));
                        put("PRACTICE_SCOPE_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_wdN4kD3G")));
                        put("IS_MANY_ORG_DOC",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_HDcM6L2n")));
                        put("SEC_ORG", toSafeString(
                                        p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_8Qys6Typ")));
                        put("SEC_ORG_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_8Qys6Typ")));
                        put("THRD_ORG", toSafeString(
                                        p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_2c0Prom5")));
                        put("THRD_ORG_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_2c0Prom5")));
                        put("IS_ALL_MAJOR",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_toywQeAb")));
                        put("IS_COUNTRY_DOC",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_B25HDBEt")));
                        put("COMMUNITY_SERVICE_FLAG",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_OViwM3Hy")));
                        put("WORK_YEARS_VALLIGE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_ufhKTH0Y")));
                        put("WORK_COUNTRY_TIMER",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_CGx5rkyk")));
                        put("IS_INFORMATION_STATISTIAL",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_e65DLtQb")));
                        put("INFORMATION_STATISTIAL_CODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_2sUALPS2")));
                        put("INFORMATION_STATISTIAL_NAME",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_2sUALPS2")));
                        put("ON_WORK_TRAIN",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_dUOqrrsj")));
                        put("OUTPLACE", toSafeString(
                                        p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_kWP2fcaQ")));
                }
        };

        /**
         * 反射设置OraclePerson属性（字段名需与OraclePerson属性一致，支持下划线转驼峰）
         * String类型赋值为字符串，Date/BigDecimal类型空字符串赋null，日期自动识别格式
         */
        public void setOracleField(OraclePerson oraclePerson, String field, String value) {
                FieldSetterTool.setField(oraclePerson, field, value);
        }

        /**
         * 下划线转驼峰
         */
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