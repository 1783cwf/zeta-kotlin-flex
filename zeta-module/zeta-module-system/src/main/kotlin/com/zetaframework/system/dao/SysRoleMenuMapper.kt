package com.zetaframework.system.dao

import com.mybatisflex.core.BaseMapper
import com.mybatisflex.core.query.QueryWrapper
import com.mybatisflex.kotlin.extensions.condition.allAnd
import com.mybatisflex.kotlin.extensions.db.query
import com.mybatisflex.kotlin.extensions.kproperty.eq
import com.mybatisflex.kotlin.extensions.kproperty.`in`
import com.mybatisflex.kotlin.extensions.sql.unaryPlus
import com.mybatisflex.kotlin.vec.QueryFunctions.select
import com.zetaframework.system.model.entity.SysMenu
import com.zetaframework.system.model.entity.SysRoleMenu
import com.zetaframework.system.model.entity.table.SysMenuTableDef.SYS_MENU
import com.zetaframework.system.model.entity.table.SysRoleMenuTableDef.SYS_ROLE_MENU
import com.zetaframework.system.model.entity.table.SysRoleTableDef.SYS_ROLE
import com.zetaframework.system.model.entity.table.SysUserRoleTableDef.SYS_USER_ROLE
import org.springframework.stereotype.Repository

/**
 * 角色菜单 Mapper 接口
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Repository
interface SysRoleMenuMapper : BaseMapper<SysRoleMenu> {
    /**
     * 查询用户对应的菜单
     *
     * @param userId Long
     * @param menuType String?
     * @return List<Menu?>
     */
    fun listMenuByUserId(
        userId: Long,
        menuType: String?,
    ): MutableList<SysMenu> {
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
        }.toMutableList()
    }

    /**
     * 根据角色id查询菜单
     *
     * @param roleIds   角色id
     * @param menuType  菜单类型
     * @return List<Menu>
     */
    fun listMenuByRoleIds(
        roleIds: List<Long>,
        menuType: String?,
    ): MutableList<SysMenu> {
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
        }.toMutableList()
    }

    // 伴生对象
    companion object {
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
    }
}
