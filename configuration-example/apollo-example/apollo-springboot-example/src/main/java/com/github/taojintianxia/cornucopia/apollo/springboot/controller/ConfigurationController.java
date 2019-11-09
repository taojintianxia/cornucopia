package com.github.taojintianxia.cornucopia.apollo.springboot.controller;

import com.github.taojintianxia.cornucopia.apollo.springboot.entity.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nianjun Sun
 * @date 2019/9/5 13:12
 */
@RestController
public class ConfigurationController {

    @Autowired
    private TestConfig testConfig;

    @GetMapping("getConfig")
    public String getConfig() {
        return "key is " + testConfig.getTestKey() + ", value is : " + testConfig.getTestValue();
    }
}
