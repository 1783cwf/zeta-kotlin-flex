package com.zetaframework.system.model.dto.sysRole

import jakarta.validation.constraints.NotBlank

/**
 * 新增 角色
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */

data class SysRoleSaveDTO(
    /** 角色名 */

    @get:NotBlank(message = "角色名不能为空")
    var name: String? = null,
    /** 角色编码 */

    @get:NotBlank(message = "角色编码不能为空")
    var code: String? = null,
    /** 描述 */

    var describe: String? = null,
)
