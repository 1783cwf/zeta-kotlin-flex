package com.zetaframework.utils

import cn.hutool.extra.spring.SpringUtil
import jakarta.validation.ConstraintViolationException
import jakarta.validation.Validator

/**
 * Validator 校验框架工具
 *
 * @author <a href="mailto:weistuday@gmail.com">caoweifeng</a>
 * @date 2024年03月16日 21:23
 */
object ValidatorUtils {
    private val VALID: Validator = SpringUtil.getBean(Validator::class.java)

    fun <T> validate(
        obj: T,
        vararg groups: Class<*>?,
    ) {
        val validate = VALID.validate(obj, *groups)
        if (validate.isNotEmpty()) {
            throw ConstraintViolationException("参数校验异常", validate)
        }
    }
}
