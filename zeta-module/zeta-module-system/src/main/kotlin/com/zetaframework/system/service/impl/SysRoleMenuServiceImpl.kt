package com.zetaframework.system.service.impl

import com.mybatisflex.core.query.QueryWrapper
import com.mybatisflex.kotlin.extensions.condition.allAnd
import com.mybatisflex.kotlin.extensions.kproperty.eq
import com.mybatisflex.kotlin.extensions.kproperty.`in`
import com.mybatisflex.kotlin.extensions.kproperty.unaryPlus
import com.mybatisflex.spring.service.impl.ServiceImpl
import com.zetaframework.system.dao.SysRoleMenuMapper
import com.zetaframework.system.model.entity.SysMenu
import com.zetaframework.system.model.entity.SysRole
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
            QueryWrapper.create()
                .select(SysUserRole::roleId)
                .from(SysUserRole::class.java)
                .leftJoin<QueryWrapper>(SysRole::class.java)
                .on(SysUserRole::roleId.eq(SysRole::id))
                .where(SysUserRole::userId.eq(userId))

        // 根据角色ID查询所有的菜单ID
        val menuIds =
            QueryWrapper.create()
                .select(SysRoleMenu::menuId)
                .from(SysRoleMenu::class.java)
                .where(SysRoleMenu::roleId.`in`(roleIds))

        return com.mybatisflex.kotlin.extensions.db.query<SysMenu> {
            select(*baseColumnList.toTypedArray())
            from(SysMenu::class.java)
            allAnd(
                SysMenu::id `in` menuIds,
                SysMenu::menuType eq menuType,
            )
            orderBy(+SysMenu::sortValue, +SysMenu::id)
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
            QueryWrapper.create()
                .select(SysRoleMenu::menuId)
                .from(SysRoleMenu::class.java)
                .where(SysRoleMenu::roleId.`in`(roleIds))

        return com.mybatisflex.kotlin.extensions.db.query<SysMenu> {
            select(*baseColumnList.toTypedArray())
            from(SysMenu::class.java)
            allAnd(
                SysMenu::id `in` menuIds,
                SysMenu::menuType eq menuType,
            )
            orderBy(+SysMenu::sortValue, +SysMenu::id)
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
