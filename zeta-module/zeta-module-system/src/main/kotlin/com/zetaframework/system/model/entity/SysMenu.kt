package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BOOL
import com.zetaframework.mybatisflex.constant.DBTypeConstant.TINYINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.TreeEntity
import com.zetaframework.system.model.enums.MenuTypeEnum
import jakarta.validation.constraints.NotNull
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoColumns
import org.dromara.autotable.annotation.Ignore
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.CHAR
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.VARCHAR2
import org.dromara.autotable.core.constants.DatabaseDialect

/**
 * 菜单
 *
 * @author AutoGenerator
 * @date 2022-04-24 17:45:03
 */
@Table(value = "sys_menu", comment = "菜单")
class SysMenu : TreeEntity<SysMenu, Long>() {
    /** 路由名称 */
    @field:Column(value = "name", comment = "路由名称")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var name: String? = null

    /** 路由地址 */
    @field:Column(value = "path", comment = "路由地址")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var path: String? = null

    /** 组件地址 */
    @field:Column(value = "component", comment = "组件地址")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var component: String? = null

    /** 重定向地址 */
    @field:Column(value = "redirect", comment = "重定向地址")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var redirect: String? = null

    /** 图标 */
    @field:Column(value = "icon", comment = "图标")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var icon: String? = null

    /** 权限标识 */
    @field:Column(value = "authority", comment = "权限标识")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var authority: String? = null

    /** 菜单类型 */
    @get:NotNull(message = "菜单类型不能为空")
    @field:Column(value = "menu_type", comment = "菜单类型")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 32, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 32),
    )
    var menuType: MenuTypeEnum? = null

    /** 是否隐藏 0否 1是 */
    @field:Column(value = "hide", comment = "是否隐藏 false否 true是")
    @field:AutoColumns(
        AutoColumn(type = CHAR, length = 1, defaultValue = "N", dialect = DatabaseDialect.Oracle),
        AutoColumn(type = TINYINT, length = 1, defaultValue = "0", dialect = DatabaseDialect.MySQL),
        AutoColumn(type = BOOL, defaultValue = "false"),
    )
    var hide: Boolean? = null

    /** 是否缓存 */
    @field:Column(value = "keep_alive", comment = "是否缓存 false否 true是")
    @field:AutoColumns(
        AutoColumn(type = CHAR, length = 1, defaultValue = "N", dialect = DatabaseDialect.Oracle),
        AutoColumn(type = TINYINT, length = 1, defaultValue = "0", dialect = DatabaseDialect.MySQL),
        AutoColumn(type = BOOL, defaultValue = "false"),
    )
    var keepAlive: Boolean? = null

    /** 外链地址 */
    @field:Column(value = "href", comment = "外链地址")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var href: String? = null

    /** 内链地址 */
    @field:Column(value = "frame_src", comment = "内链地址")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var frameSrc: String? = null

    /** 角色权限树选中状态 */
    @field:Column(ignore = true)
    @Ignore
    var checked: Boolean? = null

    override fun toString(): String =
        "SysMenu(name=$name, path=$path, component=$component, redirect=$redirect, icon=$icon, authority=$authority, menuType=$menuType, hide=$hide, keepAlive=$keepAlive, href=$href, frameSrc=$frameSrc, checked=$checked)"
}
