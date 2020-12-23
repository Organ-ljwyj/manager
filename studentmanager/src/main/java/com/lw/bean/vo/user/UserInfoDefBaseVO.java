package com.lw.bean.vo.user;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 用户信息定义表
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-20
 */
@Data
public class UserInfoDefBaseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    @Max(value = 128,message = "姓名长度最大128位")
    @Min(value = 1, message = "姓名长度最少1位")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9_]+$", message = "姓名包含非法字段")
    private String name;

    /**
     * 性别
     */
    @NotNull(message = "性别不能为空")
    @Max(value = 3,message = "性别不合法")
    @Min(value = 1, message = "性别不合法")
    private Integer sex;

    /**
     * 身份证号
     */
    @NotBlank(message = "身份证号不能为空")
    @Max(value = 18,message = "身份证号长度最大18位")
    @Min(value = 18, message = "身份证号长度最少18位")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5xX0-9_]+$", message = "身份证号包含非法字段")
    private String idCard;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp =  "1[3|4|5|7|8][0-9]\\d{8}",message = "手机号格式不合法")
    @Email
    private String phone;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不合法")
    private String email;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    @Max(value = 200,message = "年龄不合法")
    @Min(value = 0, message = "年龄不合法")
    private Integer age;

    /**
     * 出生日期
     */
    @NotNull(message = "出生日期不能为空")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;

}
