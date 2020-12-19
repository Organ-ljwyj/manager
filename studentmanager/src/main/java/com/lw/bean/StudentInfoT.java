package com.lw.bean;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 学生个人信息
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
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
    private LocalDateTime enrolDttm;

    @ApiModelProperty(value = "毕业时间")
    @TableField("T_GRADUATE_DTTM")
    private LocalDateTime graduateDttm;

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
    @TableLogic(delval = "1",value = "0")
    private Boolean deleted;


}
