package com.zetaframework.exception

import com.zetaframework.enums.ErrorCodeEnum

/**
 * 自定义异常 - 参数异常
 *
 * @author gcc
 */
class ArgumentException : RuntimeException {
    /** 错误码 */
    var code: Int? = null

    /** 无参构造方法 */
    constructor() : this(com.zetaframework.enums.ErrorCodeEnum.ERR_ARGUMENT.msg)

    /**
     * 构造方法
     *
     * @param message 异常信息
     */
    constructor(message: String) : this(com.zetaframework.enums.ErrorCodeEnum.ERR_ARGUMENT.code, message)

    /**
     * 构造方法
     *
     * @param code 错误码
     * @param message 异常信息
     */
    constructor(code: Int, message: String) : super(message) {
        this.code = code
    }

    /**
     * 构造方法
     *
     * @param message 异常信息
     * @param cause 异常
     */
    constructor(message: String, cause: Throwable) : this(com.zetaframework.enums.ErrorCodeEnum.ERR_ARGUMENT.code, message, cause)

    /**
     * 构造方法
     *
     * @param code 错误码
     * @param message 异常信息
     * @param cause 异常
     */
    constructor(code: Int, message: String, cause: Throwable) : super(message, cause) {
        this.code = code
    }
}
