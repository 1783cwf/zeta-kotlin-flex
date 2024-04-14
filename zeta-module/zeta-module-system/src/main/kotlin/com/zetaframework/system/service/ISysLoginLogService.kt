package com.zetaframework.system.service

import com.mybatisflex.core.service.IService
import com.zetaframework.log.model.LoginLogDTO
import com.zetaframework.system.model.entity.SysLoginLog

/**
 * 登录日志 服务类
 *
 * @author AutoGenerator
 * @date 2022-03-21 16:33:13
 */
interface ISysLoginLogService : IService<SysLoginLog> {
    /**
     * 保存用户登录日志
     *
     * @param loginLogDTO 新增登录日志参数
     */
    fun save(loginLogDTO: LoginLogDTO)
}
