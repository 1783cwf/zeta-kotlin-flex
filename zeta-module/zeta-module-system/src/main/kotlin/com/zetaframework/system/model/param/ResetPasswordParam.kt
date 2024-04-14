package com.zetaframework.system.model.param

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

/**
 * 重置密码参数
 *
 * @author gcc
 */

data class ResetPasswordParam(
    /** 用户id */

    @get:NotNull(message = "用户id不能为空")
    var id: Long? = null,
    /** 密码 */

    @get:NotBlank(message = "密码不能为空")
    var password: String? = null,
)
