package com.zetaframework.msg.controller

import com.zetaframework.model.result.ApiResult
import com.zetaframework.msg.model.PrivateMessageParam
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.messaging.MessagingException
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.user.SimpUserRegistry
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * websocket测试
 *
 * @author gcc
 */
@RestController
@RequestMapping("/api/msg")
class WebsocketController(
    private val simpMessagingTemplate: SimpMessagingTemplate,
    private val userRegistry: SimpUserRegistry,
) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    /**
     * 群发消息
     *
     * @param message 群发消息内容
     */
    @GetMapping("/group")
    fun group(
        @RequestParam message: String,
    ): ApiResult<Boolean> {
        return try {
            simpMessagingTemplate.convertAndSend("/topic/group", message)
            ApiResult.success()
        } catch (e: MessagingException) {
            logger.error("群发消息发送失败", e)
            ApiResult.fail()
        }
    }

    /**
     * 私聊消息
     *
     * @param message 私聊消息参数
     */
    @PostMapping("/group")
    fun privateChat(
        @RequestBody @Validated message: PrivateMessageParam,
    ): ApiResult<Boolean> {
        return try {
            simpMessagingTemplate.convertAndSendToUser(message.toUserId!!, "/queue/private", message.message!!)
            ApiResult.success()
        } catch (e: MessagingException) {
            logger.error("私聊消息发送失败", e)
            return ApiResult.fail()
        }
    }

    /**
     * 获取当前在线人数
     *
     * @return ApiResult<Int>
     */
    @GetMapping("/onlineUser")
    fun onlineUser(): ApiResult<Int> {
        return ApiResult.success(data = userRegistry.userCount)
    }
}
