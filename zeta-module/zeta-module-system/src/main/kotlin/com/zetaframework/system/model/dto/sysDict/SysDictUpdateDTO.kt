package com.zetaframework.system.model.dto.sysDict

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

/**
 * 修改 字典
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:38:20
 */

data class SysDictUpdateDTO(
    /** id */

    @get:NotNull(message = "id不能为空")
    var id: Long? = null,
    /** 名称 */

    @get:NotEmpty(message = "名称不能为空")
    @get:Size(max = 32, message = "名称长度不能超过32")
    var name: String? = null,
    /** 名称 */

    @get:NotEmpty(message = "编码不能为空")
    @get:Size(max = 32, message = "编码长度不能超过32")
    var code: String? = null,
    /** 描述 */

    var describe: String? = null,
    /** 排序 */

    var sortValue: Int? = null,
)
