package com.zetaframework.system.service.impl.authstrategy

import com.zetaframework.system.model.param.LoginParam
import com.zetaframework.system.model.result.LoginResult
import com.zetaframework.system.service.IAuthStrategy
import org.springframework.stereotype.Service

/**
 * 第三方授权策略
 * @author <a href="mailto:weistuday@gmail.com">caoweifeng</a>
 * @date 2024年03月31日 15:31
 */
@Service
class SocialAuthStrategyImpl : IAuthStrategy {
    override fun login(param: LoginParam): LoginResult {
        TODO("Not yet implemented")
    }
}
