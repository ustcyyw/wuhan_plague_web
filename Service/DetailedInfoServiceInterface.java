package com.ustcyyw.Service;

import com.ustcyyw.vo.output.DetailedInfoVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Time : 2020年1月27日15:31:46
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 指定省区疫情信息Service接口
 * 1.某时段内四种 人数数据 2.某时段内指定类 人数数据 3.某时刻四种 人数数据 4.某时刻内指定类 人数数据
 * 5.计算某时刻各省区疫情指数（计算公式自定）
 */
public interface DetailedInfoServiceInterface {
    /**
     * 指定省区某时段内四种 人数数据
     *
     * @param start    时段开始时间
     * @param end      时段结束时间d
     * @param province 指定省区
     * @return
     */
    List<DetailedInfoVo> getFourTypeNumBetweenInProvince(Date start, Date end, String province);

    /**
     * 指定省区某时段内四种 人数数据
     *
     * @param start      时段开始时间
     * @param end        时段结束时间d
     * @param givenTypes 指定需要的列 1.确诊人数 2.疑似人数 3.治愈人数 4.死亡人数
     * @param province   指定省区
     * @return
     */
    List<DetailedInfoVo> getGivenTypeNumBetweenInProvince(Date start, Date end, List<Integer> givenTypes, String province);

    /**
     * 指定省区某时刻四种 人数数据
     *
     * @param theTime  指定的时刻
     * @param province 指定省区
     * @return 单条数据
     */
    DetailedInfoVo getFourTypeNumAtInProvince(Date theTime, String province);

    /**
     * 指定省区某时刻内指定类 人数数据
     *
     * @param theTime    指定的时刻
     * @param givenTypes 指定需要的列 1.确诊人数 2.疑似人数 3.治愈人数 4.死亡人数
     * @param province   指定省区
     * @return 单条数据
     */
    DetailedInfoVo getGivenTypeNumAtInProvince(Date theTime, List<Integer> givenTypes, String province);

    /**
     * 指定时刻 全国所有省区的疫情指数
     *
     * @param theTime 指定的时刻
     * @return
     */
    Map<String, Long> getProvincePlaguePoint(Date theTime);
}
