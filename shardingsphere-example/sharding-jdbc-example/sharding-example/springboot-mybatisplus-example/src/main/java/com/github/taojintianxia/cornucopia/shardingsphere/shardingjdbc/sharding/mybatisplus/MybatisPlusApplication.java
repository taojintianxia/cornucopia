package com.github.taojintianxia.cornucopia.shardingsphere.shardingjdbc.sharding.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Nianjun Sun
 * @date 2020/1/7 10:20
 */

@ComponentScan("com.github.taojintianxia.cornucopia.shardingsphere.shardingjdbc.sharding.mybatisplus")
@MapperScan(basePackages = "com.github.taojintianxia.cornucopia.shardingsphere.shardingjdbc.sharding.mybatisplus.repository")
@SpringBootApplication()
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }
}
