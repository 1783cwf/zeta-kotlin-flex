package com.zetaframework.system.service

import com.mybatisflex.core.paginate.Page
import com.mybatisflex.core.service.IService
import com.zetaframework.base.param.PageParam
import com.zetaframework.log.model.LogDTO
import com.zetaframework.system.model.dto.sysOptLog.SysOptLogTableDTO
import com.zetaframework.system.model.entity.SysOptLog
import com.zetaframework.system.model.param.SysOptLogQueryParam

/**
 * 操作日志 服务类
 *
 * @author gcc
 * @date 2022-03-18 15:27:15
 */
interface ISysOptLogService : IService<SysOptLog> {
    /**
     * 保存系统用户操作日志
     *
     * 说明：
     * [@SysLog]注解的业务实现
     *
     * @param logDTO 新增系统日志参数
     */
    fun save(logDTO: LogDTO)

    /**
     * 分页查询 （前端数据表格用）
     *
     * @param param 分页查询参数
     */
    fun pageTable(param: PageParam<SysOptLogQueryParam>): Page<SysOptLogTableDTO>
}
