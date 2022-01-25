package com.yy.shop.codekit.parser.request.converter;

import com.yy.shop.codekit.common.exception.CodeMode;
import com.yy.shop.codekit.common.utils.JavaUtils;
import com.yy.shop.codekit.configurer.properties.FieldMappingProperties;
import com.yy.shop.codekit.parser.request.FieldRequest;
import com.yy.shop.codekit.sql.MysqlTypeConverter;
import com.yy.shop.codekit.sql.SqlKeywords;

import java.util.List;
import java.util.stream.Collectors;

/**
 * FieldRequest converter
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/5/5
 * @since 1.0
 */
public class FieldRequestConverter {

    public static List<FieldRequest> convert(CodeMode codeMode, List<FieldMappingProperties> properties) {
        return codeMode == CodeMode.CODE_BY_DB ? convertOfDb(properties) : convertOfDo(properties);
    }

    private static List<FieldRequest> convertOfDb(List<FieldMappingProperties> properties) {
        return properties.stream().map(FieldRequestConverter::convertOfDb).collect(Collectors.toList());
    }

    private static List<FieldRequest> convertOfDo(List<FieldMappingProperties> properties) {
        return properties.stream().map(FieldRequestConverter::convertOfDo).collect(Collectors.toList());
    }

    private static FieldRequest convertOfDb(FieldMappingProperties properties) {
        FieldRequest request = new FieldRequest();

        request.setField(JavaUtils.underlineToHump(properties.getColumn()));
        request.setComment(properties.getComment());
        request.setMysqlType(properties.getType());
        request.setJavaFullType(MysqlTypeConverter.mysqlToJavaType(properties.getType()));
        request.setJavaSimpleType(JavaUtils.getSimpleClassName(request.getJavaFullType()));

        request.setColumn(properties.getColumn());
        request.setFormatColumn("`" + request.getColumn() + "`");
        request.setDefine(SqlKeywords.getDefine(request.getField(), request.getJavaFullType(), request.getComment()));
        return request;
    }

    private static FieldRequest convertOfDo(FieldMappingProperties properties) {
        FieldRequest request = new FieldRequest();

        request.setField(properties.getField());
        request.setComment(properties.getComment());
        request.setJavaFullType(properties.getType());
        request.setJavaSimpleType(JavaUtils.getSimpleClassName(request.getJavaFullType()));

        request.setColumn(JavaUtils.humpToUnderline(request.getField()));
        request.setFormatColumn(SqlKeywords.isKeyword(request.getColumn()) ? "`" + request.getColumn() + "`" : request.getColumn());
        request.setDefine(SqlKeywords.getDefine(request.getField(), request.getJavaFullType(), request.getComment()));
        return request;
    }
}
