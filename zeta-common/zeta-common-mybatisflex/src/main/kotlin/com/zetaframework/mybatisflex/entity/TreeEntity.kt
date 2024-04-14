package com.zetaframework.mybatisflex.entity

import com.zetaframework.model.entity.ITree
import jakarta.validation.constraints.NotEmpty
import java.io.Serializable

/**
 * 树形表结构 实体类
 * 包括id、create_time、create_by、update_by、update_time、label、parent_id、sort_value 字段的表继承的树形实体
 *
 * @author gcc
 */
abstract class TreeEntity<E, T : Serializable>(
    /** 名称 */
    @get:NotEmpty(message = "名称不能为空")
    open var label: String? = null,
    /** 父级Id */
    open var parentId: Long? = null,
    /** 排序 */
    open var sortValue: Int? = null,
    /** 子节点 */
    open var children: MutableList<E>? = null,
) : BaseEntity<T>(), ITree<E, T> {
    /**
     * 获取树节点id
     */
    override fun getTreeId(): Long? {
        return this.id
    }

    /**
     * 获取树父节点id
     */
    override fun getTreeParentId(): Long? {
        return this.parentId
    }

    /**
     * 设置树子级
     */
    override fun setTreeChildren(children: MutableList<E>?) {
        this.children = children
    }
}
