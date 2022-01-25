package com.yy.shop.codekit.configurer.properties;

import java.util.List;

/**
 * 表相关的配置信息
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/26
 * @since 1.0
 */
public class TableProperties {

    /**
     * 表名。全名
     */
    private String name;

    /**
     * 注释信息，用于do生成sql时使用
     */
    private String comment;

    /**
     * 字段信息
     */
    private List<FieldMappingProperties> fields;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<FieldMappingProperties> getFields() {
        return fields;
    }

    public void setFields(List<FieldMappingProperties> fields) {
        this.fields = fields;
    }
}
