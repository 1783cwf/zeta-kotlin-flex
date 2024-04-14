package com.zetaframework.model.entity

import com.zetaframework.model.dto.SysRoleDTO

/**
 * 登录用户身份权限
 *
 * @author <a href="mailto:weistuday@gmail.com">caoweifeng</a>
 * @date 2024年03月16日 19:48
 */
class LoginUser {
    /**
     * 租户ID
     */
    var tenantId: String? = null

    /**
     * 用户ID
     */
    var userId: Long? = null

    /**
     * 部门ID
     */
    var deptId: Long? = null

    /**
     * 部门名
     */
    var deptName: String? = null

    /**
     * 用户唯一标识
     */
    var token: String? = null

    /**
     * 菜单权限
     */
    var menuPermission: Set<String>? = null

    /**
     * 角色权限
     */
    var rolePermission: Set<String>? = null

    /**
     * 用户名
     */
    var username: String? = null

    /**
     * 用户账号
     */
    var account: String? = null

    /**
     * 角色对象
     */
    var roles: List<SysRoleDTO>? = null

    /**
     * 数据权限 当前角色ID
     */
    var roleId: Long? = null
}
