package com.zetaframework.system.listener

import cn.dev33.satoken.listener.SaTokenListener
import cn.dev33.satoken.stp.SaLoginModel
import cn.hutool.core.convert.Convert
import cn.hutool.extra.spring.SpringUtil
import com.zetaframework.log.enums.LoginStateEnum
import com.zetaframework.log.event.LoginEvent
import com.zetaframework.log.model.LoginLogDTO
import com.zetaframework.satoken.utils.LoginHelper
import com.zetaframework.utils.ServletUtil
import org.springframework.stereotype.Component

/**
 * 用户行为 侦听器的实现
 *
 * @author <a href="mailto:weistuday@gmail.com">caoweifeng</a>
 * @date 2024年03月31日 10:47
 */
@Component
class UserActionListener : SaTokenListener {
    /**
     * 每次登录时触发
     * @param loginType 账号类别
     * @param loginId 账号id
     * @param tokenValue 本次登录产生的 token 值
     * @param loginModel 登录参数
     */
    override fun doLogin(
        loginType: String?,
        loginId: Any?,
        tokenValue: String?,
        loginModel: SaLoginModel?,
    ) {
        SpringUtil.publishEvent(
            LoginEvent(
                LoginLogDTO.loginSuccess(
                    Convert.toStr(loginModel?.getExtra(LoginHelper.ACCOUNT)),
                    Convert.toLong(loginModel?.getExtra(LoginHelper.USER_KEY)),
                    request = ServletUtil.getRequest()!!,
                ),
            ),
        )
    }

    /**
     * 每次注销时触发
     * @param loginType 账号类别
     * @param loginId 账号id
     * @param tokenValue token值
     */
    override fun doLogout(
        loginType: String?,
        loginId: Any?,
        tokenValue: String?,
    ) {
        // 登出日志
        SpringUtil.publishEvent(
            LoginEvent(
                LoginLogDTO.loginFail(
                    LoginHelper.getAccount(),
                    LoginHelper.getUserId(),
                    LoginStateEnum.LOGOUT,
                    ServletUtil.getRequest()!!,
                ),
            ),
        )
    }

    /**
     * 每次被踢下线时触发
     * @param loginType 账号类别
     * @param loginId 账号id
     * @param tokenValue token值
     */
    override fun doKickout(
        loginType: String?,
        loginId: Any?,
        tokenValue: String?,
    ) {}

    /**
     * 每次被顶下线时触发
     * @param loginType 账号类别
     * @param loginId 账号id
     * @param tokenValue token值
     */
    override fun doReplaced(
        loginType: String?,
        loginId: Any?,
        tokenValue: String?,
    ) {
    }

    /**
     * 每次被封禁时触发
     * @param loginType 账号类别
     * @param loginId 账号id
     * @param service 指定服务
     * @param level 封禁等级
     * @param disableTime 封禁时长，单位: 秒
     */
    override fun doDisable(
        loginType: String?,
        loginId: Any?,
        service: String?,
        level: Int,
        disableTime: Long,
    ) {
    }

    /**
     * 每次被解封时触发
     * @param loginType 账号类别
     * @param loginId 账号id
     * @param service 指定服务
     */
    override fun doUntieDisable(
        loginType: String?,
        loginId: Any?,
        service: String?,
    ) {
    }

    /**
     * 每次打开二级认证时触发
     * @param loginType 账号类别
     * @param tokenValue token值
     * @param service 指定服务
     * @param safeTime 认证时间，单位：秒
     */
    override fun doOpenSafe(
        loginType: String?,
        tokenValue: String?,
        service: String?,
        safeTime: Long,
    ) {
    }

    /**
     * 每次关闭二级认证时触发
     * @param loginType 账号类别
     * @param tokenValue token值
     * @param service 指定服务
     */
    override fun doCloseSafe(
        loginType: String?,
        tokenValue: String?,
        service: String?,
    ) {
    }

    /**
     * 每次创建 SaSession 时触发
     * @param id SessionId
     */
    override fun doCreateSession(id: String?) {
    }

    /**
     * 每次注销 SaSession 时触发
     * @param id SessionId
     */
    override fun doLogoutSession(id: String?) {
    }

    /**
     * 每次 Token 续期时触发（注意：是 timeout 续期，而不是 active-timeout 续期）
     *
     * @param tokenValue token 值
     * @param loginId 账号id
     * @param timeout 续期时间
     */
    override fun doRenewTimeout(
        tokenValue: String?,
        loginId: Any?,
        timeout: Long,
    ) {
    }
}
