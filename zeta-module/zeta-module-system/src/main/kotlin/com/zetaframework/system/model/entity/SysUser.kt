package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Table
import com.zetaframework.model.dto.SysRoleDTO
import com.zetaframework.model.entity.LoginUser
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
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoTable
import org.dromara.autotable.annotation.Ignore

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
    @AutoColumn(value = "username", type = VARCHAR, length = 32, comment = "用户名")
    var username: String? = null

    /** 账号 */
    @get:NotBlank(message = "账号不能为空")
    @get:Size(max = 32, message = "账号长度不能大于64")
    @AutoColumn(value = "account", type = VARCHAR, length = 64, comment = "账号")
    var account: String? = null

    /** 密码 */
    @get:NotBlank(message = "密码不能为空")
    @get:Size(max = 32, message = "密码长度不能大于64")
    @AutoColumn(value = "password", type = VARCHAR, length = 64, comment = "密码")
    var password: String? = null

    /** 邮箱 */
    @AutoColumn(value = "email", type = VARCHAR, length = 32, comment = "邮箱")
    var email: String? = null

    /** 手机号 */
    @AutoColumn(value = "mobile", type = VARCHAR, length = 20, comment = "手机号")
    var mobile: String? = null

    /** 性别 0 男 1 女 2 保密*/
    @get:NotNull(message = "性别不能为空")
    @AutoColumn(value = "sex", type = TINYINT, length = 1, defaultValue = "0")
    var sex: Int? = null

    /** 头像 */
    @AutoColumn(value = "avatar", type = VARCHAR, length = 255, comment = "头像")
    var avatar: String? = null

    /** 生日 */
    @AutoColumn(value = "birthday", type = DATE, comment = "生日")
    var birthday: LocalDate? = null

    /** 是否内置 0否 1是 */
    @AutoColumn(value = "readonly_", type = TINYINT, length = 1, notNull = true, defaultValue = "0", comment = "是否内置 0否 1是")
    var readonly: Boolean? = null

    /** 用户角色 */
    @Ignore
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
