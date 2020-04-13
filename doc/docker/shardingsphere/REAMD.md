## ShardingSphere 

ShardingSphere 的 demo 中经常使用多台数据库，这里可以通过 Docker 进行快速的拉起相应环境。

首先需要下载仓库 [dockerfile-repository](https://github.com/taojintianxia/dockerfile-repository.git)

#### Master Slave

master slave 的场景为启动 `一主二从` 3 台MySQL，3 台数据库的端口分别为 `13306`，`13307`，`13308`
用户名密码分别为 root / root

进入 `dockerfile-repository/shardingsphere/master-with-2-slaves/with-sql-script` 下的 `bin` 目录，执行如下命令启动或是关闭相应 docker 环境

```shell script
## 启动 docker 环境
sh startup.sh


## 关闭 docker 环境
sh shutdown.sh
```