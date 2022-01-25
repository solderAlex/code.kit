package com.yy.shop.codekit.parser.impl.clazz.dal;


import com.yy.shop.codekit.common.utils.JavaUtils;
import com.yy.shop.codekit.configurer.properties.CodeKitProperties;
import com.yy.shop.codekit.parser.impl.clazz.AbstractClazzCodeParserImpl;
import com.yy.shop.codekit.parser.request.ExtMapperRequest;
import com.yy.shop.codekit.parser.request.Request;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/24
 * @since 1.0
 */
public class ExtMapperCodeParserImpl extends AbstractClazzCodeParserImpl<ExtMapperRequest> {

    public ExtMapperCodeParserImpl() {
        super("dal.mapper", "ExtMapper", "ExtMapper.java", false);
    }

    @Override
    protected void perGenerate(Request request) {
        super.t = request.getExtMapper();
    }

    @Override
    protected void buildRequest(CodeKitProperties properties, Request request) {
        super.buildRequest(properties, request);
        if (properties.getDalPkg() != null) {
            request.getExtMapper().setPkg(properties.getDalPkg() + ".mapper");
            request.getExtMapper().setPath(JavaUtils.convertPackageToPath(request.getExtMapper().getPkg()));
        }
    }
}
