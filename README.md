# Tamboot Admin (后端)
Tamboot Admin是一个基于 [Tamboot](https://github.com/chensheng/tamboot.git)（一个基于[spring boot](https://spring.io/projects/spring-boot)的快速开发框架） 的服务端脚手架项目，实现了企业级应用常见的用户管理、角色管理、权限管理、菜单管理等基本功能，开发者可基于此快速搭建系统。

## 快速上手教程

* [安装依赖](#安装依赖)
* [下载项目](#下载项目)
* [最小配置](#最小配置)
* [运行项目](#运行项目)

### 安装依赖 <div id="安装依赖"></div>
由于[Tamboot](https://github.com/chensheng/tamboot.git)尚未发布到maven仓库，因此运行项目前，需要先在本地编译安装Tamboot依赖。
```bash
$ git clone https://github.com/chensheng/tamboot.git
$ cd tamboot
$ mvn install
```

### 下载项目 <div id="下载项目"></div>
```bash
$ git clone https://github.com/chensheng/tamboot-admin-back.git tamboot-admin
```

### 最小配置 <div id="最小配置"></div>
修改配置文件`src/main/resources/application.yml`
```yml
spring:
  transaction:
    rollback-on-commit-failure: true
  security:
    useRedisRepo: true
    loginPath: /login
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/tamboot_admin_db
    username: root
    password: Aa123456
  redis:
    host: 127.0.0.1
    port: 6379
mybatis:
  ignoreInterceptor: false
  throwVersionLockException: true
  snowFlake:
    dataCenterId: 1
  configuration:
    mapUnderscoreToCamelCase: true
server:
  servlet:
    context-path: /tamboot-admin
  port: 8080
```


### 运行项目 <div id="运行项目"></div>
执行以下命令后，服务端将启动，可访问 `http://localhost:8080/tamboot-admin` 验证。
```bash
$ cd tamboot-admin
$ mvn spring-boot:run
```
