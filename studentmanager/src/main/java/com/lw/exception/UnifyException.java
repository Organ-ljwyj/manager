package com.lw.exception;

/**
 * @author yujun.wu
 * @version 1.0
 * @create date 2020/12/20 22:27
 * @Description:系统返回的统一异常,其他所有异常必须实现该异常
 */
public class UnifyException extends Exception {
    public UnifyException() {
        super();
    }


    public UnifyException(String message) {
        super(message);
    }


    public UnifyException(String message, Throwable cause) {
        super(message, cause);
    }


    public UnifyException(Throwable cause) {
        super(cause);
    }


    protected UnifyException(String message, Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
