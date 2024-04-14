package com.zetaframework.system.service.impl.authstrategy

import cn.dev33.satoken.stp.SaLoginModel
import cn.dev33.satoken.stp.StpUtil
import cn.hutool.extra.spring.SpringUtil
import com.zetaframework.crypto.helper.AESHelper
import com.zetaframework.exception.BusinessException
import com.zetaframework.log.enums.LoginStateEnum
import com.zetaframework.log.event.LoginEvent
import com.zetaframework.log.model.LoginLogDTO
import com.zetaframework.satoken.utils.LoginHelper
import com.zetaframework.system.model.entity.toLoginUser
import com.zetaframework.system.model.enums.UserStateEnum
import com.zetaframework.system.model.param.LoginParam
import com.zetaframework.system.model.result.LoginResult
import com.zetaframework.system.service.IAuthStrategy
import com.zetaframework.system.service.ISysUserService
import com.zetaframework.utils.ServletUtil
import org.springframework.stereotype.Service

/**
 * 密码授权策略
 * @author <a href="mailto:weistuday@gmail.com">caoweifeng</a>
 * @date 2024年03月31日 15:30
 */
@Service
class PasswordAuthStrategyImpl(
    private val userService: ISysUserService,
    private val aseHelper: AESHelper,
) : IAuthStrategy {
    override fun login(param: LoginParam): LoginResult {
        // 查询用户, 因为账号已经判空过了所以这里直接param.account!!
        val user = userService.getByAccount(param.account!!) ?: throw BusinessException("用户不存在")

        // 密码解密
        val password =
            try {
                aseHelper.decryptStr(param.password!!)
            } catch (e: Exception) {
                ""
            }
        val userId = user.id
        // 比较密码
        if (!userService.comparePassword(password, user.password!!)) {
            SpringUtil.publishEvent(
                LoginEvent(
                    LoginLogDTO.loginFail(
                        param.account!!,
                        userId,
                        LoginStateEnum.ERROR_PWD,
                        ServletUtil.getRequest()!!,
                    ),
                ),
            )
            // 密码不正确
            throw BusinessException(LoginStateEnum.ERROR_PWD.desc)
        }
        // 判断用户状态
        if (user.state == UserStateEnum.FORBIDDEN.code) {
            SpringUtil.publishEvent(
                LoginEvent(
                    LoginLogDTO.loginFail(
                        param.account!!,
                        userId,
                        LoginStateEnum.FAIL,
                        "用户被禁用，无法登录",
                        ServletUtil.getRequest()!!,
                    ),
                ),
            )
            throw BusinessException("用户被禁用，无法登录")
        }

        // 踢人下线并登录
        StpUtil.kickout(userId)

        LoginHelper.login(user.toLoginUser(), SaLoginModel())

        return LoginResult(StpUtil.getTokenName(), StpUtil.getTokenValue())
    }
}
