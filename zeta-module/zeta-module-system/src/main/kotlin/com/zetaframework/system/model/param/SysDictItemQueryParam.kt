package com.zetaframework.system.model.param

import java.time.LocalDateTime

/**
 * 字典项 查询参数
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:38:20
 */

data class SysDictItemQueryParam(
    /** id */

    var id: Long? = null,
    /** 创建时间 */

    var createTime: LocalDateTime? = null,
    /** 创建人 */

    var createdBy: Long? = null,
    /** 修改时间 */

    var updateTime: LocalDateTime? = null,
    /** 修改人 */

    var updatedBy: Long? = null,
    /** 字典id */

    var dictId: Long? = null,
    /** 字典项 */

    var name: String? = null,
    /** 值 */

    var value: String? = null,
    /** 描述 */

    var describe: String? = null,
    /** 排序 */

    var sortValue: Int? = null,
)
