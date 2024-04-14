package com.zetaframework.mybatisflex.listener

import cn.hutool.core.date.LocalDateTimeUtil
import cn.hutool.core.util.ObjectUtil
import com.mybatisflex.annotation.InsertListener
import com.zetaframework.exception.BusinessException
import com.zetaframework.mybatisflex.entity.BaseEntity
import com.zetaframework.satoken.utils.LoginHelper

/**
 * @author caoweifeng
 * @date 2024年01月30日 08:24
 * @email weistuday@gmail.com
 * @description: Entity实体类全局插入数据监听器
 */
class EntityInsertListener : InsertListener {
    /**
     * 新增操作的前置操作。
     *
     * @param entity 实体类
     */
    override fun onInsert(entity: Any?) {
        try {
            if (entity is BaseEntity<*> && ObjectUtil.isNotNull(entity)) {
                val loginUserId = LoginHelper.getUserId()
                val nowDate = LocalDateTimeUtil.now()

                entity.createdBy = loginUserId
                entity.createTime = nowDate
                entity.updatedBy = loginUserId
                entity.updateTime = nowDate
            }
        } catch (e: Exception) {
            throw com.zetaframework.exception.BusinessException("全局插入数据监听器注入异常 =》entity [$entity]", e)
        }
    }
}
