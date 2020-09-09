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
 * 系统词典
 */
@Getter
@Setter
@Entity
@Table(name = "app_dictionary")
public class Dictionary extends BaseEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String dictionaryId;

    private String block;

    private String blockName;

    private String code;

    private String value;
}