package com.zetaframework.system.common.config

import com.zetaframework.websocket.enums.WsUserTypeEnum
import com.zetaframework.websocket.event.WsUserEventListener
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * websocket事件配置
 * @author gcc
 */
@Configuration
class WebsocketEventConfiguration {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    /**
     * 配置WebSocket用户上下线事件监听
     */
    @Bean
    fun wsUserEventListener(): WsUserEventListener =
        WsUserEventListener { user, userType ->
            when (userType) {
                WsUserTypeEnum.ONLINE -> logger.info("websocket用户上线：${user?.userId}")
                WsUserTypeEnum.OFFLINE -> logger.info("websocket用户离线：${user?.userId}")
            }
        }
}
