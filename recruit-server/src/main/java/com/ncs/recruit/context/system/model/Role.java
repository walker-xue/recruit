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
 * 角色表
 */
@Getter
@Setter
@Entity
@Table(name = "app_role")
public class Role extends BaseEntity {

    @Id

    @KeySql(genId = UUIdGenId.class)
    private String roleId;

    private String creatorId;

    private Date gmtCreate;

    private String modifier;

    private Date gmtModified;

    private String isDeleted;

    private String roleKey;

    private String roleValue;

}