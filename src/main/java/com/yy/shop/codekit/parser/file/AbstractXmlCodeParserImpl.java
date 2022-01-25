package com.yy.shop.codekit.parser.file;

import com.yy.shop.codekit.common.constants.Const;
import com.yy.shop.codekit.configurer.properties.CodeKitProperties;
import com.yy.shop.codekit.parser.impl.AbstractCodeParserImpl;
import com.yy.shop.codekit.parser.request.ExtMapperXmlRequest;
import com.yy.shop.codekit.parser.request.MapperXmlRequest;
import com.yy.shop.codekit.parser.request.Request;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2020/6/1
 * @since 1.0
 */
public abstract class AbstractXmlCodeParserImpl<T extends MapperXmlRequest> extends AbstractCodeParserImpl {

    public AbstractXmlCodeParserImpl(String suffix, String templateName, boolean isCover) {
        super(suffix, templateName, isCover);
    }

    /**
     * 生成参数
     *
     * @return
     */
    @Override
    protected void buildRequest(CodeKitProperties properties, Request request) {
        super.buildRequest(properties, request);

        MapperXmlRequest mapperXmlRequest = (MapperXmlRequest) t;
        mapperXmlRequest.setTableName(properties.getTable().getName());
    }

    @Override
    protected String getPath() {
        String suffix = templateName.substring(templateName.indexOf("."));

        String mapperPath = Const.MODULE_PATH + Const.RESOURCE_DIRECTORY_PATH + Const.FILE_SEPARATOR + "mapper" + Const.FILE_SEPARATOR;

        if (!(t instanceof ExtMapperXmlRequest)) {
            mapperPath += "basic" + Const.FILE_SEPARATOR;
        }
        return mapperPath + t.getName() + suffix;
    }
}
