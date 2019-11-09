## 创建依赖环境

~~将 apollo 项目下载到本地，进入目录 /scripts/docker-quick-start/ ，执行 docker-compose up 命令即可  
docker quick start : https://github.com/ctripcorp/apollo/tree/master/scripts/docker-quick-start~~

docker quick start 的方式不靠谱，还是用 all in one 的方式 quick start 吧

参照如下文章搭建 apollo-all-in-one : https://github.com/nobodyiam/apollo-build-scripts

docker 的方式，客户端会默认根据 eureka 中记录的 docker 容器的 ip 地址去访问。
但是localhost 是没法访问 docker 虚拟的 ip 的。  
尝试了官方的一些解决办法，但是暂时没有效果

## spring boot

创建依赖环境后，创建项目hello-world。

1. 在默认的 application 中添加键值对如下：

```properties
test.key=TEST_KEY
test.value=TEST_VALUE
```
通过 `ApolloSpringBootApplication` 启动 APP，然后访问 `http://localhost:8080/getConfig` 即可看到上面的键值对

2. 

