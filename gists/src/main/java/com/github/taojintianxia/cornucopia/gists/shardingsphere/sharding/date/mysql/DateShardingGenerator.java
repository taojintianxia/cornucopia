package com.github.taojintianxia.cornucopia.gists.shardingsphere.sharding.date.mysql;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateShardingGenerator {
    
    private static final String DATASOURCE_TEMPLATE = "  ds_${DATE}:\n" +
            "    url: jdbc:mysql://${IP}:3306/ds_${DATE}?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true\n" +
            "    username: shardpmsdb\n" +
            "    password: pmsdb1234!\n" +
            "    connectionTimeoutMilliseconds: 30000\n" +
            "    idleTimeoutMilliseconds: 60000\n" +
            "    maxLifetimeMilliseconds: 1800000\n" +
            "    maxPoolSize: 50\n" +
            "    minPoolSize: 1";
    private static final List<String> DATASOURCE_LIST = Arrays.asList(
            "rm-z2q602zdlvx3r365f.mysql.rds.xscloud-test.test",
            "rm-z2q556ly84013r245.mysql.rds.xscloud-test.test",
            "rm-z2qo5qr4111gi44pw.mysql.rds.xscloud-test.test",
            "rm-z2qfx1zadyl843n20.mysql.rds.xscloud-test.test",
            "rm-z2qoor4aunf6f1ju2.mysql.rds.xscloud-test.test",
            "rm-z2qr10wufr8z6du8j.mysql.rds.xscloud-test.test",
            "rm-z2qg2wc9z400q9t2s.mysql.rds.xscloud-test.test",
            "rm-z2qt80kc301li9873.mysql.rds.xscloud-test.test",
            "rm-z2q6759lgb1rfpg24.mysql.rds.xscloud-test.test",
            "rm-z2qup20b05mj60p7m.mysql.rds.xscloud-test.test",
            "rm-z2qn29dc8g34tb476.mysql.rds.xscloud-test.test",
            "rm-z2q1vuf4uihh22sgi.mysql.rds.xscloud-test.test",
            "rm-z2qu5zq3h178x363b.mysql.rds.xscloud-test.test",
            "rm-z2qj63xt1i06z1rso.mysql.rds.xscloud-test.test",
            "rm-z2q7209m4202a1uuy.mysql.rds.xscloud-test.test",
            "rm-z2q42j68851wxpe7q.mysql.rds.xscloud-test.test"
    );
    
    public static void main(String... args) {
        generateDate();
    }
    
    private static void generateDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2021);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(Calendar.YEAR, 2027);
        endCalendar.set(Calendar.MONTH, Calendar.DECEMBER);
        int i = 0;
        StringBuilder datasourceBuilder = new StringBuilder();
        while (!calendar.after(endCalendar)) {
            Date date = calendar.getTime();
            String formattedMonth = dateFormat.format(date);
            StringBuilder builder = new StringBuilder("mysql -h " + DATASOURCE_LIST.get(i % DATASOURCE_LIST.size()) + " -u shardpmsdb -ppmsdb1234!");
            builder.append(" -e \"create database if not exists pmds_" + formattedMonth + "\"");
            calendar.add(Calendar.MONTH, 1);
            System.out.println(builder.toString());
            datasourceBuilder.append(DATASOURCE_TEMPLATE
                    .replace("${DATE}", formattedMonth)
                    .replace("${IP}", DATASOURCE_LIST.get(i % DATASOURCE_LIST.size()))).append("\n");
            i++;
        }
        System.out.println("\n-------------------------------------------------------------\n");
        System.out.println(datasourceBuilder.toString());
    }
}
