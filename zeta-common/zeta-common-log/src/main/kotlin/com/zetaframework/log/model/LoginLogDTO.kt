package com.zetaframework.log.model

import cn.hutool.http.useragent.UserAgentUtil
import com.zetaframework.log.enums.LoginStateEnum
import com.zetaframework.utils.IpAddressUtil
import com.zetaframework.utils.ServletUtil
import jakarta.servlet.http.HttpServletRequest
import java.time.LocalDateTime

/**
 * 登录日志
 *
 * @author gcc
 */
data class LoginLogDTO(
    /** 状态 see: [LoginStateEnum] */
    var state: String? = null,
    /** 用户id */
    var userId: Long? = null,
    /** 账号 */
    var account: String? = null,
    /** 操作系统 */
    var os: String? = null,
    /** 设备名称 */
    var device: String? = null,
    /** 浏览器类型 */
    var browser: String? = null,
    /** ip地址 */
    var ip: String? = null,
    /** ip所在地区 */
    var ipRegion: String? = null,
    /** 备注 */
    var comments: String? = null,
    /** 创建时间 */
    var createTime: LocalDateTime? = null,
) {
    companion object {
        /**
         * 构造登录日志
         *
         * @param account 账号
         * @param userId 用户id
         * @param state 状态
         * @param comments 备注
         * @param request HttpServletRequest
         * @return LoginLogDTO
         */
        fun build(
            account: String,
            userId: Long?,
            state: String,
            comments: String? = "登录成功",
            request: HttpServletRequest,
        ): LoginLogDTO {
            val ua = UserAgentUtil.parse(ServletUtil.getHeaderIgnoreCase(request, "User-Agent"))
            return LoginLogDTO().apply {
                this.userId = userId
                this.account = account
                this.createTime = LocalDateTime.now()
                this.state = state
                this.comments = comments
                this.os = ua.platform.name
                this.device = ua.os.name
                this.browser = ua.browser.name
                this.ip = ServletUtil.getClientIP(request)
                this.ip?.let { ip ->
                    this.ipRegion = IpAddressUtil.search(ip)
                }
            }
        }

        /**
         * 构造登录成功日志
         *
         * @param account 账号
         * @param userId 用户id
         * @param comments 备注
         * @param request HttpServletRequest
         * @return LoginLogDTO
         */
        fun loginSuccess(
            account: String,
            userId: Long?,
            comments: String? = "登录成功",
            request: HttpServletRequest,
        ): LoginLogDTO = build(account, userId, LoginStateEnum.SUCCESS.name, request = request)

        /**
         * 构造登录失败日志
         *
         * @param account 账号
         * @param userId 用户id
         * @param state [LoginStateEnum]
         * @param request HttpServletRequest
         * @return LoginLogDTO
         */
        fun loginFail(
            account: String,
            userId: Long?,
            state: LoginStateEnum,
            request: HttpServletRequest,
        ): LoginLogDTO = build(account, userId, state.name, state.desc, request)

        /**
         * 构造登录失败日志
         *
         * @param account 账号
         * @param userId 用户id
         * @param state 状态
         * @param comments 备注
         * @param request HttpServletRequest
         * @return LoginLogDTO
         */
        fun loginFail(
            account: String,
            userId: Long?,
            state: LoginStateEnum,
            comments: String,
            request: HttpServletRequest,
        ): LoginLogDTO = build(account, userId, state.name, comments, request)
    }
}
