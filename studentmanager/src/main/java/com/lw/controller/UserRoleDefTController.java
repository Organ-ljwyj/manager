package com.lw.controller;

import com.lw.bean.ResultInfo;
import com.lw.bean.UserRoleDefT;
import com.lw.service.IUserRoleDefTService;
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
 * 用户角色定义表 前端控制器
 * </p>
 *
 * @author yujun.wu
 * @since 2020-12-19
 */
@Api(tags = "用户角色定义表")
@RestController
@RequestMapping("/user-role-def-t")
public class UserRoleDefTController {
    @Autowired
    private IUserRoleDefTService iUserRoleDefTService;

    @ApiOperation(value = "用户角色定义表分页列表", response = ResultInfo.class)
    @PostMapping(value = "/page")
    public Object list(@Valid @RequestBody UserRoleDefT param) {
        Object data = iUserRoleDefTService.page(param);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "用户角色定义表详情", response = ResultInfo.class)
    @GetMapping(value = "/info/{id}")
    public Object info(@PathVariable Long id) {
        Object data = iUserRoleDefTService.info(id);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "用户角色定义表新增")
    @PostMapping(value = "/add")
    public Object add(@Valid @RequestBody UserRoleDefT param) {
        iUserRoleDefTService.add(param);
        return ResultInfo.success();
    }

    @ApiOperation(value = "用户角色定义表修改")
    @PostMapping(value = "/modify")
    public Object modify(@Valid @RequestBody UserRoleDefT param) {
        iUserRoleDefTService.modify(param);
        return ResultInfo.success();
    }

    @ApiOperation(value = "用户角色定义表删除(单个条目)")
    @GetMapping(value = "/remove/{id}")
    public Object remove(@PathVariable Long id) {
        iUserRoleDefTService.remove(id);
        return ResultInfo.success();
    }

    @ApiOperation(value = "用户角色定义表删除(多个条目)")
    @PostMapping(value = "/removes")
    public Object removes(@Valid @RequestBody List<Long> ids) {
        iUserRoleDefTService.removes(ids);
        return ResultInfo.success();
    }
}
