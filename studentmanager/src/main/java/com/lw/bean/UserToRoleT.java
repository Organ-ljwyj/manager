package com.lw.bean;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户角色关系表
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("lw_user_to_role_t")
@ApiModel(value="UserToRoleT对象", description="用户角色关系表")
public class UserToRoleT implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId("T_ID")
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    @TableField("T_USER_ID")
    private Integer userId;

    @ApiModelProperty(value = "角色ID")
    @TableField("T_ROLE_ID")
    @TableLogic(delval = "1",value = "0")
    private Integer roleId;


}
