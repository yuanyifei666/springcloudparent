package com.yuan.springcloud.en;

/**
 * 自定义返回信息的枚举
 */

public enum ResultEnum {

    RESULT_SERVICE_DEPARTMENT_NOTNULL(400,"插入的数据为空!");

    private String message;
    private Integer status;
    private  ResultEnum(Integer status,String message){
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }
}
