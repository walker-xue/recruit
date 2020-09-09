package com.ncs.recruit.infrastructure.security;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ncs.recruit.context.system.UserService;
import com.ncs.recruit.context.system.model.User;

/**
 * Spring Security 查找用户实现ｌ
 *
 * @author walker
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if (user == null) {
            throw new BadCredentialsException(String.format("用户[%s]未找到", username));
        }
        // 用户权限列表，根据用户拥有的权限标识与如 @PreAuthorize("hasAuthority('sys:menu:view')") 标注的接口对比，决定是否可以调用接口

        Set<String> permissions = userService.findPermissions(username);
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(CustomGrantedAuthority::new).collect(Collectors.toList());
        return new CustomUserDetails(username, user.getPswMd5(), grantedAuthorities);
    }
}