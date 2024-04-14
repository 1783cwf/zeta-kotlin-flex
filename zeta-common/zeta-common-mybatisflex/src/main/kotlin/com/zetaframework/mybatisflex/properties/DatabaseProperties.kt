package com.zetaframework.mybatisflex.properties

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * 数据源配置参数
 * @author gcc
 */
@ConfigurationProperties(prefix = "zeta.mybatis-flex")
class DatabaseProperties(
    /** 是否打印SQL */
    var isPrintSql: Boolean = false,
    /** 是否开启审计 */
    var auditEnable: Boolean = false,
    /** 是否启用 乐观锁插件 */
    var optimisticLock: Boolean = false,
)
