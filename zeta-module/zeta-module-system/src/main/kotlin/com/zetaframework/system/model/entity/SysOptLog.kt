package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.log.model.LogDTO
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
class SysOptLog : LogBaseEntity<Long>() {
    /** 操作类型 */
    @Column(value = "type")
    var type: String? = null

    /** 操作描述 */
    @Column(value = "description")
    var description: String? = null

    /** 请求地址 */
    @get:NotBlank(message = "请求地址不能为空")
    @Column(value = "url")
    var url: String? = null

    /** 请求方式 */
    @get:NotBlank(message = "请求方式不能为空")
    @Column(value = "http_method")
    var httpMethod: String? = null

    /** 类路径 */
    @get:NotBlank(message = "类路径不能为空")
    @Column(value = "class_path")
    var classPath: String? = null

    /** 请求参数 */
    @Column(value = "params")
    var params: String? = null

    /** 返回值 */
    @Column(value = "result")
    var result: String? = null

    /** 异常描述 */
    @Column(value = "exception")
    var exception: String? = null

    /** 消耗时间 单位毫秒 */
    @get:NotBlank(message = "消耗时间不能为空")
    @Column(value = "spend_time")
    var spendTime: Int? = null

    /** 操作系统 */
    @Column(value = "os")
    var os: String? = null

    /** 设备名称 */
    @Column(value = "device")
    var device: String? = null

    /** 浏览器类型 */
    @Column(value = "browser")
    var browser: String? = null

    /** ip地址 */
    @Column(value = "ip")
    var ip: String? = null

    /** ip所在地区 */
    @Column(value = "ip_region")
    var ipRegion: String? = null

    /** 操作人 */
    @Column(value = "user_name", ignore = true)
    var userName: String? = null

    override fun toString(): String {
        return "SysOptLog(id=$id, createTime=$createTime, createdBy=$createdBy, type=$type, description=$description, url=$url, httpMethod=$httpMethod, classPath=$classPath, params=$params, result=$result, exception=$exception, spendTime=$spendTime, os=$os, device=$device, browser=$browser, ip=$ip, ipRegion=$ipRegion)"
    }
}
