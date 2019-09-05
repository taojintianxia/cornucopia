#### 运行 SpringCloudConfigApplication 启动 app，端口设置为 12580

---

#### 按照如下规则访问配置文件 ：  
  - /{application}/{profile}[/{label}]

  - /{application}-{profile}.yml

  - /{label}/{application}-{profile}.yml

  - /{application}-{profile}.properties

  - /{label}/{application}-{profile}.properties
  
例如 http://localhost:12580/master/application