package com.ustcyyw.Service;

import com.ustcyyw.Dao.entity.TotalInfo;
import com.ustcyyw.Dao.repository.TotalInfoRepository;
import com.ustcyyw.vo.output.TotalInfoVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Time : 2020年1月25日16:39:13
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 全国疫情信息Service
 */

@Service
public class TotalInfoService implements TotalInfoServiceInterface {
    @Autowired
    private TotalInfoRepository totalInfoRepository;

    @Value("${data.key.diagnosis}")
    private String diagnosis;

    @Value("${data.key.suspect}")
    private String suspect;

    @Value("${data.key.cure}")
    private String cure;

    @Value("${data.key.death}")
    private String death;

    @Override
    public List<TotalInfoVo> getFourTypeNumBetween(Date start, Date end) {
        Date[] formatDate = FormatDate.getFormatDate(start, end);
        List<TotalInfoVo> result = getNumBetween(formatDate[0], formatDate[1]);
        if (result.size() > 0)
            return result;
        return null;
    }

    @Override
    public List<TotalInfoVo> getGivenTypeNumBetween(Date start, Date end, List<Integer> givenTypes) {
        Date[] formatDate = FormatDate.getFormatDate(start, end);
        List<TotalInfoVo> result = getNumBetween(formatDate[0], formatDate[1], givenTypes);
        if (result.size() > 0)
            return result;
        return null;
    }

    @Override
    public TotalInfoVo getFourTypeNumAt(Date theTime) {
        Date[] formatDate = FormatDate.getFormatDate(theTime);
        List<TotalInfoVo> tempResult = getNumBetween(formatDate[0], formatDate[1]);
        if (tempResult.size() > 0)
            return tempResult.get(0);
        return null;
    }

    @Override
    public TotalInfoVo getGivenTypeNumAt(Date theTime, List<Integer> givenTypes) {
        Date[] formatDate = FormatDate.getFormatDate(theTime);
        List<TotalInfoVo> tempResult = getNumBetween(formatDate[0], formatDate[1], givenTypes);
        if (tempResult.size() > 0)
            return tempResult.get(0);
        return null;
    }

    /**
     * 返回前端的数据列表
     *
     * @param start      指定初始时间
     * @param end        指定结束时间
     * @param givenTypes 指定需要的列 1.确诊人数 2.疑似人数 3.治愈人数 4.死亡人数
     * @return List<TotalInfoVo>
     */
    private List<TotalInfoVo> getNumBetween(Date start, Date end, List<Integer> givenTypes) {
        List<TotalInfo> selectedResult = totalInfoRepository.findByRecordingTimeBetween(start, end);
        List<TotalInfoVo> result = new ArrayList<>();
        for (TotalInfo one : selectedResult) {
            TotalInfoVo theInfo = new TotalInfoVo();
            theInfo.setTime(one.getRecordingTime());

            Map<String, Long> numData = new HashMap<>();
            if (givenTypes.contains(1)) numData.put(this.diagnosis, one.getDiagnosisNum());
            if (givenTypes.contains(2)) numData.put(this.suspect, one.getSuspectNum());
            if (givenTypes.contains(3)) numData.put(this.cure, one.getCureNum());
            if (givenTypes.contains(4)) numData.put(this.death, one.getDeathNum());

            theInfo.setNumData(numData);
            result.add(theInfo);
        }
        return result;
    }

    /**
     * 返回前端的数据列表 已指定所有列
     *
     * @param start 指定初始时间
     * @param end   指定结束时间
     * @return List<TotalInfoVo>
     */
    private List<TotalInfoVo> getNumBetween(Date start, Date end) {
        List<Integer> givenTypes = new ArrayList<>();
        givenTypes.add(1);
        givenTypes.add(2);
        givenTypes.add(3);
        givenTypes.add(4);
        return getNumBetween(start, end, givenTypes);
    }
}
