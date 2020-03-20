package com.ustcyyw.Dao.repository;

import com.ustcyyw.Dao.entity.TotalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Time : 2020年1月25日16:34:39
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc :
 */

@Repository
public interface TotalInfoRepository extends JpaRepository<TotalInfo, Long> {
    /**
     * 查找两个时刻间所有 TotalInfo
     *
     * @param start 开始时刻
     * @param end   结束时刻
     * @return
     */
    List<TotalInfo> findByRecordingTimeBetween(Date start, Date end);
}
