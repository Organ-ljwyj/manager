package com.lw.bean.vo;

import lombok.Data;

/**
 * @author yujun.wu
 * @version 1.0
 * @create date 2020/12/23 21:24
 * @Description: 定义一个列表查询Page超类
 */
@Data
public abstract class PageVO {
    private Integer pageSize;
    private Integer pageNum;
}
