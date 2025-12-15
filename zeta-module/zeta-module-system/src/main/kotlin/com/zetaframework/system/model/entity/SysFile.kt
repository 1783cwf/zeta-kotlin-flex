package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.file.model.FileInfo
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BIGINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.BaseEntity
import io.github.linpeilie.annotations.AutoMapper
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoColumns
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.NUMBER
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.VARCHAR2
import org.dromara.autotable.annotation.pgsql.PgsqlTypeConstant.INT8
import org.dromara.autotable.core.constants.DatabaseDialect

/**
 * 系统文件
 *
 * @author AutoGenerator
 * @date 2022-04-12 16:47:45
 */
@Table(value = "sys_file", comment = "系统文件")
@AutoMapper(target = FileInfo::class)
class SysFile : BaseEntity() {
    /** 业务类型 */
    @field:Column(value = "biz_type", comment = "业务类型")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var bizType: String? = null

    /** 桶 */
    @get:NotBlank(message = "桶不能为空")
    @get:Size(max = 255, message = "桶长度不能超过255")
    @field:Column(value = "bucket", comment = "桶")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var bucket: String? = null

    /** 存储类型 */
    @get:NotBlank(message = "存储类型不能为空")
    @get:Size(max = 255, message = "存储类型长度不能超过255")
    @field:Column(value = "storage_type", comment = "存储类型")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var storageType: String? = null

    /** 文件相对地址 */
    @get:NotBlank(message = "文件相对地址不能为空")
    @get:Size(max = 255, message = "文件相对地址长度不能超过255")
    @field:Column(value = "path", comment = "文件相对地址")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var path: String? = null

    /** 文件访问地址 */
    @field:Column(value = "url", comment = "文件访问地址")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var url: String? = null

    /** 唯一文件名 */
    @get:NotBlank(message = "唯一文件名不能为空")
    @get:Size(max = 255, message = "唯一文件名长度不能超过255")
    @field:Column(value = "unique_file_name", comment = "唯一文件名")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var uniqueFileName: String? = null

    /** 原始文件名 */
    @field:Column(value = "original_file_name", comment = "原始文件名")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var originalFileName: String? = null

    /** 文件类型 */
    @field:Column(value = "file_type", comment = "文件类型")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var fileType: String? = null

    /** 内容类型 */
    @field:Column(value = "content_type", comment = "内容类型")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var contentType: String? = null

    /** 后缀 */
    @field:Column(value = "suffix", comment = "后缀")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 50, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 50),
    )
    var suffix: String? = null

    /** 文件大小 */
    @field:Column(value = "size", comment = "文件大小")
    @field:AutoColumns(
        AutoColumn(type = NUMBER, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = BIGINT, length = 20, dialect = DatabaseDialect.MySQL),
        AutoColumn(type = INT8),
    )
    var size: Long? = null

    override fun toString(): String =
        "SysFile(id=$id, createTime=$createTime, createdBy=$createdBy, updateTime=$updateTime, updatedBy=$updatedBy, bizType=$bizType, bucket=$bucket, storageType=$storageType, path=$path, url=$url, uniqueFileName=$uniqueFileName, originalFileName=$originalFileName, fileType=$fileType, contentType=$contentType, suffix=$suffix, size=$size)"
}
