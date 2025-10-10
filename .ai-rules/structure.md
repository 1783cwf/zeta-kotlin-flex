# Zeta Kotlin Flex - Project Structure

## 项目整体结构

```
zeta-kotlin-flex/
├── .ai-rules/                    # AI 辅助开发规则
│   ├── product.md               # 产品愿景和定位
│   ├── tech.md                  # 技术栈和依赖
│   └── structure.md             # 项目结构和规范
├── .github/                     # GitHub 相关配置
│   └── workflows/              # CI/CD 工作流
├── docker/                      # Docker 相关文件
│   ├── Dockerfile              # Docker 镜像构建
│   └── docker-compose.yml      # Docker Compose 配置
├── zeta-admin/                  # 主应用模块
│   └── src/main/
│       ├── kotlin/
│       │   └── com/zetaframework/
│       │       ├── ZetaApplication.kt  # 应用启动类
│       │       └── config/             # 应用配置
│       └── resources/
│           ├── application.yml       # 应用配置
│           ├── application-dev.yml   # 开发环境配置
│           ├── application-prod.yml  # 生产环境配置
│           ├── log4j2.xml            # 日志配置
│           └── banner.txt            # 启动 Banner
├── zeta-common/                 # 公共模块
│   ├── zeta-common-base/         # 基础模块
│   │   └── src/main/kotlin/com/zetaframework/base/
│   │       ├── controller/        # 基础控制器
│   │       ├── exception/         # 异常处理
│   │       ├── model/            # 基础模型
│   │       └── result/           # 统一返回
│   ├── zeta-common-core/         # 核心模块
│   │   └── src/main/kotlin/com/zetaframework/core/
│   │       ├── enums/           # 枚举定义
│   │       ├── model/           # 核心模型
│   │       └── util/            # 核心工具类
│   ├── zeta-common-json/         # JSON 处理
│   │   └── src/main/kotlin/com/zetaframework/jackson/
│   │       └── util/            # Jackson 工具类
│   ├── zeta-common-mybatisflex/  # MyBatis-Flex 配置
│   │   └── src/main/kotlin/com/zetaframework/mybatisflex/
│   │       ├── config/          # 配置类
│   │       └── handler/         # 处理器
│   ├── zeta-common-redis/        # Redis 配置
│   │   └── src/main/kotlin/com/zetaframework/redis/
│   │       ├── config/          # 配置类
│   │       └── util/            # Redis 工具
│   ├── zeta-common-satoken/      # Sa-Token 配置
│   │   └── src/main/kotlin/com/zetaframework/satoken/
│   │       ├── config/          # 配置类
│   │       ├── listener/        # 监听器
│   │       └── util/            # 认证工具
│   ├── zeta-common-xss/          # XSS 防护
│   │   └── src/main/kotlin/com/zetaframework/xss/
│   │       ├── filter/          # 过滤器
│   │       └── util/            # XSS 工具
│   ├── zeta-common-crypto/       # 加密解密
│   │   └── src/main/kotlin/com/zetaframework/crypto/
│   │       ├── config/          # 配置类
│   │       └── util/            # 加密工具
│   ├── zeta-common-desensitization/  # 数据脱敏
│   │   └── src/main/kotlin/com/zetaframework/desensitization/
│   │       ├── annotation/      # 注解
│   │       └── serializer/      # 序列化器
│   ├── zeta-common-file/         # 文件管理
│   │   └── src/main/kotlin/com/zetaframework/file/
│   │       ├── config/          # 配置类
│   │       ├── enums/           # 枚举
│   │       ├── properties/      # 配置属性
│   │       └── strategy/        # 存储策略
│   ├── zeta-common-log/          # 日志模块
│   │   └── src/main/kotlin/com/zetaframework/log/
│   │       ├── annotation/      # 注解
│   │       ├── enums/           # 枚举
│   │       ├── event/           # 事件
│   │       ├── listener/        # 监听器
│   │       └── model/           # 模型
│   └── zeta-common-websocket/    # WebSocket
│       └── src/main/kotlin/com/zetaframework/websocket/
│           ├── config/          # 配置类
│           ├── handler/         # 处理器
│           └── model/           # 模型
├── zeta-module/                 # 业务模块
│   ├── zeta-module-system/       # 系统管理
│   │   └── src/main/
│   │       ├── kotlin/
│   │       │   └── com/zetaframework/system/
│   │       │       ├── controller/    # 控制器
│   │       │       ├── model/         # 模型
│   │       │       ├── service/       # 服务
│   │       │       └── serviceImpl/   # 服务实现
│   │       └── resources/
│   │           └── mapper/        # MyBatis Mapper
│   ├── zeta-module-msg/         # 消息模块
│   └── zeta-module-monitor/     # 监控模块
├── docs/                        # 文档目录
├── gradle/                      # Gradle 配置
│   ├── libs.versions.toml       # 版本目录
│   └── wrapper/                 # Gradle Wrapper
├── build.gradle.kts            # 根构建文件
├── gradle.properties           # Gradle 属性
├── gradlew                     # Gradle Wrapper 脚本
├── gradlew.bat                 # Windows 脚本
├── settings.gradle.kts         # 项目设置
└── README.md                   # 项目说明
```

## 模块职责说明

### 1. zeta-admin (主模块)
- **职责**: 应用启动入口，整合所有模块
- **特点**: 
  - 包含主启动类 `ZetaApplication`
  - 应用级配置
  - 资源文件（配置文件、日志配置等）

### 2. zeta-common (公共模块)

#### zeta-common-base
- **职责**: 提供基础功能
- **包含**:
  - 基础控制器 `BaseController`
  - 统一异常处理
  - 统一返回格式 `Result`
  - 分页查询支持

#### zeta-common-core
- **职责**: 核心工具和模型
- **包含**:
  - 通用枚举（状态、类型等）
  - 基础模型类
  - 核心工具类

#### zeta-common-json
- **职责**: JSON 序列化配置
- **包含**:
  - Jackson 配置
  - 日期格式化
  - Long 类型转 String 避免精度丢失

#### zeta-common-mybatisflex
- **职责**: MyBatis-Flex ORM 配置
- **包含**:
  - 数据源配置
  - 分页插件配置
  - 通用处理器

#### zeta-common-redis
- **职责**: Redis 缓存配置
- **包含**:
  - Redis 连接配置
  - 缓存管理器配置
  - Redis 工具类

#### zeta-common-satoken
- **职责**: 认证授权配置
- **包含**:
  - Sa-Token 配置
  - JWT 配置
  - 权限注解支持

#### zeta-common-xss
- **职责**: XSS 防护
- **包含**:
  - XSS 过滤器
  - 清理工具类

#### zeta-common-crypto
- **职责**: 加密解密
- **包含**:
  - AES/RSA 加密
  - 密码工具类

#### zeta-common-desensitization
- **职责**: 数据脱敏
- **包含**:
  - 脱敏注解
  - 序列化器

#### zeta-common-file
- **职责**: 文件管理
- **包含**:
  - 文件上传下载
  - 多种存储策略
  - 文件类型限制

#### zeta-common-log
- **职责**: 日志管理
- **包含**:
  - 操作日志注解
  - 登录日志
  - 异步日志记录

#### zeta-common-websocket
- **职责**: WebSocket 支持
- **包含**:
  - WebSocket 配置
  - 消息处理器
  - 会话管理

### 3. zeta-module (业务模块)

#### zeta-module-system
- **职责**: 系统管理功能
- **包含**:
  - 用户管理
  - 角色管理
  - 菜单管理
  - 字典管理
  - 操作日志
  - 登录日志

#### zeta-module-msg
- **职责**: 消息管理
- **包含**:
  - 消息模板
  - 消息发送
  - 消息记录

#### zeta-module-monitor
- **职责**: 系统监控
- **包含**:
  - 服务监控
  - 性能监控
  - 告警管理

## 包命名规范

### 基础包名
```
com.zetaframework.*
```

### 模块包名
- **公共模块**: `com.zetaframework.{module-name}`
- **业务模块**: `com.zetaframework.{module-name}`

### 功能包名
```
controller/     # 控制器层
service/        # 服务接口层
serviceImpl/    # 服务实现层
model/          # 数据模型
dao/           # 数据访问层
mapper/        # MyBatis Mapper
config/        # 配置类
listener/      # 监听器
event/         # 事件
enums/         # 枚举
annotation/    # 注解
util/          # 工具类
dto/           # 数据传输对象
vo/            # 视图对象
```

## 代码规范

### 1. Kotlin 编码规范
- 使用驼峰命名法
- 类名首字母大写
- 方法名和属性名首字母小写
- 常量使用大写字母和下划线
- 优先使用 `val` 而不是 `var`
- 空安全设计，合理使用 `?` 和 `!!`

### 2. 控制器规范
- 继承 `BaseController`
- 使用 `@RestController`
- 统一返回 `Result<T>`
- 接口文档注解 `@Tag`、`@Operation`

### 3. 服务层规范
- 接口和实现分离
- 事务注解 `@Transactional`
- 业务逻辑封装在服务层

### 4. 数据模型规范
- 实体类使用 `@Table` 注解
- 使用 `@Id` 标识主键
- 日期类型使用 `LocalDateTime`
- 使用数据类 `data class`

### 5. Mapper 规范
- 继承 `BaseMapper<T>`
- XML 文件放在 `resources/mapper` 目录
- 使用动态 SQL

## 配置文件规范

### 1. 应用配置
- 主配置文件：`application.yml`
- 环境配置：`application-{profile}.yml`
- 敏感配置使用环境变量

### 2. 日志配置
- 使用 Log4j2
- 区分环境输出
- 支持日志文件滚动

### 3. 数据库配置
- 使用 MyBatis-Flex
- 配置连接池
- 开启 SQL 日志

## Git 工作流

### 1. 分支策略
- `main`: 主分支，生产环境
- `dev`: 开发分支，开发环境
- `feature/*`: 功能分支
- `hotfix/*`: 修复分支

### 2. 提交规范
```
<type>(<scope>): <description>

# 示例
feat(system): 添加用户管理功能
fix(auth): 修复登录验证问题
docs: 更新 README 文档
```

### 3. 代码审查
- 所有提交需要 PR
- 至少一人审查通过
- 通过自动化测试

## 开发流程

### 1. 新功能开发
1. 从 `dev` 创建功能分支
2. 开发并提交代码
3. 创建 PR 到 `dev`
4. 代码审查和测试
5. 合并到 `dev`

### 2. Bug 修复
1. 从 `main` 创建修复分支
2. 修复问题并测试
3. 创建 PR 到 `main` 和 `dev`
4. 紧急发布后合并到 `dev`

### 3. 版本发布
1. 从 `dev` 创建发布分支
2. 版本测试和修复
3. 合并到 `main`
4. 打标签发布

## 测试规范

### 1. 单元测试
- 使用 JUnit 5
- 测试类命名：`{ClassName}Test`
- 测试方法命名：`{methodName}_{scenario}_{expectedResult}`

### 2. 集成测试
- 使用 Spring Boot Test
- 测试真实数据库
- 测试类命名：`{ClassName}IT`

### 3. 测试覆盖率
- 目标覆盖率：80%
- 核心业务逻辑：90%
- 工具类：70%

## 文档规范

### 1. 代码注释
- 所有公共 API 必须有 KDoc
- 复杂逻辑添加行内注释
- 使用中文注释

### 2. API 文档
- 使用 SpringDoc OpenAPI
- 接口文档实时更新
- 提供在线测试

### 3. 更新日志
- 使用 CHANGELOG.md
- 按版本记录变更
- 包含新增、修改、删除