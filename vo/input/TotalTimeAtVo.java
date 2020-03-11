package com.ustcyyw.vo.input;

import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

/**
 * @Time : 2020年1月28日12:57:14
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 前端传入的全国疫情信息查询参数类 指定查询某时刻
 */
public class TotalTimeAtVo {
    @Pattern(regexp = "^\\d{1,2}-\\d{1,2} \\d{1,2}$", message = "指定时间格式错误，请传入e.g 5-24 16 表示5月24日16时")
    private String theTime;

    @Pattern(regexp = "^([1234],){0,3}[1234]$", message = "选项展示类别格式错误 请传入 e.g 2,3")
    private String givenType;

    public TotalTimeAtVo() {
    }

    public void setTheTime(String theTime) {
        this.theTime = theTime;
    }

    public Date getTheTime() {
        return FormatInput.getFormatDate(theTime);
    }

    /**
     * 如果没有传入选择类型 会返回null
     *
     * @return
     */
    public List<Integer> getGivenType() {
        return FormatInput.getFormatGivenType(givenType);
    }

    public void setGivenType(String givenType) {
        this.givenType = givenType;
    }
}
