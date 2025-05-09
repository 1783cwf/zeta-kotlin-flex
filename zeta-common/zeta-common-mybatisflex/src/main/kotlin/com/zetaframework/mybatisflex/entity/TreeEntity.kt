package com.zetaframework.mybatisflex.entity

import com.zetaframework.model.entity.ITree
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BIGINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.INT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import jakarta.validation.constraints.NotEmpty
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.Ignore
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
    @AutoColumn(type = VARCHAR, length = 255, comment = "名称")
    open var label: String? = null,
    /** 父级Id */
    @AutoColumn(type = BIGINT, comment = "创建人ID")
    open var parentId: Long? = null,
    /** 排序 */
    @AutoColumn(type = INT, comment = "排序")
    open var sortValue: Int? = null,
    /** 子节点 */
    @Ignore
    open var children: MutableList<E>? = null,
) : BaseEntity<T>(),
    ITree<E, T> {
    /**
     * 获取树节点id
     */
    override fun getTreeId(): Long? = this.id

    /**
     * 获取树父节点id
     */
    override fun getTreeParentId(): Long? = this.parentId

    /**
     * 设置树子级
     */
    override fun setTreeChildren(children: MutableList<E>?) {
        this.children = children
    }
}
