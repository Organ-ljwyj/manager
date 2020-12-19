package com.lw.controller;

import com.lw.bean.UserToRoleT;
import com.lw.service.IUserToRoleTService;
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
 * 用户角色关系表 前端控制器
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
@Api(tags = "用户角色关系表")
@RestController
@RequestMapping("/user-to-role-t")
public class UserToRoleTController {
    @Autowired
    private IUserToRoleTService iUserToRoleTService;

    @ApiOperation(value = "用户角色关系表分页列表", response = UserToRoleT.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页面", dataType = "Long"),
            @ApiImplicitParam(name = "size", value = "页面数据量", dataType = "Long"),
            @ApiImplicitParam(name = "sort", value = "排序方式排序[true:正序; false:倒序]", dataType = "Boolean"),
            @ApiImplicitParam(name = "sortName", value = "排序字段,参照返回字段", dataType = "String")})
    @PostMapping(value = "/page")
    public Object list(@Valid @RequestBody UserToRoleT param) {
        Object data = iUserToRoleTService.page(param);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "用户角色关系表详情", response = UserToRoleT.class)
    @GetMapping(value = "/info/{id}")
    public Object info(@PathVariable Long id) {
        Object data = iUserToRoleTService.info(id);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "用户角色关系表新增")
    @PostMapping(value = "/add")
    public Object add(@Valid @RequestBody UserToRoleT param) {
        iUserToRoleTService.add(param);
        return ResultInfo.success();
    }

    @ApiOperation(value = "用户角色关系表修改")
    @PostMapping(value = "/modify")
    public Object modify(@Valid @RequestBody UserToRoleT param) {
        iUserToRoleTService.modify(param);
        return ResultInfo.success();
    }

    @ApiOperation(value = "用户角色关系表删除(单个条目)")
    @GetMapping(value = "/remove/{id}")
    public Object remove(@PathVariable Long id) {
        iUserToRoleTService.remove(id);
        return ResultInfo.success();
    }

    @ApiOperation(value = "用户角色关系表删除(多个条目)")
    @PostMapping(value = "/removes")
    public Object removes(@Valid @RequestBody List<Long> ids) {
        iUserToRoleTService.removes(ids);
        return ResultInfo.success();
    }
}
