package com.intelligent.basic.result;

import com.intelligent.basic.constant.ResultCodeConstant;
import lombok.Data;

@Data
public class ResponseMessage<T> {

    private Integer code;
    private String message;
    private T data;

    public ResponseMessage() {
    }

    public ResponseMessage(Integer code) {
        this.code = code;
    }

    public ResponseMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseMessage(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isOk() {
        return this.code == null ? false : this.code.equals(ResultCodeConstant.SUCCESS);
    }

}
