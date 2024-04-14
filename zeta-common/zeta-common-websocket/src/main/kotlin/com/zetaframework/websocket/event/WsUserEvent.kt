package com.zetaframework.websocket.event

import com.zetaframework.websocket.enums.WsUserTypeEnum
import com.zetaframework.websocket.model.WsUser
import org.springframework.context.ApplicationEvent

/**
 * Websocket用户 事件
 *
 * 说明：
 * 主要用来发送用户上线、下线事件通知
 * @author gcc
 */
class WsUserEvent(val user: WsUser?, source: WsUserTypeEnum) : ApplicationEvent(source)
