package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.mybatisflex.constant.DBTypeConstant.TINYINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.TreeEntity
import com.zetaframework.system.model.enums.MenuTypeEnum
import jakarta.validation.constraints.NotNull
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoTable
import org.dromara.autotable.annotation.Ignore

/**
 * 菜单
 *
 * @author AutoGenerator
 * @date 2022-04-24 17:45:03
 */
@Table(value = "sys_menu")
@AutoTable(value = "sys_menu", comment = "菜单")
class SysMenu : TreeEntity<SysMenu, Long>() {
    /** 路由名称 */
    @AutoColumn(value = "name", type = VARCHAR, length = 255, comment = "路由名称")
    var name: String? = null

    /** 路由地址 */
    @AutoColumn(value = "path", type = VARCHAR, length = 255, comment = "路由地址")
    var path: String? = null

    /** 组件地址 */
    @AutoColumn(value = "component", type = VARCHAR, length = 255, comment = "组件地址")
    var component: String? = null

    /** 重定向地址 */
    @AutoColumn(value = "redirect", type = VARCHAR, length = 255, comment = "重定向地址")
    var redirect: String? = null

    /** 图标 */
    @AutoColumn(value = "icon", type = VARCHAR, length = 255, comment = "图标")
    var icon: String? = null

    /** 权限标识 */
    @AutoColumn(value = "authority", type = VARCHAR, length = 255, comment = "权限标识")
    var authority: String? = null

    /** 菜单类型 */
    @get:NotNull(message = "菜单类型不能为空")
    @AutoColumn(value = "menu_type", type = VARCHAR, length = 32, comment = "菜单类型")
    var menuType: MenuTypeEnum? = null

    /** 是否隐藏 0否 1是 */
    @AutoColumn(value = "hide", type = TINYINT, length = 1, comment = "是否隐藏 0否 1是")
    var hide: Boolean? = null

    /** 是否缓存 */
    @AutoColumn(value = "keep_alive", type = TINYINT, length = 1, comment = "是否缓存 0否 1是")
    var keepAlive: Boolean? = null

    /** 外链地址 */
    @AutoColumn(value = "href", type = VARCHAR, length = 255, comment = "外链地址")
    var href: String? = null

    /** 内链地址 */
    @AutoColumn(value = "frame_src", type = VARCHAR, length = 255, comment = "内链地址")
    var frameSrc: String? = null

    /** 角色权限树选中状态 */
    @Column(ignore = true)
    @Ignore
    var checked: Boolean? = null

    override fun toString(): String =
        "SysMenu(name=$name, path=$path, component=$component, redirect=$redirect, icon=$icon, authority=$authority, menuType=$menuType, hide=$hide, keepAlive=$keepAlive, href=$href, frameSrc=$frameSrc, checked=$checked)"
}
