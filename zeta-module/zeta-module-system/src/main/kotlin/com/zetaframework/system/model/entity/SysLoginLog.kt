package com.zetaframework.system.model.entity

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table
import com.zetaframework.log.model.LoginLogDTO
import com.zetaframework.mybatisflex.entity.LogBaseEntity
import io.github.linpeilie.annotations.AutoMapper
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

/**
 * 登录日志
 *
 * @author AutoGenerator
 * @date 2022-03-21 16:33:13
 */
@Table(value = "sys_login_log")
@AutoMapper(target = LoginLogDTO::class)
class SysLoginLog : LogBaseEntity<Long>() {
    /** 状态 */
    @get:NotBlank(message = "状态不能为空")
    @get:Size(max = 10, message = "状态长度不能超过10")
    @Column(value = "state")
    var state: String? = null

    /** 账号 */
    @get:NotBlank(message = "账号不能为空")
    @get:Size(max = 64, message = "账号长度不能超过64")
    @Column(value = "account")
    var account: String? = null

    /** 备注 */
    @Column(value = "comments")
    var comments: String? = null

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

    override fun toString(): String {
        return "SysLoginLog(id=$id, createTime=$createTime, createdBy=$createdBy, state=$state, account=$account, comments=$comments, os=$os, device=$device, browser=$browser, ip=$ip, ipRegion=$ipRegion)"
    }
}
