package com.github.taojintianxia.cornucopia.database.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Nianjun Sun
 * @date 2020/1/7 10:23
 */
@SpringBootApplication
@MapperScan("com.github.taojintianxia.cornucopia.database.mybatisplus.mapper")
public class MybatisPlusApplication {
}
