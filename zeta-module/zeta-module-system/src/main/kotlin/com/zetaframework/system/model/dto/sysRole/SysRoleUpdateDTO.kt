package com.zetaframework.system.model.dto.sysRole

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

/**
 * 修改 角色
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */

data class SysRoleUpdateDTO(
    /** 角色id */

    @get:NotNull(message = "id不能为空")
    var id: Long? = null,
    /** 角色名 */

    @get:NotBlank(message = "角色名不能为空")
    var name: String? = null,
    /** 角色编码 */

    @get:NotBlank(message = "角色编码不能为空")
    var code: String? = null,
    /** 描述 */

    var describe: String? = null,
)
