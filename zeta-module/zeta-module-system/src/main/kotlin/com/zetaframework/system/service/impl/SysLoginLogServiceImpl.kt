package com.zetaframework.system.service.impl

import com.mybatisflex.spring.service.impl.ServiceImpl
import com.zetaframework.log.model.LoginLogDTO
import com.zetaframework.system.dao.SysLoginLogMapper
import com.zetaframework.system.model.entity.SysLoginLog
import com.zetaframework.system.service.ISysLoginLogService
import com.zetaframework.utils.MapstructUtils
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 * 登录日志 服务实现类
 *
 * @author AutoGenerator
 * @date 2022-03-21 16:33:13
 */
@Service
class SysLoginLogServiceImpl : ISysLoginLogService, ServiceImpl<SysLoginLogMapper, SysLoginLog>() {
    private val logger = LoggerFactory.getLogger(this::class.java)

    /**
     * 保存用户登录日志
     *
     * @param loginLogDTO 新增登录日志参数
     */
    override fun save(loginLogDTO: LoginLogDTO) {
        val loginLog = MapstructUtils.convert(loginLogDTO, SysLoginLog::class.java)
        loginLog?.createdBy = loginLogDTO.userId
        save(loginLog)
    }
}
