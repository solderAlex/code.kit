package com.yy.shop.codekit.sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/25
 * @since 1.0
 */
public class SqlKeywords {

    private static List<String> KEY_WORDS = new ArrayList<>();
    private static List<String> INSERT_IGNORE_FIELD = new ArrayList<>();
    private static Map<String, String> SPECIAL_COLUMN_DEFINES = new HashMap<>();
    private static Map<String, String> JAVA_SQL_MAPPING = new HashMap<>();

    private static String COLUMN_DEFINE_FORMAT = "%s not null default %s comment '%s'";

    static {
        KEY_WORDS.add("name");
        KEY_WORDS.add("desc");
        KEY_WORDS.add("interval");
        KEY_WORDS.add("begin");
        KEY_WORDS.add("end");
        KEY_WORDS.add("order");
        KEY_WORDS.add("by");
        KEY_WORDS.add("limit");
        KEY_WORDS.add("select");
        KEY_WORDS.add("update");
        KEY_WORDS.add("delete");
        KEY_WORDS.add("alter");
        KEY_WORDS.add("from");
        KEY_WORDS.add("between");
        KEY_WORDS.add("in");
        KEY_WORDS.add("add");

        INSERT_IGNORE_FIELD.add("createTime");
        INSERT_IGNORE_FIELD.add("updateTime");

        SPECIAL_COLUMN_DEFINES.put("id", "%s auto_increment comment '主键id'");
        SPECIAL_COLUMN_DEFINES.put("createTime", "%s not null default now() comment '创建时间'");
        SPECIAL_COLUMN_DEFINES.put("updateTime", "%s not null default now() on update current_timestamp comment '更新时间'");

        JAVA_SQL_MAPPING.put("java.lang.Integer", "int");
        JAVA_SQL_MAPPING.put("java.lang.Long", "bigint(20)");
        JAVA_SQL_MAPPING.put("java.lang.Byte", "tinyint(2)");
        JAVA_SQL_MAPPING.put("java.lang.Short", "smallint(4)");
        JAVA_SQL_MAPPING.put("java.lang.Double", "decimal(10,4");
        JAVA_SQL_MAPPING.put("java.lang.Float", "float");
        JAVA_SQL_MAPPING.put("java.lang.String", "varchar(50)");
        JAVA_SQL_MAPPING.put("java.util.Date", "timestamp");
    }

    public static boolean isKeyword(String word) {
        return KEY_WORDS.contains(word);
    }

    public static boolean isIgnoreField(String field) {
        return INSERT_IGNORE_FIELD.contains(field);
    }

    public static String getDefine(String field, String type, String comment) {
        String define = SPECIAL_COLUMN_DEFINES.get(field);
        if (define != null) {
            define = String.format(define, JAVA_SQL_MAPPING.get(type));
            return define;
        }

        switch (type) {
            case "java.lang.String":
                define = String.format(COLUMN_DEFINE_FORMAT, JAVA_SQL_MAPPING.get(type), "''", comment);
                break;
            case "java.util.Date":
                define = String.format(COLUMN_DEFINE_FORMAT, JAVA_SQL_MAPPING.get(type), "now()", comment);
                break;
            default:
                define = String.format(COLUMN_DEFINE_FORMAT, JAVA_SQL_MAPPING.get(type), "'0'", comment);
                break;
        }
        return define;
    }
}
