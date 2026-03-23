package com.springbootTz.ZNYY.Humanresource.mapper.Converter;

import com.springbootTz.ZNYY.Humanresource.entity.PostgresPerson;
import com.springbootTz.ZNYY.Humanresource.entity.OraclePerson;
import com.springbootTz.ZNYY.Humanresource.mapper.oracle.OraclePersonMapper;
import com.springbootTz.ZNYY.Humanresource.mapper.postgresql.OursEnumValueMapper;
import com.springbootTz.ZNYY.Humanresource.mapper.postgresql.PostgresPersonDetailEducationExperienceMapper;
import com.springbootTz.ZNYY.Humanresource.mapper.postgresql.PostgresPersonMapper;
import com.springbootTz.ZNYY.Humanresource.service.OursEnumValueService;
import com.springbootTz.ZNYY.Humanresource.tool.DepartmentQueryTool;
import com.springbootTz.ZNYY.Humanresource.tool.OrgCodeConcatTool;
import com.springbootTz.ZNYY.Humanresource.tool.OrgCodeQueryTool;
import com.springbootTz.ZNYY.Humanresource.tool.EnumValueQueryTool;
import com.springbootTz.ZNYY.Humanresource.tool.JsonKeyValueTool;
import com.springbootTz.ZNYY.Humanresource.tool.FieldSetterTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Qualifier;

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
        private PostgresPersonDetailEducationExperienceMapper postgresPersonDetailEducationExperienceMapper;
        @Autowired
        private OrgCodeQueryTool orgCodeQueryTool;
        @Autowired
        private OrgCodeConcatTool orgCodeConcatTool;
        @Autowired
        private EnumValueQueryTool enumValueQueryTool;

        @Autowired
        private OursEnumValueMapper oursEnumValueMapper;
        @Autowired
        @Qualifier("postgresDataSource")
        private DataSource postgresqlDataSource;
        @Autowired
        private PostgresPersonMapper postgresPersonMapper;
        @Autowired
        private OraclePersonMapper oraclePersonMapper;
        @Autowired
        private OursEnumValueService oursEnumValueService;

        @Autowired
        private JsonKeyValueTool jsonKeyValueTool;
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
                        put("PERSON_PROP_CODE", toSafeString(p -> {
                                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_xLIaqBeW");
                                return v == null ? "-" : v;
                        }));
                        put("PERSON_PROP_NAME", toSafeString(p ->{
                                String v = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_xLIaqBeW");
                                return v == null ? "-" : oursEnumValueService.getDisplayById(v);
                        }));
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
                        put("DUTY_CODE", toSafeString(p -> {
                                String jobId = p.getJobId();
                                // 空值（null/空字符串/纯空格）返回 "-"，非空返回去空格后的值
                                return (jobId == null || jobId.trim().isEmpty()) ? "-" : jobId.trim();
                        }));
                        put("DUTY_NAME", toSafeString(
                                p ->{
                                        String id = p.getJobId();
                                        if (id == null){
                                                return "-";
                                        }
                                         String name = oursEnumValueMapper.selectNameById(id);

                                        return name == null ? "-" : name;}
                        ));
                        put("MAX_EDU_BACKGROUND_CODE", toSafeString(p -> {
                                Integer v = p.getEducationType();
                                if (v == null) {
                                        return "-";
                                }
                                return String.valueOf(v);
                        }));
                        put("MAX_EDU_BACKGROUND_NAME", toSafeString(p ->
                                {
                                        Integer v = p.getEducationType();
                                        String name = oursEnumValueMapper.selectDisplayByValue(v);
                                        return name == null ? "-" : name;
                                }
                                ));
                        put("INOROUT_DATE", toSafeString(p -> {
                                if (p.getEndTime() == null)
                                        return null;
                                return p.getEndTime().toLocalDateTime().toLocalDate().toString();
                        }));
                        put("HIRE_STATUS_CODE", toSafeString(p -> p.getState()));
                        //6 种状态：正式、试用、非正式、返聘、离职、退休
                        put("HIRE_STATUS_NAME", toSafeString(p ->
                                {
                                     Integer state = p.getState();
                                     if (state == null) {
                                             return "-";
                                     }
                                      switch (state) {
                                             case 1:
                                                     return "正式";
                                             case 2:
                                                     return "试用";
                                             case 3:
                                                     return "非正式";
                                             case 4:
                                                     return "返聘";
                                             case 5:
                                                     return "离职";
                                             case 6:
                                                     return "退休";
                                             default:
                                                     return "-";
                                      }
                                }
                                ));
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
                        put("CURR_ADDR", toSafeString(p -> {
                                String address = p.getAddress();
                                // 空值（null/空字符串/纯空格）返回 "-"，非空返回去空格后的值
                                return (address == null || address.trim().isEmpty()) ? "-" : address.trim();
                        }));
                        put("PSN_TEL", toSafeString(PostgresPerson::getPhone));
                        put("EMPR_POSCODE",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_caena0g0")));
                        put("JOIN_PARTY_YM",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_hvsLnzBc")));
                        // MAJOR_TYPE_CODE：空值返回 "-"，非空去空格
                        put("MAJOR_TYPE_CODE", toSafeString(p -> {
                                String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_uJhLfKxb");
                                return (v == null || v.trim().isEmpty()) ? "-" : v.trim();
                        }));

                        // MAJOR_TYPE_NAME：逻辑与 CODE 完全一致（空值 "-"，非空去空格）
                        put("MAJOR_TYPE_NAME", toSafeString(p -> {
                                String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_uJhLfKxb");
                                return (v == null || v.trim().isEmpty()) ? "-" : v.trim();
                        }));
                        put("WORK_UNIT", toSafeString(
                                        p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_xsM0Ez44")));
                        put("COME_PROP_CODE", toSafeString(p -> {
                                String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_vJMvshZ8");
                                return (v == null || v.trim().isEmpty()) ? "-" : v.trim();
                        }));
                        put("COME_PROP_NAME", toSafeString(
                                p ->{
                                        String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_vJMvshZ8");
                                        return v == null ? "-" : oursEnumValueService.getDisplayById(v);
                                } ));
                        // COME_TYPE_CODE：空值（null/空字符串/纯空格）返回 "-"，非空返回去空格后的值
                        put("COME_TYPE_CODE", toSafeString(p -> {
                                String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_3RAFf7Nh");
                                return (v == null || v.trim().isEmpty()) ? "-" : v.trim();
                        }));

                        // COME_TYPE_NAME：空值返回 "-"，非空按 code 查 display，查不到也返回 "-"
                        put("COME_TYPE_NAME", toSafeString(p -> {
                                String code = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_3RAFf7Nh");
                                // 1. 空值直接返回 "-"
                                if (code == null || code.trim().isEmpty()) {
                                        return "-";
                                }
                                // 2. 非空查枚举，查不到返回 "-"（避免返回 null）
                                String display = oursEnumValueService.getDisplayById(code.trim());
                                return display != null && !display.trim().isEmpty() ? display.trim() : "-";
                        }));

                        put("FIRST_EDU_BACKGROUND_CODE",
                                        toSafeString(p ->
                                                {
                                                        String v = postgresPersonDetailEducationExperienceMapper.selectDegreeTypeByPersonId(p.getId());
                                                        if (v == null){
                                                                return "-";
                                                        }
                                                         switch (v) {
                                                                case "1":
                                                                        return "20";
                                                                case "2":
                                                                        return "14";
                                                                case "3":
                                                                        return "21";
                                                                default:
                                                                        return "-";
                                                         }
                                                }
                                                ));
                        put("FIRST_EDU_BACKGROUND_NAME",
                                        toSafeString(p -> {
                                                String v = postgresPersonDetailEducationExperienceMapper.selectDegreeTypeByPersonId(p.getId());
                                                if (v == null){
                                                        return "-";
                                                }
                                                 switch (v) {
                                                        case "1":
                                                                return "博士研究生毕业";
                                                        case "2":
                                                                return "硕士研究生毕业";
                                                        case "3":
                                                                return "大学本科毕业";
                                                        default:
                                                                return "-";
                                                 }
                                        }));
                       //学位代码和学位名称——>更改成三一网的内容
                        // 01博士
                        //02硕士
                        //03学士
                        /**
                         * 这是新势力目前的
                         * 学士	1
                         * 硕士	2
                         * 博士	3
                         * 名誉博士	4
                         * 未取得学位	5
                         */
                        /**
                         * SELECT degree_type from ehr_org_person_detail_education_experience  WHERE person_id ='';
                         * 也就是要用这边的主键id去查教育明细表
                         */
                        put("DEGREE_NAME",
                                toSafeString(p -> {
                                        String v = postgresPersonDetailEducationExperienceMapper.selectDegreeTypeByPersonId(p.getId());
                                        if (v == null) {
                                                return "-"; // 已处理 null，没问题
                                        }
                                        switch (v) {
                                                case "1":
                                                        return "学士";
                                                case "2":
                                                        return "硕士";
                                                case "3":
                                                        return "博士";
                                                default: // 补充 default，避免漏判
                                                        return "-";
                                        }
                                }));

                        put("DEGREE_CODE",
                                toSafeString(p -> {
                                        String v = postgresPersonDetailEducationExperienceMapper.selectDegreeTypeByPersonId(p.getId());
                                        if (v == null) { // 关键修复：处理 v 为 null 的情况
                                                return "-";
                                        }
                                        switch (v) {
                                                case "1":
                                                        return "3";
                                                case "2":
                                                        return "2";
                                                case "3":
                                                        return "1";
                                                default:
                                                        return "-";
                                        }
                                }));



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
                        // TECHNOLOGY_GET_CODE：空值（null/空字符串/纯空格）返回 "-"，非空去空格
                        put("TECHNOLOGY_GET_CODE", toSafeString(p -> {
                                String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_bfyynNCJ");
                                return (v == null || v.trim().isEmpty()) ? "-" : v.trim();
                        }));

                        // TECHNOLOGY_GET_NAME：逻辑与 CODE 完全一致，空值返回 "-"，非空去空格
                        put("TECHNOLOGY_GET_NAME", toSafeString(p -> {
                                String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_bfyynNCJ");
                                return (v == null || v.trim().isEmpty()) ? "-" : v.trim();
                        }));
                        // TECHNOLOGY_GET_LEVEL_CODE：空值（null/空字符串/纯空格）返回 "-"，非空去空格
                        put("TECHNOLOGY_GET_LEVEL_CODE", toSafeString(p -> {
                                String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_NdOd7wLk");
                                return (v == null || v.trim().isEmpty()) ? "-" : v.trim();
                        }));

                        // TECHNOLOGY_GET_LEVEL_NAME：逻辑与 CODE 完全一致，空值返回 "-"，非空去空格
                        put("TECHNOLOGY_GET_LEVEL_NAME", toSafeString(p -> {
                                String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_NdOd7wLk");
                                return (v == null || v.trim().isEmpty()) ? "-" : v.trim();
                        }));
                        put("TECHNOLOGY_GET_YM",
                                        toSafeString(p -> JsonKeyValueTool.getValueByKey(p.getCustomFields(),
                                                        "person_10Eltjqi")));
                        // PROFTECHTTL_APPO_CODE：空值（null/空字符串/纯空格）返回 "-"，非空去空格
                        put("PROFTECHTTL_APPO_CODE", toSafeString(p -> {
                                String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_BCrHmhQg");
                                return (v == null || v.trim().isEmpty()) ? "-" : v.trim();
                        }));

                        // PROFTECHTTL_APPO_NAME：逻辑与 CODE 完全一致，空值返回 "-"，非空去空格
                        put("PROFTECHTTL_APPO_NAME", toSafeString(p -> {
                                String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_BCrHmhQg");
                                return (v == null || v.trim().isEmpty()) ? "-" : v.trim();
                        }));
                        // RES_PROFTECHTTL_CODE：空值（null/空字符串/纯空格）返回 "-"，非空去空格
                        put("RES_PROFTECHTTL_CODE", toSafeString(p -> {
                                String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_MEPKPpNn");
                                return (v == null || v.trim().isEmpty()) ? "-" : v.trim();
                        }));

                        // RES_PROFTECHTTL_NAME：逻辑与 CODE 完全一致，空值返回 "-"，非空去空格
                        put("RES_PROFTECHTTL_NAME", toSafeString(p -> {
                                String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_MEPKPpNn");
                                return (v == null || v.trim().isEmpty()) ? "-" : v.trim();
                        }));
                        // PROFTECHTTL_APPO_YM：空值返回无效时间 1900-01-01，非空去空格
                        put("PROFTECHTTL_APPO_YM", toSafeString(p -> {
                                String v = JsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_tb3prk1G");
                                // 空值（null/空字符串/纯空格）返回统一无效日期，非空返回去空格后的值
                                return (v == null || v.trim().isEmpty()) ? "1900-01-01 00:00:00" : v.trim();
                        }));
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