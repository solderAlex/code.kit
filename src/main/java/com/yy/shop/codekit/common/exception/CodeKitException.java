package com.yy.shop.codekit.common.exception;

/**
 * 描述: 异常
 *
 * @author 钟超 mailto:zhongchao1@yy.com
 * @version 创建时间：2020/11/3 1:59 下午
 */
public class CodeKitException extends RuntimeException {

    public CodeKitException() {
        super();
    }

    public CodeKitException(String message) {
        super(message);
    }

    public CodeKitException(String message, Throwable cause) {
        super(message, cause);
    }

    public CodeKitException(Throwable cause) {
        super(cause);
    }

    protected CodeKitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
