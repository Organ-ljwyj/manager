package com.lw.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.core.Local;
import org.springframework.util.Assert;

/**
 * @author yujun.wu
 * @version 1.0
 * @create date 2020/12/20 21:59
 * @Description: 自动实现属性相同对象转换
 */
@Slf4j
public class BuildBeanUtils {
    /**
     * @param sourceObject 源对象
     * @param targetClass  目标Class类型
     * @return 目标对象
     * @throws ReflectiveOperationException
     */
    public static <T> T copyProperties(Object sourceObject, Class targetClass) throws ReflectiveOperationException {
        Object targetObject = targetClass.newInstance();
        BeanUtils.copyProperties(sourceObject, targetObject);
        StringBuilder sb = new StringBuilder();
        sb.append("拷贝对象源数据失败,源对象{")
                .append(sourceObject.getClass().getSimpleName())
                .append("}目标对象{")
                .append(targetClass.getSimpleName())
                .append("}");
        Assert.notNull(targetObject, sb.toString());
        return (T) targetObject;
    }
}
