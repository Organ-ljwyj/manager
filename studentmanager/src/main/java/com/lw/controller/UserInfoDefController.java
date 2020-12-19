package com.lw.controller;

import com.lw.bean.UserInfoDef;
import com.lw.service.IUserInfoDefService;
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
 * 用户信息定义表 前端控制器
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
@Api(tags = "用户信息定义表")
@RestController
@RequestMapping("/user-info-def")
public class UserInfoDefController {
    @Autowired
    private IUserInfoDefService iUserInfoDefService;

    @ApiOperation(value = "用户信息定义表分页列表", response = UserInfoDef.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页面", dataType = "Long"),
            @ApiImplicitParam(name = "size", value = "页面数据量", dataType = "Long"),
            @ApiImplicitParam(name = "sort", value = "排序方式排序[true:正序; false:倒序]", dataType = "Boolean"),
            @ApiImplicitParam(name = "sortName", value = "排序字段,参照返回字段", dataType = "String")})
    @PostMapping(value = "/page")
    public Object list(@Valid @RequestBody UserInfoDef param) {
        Object data = iUserInfoDefService.page(param);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "用户信息定义表详情", response = UserInfoDef.class)
    @GetMapping(value = "/info/{id}")
    public Object info(@PathVariable Long id) {
        Object data = iUserInfoDefService.info(id);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "用户信息定义表新增")
    @PostMapping(value = "/add")
    public Object add(@Valid @RequestBody UserInfoDef param) {
        iUserInfoDefService.add(param);
        return ResultInfo.success();
    }

    @ApiOperation(value = "用户信息定义表修改")
    @PostMapping(value = "/modify")
    public Object modify(@Valid @RequestBody UserInfoDef param) {
        iUserInfoDefService.modify(param);
        return ResultInfo.success();
    }

    @ApiOperation(value = "用户信息定义表删除(单个条目)")
    @GetMapping(value = "/remove/{id}")
    public Object remove(@PathVariable Long id) {
        iUserInfoDefService.remove(id);
        return ResultInfo.success();
    }

    @ApiOperation(value = "用户信息定义表删除(多个条目)")
    @PostMapping(value = "/removes")
    public Object removes(@Valid @RequestBody List<Long> ids) {
        iUserInfoDefService.removes(ids);
        return ResultInfo.success();
    }
}
