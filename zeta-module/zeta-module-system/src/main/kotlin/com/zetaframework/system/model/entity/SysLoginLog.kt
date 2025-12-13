package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.log.model.LoginLogDTO
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.LogBaseEntity
import io.github.linpeilie.annotations.AutoMapper
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoColumns
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.VARCHAR2
import org.dromara.autotable.core.constants.DatabaseDialect

/**
 * 登录日志
 *
 * @author AutoGenerator
 * @date 2022-03-21 16:33:13
 */
@Table(value = "sys_login_log", comment = "登录日志")
@AutoMapper(target = LoginLogDTO::class)
class SysLoginLog : LogBaseEntity<Long>() {
    /** 状态 */
    @get:NotBlank(message = "状态不能为空")
    @get:Size(max = 10, message = "状态长度不能超过10")
    @field:Column(value = "state", comment = "状态")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 10, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 10),
    )
    var state: String? = null

    /** 账号 */
    @get:NotBlank(message = "账号不能为空")
    @get:Size(max = 64, message = "账号长度不能超过64")
    @field:Column(value = "account", comment = "账号")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 64, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 64),
    )
    var account: String? = null

    /** 备注 */
    @field:Column(value = "comments", comment = "备注")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var comments: String? = null

    /** 操作系统 */
    @field:Column(value = "os", comment = "操作系统")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 50, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 50),
    )
    var os: String? = null

    /** 设备名称 */
    @field:Column(value = "device", comment = "设备名称")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 50, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 50),
    )
    var device: String? = null

    /** 浏览器类型 */
    @field:Column(value = "browser", comment = "浏览器类型")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 50, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 50),
    )
    var browser: String? = null

    /** ip地址 */
    @field:Column(value = "ip", comment = "ip地址")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 50, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 50),
    )
    var ip: String? = null

    /** ip所在地区 */
    @field:Column(value = "ip_region", comment = "ip所在地区")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var ipRegion: String? = null

    override fun toString(): String =
        "SysLoginLog(id=$id, createTime=$createTime, createdBy=$createdBy, state=$state, account=$account, comments=$comments, os=$os, device=$device, browser=$browser, ip=$ip, ipRegion=$ipRegion)"
}
