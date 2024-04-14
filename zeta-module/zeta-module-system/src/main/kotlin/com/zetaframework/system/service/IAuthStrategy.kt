package com.zetaframework.system.service

import cn.hutool.extra.spring.SpringUtil
import com.zetaframework.system.model.enums.GrantTypeEnum
import com.zetaframework.system.model.param.LoginParam
import com.zetaframework.system.model.result.LoginResult
import com.zetaframework.system.service.impl.authstrategy.EmailAuthStrategyImpl
import com.zetaframework.system.service.impl.authstrategy.PasswordAuthStrategyImpl
import com.zetaframework.system.service.impl.authstrategy.SmsAuthStrategyImpl
import com.zetaframework.system.service.impl.authstrategy.SocialAuthStrategyImpl

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

/**
 * 获取授权策略
 * @param grantType 授权类型
 * @return IAuthStrategy 授权策略
 */
fun getGranter(grantType: GrantTypeEnum): IAuthStrategy {
    return when (grantType) {
        GrantTypeEnum.PASSWORD -> SpringUtil.getBean(PasswordAuthStrategyImpl::class.java)
        GrantTypeEnum.SMS -> SpringUtil.getBean(SmsAuthStrategyImpl::class.java)
        GrantTypeEnum.EMAIL -> SpringUtil.getBean(EmailAuthStrategyImpl::class.java)
        GrantTypeEnum.SOCIAL -> SpringUtil.getBean(SocialAuthStrategyImpl::class.java)
    }
}
