package com.ncs.recruit.infrastructure.security;

import com.github.skunk.core.exception.BaseException;

public class UnauthorizedException extends BaseException {

    private String message = "未授权异常";
    /**
     * 异常对应的返回码
     */
    private Integer code = Integer.valueOf(401);

    public UnauthorizedException(String message) {
        super(message);
        this.message = message;
    }

}
