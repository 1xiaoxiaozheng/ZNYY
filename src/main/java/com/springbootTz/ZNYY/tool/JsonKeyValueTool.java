package com.springbootTz.ZNYY.tool;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JsonKeyValueTool {
    private static final Logger logger = LoggerFactory.getLogger(JsonKeyValueTool.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 从JSON字符串中获取指定key的value，若为null或不存在则返回空字符串
     * 
     * @param jsonStr JSON字符串
     * @param key     需要查找的key
     * @return key对应的value，若为null或不存在则返回""
     */
    public static String getValueByKey(String jsonStr, String key) {
        if (jsonStr == null || key == null)
            return "";
        try {
            JsonNode node = objectMapper.readTree(jsonStr);
            JsonNode valueNode = node.get(key);
            if (valueNode == null || valueNode.isNull()) {
                return "";
            }
            return valueNode.asText("");
        } catch (Exception e) {
            logger.warn("解析JSON失败: {}", e.getMessage());
            return "";
        }
    }
}