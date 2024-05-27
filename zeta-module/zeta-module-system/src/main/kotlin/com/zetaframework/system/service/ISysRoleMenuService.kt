package com.zetaframework.system.service

import com.mybatisflex.core.service.IService
import com.zetaframework.system.model.entity.SysMenu
import com.zetaframework.system.model.entity.SysRoleMenu

/**
 * 角色菜单 服务类
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
interface ISysRoleMenuService : IService<SysRoleMenu> {
    /**
     * 查询用户对应的菜单
     *
     * @param userId    用户id
     * @param menuType  菜单类型
     * @return List<[SysMenu]> 菜单列表
     */
    fun listMenuByUserId(
        userId: Long,
        menuType: String? = null,
    ): List<SysMenu>

    /**
     * 根据角色id查询菜单
     *
     * @param roleIds   角色id
     * @param menuType  菜单类型
     * @return List<[SysMenu]> 菜单列表
     */
    fun listMenuByRoleIds(
        roleIds: List<Long>,
        menuType: String? = null,
    ): List<SysMenu>

    /**
     * 删除用户角色、权限缓存
     *
     * @param roleId 角色id
     * @return
     */
    fun clearUserCache(roleId: Long)
}
