package com.lw.service;

import com.lw.bean.StudentInfoT;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 学生个人信息 服务类
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
public interface IStudentInfoTService extends IService<StudentInfoT> {
    /**
     * 学生个人信息分页列表
     *
     * @param param 根据需要进行传值
     * @return
     */
    IPage<StudentInfoT> page(StudentInfoT param);


    /**
     * 学生个人信息详情
     *
     * @param id
     * @return
     */
     StudentInfoT info(Long id);

    /**
     * 学生个人信息新增
     *
     * @param param 根据需要进行传值
     * @return
     */
     void add(StudentInfoT param);

    /**
     * 学生个人信息修改
     *
     * @param param 根据需要进行传值
     * @return
     */
     void modify(StudentInfoT param);

    /**
     * 学生个人信息删除(单个条目)
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
