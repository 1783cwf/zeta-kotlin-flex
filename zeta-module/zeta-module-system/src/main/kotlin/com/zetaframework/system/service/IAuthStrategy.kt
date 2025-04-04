package com.zetaframework.system.service

import com.zetaframework.system.model.param.LoginParam
import com.zetaframework.system.model.result.LoginResult

/**
 * 授权策略
 *
 * @author <a href="mailto:weistuday@gmail.com">caoweifeng</a>
 * @date 2024年03月31日 15:17
 */
interface IAuthStrategy {
    /**
     * 登录
     */
    fun login(param: LoginParam): LoginResult
}
