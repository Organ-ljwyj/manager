package com.lw.constant;

import lombok.Data;

/**
 * @author yujun.wu
 * @version 1.0
 * @create date 2020/12/19 17:41
 * @Description:WEB端响应返回CODE和描述
 */
public enum ResponseEnum {
    /**
     * 请求成功
     */
    SUCCESS(1, "success"),
    /**
     * 请求失败
     */
    Fail(0, "fail");

    private Integer code;
    private String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
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
}
