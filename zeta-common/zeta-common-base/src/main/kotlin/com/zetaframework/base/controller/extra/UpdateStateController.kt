package com.zetaframework.base.controller.extra

import com.zetaframework.base.controller.BaseController
import com.zetaframework.base.param.UpdateStateParam
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreCheckPermission
import com.zetaframework.satoken.annotation.PreMode
import com.zetaframework.utils.MapstructUtils
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import java.io.Serializable

/**
 * 修改状态 Controller
 *
 * @param <BaseEntity> 实体
 * @param <Id>     主键字段类型
 * @param <State>  state字段的类型
 * @author gcc
 */
interface UpdateStateController<Entity, State : Serializable> : BaseController<Entity> {
    /**
     * 修改状态
     *
     * @param param 修改状态参数
     * @return ApiResult<Boolean>
     */
    @PreCheckPermission(value = ["{}:edit", "{}:update"], mode = PreMode.OR)
    @PutMapping("/state")
    fun updateState(
        @RequestBody param: UpdateStateParam<Long, State>,
    ): ApiResult<Boolean> {
        val result = handlerUpdateState(param)
        if (result.defExec) {
            // updateDTO -> BaseEntity
            val entity = MapstructUtils.convert(param, getEntityClass())
            result.setData(getBaseService().updateById(entity))
        }
        return result
    }

    /**
     * 自定义修改状态
     *
     * @param param 修改状态参数
     * @return ApiResult<Boolean>
     */
    fun handlerUpdateState(param: UpdateStateParam<Long, State>): ApiResult<Boolean> {
        return ApiResult.successDef()
    }
}
