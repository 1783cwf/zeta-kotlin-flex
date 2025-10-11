package com.zetaframework.base.controller

import com.zetaframework.model.result.ResultT

/**
 * 基础接口
 *
 * @author gcc
 */
interface SuperBaseController {
    /**
     * 返回成功
     *
     * @return ApiResult<T>
     */
    fun <T> success(): ResultT<T> = ResultT.success()

    /**
     * 返回成功
     *
     * @param message 状态信息
     * @return ApiResult<T>
     */
    fun <T> success(message: String): ResultT<T> = ResultT.success(message = message)

    /**
     * 返回成功
     *
     * @param data 返回数据
     * @return ApiResult<T>
     */
    fun <T> success(data: T): ResultT<T> = ResultT.success(data = data)

    /**
     * 返回成功
     *
     * @param message 状态信息
     * @param data 返回数据
     * @return ApiResult<T>
     */
    fun <T> success(
        message: String,
        data: T,
    ): ResultT<T> = ResultT.success(message = message, data = data)

    /**
     * 返回失败
     *
     * @return ApiResult<T>
     */
    fun <T> fail(): ResultT<T> = ResultT.fail()

    /**
     * 返回失败
     *
     * @param message 状态信息
     * @return ApiResult<T>
     */
    fun <T> fail(message: String): ResultT<T> = ResultT.fail(message = message)

    /**
     * 返回失败
     *
     * @param data 返回数据
     * @return ApiResult<T>
     */
    fun <T> fail(data: T): ResultT<T> = ResultT.fail(data = data)

    /**
     * 返回失败
     *
     * @param message 状态信息
     * @param data 返回数据
     * @return ApiResult<T>
     */
    fun <T> fail(
        message: String,
        data: T,
    ): ResultT<T> = ResultT.fail(message = message, data = data)
}
