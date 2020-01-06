package com.github.taojintianxia.cornucopia.shardingsphere.mybatisexample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.taojintianxia.cornucopia.shardingsphere.mybatisexample")
public class StateApplication {

    public static void main(String[] args) {
        SpringApplication.run(StateApplication.class, args);
    }

}
