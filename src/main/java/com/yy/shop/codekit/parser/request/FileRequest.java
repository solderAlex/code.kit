package com.yy.shop.codekit.parser.request;

/**
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2020/6/1
 * @since 1.0
 */
public class FileRequest {

    /**
     * 文件名
     */
    private String name;

    /**
     * 路径
     */
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
