package com.zetaframework.system.controller

import cn.hutool.core.lang.Assert
import com.mybatisflex.core.query.QueryWrapper
import com.zetaframework.base.controller.SuperController
import com.zetaframework.log.annotation.SysLog
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreAuth
import com.zetaframework.system.model.dto.sysMenu.SysMenuSaveDTO
import com.zetaframework.system.model.dto.sysMenu.SysMenuUpdateDTO
import com.zetaframework.system.model.entity.SysMenu
import com.zetaframework.system.model.enums.MenuTypeEnum
import com.zetaframework.system.model.param.SysMenuQueryParam
import com.zetaframework.system.service.ISysMenuService
import com.zetaframework.utils.MapstructUtils
import com.zetaframework.utils.TreeUtil
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 菜单 前端控制器
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@PreAuth(replace = "sys:menu")
@RestController
@RequestMapping("/api/system/menu")
class SysMenuController : SuperController<ISysMenuService, SysMenu, SysMenuQueryParam, SysMenuSaveDTO, SysMenuUpdateDTO>() {
    /**
     * 自定义批量查询
     *
     * @param param QueryParam
     * @return MutableList<BaseEntity>
     */
    override fun handlerBatchQuery(param: SysMenuQueryParam): MutableList<SysMenu> {
        val entity = MapstructUtils.convert(param, SysMenu::class.java)
        // 批量查询
        val list =
            service.list(
                QueryWrapper.create(entity),
            )
        // 处理批量查询数据
        super.handlerBatchData(list)
        return list
    }

    /**
     * 自定义新增
     *
     * @param saveDTO SaveDTO 保存对象
     * @return ApiResult<Boolean>
     */
    override fun handlerSave(saveDTO: SysMenuSaveDTO): ApiResult<Boolean> {
        // 如果新增的是菜单
        if (MenuTypeEnum.MENU == saveDTO.menuType) {
            Assert.notBlank(saveDTO.name, "路由名称不能为空")
            Assert.notBlank(saveDTO.path, "路由地址不能为空")
        }
        return super.handlerSave(saveDTO)
    }

    /**
     * 自定义修改
     *
     * @param updateDTO UpdateDTO 修改对象
     * @return ApiResult<Boolean>
     */
    override fun handlerUpdate(updateDTO: SysMenuUpdateDTO): ApiResult<Boolean> {
        // 如果修改的是菜单
        if (MenuTypeEnum.MENU == updateDTO.menuType) {
            Assert.notBlank(updateDTO.name, "路由名称不能为空")
            Assert.notBlank(updateDTO.path, "路由地址不能为空")
        }
        return super.handlerUpdate(updateDTO)
    }

    /**
     * 查询菜单树
     *
     * @param param 查询参数
     * @return ApiResult<List<[SysMenu]?>>
     */
    @SysLog
    @PostMapping("/tree")
    fun tree(
        @RequestBody param: SysMenuQueryParam,
    ): ApiResult<List<SysMenu?>> {
        // 查询所有菜单
        val menuList = handlerBatchQuery(param)
        if (menuList.isEmpty()) return fail("未查询到菜单")

        // 转换成树形结构
        return success(TreeUtil.buildTree(menuList, false))
    }
}
