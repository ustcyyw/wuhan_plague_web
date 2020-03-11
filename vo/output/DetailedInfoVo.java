package com.ustcyyw.vo.output;

import java.util.Date;
import java.util.Map;

/**
 * @Time : 2020年1月27日16:13:03
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 传给前端的地区疫情信息
 */
public class DetailedInfoVo {
    /**
     * 数据记录的时刻
     */
    private Date time;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 省区名字
     */
    private String province;

    /**
     * 记录 确诊 疑似 死亡 治愈的人数信息
     */
    private Map<String, Long> numData;

    public DetailedInfoVo() {
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Map<String, Long> getNumData() {
        return numData;
    }

    public void setNumData(Map<String, Long> numData) {
        this.numData = numData;
    }

    @Override
    public String toString() {
        return "DetailedInfoVo{" +
                "time=" + time +
                ", province='" + province + '\'' +
                ", numData=" + numData +
                '}';
    }
}
