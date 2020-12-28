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
import java.time.LocalDateTime;

/**
 * <p>
 * 用户角色定义表
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("lw_user_role_def_t")
@ApiModel(value="UserRoleDefT对象", description="用户角色定义表")
public class UserRoleDefT implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "T_ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "角色")
    @TableField("T_ROLE")
    private String role;

    @ApiModelProperty(value = "角色描述")
    @TableField("T_ROLE_DESC")
    private String roleDesc;

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
