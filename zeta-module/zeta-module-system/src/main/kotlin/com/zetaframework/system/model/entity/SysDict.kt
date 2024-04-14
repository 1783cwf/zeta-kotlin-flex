package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.mybatisflex.entity.BaseEntity
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

/**
 * 字典
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:38:20
 */
@Table(value = "sys_dict")
class SysDict : BaseEntity<Long>() {
    /** 名称 */
    @get:NotBlank(message = "名称不能为空")
    @get:Size(max = 32, message = "名称长度不能超过32")
    @Column(value = "name")
    var name: String? = null

    /** 编码 */
    @get:NotBlank(message = "编码不能为空")
    @get:Size(max = 32, message = "编码长度不能超过32")
    @Column(value = "code")
    var code: String? = null

    /** 描述 */
    @Column(value = "describe_")
    var describe: String? = null

    /** 排序 */
    @Column(value = "sort_value")
    var sortValue: Int? = null

    override fun toString(): String {
        return "SysDict(id=$id, createTime=$createTime, createdBy=$createdBy, updateTime=$updateTime, updatedBy=$updatedBy, name=$name, code=$code, describe=$describe, sortValue=$sortValue, deleted=$deleted)"
    }
}
