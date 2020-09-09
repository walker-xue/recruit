package com.ncs.recruit.interfaces.core;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ncs.recruit.infrastructure.security.CustomUserDetails;

/**
 * 通用 Resource
 */
public abstract class BaseController {

    protected static final String SUCESS = "OK";
    protected static final String FAIL = "ERROR";

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @PostConstruct
    private void initPermCheck() {

    }

    /**
     * 获取当前登录的用户
     *
     * @return
     */
    public String CurrentUserId() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
