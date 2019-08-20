package com.github.taojintianxia.nacos.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nianjun Sun
 * @date 2019-08-20 18:46
 */
@Data
@Configuration
public class ClassRoomConfig {

    /**
     * 教室面积
     */
    @Value("${classroom.area:}")
    private double area;

    /**
     * 座椅数量
     */
    @Value("${classroom.chair-number:}")
    private int chairNumber;

    /**
     * 是否是老教室
     */
    @Value("${classroom.legacy:}")
    private boolean legacy;
}
