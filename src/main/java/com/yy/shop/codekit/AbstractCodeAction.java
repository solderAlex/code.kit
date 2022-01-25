package com.yy.shop.codekit;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.yy.shop.codekit.analyzer.ConfigFileAnalyzer;
import com.yy.shop.codekit.common.constants.Const;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 描述: 启动类父类
 *
 * @author 钟超 mailto:zhongchao1@yy.com
 * @version 创建时间：2020/11/3 2:00 下午
 */
public abstract class AbstractCodeAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Const.event = event;
        // 获取项目信息, 如果未定义项目，则直接退出
        Project project = event.getData(PlatformDataKeys.PROJECT);
        if (project == null) {
            return;
        }
        Const.currentProject = project;

        VirtualFile currentFile = getFile(event.getDataContext());
        List<VirtualFile> codeKitFiles = ConfigFileAnalyzer.search(project, currentFile);

        if (codeKitFiles.isEmpty()) {
            Messages.showMessageDialog("缺少codekit.properties文件", "友情提示", Messages.getErrorIcon());
            return;
        }

        if (codeKitFiles.size() > 1) {
            Messages.showMessageDialog("请选择确定的codekit.properties文件执行", "友情提示", Messages.getWarningIcon());
        }

        VirtualFile codeKitFile = codeKitFiles.get(0);

        // 获取项目的文件信息
//        ProjectFileIndex index = ProjectRootManager.getInstance(project).getFileIndex();
//
//        // 获取当前文件所在的module
//        Module currentModule = index.getModuleForFile(codeKitFile);
//
//        if (currentModule == null) {
//            return;
//        }
//        System.out.println(currentModule.getModuleFilePath());
//        // 获取当前module所在的路径
//        Path modulePath = Paths.get(currentModule.getModuleFilePath()).getParent();
        Const.MODULE_PATH = codeKitFile.getParent().getParent().getParent().getParent().getPath();

        try {

            // 执行逻辑
            performed(codeKitFile);

            // 刷新project
            VirtualFileManager.getInstance().syncRefresh();

            Messages.showMessageDialog(project, "文件创建成功", "Code Kit提示", Messages.getInformationIcon());
        } catch (Exception ex) {
            Messages.showMessageDialog(ex.getMessage(), "错误提示", Messages.getErrorIcon());
        }
    }

    /**
     * 执行逻辑
     *
     * @param codeKitFile 配置文件
     */
    abstract void performed(VirtualFile codeKitFile);

    @Override
    public void update(AnActionEvent event) {
        String extension = getFileExtension(event.getDataContext());

        // 控制按钮的可操作。仅在properties文件内，允许操作
        event.getPresentation().setEnabled("properties".equals(extension));
        event.getPresentation().setVisible("properties".equals(extension));
    }

    private String getFileExtension(DataContext dataContext) {
        VirtualFile file = getFile(dataContext);
        return file == null ? null : file.getExtension();
    }

    private VirtualFile getFile(DataContext dataContext) {
        return DataKeys.VIRTUAL_FILE.getData(dataContext);
    }
}
