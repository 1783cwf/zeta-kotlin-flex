package com.zetaframework.base.param

import com.mybatisflex.core.paginate.Page
import jakarta.validation.Valid

/**
 * 分页查询参数
 *
 * @author gcc
 */

class PageParam<T> private constructor() {
    /**
     * 每页数据数量。
     */
    private var pageSize: Long = 10

    /**
     * 当前页码。
     */
    private var pageNumber: Long = 1

    /** 查询条件 */
    @Valid // 见[docs/03功能介绍/参数校验.md]常见问题
    var model: T? = null

    /**
     * 排序列
     * 允许的列名： "id","createTime","updateTime"
     */
    private var orderByColumn: String? = null

    /**
     * 排序的方向desc或者asc
     *
     * <p>排序规则：
     * <ul>
     *     <li>{@code null} 不排序
     *     <li>{@code true} 升序
     *     <li>{@code false} 降序
     * </ul>
     */
    private var isAsc: Boolean? = null

    constructor(pageNumber: Long, pageSize: Long) : this() {
        this.pageNumber = pageNumber
        this.pageSize = pageSize
    }

    constructor(pageNumber: Long, pageSize: Long, model: T? = null) : this(pageNumber, pageSize) {
        this.model = model
    }

    /**
     * 构造分页查询参数
     * @return
     * @param <T>
     </T> */
    fun <T> build(): Page<T> {
        return Page<T>(this.pageNumber, this.pageSize)
    }

    companion object {
        /**
         * 当前记录起始索引
         */
        val PAGE_NUM = "pageNum"

        /**
         * 每页显示记录数
         */
        val PAGE_SIZE = "pageSize"
    }
}
