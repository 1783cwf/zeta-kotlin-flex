package com.zetaframework.base.controller.curd

import com.mybatisflex.core.paginate.Page
import com.mybatisflex.core.query.QueryWrapper
import com.zetaframework.base.param.PageParam
import com.zetaframework.log.annotation.SysLog
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreCheckPermission
import com.zetaframework.utils.MapstructUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

/**
 * 基础查询 Controller
 *
 * @param <Id>          主键字段类型
 * @param <BaseEntity>      实体
 * @param <QueryParam>   分页参数
 * @author gcc
 */
interface QueryController<Entity, QueryParam> : PageController<Entity, QueryParam> {
    /**
     * 分页查询
     *
     * @param param PageParam<QueryParam> 分页查询参数
     * @return ApiResult<PageResult<BaseEntity>>
     */
    @PreCheckPermission(value = ["{}:view"])
    @SysLog(response = false)
    @PostMapping("/page")
    fun page(
        @RequestBody param: PageParam<QueryParam>,
    ): ApiResult<Page<Entity>> {
        return success(super.query(param))
    }

    /**
     * 批量查询
     *
     * @param param 批量查询参数
     * @return ApiResult<List<BaseEntity>>
     */
    @PreCheckPermission(value = ["{}:view"])
    @SysLog(response = false)
    @PostMapping("/query")
    fun list(
        @RequestBody param: QueryParam,
    ): ApiResult<List<Entity>> {
        return success(handlerBatchQuery(param))
    }

    /**
     * 自定义批量查询
     *
     * @param param 批量查询参数
     * @return MutableList<BaseEntity>
     */
    fun handlerBatchQuery(param: QueryParam): MutableList<Entity> {
        val entity = MapstructUtils.convert(param, getEntityClass())
        // 批量查询
        val list = getBaseService().list(QueryWrapper.create(entity))
        // 处理批量查询数据
        handlerBatchData(list)
        return list
    }

    /**
     * 处理批量查询数据
     * @param list 实体列表
     */
    fun handlerBatchData(list: MutableList<Entity>) {}

    /**
     * 单体查询
     * @param id Id 主键
     * @return ApiResult<BaseEntity?>
     */
    @PreCheckPermission(value = ["{}:view"])
    @SysLog
    @GetMapping("/{id}")
    fun get(
        @PathVariable("id") id: Long,
    ): ApiResult<Entity?> {
        val entity = getBaseService().getById(id)
        // 处理单体查询数据
        handlerGetData(entity)
        return success(entity)
    }

    /**
     * 处理单体查询数据
     * @param entity 实体对象
     */
    fun handlerGetData(entity: Entity?) {}
}
