package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.tangzc.autotable.annotation.AutoTable
import com.tangzc.autotable.annotation.Index
import com.zetaframework.mybatisflex.annotation.ColumnDefine
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BIGINT
import com.zetaframework.mybatisflex.entity.BaseEntity
import jakarta.validation.constraints.NotNull

/**
 * 用户角色
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Table(value = "sys_user_role")
@AutoTable(value = "sys_user_role", comment = "用户角色")
class SysUserRole() : BaseEntity<Long>() {
    /** 用户id */
    @get:NotNull(message = "用户id不能为空")
    @Column(value = "user_id")
    @ColumnDefine(type = BIGINT, comment = "用户id")
    @Index
    var userId: Long? = null

    /** 角色id */
    @get:NotNull(message = "角色id不能为空")
    @Column(value = "role_id")
    @ColumnDefine(type = BIGINT, comment = "角色id")
    @Index
    var roleId: Long? = null

    constructor(userId: Long?, roleId: Long?) : this() {
        this.userId = userId
        this.roleId = roleId
    }

    override fun toString(): String {
        return "SysUserRole(id=$id, createTime=$createTime, createdBy=$createdBy, userId=$userId, roleId=$roleId)"
    }
}
