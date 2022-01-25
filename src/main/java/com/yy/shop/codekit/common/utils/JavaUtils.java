package com.yy.shop.codekit.common.utils;

import com.yy.shop.codekit.common.constants.Const;
import org.apache.commons.lang3.StringUtils;

/**
 * java 工具类
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/24
 * @since 1.0
 */
public class JavaUtils {

    public static String convertPackageToPath(String packagePath) {
        return StringUtils.replace(packagePath, ".", Const.FILE_SEPARATOR);
    }

    public static String humpToUnderline(String data) {
        StringBuilder sb = new StringBuilder(data);
        int temp = 0;
        if (!data.contains("_")) {
            for (int i = 0; i < data.length(); i++) {
                if (Character.isUpperCase(data.charAt(i))) {
                    sb.insert(i + temp, "_");
                    temp += 1;
                }
            }
        }
        return StringUtils.lowerCase(sb.toString());
    }

    public static String humpToLine(String data) {
        StringBuilder sb = new StringBuilder(data);
        int temp = 0;
        if (!data.contains("-")) {
            for (int i = 0; i < data.length(); i++) {
                if (Character.isUpperCase(data.charAt(i))) {
                    sb.insert(i + temp, "-");
                    temp += 1;
                }
            }
        }
        return StringUtils.lowerCase(sb.toString());
    }

    public static String underlineToHump(String data) {
        if (StringUtils.isBlank(data)) {
            return "";
        }

        if (!StringUtils.contains(data, "_")) {
            return data;
        }

        StringBuilder result = new StringBuilder();
        // 用下划线将原始字符串分割
        String camels[] = data.split("_");
        for (String camel :  camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    public static boolean isLang(String fullClassName) {
        return StringUtils.startsWith(fullClassName, "java.lang");
    }

    public static String getSimpleClassName(String fullClassName) {
        try {
            return Class.forName(fullClassName).getSimpleName();
        } catch (ClassNotFoundException e) {
            //
        }
        return null;
    }
}
