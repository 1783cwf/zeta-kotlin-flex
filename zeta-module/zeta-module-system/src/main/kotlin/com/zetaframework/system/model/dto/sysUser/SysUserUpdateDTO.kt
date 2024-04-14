package com.zetaframework.system.model.dto.sysUser

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

/**
 * 修改 用户
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
data class SysUserUpdateDTO(
    /** 用户id */

    @get:NotNull(message = "id不能为空")
    var id: Long? = null,
    /** 用户名 */

    @get:Size(max = 32, message = "用户名长度不能大于32")
    @get:NotBlank(message = "用户名不能为空")
    var username: String? = null,
    /** 邮箱 */

    var email: String? = null,
    /** 手机号 */

    var mobile: String? = null,
    /** 性别 */

    @get:NotNull(message = "性别不能为空")
    var sex: Int? = null,
    /** 生日 */

    var birthday: LocalDate? = null,
    /** 角色id列表 为空代表不关联用户角色 */

    var roleIds: List<Long>? = null,
)
