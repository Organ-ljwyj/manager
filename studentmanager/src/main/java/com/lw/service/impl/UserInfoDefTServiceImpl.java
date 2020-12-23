package com.lw.service.impl;

import com.lw.bean.UserInfoDefT;
import com.lw.bean.vo.user.UserInfoDefBaseVO;
import com.lw.mapper.UserInfoDefTMapper;
import com.lw.service.IUserInfoDefTService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lw.utils.BuildBeanUtils;
import com.lw.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.lw.exception.UnifyException;

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

    @Autowired
    private PageUtils pageUtils;

    /**
     * 用户信息定义表分页列表
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public IPage<UserInfoDefT> page(UserInfoDefT param) throws UnifyException{
        QueryWrapper<UserInfoDefT> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
            //自增主键ID
                .eq(param.getId() != null, UserInfoDefT::getId, param.getId())
                    //姓名
                .eq(!StringUtils.isEmpty(param.getName()), UserInfoDefT::getName, param.getName())
                    //性别
                .eq(param.getSex() != null, UserInfoDefT::getSex, param.getSex())
                    //身份证号
                .eq(!StringUtils.isEmpty(param.getIdCard()), UserInfoDefT::getIdCard, param.getIdCard())
                    //手机号
                .eq(!StringUtils.isEmpty(param.getPhone()), UserInfoDefT::getPhone, param.getPhone())
                    //邮箱
                .eq(!StringUtils.isEmpty(param.getEmail()), UserInfoDefT::getEmail, param.getEmail())
                    //年龄
                .eq(param.getAge() != null, UserInfoDefT::getAge, param.getAge())
                    //出生日期
                .eq(param.getBirthday() != null, UserInfoDefT::getBirthday, param.getBirthday())
                    //添加人
                .eq(param.getAddOperator() != null, UserInfoDefT::getAddOperator, param.getAddOperator())
                    //添加时间
                .eq(param.getAddDttm() != null, UserInfoDefT::getAddDttm, param.getAddDttm())
                    //修改人
                .eq(param.getUpdateOperator() != null, UserInfoDefT::getUpdateOperator, param.getUpdateOperator())
                    //修改时间
                .eq(param.getUpdateDttm() != null, UserInfoDefT::getUpdateDttm, param.getUpdateDttm())
                    //删除标志
                .eq(param.getDeleted() != null, UserInfoDefT::getDeleted, param.getDeleted())
        ;
        IPage<UserInfoDefT> page = page(pageUtils.page(), queryWrapper);
        return page;
    }

    /**
     * 用户信息定义表详情
     *
     * @param id
     * @return
     */
    @Override
    public UserInfoDefT info(Long id) throws UnifyException{
        return getById(id);
    }

    /**
     * 用户信息定义表新增
     *
     * @param vo 根据需要进行传值
     * @return
     */
    @Override
    public void add(UserInfoDefBaseVO vo) throws UnifyException{
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
    public void modify(UserInfoDefT param) throws UnifyException{
        updateById(param);
    }

    /**
     * 用户信息定义表删除(单个条目)
     *
     * @param id
     * @return
     */
    @Override
    public void remove(Long id) throws UnifyException{
        removeById(id);
    }

    /**
     * 用户信息定义表删除(多个条目)
     *
     * @param ids
     * @return
     */
    @Override
    public void removes(List<Long> ids) throws UnifyException{
        removeByIds(ids);
    }
}
