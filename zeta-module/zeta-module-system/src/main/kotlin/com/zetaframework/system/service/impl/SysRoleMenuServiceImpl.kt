package com.zetaframework.system.service.impl

import com.mybatisflex.core.query.QueryWrapper
import com.mybatisflex.spring.service.impl.ServiceImpl
import com.zetaframework.system.dao.SysRoleMenuMapper
import com.zetaframework.system.model.entity.SysMenu
import com.zetaframework.system.model.entity.SysRoleMenu
import com.zetaframework.system.model.entity.SysUserRole
import com.zetaframework.system.service.ISysRoleMenuService
import com.zetaframework.system.service.ISysUserRoleService
import org.springframework.stereotype.Service

/**
 * 角色菜单 服务实现类
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Service
class SysRoleMenuServiceImpl(
    private val userRoleService: ISysUserRoleService,
    private val saRoleStringCacheKey: com.zetaframework.system.common.cacheKey.SaRoleStringCacheKey,
    private val saPermissionStringCacheKey: com.zetaframework.system.common.cacheKey.SaPermissionStringCacheKey,
) : ISysRoleMenuService, ServiceImpl<SysRoleMenuMapper, SysRoleMenu>() {
    /**
     * 查询用户对应的菜单
     *
     * @param userId    用户id
     * @param menuType  菜单类型
     * @return List<[SysMenu]> 菜单列表
     */
    override fun listMenuByUserId(
        userId: Long,
        menuType: String?,
    ): List<SysMenu> {
        return mapper.listMenuByUserId(userId, menuType)
    }

    /**
     * 根据角色id查询菜单
     *
     * @param roleIds   角色id
     * @param menuType  菜单类型
     * @return List<[SysMenu]> 菜单列表
     */
    override fun listMenuByRoleIds(
        roleIds: List<Long>,
        menuType: String?,
    ): List<SysMenu> {
        return mapper.listMenuByRoleIds(roleIds, menuType)
    }

    /**
     * 删除用户角色、权限缓存
     *
     * @param roleId 角色id
     * @return
     */
    override fun clearUserCache(roleId: Long) {
        // 查询角色对应的用户
        val userRoleList =
            userRoleService.list(
                QueryWrapper.create(SysUserRole())
                    .eq(SysUserRole::roleId, roleId),
            )
        if (userRoleList.isEmpty()) return

        userRoleList!!.map { it.userId }.forEach { userId ->
            // 删除用户权限缓存
            saPermissionStringCacheKey.delete(userId)
            // 删除用户角色缓存
            saRoleStringCacheKey.delete(userId)
        }
    }
}
