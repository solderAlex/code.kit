package com.yy.shop.codekit.parser.impl.clazz.query;


import com.yy.shop.codekit.configurer.properties.CodeKitProperties;
import com.yy.shop.codekit.parser.impl.clazz.AbstractClazzCodeParserImpl;
import com.yy.shop.codekit.parser.request.PageQueryRequest;
import com.yy.shop.codekit.parser.request.Request;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/24
 * @since 1.0
 */
public class PageQueryCodeParserImpl extends AbstractClazzCodeParserImpl<PageQueryRequest> {

    public PageQueryCodeParserImpl() {
        super("model.query", "", "PageQuery.java", false);
    }


    @Override
    protected void perGenerate(Request request) {
        super.t = request.getPageQuery();
    }

    @Override
    protected void buildRequest(CodeKitProperties properties, Request request) {
        super.buildRequest(properties, request);
        t.setName("PageQuery");
    }
}
