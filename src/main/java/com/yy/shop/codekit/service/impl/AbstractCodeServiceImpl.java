package com.yy.shop.codekit.service.impl;

import com.yy.shop.codekit.configurer.properties.CodeKitProperties;
import com.yy.shop.codekit.parser.CodeParser;
import com.yy.shop.codekit.parser.file.xml.ExtMapperXmlParserImpl;
import com.yy.shop.codekit.parser.file.xml.MapperXmlParserImpl;
import com.yy.shop.codekit.parser.impl.clazz.dal.DoCodeParserImpl;
import com.yy.shop.codekit.parser.impl.clazz.dal.ExtMapperCodeParserImpl;
import com.yy.shop.codekit.parser.impl.clazz.dal.MapperCodeParserImpl;
import com.yy.shop.codekit.parser.impl.clazz.query.PageQueryCodeParserImpl;
import com.yy.shop.codekit.parser.request.Request;
import com.yy.shop.codekit.service.CodeService;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成服务 基本类
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/5/5
 * @since 1.0
 */
public abstract class AbstractCodeServiceImpl implements CodeService {

    protected List<CodeParser> codeParsers = new ArrayList<>();

    public AbstractCodeServiceImpl() {
        codeParsers.add(new DoCodeParserImpl());
        codeParsers.add(new MapperCodeParserImpl());
        codeParsers.add(new ExtMapperCodeParserImpl());

        codeParsers.add(new MapperXmlParserImpl());
        codeParsers.add(new ExtMapperXmlParserImpl());
    }

    @Override
    public void generate() {
        Request request = new Request();
        codeParsers.forEach(e -> e.generate(CodeKitProperties.instance(), request));
    }
}
