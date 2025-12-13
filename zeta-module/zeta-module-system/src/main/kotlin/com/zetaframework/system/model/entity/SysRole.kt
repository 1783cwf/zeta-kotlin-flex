package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.model.dto.SysRoleDTO
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BOOL
import com.zetaframework.mybatisflex.constant.DBTypeConstant.TINYINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.BaseEntity
import io.github.linpeilie.annotations.AutoMapper
import jakarta.validation.constraints.NotBlank
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoColumns
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.CHAR
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.VARCHAR2
import org.dromara.autotable.core.constants.DatabaseDialect

/**
 * 角色
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Table(value = "sys_role", comment = "角色")
@AutoMapper(target = SysRoleDTO::class)
class SysRole : BaseEntity() {
    /** 角色名 */
    @get:NotBlank(message = "角色名不能为空")
    @field:Column(value = "name", comment = "角色名")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 32, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 32),
    )
    var name: String? = null

    /** 角色编码 */
    @get:NotBlank(message = "角色编码不能为空")
    @field:Column(value = "code", comment = "角色编码")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 32, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 32),
    )
    var code: String? = null

    /** 描述 */
    @field:Column(value = "describe", comment = "描述")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var describe: String? = null

    /** 是否内置 0否 1是 */
    @field:Column(value = "readonly", comment = "是否内置 0否 1是")
    @field:AutoColumns(
        AutoColumn(type = CHAR, length = 1, defaultValue = "N", dialect = DatabaseDialect.Oracle),
        AutoColumn(type = TINYINT, length = 1, defaultValue = "0", dialect = DatabaseDialect.MySQL),
        AutoColumn(type = BOOL, defaultValue = "false"),
    )
    var readonly: Boolean? = null

    override fun toString(): String =
        "SysRole(id=$id, createTime=$createTime, createdBy=$createdBy, updateTime=$updateTime, updatedBy=$updatedBy, name=$name, code=$code, describe=$describe, readonly=$readonly, deleted=$deleted)"
}
