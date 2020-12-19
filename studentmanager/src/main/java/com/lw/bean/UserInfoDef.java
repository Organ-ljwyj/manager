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
 * 用户信息定义表
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("lw_user_info_def")
@ApiModel(value="UserInfoDef对象", description="用户信息定义表")
public class UserInfoDef implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键ID")
    @TableId(value = "T_ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "学生姓名")
    @TableField("T_NAME")
    private String name;

    @ApiModelProperty(value = "学生性别")
    @TableField("T_SEX")
    private Boolean sex;

    @ApiModelProperty(value = "身份证号")
    @TableField("T_ID_CARD")
    private String idCard;

    @ApiModelProperty(value = "手机号")
    @TableField("T_PHONE")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    @TableField("T_EMAIL")
    private String email;

    @ApiModelProperty(value = "年龄")
    @TableField("T_AGE")
    private Integer age;

    @ApiModelProperty(value = "出生日期")
    @TableField("T_BIRTHDAY")
    private LocalDateTime birthday;

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
