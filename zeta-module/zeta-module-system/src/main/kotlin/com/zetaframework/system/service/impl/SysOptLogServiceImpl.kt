package com.zetaframework.system.service.impl

import com.mybatisflex.core.paginate.Page
import com.mybatisflex.kotlin.extensions.condition.allAnd
import com.mybatisflex.kotlin.extensions.db.paginate
import com.mybatisflex.kotlin.extensions.kproperty.eq
import com.mybatisflex.kotlin.extensions.kproperty.like
import com.mybatisflex.kotlin.extensions.kproperty.unaryMinus
import com.mybatisflex.spring.service.impl.ServiceImpl
import com.zetaframework.base.param.PageParam
import com.zetaframework.log.model.LogDTO
import com.zetaframework.system.dao.SysOptLogMapper
import com.zetaframework.system.model.dto.sysOptLog.SysOptLogTableDTO
import com.zetaframework.system.model.entity.SysOptLog
import com.zetaframework.system.model.entity.SysUser
import com.zetaframework.system.model.param.SysOptLogQueryParam
import com.zetaframework.system.service.ISysOptLogService
import com.zetaframework.utils.MapstructUtils
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

/**
 * 操作日志 服务实现类
 *
 * @author gcc
 * @date 2022-03-18 15:27:15
 */
@Service
class SysOptLogServiceImpl : ISysOptLogService, ServiceImpl<SysOptLogMapper, SysOptLog>() {
    private val logger = LoggerFactory.getLogger(this::class.java)

    /**
     * 是否把操作日志保存到数据库
     */
    @Value("\${zeta.log.isSave}")
    private val isSave: Boolean? = null

    /**
     * 保存系统用户操作日志
     *
     * 说明：
     * [@SysLog]注解的业务实现
     *
     * @param logDTO 新增系统日志参数
     */
    override fun save(logDTO: LogDTO) {
        val optLog = MapstructUtils.convert(logDTO, SysOptLog::class.java)

        if (isSave == true) {
            save(optLog)
        } else {
            logger.info(
                """

                ===============  Request Start  ================
                ===> ${optLog?.httpMethod}: ${optLog?.url} Parameters: ${optLog?.params}

                ===Result===  ${optLog?.result}
                <=== spendTime: (${optLog?.spendTime} ms)
                ===============  Request End    ================

                """.trimIndent(),
            )
        }
    }

    /**
     * 分页查询 （前端数据表格用）
     *
     * @param param 分页查询参数
     */
    override fun pageTable(param: PageParam<SysOptLogQueryParam>): Page<SysOptLogTableDTO> {
        val queryParam = param.model
        return paginate<SysOptLogTableDTO>(param.build()) {
            select(
                SysOptLog::id,
                SysOptLog::createTime,
                SysOptLog::createdBy,
                SysOptLog::type,
                SysUser::username,
                SysOptLog::description,
                SysOptLog::url,
                SysOptLog::httpMethod,
                SysOptLog::classPath,
                SysOptLog::browser,
            )
            from(SysOptLog::class.java)
            leftJoin(SysUser::class.java).on(SysOptLog::createdBy.eq(SysUser::id))
            allAnd(
                SysOptLog::id eq queryParam?.id,
                SysOptLog::type eq queryParam?.type,
                SysOptLog::userName eq queryParam?.userName,
                SysOptLog::url eq queryParam?.url,
                SysOptLog::description like queryParam?.description,
                SysOptLog::httpMethod eq queryParam?.httpMethod,
                SysOptLog::classPath eq queryParam?.classPath,
                SysOptLog::os like queryParam?.os,
                SysOptLog::device like queryParam?.device,
                SysOptLog::browser like queryParam?.browser,
                SysOptLog::ip like queryParam?.ip,
                SysOptLog::ipRegion like queryParam?.ipRegion,
            )

            orderBy(-SysOptLog::createTime)
        }
    }
}
