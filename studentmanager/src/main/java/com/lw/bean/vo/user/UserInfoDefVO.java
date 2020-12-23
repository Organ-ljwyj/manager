package com.lw.bean.vo.user;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户信息定义表
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-20
 */
@Data
public class UserInfoDefVO extends UserInfoDefBaseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键ID
     */
    private Integer id;
}
