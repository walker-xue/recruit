package com.ncs.recruit.infrastructure;

import java.sql.DatabaseMetaData;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ncs.recruit.BaseTest;
import com.ncs.recruit.infrastructure.gencode.BusinessCodeGenProvider;

import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class BusinessCodeProviderTest extends BaseTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws Exception {
        log.info(jdbcTemplate.toString());

        DatabaseMetaData md = this.jdbcTemplate.getDataSource().getConnection().getMetaData();
        System.out.println(md.getDatabaseProductName());
        System.out.println(md.getDatabaseProductVersion());

    }

    @Test
    public void createCode() {
        BusinessCodeGenProvider codeProvider = BusinessCodeGenProvider.getInstance();
        codeProvider.addCodeRule("USER", "", "yyyyMMdd", 3);
        String user = codeProvider.createCode("USER");
        log.info(user);
    }

}
