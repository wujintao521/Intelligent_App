package com.intelligent.basic.exception;

import com.intelligent.basic.constant.ResultCodeConstant;
import lombok.Data;

@Data
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Integer code;
    private Object data;

    public ServiceException() {
        this.code = ResultCodeConstant.FAIL;
    }

    public ServiceException(String message) {
        super(message);
        this.code = ResultCodeConstant.FAIL;
    }

    public ServiceException(Throwable cause) {
        super(cause);
        this.code = ResultCodeConstant.FAIL;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.code = ResultCodeConstant.FAIL;
    }

    public ServiceException(String message, Throwable cause, Object data) {
        super(message, cause);
        this.code = ResultCodeConstant.FAIL;
        this.data = data;
    }

    public ServiceException(Integer code) {
        super("MessageCode:" + code);
        this.code = ResultCodeConstant.FAIL;
        this.code = code;
    }

    public ServiceException(Integer code, Object data) {
        this.code = ResultCodeConstant.FAIL;
        this.code = code;
        this.data = data;
    }

    public ServiceException(Integer code, String message, Object data) {
        super(message);
        this.code = ResultCodeConstant.FAIL;
        this.code = code;
        this.data = data;
    }

    public String toString() {
        return "ServiceException(code=" + this.getCode() + ", data=" + this.getData() + ")";
    }
}
