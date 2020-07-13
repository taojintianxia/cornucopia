# 前言

在某些场景下，我们部署多个应用，但是多个应用除了某项配置（例如 datasource.url）不同外，其他的都相同。
可以通过配置的继承来精简配置，也让通用配置的更新变得更加简单。

## 准备

如果你已经运行了之前的那个 `apollo-config-sync` 例子，请先删除 `hello-world` 这个 APP。
我们还是新建一个 hello world 项目，AppId 设置为 `hello-world`，项目名随意。

## 配置

1.新建一个 public 的 namespace，名字就叫 `hello-world-common`，填写一些不同服务间的通用配置并发布，例如：

```
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```
2.新建 namespace，并在 `关联公共 Namespace` 的 tag 中选择刚才创建的 `hello-world-common`。
在 `创建Namespace` 的 tag 中创建一个 private 的 namespace，名字叫 `hello-world-service-A`。

3.返回 hello-world 项目，编辑 `hello-world-service-A`，添加一些只有该服务使用的配置，例如：

```
server.port=9990
spring.datasource.url=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=true
```

4.重复 2 跟 3，然后使用另一个 jdbc url 并发布，例如：

```
spring.datasource.username=jarger
server.port=9991
spring.datasource.url=jdbc:mysql://localhost:3307/test?useUnicode=true&characterEncoding=utf-8&useSSL=true
```

5.分别进入 `hello-world-service-A`，`hello-world-service-B` 并启动 ConfigInheritanceApplication

6.分别浏览如下地址来查看相应的配置信息

```
http://localhost:9990/config_inheritance/getServiceConfig
http://localhost:9991/config_inheritance/getServiceConfig
```

## 注意
>这里需要注意的一点是，`apollo.bootstrap.namespaces` 的顺序问题，哪个 namespace 在前面，相同的 key 就会覆盖掉后面的 key 对应的值
