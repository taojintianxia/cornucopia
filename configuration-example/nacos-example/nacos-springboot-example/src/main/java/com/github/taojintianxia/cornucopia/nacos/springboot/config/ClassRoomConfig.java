package com.github.taojintianxia.cornucopia.nacos.springboot.config;

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
    @Value("${classroom.area:50}")
    private double area;

    /**
     * 座椅数量
     */
    @Value("${classroom.chair-number:10}")
    private int chairNumber;

    /**
     * 是否是老教室
     */
    @Value("${classroom.legacy:false}")
    private boolean legacy;
}
