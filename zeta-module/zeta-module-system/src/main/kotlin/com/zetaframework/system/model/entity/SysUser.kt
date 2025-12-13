package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.model.dto.SysRoleDTO
import com.zetaframework.model.entity.LoginUser
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BOOL
import com.zetaframework.mybatisflex.constant.DBTypeConstant.INT
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
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoColumns
import org.dromara.autotable.annotation.Ignore
import org.dromara.autotable.annotation.mysql.MysqlTypeConstant.TINYINT
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.CHAR
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.DATE
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.NUMBER
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.VARCHAR2
import org.dromara.autotable.core.constants.DatabaseDialect
import java.time.LocalDate

/**
 * 用户
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Table(value = "sys_user", comment = "用户表")
@AutoMappers(
    AutoMapper(target = UserInfoDTO::class),
    AutoMapper(target = SysUserSaveDTO::class),
    AutoMapper(target = SysUserUpdateDTO::class),
    AutoMapper(target = SysUserQueryParam::class),
)
class SysUser : StateEntity<Long>() {
    /** 用户名 */
    @get:NotBlank(message = "用户名不能为空")
    @get:Size(max = 32, message = "用户名长度不能大于32")
    @field:Column(value = "username", comment = "用户名")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 32, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 32),
    )
    var username: String? = null

    /** 账号 */
    @get:NotBlank(message = "账号不能为空")
    @get:Size(max = 32, message = "账号长度不能大于64")
    @field:Column(value = "account", comment = "账号")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 64, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 64),
    )
    var account: String? = null

    /** 密码 */
    @get:NotBlank(message = "密码不能为空")
    @get:Size(max = 32, message = "密码长度不能大于64")
    @field:Column(value = "password", comment = "密码")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 64, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 64),
    )
    var password: String? = null

    /** 邮箱 */
    @field:Column(value = "email", comment = "邮箱")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 32, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 32),
    )
    var email: String? = null

    /** 手机号 */
    @field:Column(value = "mobile", comment = "手机号")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 20, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 20),
    )
    var mobile: String? = null

    /** 性别 0 男 1 女 2 保密*/
    @get:NotNull(message = "性别不能为空")
    @field:Column(value = "sex", comment = "性别 0 男 1 女 2 保密")
    @field:AutoColumns(
        AutoColumn(type = NUMBER, length = 1, defaultValue = "0", dialect = DatabaseDialect.Oracle),
        AutoColumn(type = TINYINT, length = 1, defaultValue = "0", dialect = DatabaseDialect.MySQL),
        AutoColumn(type = INT, defaultValue = "0"),
    )
    var sex: Int? = null

    /** 头像 */
    @field:Column(value = "avatar", comment = "头像")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var avatar: String? = null

    /** 生日 */
    @field:Column(value = "birthday", comment = "生日")
    @field:AutoColumns(
        AutoColumn(type = DATE, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = DATE),
    )
    var birthday: LocalDate? = null

    /** 是否内置 0否 1是 */
    @field:Column(value = "readonly_", comment = "是否内置 0否 1是")
    @field:AutoColumns(
        AutoColumn(
            type = CHAR,
            length = 1,
            notNull = true,
            defaultValue = "N",
            dialect = DatabaseDialect.Oracle,
        ),
        AutoColumn(
            type = TINYINT,
            length = 1,
            notNull = true,
            defaultValue = "0",
            dialect = DatabaseDialect.MySQL,
        ),
        AutoColumn(type = BOOL, notNull = true, defaultValue = "false"),
    )
    var readonly: Boolean? = null

    /** 用户角色 */
    @Ignore
    var roles: List<SysRoleDTO>? = null

    override fun toString(): String =
        "SysUser(id=$id, createTime=$createTime, createdBy=$createdBy, updateTime=$updateTime, updatedBy=$updatedBy, username=$username, account=$account, password=$password, email=$email, mobile=$mobile, sex=$sex, avatar=$avatar, birthday=$birthday, readonly=$readonly, deleted=$deleted)"
}

fun SysUser.toLoginUser(): LoginUser {
    val login = LoginUser()

    login.userId = id
    login.username = username
    login.account = account

    return login
}
