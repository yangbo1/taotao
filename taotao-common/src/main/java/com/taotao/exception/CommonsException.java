package com.taotao.exception;

/**
 * Created by 杨波 on 2017/3/16.
 */
public class CommonsException extends RuntimeException {
    private static final long serialVersionUID = 699978142734398943L;

    public CommonsException() {
        super();
    }

    public CommonsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonsException(Throwable cause) {
        super(cause);
    }

    public CommonsException(String message) {
        super(message);
    }
}
