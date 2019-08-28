# Tamboot Admin
Tamboot Admin是一个基于 [Tamboot](https://github.com/chensheng/tamboot.git)（一个基于[spring boot](https://spring.io/projects/spring-boot)的快速开发框架） 的服务端脚手架项目，实现了企业级应用常见的用户管理、角色管理、权限管理、菜单管理等基本功能，开发者可基于此快速搭建系统。

* [快速上手](#快速上手)
* [详细教程](https://github.com/chensheng/tamboot/wiki)
* [Demo演示](http://www.tamboot.com)
* [前端项目](https://github.com/chensheng/tamboot-admin-frontend)


## 快速上手

* [安装依赖](#安装依赖)
* [下载项目](#下载项目)
* [创建数据库](#创建数据库)
* [最小配置](#最小配置)
* [运行项目](#运行项目)
* [返回值](#返回值)
* [状态码](#状态码)
* [初始用户](#初始用户)

### 安装依赖
由于[Tamboot](https://github.com/chensheng/tamboot.git)尚未发布到maven仓库，因此运行项目前，需要先在本地编译安装Tamboot依赖。
```bash
$ git clone https://github.com/chensheng/tamboot.git
$ cd tamboot
$ mvn install
```

### 下载项目
```bash
$ git clone https://github.com/chensheng/tamboot-admin-back.git tamboot-admin
```

### 创建数据库
数据库初始化文件在项目的`src/main/sql`目录下。

### 最小配置
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


### 运行项目
执行以下命令后，服务端将启动，可访问 `http://localhost:8080/tamboot-admin` 验证。
```bash
$ cd tamboot-admin
$ mvn spring-boot:run
```

### 返回值
所有接口统一返回json格式数据，返回格式如下：
```json
{
  "code": "1",
  "msg": "success",
  "data": null
}
```

字段|说明
-----|-----
code|状态码。除了使用框架定义的状态码，开发者也可以自定义状态码。具体见下表。
msg|提示信息
data|数据。不同接口返回不同数据。

### 状态码
code|说明
-----|-----
0|失败
1|成功
1001|未登录
1002|无权限
9999|系统异常

### 初始用户
系统初始用户：admin，初始密码：Tamboot@123456

