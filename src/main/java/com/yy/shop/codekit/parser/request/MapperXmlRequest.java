package com.yy.shop.codekit.parser.request;

/**
 * mapper.java 中的文件参数
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/24
 * @since 1.0
 */
public class MapperXmlRequest extends FileRequest {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 所有列 ，一行显示
     */
    private String allColumns;

    /**
     * 插入列 ，一行显示
     */
    private String insertColumns;

    /**
     * 插入列值 ，一行显示
     */
    private String insertBatchValues;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAllColumns() {
        return allColumns;
    }

    public void setAllColumns(String allColumns) {
        this.allColumns = allColumns;
    }

    public String getInsertColumns() {
        return insertColumns;
    }

    public void setInsertColumns(String insertColumns) {
        this.insertColumns = insertColumns;
    }

    public String getInsertBatchValues() {
        return insertBatchValues;
    }

    public void setInsertBatchValues(String insertBatchValues) {
        this.insertBatchValues = insertBatchValues;
    }
}
