package com.webbackend.webbackend1.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String log;

    /**
     * @author jinhaoxun
     * @description 构造器
     * @param code 异常状态码
     * @param log 异常打印日志
     * @param msg 异常返回信息
     */
    public CustomerException(Integer code, String log, String msg) {
        super(msg);
        this.code = code;
        this.log = log;
    }
}
