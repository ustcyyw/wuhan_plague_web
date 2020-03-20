package com.ustcyyw.Dao.repository;

import com.ustcyyw.Dao.entity.DetailedInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @Time : 2020年1月27日15:43:42
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc :
 */
public interface DetailedInfoRepository extends JpaRepository<DetailedInfo, Long> {
    /**
     * 查找两个时刻间某省区 疫情记录
     *
     * @param start    开始时刻
     * @param end      结束时刻
     * @param province 指定省区
     * @return
     */
    List<DetailedInfo> findByProvinceAndRecordingTimeBetween(String province, Date start, Date end);

    /**
     * 查找两个时刻间所有省区 疫情记录
     *
     * @param start 开始时刻
     * @param end   结束时刻
     * @return
     */
    List<DetailedInfo> findByRecordingTimeBetween(Date start, Date end);
}
