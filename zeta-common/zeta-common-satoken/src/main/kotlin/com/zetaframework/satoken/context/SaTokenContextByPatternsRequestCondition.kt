package com.zetaframework.satoken.context

import cn.dev33.satoken.`fun`.strategy.SaRouteMatchFunction
import cn.dev33.satoken.spring.pathmatch.SaPatternsRequestConditionHolder
import cn.dev33.satoken.strategy.SaStrategy
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

/**
 *
 * 说明：
 * 解决`No more pattern data allowed after {*...} or ** pattern element`问题
 *
 * @author gcc
 */
@Primary
@Component
class SaTokenContextByPatternsRequestCondition {
    init {
        // 解决 No more pattern data allowed after {*...} or ** pattern element
        SaStrategy.instance.routeMatcher =
            SaRouteMatchFunction { pattern: String?, path: String? ->
                SaPatternsRequestConditionHolder.match(pattern, path)
            }
    }
}
