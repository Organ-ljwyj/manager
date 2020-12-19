package com.lw.service;

import com.lw.bean.UserInfoDef;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 用户信息定义表 服务类
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
public interface IUserInfoDefService extends IService<UserInfoDef> {
    /**
     * 用户信息定义表分页列表
     *
     * @param param 根据需要进行传值
     * @return
     */
    IPage<UserInfoDef> page(UserInfoDef param);


    /**
     * 用户信息定义表详情
     *
     * @param id
     * @return
     */
    UserInfoDef info(Long id);

    /**
     * 用户信息定义表新增
     *
     * @param param 根据需要进行传值
     * @return
     */
    void add(UserInfoDef param);

    /**
     * 用户信息定义表修改
     *
     * @param param 根据需要进行传值
     * @return
     */
    void modify(UserInfoDef param);

    /**
     * 用户信息定义表删除(单个条目)
     *
     * @param id
     * @return
     */
    void remove(Long id);

    /**
     * 删除(多个条目)
     *
     * @param ids
     * @return
     */
    void removes(List<Long> ids);
}
