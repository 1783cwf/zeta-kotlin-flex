package com.zetaframework.satoken.properties

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * security忽略鉴权配置类
 * @author gcc
 */
@ConfigurationProperties(prefix = "zeta.security.ignore")
class IgnoreProperties {
    /** 基础忽略鉴权地址 */
    private var baseUrl: MutableList<String> =
        mutableListOf(
            "/**/*.html",
            "/**/*.css",
            "/**/*.js",
            "/**/*.ico",
            "/**/*.jpg",
            "/**/*.png",
            "/**/*.gif",
            "/error",
            "/api/system/login",
            "/api/system/captcha",
        )

    /** 忽略鉴权的地址 */
    private var ignoreUrl: MutableList<String> = mutableListOf("/**/noToken/**")

    /**
     * 获取saToken放行路由
     */
    fun getNotMatchUrl(): MutableList<String> {
        return mutableListOf<String>().apply {
            addAll(baseUrl)
            addAll(ignoreUrl)
        }
    }
}
