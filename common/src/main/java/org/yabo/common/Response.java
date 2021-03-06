package org.yabo.common;

import java.io.Serializable;

public class Response implements Serializable {
    private Integer code;
    private String message;
    private Object data;

    public Response() {
        code = Code.SUCCESS;
        message = "SUCCESS";
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
