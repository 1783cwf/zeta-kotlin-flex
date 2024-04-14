package com.zetaframework.system.controller

import cn.hutool.core.collection.CollUtil
import com.mybatisflex.core.query.QueryWrapper
import com.zetaframework.base.controller.SuperSimpleController
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreAuth
import com.zetaframework.satoken.annotation.PreCheckPermission
import com.zetaframework.satoken.annotation.PreMode
import com.zetaframework.system.model.dto.sysRoleMenu.SysRoleMenuHandleDTO
import com.zetaframework.system.model.entity.SysMenu
import com.zetaframework.system.model.entity.SysRoleMenu
import com.zetaframework.system.service.ISysMenuService
import com.zetaframework.system.service.ISysRoleMenuService
import com.zetaframework.utils.TreeUtil
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 角色菜单 前端控制器
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@PreAuth(replace = "sys:role")
@RestController
@RequestMapping("/api/system/roleMenu")
class SysRoleMenuController(
    private val menuService: ISysMenuService,
) : SuperSimpleController<ISysRoleMenuService, SysRoleMenu>() {
    /**
     * 查询角色菜单树
     *
     * 说明：
     * 用于前端角色管理查询角色对应的菜单树。
     *
     * @param roleId 角色id
     * @return ApiResult<List<SysMenu?>>
     */
    @GetMapping("/{roleId}")
    fun list(
        @PathVariable("roleId") roleId: Long,
    ): ApiResult<List<SysMenu?>> {
        val menuList = menuService.list() ?: return success(mutableListOf())
        val roleMenuList = service.list(QueryWrapper().eq(SysRoleMenu::roleId, roleId))
        for (menu in menuList) {
            menu.checked =
                roleMenuList.any {
                    it.menuId == menu.id
                }
        }
        return success(TreeUtil.buildTree(menuList))
    }

    /**
     * 新增或修改
     *
     * @param roleMenuHandleDto 修改角色菜单关联关系参数
     * @return ApiResult<Boolean>
     */
    @PreCheckPermission(value = ["{}:edit", "{}:update"], mode = PreMode.OR)
    @PutMapping
    fun update(
        @RequestBody @Validated roleMenuHandleDto: SysRoleMenuHandleDTO,
    ): ApiResult<Boolean> {
        // 修改前先删除角色所有权限

        service.remove(QueryWrapper().eq(SysRoleMenu::roleId, roleMenuHandleDto.roleId))

        // 重新关联角色权限
        if (CollUtil.isNotEmpty(roleMenuHandleDto.menuIds)) {
            val batchList: List<SysRoleMenu> =
                roleMenuHandleDto.menuIds!!.map {
                    SysRoleMenu(roleMenuHandleDto.roleId, it)
                }
            if (!service.saveBatch(batchList)) return fail("操作失败")
        }

        // 删除用户角色、权限缓存
        service.clearUserCache(roleMenuHandleDto.roleId!!)
        return success(true)
    }
}
