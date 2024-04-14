package com.zetaframework.system.model.dto.sysUser

/**
 * 用户信息
 *
 * @author gcc
 */
data class UserInfoDTO(
    /** 用户id */

    var id: Long? = null,
    /** 用户名 */

    var username: String? = null,
    /** 账号 */

    var account: String? = null,
    /** 性别 */
    var sex: Int? = null,
    /** 头像 */

    var avatar: String? = null,
    /** 状态 */

    var state: Int? = null,
    /** 角色列表 */
    var roleIds: List<String>? = null,
    /** 权限列表 */

    var permissions: List<String>? = null,
)
