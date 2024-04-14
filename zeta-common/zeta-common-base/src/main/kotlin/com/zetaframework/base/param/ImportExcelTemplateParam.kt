package com.zetaframework.base.param

import jakarta.validation.constraints.NotBlank

/**
 * 获取导入Excel模板 参数
 *
 * @author gcc
 */

class ImportExcelTemplateParam {
    /** excel模板文件名 */

    @get:NotBlank(message = "excel模板文件名不能为空")
    var fileName: String? = null

    /** 表格标题 */

    var title: String? = null

    /** sheet名称 */

    var sheetName: String? = null

    /** excel文件类型 */

    @get:NotBlank(message = "excel模板类型不能为空")
    var type: String? = null
}
