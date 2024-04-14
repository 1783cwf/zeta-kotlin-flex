package com.zetaframework.mybatisflex.listener

import cn.hutool.core.date.LocalDateTimeUtil
import cn.hutool.core.util.ObjectUtil
import com.mybatisflex.annotation.UpdateListener
import com.zetaframework.exception.BusinessException
import com.zetaframework.mybatisflex.entity.BaseEntity
import com.zetaframework.satoken.utils.LoginHelper

/**
 * @author caoweifeng
 * @date 2024年01月30日 20:26
 * @email weistuday@gmail.com
 * @description:
 */
class EntityUpdateListener : UpdateListener {
    /**
     * 更新操作的前置操作。
     *
     * @param entity 实体类
     */
    override fun onUpdate(entity: Any?) {
        try {
            if (entity is BaseEntity<*> && ObjectUtil.isNotNull(entity)) {
                entity.updatedBy = LoginHelper.getUserId()
                entity.updateTime = LocalDateTimeUtil.now()
            }
        } catch (e: Exception) {
            throw com.zetaframework.exception.BusinessException("全局更新数据监听器注入异常 =》 entity [$entity]", e)
        }
    }
}
