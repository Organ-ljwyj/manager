package com.lw.controller;

import com.lw.bean.StudentInfoT;
import com.lw.service.IStudentInfoTService;
import com.lw.bean.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 学生个人信息 前端控制器
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
@Api(tags = "学生个人信息")
@RestController
@RequestMapping("/student-info-t")
public class StudentInfoTController {
    @Autowired
    private IStudentInfoTService iStudentInfoTService;

    @ApiOperation(value = "学生个人信息分页列表", response = StudentInfoT.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页面", dataType = "Long"),
            @ApiImplicitParam(name = "size", value = "页面数据量", dataType = "Long"),
            @ApiImplicitParam(name = "sort", value = "排序方式排序[true:正序; false:倒序]", dataType = "Boolean"),
            @ApiImplicitParam(name = "sortName", value = "排序字段,参照返回字段", dataType = "String")})
    @PostMapping(value = "/page")
    public Object list(@Valid @RequestBody StudentInfoT param) {
        Object data = iStudentInfoTService.page(param);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "学生个人信息详情", response = StudentInfoT.class)
    @GetMapping(value = "/info/{id}")
    public Object info(@PathVariable Long id) {
        Object data = iStudentInfoTService.info(id);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "学生个人信息新增")
    @PostMapping(value = "/add")
    public Object add(@Valid @RequestBody StudentInfoT param) {
        iStudentInfoTService.add(param);
        return ResultInfo.success();
    }

    @ApiOperation(value = "学生个人信息修改")
    @PostMapping(value = "/modify")
    public Object modify(@Valid @RequestBody StudentInfoT param) {
        iStudentInfoTService.modify(param);
        return ResultInfo.success();
    }

    @ApiOperation(value = "学生个人信息删除(单个条目)")
    @GetMapping(value = "/remove/{id}")
    public Object remove(@PathVariable Long id) {
        iStudentInfoTService.remove(id);
        return ResultInfo.success();
    }

    @ApiOperation(value = "学生个人信息删除(多个条目)")
    @PostMapping(value = "/removes")
    public Object removes(@Valid @RequestBody List<Long> ids) {
        iStudentInfoTService.removes(ids);
        return ResultInfo.success();
    }
}
