package com.zetaframework.base.controller.curd

import com.mybatisflex.core.paginate.Page
import com.mybatisflex.core.query.QueryWrapper
import com.zetaframework.base.controller.BaseController
import com.zetaframework.base.param.PageParam
import com.zetaframework.utils.MapstructUtils

/**
 * 分页 Controller
 *
 * @param <BaseEntity>     实体
 * @param <QueryParam>  查询参数
 * @author gcc
 */
interface PageController<Entity, QueryParam> : BaseController<Entity> {
    /**
     * 分页查询
     *
     * @param param 分页查询参数
     * @return PageResult<BaseEntity>
     */
    fun query(param: PageParam<QueryParam>): Page<Entity> {
        // 处理查询参数
        handlerQueryParams(param)

        // 构建分页对象
        val page = param.build<Entity>()
        // PageQuery -> BaseEntity

        val model: Entity? = MapstructUtils.convert(param.model, getEntityClass())

        // 构造分页查询条件
        val wrapper = handlerWrapper(model, param)
        // 执行单表分页查询
        getBaseService().page(page, wrapper)

        // 处理查询后的分页结果
        handlerResult(page)

        return page
    }

    /**
     * 构造查询条件
     *
     * @param model 实体
     * @param param PageParam<PageQuery>
     * @return QueryWrapper<BaseEntity>
     */
    fun handlerWrapper(
        model: Entity?,
        param: PageParam<QueryParam>,
    ): QueryWrapper {
        // ?.let 不为空执行
        return model?.let { QueryWrapper.create(model) } ?: QueryWrapper.create()
    }

    /**
     * 处理查询参数
     *
     * @param param 分页查询参数
     */
    fun handlerQueryParams(param: PageParam<QueryParam>) {}

    /**
     * 处理查询后的数据
     *
     * @param page 分页对象
     */
    fun handlerResult(page: Page<Entity>) {}
}
