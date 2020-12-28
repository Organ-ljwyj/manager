package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lw.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.lw.exception.UnifyException;

import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
@Slf4j
<#if kotlin>
 open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {
 }
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    /**
     * ${table.comment!}分页列表
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public IPage<${entity}> page(${entity} param) throws UnifyException{
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        IPage<${entity}> page = page(PageUtils.page(vo.getPageNum(), vo.getPageSize()), queryWrapper);
        return page;
    }

    /**
     * ${table.comment!}详情
     *
     * @param id
     * @return
     */
    @Override
    public ${entity} info(Long id) throws UnifyException{
        return getById(id);
    }

    /**
     * ${table.comment!}新增
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public void add(${entity} param) throws UnifyException{
        save(param);
    }

    /**
     * ${table.comment!}修改
     *
     * @param param 根据需要进行传值
     * @return
     */
    @Override
    public void modify(${entity} param) throws UnifyException{
        updateById(param);
    }

    /**
     * ${table.comment!}删除(单个条目)
     *
     * @param id
     * @return
     */
    @Override
    public void remove(Long id) throws UnifyException{
        removeById(id);
    }

    /**
     * ${table.comment!}删除(多个条目)
     *
     * @param ids
     * @return
     */
    @Override
    public void removes(List<Long> ids) throws UnifyException{
        removeByIds(ids);
    }
}
</#if>