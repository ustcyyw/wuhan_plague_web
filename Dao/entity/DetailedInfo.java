package com.ustcyyw.Dao.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Time : 2020年1月27日15:35:57
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 代表各省区疫情信息的实体类, 暂时只允许查询不允许更改
 */
@Entity
@DynamicUpdate
@Table(name = "china_detail_info")
public class DetailedInfo {
    /**
     * 主键id
     */
    @Id
    private Long id;

    /**
     * 第几次记录
     */
    @Column(name = "count")
    private Long count;

    /**
     * 省区名字
     */
    @Column(name = "province")
    private String province;

    /**
     * 确诊人数
     */
    @Column(name = "diagnosis_num")
    private Long diagnosisNum;

    /**
     * 疑似人数
     */
    @Column(name = "suspect_num")
    private Long suspectNum;

    /**
     * 治愈人数
     */
    @Column(name = "cure_num")
    private Long cureNum;

    /**
     * 死亡人数
     */
    @Column(name = "death_num")
    private Long deathNum;

    /**
     * 记录时间
     */
    @Column(name = "recording_time")
    private Date recordingTime;

    public DetailedInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Long getDiagnosisNum() {
        return diagnosisNum;
    }

    public void setDiagnosisNum(Long diagnosisNum) {
        this.diagnosisNum = diagnosisNum;
    }

    public Long getSuspectNum() {
        return suspectNum;
    }

    public void setSuspectNum(Long suspectNum) {
        this.suspectNum = suspectNum;
    }

    public Long getCureNum() {
        return cureNum;
    }

    public void setCureNum(Long cureNum) {
        this.cureNum = cureNum;
    }

    public Long getDeathNum() {
        return deathNum;
    }

    public void setDeathNum(Long deathNum) {
        this.deathNum = deathNum;
    }

    public Date getRecordingTime() {
        return recordingTime;
    }

    public void setRecordingTime(Date recordingTime) {
        this.recordingTime = recordingTime;
    }

    @Override
    public String toString() {
        return "DetailedInfo{" +
                "id=" + id +
                ", count=" + count +
                ", province='" + province + '\'' +
                ", diagnosisNum=" + diagnosisNum +
                ", suspectNum=" + suspectNum +
                ", cureNum=" + cureNum +
                ", deathNum=" + deathNum +
                ", recordingTime=" + recordingTime +
                '}';
    }
}
