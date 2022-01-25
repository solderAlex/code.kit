package com.yy.shop.codekit.analyzer;

import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.PsiClassImpl;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.siyeh.ig.fixes.SerialVersionUIDBuilder;
import com.yy.shop.codekit.common.constants.Const;
import com.yy.shop.codekit.common.exception.CodeKitException;
import com.yy.shop.codekit.configurer.properties.FieldMappingProperties;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 基于idea的java文件分析器
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/24
 * @since 1.0
 */
public class JavaFileAnalyzer {

    public static long generateUID(String path) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        // 正负号生成
        if (random.nextFloat() > 0.5F) {
            builder.append("-");
        }
        // 首位不能为0
        builder.append(random.nextInt(9) + 1);
        // 生成剩余位数
        do {
            builder.append(random.nextInt(10));
        } while (builder.length() < 18);
        return Long.valueOf(builder.toString());
    }

    public static List<FieldMappingProperties> analyze(String className) {
        PsiFile[] psiFiles = FilenameIndex.getFilesByName(Const.currentProject, className + ".java", GlobalSearchScope.projectScope(Const.currentProject));

        if (psiFiles.length == 0) {
            throw new CodeKitException("项目中不存在唯一的java文件：" + className + "不存在");
        }

        if (psiFiles.length > 1) {
            throw new CodeKitException("项目中存在多个的java文件：" + className);
        }
        PsiFile pojoFile = psiFiles[0];

        PsiField[] psiFields = null;
        for (PsiElement element : pojoFile.getChildren()) {
            if (element instanceof PsiClassImpl) {
                psiFields = ((PsiClassImpl)element).getAllFields();
                break;
            }
        }
        if (psiFields == null) {
            return Collections.emptyList();
        }

        List<FieldMappingProperties> fields = new ArrayList<>();
        for (PsiField psiField : psiFields) {
            FieldMappingProperties field = new FieldMappingProperties();
            if(!"serialVersionUID".equals(psiField.getName())) {
                field.setField(psiField.getName());
                field.setType(psiField.getType().getCanonicalText());
                field.setComment(getFieldComment(psiField.getText()));
                fields.add(field);
            }
        }
        return fields;
    }

    private static String getFieldComment(String text) {
        int index = StringUtils.indexOf(text, "/**");
        int last = StringUtils.indexOf(text, "*/");

        if (index > -1 && last > -1) {
            return StringUtils.substring(text, index + 3, last).replaceAll("\\*", "").trim();
        }
        return "";
    }
}
