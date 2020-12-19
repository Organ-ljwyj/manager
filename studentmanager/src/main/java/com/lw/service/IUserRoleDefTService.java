package com.lw.service;

import com.lw.bean.UserRoleDefT;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 用户角色定义表 服务类
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
public interface IUserRoleDefTService extends IService<UserRoleDefT> {
    /**
     * 用户角色定义表分页列表
     *
     * @param param 根据需要进行传值
     * @return
     */
    IPage<UserRoleDefT> page(UserRoleDefT param);


    /**
     * 用户角色定义表详情
     *
     * @param id
     * @return
     */
    UserRoleDefT info(Long id);

    /**
     * 用户角色定义表新增
     *
     * @param param 根据需要进行传值
     * @return
     */
    void add(UserRoleDefT param);

    /**
     * 用户角色定义表修改
     *
     * @param param 根据需要进行传值
     * @return
     */
    void modify(UserRoleDefT param);

    /**
     * 用户角色定义表删除(单个条目)
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
