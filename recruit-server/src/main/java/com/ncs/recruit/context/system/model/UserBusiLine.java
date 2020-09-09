package com.ncs.recruit.context.system.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.skunk.core.BaseEntity;
import com.ncs.recruit.infrastructure.core.UUIdGenId;

import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * 业务线
 */
@Getter
@Setter
@Entity
@Table(name = "user_busi_line")
public class UserBusiLine extends BaseEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String busiLineUserId;

    private String userId;
    private String dictionaryId;

    public UserBusiLine(String userId, String dictionaryId) {
        this.userId = userId;
        this.dictionaryId = dictionaryId;
    }
}