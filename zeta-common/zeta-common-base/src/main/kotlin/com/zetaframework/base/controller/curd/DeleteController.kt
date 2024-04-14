package com.zetaframework.base.controller.curd

import com.zetaframework.base.controller.BaseController
import com.zetaframework.log.annotation.SysLog
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreCheckPermission
import com.zetaframework.satoken.annotation.PreMode
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

/**
 * 基础删除 Controller
 *
 * @param <BaseEntity> 实体
 * @param <Id>     主键字段类型
 * @author gcc
 */
interface DeleteController<Entity> : BaseController<Entity> {
    /**
     * 单体删除
     *
     * @param id Id
     * @return ApiResult<Boolean>
     */
    @PreCheckPermission(value = ["{}:delete", "{}:remove"], mode = PreMode.OR)
    @SysLog
    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: Long,
    ): ApiResult<Boolean> {
        val result = handlerDelete(id)
        if (result.defExec) {
            result.setData(getBaseService().removeById(id))
        }
        return result
    }

    /**
     * 自定义单体删除
     *
     * @param id 主键
     * @return ApiResult<Boolean>
     */
    fun handlerDelete(id: Long): ApiResult<Boolean> {
        return ApiResult.successDef()
    }

    /**
     * 批量删除
     *
     * @param ids List<Id>
     * @return ApiResult<Boolean>
     */
    @PreCheckPermission(value = ["{}:delete", "{}:remove"], mode = PreMode.OR)
    @SysLog
    @DeleteMapping("/batch")
    fun batchDelete(
        @RequestBody ids: MutableList<Long>,
    ): ApiResult<Boolean> {
        val result = handlerBatchDelete(ids)
        if (result.defExec) {
            result.setData(getBaseService().removeByIds(ids))
        }
        return result
    }

    /**
     * 自定义批量删除
     *
     * @param ids List<Id>
     * @return ApiResult<Boolean>
     */
    fun handlerBatchDelete(ids: MutableList<Long>): ApiResult<Boolean> {
        return ApiResult.successDef()
    }
}
