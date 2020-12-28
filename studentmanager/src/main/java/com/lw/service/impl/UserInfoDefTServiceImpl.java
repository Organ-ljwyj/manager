package com.lw.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lw.bean.UserInfoDefT;
import com.lw.bean.vo.user.UserInfoDefBaseVO;
import com.lw.bean.vo.user.UserInfoPageVO;
import com.lw.exception.UnifyException;
import com.lw.mapper.UserInfoDefTMapper;
import com.lw.service.IUserInfoDefTService;
import com.lw.utils.BuildBeanUtils;
import com.lw.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息定义表 服务实现类
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-20
 */
@Service
@Slf4j
public class UserInfoDefTServiceImpl extends ServiceImpl<UserInfoDefTMapper, UserInfoDefT> implements IUserInfoDefTService {

    /**
     * 用户信息定义表分页列表
     *
     * @param vo 根据需要进行传值
     * @return
     */
    @Override
    public IPage<UserInfoDefT> page(UserInfoPageVO vo) throws UnifyException {
        LambdaQueryChainWrapper<UserInfoDefT> queryChainWrapper = lambdaQuery()
                .like(!StringUtils.isBlank(vo.getName()), UserInfoDefT::getName, vo.getName())
                .like(!StringUtils.isEmpty(vo.getIdCard()), UserInfoDefT::getIdCard, vo.getIdCard());
        IPage<UserInfoDefT> page = page(PageUtils.page(vo.getPageNum(), vo.getPageSize()), queryChainWrapper);
        return page;
    }

    /**
     * 用户信息定义表详情
     *
     * @param id
     * @return
     */
    @Override
    public UserInfoDefT info(Long id) throws UnifyException {
        return getById(id);
    }

    /**
     * 用户信息定义表新增
     *
     * @param vo 根据需要进行传值
     * @return
     */
    @Override
    public void add(UserInfoDefBaseVO vo) throws UnifyException {
        try {
            UserInfoDefT userInfoDefT = BuildBeanUtils.copyProperties(vo, UserInfoDefT.class);
            save(userInfoDefT);
        } catch (Exception e) {
            StringBuilder failMessage = new StringBuilder(100).append("新增用户信息失败，失败原因：")
                    .append(e.getMessage());
            throw new UnifyException(failMessage.toString());
        }
    }

    /**
     * 用户信息定义表修改
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public void modify(UserInfoDefT param) throws UnifyException {
        updateById(param);
    }

    /**
     * 用户信息定义表删除(单个条目)
     *
     * @param id
     * @return
     */
    @Override
    public void remove(Long id) throws UnifyException {
        removeById(id);
    }

    /**
     * 用户信息定义表删除(多个条目)
     *
     * @param ids
     * @return
     */
    @Override
    public void removes(List<Long> ids) throws UnifyException {
        removeByIds(ids);
    }
}
