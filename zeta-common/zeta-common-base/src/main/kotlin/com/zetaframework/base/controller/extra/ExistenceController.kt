package com.zetaframework.base.controller.extra

import com.zetaframework.base.controller.BaseController
import com.zetaframework.base.param.ExistParam
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreCheckPermission
import org.springframework.web.bind.annotation.GetMapping

/**
 * 验证存在 Controller
 *
 * @param <BaseEntity> 实体
 * @param <Id>     主键字段类型
 * @author gcc
 */
interface ExistenceController<Entity> : BaseController<Entity> {
    /**
     * 验证字段是否存在
     *
     * @param param 验证参数
     * @return ApiResult<Boolean>
     */
    @PreCheckPermission(value = ["{}:view"])
    @GetMapping("/existence")
    fun existence(param: ExistParam<Entity, Long>): ApiResult<Boolean> {
        if (param.isExist(getBaseService())) {
            return success("${param.value}已存在", true)
        }
        return success("${param.value}不存在", false)
    }
}
