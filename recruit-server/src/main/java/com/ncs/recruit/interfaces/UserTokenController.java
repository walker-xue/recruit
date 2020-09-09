package com.ncs.recruit.interfaces;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.skunk.core.BaseEntity;
import com.github.skunk.core.date.DateUtils;
import com.ncs.recruit.infrastructure.security.CustomUserDetailsService;
import com.ncs.recruit.infrastructure.security.UserTokenProvider;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Api(tags = "用户认证")
@RestController
@RequestMapping("token")
public class UserTokenController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserTokenProvider tokenProvider;
    @Autowired
    CustomUserDetailsService userDetailsService;

    /**
     * 获取用户tonek code　值
     *
     * @param loginVm
     * @return
     */
    @PostMapping("access")
    @ApiOperation(value = "获取用户Token", notes = "根据用户登录参数获取用户Token")
    public Token login(@RequestBody LoginVm loginVm) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(loginVm.getUserName(), loginVm.getPassword());
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginVm.getUserName());
        return new Token(tokenProvider.generateToken(userDetails));
    }

    @Setter
    @Getter
    class Token extends BaseEntity {

        private String accessToken;
        private Date now = DateUtils.nowDate();

        Token(String accessToken) {
            this.accessToken = accessToken;
        }

    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static class LoginVm extends BaseEntity {

        @ApiModelProperty(value = "用户名称", position = 1)
        private String userName;
        @ApiModelProperty(value = "密码", position = 2)
        private String password;

    }
}