package com.github.taojintianxia.springboot.dubbo.protobuf.provider.controller;

import org.apache.dubbo.demo.DemoServiceDubbo;
import org.apache.dubbo.demo.HelloReply;
import org.apache.dubbo.demo.HelloRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nianjun Sun
 */
@RestController
public class DemoController {

    @Autowired
    private DemoServiceDubbo.IDemoService demoService;

    @GetMapping("/provider/demoService")
    public String sayHello (){
        HelloRequest request = HelloRequest.newBuilder().setName("Hello").build();
        HelloReply helloReply = demoService.sayHello(request);
        return helloReply.getMessage();
    }


}
