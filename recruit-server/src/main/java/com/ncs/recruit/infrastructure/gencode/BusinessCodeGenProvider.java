package com.ncs.recruit.infrastructure.gencode;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.github.skunk.core.bean.SpringBeanFactory;
import com.github.skunk.core.date.DateUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 生成业务编号
 * <p>
 * 目前只支持MySQL
 *
 * @author walker
 * @version 0.0.1
 */
@Slf4j
public class BusinessCodeGenProvider {

    private static BusinessCodeGenProvider lazySingleton = null;

    private final static String GET_RULE_SQL = "SELECT * FROM s2k_code_rule WHERE CODE= ?";

    private final static String UPDATE_RULE_SQL = "REPLACE INTO s2k_code_rule (CODE, PREFIX, DATE_FORMAT, START_VALUE, SN_LENGTH, START_DATE) VALUES (?, ?, ?, ?, ?, ?) ";

    private JdbcTemplate jdbcTemplate;
    private DbProductType dbType;

    private BusinessCodeGenProvider() {
        jdbcTemplate = SpringBeanFactory.bean(JdbcTemplate.class);
        try {
            DatabaseMetaData md = jdbcTemplate.getDataSource().getConnection().getMetaData();
            dbType = DbProductType.valueOf(md.getDatabaseProductName());
            jdbcTemplate.execute(DbSQLDefinition.CREATE_MYSQL_TABLE_SQL);
        } catch (SQLException e) {
            log.error(e.getLocalizedMessage(), e);
            e.printStackTrace();
        }

    }

    public synchronized static BusinessCodeGenProvider getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new BusinessCodeGenProvider();
        }
        return lazySingleton;
    }

    private static Map<String, BizRule> bizRuleMap = new HashMap<>();

    /**
     * @param bizCode
     * @return
     */
    public synchronized String createCode(String bizCode) {

        BizRule rule = checkUpRule(bizCode);

        if (Objects.isNull(rule)) {
            rule = bizRuleMap.get(bizCode);
        }

        Date now = DateUtils.nowDate();
        DateFormat format = new SimpleDateFormat(rule.dateFormat);
        String dateValue = format.format(now);

        if (StringUtils.isNoneBlank(rule.startDate) && !dateValue.equals(rule.startDate)) {
            rule.startValue = 0;
        }
        String joinWith = StringUtils.joinWith(
            "",
            rule.prefix,
            dateValue, StringUtils.leftPad(String.valueOf(rule.startValue), rule.snLength, '0')
        );

        ++rule.startValue;
        rule.startDate = dateValue;
        saveRule(rule);
        return joinWith;
    }

    /**
     * 添加规则
     *
     * @param code
     * @param prefix
     * @param dateFormat
     * @param snLength
     */
    public void addCodeRule(String code, String prefix, String dateFormat, int snLength) {

        Validate.notBlank(code);
        Validate.notBlank(dateFormat);
        Validate.isTrue(snLength > 0);
        Validate.notBlank(code);

        BizRule rule = BizRule.builder()
            .code(code)
            .dateFormat(dateFormat)
            .prefix(prefix)
            .snLength(snLength).build();

        bizRuleMap.put(rule.code, rule);
    }

    /**
     * @param bizCode
     * @return
     */
    private BizRule checkUpRule(@NotNull final String bizCode) {

        Validate.notBlank(bizCode);

        try {
            return jdbcTemplate.queryForObject(GET_RULE_SQL, new BizRule(), new Object[] { bizCode });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * @param rule
     */
    private void saveRule(@NotNull BizRule rule) {

        Objects.requireNonNull(rule);

        Object params[] = { rule.code, rule.prefix, rule.dateFormat, rule.startValue, rule.snLength, rule.startDate };

        jdbcTemplate.update(UPDATE_RULE_SQL, params);
    }

    /**
     *
     */
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class BizRule implements RowMapper<BizRule> {

        String code;
        String prefix;
        String dateFormat;
        int startValue;
        int snLength;
        String startDate;

        @Override
        public BizRule mapRow(ResultSet rs, int rowNum) throws SQLException {

            return new BizRule(
                rs.getString("code"),
                rs.getString("prefix"),
                rs.getString("date_format"),
                rs.getInt("start_value"),
                rs.getInt("sn_length"),
                rs.getString("start_date")
            );
        }

    }

    enum DbProductType {

        MySQL("MySQL"),
        Oracle("Oracle");

        String productType;

        DbProductType(String type) {
            productType = type;
        }

    }
}
