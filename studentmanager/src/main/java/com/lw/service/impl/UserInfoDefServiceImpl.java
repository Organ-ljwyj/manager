package com.lw.service.impl;

import com.lw.bean.UserInfoDef;
import com.lw.mapper.UserInfoDefMapper;
import com.lw.service.IUserInfoDefService;
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
 * 用户信息定义表 服务实现类
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
@Service
public class UserInfoDefServiceImpl extends ServiceImpl<UserInfoDefMapper, UserInfoDef> implements IUserInfoDefService {

    @Autowired
    private PageUtils pageUtils;

    /**
     * 用户信息定义表分页列表
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public IPage<UserInfoDef> page(UserInfoDef param) {
        QueryWrapper<UserInfoDef> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                //自增主键ID
                .eq(param.getId() != null, UserInfoDef::getId, param.getId())
                //学生姓名
                .eq(!StringUtils.isEmpty(param.getName()), UserInfoDef::getName, param.getName())
                //学生性别
                .eq(param.getSex() != null, UserInfoDef::getSex, param.getSex())
                //身份证号
                .eq(!StringUtils.isEmpty(param.getIdCard()), UserInfoDef::getIdCard, param.getIdCard())
                //手机号
                .eq(!StringUtils.isEmpty(param.getPhone()), UserInfoDef::getPhone, param.getPhone())
                //邮箱
                .eq(!StringUtils.isEmpty(param.getEmail()), UserInfoDef::getEmail, param.getEmail())
                //年龄
                .eq(param.getAge() != null, UserInfoDef::getAge, param.getAge())
                //出生日期
                .eq(param.getBirthday() != null, UserInfoDef::getBirthday, param.getBirthday())
                //添加人
                .eq(param.getAddOperator() != null, UserInfoDef::getAddOperator, param.getAddOperator())
                //添加时间
                .eq(param.getAddDttm() != null, UserInfoDef::getAddDttm, param.getAddDttm())
                //修改人
                .eq(param.getUpdateOperator() != null, UserInfoDef::getUpdateOperator, param.getUpdateOperator())
                //修改时间
                .eq(param.getUpdateDttm() != null, UserInfoDef::getUpdateDttm, param.getUpdateDttm())
                //删除标志
                .eq(param.getDeleted() != null, UserInfoDef::getDeleted, param.getDeleted())
        ;
        IPage<UserInfoDef> page = page(pageUtils.page(), queryWrapper);
        return page;
    }

    /**
     * 用户信息定义表详情
     *
     * @param id
     * @return
     */
    @Override
    public UserInfoDef info(Long id) {
        return getById(id);
    }

    /**
     * 用户信息定义表新增
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public void add(UserInfoDef param) {
        save(param);
    }

    /**
     * 用户信息定义表修改
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public void modify(UserInfoDef param) {
        updateById(param);
    }

    /**
     * 用户信息定义表删除(单个条目)
     *
     * @param id
     * @return
     */
    @Override
    public void remove(Long id) {
        removeById(id);
    }

    /**
     * 用户信息定义表删除(多个条目)
     *
     * @param ids
     * @return
     */
    @Override
    public void removes(List<Long> ids) {
        removeByIds(ids);
    }
}
