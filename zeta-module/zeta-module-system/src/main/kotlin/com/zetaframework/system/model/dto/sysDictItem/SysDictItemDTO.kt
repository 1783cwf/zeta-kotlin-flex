package com.zetaframework.system.model.dto.sysDictItem

/**
 * 字典项 详情
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:38:20
 */

data class SysDictItemDTO(
    /** id */

    var id: Long? = null,
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
    /** 字典code */

    var dictCode: String? = null,
)
