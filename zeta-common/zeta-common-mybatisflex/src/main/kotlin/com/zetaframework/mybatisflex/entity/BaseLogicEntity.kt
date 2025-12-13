package com.zetaframework.mybatisflex.entity

import com.mybatisflex.annotation.Column
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BOOL
import com.zetaframework.mybatisflex.constant.DBTypeConstant.TINYINT
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoColumns
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.CHAR
import org.dromara.autotable.core.constants.DatabaseDialect

/**
 * 逻辑删除实体.逻辑删除存在很多弊端，不建议无脑所有表都设计为逻辑删除
 * 需要使用逻辑删除是继承该实体
 */
abstract class BaseLogicEntity : BaseEntity<Long>() {
    /** 逻辑删除字段 false 未删除 true已删除*/
    @field:Column(value = "deleted", isLogicDelete = true, comment = "逻辑删除字段")
    @field:AutoColumns(
        AutoColumn(type = CHAR, length = 1, defaultValue = "N", dialect = DatabaseDialect.Oracle),
        AutoColumn(type = TINYINT, length = 1, defaultValue = "0", dialect = DatabaseDialect.MySQL),
        AutoColumn(type = BOOL, defaultValue = "false"),
    )
    open var deleted: Boolean? = null
}
