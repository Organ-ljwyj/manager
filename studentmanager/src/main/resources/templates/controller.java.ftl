package ${package.Controller};

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import com.lw.bean.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import com.lw.exception.UnifyException;
import org.springframework.web.bind.annotation.*;

<#if restControllerStyle>
<#else>
 import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
 import ${superControllerClassPackage};
</#if>


import javax.validation.Valid;
import java.util.List;

/**
* <p>
    * ${table.comment} 前端控制器
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Api(tags = "${table.comment}")
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
 class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
 </#if>
    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    @ApiOperation(value = "${table.comment}分页列表", response = ${entity}.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页面", dataType = "Long"),
        @ApiImplicitParam(name = "size", value = "页面数据量", dataType = "Long"),
        @ApiImplicitParam(name = "sort", value = "排序方式排序[true:正序; false:倒序]", dataType = "Boolean"),
        @ApiImplicitParam(name = "sortName", value = "排序字段,参照返回字段", dataType = "String")})
    @PostMapping(value = "/page")
    public  ResultInfo list(@Valid @RequestBody ${entity} param) throws UnifyException{
        Object data = ${table.serviceName?uncap_first}.page(param);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "${table.comment}详情", response = ${entity}.class)
    @GetMapping(value = "/info/{id}")
    public  ResultInfo info(@PathVariable Long id) throws UnifyException{
        Object data = ${table.serviceName?uncap_first}.info(id);
        return ResultInfo.success(data);
    }

    @ApiOperation(value = "${table.comment}新增")
    @PostMapping(value = "/add")
    public  ResultInfo add(@Valid @RequestBody ${entity} param) throws UnifyException{
        ${table.serviceName?uncap_first}.add(param);
        return ResultInfo.success();
    }

    @ApiOperation(value = "${table.comment}修改")
    @PostMapping(value = "/modify")
    public  ResultInfo modify(@Valid @RequestBody ${entity} param) throws UnifyException{
        ${table.serviceName?uncap_first}.modify(param);
        return ResultInfo.success();
    }

    @ApiOperation(value = "${table.comment}删除(单个条目)")
    @GetMapping(value = "/remove/{id}")
    public  ResultInfo remove(@PathVariable Long id) throws UnifyException{
        ${table.serviceName?uncap_first}.remove(id);
        return ResultInfo.success();
    }

    @ApiOperation(value = "${table.comment}删除(多个条目)")
    @PostMapping(value = "/removes")
    public  Object removes(@Valid @RequestBody List<Long> ids) throws UnifyException{
        ${table.serviceName?uncap_first}.removes(ids);
        return ResultInfo.success();
    }
}
</#if>