package com.zetaframework.system.model.result

/**
 * 登录返回结果
 *
 * @author gcc
 */

data class LoginResult(
    /** token名称 */

    val tokenName: String? = null,
    /** token值 */

    val token: String? = null,
)
