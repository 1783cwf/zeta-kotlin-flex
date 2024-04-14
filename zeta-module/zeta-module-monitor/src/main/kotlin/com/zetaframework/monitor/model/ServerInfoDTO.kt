package com.zetaframework.monitor.model

import com.zetaframework.utils.MapstructUtils
import io.github.linpeilie.annotations.AutoMapper

/**
 * 服务器信息
 *
 * @author gcc
 */
class ServerInfoDTO {
    /** 系统信息 */
    var sysInfo: SysInfo? = null

    /** cpu信息 */
    var cpuInfo: CpuInfo? = null

    /** 内存信息 */
    var memoryInfo: MemoryInfo? = null

    /** Jvm 虚拟机信息 */
    var jvmInfo: JvmInfo? = null

    /** 中央处理器 */
    var centralProcessor: CentralProcessor? = null

    /** 磁盘信息 */
    var diskInfos: List<DiskInfo>? = null

    /**
     * 操作系统信息
     *
     * 说明：
     * 自定义返回哪些数据
     */
    @AutoMapper(target = com.aizuda.monitor.SysInfo::class)
    class SysInfo {
        /** 系统名称 */
        var name: String? = null

        /** ip地址 */
        var ip: String? = null

        /** 操作系统 */
        var osName: String? = null

        /** 系统架构 */
        var osArch: String? = null

        companion object {
            fun build(sysInfo: com.aizuda.monitor.SysInfo): SysInfo? {
                return MapstructUtils.convert(sysInfo, SysInfo::class.java)
            }
        }
    }

    /**
     * CPU信息
     *
     * 说明：
     * 自定义返回哪些数据
     */
    @AutoMapper(target = com.aizuda.monitor.CpuInfo::class)
    class CpuInfo {
        /** 物理处理器数量 */
        var physicalProcessorCount: Int = 0

        /** 逻辑处理器数量 */
        var logicalProcessorCount: Int = 0

        /** 系统使用率 */
        var systemPercent: Double = 0.0

        /** 用户使用率 */
        var userPercent: Double = 0.0

        /** 当前等待率 */
        var waitPercent: Double = 0.0

        /** 当前使用率 */
        var usePercent: Double = 0.0

        companion object {
            fun build(cpuInfo: com.aizuda.monitor.CpuInfo): CpuInfo? {
                return MapstructUtils.convert(cpuInfo, CpuInfo::class.java)
            }
        }
    }

    /**
     * 内存信息
     *
     * 说明：
     * 自定义返回哪些数据
     */
    @AutoMapper(target = com.aizuda.monitor.MemoryInfo::class)
    class MemoryInfo {
        /** 总计 */
        var total: String? = null

        /** 已使用 */
        var used: String? = null

        /** 未使用 */
        var free: String? = null

        /** 使用率 */
        var usePercent: Double = 0.0

        companion object {
            fun build(memoryInfo: com.aizuda.monitor.MemoryInfo): MemoryInfo? {
                return MapstructUtils.convert(memoryInfo, MemoryInfo::class.java)
            }
        }
    }

    /**
     * JVM信息
     *
     * 说明：
     * 自定义返回哪些数据
     */
    @AutoMapper(target = com.aizuda.monitor.JvmInfo::class)
    class JvmInfo {
        /** jdk版本 */
        var jdkVersion: String? = null

        /** jdk Home */
        var jdkHome: String? = null

        /** jdk name */
        var jdkName: String? = null

        /** 总内存 */
        var jvmTotalMemory: String? = null

        /** Java虚拟机将尝试使用的最大内存量 */
        var maxMemory: String? = null

        /** 空闲内存 */
        var freeMemory: String? = null

        /** 已使用内存 */
        var usedMemory: String? = null

        /** 内存使用率 */
        var usePercent: Double = 0.0

        /**
         * 返回Java虚拟机的启动时间（毫秒）。此方法返回Java虚拟机启动的大致时间。
         */
        var startTime: Long = 0

        /**
         * 返回Java虚拟机的正常运行时间（毫秒）
         */
        var uptime: Long = 0

        companion object {
            fun build(jvmInfo: com.aizuda.monitor.JvmInfo): JvmInfo? {
                return MapstructUtils.convert(jvmInfo, JvmInfo::class.java)
            }
        }
    }

    /**
     * 中央处理器信息
     *
     * 说明：
     * 自定义返回哪些数据
     */
    class CentralProcessor {
        /** cpu名称 */
        var name: String? = null

        /** 是否64位cpu */
        var cpu64bit: Boolean = false

        companion object {
            fun build(centralProcessor: oshi.hardware.CentralProcessor.ProcessorIdentifier): CentralProcessor {
                return CentralProcessor().apply {
                    this.name = centralProcessor.name
                    this.cpu64bit = centralProcessor.isCpu64bit
                }
            }
        }
    }

    /**
     * 磁盘信息
     *
     * 说明：
     * 自定义返回哪些数据
     */
    @AutoMapper(target = com.aizuda.monitor.DiskInfo::class)
    class DiskInfo {
        /** 名称 */
        var name: String? = null

        /** 标签 */
        var label: String? = null

        /** 文件系统的逻辑卷名 */
        var logicalVolume: String? = null

        /** 文件系统的挂载点 */
        var mount: String? = null

        /**
         * 文件系统的类型（FAT、NTFS、etx2、ext4等）
         */
        var type: String? = null

        /** 分区大小 */
        var size: String? = null

        /** 已使用 */
        var used: String? = null

        /** 可用容量 */
        var avail: String? = null

        /** 总容量 */
        var totalSpace: Long? = null

        /** 已使用容量 */
        var usableSpace: Long? = null

        /** 已使用百分比 */
        var usePercent: Double = 0.0

        companion object {
            fun build(diskInfo: com.aizuda.monitor.DiskInfo): DiskInfo {
                return MapstructUtils.convert(diskInfo, DiskInfo::class.java)!!
            }

            fun build(diskInfos: MutableList<com.aizuda.monitor.DiskInfo>): List<DiskInfo> {
                return diskInfos.map { build(it) }
            }
        }
    }
}
