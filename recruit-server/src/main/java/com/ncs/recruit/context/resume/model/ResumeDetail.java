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
 * 应聘者的简历详情
 */
@Getter
@Setter
@Entity
@Table(name = "resume_detail")
public class ResumeDetail extends BaseEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String resumeDetailId;

    private String resumeId;

    private Date gmtCreate;

    private String modifier;

    private Date gmtModified;

    private String detType;

    private Date startTime;

    private Date endTime;

    private String detContext;

    private String isDeleted;

    private String remark;
}