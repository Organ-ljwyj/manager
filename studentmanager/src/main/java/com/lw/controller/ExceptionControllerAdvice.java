package com.lw.controller;

import com.lw.bean.ResultInfo;
import com.lw.exception.UnifyException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yujun.wu
 * @version 1.0
 * @create date 2020/12/21 23:10
 * @Description: Controller层全局异常捕获
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    /**
     *  捕获所有validation校验不通过的字段组转后返回
     *
     * @param bindException validation校验失败抛出的异常
     * @return
     */
    @ExceptionHandler(value = {BindException.class})
    public ResultInfo MethodArgumentNotValidExceptionHandler(BindException bindException) {
        StringBuilder errorInfo = new StringBuilder();
        BindingResult bindingResult = bindException.getBindingResult();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorInfo.append(fieldError.getField()).append(" :").append(fieldError.getDefaultMessage()).append("、");
        }
        // 然后提取错误提示信息进行返回.
        return ResultInfo.fail(errorInfo.toString());
    }

    /**
     *  捕获定义的全局异常类
     *
     * @param unifyException 定义的全局异常类
     * @return
     */
    @ExceptionHandler(value = {UnifyException.class})
    public ResultInfo UnifyExceptionHandler(UnifyException unifyException) {

        // 然后提取错误提示信息进行返回
        return ResultInfo.fail(unifyException.getMessage());
    }

}
