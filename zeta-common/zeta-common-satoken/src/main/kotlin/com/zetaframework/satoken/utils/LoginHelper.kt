package com.zetaframework.satoken.utils

import cn.dev33.satoken.stp.SaLoginModel
import cn.dev33.satoken.stp.StpUtil
import cn.hutool.core.convert.Convert
import com.zetaframework.model.entity.LoginUser

/**
 * @author <a href="mailto:weistuday@gmail.com">caoweifeng</a>
 * @date 2024年03月16日 18:11
 */
object LoginHelper {
    const val LOGIN_USER_KEY: String = "loginUser"
    const val TENANT_KEY: String = "tenantId"
    const val USER_KEY: String = "userId"
    const val USER_NAME_KEY: String = "userName"
    const val ACCOUNT: String = "account"
    const val DEPT_KEY: String = "deptId"
    const val DEPT_NAME_KEY: String = "deptName"
    const val CLIENT_KEY: String = "clientid"

    /**
     * 登录
     * @param loginUser 登录用户信息
     * @param model     配置参数
     */
    fun login(
        loginUser: LoginUser,
        model: SaLoginModel?,
    ) {
        val saLoginModel = model ?: SaLoginModel()

        val userId = loginUser.userId
        val username = loginUser.username
        StpUtil.login(
            userId,
            saLoginModel.setExtra(USER_KEY, userId)
                .setExtra(USER_NAME_KEY, username)
                .setExtra(ACCOUNT, loginUser.account),
        )

        loginUser.rolePermission = StpUtil.getRoleList().toSet()
        loginUser.menuPermission = StpUtil.getPermissionList().toSet()

        StpUtil.getSession()
            .set(LOGIN_USER_KEY, loginUser)
            .updateTimeout(model!!.getTimeout())
    }

    /**
     * 获取用户基于多级缓存
     */
    fun getLoginUser(): LoginUser {
        return StpUtil.getSession().get(LOGIN_USER_KEY) as LoginUser
    }

    /**
     * 获取用户基于token
     */
    fun getLoginUser(token: String): LoginUser {
        return StpUtil.getTokenSessionByToken(token).get(LOGIN_USER_KEY) as LoginUser
    }

    /**
     * 获取用户ID
     */
    fun getUserId(): Long? {
        return Convert.toLong(getExtra(USER_KEY))
    }

    /**
     * 获取用户名
     */
    fun getUserName(): String {
        return getExtra(USER_NAME_KEY) as String
    }

    /**
     * 获取账号
     */
    fun getAccount(): String {
        return getExtra(USER_NAME_KEY) as String
    }

    /**
     * 获取扩展信息
     */
    fun getExtra(key: String): Any? {
        return try {
            StpUtil.getExtra(key)
        } catch (e: Exception) {
            null
        }
    }

    /**
     * 判断当前用户是否已经登录
     */
    fun isLogin(): Boolean {
        return StpUtil.isLogin()
    }
}
