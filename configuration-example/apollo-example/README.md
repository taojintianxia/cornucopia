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

1. 在默认的 application 中添加键值配置对如下：

```properties
test.key=TEST_KEY
test.value=TEST_VALUE
```
通过 `ApolloSpringBootApplication` 启动 APP，然后访问 `http://localhost:8080/getConfig` 即可看到上面的键值对

2. 创建一个 公用的 namespace，就叫做 `hello-world-common` 好了。
这里有个不太好的体验，就是如果想设置公用 namespace 的文件类型，需要先点 private，然后选了文件类型后在切换回 public 才行
然后我们编辑这个 namespace，添加配置如下：

```yaml
common:
    commonName: hello-world
    commonConfigCenter: Apollo
    
dataSource:
    driverClassName: com.mysql.jdbc.Driver
    jdbcUrl: jdbc:mysql://localhost:13306/demo_ds_master
```

在项目的 application.properties 中新建一行 `apollo.bootstrap.namespaces = application,YOUR_GROUP_NAME.hello-world-common.yaml
这里 YOUR_GROUP_NAME 就是你之前新建的 group 的名称，那个配置可以在系统参数 `organizations` 中修改
这里还需要添加运行时 JVM 的参数，在 idea 中修改 RUN/DEBUG Configurations，添加 jvm 变量 `-Denv=DEV`，当然在 `java -jar` 执行时添加也可以




