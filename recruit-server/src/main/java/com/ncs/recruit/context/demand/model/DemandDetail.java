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
 * 需求详情
 */
@Getter
@Setter
@Entity
@Table(name = "demand_detail")
public class DemandDetail extends BaseEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String demandDetailId;

    private String recruitmentConsultantId;

    private String demandId;

    private Date gmtCreate;

    private String modifier;

    private Date gmtModified;

    private String station;

    private Integer needCount;

    private Date arrivalTime;

    private String techLevel;

    private Long demandDetailState;

    private String stationRequire;

    private String isDeleted;

    private String remark;

}