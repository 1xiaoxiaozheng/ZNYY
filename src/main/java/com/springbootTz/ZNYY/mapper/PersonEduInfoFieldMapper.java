package com.springbootTz.ZNYY.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import com.springbootTz.ZNYY.service.OursEnumValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springbootTz.ZNYY.entity.OraclePersonEduInfo;
import com.springbootTz.ZNYY.entity.PostgresPerson;
import com.springbootTz.ZNYY.entity.PostgresPersonDetailEducationExperience;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonDetailEducationExperienceMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonMapper;
import com.springbootTz.ZNYY.tool.DepartmentQueryTool;
import com.springbootTz.ZNYY.tool.EnumValueQueryTool;
import com.springbootTz.ZNYY.tool.FieldSetterTool;
import com.springbootTz.ZNYY.tool.JsonKeyValueTool;
import com.springbootTz.ZNYY.tool.OrgCodeConcatTool;
import com.springbootTz.ZNYY.tool.OrgCodeQueryTool;

/**
 * 用于OraclePersonEduInfo与PostgresPersonDetailEducationExperience字段映射的工具类
 * 后续可在此类中实现字段映射逻辑
 * PersonEduInfoFieldMapper - 人员教育经历
 * 数据说明：人员的学历教育经历，包括学校、专业、学位、学习时间等
 * PostgreSQL表：ehr_org_person_detail_education_experience
 * Oracle表：HUM_PSN_EDU_INFO
 * 同步方法：syncEducationInfoAll()
 */
@Component
public class PersonEduInfoFieldMapper {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    private static final Logger logger = LoggerFactory.getLogger(PersonEduInfoFieldMapper.class);
    @Autowired
    private DepartmentQueryTool departmentQueryTool;
    @Autowired
    private OrgCodeQueryTool orgCodeQueryTool;
    @Autowired
    private OrgCodeConcatTool orgCodeConcatTool;
    @Autowired
    private EnumValueQueryTool enumValueQueryTool;
    @Autowired
    private JsonKeyValueTool jsonKeyValueTool;
    @Autowired
    private PostgresPersonMapper postgresPersonMapper;
    @Autowired
    private PostgresPersonDetailEducationExperienceMapper detailEducationExperienceMapper;
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

    /**
     * Oracle字段名 -> 映射逻辑（输入PostgresPersonDetailEducationExperience，输出String）
     */
    public final Map<String, Function<PostgresPersonDetailEducationExperience, String>> FIELD_MAPPING = new LinkedHashMap<String, Function<PostgresPersonDetailEducationExperience, String>>() {
        {
            put("RID", toSafeString(p -> {
                String orgName = getOrgNameByPersonId(p.getPersonId());
                if (orgName == null || orgName.isEmpty()) {
                    return " ";
                }
                return orgCodeConcatTool.concatCodeAndParams(orgName, SYS_PRDR_CODE, p.getId());
//                return uscid+SYS_PRDR_CODE+p.getId();
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
                String uscid = oursEnumValueService.getCodeByDisplay(orgName);
                return uscid == null ? " " : uscid;
            }));
            put("UPLOAD_TIME",
                    toSafeString(p -> new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
            put("SYS_PRDR_CODE", toSafeString(p -> SYS_PRDR_CODE));
            put("SYS_PRDR_NAME", toSafeString(p -> SYS_PRDR_NAME));
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
            put("GRADUAT_SCH", toSafeString(p -> p.getSchool() == null ? "-" : p.getSchool()));
            put("ENR_DATE", toSafeString(p -> {
                Date startTime = p.getStartTime();
                // 为空则返回无效日期 "1900-01-01"，不为空则格式化为 YYYY-MM-DD 字符串
                return startTime == null ? "1900-01-01 00:00:00" : DATE_FORMATTER.format(startTime);
            }));
            put("GRADUAT_DATE", toSafeString(p -> {
                Date endTime = p.getEndTime();
                // 为空则返回无效日期 "1900-01-01"，不为空则格式化为 YYYY-MM-DD 标准格式
                return endTime == null ? "1900-01-01 00:00:00" : DATE_FORMATTER.format(endTime);
            }));
            /**
             * 你的系统（文字）	你的系统（数字）	医院枚举（文字）	医院枚举（数字）	备注
             * 小学	1	小学毕业	81	按你要求默认映射 “毕业” 状态
             * 初中	2	初中毕业	71	按你要求默认映射 “毕业” 状态
             * 高中	3	普通高中毕业	61	按你要求默认映射 “毕业” 状态
             * 中专	4	中等专科毕业	41	中等职业教育下核心毕业状态
             * 技校	5	技工学校毕业	47	中等职业教育下技校毕业状态
             * 中技	13	技工学校毕业	47	中技 = 技校，同义映射
             * 职高	6	职业高中毕业	43	中等职业教育下职高毕业状态
             * 大专	7	大学专科毕业	31	专科教育核心毕业状态
             * 本科	8	大学本科毕业	21	本科教育核心毕业状态
             * 本科学士	9	大学本科毕业	21	本科学士隐含本科毕业
             * 硕士研究生	10	硕士研究生毕业	14	研究生教育硕士毕业状态
             * 博士研究生	12	博士研究生毕业	11	研究生教育博士毕业状态
             * 其他	14	其他	90	直接匹配
             * 在职本科	15	大学本科毕业	21	医院不区分在职，按毕业状态映射
             * 在职本科学士	16	大学本科毕业	21	在职 + 本科学士 = 本科毕业
             * 专科	17	大学专科毕业	31	专科 = 大专，同义映射
             * 在职博士研究生	18	博士研究生毕业	11	医院不区分在职，按毕业状态映射
             * 在职硕士研究生	19	硕士研究生毕业	14	医院不区分在职，按毕业状态映射
             * 在职大专	20	大学专科毕业	31	医院不区分在职，按毕业状态映射
             * 在职中专	21	中等专科毕业	41	医院不区分在职，按毕业状态映射
             */
            put("EDU_BACKGROUND_CODE", toSafeString(p ->
                    {
                        if (p.getEducationType() == null || p.getEducationType().isEmpty()) {
                            return "-";
                        }
                        if (p.getEducationType().equals("1")){
                            return "81";
                        }
                        if (p.getEducationType().equals("2")){
                            return "71";
                        }
                        if (p.getEducationType().equals("3")){
                            return "61";
                        }
                        if (p.getEducationType().equals("4")){
                            return "41";
                        }
                        if (p.getEducationType().equals("5")){
                            return "47";
                        }
                        if (p.getEducationType().equals("6")){
                            return "43";
                        }
                        if (p.getEducationType().equals("7")){
                            return "31";
                        }
                        if (p.getEducationType().equals("8")){
                            return "21";
                        }
                        if (p.getEducationType().equals("9")){
                            return "21";
                        }
                        if (p.getEducationType().equals("10")){
                            return "14";
                        }
                        if (p.getEducationType().equals("12")){
                            return "11";
                        }
                        if (p.getEducationType().equals("14")){
                            return "90";
                        }
                        if (p.getEducationType().equals("15")){
                            return "21";
                        }
                        if (p.getEducationType().equals("16")){
                            return "21";
                        }
                        if (p.getEducationType().equals("17")){
                            return "31";
                        }
                        if (p.getEducationType().equals("18")){
                            return "11";
                        }
                        if (p.getEducationType().equals("19")){
                            return "14";
                        }
                        if (p.getEducationType().equals("20")){
                            return "31";
                        }
                        if (p.getEducationType().equals("21")){
                            return "41";
                        }
                        else {
                            return "-";
                        }
                    }
                    ));
            put("EDU_BACKGROUND_NAME", toSafeString(p ->
                    {
                        String educationType = p.getEducationType();
                        if (educationType == null || educationType.isEmpty()) {
                            return " ";
                        }
                        if (educationType.equals("1")){
                            return "小学毕业";
                        }
                        if (educationType.equals("2")){
                            return "初中毕业";
                        }
                        if (educationType.equals("3")){
                            return "普通高中毕业";
                        }
                        if (educationType.equals("4")){
                            return "中等专科毕业";
                        }
                        if (educationType.equals("5")){
                            return "技工学校毕业";
                        }
                        if (educationType.equals("6")){
                            return "职业高中毕业";
                        }
                        if (educationType.equals("7")){
                            return "大学专科毕业";
                        }
                        if (educationType.equals("8")){
                            return "大学本科毕业";
                        }
                        if (educationType.equals("9")){
                            return "大学本科毕业";
                        }
                        if (educationType.equals("10")){
                            return "硕士研究生毕业";
                        }
                        if (educationType.equals("12")){
                            return "博士研究生毕业";
                        }
                        if (educationType.equals("14")){
                            return "其他";
                        }
                        if (educationType.equals("15")){
                            return "大学本科毕业";
                        }
                        if (educationType.equals("16")){
                            return "大学本科毕业";
                        }
                        if (educationType.equals("17")){
                            return "大学专科毕业";
                        }
                        if (educationType.equals("18")){
                            return "博士研究生毕业";
                        }
                        if (educationType.equals("19")){
                            return "硕士研究生毕业";
                        }
                        if (educationType.equals("20")){
                            return "大学专科毕业";
                        }
                        if (educationType.equals("21")){
                            return "中等专科毕业";
                        }
                        else {
                            return " ";
                        }
                    }
                    ));
            put("DEGREE_CODE", toSafeString(p ->
                    {
                        String degreeType = p.getDegreeType();
                        if (degreeType == null || degreeType.isEmpty()) {
                            return "-";
                        }
                        if (degreeType.equals("1")){
                            return "3";
                        }
                        if (degreeType.equals("2")){
                            return "2";
                        }
                        if (degreeType.equals("3")){
                            return "1";
                        }
                        return "-";
                    }
            ));
            //如果枚举值是“未取得学位”——无
            put("DEGREE_NAME", toSafeString(p -> {
                String degreeType = p.getDegreeType();
                if (degreeType == null || degreeType.isEmpty()) {
                    return "-";
                }

                if (degreeType.equals("1")) {
                    return "学士";
                }
                if (degreeType.equals("2")) {
                    return "硕士";
                }
                if (degreeType.equals("3")) {
                    return "博士";
                }

                return "-";

            }));

//            put("DEGREE_NAME", toSafeString(p -> p.getDegreeType() == null ? " "
//                    : oursEnumValueService.getDisplayById(p.getDegreeType())));
            put("EDU_TYPE_CODE", toSafeString(p -> p.getLearnType() == null ? "-" : p.getLearnType()));
            //获取枚举值名称并对比成三医网需要的，全日制——普通全日制，成人教育——成人脱产，远程教育——网络教育，自学考试——自学考试和学历文凭考试，其他非全日制——其他
            put("EDU_TYPE_NAME", toSafeString(p -> {
                String eduType = p.getLearnType();
                if (eduType == null || eduType.isEmpty()) {
                    return "-";
                }
                /**
                 * 全日制	1
                 * 成人教育	2
                 * 远程教育	3
                 * 自学考试	4
                 * 其他非全日制	5
                 */
                if (eduType.equals("1")) {
                    return "普通全日制";
                } else if (eduType.equals("2")) {
                    return "成人脱产";
                } else if (eduType.equals("3")) {
                    return "网络教育";
                } else if (eduType.equals("4")) {
                    return "自学考试和学历文凭考试";
                } else {
                    return "其他非全日制";
                }
            }));


            put("MAJOR_CODE", toSafeString(p -> p.getMajor() == null ? " " : p.getMajor()));
            put("MAJOR_NAME", toSafeString(p -> p.getMajor() == null ? " " : p.getMajor()));
            put("DATA_CLCT_PRDR_NAME", toSafeString(p -> DATA_CLCT_PRDR_NAME));
            put("CRTE_TIME", toSafeString(p -> "2025-06-30 00:00:00"));
            put("UPDT_TIME", toSafeString(p -> p.getModifyTime() == null ? " " : p.getModifyTime().toString()));
            put("DELETED", toSafeString(p -> {
                Integer delFlag = p.getDelFlag();
                return (delFlag != null && delFlag == 1) ? "0" : "1";
            }));
            put("DELETED_TIME", toSafeString(p -> " "));
            put("VARIANT", toSafeString(p -> {
                String variant = jsonKeyValueTool.getValueByKey(p.getCustomFields(), "person_l5u6zqdd");
                return variant == null ? " " : variant;
            }));
        }
    };

    /**
     * 反射设置OraclePersonEduInfo属性（字段名需与OraclePersonEduInfo属性一致，支持下划线转驼峰）
     * String类型赋值为字符串，Date/BigDecimal类型空字符串赋null，日期自动识别格式
     */
    public void setOracleField(OraclePersonEduInfo oracle, String field, String value) {
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
