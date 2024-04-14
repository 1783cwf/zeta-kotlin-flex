package com.zetaframework.system.controller

import com.mybatisflex.core.paginate.Page
import com.zetaframework.base.controller.SuperSimpleController
import com.zetaframework.base.param.PageParam
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreAuth
import com.zetaframework.satoken.annotation.PreCheckPermission
import com.zetaframework.system.model.dto.sysOptLog.SysOptLogTableDTO
import com.zetaframework.system.model.entity.SysOptLog
import com.zetaframework.system.model.param.SysOptLogQueryParam
import com.zetaframework.system.service.ISysOptLogService
import com.zetaframework.system.service.ISysUserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 操作日志 前端控制器
 *
 * @author gcc
 * @date 2022-03-18 15:27:15
 */
@PreAuth(replace = "sys:optLog")
@RestController
@RequestMapping("/api/system/optLog")
class SysOptLogController(
    private val userService: ISysUserService,
) : SuperSimpleController<ISysOptLogService, SysOptLog>() {
    /**
     * 分页查询
     * @param param PageParam<QueryParam> 分页查询参数
     * @return ApiResult<PageResult<BaseEntity>>
     */
    @PreCheckPermission(value = ["{}:view"])
    @PostMapping("/page")
    fun page(
        @RequestBody param: PageParam<SysOptLogQueryParam>,
    ): ApiResult<Page<SysOptLogTableDTO>> {
        return success(service.pageTable(param))
    }

    /**
     * 单体查询
     * @param id 主键
     * @return ApiResult<BaseEntity?>
     */
    @PreCheckPermission(value = ["{}:view"])
    @GetMapping("/{id}")
    fun get(
        @PathVariable("id") id: Long,
    ): ApiResult<SysOptLog?> {
        val entity = service.getById(id) ?: return success(null)

        // 查询操作人
        val user = userService.getById(entity.createdBy)
        entity.userName = user?.username
        return success(entity)
    }
}
