package com.yy.shop.codekit.configurer.properties;

/**
 * 字段 相关的配置信息
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/26
 * @since 1.0
 */
public class FieldMappingProperties {

    /**
     * 字段名
     */
    private String field;

    /**
     * 对应的数据库列
     */
    private String column;

    /**
     * 字段类型
     */
    private String type;

    /**
     * 注释
     */
    private String comment;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
