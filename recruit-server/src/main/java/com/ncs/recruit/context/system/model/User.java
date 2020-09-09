package com.ncs.recruit.context.system.model;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.skunk.core.BaseEntity;
import com.github.skunk.core.bean.SpringBeanFactory;
import com.ncs.recruit.infrastructure.core.UUIdGenId;

import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * 用户表
 */
@Getter
@Setter
@Entity
@Table(name = "app_user")
public class User extends BaseEntity {

    private static final String DEFAULT_USER_PWD = "111111";

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String userId;

    private String workNum;

    private String userName;

    @JsonIgnore
    @JSONField(serialize = false)
    private String pswMd5;

    private String name;

    private String phoneNum;

    private String email;

    private String department;

    private String position;

    private String busiLines;

    @JsonIgnore
    @JSONField(serialize = false)
    private String isDeleted;

    private String remark;

    private Long creatorId;

    private Date gmtCreate;

    private String modifier;

    private Date gmtModified;

    public User() {
    }
    /**
     * @param workNum
     * @param userName
     * @param name
     * @param phoneNum
     * @param email
     * @param department
     * @param position
     * @param busiLines
     */
    public User(String workNum, String userName, String name, String phoneNum, String email, String department, String position,
        String busiLines) {
        this.workNum = workNum;
        this.userName = userName;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.department = department;
        this.position = position;
        this.busiLines = busiLines;
    }
    /**
     * 重置用户密码
     */
    public void rserUserPwd() {
        PasswordEncoder passwordEncoder = SpringBeanFactory.bean(PasswordEncoder.class);
        pswMd5 = passwordEncoder.encode(DEFAULT_USER_PWD);
    }

    /**
     * 重置用户密码
     */
    public void updateUserPwd(String oldPwd, String newPwd) {

        Validate.notBlank(newPwd);

        PasswordEncoder passwordEncoder = SpringBeanFactory.bean(PasswordEncoder.class);

        boolean matches = passwordEncoder.matches(oldPwd, pswMd5);
        if (!matches) {
            throw new RuntimeException("原始密码错误");
        }
        pswMd5 = passwordEncoder.encode(newPwd);
    }

    /**
     * 重置用户密码
     */
    public List<UserBusiLine> getBusiLines() {
        if (StringUtils.isBlank(busiLines)) {
            return Collections.emptyList();
        }
        return Stream.of(busiLines.split(",")).map(code -> new UserBusiLine(userId, code)).collect(Collectors.toList());
    }
}