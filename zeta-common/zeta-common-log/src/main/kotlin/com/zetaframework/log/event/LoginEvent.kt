package com.zetaframework.log.event

import com.zetaframework.log.model.LoginLogDTO
import org.springframework.context.ApplicationEvent

/**
 * 登录日志 事件
 *
 * @author gcc
 */
class LoginEvent(source: LoginLogDTO) : ApplicationEvent(source)
