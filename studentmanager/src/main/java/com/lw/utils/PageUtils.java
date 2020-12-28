package com.lw.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author yujun.wu
 * @version 1.0
 * @create date 2020/12/19 20:45
 * @Description:类的具体作用描述
 */

public class PageUtils {
    /**
     * 获取分页数据
     */
    public static Page page(long current, long size){
        Page page = new Page();
        page.setCurrent(current);
        page.setSize(size);
        return page;
    }

}
