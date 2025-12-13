package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BIGINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.INT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.BaseLogicEntity
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoColumns
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.NUMBER
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.VARCHAR2
import org.dromara.autotable.annotation.pgsql.PgsqlTypeConstant.INT8
import org.dromara.autotable.core.constants.DatabaseDialect

/**
 * 字典项
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:38:20
 */
@Table(value = "sys_dict_item", comment = "字典项")
class SysDictItem : BaseLogicEntity() {
    /** 字典id */
    @get:NotNull(message = "字典id不能为空")
    @field:Column(value = "dict_id", comment = "字典id")
    @field:AutoColumns(
        AutoColumn(type = NUMBER, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = BIGINT, dialect = DatabaseDialect.MySQL),
        AutoColumn(type = INT8),
    )
    var dictId: Long? = null

    /** 字典项 */
    @get:NotBlank(message = "字典项不能为空")
    @get:Size(max = 32, message = "字典项长度不能超过32")
    @field:Column(value = "name", comment = "字典项")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 32, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 32),
    )
    var name: String? = null

    /** 值 */
    @get:NotBlank(message = "值不能为空")
    @get:Size(max = 32, message = "值长度不能超过32")
    @field:Column(value = "value", comment = "值")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 32, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 32),
    )
    var value: String? = null

    /** 描述 */
    @field:Column(value = "describe_", comment = "描述")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var describe: String? = null

    /** 排序 */
    @field:Column(value = "sort_value", comment = "排序")
    @field:AutoColumns(
        AutoColumn(type = NUMBER, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = INT),
    )
    var sortValue: Int? = null

    override fun toString(): String =
        "SysDictItem(id=$id, createTime=$createTime, createdBy=$createdBy, updateTime=$updateTime, updatedBy=$updatedBy, dictId=$dictId, name=$name, value=$value, describe=$describe, sortValue=$sortValue, deleted=$deleted)"
}
