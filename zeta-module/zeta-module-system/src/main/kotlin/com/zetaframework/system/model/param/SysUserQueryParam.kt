package com.zetaframework.system.model.param

/**
 * 用户 查询参数
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
data class SysUserQueryParam(
    /** 用户id */

    var id: Long? = null,
    /** 用户名 */

    var username: String? = null,
    /** 账号 */

    var account: String? = null,
    /** 邮箱 */

    var email: String? = null,
    /** 手机号 */

    var mobile: String? = null,
    /** 性别 */

    var sex: Int? = null,
    /** 状态 */

    var state: Int? = null,
)
