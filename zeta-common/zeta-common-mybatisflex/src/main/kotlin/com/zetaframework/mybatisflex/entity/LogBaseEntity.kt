package com.zetaframework.mybatisflex.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Id
import com.mybatisflex.annotation.KeyType
import com.zetaframework.validation.group.Update
import jakarta.validation.constraints.NotNull
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
    @Id(keyType = KeyType.Generator)
    open var id: Long? = null,
    /** 创建时间 */
    @Column(value = "create_time")
    open var createTime: LocalDateTime? = null,
    /** 创建人ID */
    @Column(value = "created_by")
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
