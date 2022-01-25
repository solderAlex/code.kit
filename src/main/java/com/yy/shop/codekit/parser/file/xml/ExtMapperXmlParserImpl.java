package com.yy.shop.codekit.parser.file.xml;

import com.yy.shop.codekit.parser.file.AbstractXmlCodeParserImpl;
import com.yy.shop.codekit.parser.request.ExtMapperXmlRequest;
import com.yy.shop.codekit.parser.request.Request;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/24
 * @since 1.0
 */
public class ExtMapperXmlParserImpl extends AbstractXmlCodeParserImpl<ExtMapperXmlRequest> {

    public ExtMapperXmlParserImpl() {
        super("ExtMapper", "ExtMapper.xml", false);
    }

    @Override
    protected void perGenerate(Request request) {
        super.t = request.getExtMapperXml();
    }
}
