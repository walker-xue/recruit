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
 * 评论表
 */
@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String commentId;
    private String creatorId;
    private Date gmtCreate;
    private Date gmtModified;
    private String modifier;
    private String instanceId;
    private String instanceType;
    private String commentType;
    private String context;
    private String isDeleted;
}