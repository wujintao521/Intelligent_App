package com.commos.utils;

import com.commos.eums.Status;
import lombok.Data;

@Data
public class ResultVO{
    // 状态码
    private Integer code;
    // 消息
    private String message;
    // 数据对象
    private Object result;

    private Integer total;

    /**
     * 无参构造器
     */
    public ResultVO() {
        super();
    }

    public ResultVO(Status status) {
        super();
        this.code = status.code;
        this.message = status.message;
    }

    public ResultVO result(Object result) {
        this.result = result;
        return this;
    }

    public ResultVO message(String message) {
        this.message = message;
        return this;
    }
    public ResultVO total(Integer total) {
        this.total = total;
        return this;
    }

    /**
     * 只返回状态，状态码，消息
     *
     * @param code
     * @param message
     */
    public ResultVO(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    /**
     * 只返回状态，状态码，数据对象
     *
     * @param code
     * @param result
     */
    public ResultVO(Integer code, Object result) {
        super();
        this.code = code;
        this.result = result;
    }

    /**
     * 返回全部信息即状态，状态码，消息，数据对象
     *
     * @param code
     * @param message
     * @param result
     */
    public ResultVO(Integer code, String message, Object result) {
        super();
        this.code = code;
        this.message = message;
        this.result = result;
    }
}
