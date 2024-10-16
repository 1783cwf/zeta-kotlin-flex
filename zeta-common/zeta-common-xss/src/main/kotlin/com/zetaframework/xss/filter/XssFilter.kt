package com.zetaframework.xss.filter

import com.zetaframework.xss.cleaner.XssCleaner
import com.zetaframework.xss.properties.XssProperties
import com.zetaframework.xss.wrapper.XssRequestWrapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.filter.OncePerRequestFilter

/**
 * 自定义用于XSS防护的 过滤器
 *
 * @author gcc
 */
class XssFilter(
    private val xssCleaner: XssCleaner,
    private val xssProperties: XssProperties,
) : OncePerRequestFilter() {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    /**
     * 执行过滤
     *
     * @param request 请求
     * @param response 响应
     * @param filterChain 过滤器链
     */
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try {
            filterChain.doFilter(XssRequestWrapper(request, xssCleaner), response)
        } catch (e: Exception) {
            log.error("执行XSS过滤失败", e)
        }
    }

    /**
     * 如果返回true，则这个请求不会被过滤
     */
    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        // XSS防护开关是否关闭
        if (!xssProperties.enabled) {
            return true
        }

        // 当前url是否是忽略xss防护的地址
        return xssProperties.isIgnoreUrl(request.method, request.requestURI)
    }
}
