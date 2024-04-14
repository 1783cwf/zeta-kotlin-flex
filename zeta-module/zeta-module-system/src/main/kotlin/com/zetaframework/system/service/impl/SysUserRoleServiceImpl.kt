package com.zetaframework.system.service.impl

import com.mybatisflex.core.query.QueryWrapper
import com.mybatisflex.spring.service.impl.ServiceImpl
import com.zetaframework.model.dto.SysRoleDTO
import com.zetaframework.system.dao.SysUserRoleMapper
import com.zetaframework.system.model.entity.SysRole
import com.zetaframework.system.model.entity.SysUserRole
import com.zetaframework.system.service.ISysUserRoleService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 用户角色 服务实现类
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Service
class SysUserRoleServiceImpl : ISysUserRoleService, ServiceImpl<SysUserRoleMapper, SysUserRole>() {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    /**
     * 根据用户id查询角色
     *
     * @param userId 用户id
     * @return List<[SysRole]> 角色列表
     */
    override fun listByUserId(userId: Long): List<SysRole> {
        return mapper.selectByUserId(userId)
    }

    /**
     * 批量根据用户id查询角色
     *
     * @param userIds 用户id集合
     * @return List<[SysRoleDTO]> 角色详情列表
     */
    override fun listByUserIds(userIds: List<Long>): List<SysRoleDTO> {
        return mapper.selectByUserIds(userIds)
    }

    /**
     * 关联用户角色
     *
     * @param userId 用户id
     * @param roleIds 角色id列表
     * @return 是否成功
     */
    @Transactional(rollbackFor = [Exception::class])
    override fun saveUserRole(
        userId: Long,
        roleIds: List<Long>?,
    ): Boolean {
        // 删除用户角色关联
        this.remove(QueryWrapper.create(SysUserRole()).eq(SysUserRole::userId, userId))

        if (roleIds.isNullOrEmpty()) {
            return true
        }

        // 批量关联
        val batchList = roleIds.map { SysUserRole(userId, it) }
        return this.saveBatch(batchList)
    }

    /**
     * 关联用户角色
     *
     * @param userId 用户id
     * @param roleId 角色id
     * @return 是否成功
     */
    @Transactional(rollbackFor = [Exception::class])
    override fun saveUserRole(
        userId: Long,
        roleId: Long,
    ): Boolean {
        return this.save(SysUserRole(userId, roleId))
    }
}
