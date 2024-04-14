package com.zetaframework.monitor.controller

import com.aizuda.monitor.OshiMonitor
import com.zetaframework.base.controller.SuperBaseController
import com.zetaframework.log.annotation.SysLog
import com.zetaframework.model.result.ApiResult
import com.zetaframework.monitor.model.ServerInfoDTO
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Properties

/**
 * 系统监控
 *
 * @author gcc
 */
@RestController
@RequestMapping("/api/monitor")
class MonitorController(
    private val oshiMonitor: OshiMonitor,
    private val redisTemplate: StringRedisTemplate,
) : SuperBaseController {
    /**
     * 获取服务器信息
     *
     * @return ApiResult<Boolean>
     */
    @SysLog
    @GetMapping("/server")
    fun getServerInfo(): ApiResult<ServerInfoDTO> {
        return success(
            ServerInfoDTO().apply {
                // 系统信息
                this.sysInfo = ServerInfoDTO.SysInfo.build(oshiMonitor.sysInfo)
                // CPU使用率信息
                this.cpuInfo = ServerInfoDTO.CpuInfo.build(oshiMonitor.cpuInfo)
                // 内存信息
                this.memoryInfo = ServerInfoDTO.MemoryInfo.build(oshiMonitor.memoryInfo)
                // Jvm 虚拟机信息
                this.jvmInfo = ServerInfoDTO.JvmInfo.build(oshiMonitor.jvmInfo)
                // CPU信息
                this.centralProcessor =
                    ServerInfoDTO.CentralProcessor.build(
                        oshiMonitor.centralProcessor.processorIdentifier,
                    )
                // 磁盘信息
                this.diskInfos = ServerInfoDTO.DiskInfo.build(oshiMonitor.diskInfos)
            },
        )
    }

    /**
     * 获取Redis信息
     *
     * @return ApiResult<Boolean>
     */
    @SysLog
    @GetMapping("/redis")
    fun getRedisInfo(): ApiResult<Properties?> {
        val properties: Properties? = redisTemplate.connectionFactory?.connection?.info()
        return success(data = properties)
    }
}
