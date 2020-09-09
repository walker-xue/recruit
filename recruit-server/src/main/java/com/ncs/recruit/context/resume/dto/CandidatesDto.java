package com.ncs.recruit.context.resume.dto;

import javax.persistence.Id;

import com.github.skunk.core.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 应聘者的简历
 */
@Getter
@Setter
public class CandidatesDto extends BaseEntity {

    @Id
    private Long resumeId;

    private String resumeNum;

    private Long demandId;

    private String name;

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

    private String storagePath;

    private String infoRemark;

    private String stateRemark;

}