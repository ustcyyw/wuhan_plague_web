package com.ustcyyw.vo.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @Time : 2020年1月28日14:04:32
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 前端传入的指定省区疫情信息查询参数类 指定查询某时刻
 */
public class DetailedTimeAtVo {
    @Pattern(regexp = "^\\d{1,2}-\\d{1,2} \\d{1,2}$", message = "指定时间格式错误，请传入e.g 5-24 16 表示5月24日16时")
    private String theTime;

    @Pattern(regexp = "^([1234],){0,3}[1234]$", message = "选项展示类别格式错误 请传入 e.g 2,3")
    private String givenType;

    @NotNull(message = "省区名不能为空")
    @Size(min = 2, max = 3, message = "省区名字最长为3 如 黑龙江， 最短为2 如台湾")
    private String province;

    public DetailedTimeAtVo() {

    }

    public Date getTheTime() {
        return FormatInput.getFormatDate(theTime);
    }

    public void setTheTime(String theTime) {
        this.theTime = theTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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
