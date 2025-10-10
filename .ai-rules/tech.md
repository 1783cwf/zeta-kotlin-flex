# Zeta Kotlin Flex - Technical Stack

## 核心技术栈

### 基础框架
- **JDK**: Java 21 (LTS)
- **Language**: Kotlin 2.1.20
- **Framework**: Spring Boot 3.5.0
- **Build Tool**: Gradle 8.x (Kotlin DSL)
- **Server**: Undertow (替代 Tomcat)

### 数据访问层
- **ORM**: MyBatis-Flex 1.10.9
- **Connection Pool**: HikariCP 5.1.0
- **Database**: MySQL 8.0+
- **Migration**: Flyway (可选)

### 缓存层
- **Redis Client**: Lettuce
- **Spring Cache**: Spring Data Redis
- **Cache Manager**: RedisCacheManager

### 认证授权
- **Authentication**: Sa-Token 1.43.0
- **JWT**: Sa-Token-JWT
- **Permission**: Sa-Token 权限注解

### 工具库
- **Utilities**: Hutool 5.8.38
- **JSON**: Jackson 2.17
- **Validation**: Spring Validation
- **Logging**: SLF4J + Log4j2

### 安全相关
- **XSS Protection**: 自定义 XSS 过滤器
- **Encryption**: AES、RSA 加密支持
- **Desensitization**: 数据脱敏注解

### 文件存储
- **Local Storage**: 本地文件存储
- **Aliyun OSS**: 阿里云对象存储
- **MinIO**: 开源对象存储

### 通信协议
- **WebSocket**: Spring WebSocket
- **RESTful**: Spring Web MVC
- **HTTP Client**: OkHttp (可选)

## 依赖管理

### 版本目录 (gradle/libs.versions.toml)

```toml
[versions]
# Core
kotlin = "2.1.20"
spring-boot = "3.5.0"
# ... 其他版本
```

### 核心依赖组

#### 1. Spring Boot 相关
```kotlin
implementation(libs.spring.boot.starter.web)
implementation(libs.spring.boot.starter.aop)
implementation(libs.spring.boot.starter.validation)
implementation(libs.spring.boot.starter.cache)
implementation(libs.spring.boot.starter.data.redis)
implementation(libs.spring.boot.starter.websocket)
implementation(libs.spring.boot.starter.actuator)
```

#### 2. Kotlin 相关
```kotlin
implementation(libs.kotlin.reflect)
implementation(libs.kotlinx.coroutines.core)
implementation(libs.kotlinx.coroutines.reactor)
implementation(libs.jackson.module.kotlin)
```

#### 3. 数据库相关
```kotlin
implementation(libs.mybatisflex.spring.boot.starter)
implementation(libs.mysql.connector.java)
implementation(libs.hikaricp)
```

#### 4. 认证授权
```kotlin
implementation(libs.sa.token.core)
implementation(libs.sa.token.jwt)
implementation(libs.sa.token.redis)
```

#### 5. 工具库
```kotlin
implementation(libs.hutool.all)
implementation(libs.commons.lang3)
implementation(libs.commons.io)
implementation(libs.commons.codec)
```

## 模块依赖关系

```
zeta-admin (主模块)
├── zeta-common-* (所有公共模块)
└── zeta-module-* (业务模块)
```

### 依赖规则
1. **zeta-admin** 依赖所有其他模块
2. **zeta-module** 模块可以依赖 **zeta-common** 模块
3. **zeta-common** 模块之间不能循环依赖
4. **zeta-module** 模块之间不能直接依赖（通过 common 模块通信）

## 配置规范

### 1. 应用配置 (application.yml)
```yaml
spring:
  profiles:
    active: dev
  application:
    name: zeta-admin

# 数据库配置
zeta:
  datasource:
    type: mysql
    host: localhost
    port: 3306
    database: zeta
    username: root
    password: root

# Redis 配置
  redis:
    host: localhost
    port: 6379
    database: 0
    password:
```

### 2. 日志配置 (log4j2.xml)
- 使用异步日志
- 区分环境输出
- 支持日志文件滚动
- JSON 格式支持

### 3. 代码规范
- **Kotlin 编码规范**: 遵循官方 Kotlin 编码规范
- **命名规范**: 驼峰命名，类名首字母大写
- **注解使用**: 合理使用 Spring 和自定义注解
- **异常处理**: 统一异常处理机制

## 开发工具配置

### 1. IntelliJ IDEA
- 安装 Kotlin 插件
- 配置代码风格
- 启用 Lombok 支持

### 2. Git
- 提交信息规范
- 分支管理策略
- 代码审查流程

### 3. Docker
- Dockerfile 配置
- Docker Compose 开发环境
- 多阶段构建优化

## 性能优化

### 1. JVM 参数
```bash
-XX:+UseZGC
-XX:ZGCAllocationSpikeTolerance=5
-Xms4g
-Xmx4g
```

### 2. 数据库优化
- 连接池配置
- 索引优化建议
- SQL 审查规则

### 3. 缓存策略
- 多级缓存设计
- 缓存更新策略
- 缓存穿透防护

## 监控与运维

### 1. 健康检查
- Spring Boot Actuator
- 自定义健康指标
- 数据库连接检查

### 2. 日志监控
- 结构化日志
- 日志收集方案
- 错误告警机制

### 3. 性能监控
- Micrometer 指标
- JVM 监控
- 业务指标监控

## 安全最佳实践

### 1. 认证安全
- 密码加密存储
- JWT 令牌管理
- 会话超时控制

### 2. 数据安全
- SQL 注入防护
- XSS 攻击防护
- CSRF 防护

### 3. 接口安全
- 接口限流
- 参数校验
- 敏感数据脱敏

## 测试策略

### 1. 单元测试
- JUnit 5
- Mockito
- Kotlin Test

### 2. 集成测试
- Spring Boot Test
- Testcontainers
- 测试数据管理

### 3. 性能测试
- JMeter
- Gatling
- 压力测试方案