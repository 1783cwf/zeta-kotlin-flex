package com.zetaframework.system.dao

import com.mybatisflex.core.BaseMapper
import com.zetaframework.model.dto.SysRoleDTO
import com.zetaframework.system.model.entity.SysRole
import com.zetaframework.system.model.entity.SysUserRole
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 * 用户角色 Mapper 接口
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Repository
interface SysUserRoleMapper : BaseMapper<SysUserRole> {
    /**
     * 根据用户id查询角色
     *
     * @param userId 用户id
     * @return List<[SysRole]> 角色列表
     */
    fun selectByUserId(
        @Param("userId") userId: Long?,
    ): List<SysRole>

    /**
     * 批量根据用户id查询角色
     *
     * @param userIds 用户id集合
     * @return List<[SysRoleDTO]> 角色详情列表
     */
    fun selectByUserIds(
        @Param("userIds") userIds: List<Long>,
    ): List<SysRoleDTO>
}
