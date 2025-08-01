package com.springbootTz.ZNYY.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.dao.EmptyResultDataAccessException;

@Component
public class DepartmentQueryTool {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据部门ID查询机构名称
     * 
     * @param deptId 部门ID
     * @return 机构名称，查不到返回空字符串
     */
    public String getOrgNameByDeptId(String deptId) {
        try {
            String orderNum = jdbcTemplate.queryForObject(
                    "select order_num from ehr_org_department where id=?",
                    new Object[] { deptId }, String.class);
            if (orderNum == null) {
                return "";
            }
            if (orderNum.length() >= 3) {
                orderNum = orderNum.substring(0, 3);
            }
            return jdbcTemplate.queryForObject(
                    "select name from ehr_org_department where order_num=?",
                    new Object[] { orderNum }, String.class);
        } catch (EmptyResultDataAccessException e) {
            return "";
        } catch (Exception e) {
            // 其他异常也返回空字符串，不抛出
            return "";
        }
    }

    /**
     * 根据部门ID查询科室名称和科室代码
     * 
     * @param deptId 部门ID
     * @return DeptInfoResult，查不到返回空对象（name和orderNum都为""）
     */
    public DeptInfoResult getDeptInfoByDeptId(String deptId) {
        DeptInfoResult result = new DeptInfoResult();
        try {
            String orderNum = jdbcTemplate.queryForObject(
                    "select order_num from ehr_org_department where id=?",
                    new Object[] { deptId }, String.class);
            if (orderNum == null) {
                return result;
            }
            String name = jdbcTemplate.queryForObject(
                    "select name from ehr_org_department where order_num=?",
                    new Object[] { orderNum }, String.class);
            result.setName(name == null ? "" : name);
            result.setOrderNum(orderNum);
        } catch (Exception e) {
            // 查不到或异常都返回空对象
        }
        return result;
    }

    /**
     * 科室信息结果对象
     */
    public static class DeptInfoResult {
        private String name = "";
        private String orderNum = "";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(String orderNum) {
            this.orderNum = orderNum;
        }
    }
}