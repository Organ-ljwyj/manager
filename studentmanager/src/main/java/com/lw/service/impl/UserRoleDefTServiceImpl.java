package com.lw.service.impl;

import com.lw.bean.UserRoleDefT;
import com.lw.mapper.UserRoleDefTMapper;
import com.lw.service.IUserRoleDefTService;
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
 * 用户角色定义表 服务实现类
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
@Service
public class UserRoleDefTServiceImpl extends ServiceImpl<UserRoleDefTMapper, UserRoleDefT> implements IUserRoleDefTService {

    @Autowired
    private PageUtils pageUtils;

    /**
     * 用户角色定义表分页列表
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public IPage<UserRoleDefT> page(UserRoleDefT param) {
        QueryWrapper<UserRoleDefT> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
            //主键ID
                .eq(param.getId() != null, UserRoleDefT::getId, param.getId())
                    //角色
                .eq(!StringUtils.isEmpty(param.getRole()), UserRoleDefT::getRole, param.getRole())
                    //角色描述
                .eq(!StringUtils.isEmpty(param.getRoleDesc()), UserRoleDefT::getRoleDesc, param.getRoleDesc())
                    //添加人
                .eq(param.getAddOperator() != null, UserRoleDefT::getAddOperator, param.getAddOperator())
                    //添加时间
                .eq(param.getAddDttm() != null, UserRoleDefT::getAddDttm, param.getAddDttm())
                    //修改人
                .eq(param.getUpdateOperator() != null, UserRoleDefT::getUpdateOperator, param.getUpdateOperator())
                    //修改时间
                .eq(param.getUpdateDttm() != null, UserRoleDefT::getUpdateDttm, param.getUpdateDttm())
                    //删除标志
                .eq(param.getDeleted() != null, UserRoleDefT::getDeleted, param.getDeleted())
        ;
        IPage<UserRoleDefT> page = page(pageUtils.page(), queryWrapper);
        return page;
    }

    /**
     * 用户角色定义表详情
     *
     * @param id
     * @return
     */
    @Override
    public UserRoleDefT info(Long id) {
        return getById(id);
    }

    /**
     * 用户角色定义表新增
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public void add(UserRoleDefT param) {
        save(param);
    }

    /**
     * 用户角色定义表修改
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public void modify(UserRoleDefT param) {
        updateById(param);
    }

    /**
     * 用户角色定义表删除(单个条目)
     *
     * @param id
     * @return
     */
    @Override
    public void remove(Long id) {
        removeById(id);
    }

    /**
     * 用户角色定义表删除(多个条目)
     *
     * @param ids
     * @return
     */
    @Override
    public void removes(List<Long> ids) {
        removeByIds(ids);
    }
}
