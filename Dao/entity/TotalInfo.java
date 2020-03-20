package com.ustcyyw.Dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Time : 2020年1月25日16:06:42
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 代表全国疫情信息的实体类, 暂时只允许查询不允许更改
 */

@Entity
@Table(name = "china_total_info")
public class TotalInfo {

    /**
     * 主键id
     */
    @Id
    private Long id;

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

    public TotalInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "TotalInfo{" +
                "id=" + id +
                ", diagnosisNum=" + diagnosisNum +
                ", suspectNum=" + suspectNum +
                ", cureNum=" + cureNum +
                ", deathNum=" + deathNum +
                ", recordingTime=" + recordingTime +
                '}';
    }
}
