package com.zetaframework.system.model.param

import com.zetaframework.system.model.entity.SysRole
import io.github.linpeilie.annotations.AutoMapper

/**
 * 角色 查询参数
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@AutoMapper(target = SysRole::class)
data class SysRoleQueryParam(
    /** 角色名 */

    var name: String? = null,
    /** 角色编码 */

    var code: String? = null,
    /** 描述 */

    var describe: String? = null,
)
