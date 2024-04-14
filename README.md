![img](https://img.shields.io/badge/Spring%20Boot-3.2-blue.svg)![img](https://img.shields.io/badge/JDK-17-green.svg)![img](https://img.shields.io/badge/JDK-21-green.svg)

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/1783cwf/zeta-kotlin-flex/blob/main/LICENSE)
[![GitHub](https://img.shields.io/github/stars/1783cwf/zeta-kotlin-flex.svg?style=social&label=Stars)](https://github.com/1783cwf/zeta-kotlin-flex.git)
## 简介

zeta-kotlin-flex在[zeta-kotlin](https://gitee.com/xia5800/zeta-kotlin)基础上是使用kotlin语言基于spring boot、mybatis-flex、sa-token等框架开发的项目脚手架。

> 前端项目地址: [plus-ui](https://gitee.com/JavaLionLi/plus-ui)

> 项目文档地址: [zeta-doc](https://plus-doc.dromara.org)

> 接口文档地址: [api-doc](https://zeta-kotlin-flex.apifox.cn/)

## 项目结构

```plain
.
├── Dockerfile
├── README.md
├── build.gradle.kts
├── gradle
│ └── wrapper
├── gradle.properties
├── gradlew
├── gradlew.bat
├── mybatis-flex.config
├── qodana.yaml
├── settings.gradle.kts
├── zeta-admin
├── zeta-common
│ ├── zeta-common-base
│ ├── zeta-common-core
│ ├── zeta-common-crypto
│ ├── zeta-common-desensitization
│ ├── zeta-common-file
│ ├── zeta-common-json
│ ├── zeta-common-log
│ ├── zeta-common-mybatisflex
│ ├── zeta-common-redis
│ ├── zeta-common-satoken
│ ├── zeta-common-websocket
│ └── zeta-common-xss
└── zeta-module
    ├── zeta-module-monitor
    ├── zeta-module-msg
    └── zeta-module-system
```



## 后端

账号：zetaAdmin

密码：admin

## 功能

| **功能**                | **进度** |
| ----------------------- | -------- |
| 权限认证(sa-token)      | 已完成   |
| ORM框架(mybatis-flex)   | 已完成   |
| 文件管理                | 已完成   |
| websocket               | 已完成   |
| XSS防护                 | 已完成   |
| Ip2region离线IP地址查询 | 已完成   |
| 序列化(Jackson)         | 已完成   |
| 数据加解密              | 进行中   |
| 数据脱敏                | 进行中   |
| 定时任务                | 待开始   |
| 数据权限                | 待开始   |
| API报文加解密           | 待开始   |
| 代码生成器              | 待开始   |
| 数据翻译                | 待开始   |
| 监控框架                | 待开始   |
| 链路追踪                | 待开始   |

## 业务

| **功能** | **描述** | **进度** |
| -------- | -------- | -------- |
| 用户管理 |          | 已完成   |
| 角色管理 |          | 已完成   |
| 操作日志 |          | 已完成   |
| 登录日志 |          | 已完成   |
| 数据字典 |          | 已完成   |
| 岗位     |          | 待开始   |
| 行政区划 |          | 待开始   |

## 友情链接 & 特别鸣谢

- zeta-kotlin：https://gitee.com/xia5800/zeta-kotlin
- lamp-boot：https://github.com/zuihou/lamp-boot
- RuoYi-Vue-Plus: https://github.com/dromara/RuoYi-Vue-Plus
- sa-token https://sa-token.dev33.cn/
- mybatis-flex：[https://mybatis-flex.com](https://mybatis-flex.com/)
- Hutool：https://hutool.cn/