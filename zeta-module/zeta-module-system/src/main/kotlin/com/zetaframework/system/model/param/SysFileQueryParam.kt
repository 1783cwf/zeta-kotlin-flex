package com.zetaframework.system.model.param

import com.zetaframework.system.model.entity.SysFile
import io.github.linpeilie.annotations.AutoMapper
import java.time.LocalDateTime

/**
 * 系统文件 查询参数
 *
 * @author AutoGenerator
 * @date 2022-04-11 11:18:44
 */
@AutoMapper(target = SysFile::class)
data class SysFileQueryParam(
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
    /** 业务类型 */

    var bizType: String? = null,
    /** 桶 */

    var bucket: String? = null,
    /** 存储类型 */

    var storageType: String? = null,
    /** 文件相对地址 */

    var path: String? = null,
    /** 文件访问地址 */

    var url: String? = null,
    /** 唯一文件名 */

    var uniqueFileName: String? = null,
    /** 原始文件名 */

    var originalFileName: String? = null,
    /** 文件类型 */

    var fileType: String? = null,
    /** 内容类型 */

    var contentType: String? = null,
    /** 后缀 */

    var suffix: String? = null,
    /** 文件大小 */

    var size: Long? = null,
)
