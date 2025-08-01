package com.springbootTz.ZNYY.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrgCodeConcatTool {

    @Autowired
    private OrgCodeQueryTool orgCodeQueryTool;

    /**
     * 根据org_name获取code，并拼接code+sys_prdr+code+original_id
     * 
     * @param org_name    机构名称
     * @param sys_prdr    系统标识
     * @param original_id 原始ID
     * @return 拼接后的字符串
     */
    public String concatCodeAndParams(String org_name, String sys_prdr, String original_id) {
        String code = orgCodeQueryTool.getCodeByDisplay(org_name);
        if (code == null) {
            return "";
        }
        return code + sys_prdr + original_id;
    }
}