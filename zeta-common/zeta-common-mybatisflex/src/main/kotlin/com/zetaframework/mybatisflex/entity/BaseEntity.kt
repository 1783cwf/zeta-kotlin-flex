package com.zetaframework.mybatisflex.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Id
import com.mybatisflex.annotation.KeyType
import com.tangzc.autotable.annotation.PrimaryKey
import com.zetaframework.mybatisflex.annotation.ColumnDefine
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BIGINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.DATETIME
import com.zetaframework.mybatisflex.constant.DBTypeConstant.INT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.TINYINT
import com.zetaframework.validation.group.Update
import jakarta.validation.constraints.NotNull
import java.io.Serializable
import java.time.LocalDateTime

/**
 * 包括id、create_time、create_by、update_by、update_time、version、deleted字段的表继承的基础实体
 *
 * @author gcc
 * @date 2021/10/18 下午2:22
 * @since 1.0.0
 */

abstract class BaseEntity<T>(
    /** id */
    @get:NotNull(message = "id不能为空", groups = [Update::class])
    @Id(keyType = KeyType.Generator)
    @PrimaryKey(true)
    open var id: Long? = null,
    /** 创建时间 */
    @Column(value = "create_time")
    @ColumnDefine(type = DATETIME, comment = "创建时间")
    open var createTime: LocalDateTime? = null,
    /** 创建人ID */
    @Column(value = "created_by")
    @ColumnDefine(type = BIGINT, comment = "创建人ID")
    open var createdBy: Long? = null,
    /** 最后修改时间 */
    @Column(value = "update_time")
    @ColumnDefine(type = DATETIME, comment = "最后修改时间")
    open var updateTime: LocalDateTime? = null,
    /** 最后修改人ID */
    @Column(value = "updated_by")
    @ColumnDefine(type = BIGINT, comment = "最后修改人ID")
    open var updatedBy: Long? = null,
    /** 乐观锁 */
    @Column(value = "version", version = true)
    @ColumnDefine(type = INT, comment = "乐观锁", defaultValue = "0")
    open var version: Int? = null,
    /** 逻辑删除字段 false 未删除 true已删除*/
    @Column(value = "deleted", isLogicDelete = true)
    @ColumnDefine(type = TINYINT, comment = "逻辑删除字段", defaultValue = "0")
    open var deleted: Boolean? = null,
) : Serializable {
    companion object {
        const val FIELD_ID = "id"
        const val CREATE_TIME = "createTime"
        const val CREATE_TIME_COLUMN = "create_time"
        const val CREATED_BY = "createdBy"
        const val CREATED_BY_COLUMN = "created_by"
        const val UPDATE_TIME = "updateTime"
        const val UPDATE_TIME_COLUMN = "update_time"
        const val UPDATED_BY = "updatedBy"
        const val UPDATED_BY_COLUMN = "updated_by"
    }
}
