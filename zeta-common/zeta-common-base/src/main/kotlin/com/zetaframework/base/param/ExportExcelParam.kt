package com.zetaframework.base.param

import jakarta.validation.constraints.NotBlank

/**
 * 导出Excel参数
 *
 * @author gcc
 */

class ExportExcelParam<QueryParam> {
    /** 查询条件 */

    var queryParam: QueryParam? = null

    /** excel文件名 */

    @get:NotBlank(message = "excel文件名不能为空")
    var fileName: String? = null

    /** 表格标题 */

    var title: String? = null

    /** sheet名称 */

    var sheetName: String? = null

    /** excel文件类型 */

    @get:NotBlank(message = "excel文件类型不能为空")
    var type: String? = null
}
