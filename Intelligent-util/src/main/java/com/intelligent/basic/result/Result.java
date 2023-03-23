package com.intelligent.basic.result;

import com.intelligent.basic.constant.ResultCodeConstant;

public class Result {

    public Result() {
    }

    public static <T> ResponseMessage<T> success() {
        return new ResponseMessage(ResultCodeConstant.SUCCESS);
    }

    public static <T> ResponseMessage<T> success(String message, T t) {
        return new ResponseMessage(ResultCodeConstant.SUCCESS, message, t);
    }

    public static <T> ResponseMessage<T> success(T t) {
        return new ResponseMessage(ResultCodeConstant.SUCCESS, (String)null, t);
    }

    public static <T> ResponseMessage<T> fail() {
        return new ResponseMessage(ResultCodeConstant.FAIL);
    }

    public static <T> ResponseMessage<T> fail(Integer code) {
        return new ResponseMessage(code, (String)null, (Object)null);
    }

    public static <T> ResponseMessage<T> fail(Integer code, String message) {
        return new ResponseMessage(code, message, (Object)null);
    }

    public static <T> ResponseMessage<T> fail(Integer code, String message, T t) {
        return new ResponseMessage(code, message, t);
    }

    public static <T> ResponseMessage<T> unAuthorized(String message) {
        return fail(ResultCodeConstant.UN_AUTHORIZED, message);
    }

}
