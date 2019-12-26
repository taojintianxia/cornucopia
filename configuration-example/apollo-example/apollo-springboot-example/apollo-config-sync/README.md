## 通过 Apollo 同步配置

Apollo 基础功能的样例，将 Apollo 中的数据同步并注入到本地 @Value 注释的配置中。

### 准备数据
1.在 Apollo 上新建一个项目 `hello-world`, AppId 设置为 `hello-world`，应用名随意

2.添加一些测试用键值对，如果批量添加，可以点击 `文本` 进行批量添加，数据如下：

```
docker.host = localhost:2375
docker.repository.host = hub.docker.com
docker.certPath = /user/kane/.docker
git.repository = localhost:8080/github/
```
3.点击发布，将配置发布出去。

4.启动 `ConfigSyncApplication` ，并在浏览器中访问如下链接，验证数据是否为空：

```
http://localhost:8080/config_sync/getGitConfig
http://localhost:8080/config_sync/getDockerConfig
```
