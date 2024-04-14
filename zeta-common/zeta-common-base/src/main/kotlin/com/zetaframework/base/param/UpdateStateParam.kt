package com.zetaframework.base.param

/**
 * 修改状态参数
 *
 * @author gcc
 */

data class UpdateStateParam<T, U>(
    /** id */

    var id: T? = null,
    /** 状态 */

    var state: U? = null,
)
