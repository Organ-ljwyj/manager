package com.lw.service.impl;

import com.lw.bean.StudentInfoT;
import com.lw.bean.vo.student.StudentInfoBaseVO;
import com.lw.exception.UnifyException;
import com.lw.mapper.StudentInfoTMapper;
import com.lw.service.IStudentInfoTService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lw.utils.BuildBeanUtils;
import com.lw.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Autowired
    private PageUtils pageUtils;

    /**
     * 学生个人信息分页列表
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public IPage<StudentInfoT> page(StudentInfoT param) throws UnifyException {
        QueryWrapper<StudentInfoT> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                //自增主键ID
                .eq(param.getId() != null, StudentInfoT::getId, param.getId())
                //用户ID
                .eq(param.getUserId() != null, StudentInfoT::getUserId, param.getUserId())
                //学生学号
                .eq(!StringUtils.isEmpty(param.getStuNum()), StudentInfoT::getStuNum, param.getStuNum())
                //入学日期
                .eq(param.getEnrolDttm() != null, StudentInfoT::getEnrolDttm, param.getEnrolDttm())
                //毕业时间
                .eq(param.getGraduateDttm() != null, StudentInfoT::getGraduateDttm, param.getGraduateDttm())
                //添加人
                .eq(param.getAddOperator() != null, StudentInfoT::getAddOperator, param.getAddOperator())
                //添加时间
                .eq(param.getAddDttm() != null, StudentInfoT::getAddDttm, param.getAddDttm())
                //修改人
                .eq(param.getUpdateOperator() != null, StudentInfoT::getUpdateOperator, param.getUpdateOperator())
                //修改时间
                .eq(param.getUpdateDttm() != null, StudentInfoT::getUpdateDttm, param.getUpdateDttm())
                //删除标志
                .eq(param.getDeleted() != null, StudentInfoT::getDeleted, param.getDeleted())
        ;
        IPage<StudentInfoT> page = page(pageUtils.page(), queryWrapper);
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
