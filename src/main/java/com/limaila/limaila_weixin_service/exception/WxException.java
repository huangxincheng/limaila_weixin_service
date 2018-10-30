package com.limaila.limaila_weixin_service.exception;

/**
 * Wx统一异常
 */
public class WxException extends RuntimeException {

    public WxException() {
        super();
    }


    public WxException(String message) {
        super(message);
    }


    public WxException(String message, Throwable cause) {
        super(message, cause);
    }


    public WxException(Throwable cause) {
        super(cause);
    }

    protected WxException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
