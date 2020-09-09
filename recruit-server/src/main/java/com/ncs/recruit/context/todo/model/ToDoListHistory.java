package com.ncs.recruit.context.todo.model;

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
 * 待处理事项历史表
 */
@Getter
@Setter
@Entity
@Table(name = "to_do_list_history")
public class ToDoListHistory extends BaseEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String toDoListHistoryId;

    private String creatorId;

    private Date gmtCreate;

    private Date gmtModified;

    private String modifier;

    private String handlerId;

    private Date endTime;

    private String assigneType;

    private String instanceType;

    private String instanceId;

    private Integer version;

    private String isDeleted;

    private String remark;

}