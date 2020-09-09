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
 * 角色权限表
 */
@Getter
@Setter
@Entity
@Table(name = "app_role_authority")
public class RoleAuthority extends BaseEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String roleAuthorityId;
    private String roleId;
    private String authorityId;
    private Date gmtCreate;
    private String creatorId;
    private String modifier;
    private Date gmtModified;
    private String isDeleted;
    private String remark;
}