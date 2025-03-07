package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Table
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BIGINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.INT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.BaseEntity
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoTable

/**
 * 字典项
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:38:20
 */
@Table(value = "sys_dict_item")
@AutoTable(value = "sys_dict_item", comment = "字典项")
class SysDictItem : BaseEntity<Long>() {
    /** 字典id */
    @get:NotNull(message = "字典id不能为空")
    @AutoColumn(value = "dict_id", type = BIGINT, comment = "字典id")
    var dictId: Long? = null

    /** 字典项 */
    @get:NotBlank(message = "字典项不能为空")
    @get:Size(max = 32, message = "字典项长度不能超过32")
    @AutoColumn(value = "name", type = VARCHAR, length = 32, comment = "字典项")
    var name: String? = null

    /** 值 */
    @get:NotBlank(message = "值不能为空")
    @get:Size(max = 32, message = "值长度不能超过32")
    @AutoColumn(value = "value", type = VARCHAR, length = 32, comment = "值")
    var value: String? = null

    /** 描述 */
    @AutoColumn(value = "describe_", type = VARCHAR, length = 255, comment = "描述")
    var describe: String? = null

    /** 排序 */
    @AutoColumn(value = "sort_value", type = INT, comment = "排序")
    var sortValue: Int? = null

    override fun toString(): String {
        return "SysDictItem(id=$id, createTime=$createTime, createdBy=$createdBy, updateTime=$updateTime, updatedBy=$updatedBy, dictId=$dictId, name=$name, value=$value, describe=$describe, sortValue=$sortValue, deleted=$deleted)"
    }
}
