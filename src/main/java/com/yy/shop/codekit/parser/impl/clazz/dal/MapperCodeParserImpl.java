package com.yy.shop.codekit.parser.impl.clazz.dal;


import com.yy.shop.codekit.common.utils.JavaUtils;
import com.yy.shop.codekit.configurer.properties.CodeKitProperties;
import com.yy.shop.codekit.parser.impl.clazz.AbstractClazzCodeParserImpl;
import com.yy.shop.codekit.parser.request.MapperRequest;
import com.yy.shop.codekit.parser.request.Request;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/24
 * @since 1.0
 */
public class MapperCodeParserImpl extends AbstractClazzCodeParserImpl<MapperRequest> {

    public MapperCodeParserImpl() {
        super("dal.mapper.basic", "Mapper", "Mapper.java",true);
    }

    @Override
    protected void perGenerate(Request request) {
        super.t = request.getMapper();
    }

    @Override
    protected void buildRequest(CodeKitProperties properties, Request request) {
        super.buildRequest(properties, request);

        if (properties.getDalPkg() != null) {
            request.getMapper().setPkg(properties.getDalPkg() + ".mapper.basic");
            request.getMapper().setPath(JavaUtils.convertPackageToPath(request.getMapper().getPkg()));
        }

        // 获取主键id的类型
        request.getEntity()
            .getFields()
            .stream()
            .filter(e -> "id".equals(e.getField()))
            .findFirst()
            .ifPresent(idField -> request.getEntity()
                .setIdType(idField.getJavaSimpleType()));

    }
}
