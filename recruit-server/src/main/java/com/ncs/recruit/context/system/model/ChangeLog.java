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
 * 变更日志记录
 */
@Getter
@Setter
@Entity
@Table(name = "change_log")
public class ChangeLog extends BaseEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String changeLogId;

    private Date gmtCreate;

    private String creatorId;

    private String modifier;

    private Date gmtModified;

    private String isDeleted;

    private String oriValue;

    private String newValue;

    private String entityId;

    private String entityName;

    private String entityField;

    private String remark;

    public ChangeLog() {
    }

    public ChangeLog(Object oriValue, Object newValue, String field) {
        this.oriValue = String.valueOf(oriValue);
        this.newValue = String.valueOf(newValue);
        this.entityField = field;
    }

}