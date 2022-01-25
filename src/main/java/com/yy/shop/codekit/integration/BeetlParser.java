package com.yy.shop.codekit.integration;

import com.yy.shop.codekit.common.utils.MicroFileUtils;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.io.IOException;

/**
 * beetl 模板渲染组件
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/24
 * @since 1.0
 */
public class BeetlParser {

    private static final StringTemplateResourceLoader LOADER = new StringTemplateResourceLoader();
    private static final String PARAM_KEY = "p";
    private static GroupTemplate groupTemplate;

    static {
        try {
            groupTemplate = new GroupTemplate(LOADER, Configuration.defaultConfiguration());
        } catch (IOException e) {
            throw new RuntimeException("beetl加载错误");
        }
    }

    public static String parse(String templateFile, Object param) {
        Template template = groupTemplate.getTemplate(MicroFileUtils.readToString(templateFile));
        template.binding(PARAM_KEY, param);
        return template.render();
    }
}
