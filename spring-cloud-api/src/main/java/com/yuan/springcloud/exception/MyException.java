package com.yuan.springcloud.exception;

import lombok.Data;

/**
 * 自定义异常类
 */
//@Data
public class MyException extends Exception {

    private String message;

    public MyException(String message) {
        super(message);
        this.message = message;
    }

}
