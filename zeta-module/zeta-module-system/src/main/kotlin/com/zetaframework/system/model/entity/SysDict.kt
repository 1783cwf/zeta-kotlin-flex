package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.mybatisflex.constant.DBTypeConstant.INT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.BaseEntity
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoColumns
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.NUMBER
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.VARCHAR2
import org.dromara.autotable.core.constants.DatabaseDialect

/**
 * 字典
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:38:20
 */
@Table(value = "sys_dict", comment = "字典表")
class SysDict : BaseEntity() {
    /** 名称 */
    @get:NotBlank(message = "名称不能为空")
    @get:Size(max = 32, message = "名称长度不能超过32")
    @field:Column(value = "name", comment = "名称")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 32, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 32),
    )
    var name: String? = null

    /** 编码 */
    @get:NotBlank(message = "编码不能为空")
    @get:Size(max = 32, message = "编码长度不能超过32")
    @field:Column(value = "code", comment = "编码")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 32, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 32),
    )
    var code: String? = null

    /** 描述 */
    @field:Column(value = "remark", comment = "备注")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var remark: String? = null

    /** 排序 */
    @field:Column(value = "sort_value", comment = "排序")
    @field:AutoColumns(
        AutoColumn(type = NUMBER, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = INT),
    )
    var sortValue: Int? = null

    override fun toString(): String =
        "SysDict(id=$id, createTime=$createTime, createdBy=$createdBy, updateTime=$updateTime, updatedBy=$updatedBy, name=$name, code=$code, remark=$remark, sortValue=$sortValue, deleted=$deleted)"
}
