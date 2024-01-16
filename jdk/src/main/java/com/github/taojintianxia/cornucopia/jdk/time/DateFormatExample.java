package com.github.taojintianxia.cornucopia.jdk.time;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatExample {
    
    public static void main(String... args) {
        // 原始的方式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("original format : " + simpleDateFormat.format(System.currentTimeMillis()));
        
        // Java 8 的方式
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("new format : " + pattern.format(localDateTime));
    }
}
