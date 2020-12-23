package com.lw.bean.vo.student;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * @author yujun.wu
 * @version 1.0
 * @create date 2020/12/20 21:21
 * @Description: 前端学生个人信息实体
 */
@Data
public class StudentInfoBaseVO {

    /**
     * 用户ID
     */
    @NotNull
    @Max(value = 12,message = "用户ID最大长度12位")
    @Min(value = 1, message = "用户ID最少长度1位")
    private Integer userId;

    /**
     * 学生学号
     */
    @NotBlank(message = "学号不能为空")
    @Max(value = 16,message = "学号长度最大长度16位")
    @Min(value = 6, message = "学号长度最少长度6位")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9_]+$", message = "学号包含非法字段")
    private String stuNum;

    /**
     * 入学日期
     */
    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate enrolDttm;

    /**
     * 毕业时间
     */
    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate graduateDttm;

}
