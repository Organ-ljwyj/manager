package com.lw.controller;

import com.lw.bean.ResultInfo;
import com.lw.bean.vo.student.StudentInfoBaseVO;
import com.lw.bean.vo.student.StudentInfoPageVO;
import com.lw.exception.UnifyException;
import com.lw.service.IStudentInfoTService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
* <p>
    * 学生个人信息 前端控制器
    * </p>
*
* @author yujun.wu
* @since 2020-12-20
*/
@Api(tags = "学生个人信息")
@RestController
@RequestMapping("/student-info-t")
public class StudentInfoTController {
    @Autowired
    private IStudentInfoTService iStudentInfoTService;

    @ApiOperation(value = "学生个人信息分页列表", response = ResultInfo.class)
    @PostMapping(value = "/page")
    public  Object list(@Valid @RequestBody StudentInfoPageVO vo) throws UnifyException {
        Object data = iStudentInfoTService.page(vo);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "学生个人信息详情", response = ResultInfo.class)
    @GetMapping(value = "/info/{id}")
    public  Object info(@PathVariable Long id) throws UnifyException {
        Object data = iStudentInfoTService.info(id);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "学生个人信息新增")
    @PostMapping(value = "/add")
    public  Object add(@Valid @RequestBody StudentInfoBaseVO vo) throws UnifyException {
        iStudentInfoTService.add(vo);
        return ResultInfo.success();
    }

    @ApiOperation(value = "学生个人信息修改")
    @PostMapping(value = "/modify")
    public  Object modify(@Valid @RequestBody StudentInfoBaseVO vo) throws UnifyException {
        iStudentInfoTService.modify(vo);
        return ResultInfo.success();
    }

    @ApiOperation(value = "学生个人信息删除(单个条目)")
    @GetMapping(value = "/remove/{id}")
    public  Object remove(@PathVariable Long id) throws UnifyException {
        iStudentInfoTService.remove(id);
        return ResultInfo.success();
    }

    @ApiOperation(value = "学生个人信息删除(多个条目)")
    @PostMapping(value = "/removes")
    public  Object removes(@Valid @RequestBody List<Long> ids) throws UnifyException {
        iStudentInfoTService.removes(ids);
        return ResultInfo.success();
    }
}
