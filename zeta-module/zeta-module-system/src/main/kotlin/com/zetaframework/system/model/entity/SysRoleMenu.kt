package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BIGINT
import com.zetaframework.mybatisflex.entity.BaseEntity
import jakarta.validation.constraints.NotNull
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoColumns
import org.dromara.autotable.annotation.Index
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.NUMBER
import org.dromara.autotable.annotation.pgsql.PgsqlTypeConstant.INT8
import org.dromara.autotable.core.constants.DatabaseDialect

/**
 * 角色菜单
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Table(value = "sys_role_menu", comment = "角色菜单")
class SysRoleMenu() : BaseEntity() {
    /** 角色id */
    @get:NotNull(message = "角色id不能为空")
    @field:Column(value = "role_id", comment = "角色id")
    @field:AutoColumns(
        AutoColumn(type = NUMBER, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = BIGINT, dialect = DatabaseDialect.MySQL),
        AutoColumn(type = INT8),
    )
    @Index
    var roleId: Long? = null

    /** 菜单id */
    @get:NotNull(message = "菜单id不能为空")
    @field:Column(value = "menu_id", comment = "菜单id")
    @field:AutoColumns(
        AutoColumn(type = NUMBER, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = BIGINT, dialect = DatabaseDialect.MySQL),
        AutoColumn(type = INT8),
    )
    @Index
    var menuId: Long? = null

    constructor(roleId: Long?, menuId: Long?) : this() {
        this.roleId = roleId
        this.menuId = menuId
    }

    override fun toString(): String = "SysRoleMenu(id=$id, createTime=$createTime, createdBy=$createdBy, roleId=$roleId, menuId=$menuId)"
}
