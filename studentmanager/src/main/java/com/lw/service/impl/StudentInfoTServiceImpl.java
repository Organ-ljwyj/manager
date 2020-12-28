package com.lw.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lw.bean.StudentInfoT;
import com.lw.bean.vo.student.StudentInfoBaseVO;
import com.lw.bean.vo.student.StudentInfoPageVO;
import com.lw.exception.UnifyException;
import com.lw.mapper.StudentInfoTMapper;
import com.lw.service.IStudentInfoTService;
import com.lw.utils.BuildBeanUtils;
import com.lw.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 学生个人信息 服务实现类
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-20
 */
@Service
@Slf4j
public class StudentInfoTServiceImpl extends ServiceImpl<StudentInfoTMapper, StudentInfoT> implements IStudentInfoTService {

    /**
     * 学生个人信息分页列表
     *
     * @param vo 根据需要进行传值
     * @return
     */
    @Override
    public IPage<StudentInfoT> page(StudentInfoPageVO vo) throws UnifyException {
        LambdaQueryChainWrapper<StudentInfoT> chainWrapper = lambdaQuery()
                .like(!StringUtils.isEmpty(vo.getStuNum()), StudentInfoT::getStuNum, vo.getStuNum());
        IPage<StudentInfoT> page = page(PageUtils.page(vo.getPageNum(), vo.getPageSize()), chainWrapper);
        return page;
    }

    /**
     * 学生个人信息详情
     *
     * @param id
     * @return
     */
    @Override
    public StudentInfoT info(Long id) throws UnifyException {
        return getById(id);
    }

    /**
     * 学生个人信息新增
     *
     * @param vo 根据需要进行传值
     * @return
     */
    @Override
    public void add(StudentInfoBaseVO vo) throws UnifyException {
        try {
            StudentInfoT studentInfoT = BuildBeanUtils.copyProperties(vo, StudentInfoT.class);
            save(studentInfoT);
        } catch (Exception e) {
            StringBuilder failMessage = new StringBuilder(100).append("新增学生个人信息失败，失败原因：")
                    .append(e.getMessage());
            throw new UnifyException(failMessage.toString());
        }

    }

    /**
     * 学生个人信息修改
     *
     * @param vo 根据需要进行传值
     * @return
     */
    @Override
    public void modify(StudentInfoBaseVO vo) throws UnifyException {
        try {
            StudentInfoT studentInfoT = BuildBeanUtils.copyProperties(vo, StudentInfoT.class);
            updateById(studentInfoT);
        } catch (ReflectiveOperationException e) {
            StringBuilder failMessage = new StringBuilder(100).append("修改学生个人信息失败，失败原因：")
                    .append(e.getMessage());
            throw new UnifyException(failMessage.toString());
        }

    }

    /**
     * 学生个人信息删除(单个条目)
     *
     * @param id
     * @return
     */
    @Override
    public void remove(Long id) throws UnifyException {
        removeById(id);
    }

    /**
     * 学生个人信息删除(多个条目)
     *
     * @param ids
     * @return
     */
    @Override
    public void removes(List<Long> ids) throws UnifyException {
        removeByIds(ids);
    }
}
