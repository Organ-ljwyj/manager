package com.lw.bean.vo.student;

import com.lw.bean.vo.PageVO;
import lombok.Data;

/**
 * @author yujun.wu
 * @version 1.0
 * @create date 2020/12/23 21:31
 * @Description:类的具体作用描述
 */
@Data
public class StudentInfoPageVO extends PageVO {
    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 学生学号
     */
    private String stuNum;
}
