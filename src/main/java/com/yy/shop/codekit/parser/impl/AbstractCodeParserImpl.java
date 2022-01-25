package com.yy.shop.codekit.parser.impl;

import com.yy.shop.codekit.common.constants.Const;
import com.yy.shop.codekit.common.utils.MicroFileUtils;
import com.yy.shop.codekit.configurer.properties.CodeKitProperties;
import com.yy.shop.codekit.integration.BeetlParser;
import com.yy.shop.codekit.parser.CodeParser;
import com.yy.shop.codekit.parser.request.FileRequest;
import com.yy.shop.codekit.parser.request.Request;

/**
 * 代码生成器
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/24
 * @since 1.0
 */
public abstract class AbstractCodeParserImpl<T extends FileRequest> implements CodeParser {

    private String suffix;
    private boolean isCover;
    protected String templateName;
    protected T t;

    public AbstractCodeParserImpl(String suffix, String templateName, boolean isCover) {
        this.suffix = suffix;
        this.templateName = templateName;
        this.isCover = isCover;
    }

    @Override
    public void generate(CodeKitProperties properties, Request request) {
        perGenerate(request);
        // 构建参数
        buildRequest(properties, request);
        write(request);

    }

    /**
     * 执行前
     *
     * @param request
     */
    protected abstract void perGenerate(Request request);

    protected void write(Request request) {
        // 根据模板生成数据
        String codeData = BeetlParser.parse(Const.BEETL_DEPLOY_PATH + Const.FILE_SEPARATOR + templateName, request);

        // 写入文件
        MicroFileUtils.writeToFile(getPath(), codeData, isCover);
    }

    protected abstract String getPath();

    /**
     * 生成参数
     *
     * @return
     */
    protected void buildRequest(CodeKitProperties properties, Request request) {
        t.setName(properties.getEntityName() + suffix);
    }
}
