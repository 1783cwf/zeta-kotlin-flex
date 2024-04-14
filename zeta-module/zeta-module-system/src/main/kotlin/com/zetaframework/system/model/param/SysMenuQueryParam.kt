package com.zetaframework.system.model.param

import com.zetaframework.system.model.entity.SysMenu
import com.zetaframework.system.model.enums.MenuTypeEnum
import io.github.linpeilie.annotations.AutoMapper
import java.time.LocalDateTime

/**
 * 菜单 查询参数
 *
 * @author AutoGenerator
 * @date 2022-04-24 17:45:03
 */
@AutoMapper(target = SysMenu::class)
class SysMenuQueryParam(
    /** id */

    var id: Long? = null,
    /** 创建时间 */

    var createTime: LocalDateTime? = null,
    /** 创建人 */

    var createdBy: Long? = null,
    /** 修改时间 */

    var updateTime: LocalDateTime? = null,
    /** 修改人 */

    var updatedBy: Long? = null,
    /** 名称 */

    var label: String? = null,
    /** 父级id */

    var parentId: Long? = null,
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

    var type: MenuTypeEnum? = null,
    /** 是否隐藏 0否 1是 */

    var hide: Boolean? = null,
    /** 是否缓存 */

    var keepAlive: Boolean? = null,
    /** 外链地址 */

    var href: String? = null,
    /** 内链地址 */

    var frameSrc: String? = null,
)
