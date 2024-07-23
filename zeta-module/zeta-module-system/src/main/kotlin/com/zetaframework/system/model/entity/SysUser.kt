package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.tangzc.autotable.annotation.AutoTable
import com.tangzc.autotable.annotation.Ignore
import com.zetaframework.model.dto.SysRoleDTO
import com.zetaframework.model.entity.LoginUser
import com.zetaframework.mybatisflex.annotation.ColumnDefine
import com.zetaframework.mybatisflex.constant.DBTypeConstant.DATE
import com.zetaframework.mybatisflex.constant.DBTypeConstant.TINYINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.StateEntity
import com.zetaframework.system.model.dto.sysUser.SysUserSaveDTO
import com.zetaframework.system.model.dto.sysUser.SysUserUpdateDTO
import com.zetaframework.system.model.dto.sysUser.UserInfoDTO
import com.zetaframework.system.model.param.SysUserQueryParam
import io.github.linpeilie.annotations.AutoMapper
import io.github.linpeilie.annotations.AutoMappers
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

/**
 * 用户
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Table(value = "sys_user")
@AutoMappers(
    AutoMapper(target = UserInfoDTO::class),
    AutoMapper(target = SysUserSaveDTO::class),
    AutoMapper(target = SysUserUpdateDTO::class),
    AutoMapper(target = SysUserQueryParam::class),
)
@AutoTable(value = "sys_user", comment = "用户表")
class SysUser : StateEntity<Long>() {
    /** 用户名 */
    @get:NotBlank(message = "用户名不能为空")
    @get:Size(max = 32, message = "用户名长度不能大于32")
    @Column(value = "username")
    @ColumnDefine(type = VARCHAR, length = 32, comment = "用户名")
    var username: String? = null

    /** 账号 */
    @get:NotBlank(message = "账号不能为空")
    @get:Size(max = 32, message = "账号长度不能大于64")
    @Column(value = "account")
    @ColumnDefine(type = VARCHAR, length = 64, comment = "账号")
    var account: String? = null

    /** 密码 */
    @get:NotBlank(message = "密码不能为空")
    @get:Size(max = 32, message = "密码长度不能大于64")
    @Column(value = "password")
    @ColumnDefine(type = VARCHAR, length = 64, comment = "密码")
    var password: String? = null

    /** 邮箱 */
    @Column(value = "email")
    @ColumnDefine(type = VARCHAR, length = 32, comment = "邮箱")
    var email: String? = null

    /** 手机号 */
    @Column(value = "mobile")
    @ColumnDefine(type = VARCHAR, length = 20, comment = "手机号")
    var mobile: String? = null

    /** 性别 0 男 1 女 2 保密*/
    @get:NotNull(message = "性别不能为空")
    @Column(value = "sex")
    @ColumnDefine(type = TINYINT, length = 1, defaultValue = "0")
    var sex: Int? = null

    /** 头像 */
    @Column(value = "avatar")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "头像")
    var avatar: String? = null

    /** 生日 */
    @Column(value = "birthday")
    @ColumnDefine(type = DATE, comment = "生日")
    var birthday: LocalDate? = null

    /** 是否内置 0否 1是 */
    @Column(value = "readonly_")
    @ColumnDefine(type = TINYINT, length = 1, notNull = true, defaultValue = "0", comment = "是否内置 0否 1是")
    var readonly: Boolean? = null

    /** 用户角色 */
    @Ignore
    @Column(ignore = true)
    var roles: List<SysRoleDTO>? = null

    override fun toString(): String {
        return "SysUser(id=$id, createTime=$createTime, createdBy=$createdBy, updateTime=$updateTime, updatedBy=$updatedBy, username=$username, account=$account, password=$password, email=$email, mobile=$mobile, sex=$sex, avatar=$avatar, birthday=$birthday, readonly=$readonly, deleted=$deleted)"
    }
}

fun SysUser.toLoginUser(): LoginUser {
    val login = LoginUser()

    login.userId = id
    login.username = username
    login.account = account

    return login
}
