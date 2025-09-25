package com.springbootTz.ZNYY.mapper;

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
            put("GRADUAT_SCH", toSafeString(p -> p.getSchool() == null ? " " : p.getSchool()));
            put("ENR_DATE", toSafeString(p -> p.getStartTime() == null ? " " : p.getStartTime()));
            put("GRADUAT_DATE", toSafeString(p -> p.getEndTime() == null ? " " : p.getEndTime()));
            put("EDU_BACKGROUND_CODE", toSafeString(p -> p.getEducationType() == null ? " " : p.getEducationType()));
            put("EDU_BACKGROUND_NAME", toSafeString(p -> p.getEducationType() == null ? " "
                    : oursEnumValueService.getDisplayById(p.getEducationType())));
            put("DEGREE_CODE", toSafeString(p -> p.getDegreeType() == null ? " " : p.getDegreeType()));
            //如果枚举值是“未取得学位”——无
            put("DEGREE_NAME", toSafeString(p -> {
                String degreeType = p.getDegreeType();
                if (degreeType == null || degreeType.isEmpty()) {
                    return " ";
                }
                String degreeName = oursEnumValueService.getDisplayById(degreeType);
                if (degreeName == null || degreeName.isEmpty()) {
                    return " ";
                }
                if (degreeName.equals("未取得学位")) {
                    return "无";
                }
                return degreeName;
            }));

//            put("DEGREE_NAME", toSafeString(p -> p.getDegreeType() == null ? " "
//                    : oursEnumValueService.getDisplayById(p.getDegreeType())));
            put("EDU_TYPE_CODE", toSafeString(p -> p.getLearnType() == null ? " " : p.getLearnType()));
            //获取枚举值名称并对比成三医网需要的，全日制——普通全日制，成人教育——成人脱产，远程教育——网络教育，自学考试——自学考试和学历文凭考试，其他非全日制——其他
            put("EDU_TYPE_NAME", toSafeString(p -> {
                String eduType = p.getLearnType();
                if (eduType == null || eduType.isEmpty()) {
                    return " ";
                }
                String eduTypeName = oursEnumValueService.getDisplayById(eduType);
                if (eduTypeName == null || eduTypeName.isEmpty()) {
                    return " ";
                }
                if (eduTypeName.equals("全日制")) {
                    return "普通全日制";
                } else if (eduTypeName.equals("成人教育")) {
                    return "成人脱产";
                } else if (eduTypeName.equals("远程教育")) {
                    return "网络教育";
                } else if (eduTypeName.equals("自学考试")) {
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
