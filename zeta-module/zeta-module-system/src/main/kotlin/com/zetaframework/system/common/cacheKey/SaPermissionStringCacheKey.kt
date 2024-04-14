package com.zetaframework.system.common.cacheKey

import com.zetaframework.constants.RedisKeyConstants
import com.zetaframework.redis.model.StringCacheKey
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.time.Duration

/**
 * 用户权限 String类型的缓存key
 *
 * @author gcc
 */
@Component
class SaPermissionStringCacheKey(private val redisTemplate: RedisTemplate<String, Any>) : StringCacheKey {
    /**
     * key 前缀
     */
    override fun getPrefix(): String {
        return com.zetaframework.constants.RedisKeyConstants.USER_PERMISSION_KEY
    }

    /**
     * key 过期时间
     */
    override fun getExpire(): Duration? {
        return Duration.ofDays(1)
    }

    /**
     * 获取redisTemplate
     */
    override fun getRedisTemplate(): RedisTemplate<String, Any> {
        return redisTemplate
    }
}
