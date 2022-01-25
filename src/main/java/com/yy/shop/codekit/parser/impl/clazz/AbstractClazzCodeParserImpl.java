package com.yy.shop.codekit.parser.impl.clazz;

import com.yy.shop.codekit.common.constants.Const;
import com.yy.shop.codekit.common.utils.JavaUtils;
import com.yy.shop.codekit.configurer.properties.CodeKitProperties;
import com.yy.shop.codekit.parser.impl.AbstractCodeParserImpl;
import com.yy.shop.codekit.parser.request.ClassRequest;
import com.yy.shop.codekit.parser.request.Request;
import org.apache.commons.lang3.StringUtils;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2020/6/1
 * @since 1.0
 */
public abstract class AbstractClazzCodeParserImpl<T extends ClassRequest> extends AbstractCodeParserImpl {

    private String pkg;

    public AbstractClazzCodeParserImpl(String pkg, String suffix, String templateName, boolean isCover) {
        super(suffix, templateName, isCover);
        this.pkg = pkg;
    }

    /**
     * 生成参数
     *
     * @return
     */
    @Override
    protected void buildRequest(CodeKitProperties properties, Request request) {
        super.buildRequest(properties, request);

        ClassRequest classRequest = (ClassRequest) t;
        classRequest.setPkg(properties.getPkg() + "." + this.pkg);
        classRequest.setVarName(StringUtils.uncapitalize(classRequest.getName()));
        classRequest.setPath(JavaUtils.convertPackageToPath(classRequest.getPkg()));
    }

    @Override
    protected String getPath() {
        String suffix = templateName.substring(templateName.indexOf("."));
        return Const.MODULE_PATH + Const.JAVA_CODE_PATH + Const.FILE_SEPARATOR + t.getPath() + Const.FILE_SEPARATOR
            + t.getName() + suffix;
    }
}
