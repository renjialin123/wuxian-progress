package com.itheima.wuxianprogress.common;

import com.itheima.wuxianprogress.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 全局响应封装类
 *
 * @param <T>
 */
@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;//不确定data类型，用反泛型

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {

        this(code, data, "");
    }

    public BaseResponse(ErrorCode errorCode) {

        this(errorCode.getCode(), null, errorCode.getMessage());
    }
}
