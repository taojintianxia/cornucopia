package com.github.taojintianxia.cornucopia.springboot.customizedstarter.configuration;

/**
 * @author Nianjun Sun
 * @date 2020/3/9 17:58
 */

import com.github.taojintianxia.cornucopia.springboot.customizedstarter.property.HelloProperty;
import com.github.taojintianxia.cornucopia.springboot.customizedstarter.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperty.class)
public class HelloAutoConfiguration {

    @Autowired
    private HelloProperty helloProperty;

    @Bean
    public HelloService helloService() {
        String target = helloProperty.getTarget();
        if (target == null || target.trim() == "") {
            target = HelloProperty.DEFAULT_TARGET;
        }
        HelloService helloService = new HelloService(target);
        return helloService;
    }
}
