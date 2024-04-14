package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.mybatisflex.entity.BaseEntity
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

/**
 * 字典项
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:38:20
 */
@Table(value = "sys_dict_item")
class SysDictItem : BaseEntity<Long>() {
    /** 字典id */
    @get:NotNull(message = "字典id不能为空")
    @Column(value = "dict_id")
    var dictId: Long? = null

    /** 字典项 */
    @get:NotBlank(message = "字典项不能为空")
    @get:Size(max = 32, message = "字典项长度不能超过32")
    @Column(value = "name")
    var name: String? = null

    /** 值 */
    @get:NotBlank(message = "值不能为空")
    @get:Size(max = 32, message = "值长度不能超过32")
    @Column(value = "value")
    var value: String? = null

    /** 描述 */
    @Column(value = "describe_")
    var describe: String? = null

    /** 排序 */
    @Column(value = "sort_value")
    var sortValue: Int? = null

    override fun toString(): String {
        return "SysDictItem(id=$id, createTime=$createTime, createdBy=$createdBy, updateTime=$updateTime, updatedBy=$updatedBy, dictId=$dictId, name=$name, value=$value, describe=$describe, sortValue=$sortValue, deleted=$deleted)"
    }
}
