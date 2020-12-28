package com.lw.bean.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author yujun.wu
 * @version 1.0
 * @create date 2020/12/23 21:24
 * @Description: 定义一个列表查询Page超类
 */
@Data
public abstract class PageVO {
    @Min(value = 5,message = "分页最小5页")
    @Max(value = 100,message = "分页最大100页")
    @NotNull(message = "分页大小不能为空")
    private Long pageSize;

    @Min(value = 0,message = "分页数最小0")
    @Max(value = 10000,message = "分页数最大10000")
    @NotNull(message = "分页数不能为空")
    private Long pageNum;
}
