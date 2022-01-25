package com.yy.shop.codekit.parser.impl.clazz.dal;

import com.yy.shop.codekit.analyzer.JavaFileAnalyzer;
import com.yy.shop.codekit.common.utils.JavaUtils;
import com.yy.shop.codekit.common.utils.MicroFileUtils;
import com.yy.shop.codekit.configurer.properties.CodeKitProperties;
import com.yy.shop.codekit.parser.impl.clazz.AbstractClazzCodeParserImpl;
import com.yy.shop.codekit.parser.request.EntityRequest;
import com.yy.shop.codekit.parser.request.FieldRequest;
import com.yy.shop.codekit.parser.request.Request;
import com.yy.shop.codekit.parser.request.converter.FieldRequestConverter;

import java.util.ArrayList;
import java.util.List;



/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/24
 * @since 1.0
 */
public class DoCodeParserImpl extends AbstractClazzCodeParserImpl<EntityRequest> {

    private final static String childPkg = "dal.entity";

    public DoCodeParserImpl() {
        super(childPkg, "Entity", "DO.java", true);
    }


    @Override
    protected void perGenerate(Request request) {
        super.t = request.getEntity();
    }

    @Override
    public void generate(CodeKitProperties properties, Request request) {
        perGenerate(request);
        // 构建参数
        buildRequest(properties, request);

        // 获取绝对路径
        String filePath = super.getPath();

        // 获取原序列化id
        long serialVersionUID = readSerialVersionUID();

        // 覆盖生成文件. 默认serialVersionUID=-1L
        write(request);

        // 如果序列化id=-1，需要重新生成
        if (serialVersionUID == -1L) {
            serialVersionUID = JavaFileAnalyzer.generateUID(filePath);
        }

        // 写入序列化id
        List<String> lines = MicroFileUtils.readLines(filePath);
        int serialVersionLineNumber = 0;
        if (lines != null) {
            for (String line : lines) {
                if (line.contains("implements Serializable")) {
                    serialVersionLineNumber = lines.indexOf(line);
                    break;
                }
            }

            if (serialVersionLineNumber > 0) {
                lines.add(++serialVersionLineNumber, "");
                lines.add(++serialVersionLineNumber, String.format("    private static final long serialVersionUID = %sL;", serialVersionUID));
                MicroFileUtils.writeLines(filePath, lines);
            }
        }
        System.out.println(filePath);
    }


    private long readSerialVersionUID() {
        String line = MicroFileUtils.readLineByRegexp(super.getPath(), "serialVersionUID");
        if (line == null) {
            return -1;
        }

        return Long.valueOf(line.substring(line.lastIndexOf("=")+2, line.lastIndexOf("L")));
    }

    @Override
    protected void buildRequest(CodeKitProperties properties, Request request) {

        super.buildRequest(properties, request);
        if (properties.getDalPkg() != null) {
            request.getEntity().setPkg(properties.getDalPkg() + ".entity");
            request.getEntity().setPath(JavaUtils.convertPackageToPath(request.getEntity().getPkg()));
        }
        request.getEntity().setSimpleName(properties.getEntityName());
        request.getEntity().setFields(FieldRequestConverter.convert(properties.getMode(), properties.getTable().getFields()));

        List<String> importStatements = new ArrayList<>();
        for (FieldRequest field : request.getEntity().getFields()) {
            if (JavaUtils.isLang(field.getJavaFullType())) {
                continue;
            }

            String statement = String.format("import %s;", field.getJavaFullType());
            if (!importStatements.contains(statement) ) {
                importStatements.add(statement);
            }
        }
        request.getEntity().setImportStatements(importStatements);
    }
}
