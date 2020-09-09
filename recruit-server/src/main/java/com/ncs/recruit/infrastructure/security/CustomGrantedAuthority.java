package com.ncs.recruit.infrastructure.security;

import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {

    private static final long serialVersionUID = -4840085496357624893L;

    private String authority;

    public CustomGrantedAuthority(String authority) {

        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
