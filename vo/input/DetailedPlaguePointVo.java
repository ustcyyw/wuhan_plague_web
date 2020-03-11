package com.ustcyyw.vo.input;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @Time : 2020年1月28日14:10:56
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 获取全国各省区疫情指数的vo
 */
public class DetailedPlaguePointVo {
    @Pattern(regexp = "^\\d{1,2}-\\d{1,2} \\d{1,2}$", message = "指定时间格式错误，请传入e.g 5-24 16 表示5月24日16时")
    private String theTime;

    public DetailedPlaguePointVo() {

    }

    public void setTheTime(String theTime) {
        this.theTime = theTime;
    }

    public Date getTheTime() {
        return FormatInput.getFormatDate(theTime);
    }
}
