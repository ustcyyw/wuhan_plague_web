package com.ustcyyw.vo.input;

import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

/**
 * @Time : 2020年1月28日13:59:43
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 前端传入的全国疫情信息查询参数类 指定查询的时间区间
 */
public class TotalTimeBetweenVo {
    @Pattern(regexp = "^\\d{1,2}-\\d{1,2} \\d{1,2}$", message = "指定时间格式错误，请传入e.g 5-24 16 表示5月24日16时")
    private String start;

    @Pattern(regexp = "^\\d{1,2}-\\d{1,2} \\d{1,2}$", message = "指定时间格式错误，请传入e.g 5-24 16 表示5月24日16时")
    private String end;

    @Pattern(regexp = "^([1234],){0,3}[1234]$", message = "选项展示类别格式错误 请传入 e.g 2,3")
    private String givenType;

    public TotalTimeBetweenVo() {

    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * 没有传入start时 设置为默认时间：记录最开始的时间
     *
     * @return
     */
    public Date getStart() {
        if (start == null)
            start = "1-22 0";
        return FormatInput.getFormatDate(start);
    }

    public Date getEnd() {
        return FormatInput.getFormatDate(end);
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
