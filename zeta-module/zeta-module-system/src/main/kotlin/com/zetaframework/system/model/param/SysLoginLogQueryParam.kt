package com.zetaframework.system.model.param

import java.time.LocalDateTime

/**
 * 登录日志 查询参数
 *
 * @author AutoGenerator
 * @date 2022-03-21 16:33:13
 */

data class SysLoginLogQueryParam(
    /** id */

    var id: Long? = null,
    /** 创建时间 */

    var createTime: LocalDateTime? = null,
    /** 创建人 */

    var createdBy: Long? = null,
    /** 状态 */

    var state: String? = null,
    /** 账号 */

    var account: String? = null,
    /** 备注 */

    var comments: String? = null,
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
