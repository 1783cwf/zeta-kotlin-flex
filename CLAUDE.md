# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 项目概述

zeta-kotlin-flex是基于Kotlin语言开发的Spring Boot项目脚手架，使用MyBatis-Flex作为ORM框架，Sa-Token作为权限认证框架。

- **前端项目**: [zeta-kotlin-vben](https://github.com/1783cwf/zeta-kotlin-vben)
- **项目文档**: [zeta-doc](https://www.yuque.com/weifeng97/zv86gq)
- **接口文档**: [api-doc](https://zeta-kotlin-flex.apifox.cn/)
- **默认账号**: zetaAdmin / admin

## 技术栈

- **语言**: Kotlin 2.2.20 + JDK 21
- **框架**: Spring Boot 3.5.8
- **ORM**: MyBatis-Flex 1.11.4
- **权限**: Sa-Token 1.44.0
- **数据库**: PostgreSQL (也支持MySQL)
- **缓存**: Redis
- **构建工具**: Gradle 8.x
- **日志**: Log4j2

## 常用命令

### 构建和运行

```bash
# 编译项目
./gradlew build

# 跳过测试编译
./gradlew build -x test

# 运行应用（开发环境）
./gradlew :zeta-admin:bootRun

# 清理构建产物
./gradlew clean

# 代码格式化检查
./gradlew ktlintCheck

# 自动格式化代码
./gradlew ktlintFormat

# 生成jar包
./gradlew :zeta-admin:bootJar
```

### Docker相关

```bash
# 构建Docker镜像
./gradlew :zeta-admin:buildDockerImage

# 推送Docker镜像
./gradlew :zeta-admin:pushDockerImage
```

### 测试

```bash
# 运行所有测试
./gradlew test

# 运行特定模块测试
./gradlew :zeta-module:zeta-module-system:test

# 运行单个测试类
./gradlew test --tests "com.zetaframework.system.SomeTest"
```

## 项目架构

### 模块结构

项目采用多模块架构，分为三大部分：

1. **zeta-admin**: 主应用模块
   - 包含启动类 `ZetaKotlinFlexApplication`
   - 聚合所有业务模块和公共模块
   - 配置文件位于 `src/main/resources/`

2. **zeta-common**: 公共模块集合
   - `zeta-common-core`: 核心工具类、常量、枚举
   - `zeta-common-base`: 基础实体、DTO、VO定义
   - `zeta-common-mybatisflex`: MyBatis-Flex配置和扩展
   - `zeta-common-satoken`: Sa-Token权限认证配置
   - `zeta-common-redis`: Redis配置和工具
   - `zeta-common-log`: 操作日志记录
   - `zeta-common-json`: Jackson序列化配置
   - `zeta-common-file`: 文件存储（本地/阿里云OSS/Minio）
   - `zeta-common-crypto`: 数据加解密
   - `zeta-common-desensitization`: 数据脱敏
   - `zeta-common-xss`: XSS防护
   - `zeta-common-websocket`: WebSocket支持
   - `zeta-common-dependencies`: 依赖版本管理

3. **zeta-module**: 业务模块集合
   - `zeta-module-system`: 系统管理（用户、角色、菜单、字典等）
   - `zeta-module-msg`: 消息模块（WebSocket）
   - `zeta-module-monitor`: 系统监控
   - `zeta-module-ai`: AI相关功能

### 关键设计模式

- **分层架构**: Controller -> Service -> Mapper (DAO)
- **实体映射**: 使用MapStruct Plus进行DTO/Entity转换
- **自动建表**: 使用Auto-Table在启动时自动创建/更新表结构
- **逻辑删除**: 默认启用，通过`deleted`字段标记
- **数据审计**: 支持创建时间、更新时间、创建人、更新人自动填充
- **操作日志**: 通过注解`@SysLog`记录用户操作

## 配置说明

### 环境配置

项目支持多环境配置，通过`spring.profiles.active`切换：
- `application-dev.yml`: 开发环境
- `application-test.yml`: 测试环境
- `application-prod.yml`: 生产环境

### 数据库配置

当前默认使用PostgreSQL，如需切换到MySQL：
1. 修改`zeta-admin/build.gradle.kts`中的数据库驱动依赖
2. 修改`application.yml`中的`driver-class-name`
3. 调整实体类中的`@AutoColumns`注解以适配不同数据库

### 关键配置项

- `zeta.mybatis-flex.audit-enable`: 是否开启数据审计
- `zeta.mybatis-flex.logic-delete`: 是否启用逻辑删除
- `zeta.token.type`: Token类型（DEFAULT/SIMPLE/MIXIN/STATELESS）
- `zeta.file.storageType`: 文件存储策略（LOCAL/ALI_OSS/MINIO）
- `zeta.xss.enabled`: 是否开启XSS防护
- `auto-table.enable`: 是否开启自动建表

## 开发注意事项

### Kotlin特性

- 项目使用Kotlin 2.2，充分利用Kotlin特性（数据类、扩展函数、协程等）
- 编译器参数包含`-Xjsr305=strict`和`-Xjvm-default=all-compatibility`
- 使用kapt进行注解处理（MyBatis-Flex、MapStruct Plus）

### MyBatis-Flex

- Mapper接口继承`BaseMapper<T>`获得基础CRUD能力
- 使用Kotlin扩展函数简化查询构建
- XML Mapper文件位于`src/main/resources/mapper/`
- 实体类使用`@Table`注解映射表名

### Sa-Token权限

- 使用`StpUtil.login(userId)`进行登录
- 使用`@SaCheckPermission`注解进行权限校验
- 使用`@SaCheckRole`注解进行角色校验
- Token配置支持多种模式，默认使用SIMPLE模式

### 依赖管理

- 版本号统一在`gradle/libs.versions.toml`中管理
- 子模块通过`dependencyManagement`引入BOM
- 避免在子模块中硬编码版本号

### 代码规范

- 遵循Kotlin官方编码规范
- 使用ktlint进行代码格式化
- 提交前运行`./gradlew ktlintFormat`格式化代码
- 所有公共API必须有KDoc注释

### 日志配置

- 项目排除了Spring Boot默认的Logback
- 使用Log4j2作为日志框架
- 配置文件：`zeta-admin/src/main/resources/log4j2-spring.xml`
- 日志文件输出到`./log`目录

### 虚拟线程

- 项目启用了Java 21的虚拟线程特性（`spring.threads.virtual.enabled=true`）
- 提升并发处理能力，特别是I/O密集型操作

## 常见任务

### 添加新的业务模块

1. 在`zeta-module`下创建新模块目录
2. 创建`build.gradle.kts`并添加依赖
3. 在`settings.gradle.kts`中include新模块
4. 在`zeta-admin/build.gradle.kts`中添加模块依赖

### 添加新的实体类

1. 在对应模块的`entity`包下创建实体类
2. 使用`@Table`注解指定表名
3. 使用`@AutoColumns`注解进行多数据库适配
4. 继承`SuperEntity`获得审计字段（创建时间、更新时间等）

### 添加新的API接口

1. 在Controller中添加方法，使用`@SysLog`记录操作日志
2. 使用`@SaCheckPermission`进行权限控制
3. 返回值统一使用`ApiResult<T>`包装
4. 参数校验使用JSR-303注解

### 文件存储切换

修改`zeta.file.storageType`配置项：
- `LOCAL`: 本地存储，需配置`zeta.file.local.*`
- `ALI_OSS`: 阿里云OSS，需配置`zeta.file.ali.*`
- `MINIO`: Minio对象存储，需配置`zeta.file.minio.*`
