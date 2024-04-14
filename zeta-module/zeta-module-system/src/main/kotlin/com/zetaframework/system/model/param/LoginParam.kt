package com.zetaframework.system.model.param

import com.zetaframework.system.model.enums.GrantTypeEnum
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

/**
 * 登录参数
 *
 * @author gcc
 */

data class LoginParam(
    /** 账号 */

    @get:NotBlank(message = "账号不能为空")
    var account: String? = null,
    /** 密码 */

    @get:NotBlank(message = "密码不能为空")
    var password: String? = null,
    /** 验证码key */

    @get:NotNull(message = "验证码key不能为空")
    var key: Long? = null,
    /** 验证码 */

    @get:NotBlank(message = "验证码不能为空")
    val code: String? = null,
    @get:NotNull(message = "授权类型不能为空")
    val grantType: GrantTypeEnum,
)
