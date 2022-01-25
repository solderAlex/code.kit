package com.yy.shop.codekit.parser;

import com.yy.shop.codekit.configurer.properties.CodeKitProperties;
import com.yy.shop.codekit.parser.request.Request;

/**
 * 描述: 代码生成器
 *
 * @author 钟超 mailto:zhongchao1@yy.com
 * @version 创建时间：2020/11/3 2:18 下午
 */
public interface CodeParser {

    /**
     * 生成代码文件
     *
     */
    void generate(CodeKitProperties properties, Request request);
}
