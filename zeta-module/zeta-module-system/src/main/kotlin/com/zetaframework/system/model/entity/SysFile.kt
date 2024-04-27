package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.tangzc.autotable.annotation.AutoTable
import com.zetaframework.file.model.FileInfo
import com.zetaframework.mybatisflex.annotation.ColumnDefine
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BIGINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.BaseEntity
import io.github.linpeilie.annotations.AutoMapper
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

/**
 * 系统文件
 *
 * @author AutoGenerator
 * @date 2022-04-12 16:47:45
 */
@Table(value = "sys_file")
@AutoMapper(target = FileInfo::class)
@AutoTable(value = "sys_file", comment = "系统文件")
class SysFile : BaseEntity<Long>() {
    /** 业务类型 */
    @Column(value = "biz_type")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "业务类型")
    var bizType: String? = null

    /** 桶 */
    @get:NotBlank(message = "桶不能为空")
    @get:Size(max = 255, message = "桶长度不能超过255")
    @Column(value = "bucket")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "桶")
    var bucket: String? = null

    /** 存储类型 */
    @get:NotBlank(message = "存储类型不能为空")
    @get:Size(max = 255, message = "存储类型长度不能超过255")
    @Column(value = "storage_type")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "存储类型")
    var storageType: String? = null

    /** 文件相对地址 */
    @get:NotBlank(message = "文件相对地址不能为空")
    @get:Size(max = 255, message = "文件相对地址长度不能超过255")
    @Column(value = "path")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "文件相对地址")
    var path: String? = null

    /** 文件访问地址 */
    @Column(value = "url")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "文件访问地址")
    var url: String? = null

    /** 唯一文件名 */
    @get:NotBlank(message = "唯一文件名不能为空")
    @get:Size(max = 255, message = "唯一文件名长度不能超过255")
    @Column(value = "unique_file_name")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "唯一文件名")
    var uniqueFileName: String? = null

    /** 原始文件名 */
    @Column(value = "original_file_name")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "原始文件名")
    var originalFileName: String? = null

    /** 文件类型 */
    @Column(value = "file_type")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "文件类型")
    var fileType: String? = null

    /** 内容类型 */
    @Column(value = "content_type")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "内容类型")
    var contentType: String? = null

    /** 后缀 */
    @Column(value = "suffix")
    @ColumnDefine(type = VARCHAR, length = 50, comment = "后缀")
    var suffix: String? = null

    /** 文件大小 */
    @Column(value = "size")
    @ColumnDefine(type = BIGINT, comment = "文件大小")
    var size: Long? = null

    override fun toString(): String {
        return "SysFile(id=$id, createTime=$createTime, createdBy=$createdBy, updateTime=$updateTime, updatedBy=$updatedBy, bizType=$bizType, bucket=$bucket, storageType=$storageType, path=$path, url=$url, uniqueFileName=$uniqueFileName, originalFileName=$originalFileName, fileType=$fileType, contentType=$contentType, suffix=$suffix, size=$size)"
    }
}
