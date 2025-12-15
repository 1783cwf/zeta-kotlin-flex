package com.zetaframework.mybatisflex.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Id
import com.mybatisflex.annotation.KeyType
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BIGINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.DATE
import com.zetaframework.mybatisflex.constant.DBTypeConstant.DATETIME
import com.zetaframework.mybatisflex.constant.DBTypeConstant.TIMESTAMP
import com.zetaframework.validation.group.Update
import jakarta.validation.constraints.NotNull
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoColumns
import org.dromara.autotable.annotation.PrimaryKey
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.NUMBER
import org.dromara.autotable.annotation.pgsql.PgsqlTypeConstant.INT8
import org.dromara.autotable.core.constants.DatabaseDialect
import java.io.Serializable
import java.time.LocalDateTime

/**
 * 包括id、create_time、create_by、update_by、update_time、version、deleted字段的表继承的基础实体
 *
 * 继承的实体不使用自动填充
 * @author gcc
 * @date 2021/10/18 下午2:22
 * @since 1.0.0
 */
abstract class LogBaseEntity<T>(
    /** id */
    @get:NotNull(message = "id不能为空", groups = [Update::class])
    @Id(keyType = KeyType.Generator, value = "flexId")
    @PrimaryKey(autoIncrement = false)
    @field:Column(value = "id", comment = "主键ID")
    @field:AutoColumns(
        AutoColumn(type = NUMBER, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = BIGINT, dialect = DatabaseDialect.MySQL),
        AutoColumn(type = INT8),
    )
    open var id: Long? = null,
    /** 创建时间 */
    @field:Column(value = "create_time", comment = "创建时间")
    @field:AutoColumns(
        AutoColumn(type = DATE, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = DATETIME, dialect = DatabaseDialect.MySQL),
        AutoColumn(type = TIMESTAMP),
    )
    open var createTime: LocalDateTime? = null,
    /** 创建人ID */
    @field:Column(value = "created_by", comment = "创建人ID")
    @field:AutoColumns(
        AutoColumn(type = NUMBER, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = BIGINT, dialect = DatabaseDialect.MySQL),
        AutoColumn(type = INT8),
    )
    open var createdBy: Long? = null,
) : Serializable {
    companion object {
        const val FIELD_ID = "id"
        const val CREATE_TIME = "createTime"
        const val CREATE_TIME_COLUMN = "create_time"
        const val CREATED_BY = "createdBy"
        const val CREATED_BY_COLUMN = "created_by"
    }
}
