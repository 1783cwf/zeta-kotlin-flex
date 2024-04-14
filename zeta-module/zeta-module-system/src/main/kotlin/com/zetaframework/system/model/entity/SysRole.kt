package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.model.dto.SysRoleDTO
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
class SysRole : BaseEntity<Long>() {
    /** 角色名 */
    @get:NotBlank(message = "角色名不能为空")
    @Column(value = "name")
    var name: String? = null

    /** 角色编码 */
    @get:NotBlank(message = "角色编码不能为空")
    @Column(value = "code")
    var code: String? = null

    /** 描述 */
    @Column(value = "describe_")
    var describe: String? = null

    /** 是否内置 0否 1是 */
    @Column(value = "readonly_")
    var readonly: Boolean? = null

    override fun toString(): String {
        return "SysRole(id=$id, createTime=$createTime, createdBy=$createdBy, updateTime=$updateTime, updatedBy=$updatedBy, name=$name, code=$code, describe=$describe, readonly=$readonly, deleted=$deleted)"
    }
}
