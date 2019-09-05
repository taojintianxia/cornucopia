## 通过 docker 创建依赖环境

---

~~将 apollo 项目下载到本地，进入目录 /scripts/docker-quick-start/ ，执行 docker-compose up 命令即可  
docker quick start : https://github.com/ctripcorp/apollo/tree/master/scripts/docker-quick-start~~

docker quick start 的方式不靠谱，还是用 all in one 的方式吧，虽然麻烦些，但是可以用

参照如下文章搭建 apollo-all-in-one : https://github.com/nobodyiam/apollo-build-scripts

 docker 的方式，客户端会默认根据 eureka 中记录的 docker 容器的 ip 地址去访问。
 但是localhost 是没法访问 docker 虚拟的 ip 的。  
 
 尝试了官方的一些解决办法，但是没有效果

