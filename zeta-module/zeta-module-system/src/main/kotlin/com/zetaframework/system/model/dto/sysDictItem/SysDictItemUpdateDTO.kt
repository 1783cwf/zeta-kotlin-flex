package com.zetaframework.system.model.dto.sysDictItem

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

/**
 * 修改 字典项
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:38:20
 */

data class SysDictItemUpdateDTO(
    /** id */

    @get:NotNull(message = "id不能为空")
    var id: Long? = null,
    /** 字典id */

    @get:NotNull(message = "字典id不能为空")
    var dictId: Long? = null,
    /** 字典项 */

    @get:NotEmpty(message = "字典项不能为空")
    @get:Size(max = 32, message = "字典项长度不能超过32")
    var name: String? = null,
    /** 值 */

    @get:NotEmpty(message = "值不能为空")
    @get:Size(max = 32, message = "值长度不能超过32")
    var value: String? = null,
    /** 描述 */

    var describe: String? = null,
    /** 排序 */

    var sortValue: Int? = null,
)
