package com.yy.shop.codekit.parser.request;

/**
 * Field、Column映射
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/24
 * @since 1.0
 */
public class FieldRequest {

    /**
     * java字段
     */
    private String field;

    /**
     * 列名
     */
    private String column;

    /**
     * 格式化
     */
    private String formatColumn;

    /**
     * java 简写类型
     */
    private String javaSimpleType;

    /**
     * java 全名类型
     */
    private String javaFullType;

    /**
     * mysql 类型
     */
    private String mysqlType;

    /**
     * 注释
     */
    private String comment;

    /**
     * sql 建表字段定义语句
     */
    private String define;

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

    public String getFormatColumn() {
        return formatColumn;
    }

    public void setFormatColumn(String formatColumn) {
        this.formatColumn = formatColumn;
    }

    public String getJavaSimpleType() {
        return javaSimpleType;
    }

    public void setJavaSimpleType(String javaSimpleType) {
        this.javaSimpleType = javaSimpleType;
    }

    public String getJavaFullType() {
        return javaFullType;
    }

    public void setJavaFullType(String javaFullType) {
        this.javaFullType = javaFullType;
    }

    public String getMysqlType() {
        return mysqlType;
    }

    public void setMysqlType(String mysqlType) {
        this.mysqlType = mysqlType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDefine() {
        return define;
    }

    public void setDefine(String define) {
        this.define = define;
    }
}
