package com.zetaframework.websocket.model

import com.zetaframework.websocket.interceptor.WsUserInterceptor
import java.security.Principal

/**
 * Websocket用户信息
 *
 * 说明：主要用于[WsUserInterceptor]
 * @author gcc
 */
class WsUser : Principal {
    var userId: String? = null

    override fun getName(): String? {
        return this.userId
    }

    override fun toString(): String {
        return "WsUser(userId=$userId)"
    }
}
