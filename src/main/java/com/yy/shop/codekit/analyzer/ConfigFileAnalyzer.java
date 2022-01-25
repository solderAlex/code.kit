package com.yy.shop.codekit.analyzer;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 配置文件解析器
 *
 * @author 钟超 mailto:zhongchao1@yy.com
 * @version 创建时间：2020/11/3 2:04 下午
 */
public class ConfigFileAnalyzer {
    /**
     * 使用codekit.properties作为配置文件的后缀。
     * 在项目中可以存在多个codekit.properties文件
     */
    private final static String DEFAULT_CONFIG_PROFILE_SUFFIX = "codekit.properties";


    /**
     * 查找codekit.properties配置文件
     *
     * 如果currentFile为codekit.properties，那么直接返回。
     * 如果不是，则在项目中搜寻codekit.properties配置文件
     *
     * @param currentFile   当前的光标所在的文件，或者是鼠标点击停留的文件
     * @return
     */
    public static List<VirtualFile> search(Project project, VirtualFile currentFile) {
        // 存放所有config file
        List<VirtualFile> configFiles = new ArrayList<>();

        if (currentFile != null) {
            String fileName = currentFile.getName();
            if (StringUtils.endsWith(fileName, DEFAULT_CONFIG_PROFILE_SUFFIX)) {
                configFiles.add(currentFile);
                return configFiles;
            }
        }

        // 从所有的文件名中，检索出 codekit.properties文件
        List<String> configFileNames = pick(FilenameIndex.getAllFilenames(project));
        for (String fileName : configFileNames) {
            configFiles.addAll(FilenameIndex.getVirtualFilesByName(project, fileName, GlobalSearchScope.projectScope(project)));
        }

        return configFiles;
    }

    /**
     * 选择出codekit.properties文件
     *
     * @param allFileNames
     * @return
     */
    private static List<String> pick(String[] allFileNames) {
        List<String> configFileNames = new ArrayList<>();

        for (String fileName : allFileNames) {
            if (match(fileName)) {
                configFileNames.add(fileName);
            }
        }
        return configFileNames;
    }

    private static boolean match(String fileName) {
        return StringUtils.endsWith(fileName, DEFAULT_CONFIG_PROFILE_SUFFIX);
    }
}
