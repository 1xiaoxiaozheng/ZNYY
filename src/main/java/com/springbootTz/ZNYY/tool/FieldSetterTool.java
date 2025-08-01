package com.springbootTz.ZNYY.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通用字段设置工具类，避免使用PropertyDescriptor
 */
public class FieldSetterTool {
    private static final Logger logger = LoggerFactory.getLogger(FieldSetterTool.class);

    /**
     * 设置对象字段值
     * 
     * @param target    目标对象
     * @param fieldName 字段名（支持下划线转驼峰）
     * @param value     字段值
     */
    public static void setField(Object target, String fieldName, String value) {
        try {
            String camelFieldName = toCamelCase(fieldName);
            Field field = findField(target.getClass(), camelFieldName);
            if (field == null) {
                logger.warn("Field not found: {} in class {}", camelFieldName, target.getClass().getSimpleName());
                return;
            }

            field.setAccessible(true);
            Class<?> fieldType = field.getType();

            if (fieldType == String.class) {
                // 确保空字符串不会被Oracle视为NULL
                field.set(target, value == null ? " " : (value.trim().isEmpty() ? " " : value));
            } else if (fieldType == Date.class) {
                if (value == null || value.trim().isEmpty()) {
                    field.set(target, null);
                } else {
                    Date date = parseDate(value);
                    field.set(target, date);
                }
            } else if (fieldType == BigDecimal.class) {
                if (value == null || value.trim().isEmpty()) {
                    field.set(target, null);
                } else {
                    field.set(target, new BigDecimal(value));
                }
            } else if (fieldType == Long.class) {
                if (value == null || value.trim().isEmpty()) {
                    field.set(target, 0L);
                } else {
                    field.set(target, Long.valueOf(value));
                }
            } else if (fieldType == Integer.class) {
                if (value == null || value.trim().isEmpty()) {
                    field.set(target, 0);
                } else {
                    field.set(target, Integer.valueOf(value));
                }
            } else {
                // 其他类型直接赋值
                field.set(target, value);
            }
        } catch (Exception e) {
            logger.warn("Failed to set field {} with value {}: {}", fieldName, value, e.getMessage());
        }
    }

    /**
     * 查找字段（包括父类字段）
     */
    private static Field findField(Class<?> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null) {
                return findField(superClass, fieldName);
            }
            return null;
        }
    }

    /**
     * 解析日期字符串
     */
    private static Date parseDate(String dateStr) {
        try {
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            SimpleDateFormat[] possibleFormats = {
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
                    new SimpleDateFormat("yyyy-MM-dd"),
                    new SimpleDateFormat("yyyy/MM/dd"),
                    new SimpleDateFormat("yyyyMMdd"),
                    new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", java.util.Locale.US)
            };

            for (SimpleDateFormat format : possibleFormats) {
                try {
                    Date parsedDate = format.parse(dateStr);
                    // 将解析后的日期重新格式化为标准格式
                    return outputFormat.parse(outputFormat.format(parsedDate));
                } catch (Exception e) {
                    continue;
                }
            }
            logger.warn("Failed to parse date: {}", dateStr);
            return null;
        } catch (Exception e) {
            logger.warn("Failed to parse date: {}", dateStr);
            return null;
        }
    }

    /**
     * 下划线转驼峰
     */
    private static String toCamelCase(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
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

    /**
     * 设置对象字段值
     * 
     * @param target    目标对象
     * @param fieldName 字段名（支持下划线转驼峰）
     * @param value     字段值
     */
    public static void setField(Object target, String fieldName, Object value) {
        try {
            String camelFieldName = toCamelCase(fieldName);
            Field field = target.getClass().getDeclaredField(camelFieldName);
            field.setAccessible(true);
            Class<?> fieldType = field.getType();

            if (value == null) {
                field.set(target, null);
                return;
            }

            if (fieldType == Date.class) {
                if (value instanceof Date) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    field.set(target, sdf.parse(sdf.format((Date) value)));
                } else if (value instanceof String) {
                    String dateStr = ((String) value).trim();
                    if (dateStr.isEmpty()) {
                        field.set(target, null);
                        return;
                    }
                    Date parsedDate = parseDate(dateStr);
                    field.set(target, parsedDate);
                } else {
                    field.set(target, null);
                }
            } else if (fieldType == String.class) {
                field.set(target, value.toString());
            } else if (fieldType == Long.class || fieldType == long.class) {
                if (value instanceof Number) {
                    field.set(target, ((Number) value).longValue());
                } else {
                    try {
                        field.set(target, Long.parseLong(value.toString().trim()));
                    } catch (NumberFormatException e) {
                        field.set(target, 0L);
                    }
                }
            } else if (fieldType == Integer.class || fieldType == int.class) {
                if (value instanceof Number) {
                    field.set(target, ((Number) value).intValue());
                } else {
                    try {
                        field.set(target, Integer.parseInt(value.toString().trim()));
                    } catch (NumberFormatException e) {
                        field.set(target, 0);
                    }
                }
            } else {
                field.set(target, value);
            }
        } catch (Exception e) {
            logger.warn("Failed to set field: " + fieldName + ", value: " + value, e);
        }
    }
}