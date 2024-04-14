package com.zetaframework.log.aspect

import cn.hutool.core.date.SystemClock
import cn.hutool.core.exceptions.ExceptionUtil
import cn.hutool.core.util.StrUtil
import cn.hutool.http.useragent.UserAgentUtil
import com.zetaframework.jackson.util.JSONUtil
import com.zetaframework.log.annotation.SysLog
import com.zetaframework.log.enums.LogTypeEnum
import com.zetaframework.log.event.LogEvent
import com.zetaframework.log.model.LogDTO
import com.zetaframework.satoken.utils.LoginHelper
import com.zetaframework.utils.IpAddressUtil
import com.zetaframework.utils.ServletUtil
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.time.LocalDateTime
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import org.springframework.web.multipart.MultipartFile

/**
 * 系统日志 切面
 * 为了可以控制开启、关闭全局日志记录。改为Bean配置的方式
 * @author gcc
 */
@Aspect
class LogAspect(private val context: ApplicationContext) {
    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
        private val START_TIME: ThreadLocal<Long> = ThreadLocal()
        private const val MAX_LENGTH = 65535
    }

    @Pointcut("@annotation(com.zetaframework.log.annotation.SysLog)")
    fun logAspect() {}

    /**
     * 执行方法之前
     *
     * @param joinPoint JoinPoint
     */
    @Before(value = "logAspect()")
    fun doBefore(joinPoint: JoinPoint) {
        // 记录操作开始时间
        START_TIME.set(SystemClock.now())
    }

    /**
     * 执行方法之后
     *
     * @param joinPoint JoinPoint
     * @param result Any
     */
    @AfterReturning(pointcut = "logAspect()", returning = "result")
    fun doAfterReturning(
        joinPoint: JoinPoint,
        result: Any?,
    ) {
        publishEvent(joinPoint, result)
    }

    /**
     * 发生异常之后
     *
     * @param joinPoint JoinPoint
     * @param e Throwable
     */
    @AfterThrowing(pointcut = "logAspect()", throwing = "e")
    fun doAfterThrowing(
        joinPoint: JoinPoint,
        e: Throwable?,
    ) {
        publishEvent(joinPoint, exception = e)
    }

    /**
     * 发布日志存储事件
     *
     * @param joinPoint JoinPoint
     * @param result Any?
     * @param exception Throwable?
     */
    fun publishEvent(
        joinPoint: JoinPoint,
        result: Any? = null,
        exception: Throwable? = null,
    ) {
        // 方法耗时
        val spendTime = getSpendTime()
        // 获取注解
        val signature = joinPoint.signature as MethodSignature
        val method = signature.method
        var sysLog: SysLog? = null
        // 方法上的@SysLog注解
        if (method.isAnnotationPresent(SysLog::class.java)) {
            sysLog = method.getAnnotation(SysLog::class.java)
        }
        if (sysLog == null || !sysLog.enabled) {
            return
        }

        // 构造系统日志
        val logDTO = buildLogDTO(joinPoint, sysLog)
        logDTO.type = LogTypeEnum.OPERATION.name
        logDTO.spendTime = spendTime
        logDTO.result = getResponse(result, sysLog)
        logDTO.exception =
            getException(exception) {
                logDTO.type = LogTypeEnum.EXCEPTION.name
            }
        // 发布保存系统日志事件
        context.publishEvent(LogEvent(logDTO))
    }

    /**
     * 获取方法耗时
     */
    private fun getSpendTime(): Long {
        // 记录结束时间
        var spendTime = 0L
        if (START_TIME.get() != null) {
            spendTime = SystemClock.now() - START_TIME.get()
        }
        START_TIME.remove()
        return spendTime
    }

    /**
     * 构造系统日志
     *
     * @param joinPoint JoinPoint
     * @param sysLog SysLog
     * @return LogDTO
     */
    private fun buildLogDTO(
        joinPoint: JoinPoint,
        sysLog: SysLog,
    ): LogDTO {
        val logDTO = LogDTO()

        // 类路径
        logDTO.classPath = "${joinPoint.signature.declaringTypeName}.${joinPoint.signature.name}"

        // 操作描述
        logDTO.description = getDescription(joinPoint, sysLog)

        // 记录请求地址、请求方式、ip
        val attributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes?
        val request = attributes?.request
        if (request != null) {
            val ua = UserAgentUtil.parse(ServletUtil.getHeaderIgnoreCase(request, "User-Agent"))
            logDTO.url = request.requestURI
            logDTO.httpMethod = request.method
            logDTO.os = ua.platform.name
            logDTO.device = ua.os.name
            logDTO.browser = ua.browser.name
            logDTO.ip = ServletUtil.getClientIP(request)
            logDTO.createdBy = LoginHelper.getUserId()
            logDTO.createTime = LocalDateTime.now()
            logDTO.ip?.let { ip ->
                logDTO.ipRegion = IpAddressUtil.search(ip)
            }
            // 获取请求参数
            if (sysLog.request) {
                logDTO.params = getRequestParam(joinPoint, request)
            }
        }

        return logDTO
    }

    /**
     * 获取请求参数
     *
     * @param joinPoint JoinPoint
     * @param request HttpServletRequest
     * @return String?
     */
    private fun getRequestParam(
        joinPoint: JoinPoint,
        request: HttpServletRequest,
    ): String? {
        var params: String? = null

        val paramMap = ServletUtil.getParamMap(request)
        if (paramMap.isNotEmpty()) {
            params = JSONUtil.toJsonStr(paramMap)
        } else {
            if (joinPoint.args.isNotEmpty()) {
                val paramList = mutableListOf<Any>()
                joinPoint.args.forEach {
                    if (it !is HttpServletRequest &&
                        it !is HttpServletResponse &&
                        it !is MultipartFile
                    ) {
                        paramList.add(it)
                    }
                }
                if (paramList.isNotEmpty()) {
                    params = JSONUtil.toJsonStr(paramList)
                }
            }
        }
        return params
    }

    /**
     * 获取操作描述
     *
     * 格式：xxx-xxxx
     * "@Tag注解的name值"-"SysLog注解的value值 或 @Operation注解的summary值"
     * @return String?
     */
    private fun getDescription(
        joinPoint: JoinPoint,
        sysLog: SysLog,
    ): String {
        val sb = StringBuilder()

        // 获取@SysLog的value值
        if (StrUtil.isNotBlank(sysLog.value)) {
            sb.append(sysLog.value)
        } else {
            // 获取@Operation的summary值
            val signature = joinPoint.signature as MethodSignature
            val method = signature.method

            // @SysLog没有value值、没有@Operation注解的情况下。显示方法名
            sb.append(method.name)
        }
        return sb.toString()
    }

    /**
     * 获取返回值
     *
     * @param result Any?
     * @param sysLog OperationLog
     * @return String
     */
    private fun getResponse(
        result: Any?,
        sysLog: SysLog,
    ): String? =
        if (sysLog.response) {
            JSONUtil.toJsonStr(result)
        } else {
            ""
        }

    /**
     * 获取异常
     *
     * @param exception Throwable?
     * @param block Function0<Unit>
     * @return String?
     */
    private fun getException(
        exception: Throwable?,
        block: () -> Unit,
    ): String? =
        if (exception != null) {
            block.invoke()
            ExceptionUtil.stacktraceToString(exception, MAX_LENGTH)
        } else {
            ""
        }
}
