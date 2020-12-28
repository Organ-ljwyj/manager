package com.lw.controller;

import com.lw.bean.ResultInfo;
import com.lw.bean.UserInfoDefT;
import com.lw.bean.vo.user.UserInfoDefBaseVO;
import com.lw.bean.vo.user.UserInfoPageVO;
import com.lw.exception.UnifyException;
import com.lw.service.IUserInfoDefTService;
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
    * 用户信息定义表 前端控制器
    * </p>
*
* @author yujun.wu
* @since 2020-12-20
*/
@Api(tags = "用户信息定义表")
@RestController
@RequestMapping("/user-info-def-t")
public class UserInfoDefTController {
    @Autowired
    private IUserInfoDefTService iUserInfoDefTService;

    @ApiOperation(value = "用户信息定义表分页列表", response = ResultInfo.class)
    @PostMapping(value = "/page")
    public  ResultInfo list(@Valid @RequestBody UserInfoPageVO vo) throws UnifyException{
        Object data = iUserInfoDefTService.page(vo);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "用户信息定义表详情", response = ResultInfo.class)
    @GetMapping(value = "/info/{id}")
    public  ResultInfo info(@PathVariable Long id) throws UnifyException{
        Object data = iUserInfoDefTService.info(id);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "用户信息定义表新增")
    @PostMapping(value = "/add")
    public  ResultInfo add(@Valid @RequestBody UserInfoDefBaseVO vo) throws UnifyException{
        iUserInfoDefTService.add(vo);
        return ResultInfo.success();
    }

    @ApiOperation(value = "用户信息定义表修改")
    @PostMapping(value = "/modify")
    public  ResultInfo modify(@Valid @RequestBody UserInfoDefT param) throws UnifyException{
        iUserInfoDefTService.modify(param);
        return ResultInfo.success();
    }

    @ApiOperation(value = "用户信息定义表删除(单个条目)")
    @GetMapping(value = "/remove/{id}")
    public  ResultInfo remove(@PathVariable Long id) throws UnifyException{
        iUserInfoDefTService.remove(id);
        return ResultInfo.success();
    }

    @ApiOperation(value = "用户信息定义表删除(多个条目)")
    @PostMapping(value = "/removes")
    public  ResultInfo removes(@Valid @RequestBody List<Long> ids) throws UnifyException{
        iUserInfoDefTService.removes(ids);
        return ResultInfo.success();
    }
}
