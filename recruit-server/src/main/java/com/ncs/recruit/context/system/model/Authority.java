package com.ncs.recruit.context.system.model;

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
 * 权限配置表
 */
@Getter
@Setter
@Entity
@Table(name = "app_authority")
public class Authority extends BaseEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String authorityId;
    private String creatorId;
    private Date gmtCreate;
    private String modifier;
    private Date gmtModified;
    private String isDeleted;
    private String authorityName;
    private String pageName;
}