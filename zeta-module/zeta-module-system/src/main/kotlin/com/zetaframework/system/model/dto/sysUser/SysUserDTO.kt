package com.zetaframework.system.model.dto.sysUser

import cn.hutool.core.util.DesensitizedUtil
import com.zetaframework.desensitization.annotation.Desensitization
import com.zetaframework.model.dto.SysRoleDTO
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * 用户详情
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
data class SysUserDTO(
    /** id */
    var id: Long? = null,
    /** 创建时间 */
    var createTime: LocalDateTime? = null,
    /** 创建人 */
    var createdBy: Long? = null,
    /** 修改时间 */
    var updateTime: LocalDateTime? = null,
    /** 修改人 */
    var updatedBy: Long? = null,
    /** 状态 */
    var state: Int? = null,
    /** 用户名 */
    var username: String? = null,
    /** 账号 */
    @Desensitization(rule = DesensitizedUtil.DesensitizedType.FIRST_MASK)
    var account: String? = null,
    /** 密码 */
    @Desensitization(rule = DesensitizedUtil.DesensitizedType.PASSWORD)
    var password: String? = null,
    /** 邮箱 */
    @Desensitization(rule = DesensitizedUtil.DesensitizedType.EMAIL)
    var email: String? = null,
    /** 手机号 */
    @Desensitization(rule = DesensitizedUtil.DesensitizedType.MOBILE_PHONE)
    var mobile: String? = null,
    /** 性别 */
    var sex: Int? = null,
    /** 头像 */
    var avatar: String? = null,
    /** 生日 */
    var birthday: LocalDate? = null,
    /** 用户角色 */
    var roles: List<SysRoleDTO>? = null,
)
