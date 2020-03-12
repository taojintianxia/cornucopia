package com.github.taojintianxia.cornucopia.database.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Nianjun Sun
 * @date 2020/3/12 12:52
 */
@SpringBootApplication
@MapperScan("com.github.taojintianxia.cornucopia.database.mybatis.mapper")
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
