package org.yabo.common;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> of(T t) {
        Result<T> result = new Result<>();
        result.data = t;
        return result;
    }

    public Result<T> message(String msg) {
        message = msg;
        return this;
    }

    public Result<T> code(Integer code) {
        this.code = code;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
