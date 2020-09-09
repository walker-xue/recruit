package com.ncs.recruit.infrastructure.security;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ncs.recruit.BaseTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BCryptPasswordEncoderTest extends BaseTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void encodePassword() {
        String value = "123456";

        log.info("" + passwordEncoder.matches(value, "$2a$10$AglbaeTq.swmQyQLCkys9uAq82UY1lQ6zMP75.u46OrAImz9g.6/C"));
    }

}
