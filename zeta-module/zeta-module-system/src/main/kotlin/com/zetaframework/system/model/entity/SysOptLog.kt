package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Table
import com.zetaframework.log.model.LogDTO
import com.zetaframework.mybatisflex.constant.DBTypeConstant.INT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.LogBaseEntity
import io.github.linpeilie.annotations.AutoMapper
import jakarta.validation.constraints.NotBlank
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoTable
import org.dromara.autotable.annotation.mysql.MysqlTypeConstant.LONGTEXT

/**
 * 操作日志
 *
 * @author gcc
 * @date 2022-03-18 15:27:15
 */
@Table(value = "sys_opt_log")
@AutoMapper(target = LogDTO::class)
@AutoTable(value = "sys_opt_log", comment = "操作日志")
class SysOptLog : LogBaseEntity<Long>() {
    /** 操作类型 */
    @AutoColumn(value = "type", type = VARCHAR, length = 10, comment = "操作类型")
    var type: String? = null

    /** 操作描述 */
    @AutoColumn(value = "description", type = VARCHAR, length = 255, comment = "操作描述")
    var description: String? = null

    /** 请求地址 */
    @get:NotBlank(message = "请求地址不能为空")
    @AutoColumn(value = "url", type = VARCHAR, length = 255, comment = "请求地址")
    var url: String? = null

    /** 请求方式 */
    @get:NotBlank(message = "请求方式不能为空")
    @AutoColumn(value = "http_method", type = VARCHAR, length = 10, comment = "请求方式")
    var httpMethod: String? = null

    /** 类路径 */
    @get:NotBlank(message = "类路径不能为空")
    @AutoColumn(value = "class_path", type = VARCHAR, length = 255, comment = "类路径")
    var classPath: String? = null

    /** 请求参数 */
    @AutoColumn(value = "params", type = LONGTEXT, comment = "请求参数")
    var params: String? = null

    /** 返回值 */
    @AutoColumn(value = "result", type = LONGTEXT, comment = "返回值")
    var result: String? = null

    /** 异常描述 */
    @AutoColumn(value = "exception", type = LONGTEXT, comment = "异常描述")
    var exception: String? = null

    /** 消耗时间 单位毫秒 */
    @get:NotBlank(message = "消耗时间不能为空")
    @AutoColumn(value = "spend_time", type = INT, comment = "消耗时间 单位毫秒")
    var spendTime: Int? = null

    /** 操作系统 */
    @AutoColumn(value = "os", type = VARCHAR, length = 50, comment = "操作系统")
    var os: String? = null

    /** 设备名称 */
    @AutoColumn(value = "device", type = VARCHAR, length = 50, comment = "设备名称")
    var device: String? = null

    /** 浏览器类型 */
    @AutoColumn(value = "browser", type = VARCHAR, length = 50, comment = "浏览器类型")
    var browser: String? = null

    /** ip地址 */
    @AutoColumn(value = "ip", type = VARCHAR, length = 50, comment = "ip地址")
    var ip: String? = null

    /** ip所在地区 */
    @AutoColumn(value = "ip_region", type = VARCHAR, length = 255, comment = "ip所在地区")
    var ipRegion: String? = null

    /** 操作人 */
    @AutoColumn(value = "user_name", type = VARCHAR, length = 50, comment = "操作人")
    var userName: String? = null

    override fun toString(): String =
        "SysOptLog(id=$id, createTime=$createTime, createdBy=$createdBy, type=$type, description=$description, url=$url, httpMethod=$httpMethod, classPath=$classPath, params=$params, result=$result, exception=$exception, spendTime=$spendTime, os=$os, device=$device, browser=$browser, ip=$ip, ipRegion=$ipRegion)"
}
