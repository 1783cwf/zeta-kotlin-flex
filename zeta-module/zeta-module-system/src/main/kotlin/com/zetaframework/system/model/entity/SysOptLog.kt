package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.log.model.LogDTO
import com.zetaframework.mybatisflex.constant.DBTypeConstant.INT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.TEXT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.LogBaseEntity
import io.github.linpeilie.annotations.AutoMapper
import jakarta.validation.constraints.NotBlank
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoColumns
import org.dromara.autotable.annotation.mysql.MysqlTypeConstant.LONGTEXT
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.CLOB
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.NUMBER
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.VARCHAR2
import org.dromara.autotable.core.constants.DatabaseDialect

/**
 * 操作日志
 *
 * @author gcc
 * @date 2022-03-18 15:27:15
 */
@Table(value = "sys_opt_log", comment = "操作日志")
@AutoMapper(target = LogDTO::class)
class SysOptLog : LogBaseEntity<Long>() {
    /** 操作类型 */
    @field:Column(value = "type", comment = "操作类型")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 10, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 10),
    )
    var type: String? = null

    /** 操作描述 */
    @field:Column(value = "description", comment = "操作描述")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var description: String? = null

    /** 请求地址 */
    @get:NotBlank(message = "请求地址不能为空")
    @field:Column(value = "url", comment = "请求地址")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var url: String? = null

    /** 请求方式 */
    @get:NotBlank(message = "请求方式不能为空")
    @field:Column(value = "http_method", comment = "请求方式")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 10, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 10),
    )
    var httpMethod: String? = null

    /** 类路径 */
    @get:NotBlank(message = "类路径不能为空")
    @field:Column(value = "class_path", comment = "类路径")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    var classPath: String? = null

    /** 请求参数 */
    @field:Column(value = "params", comment = "请求参数")
    @field:AutoColumns(
        AutoColumn(type = CLOB, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = LONGTEXT, dialect = DatabaseDialect.MySQL),
        AutoColumn(type = TEXT),
    )
    var params: String? = null

    /** 返回值 */
    @field:Column(value = "result", comment = "返回值")
    @field:AutoColumns(
        AutoColumn(type = CLOB, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = LONGTEXT, dialect = DatabaseDialect.MySQL),
        AutoColumn(type = TEXT),
    )
    var result: String? = null

    /** 异常描述 */
    @field:Column(value = "exception", comment = "异常描述")
    @field:AutoColumns(
        AutoColumn(type = CLOB, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = LONGTEXT, dialect = DatabaseDialect.MySQL),
        AutoColumn(type = TEXT),
    )
    var exception: String? = null

    /** 消耗时间 单位毫秒 */
    @get:NotBlank(message = "消耗时间不能为空")
    @field:Column(value = "spend_time", comment = "消耗时间 单位毫秒")
    @field:AutoColumns(
        AutoColumn(type = NUMBER, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = INT),
    )
    var spendTime: Int? = null

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

    /** 操作人 */
    @field:Column(value = "user_name", comment = "操作人")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 50, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 50),
    )
    var userName: String? = null

    override fun toString(): String =
        "SysOptLog(id=$id, createTime=$createTime, createdBy=$createdBy, type=$type, description=$description, url=$url, httpMethod=$httpMethod, classPath=$classPath, params=$params, result=$result, exception=$exception, spendTime=$spendTime, os=$os, device=$device, browser=$browser, ip=$ip, ipRegion=$ipRegion)"
}
