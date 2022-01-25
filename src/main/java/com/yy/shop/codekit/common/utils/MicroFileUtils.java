package com.yy.shop.codekit.common.utils;

import com.yy.shop.codekit.common.exception.CodeKitException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 简单的文件操作类
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/24
 * @since 1.0
 */
public class MicroFileUtils implements Serializable{

    private static final long serialVersionUID = 2728998880995336662L;

    public static void writeToFile(String filePath, String data, boolean isCover) {
        File file = new File(filePath);
        if (file.exists() && !isCover) {
            return;
        }

        try {
            forceCreateFile(file);
            FileUtils.writeStringToFile(file, data, "UTF-8");
        } catch (IOException e) {
            throw new CodeKitException("生成文件失败");
        }
    }

    private static void forceCreateFile(File file) {
        if (file.exists()) {
            return;
        }

        try {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            file.createNewFile();
        } catch (IOException ex) {
            throw new CodeKitException("创建文件失败");
        }
    }

    public static String readToString(String filePath) {
        try {
            InputStream inputStream = MicroFileUtils.class.getResourceAsStream(filePath);
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new CodeKitException("读取文件失败", e);
        }
    }

    public static String read(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }

        try {
            return FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            throw new CodeKitException("读取文件失败", e);
        }
    }

    public static List<String> readLines(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }

        try {
            return FileUtils.readLines(file, "utf-8");
        } catch (IOException e) {
            throw new CodeKitException("读取文件失败", e);
        }
    }

    public static void writeLines(String filePath, List<String> lines) {
        File file = new File(filePath);

        try {
            FileUtils.writeLines(file, lines);
        } catch (IOException e) {
            throw new CodeKitException("写入文件失败", e);
        }
    }

    public static String readLineByRegexp(String filePath, String regexp) {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }

        try {
            List<String> lines = FileUtils.readLines(file, "utf-8");

            Pattern p = Pattern.compile(regexp);
            for (String line : lines) {
                if (p.matcher(line).find()) {
                    return line;
                }
            }
            return null;
        } catch (IOException ex) {
            throw new CodeKitException("读取文件失败", ex);
        }
    }

}
