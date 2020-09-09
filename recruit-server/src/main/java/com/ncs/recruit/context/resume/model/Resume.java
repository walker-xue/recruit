package com.ncs.recruit.context.resume.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.skunk.core.BaseEntity;
import com.ncs.recruit.infrastructure.core.UUIdGenId;

import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * 应聘者的简历
 */
@Getter
@Setter
@Entity
@Table(name = "resume")
public class Resume extends BaseEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String resumeId;

    private String resumeNum;

    private String creatorId;

    private Date gmtCreate;

    private String demandId;

    private String modifier;

    private Date gmtModified;

    private String name;

    private String idCard;

    private String gender;

    private String birthday;

    private String originPlace;

    private String phoneNum;

    private String email;

    private Float workYear;

    private String station;

    private String selfEval;

    private Integer resState;

    private String residence;

    private String expPlace;

    private Integer resumeType;

    private String isDeleted;

    private String storagePath;

    private String infoRemark;

    private String stateRemark;

    public Resume() {
    }
    
    public Resume(String resumeNum, String name, String idCard, String gender, String birthday, String originPlace, String phoneNum, String email,
        Float workYear, String station, String selfEval, Integer resState, String residence, String expPlace, Integer resumeType, String storagePath,
        String stateRemark) {
        this.resumeNum = resumeNum;
        this.name = name;
        this.idCard = idCard;
        this.gender = gender;
        this.birthday = birthday;
        this.originPlace = originPlace;
        this.phoneNum = phoneNum;
        this.email = email;
        this.workYear = workYear;
        this.station = station;
        this.selfEval = selfEval;
        this.resState = resState;
        this.residence = residence;
        this.expPlace = expPlace;
        this.resumeType = resumeType;
        this.storagePath = storagePath;
        this.stateRemark = stateRemark;
    }
}