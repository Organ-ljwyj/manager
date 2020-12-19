package com.lw.service;

import com.lw.bean.UserToRoleT;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 用户角色关系表 服务类
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
public interface IUserToRoleTService extends IService<UserToRoleT> {
    /**
     * 用户角色关系表分页列表
     *
     * @param param 根据需要进行传值
     * @return
     */
    IPage<UserToRoleT> page(UserToRoleT param);


    /**
     * 用户角色关系表详情
     *
     * @param id
     * @return
     */
    UserToRoleT info(Long id);

    /**
     * 用户角色关系表新增
     *
     * @param param 根据需要进行传值
     * @return
     */
    void add(UserToRoleT param);

    /**
     * 用户角色关系表修改
     *
     * @param param 根据需要进行传值
     * @return
     */
    void modify(UserToRoleT param);

    /**
     * 用户角色关系表删除(单个条目)
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
