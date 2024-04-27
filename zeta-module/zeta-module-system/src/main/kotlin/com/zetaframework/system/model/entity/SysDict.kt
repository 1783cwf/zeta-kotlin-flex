package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.tangzc.autotable.annotation.AutoTable
import com.zetaframework.mybatisflex.annotation.ColumnDefine
import com.zetaframework.mybatisflex.constant.DBTypeConstant.INT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
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
@AutoTable(value = "sys_dict", comment = "字典表")
class SysDict : BaseEntity<Long>() {
    /** 名称 */
    @get:NotBlank(message = "名称不能为空")
    @get:Size(max = 32, message = "名称长度不能超过32")
    @Column(value = "name")
    @ColumnDefine(type = VARCHAR, length = 32, comment = "名称")
    var name: String? = null

    /** 编码 */
    @get:NotBlank(message = "编码不能为空")
    @get:Size(max = 32, message = "编码长度不能超过32")
    @Column(value = "code")
    @ColumnDefine(type = VARCHAR, length = 32, comment = "编码")
    var code: String? = null

    /** 描述 */
    @Column(value = "describe_")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "描述")
    var describe: String? = null

    /** 排序 */
    @Column(value = "sort_value")
    @ColumnDefine(type = INT, length = 10, comment = "排序")
    var sortValue: Int? = null

    override fun toString(): String {
        return "SysDict(id=$id, createTime=$createTime, createdBy=$createdBy, updateTime=$updateTime, updatedBy=$updatedBy, name=$name, code=$code, describe=$describe, sortValue=$sortValue, deleted=$deleted)"
    }
}
