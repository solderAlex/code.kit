package com.yy.shop.codekit.common.constants;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;

/**
 * 描述: 常量
 *
 * @author 钟超 mailto:zhongchao1@yy.com
 * @version 创建时间：2020/11/3 2:01 下午
 */
public class Const {
    public final static String FILE_SEPARATOR = System.getProperty("file.separator");

    public final static String MAIN_PATH =  FILE_SEPARATOR + "src" + FILE_SEPARATOR + "main";

    public final static String JAVA_CODE_PATH = MAIN_PATH + FILE_SEPARATOR + "java";

    public final static String RESOURCE_DIRECTORY_PATH = MAIN_PATH + FILE_SEPARATOR + "resources";

    public final static String BEETL_DEPLOY_PATH = FILE_SEPARATOR + "beetl";

    public static String MODULE_PATH = "";

    public static Project currentProject;

    public static AnActionEvent event;
}
