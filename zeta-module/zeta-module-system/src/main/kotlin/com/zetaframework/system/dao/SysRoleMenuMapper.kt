package com.zetaframework.system.dao

import com.mybatisflex.core.BaseMapper
import com.mybatisflex.core.query.QueryWrapper
import com.mybatisflex.kotlin.extensions.condition.allAnd
import com.mybatisflex.kotlin.extensions.db.query
import com.mybatisflex.kotlin.extensions.kproperty.eq
import com.mybatisflex.kotlin.extensions.kproperty.`in`
import com.mybatisflex.kotlin.extensions.kproperty.unaryPlus
import com.zetaframework.system.model.entity.SysMenu
import com.zetaframework.system.model.entity.SysRole
import com.zetaframework.system.model.entity.SysRoleMenu
import com.zetaframework.system.model.entity.SysUserRole
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

        return query<SysMenu> {
            select(*baseColumnList.toTypedArray())
            from(SysMenu::class.java)
            allAnd(
                SysMenu::id `in` menuIds,
                SysMenu::menuType eq menuType,
            )
            orderBy(+SysMenu::sortValue, +SysMenu::id)
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
            QueryWrapper.create()
                .select(SysRoleMenu::menuId)
                .from(SysRoleMenu::class.java)
                .where(SysRoleMenu::roleId.`in`(roleIds))

        return query<SysMenu> {
            select(*baseColumnList.toTypedArray())
            from(SysMenu::class.java)
            allAnd(
                SysMenu::id `in` menuIds,
                SysMenu::menuType eq menuType,
            )
            orderBy(+SysMenu::sortValue, +SysMenu::id)
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
