package com.zetaframework.websocket.event

import com.zetaframework.websocket.enums.WsUserTypeEnum
import com.zetaframework.websocket.model.WsUser
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async

/**
 * Websocket用户状态 事件监听
 *
 * 说明：
 * 监听用户上线、下线事件
 *
 * 使用说明：
 * 1. 在业务包中，@Bean配置一个WsUserEventListener
 * 2. 用户上线、下线之后要做的事交给具体的业务去实现
 * @author gcc
 */
open class WsUserEventListener(private val consumer: (user: WsUser?, userType: WsUserTypeEnum) -> Unit) {
    /**
     * 处理用户上线、下线事件
     *
     * 说明：
     * 该方法不实现，交给具体业务去实现
     *
     * @param event 用户上下线事件
     */
    @Async
    @EventListener(WsUserEvent::class)
    open fun handler(event: WsUserEvent) {
        val userType = event.source as WsUserTypeEnum
        consumer.invoke(event.user, userType)
    }
}
