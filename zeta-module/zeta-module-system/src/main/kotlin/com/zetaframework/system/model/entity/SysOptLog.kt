package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.tangzc.autotable.annotation.AutoTable
import com.zetaframework.log.model.LogDTO
import com.zetaframework.mybatisflex.annotation.ColumnDefine
import com.zetaframework.mybatisflex.constant.DBTypeConstant.INT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.LONGTEXT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import com.zetaframework.mybatisflex.entity.LogBaseEntity
import io.github.linpeilie.annotations.AutoMapper
import jakarta.validation.constraints.NotBlank

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
    @Column(value = "type")
    @ColumnDefine(type = VARCHAR, length = 10, comment = "操作类型")
    var type: String? = null

    /** 操作描述 */
    @Column(value = "description")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "操作描述")
    var description: String? = null

    /** 请求地址 */
    @get:NotBlank(message = "请求地址不能为空")
    @Column(value = "url")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "请求地址")
    var url: String? = null

    /** 请求方式 */
    @get:NotBlank(message = "请求方式不能为空")
    @Column(value = "http_method")
    @ColumnDefine(type = VARCHAR, length = 10, comment = "请求方式")
    var httpMethod: String? = null

    /** 类路径 */
    @get:NotBlank(message = "类路径不能为空")
    @Column(value = "class_path")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "类路径")
    var classPath: String? = null

    /** 请求参数 */
    @Column(value = "params")
    @ColumnDefine(type = LONGTEXT, comment = "请求参数")
    var params: String? = null

    /** 返回值 */
    @Column(value = "result")
    @ColumnDefine(type = LONGTEXT, comment = "返回值")
    var result: String? = null

    /** 异常描述 */
    @Column(value = "exception")
    @ColumnDefine(type = LONGTEXT, comment = "异常描述")
    var exception: String? = null

    /** 消耗时间 单位毫秒 */
    @get:NotBlank(message = "消耗时间不能为空")
    @Column(value = "spend_time")
    @ColumnDefine(type = INT, comment = "消耗时间 单位毫秒")
    var spendTime: Int? = null

    /** 操作系统 */
    @Column(value = "os")
    @ColumnDefine(type = VARCHAR, length = 50, comment = "操作系统")
    var os: String? = null

    /** 设备名称 */
    @Column(value = "device")
    @ColumnDefine(type = VARCHAR, length = 50, comment = "设备名称")
    var device: String? = null

    /** 浏览器类型 */
    @Column(value = "browser")
    @ColumnDefine(type = VARCHAR, length = 50, comment = "浏览器类型")
    var browser: String? = null

    /** ip地址 */
    @Column(value = "ip")
    @ColumnDefine(type = VARCHAR, length = 50, comment = "ip地址")
    var ip: String? = null

    /** ip所在地区 */
    @Column(value = "ip_region")
    @ColumnDefine(type = VARCHAR, length = 255, comment = "ip所在地区")
    var ipRegion: String? = null

    /** 操作人 */
    @Column(value = "user_name", ignore = true)
    @ColumnDefine(type = VARCHAR, length = 50, comment = "操作人")
    var userName: String? = null

    override fun toString(): String {
        return "SysOptLog(id=$id, createTime=$createTime, createdBy=$createdBy, type=$type, description=$description, url=$url, httpMethod=$httpMethod, classPath=$classPath, params=$params, result=$result, exception=$exception, spendTime=$spendTime, os=$os, device=$device, browser=$browser, ip=$ip, ipRegion=$ipRegion)"
    }
}
