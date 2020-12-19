package com.lw.service.impl;

import com.lw.bean.UserToRoleT;
import com.lw.mapper.UserToRoleTMapper;
import com.lw.service.IUserToRoleTService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lw.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
@Service
public class UserToRoleTServiceImpl extends ServiceImpl<UserToRoleTMapper, UserToRoleT> implements IUserToRoleTService {

    @Autowired
    private PageUtils pageUtils;

    /**
     * 用户角色关系表分页列表
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public IPage<UserToRoleT> page(UserToRoleT param) {
        QueryWrapper<UserToRoleT> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
            //主键ID
                .eq(param.getId() != null, UserToRoleT::getId, param.getId())
                    //用户ID
                .eq(param.getUserId() != null, UserToRoleT::getUserId, param.getUserId())
                    //角色ID
                .eq(param.getRoleId() != null, UserToRoleT::getRoleId, param.getRoleId())
        ;
        IPage<UserToRoleT> page = page(pageUtils.page(), queryWrapper);
        return page;
    }

    /**
     * 用户角色关系表详情
     *
     * @param id
     * @return
     */
    @Override
    public UserToRoleT info(Long id) {
        return getById(id);
    }

    /**
     * 用户角色关系表新增
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public void add(UserToRoleT param) {
        save(param);
    }

    /**
     * 用户角色关系表修改
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public void modify(UserToRoleT param) {
        updateById(param);
    }

    /**
     * 用户角色关系表删除(单个条目)
     *
     * @param id
     * @return
     */
    @Override
    public void remove(Long id) {
        removeById(id);
    }

    /**
     * 用户角色关系表删除(多个条目)
     *
     * @param ids
     * @return
     */
    @Override
    public void removes(List<Long> ids) {
        removeByIds(ids);
    }
}
