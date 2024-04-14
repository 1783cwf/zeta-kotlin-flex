package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.mybatisflex.entity.TreeEntity
import com.zetaframework.system.model.enums.MenuTypeEnum
import jakarta.validation.constraints.NotNull

/**
 * 菜单
 *
 * @author AutoGenerator
 * @date 2022-04-24 17:45:03
 */
@Table(value = "sys_menu")
class SysMenu : TreeEntity<SysMenu, Long>() {
    /** 路由名称 */
    @Column(value = "name")
    var name: String? = null

    /** 路由地址 */
    @Column(value = "path")
    var path: String? = null

    /** 组件地址 */
    @Column(value = "component")
    var component: String? = null

    /** 重定向地址 */
    @Column(value = "redirect")
    var redirect: String? = null

    /** 图标 */
    @Column(value = "icon")
    var icon: String? = null

    /** 权限标识 */
    @Column(value = "authority")
    var authority: String? = null

    /** 菜单类型 */
    @get:NotNull(message = "菜单类型不能为空")
    @Column(value = "type")
    var type: MenuTypeEnum? = null

    /** 是否隐藏 0否 1是 */
    @Column(value = "hide")
    var hide: Boolean? = null

    /** 是否缓存 */
    @Column(value = "keep_alive")
    var keepAlive: Boolean? = null

    /** 外链地址 */
    @Column(value = "href")
    var href: String? = null

    /** 内链地址 */
    @Column(value = "frame_src")
    var frameSrc: String? = null

    /** 角色权限树选中状态 */
    @Column(ignore = true)
    var checked: Boolean? = null

    @Column(value = "version", version = true)
    override var version: Int? = null

    override fun toString(): String {
        return "SysMenu(name=$name, path=$path, component=$component, redirect=$redirect, icon=$icon, authority=$authority, type=$type, hide=$hide, keepAlive=$keepAlive, href=$href, frameSrc=$frameSrc, checked=$checked)"
    }
}
