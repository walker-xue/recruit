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
 * 用户登录记录表
 */
@Getter
@Setter
@Entity
@Table(name = "user_login_record")
public class UserLoginRecord extends BaseEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String userLoginRecordId;

    private String userId;

    private String creatorId;

    private Date gmtCreate;

    private Date gmtModified;

    private String modifier;

    private Integer failType;

    private String failInformation;

    private String isDeleted;

    private String remark;

}