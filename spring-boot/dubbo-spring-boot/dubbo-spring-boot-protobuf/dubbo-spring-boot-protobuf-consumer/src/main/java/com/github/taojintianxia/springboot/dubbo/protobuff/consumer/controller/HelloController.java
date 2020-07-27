package com.github.taojintianxia.springboot.dubbo.protobuff.consumer.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.demo.DemoServiceDubbo;
import org.apache.dubbo.demo.HelloReply;
import org.apache.dubbo.demo.HelloRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nianjun Sun
 */
@RestController
public class HelloController {

    @DubboReference(version = "${demo.service.version}", url = "${demo.service.url}")
    private DemoServiceDubbo.IDemoService demoService;

    @GetMapping("consumer/sayHello")
    public String sayHello(@RequestParam String name){
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply reply = demoService.sayHello(request);
        return reply.getMessage();
    }
}
