package com.zetaframework.base.controller.curd

import com.zetaframework.base.controller.BaseController
import com.zetaframework.log.annotation.SysLog
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreCheckPermission
import com.zetaframework.satoken.annotation.PreMode
import com.zetaframework.utils.MapstructUtils
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

/**
 * 基础新增 Controller
 *
 * @param <BaseEntity> 实体
 * @param <SaveDTO> 保存对象
 * @author gcc
 */
interface SaveController<Entity, SaveDTO> : BaseController<Entity> {
    /**
     * 新增
     *
     * @param saveDTO 保存对象
     * @return ApiResult<Boolean>
     */
    @PreCheckPermission(value = ["{}:add", "{}:save"], mode = PreMode.OR)
    @SysLog
    @PostMapping
    fun save(
        @RequestBody @Validated saveDTO: SaveDTO,
    ): ApiResult<Boolean> {
        val result = handlerSave(saveDTO)
        if (result.defExec) {
            // SaveDTO -> BaseEntity
            val entity = MapstructUtils.convert(saveDTO, getEntityClass())
            result.setData(getBaseService().save(entity))
        }
        return result
    }

    /**
     * 自定义新增
     *
     * @param saveDTO 保存对象
     * @return ApiResult<Boolean>
     */
    fun handlerSave(saveDTO: SaveDTO): ApiResult<Boolean> {
        return ApiResult.successDef()
    }
}
