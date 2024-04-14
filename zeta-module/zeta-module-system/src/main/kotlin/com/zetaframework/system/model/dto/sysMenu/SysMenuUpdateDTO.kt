package com.zetaframework.system.model.dto.sysMenu

import com.zetaframework.system.model.enums.MenuTypeEnum
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

/**
 * 修改 菜单
 *
 * @author AutoGenerator
 * @date 2022-04-24 17:45:03
 */

data class SysMenuUpdateDTO(
    /** id */

    @get:NotNull(message = "id不能为空")
    var id: Long? = null,
    /** 父级id */

    @get:NotNull(message = "父级id不能为空")
    var parentId: Long? = null,
    /** 菜单名称 */

    @get:NotBlank(message = "菜单名称不能为空")
    @get:Size(max = 32, message = "菜单名称长度不能超过32")
    var label: String? = null,
    /** 排序 */

    var sortValue: Int? = null,
    /** 路由名称 */

    var name: String? = null,
    /** 路由地址 */

    var path: String? = null,
    /** 组件地址 */

    var component: String? = null,
    /** 重定向地址 */

    var redirect: String? = null,
    /** 图标 */

    var icon: String? = null,
    /** 权限标识 */

    var authority: String? = null,
    /** 菜单类型 */

    @get:NotNull(message = "菜单类型不能为空")
    var type: MenuTypeEnum? = null,
    /** 是否隐藏 0否 1是 */

    var hide: Boolean? = null,
    /** 是否缓存 */

    var keepAlive: Boolean? = null,
    /** 外链地址 */

    var href: String? = null,
    /** 内链地址 */

    var frameSrc: String? = null,
    var version: Int? = null,
)
