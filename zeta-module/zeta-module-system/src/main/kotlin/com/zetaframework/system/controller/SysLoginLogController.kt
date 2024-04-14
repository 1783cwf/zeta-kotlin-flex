package com.zetaframework.system.controller

import com.zetaframework.base.controller.SuperSimpleController
import com.zetaframework.base.controller.curd.QueryController
import com.zetaframework.satoken.annotation.PreAuth
import com.zetaframework.system.model.entity.SysLoginLog
import com.zetaframework.system.model.param.SysLoginLogQueryParam
import com.zetaframework.system.service.ISysLoginLogService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 登录日志 前端控制器
 *
 * @author AutoGenerator
 * @date 2022-03-21 16:33:13
 */
@PreAuth(replace = "sys:loginLog")
@RestController
@RequestMapping("/api/system/loginLog")
class SysLoginLogController :
    SuperSimpleController<ISysLoginLogService, SysLoginLog>(),
    QueryController<SysLoginLog, SysLoginLogQueryParam>
