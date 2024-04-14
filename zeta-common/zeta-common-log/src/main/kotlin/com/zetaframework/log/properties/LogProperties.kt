package com.zetaframework.log.properties

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * 系统日志配置参数
 *
 * @author gcc
 */
@ConfigurationProperties(prefix = LogProperties.PREFIX)
class LogProperties {
    companion object {
        const val PREFIX = "zeta.log"
    }

    /** 日志开关 默认为：false 不记录用户的操作日志、异常日志 */
    var enabled: Boolean = false

    /** 操作日志是否入库, 默认为false 只打印操作日志，不保留到数据库中 */
    var save: Boolean = false
}
