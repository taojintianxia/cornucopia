package com.github.taojintianxia.cornucopia.springcloud.alibaba.consumer.controller;

import com.github.taojintianxia.cornucopia.springcloud.alibaba.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nianjun Sun
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @DubboReference(check = false)
    private UserService userService;

    @GetMapping("/getUser")
    public Object dubbo() {
        return userService.getUserById(1);
    }
}
