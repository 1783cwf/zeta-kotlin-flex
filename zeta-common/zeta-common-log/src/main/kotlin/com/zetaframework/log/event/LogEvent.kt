package com.zetaframework.log.event

import com.zetaframework.log.model.LogDTO
import org.springframework.context.ApplicationEvent

/**
 * 系统日志 事件
 *
 * @author gcc
 */
class LogEvent(source: LogDTO) : ApplicationEvent(source)
