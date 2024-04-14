package com.zetaframework.model.dto

import java.time.LocalDateTime

/**
 * @author <a href="mailto:weistuday@gmail.com">caoweifeng</a>
 * @date 2024年03月30日 12:44
 */
data class SysRoleDTO(
    /** 角色id */

    var id: Long? = null,
    /** 角色名 */

    var name: String? = null,
    /** 角色编码 */

    var code: String? = null,
    /** 描述 */

    var describe: String? = null,
    /** 创建时间 */

    var createTime: LocalDateTime? = null,
    /** 创建人ID */

    var createdBy: Long? = null,
    /** 最后修改时间 */

    var updateTime: LocalDateTime? = null,
    /** 最后修改人ID */

    var updatedBy: Long? = null,
    /** 用户id */

    var userId: Long? = null,
)
