package com.ncs.recruit.context.system.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ncs.recruit.infrastructure.core.UUIdGenId;

import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * 用户角色表
 */
@Getter
@Setter
@Entity
@Table(name = "app_user_role")
public class UserRole {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String userRoleId;

    private String userId;

    private String roleId;

    private Date gmtCreate;

    private String creatorId;

    private String modifier;

    private Date gmtModified;

    private String isDeleted;

    private String remark;

}