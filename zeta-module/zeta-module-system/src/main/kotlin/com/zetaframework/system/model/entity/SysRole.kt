package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.tangzc.autotable.annotation.AutoTable
import com.zetaframework.model.dto.SysRoleDTO
import com.zetaframework.mybatisflex.annotation.ColumnDefine
import com.zetaframework.mybatisflex.constant.DBTypeConstant.TINYINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.BaseEntity
import io.github.linpeilie.annotations.AutoMapper
import jakarta.validation.constraints.NotBlank

/**
 * 角色
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Table(value = "sys_role")
@AutoMapper(target = SysRoleDTO::class)
@AutoTable(value = "sys_role", comment = "角色")
class SysRole : BaseEntity<Long>() {
    /** 角色名 */
    @get:NotBlank(message = "角色名不能为空")
    @Column(value = "name")
    @ColumnDefine(type = VARCHAR, length = 32, comment = "角色名")
    var name: String? = null

    /** 角色编码 */
    @get:NotBlank(message = "角色编码不能为空")
    @Column(value = "code")
    @ColumnDefine(type = VARCHAR, length = 32, comment = "角色编码")
    var code: String? = null

    /** 描述 */
    @Column(value = "describe_")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "描述")
    var describe: String? = null

    /** 是否内置 0否 1是 */
    @Column(value = "readonly_")
    @ColumnDefine(type = TINYINT, length = 1, comment = "是否内置 0否 1是")
    var readonly: Boolean? = null

    override fun toString(): String {
        return "SysRole(id=$id, createTime=$createTime, createdBy=$createdBy, updateTime=$updateTime, updatedBy=$updatedBy, name=$name, code=$code, describe=$describe, readonly=$readonly, deleted=$deleted)"
    }
}
