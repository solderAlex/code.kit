package com.yy.shop.codekit;

import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.yy.shop.codekit.common.exception.CodeMode;
import com.yy.shop.codekit.configurer.DbCodeKitProfileLoader;
import com.yy.shop.codekit.configurer.properties.CodeKitProperties;
import com.yy.shop.codekit.service.CodeService;
import com.yy.shop.codekit.service.impl.DbCodeServiceImpl;

/**
 * 描述: 入口类
 *
 * @author 钟超 mailto:zhongchao1@yy.com
 * @version 创建时间：2020/11/3 1:59 下午
 */
public class CodeByDbAction extends AbstractCodeAction {

    private final DbCodeKitProfileLoader loader = new DbCodeKitProfileLoader();
    private final CodeService codeService = new DbCodeServiceImpl();

    @Override
    void performed(VirtualFile codeKitFile) {
        // 读取配置
        loader.load(codeKitFile);

        // 设置模式
        CodeKitProperties.instance().setMode(CodeMode.CODE_BY_DB);

        codeService.generate();
    }
}
