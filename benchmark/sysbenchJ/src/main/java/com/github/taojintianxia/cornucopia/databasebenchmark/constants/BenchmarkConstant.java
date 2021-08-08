package com.github.taojintianxia.cornucopia.databasebenchmark.constants;

import java.util.Arrays;
import java.util.List;

public class BenchmarkConstant {

    private final static List<String> SCRIPT_NAME_LIST = Arrays.asList("oltp_point_select", "oltp_read_only", "oltp_read_write", "oltp_update_index",
                                                                       "oltp_update_non_index", "oltp_write_only", "oltp_delete");
    public final static String TABLES = "tables";

    public final static String TABLE_SIZE = "table-size";

    public final static String REPORT_INTERVAL = "report-interval";

    public final static String DB_DRIVER = "db-driver";

    public final static String PERCENTILE = "percentile";

    public final static String MYSQL_HOST = "mysql-host";

    public final static String MYSQL_USER = "mysql-user";

    public final static String MYSQL_PASSWORD = "mysql-password";

    public final static String MYSQL_DB = "mysql-db";

    public final static String PGSQL_DB_DRIVER = "pgsql";

    public final static String PGSQL_PORT = "pgsql-port";

    public static List<String> getScriptNameList() {
        return SCRIPT_NAME_LIST;
    }
}
