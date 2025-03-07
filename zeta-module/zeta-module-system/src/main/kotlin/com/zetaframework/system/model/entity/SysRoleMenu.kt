package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Table
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BIGINT
import com.zetaframework.mybatisflex.entity.BaseEntity
import jakarta.validation.constraints.NotNull
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoTable
import org.dromara.autotable.annotation.Index

/**
 * 角色菜单
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Table(value = "sys_role_menu")
@AutoTable(value = "sys_role_menu", comment = "角色菜单")
class SysRoleMenu() : BaseEntity<Long>() {
    /** 角色id */
    @get:NotNull(message = "角色id不能为空")
    @AutoColumn(value = "role_id", type = BIGINT, comment = "角色id")
    @Index
    var roleId: Long? = null

    /** 菜单id */
    @get:NotNull(message = "菜单id不能为空")
    @AutoColumn(value = "menu_id", type = BIGINT, comment = "菜单id")
    @Index
    var menuId: Long? = null

    constructor(roleId: Long?, menuId: Long?) : this() {
        this.roleId = roleId
        this.menuId = menuId
    }

    override fun toString(): String {
        return "SysRoleMenu(id=$id, createTime=$createTime, createdBy=$createdBy, roleId=$roleId, menuId=$menuId)"
    }
}
