package com.yy.shop.codekit.parser.file.xml;
import com.yy.shop.codekit.configurer.properties.CodeKitProperties;
import com.yy.shop.codekit.parser.file.AbstractXmlCodeParserImpl;
import com.yy.shop.codekit.parser.request.FieldRequest;
import com.yy.shop.codekit.parser.request.MapperXmlRequest;
import com.yy.shop.codekit.parser.request.Request;
import com.yy.shop.codekit.sql.SqlKeywords;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/24
 * @since 1.0
 */
public class MapperXmlParserImpl extends AbstractXmlCodeParserImpl<MapperXmlRequest> {

    public MapperXmlParserImpl() {
        super("Mapper", "Mapper.xml", true);
    }

    @Override
    protected void perGenerate(Request request) {
        super.t = request.getMapperXml();
    }

    @Override
    protected void buildRequest(CodeKitProperties properties, Request request) {

        super.buildRequest(properties, request);

        MapperXmlRequest mapperXmlRequest = (MapperXmlRequest) t;

        List<String> insertColumns = new ArrayList<>();
        List<String> insertValues = new ArrayList<>();

        for (FieldRequest fieldRequest : request.getEntity().getFields()) {
            if (!SqlKeywords.isIgnoreField(fieldRequest.getField())) {
                insertColumns.add(fieldRequest.getFormatColumn());
                insertValues.add(String.format("#{item.%s}", fieldRequest.getField()));
            }
        }

        List<String> formatColumns = request.getEntity().getFields().stream().map(FieldRequest::getFormatColumn).collect(Collectors.toList());
        mapperXmlRequest.setAllColumns(StringUtils.join(formatColumns, ", "));
        mapperXmlRequest.setInsertColumns(StringUtils.join(insertColumns, ", "));
        mapperXmlRequest.setInsertBatchValues(StringUtils.join(insertValues, ", "));

    }

}
