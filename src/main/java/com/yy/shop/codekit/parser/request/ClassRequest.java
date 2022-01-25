package com.yy.shop.codekit.parser.request;

import java.util.List;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2020/6/1
 * @since 1.0
 */
public class ClassRequest extends FileRequest {

    /**
     * 变量名
     */
    private String varName;

    /**
     * 包
     */
    private String pkg;

    /**
     * 需要import的语句
     */
    private List<String> importStatements;

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public List<String> getImportStatements() {
        return importStatements;
    }

    public void setImportStatements(List<String> importStatements) {
        this.importStatements = importStatements;
    }
}
