/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.taojintianxia.springboot.dubbo.protobuf.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.demo.DemoServiceDubbo;
import org.apache.dubbo.demo.HelloReply;
import org.apache.dubbo.demo.HelloRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
@DubboService(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoServiceDubbo.IDemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public HelloReply sayHello(HelloRequest request) {
//        logger.info("Hello " + request.getName() + ", request from consumer: " + RpcContext.getContext()
//                .getRemoteAddress());
        return HelloReply.newBuilder().setMessage("")
                .build();
    }

    @Override
    public CompletableFuture<HelloReply> sayHelloAsync(HelloRequest request) {
        return CompletableFuture.completedFuture(sayHello(request));
    }
}
