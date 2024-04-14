package com.zetaframework.base.controller.curd

import com.zetaframework.base.controller.BaseController
import com.zetaframework.log.annotation.SysLog
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreCheckPermission
import com.zetaframework.satoken.annotation.PreMode
import com.zetaframework.utils.MapstructUtils
import com.zetaframework.validation.group.Update
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

/**
 * 基础修改 Controller
 *
 * @param <BaseEntity> 实体
 * @param <UpdateDTO> 修改对象
 * @author gcc
 */
interface UpdateController<Entity, UpdateDTO> : BaseController<Entity> {
    /**
     * 修改
     *
     * @param updateDTO 修改对象
     * @return ApiResult<Boolean>
     */
    @PreCheckPermission(value = ["{}:edit", "{}:update"], mode = PreMode.OR)
    @SysLog
    @PutMapping
    fun update(
        @RequestBody @Validated(Update::class) updateDTO: UpdateDTO,
    ): ApiResult<Boolean> {
        val result = handlerUpdate(updateDTO)
        if (result.defExec) {
            // updateDTO -> BaseEntity
            val entity = MapstructUtils.convert(updateDTO, getEntityClass())
            result.setData(getBaseService().updateById(entity))
        }
        return result
    }

    /**
     * 自定义修改
     *
     * @param updateDTO 修改对象
     * @return ApiResult<Boolean>
     */
    fun handlerUpdate(updateDTO: UpdateDTO): ApiResult<Boolean> {
        return ApiResult.successDef()
    }
}
