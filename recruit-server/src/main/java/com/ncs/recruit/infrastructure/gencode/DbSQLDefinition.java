package com.ncs.recruit.infrastructure.gencode;

/**
 * DB SQL 定义
 *
 *
 * @author walker
 */
public class DbSQLDefinition {

    static final String CREATE_MYSQL_TABLE_SQL = "CREATE TABLE IF NOT EXISTS `s2k_code_rule` (\n"
        + "  `code` varchar(32) DEFAULT NULL,\n"
        + "  `prefix` varchar(16) DEFAULT NULL,\n"
        + "  `date_format` varchar(32) DEFAULT NULL,\n"
        + "  `start_value` int(4) DEFAULT NULL,\n"
        + "  `sn_length` int(3) DEFAULT NULL,\n"
        + "  `start_date` varchar(10) DEFAULT NULL,\n"
        + "  UNIQUE KEY `s2k_code_rule_UN` (`code`)\n"
        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='业务时间码'";
}
