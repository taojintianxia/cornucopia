package com.github.taojintianxia.cornucopia.temp;

public class CreateDataBaseGenerator {

    private static final String INSERT_DATA_BY_SYSBENCH = "sysbench oltp_read_only --mysql-host=10.12.3.114 --mysql-port=3306 --mysql-user=root --mysql-password='sphereEx@2021' --mysql-db=sbtest# --tables=5 --table-size=100 --report-interval=10 --time=3600 --threads=10 --max-requests=0 --percentile=99 --mysql-ignore-errors=\"all\" --rand-type=uniform --range_selects=off --auto_inc=off prepare";

    private static final String CREATE_DATABASE_SQL = "CREATE SCHEMA IF NOT EXISTS sbtest# ;";

    private static final String DROP_DATABASE_SQL = "DROP SCHEMA sbtest# ;";

    public static void main( String... args ) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(INSERT_DATA_BY_SYSBENCH.replace("#", i + ""));
        }
    }
}
