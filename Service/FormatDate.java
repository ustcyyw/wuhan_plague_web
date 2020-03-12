package com.ustcyyw.Service;

import java.util.Date;

/**
 * @Time : 2020年1月26日19:49:24
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 将输入时间格式化的功能函数
 */
public class FormatDate {
    /**
     * 将传入的两个时刻调整到正确的顺序
     *
     * @param start
     * @param end
     * @return 第一个元素较早，第二个元素较晚的Date[]
     */
    public static Date[] getFormatDate(Date start, Date end) {
        Date[] formatDate = new Date[2];
        if (start.compareTo(end) < 0) {
            formatDate[0] = start;
            formatDate[1] = end;
        } else {
            formatDate[0] = end;
            formatDate[1] = start;
        }
        return formatDate;
    }

    /**
     * 将制定时刻扩展成前后30min的时间段
     *
     * @param theTime 指定时刻
     * @return
     */
    public static Date[] getFormatDate(Date theTime) {
        Date[] formatDate = new Date[2];
        long timeNow = theTime.getTime();
        formatDate[0] = new Date(timeNow - 30 * 60 * 1000L);
        formatDate[1] = new Date(timeNow + 30 * 60 * 1000L);
        return formatDate;
    }
}
