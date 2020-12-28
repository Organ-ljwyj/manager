package com.lw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lw.bean.StudentInfoT;
import com.lw.bean.vo.student.StudentInfoBaseVO;
import com.lw.bean.vo.student.StudentInfoPageVO;
import com.lw.exception.UnifyException;

import java.util.List;

/**
 * <p>
 * 学生个人信息 服务类
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-20
 */
public interface IStudentInfoTService extends IService<StudentInfoT> {
    /**
     * 学生个人信息分页列表
     *
     * @param vo 根据需要进行传值
     * @return
     */
    IPage<StudentInfoT> page(StudentInfoPageVO vo) throws UnifyException;


    /**
     * 学生个人信息详情
     *
     * @param id
     * @return
     */
    StudentInfoT info(Long id) throws UnifyException;

    /**
     * 学生个人信息新增
     *
     * @param vo 根据需要进行传值
     * @return
     */
    void add(StudentInfoBaseVO vo) throws UnifyException;

    /**
     * 学生个人信息修改
     *
     * @param vo 根据需要进行传值
     * @return
     */
    void modify(StudentInfoBaseVO vo) throws UnifyException;

    /**
     * 学生个人信息删除(单个条目)
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
