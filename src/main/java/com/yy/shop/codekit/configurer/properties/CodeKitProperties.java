package com.yy.shop.codekit.configurer.properties;

import com.yy.shop.codekit.common.exception.CodeMode;

/**
 * 描述: code kit 所有配置项
 *
 * @author 钟超 mailto:zhongchao1@yy.com
 * @version 创建时间：2020/11/3 2:09 下午
 */
public class CodeKitProperties {

    private static CodeKitProperties INSTANCE;

    private CodeMode mode;

    private String pkg;

    private String entityName;

    private String dalPkg;

    public synchronized static CodeKitProperties instance() {
        if (INSTANCE == null) {
            INSTANCE = new CodeKitProperties();
        }
        return INSTANCE;
    }

    private JdbcProperties jdbc;
    private TableProperties table;

    public CodeMode getMode() {
        return mode;
    }

    public void setMode(CodeMode mode) {
        this.mode = mode;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getDalPkg() {
        return dalPkg;
    }

    public void setDalPkg(String dalPkg) {
        this.dalPkg = dalPkg;
    }

    public JdbcProperties getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcProperties jdbc) {
        this.jdbc = jdbc;
    }

    public TableProperties getTable() {
        return table;
    }

    public void setTable(TableProperties table) {
        this.table = table;
    }
}
