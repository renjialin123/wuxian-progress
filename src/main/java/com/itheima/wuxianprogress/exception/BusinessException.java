package com.itheima.wuxianprogress.exception;

import lombok.Getter;

/**
 * 自定义业务异常，运行时的异常
 */
@Getter
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;//定义一个错误码

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());//根据错误码读消息并返回
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);//指定错误码的同时指定消息
        this.code = errorCode.getCode();
    }

}
