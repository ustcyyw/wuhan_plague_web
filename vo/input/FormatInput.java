package com.ustcyyw.vo.input;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Time : 2020年1月28日13:49:12
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 将传入的表示时间的简略字符串进行格式化
 */
public class FormatInput {
    public static Date getFormatDate(String theTime) {
        if (theTime == null)
            return new Date();
        String temp = "2020-" + theTime + ":00:00";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return df.parse(temp);
        } catch (ParseException pe) {
            return new Date();
        }
    }

    public static List<Integer> getFormatGivenType(String givenTypeString){
        if (givenTypeString == null)
            return null;
        List<Integer> givenType = new ArrayList<>();
        String[] types = givenTypeString.split(",");
        for(String type : types)
            givenType.add(Integer.parseInt(type));
        return givenType;
    }
}
