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
 * 应聘者的简历操作
 */
@Getter
@Setter
@Entity
@Table(name = "resume_docking")
public class ResumeDocking extends BaseEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String resumeDockingId;

    private String creatorId;

    private Date gmtCreate;

    private Date gmtModified;

    private String modifier;

    private String resumeId;

    private String demandDetailId;

    private String demandId;

    private Integer resumeState;

    private String isPass;

    private String information;

    private String expectationSalary;

    private String isDeleted;
    private String remark;

}