package com.zetaframework.model.result

/**
 * 分页查询返回结果
 *
 * @author gcc
 */

class PageResult<T> private constructor() {
    /** 当前页数据 */

    var records: List<T>? = mutableListOf()

    /** 总数量 */
    var totalRow: Long? = null

    /** 总页数 */
    var totalPage: Long? = null
    var pageSize: Long? = null
    var pageNumber: Long? = null

    constructor(records: List<T>, totalRow: Long = 0) : this() {
        this.records = records
        this.totalRow = totalRow
    }
}
