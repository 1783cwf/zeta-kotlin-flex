package com.zetaframework.system.dao

import com.mybatisflex.core.BaseMapper
import com.zetaframework.system.model.entity.SysOptLog
import org.springframework.stereotype.Repository

/**
 * 操作日志 Mapper 接口
 *
 * @author gcc
 * @date 2022-03-18 15:27:15
 */
@Repository
interface SysOptLogMapper : BaseMapper<SysOptLog>
