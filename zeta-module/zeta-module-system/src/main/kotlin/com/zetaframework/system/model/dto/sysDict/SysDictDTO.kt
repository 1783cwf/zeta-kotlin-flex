package com.zetaframework.system.model.dto.sysDict

import java.time.LocalDateTime

/**
 * 字典 详情
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:38:20
 */
data class SysDictDTO(
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
    /** 名称 */
    var name: String? = null,
    /** 编码 */
    var code: String? = null,
    /** 描述 */
    var describe: String? = null,
    /** 排序 */
    var sortValue: Int? = null,
)
