package com.ncs.recruit.context.resume.dto;

import java.util.Date;
import java.util.List;

import com.ncs.recruit.context.resume.model.ResumeDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResumeAndDetailDto {

    private Long resumeId;

    private String resumeNum;

    private Long demandId;

    private String name;

    private String idCard;

    private String gender;

    private Date birthday;

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

    private List<ResumeDetail> resumeDetailList;

}