package com.lw.service;

import com.lw.bean.UserInfoDefT;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lw.bean.vo.user.UserInfoDefBaseVO;
import com.lw.exception.UnifyException;

import java.util.List;

/**
 * <p>
 * 用户信息定义表 服务类
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-20
 */
public interface IUserInfoDefTService extends IService<UserInfoDefT> {
    /**
     * 用户信息定义表分页列表
     *
     * @param param 根据需要进行传值
     * @return
     */
    IPage<UserInfoDefT> page(UserInfoDefT param) throws UnifyException;


    /**
     * 用户信息定义表详情
     *
     * @param id
     * @return
     */
     UserInfoDefT info(Long id) throws UnifyException;

    /**
     * 用户信息定义表新增
     *
     * @param vo 根据需要进行传值
     * @return
     */
     void add(UserInfoDefBaseVO vo) throws UnifyException;

    /**
     * 用户信息定义表修改
     *
     * @param param 根据需要进行传值
     * @return
     */
     void modify(UserInfoDefT param) throws UnifyException;

    /**
     * 用户信息定义表删除(单个条目)
     *
     * @param id
     * @return
     */
     void remove(Long id) throws UnifyException;

    /**
     * 删除(多个条目)
     *
     * @param ids
     * @return
     */
     void removes(List<Long> ids) throws UnifyException;
}
