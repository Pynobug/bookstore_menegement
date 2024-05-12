package com.fby.store.service.ex;

/** 用户名被占用的异常 */
public class UsernameOccupiedException extends ServiceException{
    public UsernameOccupiedException() {
        super();
    }

    public UsernameOccupiedException(String message) {
        super(message);
    }

    public UsernameOccupiedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameOccupiedException(Throwable cause) {
        super(cause);
    }

    protected UsernameOccupiedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
