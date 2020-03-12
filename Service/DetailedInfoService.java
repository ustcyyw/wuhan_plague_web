package com.ustcyyw.Service;

import com.ustcyyw.Dao.entity.DetailedInfo;
import com.ustcyyw.Dao.repository.DetailedInfoRepository;
import com.ustcyyw.vo.output.DetailedInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Time : 2020年1月27日15:47:57
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 省市疫情信息service
 */
@Service
public class DetailedInfoService implements DetailedInfoServiceInterface {
    @Autowired
    private DetailedInfoRepository detailedInfoRepository;

    @Value("${data.key.diagnosis}")
    private String diagnosis;

    @Value("${data.key.suspect}")
    private String suspect;

    @Value("${data.key.cure}")
    private String cure;

    @Value("${data.key.death}")
    private String death;

    @Override
    public List<DetailedInfoVo> getFourTypeNumBetweenInProvince(Date start, Date end, String province) {
        Date[] formatDate = FormatDate.getFormatDate(start, end);
        List<DetailedInfoVo> result = getNumBetweenInProvince(formatDate[0], formatDate[1], province);
        if (result.size() > 0)
            return result;
        return null;
    }

    @Override
    public List<DetailedInfoVo> getGivenTypeNumBetweenInProvince(Date start, Date end, List<Integer> givenTypes, String province) {
        Date[] formatDate = FormatDate.getFormatDate(start, end);
        List<DetailedInfoVo> result = getNumBetweenInProvince(formatDate[0], formatDate[1], givenTypes, province);
        if (result.size() > 0)
            return result;
        return null;
    }

    @Override
    public DetailedInfoVo getFourTypeNumAtInProvince(Date theTime, String province) {
        Date[] formatDate = FormatDate.getFormatDate(theTime);
        List<DetailedInfoVo> tempResult = getNumBetweenInProvince(formatDate[0], formatDate[1], province);
        if (tempResult.size() > 0)
            return tempResult.get(0);
        return null;
    }

    @Override
    public DetailedInfoVo getGivenTypeNumAtInProvince(Date theTime, List<Integer> givenTypes, String province) {
        Date[] formatDate = FormatDate.getFormatDate(theTime);
        List<DetailedInfoVo> tempResult = getNumBetweenInProvince(formatDate[0], formatDate[1], givenTypes, province);
        if (tempResult.size() > 0)
            return tempResult.get(0);
        return null;
    }

    @Override
    public Map<String, Long> getProvincePlaguePoint(Date theTime) {
        Date[] formatDate = FormatDate.getFormatDate(theTime);
        List<DetailedInfo> recordings = detailedInfoRepository.findByRecordingTimeBetween(formatDate[0], formatDate[1]);
        if (recordings.size() > 0) {
            Long count = recordings.get(0).getCount();
            Map<String, Long> result = new HashMap<>();
            for(DetailedInfo recording : recordings){
                if (recording.getCount() != count)
                    break;
                Long plaguePoint = recording.getDiagnosisNum() * 5 + recording.getSuspectNum() * 1 +
                        recording.getDeathNum() * 10 - recording.getCureNum() * 7;
                result.put(recording.getProvince(), plaguePoint);
            }
            return result;
        }
        return null;
    }

    /**
     * 返回前端的数据列表
     *
     * @param start      指定初始时间
     * @param end        指定结束时间
     * @param givenTypes 指定需要的列 1.确诊人数 2.疑似人数 3.治愈人数 4.死亡人数
     * @return List<DetailedInfoVo>
     */
    private List<DetailedInfoVo> getNumBetweenInProvince(Date start, Date end, List<Integer> givenTypes, String province) {
        List<DetailedInfo> selectedResult = detailedInfoRepository.findByProvinceAndRecordingTimeBetween(province, start, end);
        List<DetailedInfoVo> result = new ArrayList<>();
        for (DetailedInfo one : selectedResult) {
            DetailedInfoVo theInfo = new DetailedInfoVo();
            theInfo.setTime(one.getRecordingTime());
            theInfo.setProvince(one.getProvince());

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
    private List<DetailedInfoVo> getNumBetweenInProvince(Date start, Date end, String province) {
        List<Integer> givenTypes = new ArrayList<>();
        givenTypes.add(1);
        givenTypes.add(2);
        givenTypes.add(3);
        givenTypes.add(4);
        return getNumBetweenInProvince(start, end, givenTypes, province);
    }
}
