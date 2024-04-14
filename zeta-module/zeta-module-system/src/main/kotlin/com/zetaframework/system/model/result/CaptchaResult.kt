package com.zetaframework.system.model.result

import com.fasterxml.jackson.annotation.JsonInclude

/**
 * 验证码返回结果
 *
 * @author gcc
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CaptchaResult(
    /**
     * 验证码key。
     * 后台利用该key去redis中查询正确的验证码值
     */

    val key: Long? = null,
    /**
     * 验证码base64数据
     */

    val base64: String? = null,
    /**
     * 验证码文本 生产环境不会返回该值
     */

    val text: String? = null,
)
