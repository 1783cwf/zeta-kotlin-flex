package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.tangzc.autotable.annotation.AutoTable
import com.tangzc.autotable.annotation.Ignore
import com.zetaframework.mybatisflex.annotation.ColumnDefine
import com.zetaframework.mybatisflex.constant.DBTypeConstant.TINYINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
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
@AutoTable(value = "sys_menu", comment = "菜单")
class SysMenu : TreeEntity<SysMenu, Long>() {
    /** 路由名称 */
    @Column(value = "name")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "路由名称")
    var name: String? = null

    /** 路由地址 */
    @Column(value = "path")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "路由地址")
    var path: String? = null

    /** 组件地址 */
    @Column(value = "component")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "组件地址")
    var component: String? = null

    /** 重定向地址 */
    @Column(value = "redirect")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "重定向地址")
    var redirect: String? = null

    /** 图标 */
    @Column(value = "icon")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "图标")
    var icon: String? = null

    /** 权限标识 */
    @Column(value = "authority")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "权限标识")
    var authority: String? = null

    /** 菜单类型 */
    @get:NotNull(message = "菜单类型不能为空")
    @Column(value = "type")
    @ColumnDefine(type = VARCHAR, length = 32, comment = "菜单类型")
    var type: MenuTypeEnum? = null

    /** 是否隐藏 0否 1是 */
    @Column(value = "hide")
    @ColumnDefine(type = TINYINT, length = 1, comment = "是否隐藏 0否 1是")
    var hide: Boolean? = null

    /** 是否缓存 */
    @Column(value = "keep_alive")
    @ColumnDefine(type = TINYINT, length = 1, comment = "是否缓存 0否 1是")
    var keepAlive: Boolean? = null

    /** 外链地址 */
    @Column(value = "href")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "外链地址")
    var href: String? = null

    /** 内链地址 */
    @Column(value = "frame_src")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "内链地址")
    var frameSrc: String? = null

    /** 角色权限树选中状态 */
    @Column(ignore = true)
    @Ignore
    var checked: Boolean? = null

    override fun toString(): String {
        return "SysMenu(name=$name, path=$path, component=$component, redirect=$redirect, icon=$icon, authority=$authority, type=$type, hide=$hide, keepAlive=$keepAlive, href=$href, frameSrc=$frameSrc, checked=$checked)"
    }
}
