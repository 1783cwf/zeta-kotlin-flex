package com.zetaframework.system.model.param

/**
 * 操作日志 查询参数
 *
 * @author gcc
 * @date 2022-03-18 15:27:15
 */

data class SysOptLogQueryParam(
    /** id */

    var id: Long? = null,
    /** 操作类型 */

    var type: String? = null,
    /** 操作人 */

    var userName: String? = null,
    /** 操作描述 */

    var description: String? = null,
    /** 请求地址 */

    var url: String? = null,
    /** 请求方式 */

    var httpMethod: String? = null,
    /** 类路径 */

    var classPath: String? = null,
    /** 操作系统 */

    var os: String? = null,
    /** 设备名称 */

    var device: String? = null,
    /** 浏览器类型 */

    var browser: String? = null,
    /** ip地址 */

    var ip: String? = null,
    /** ip所在地区 */

    var ipRegion: String? = null,
)
