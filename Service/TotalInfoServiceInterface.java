package com.ustcyyw.Service;

import com.ustcyyw.vo.output.TotalInfoVo;

import java.util.Date;
import java.util.List;

/**
 * @Time : 2020年1月25日16:51:22
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 全国疫情信息Service接口 1.某时段内四种 人数数据 2.某时段内指定类 人数数据 3.某时刻四种 人数数据 4.某时刻内指定类 人数数据
 */

public interface TotalInfoServiceInterface {
    /**
     * 某时段内四种 人数数据
     *
     * @param start 时段开始时间
     * @param end   时段结束时间
     * @return 数据列表
     */
    List<TotalInfoVo> getFourTypeNumBetween(Date start, Date end);

    /**
     * 某时段内指定类 人数数据
     *
     * @param start      时段开始时间
     * @param end        时段结束时间
     * @param givenTypes 指定需要的列 1.确诊人数 2.疑似人数 3.治愈人数 4.死亡人数
     * @return 数据列表
     */
    List<TotalInfoVo> getGivenTypeNumBetween(Date start, Date end, List<Integer> givenTypes);

    /**
     * 某时刻四种 人数数据
     *
     * @param theTime 指定的时刻
     * @return 单条数据
     */
    TotalInfoVo getFourTypeNumAt(Date theTime);

    /**
     * 某时刻内指定类 人数数据
     *
     * @param theTime    指定的时刻
     * @param givenTypes 指定需要的列 1.确诊人数 2.疑似人数 3.治愈人数 4.死亡人数
     * @return 单条数据
     */
    TotalInfoVo getGivenTypeNumAt(Date theTime, List<Integer> givenTypes);
}
