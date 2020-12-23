package com.lw.bean;

import com.lw.constant.ResponseEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yujun.wu
 * @version 1.0
 * @create date 2020/12/19 17:19
 * @Description: WEB端统一返回对象
 */
@Data
public class ResultInfo {
    private final static ResultInfo DEFAULT_SUCCESS = new ResultInfo(ResponseEnum.SUCCESS);
    private final static ResultInfo DEFAULT_FAIL = new ResultInfo(ResponseEnum.Fail);
    /**
     * 响应返回状态码
     */
    @NotNull
    private Integer status;
    /**
     * 响应返回失败描述，成功则是空字符串
     */
    @NotBlank
    private String message;
    /**
     * 响应返回对象
     */
    private Object result;

    private ResultInfo(ResponseEnum responseEnum) {
        this(responseEnum.getCode(), responseEnum.getMessage(), null);
    }

    private ResultInfo(ResponseEnum responseEnum, Object result) {
        this(responseEnum.getCode(), responseEnum.getMessage(), result);
    }

    private ResultInfo(Integer status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public static ResultInfo success() {
        return DEFAULT_SUCCESS;
    }

    public static ResultInfo success(Object result) {
        return new ResultInfo(ResponseEnum.SUCCESS, result);
    }

    public static ResultInfo fail() {
        return DEFAULT_FAIL;
    }

    public static ResultInfo fail(String message) {
        return new ResultInfo(ResponseEnum.Fail.getCode(), message, null);
    }

    public static ResultInfo fail(Integer status, String message) {
        return new ResultInfo(status, message, null);
    }
}
