package com.ncs.recruit.context.demand.model;

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
 * 招聘需求
 */
@Getter
@Setter
@Entity
@Table(name = "job_demand")
public class JobDemand extends BaseEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String jobDemandId;

    private String demandNum;

    private String creatorId;

    private Date gmtCreate;

    private String modifier;

    private Date gmtModified;

    private String department;

    private String projectName;

    private String projectNum;

    private String busiLine;

    private String isDeleted;

    private String remark;

}