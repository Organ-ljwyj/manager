package com.lw.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 学生个人信息
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("lw_student_info_t")
@ApiModel(value="StudentInfoT对象", description="学生个人信息")
public class StudentInfoT implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键ID")
    @TableId(value = "T_ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    @TableField("T_USER_ID")
    private Integer userId;

    @ApiModelProperty(value = "学生学号")
    @TableField("T_STU_NUM")
    private String stuNum;

    @ApiModelProperty(value = "入学日期")
    @TableField("T_ENROL_DTTM")
    private LocalDate enrolDttm;

    @ApiModelProperty(value = "毕业时间")
    @TableField("T_GRADUATE_DTTM")
    private LocalDate graduateDttm;

    @ApiModelProperty(value = "添加人")
    @TableField("T_ADD_OPERATOR")
    private Integer addOperator;

    @ApiModelProperty(value = "添加时间")
    @TableField("T_ADD_DTTM")
    private LocalDateTime addDttm;

    @ApiModelProperty(value = "修改人")
    @TableField("T_UPDATE_OPERATOR")
    private Integer updateOperator;

    @ApiModelProperty(value = "修改时间")
    @TableField("T_UPDATE_DTTM")
    private LocalDateTime updateDttm;

    @ApiModelProperty(value = "删除标志")
    @TableField("T_DELETED")
    @TableLogic
    private Boolean deleted;


}
