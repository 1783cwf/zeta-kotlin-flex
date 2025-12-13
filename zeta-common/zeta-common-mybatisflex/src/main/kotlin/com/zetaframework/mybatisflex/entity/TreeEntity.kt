package com.zetaframework.mybatisflex.entity

import com.mybatisflex.annotation.Column
import com.zetaframework.model.entity.ITree
import com.zetaframework.mybatisflex.constant.DBTypeConstant.BIGINT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.INT
import com.zetaframework.mybatisflex.constant.DBTypeConstant.VARCHAR
import jakarta.validation.constraints.NotEmpty
import java.io.Serializable
import org.dromara.autotable.annotation.AutoColumn
import org.dromara.autotable.annotation.AutoColumns
import org.dromara.autotable.annotation.Ignore
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.NUMBER
import org.dromara.autotable.annotation.oracle.OracleTypeConstant.VARCHAR2
import org.dromara.autotable.annotation.pgsql.PgsqlTypeConstant.INT8
import org.dromara.autotable.core.constants.DatabaseDialect

/**
 * 树形表结构 实体类
 * 包括id、create_time、create_by、update_by、update_time、label、parent_id、sort_value 字段的表继承的树形实体
 *
 * @author gcc
 */
abstract class TreeEntity<E, T : Serializable>(
    /** 名称 */
    @get:NotEmpty(message = "名称不能为空")
    @field:Column(value = "label", comment = "名称")
    @field:AutoColumns(
        AutoColumn(type = VARCHAR2, length = 255, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = VARCHAR, length = 255),
    )
    open var label: String? = null,
    /** 父级Id */
    @field:Column(value = "parent_id", comment = "父级ID")
    @field:AutoColumns(
        AutoColumn(type = NUMBER, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = BIGINT, dialect = DatabaseDialect.MySQL),
        AutoColumn(type = INT8),
    )
    open var parentId: Long? = null,
    /** 排序 */
    @field:Column(value = "sort_value", comment = "排序")
    @field:AutoColumns(
        AutoColumn(type = NUMBER, dialect = DatabaseDialect.Oracle),
        AutoColumn(type = INT),
    )
    open var sortValue: Int? = null,
    /** 子节点 */
    @Ignore
    open var children: MutableList<E>? = null,
) : BaseEntity(),
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
