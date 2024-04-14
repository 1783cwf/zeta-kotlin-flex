package com.zetaframework.base.controller

import com.mybatisflex.core.service.IService

/**
 * 基础接口
 *
 * @param <BaseEntity> 实体
 * @author gcc
 */
interface BaseController<Entity> : SuperBaseController {
    /**
     * 获取实体类型
     *
     * @return Class<BaseEntity>
     */
    fun getEntityClass(): Class<Entity>

    /**
     * 获取service
     */
    fun getBaseService(): IService<Entity>
}
