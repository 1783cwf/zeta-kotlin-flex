package com.zetaframework.system.service.impl

import com.mybatisflex.core.paginate.Page
import com.mybatisflex.kotlin.extensions.db.paginate
import com.mybatisflex.kotlin.extensions.kproperty.eq
import com.mybatisflex.kotlin.extensions.kproperty.like
import com.mybatisflex.kotlin.extensions.kproperty.unaryMinus
import com.mybatisflex.kotlin.extensions.wrapper.and
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
            where {
                and(queryParam?.id != null) { SysOptLog::id.eq(queryParam?.id) }
                and(!queryParam?.type.isNullOrBlank()) { SysOptLog::type.eq(queryParam?.type) }
                and(!queryParam?.userName.isNullOrBlank()) { SysOptLog::userName.eq(queryParam?.userName) }
                and(!queryParam?.description.isNullOrBlank()) { SysOptLog::description.like(queryParam?.description!!) }
                and(!queryParam?.url.isNullOrBlank()) { SysOptLog::url.eq(queryParam?.url) }
                and(!queryParam?.httpMethod.isNullOrBlank()) { SysOptLog::httpMethod.eq(queryParam?.httpMethod) }
                and(!queryParam?.classPath.isNullOrBlank()) { SysOptLog::classPath.eq(queryParam?.classPath) }
                and(!queryParam?.os.isNullOrBlank()) { SysOptLog::os.like(queryParam?.os!!) }
                and(!queryParam?.device.isNullOrBlank()) { SysOptLog::device.like(queryParam?.device!!) }
                and(!queryParam?.browser.isNullOrBlank()) { SysOptLog::browser.like(queryParam?.browser!!) }
                and(!queryParam?.ip.isNullOrBlank()) { SysOptLog::ip.like(queryParam?.ip!!) }
                and(!queryParam?.ipRegion.isNullOrBlank()) { SysOptLog::ipRegion.like(queryParam?.ipRegion!!) }
            }
            orderBy(-SysOptLog::createTime)
        }
    }
}
