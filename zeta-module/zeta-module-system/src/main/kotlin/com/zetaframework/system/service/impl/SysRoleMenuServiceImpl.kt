package com.zetaframework.system.service.impl

import com.mybatisflex.core.query.QueryWrapper
import com.mybatisflex.kotlin.extensions.condition.allAnd
import com.mybatisflex.kotlin.extensions.db.query
import com.mybatisflex.kotlin.extensions.kproperty.eq
import com.mybatisflex.kotlin.extensions.kproperty.`in`
import com.mybatisflex.kotlin.extensions.sql.unaryPlus
import com.mybatisflex.kotlin.vec.QueryFunctions.select
import com.mybatisflex.spring.service.impl.ServiceImpl
import com.zetaframework.system.dao.SysRoleMenuMapper
import com.zetaframework.system.model.entity.SysMenu
import com.zetaframework.system.model.entity.SysRoleMenu
import com.zetaframework.system.model.entity.SysUserRole
import com.zetaframework.system.model.entity.table.SysMenuTableDef.SYS_MENU
import com.zetaframework.system.model.entity.table.SysRoleMenuTableDef.SYS_ROLE_MENU
import com.zetaframework.system.model.entity.table.SysRoleTableDef.SYS_ROLE
import com.zetaframework.system.model.entity.table.SysUserRoleTableDef.SYS_USER_ROLE
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
    val baseColumnList =
        listOf(
            SysMenu::id,
            SysMenu::createTime,
            SysMenu::createdBy,
            SysMenu::updateTime,
            SysMenu::updatedBy,
            SysMenu::label,
            SysMenu::name,
            SysMenu::path,
            SysMenu::component,
            SysMenu::redirect,
            SysMenu::icon,
            SysMenu::authority,
            SysMenu::menuType,
            SysMenu::hide,
            SysMenu::keepAlive,
            SysMenu::href,
            SysMenu::frameSrc,
            SysMenu::parentId,
            SysMenu::sortValue,
        )

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
        // 根据用户ID查询当前用户所具有的角色
        val roleIds =
            select(SYS_USER_ROLE.ROLE_ID)
                .from(SYS_USER_ROLE)
                .leftJoin<QueryWrapper>(SYS_ROLE)
                .on(SYS_USER_ROLE.ROLE_ID.eq(SYS_ROLE.ID))
                .where(SYS_USER_ROLE.USER_ID.eq(userId))

        // 根据角色ID查询所有的菜单ID
        val menuIds =
            select(SYS_ROLE_MENU.MENU_ID)
                .from(SYS_ROLE_MENU)
                .where(SYS_ROLE_MENU.ROLE_ID.`in`(roleIds))

        return query<SysMenu> {
            select(*baseColumnList.toTypedArray())
            from(SYS_MENU)
            allAnd(
                SysMenu::id `in` menuIds,
                SysMenu::menuType eq menuType,
            )
            orderBy(+SYS_MENU.SORT_VALUE, +SYS_MENU.ID)
        }
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
        // 根据角色ID集合获取所有符合的菜单ID集合
        val menuIds =
            select(SYS_ROLE_MENU.MENU_ID)
                .from(SYS_ROLE_MENU)
                .where(SYS_ROLE_MENU.ROLE_ID.`in`(roleIds))

        return query<SysMenu> {
            select(*baseColumnList.toTypedArray())
            from(SYS_MENU)
            allAnd(
                SysMenu::id `in` menuIds,
                SysMenu::menuType eq menuType,
            )
            orderBy(+SYS_MENU.SORT_VALUE, +SYS_MENU.ID)
        }
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
