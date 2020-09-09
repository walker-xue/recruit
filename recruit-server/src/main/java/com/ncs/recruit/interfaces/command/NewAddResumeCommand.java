package com.ncs.recruit.interfaces.command;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewAddResumeCommand {

    @NotBlank
    @ApiModelProperty("姓名")
    private String name;

    @NotBlank
    @ApiModelProperty("身份证")
    private String idCard;

    @NotBlank
    @Pattern(regexp = "M|F")
    @ApiModelProperty("性别")
    private String gender;

    @Past
    @NotNull
    @ApiModelProperty("出生日期")
    private Date birthday;

    @ApiModelProperty("籍贯")
    private String originPlace;

    @ApiModelProperty("电话号码")
    private String phoneNum;

    @Email
    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("工作年限")
    private Float workYear;

    @ApiModelProperty("应聘岗位")
    private String station;

    @ApiModelProperty("自我评价")
    private String selfEval;

    @ApiModelProperty("居住地")
    private String residence;

    @ApiModelProperty("期望工作地")
    private String expPlace;

    @ApiModelProperty("电话号码")
    private Integer resumeType;

    @ApiModelProperty("简历附件的存放路径")
    private String storagePath;

    @ApiModelProperty("简历基本信息备注")
    private String infoRemark;

    @ApiModelProperty("工作经验")
    private List<DetailContext> workExperience;

    @ApiModelProperty("教育背景")
    private List<DetailContext> eduExperience;

    @ApiModelProperty("培训经历")
    private List<DetailContext> trainingExperience;

    @ApiModelProperty("IT技能")
    private List<DetailContext> itSkills;

    @ApiModelProperty("证书")
    private List<DetailContext> certificates;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static class DetailContext {

        @ApiModelProperty("详情类型：如，工作经历，教育经历，培训经历")
        private String detType;

        @Past
        @ApiModelProperty("详情类型的起始时间")
        private Date startTime;

        @Past
        @ApiModelProperty("详情类型的起始时间")
        private Date endTime;

        @ApiModelProperty("详情类型的内容")
        private String detContext;

    }
}
