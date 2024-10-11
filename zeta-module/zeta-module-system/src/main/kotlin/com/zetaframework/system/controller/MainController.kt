package com.zetaframework.system.controller

import cn.dev33.satoken.stp.StpUtil
import cn.hutool.core.date.SystemClock
import com.wf.captcha.SpecCaptcha
import com.zetaframework.base.controller.SuperSimpleController
import com.zetaframework.model.result.ApiResult
import com.zetaframework.redis.annotation.Limit
import com.zetaframework.system.model.entity.SysUser
import com.zetaframework.system.model.param.LoginParam
import com.zetaframework.system.model.result.CaptchaResult
import com.zetaframework.system.model.result.LoginResult
import com.zetaframework.system.service.ISysUserService
import com.zetaframework.system.service.getGranter
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 登录认证
 *
 * @author gcc
 */
@RestController
@RequestMapping("/api/system")
class MainController(
    private val captchaCacheKey: com.zetaframework.system.common.cacheKey.CaptchaStringCacheKey,
) : SuperSimpleController<ISysUserService, SysUser>() {
    @Value("\${spring.profiles.active:prod}")
    private val env: String? = null

    /**
     * 用户登录
     *
     * @param param 登录参数
     * @param request HttpServletRequest
     * @return ApiResult<[LoginResult]> 登录返回结果
     */
    @PostMapping("/login")
    fun login(
        @RequestBody @Validated param: LoginParam,
        request: HttpServletRequest,
    ): ApiResult<LoginResult> {
        // 验证验证码
        val verifyCode = captchaCacheKey.get<String>(param.key)
        if (verifyCode.isNullOrBlank()) {
            return fail("验证码过期")
        }
        if (!param.code.equals(verifyCode, true)) {
            return fail("验证码错误")
        }
        captchaCacheKey.delete(param.key)

        return success(getGranter(param.grantType).login(param))
    }

    /**
     * 注销登录
     *
     * @param request HttpServletRequest
     * @return ApiResult<Boolean>
     */
    @GetMapping("/logout")
    fun logout(request: HttpServletRequest): ApiResult<Boolean> {
        // 注销登录
        StpUtil.logout()
        return success(true)
    }

    /**
     * 图形验证码
     *
     * 说明：
     * 限流规则一分钟十次调用
     */
    @Limit(name = "验证码接口限流", count = 10, describe = "您的操作过于频繁，请稍后再试")
    @GetMapping("/captcha")
    fun captcha(): ApiResult<CaptchaResult> {
        val key = SystemClock.now()

        // 验证码值缓存到redis, 5分钟有效
        val specCaptcha = SpecCaptcha(120, 40, 5)
        captchaCacheKey.set(key, specCaptcha.text())

        // 如果生产环境，不返回验证码的值
        val text = if ("prod" === env) "" else specCaptcha.text()

        return success(CaptchaResult(key, specCaptcha.toBase64(), text))
    }
}
