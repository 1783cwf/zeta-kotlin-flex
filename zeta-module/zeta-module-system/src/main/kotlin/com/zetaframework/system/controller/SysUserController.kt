package com.zetaframework.system.controller

import cn.dev33.satoken.stp.StpUtil
import cn.hutool.core.lang.Assert
import com.mybatisflex.core.paginate.Page
import com.zetaframework.base.controller.SuperNoQueryController
import com.zetaframework.base.controller.extra.ExistenceController
import com.zetaframework.base.controller.extra.NoPageQueryController
import com.zetaframework.base.controller.extra.UpdateStateController
import com.zetaframework.base.param.ExistParam
import com.zetaframework.base.param.PageParam
import com.zetaframework.base.param.UpdateStateParam
import com.zetaframework.log.annotation.SysLog
import com.zetaframework.model.dto.SysRoleDTO
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreAuth
import com.zetaframework.satoken.annotation.PreCheckPermission
import com.zetaframework.satoken.utils.LoginHelper
import com.zetaframework.system.model.dto.sysMenu.FrontRoute
import com.zetaframework.system.model.dto.sysUser.SysUserDTO
import com.zetaframework.system.model.dto.sysUser.SysUserSaveDTO
import com.zetaframework.system.model.dto.sysUser.SysUserUpdateDTO
import com.zetaframework.system.model.dto.sysUser.UserInfoDTO
import com.zetaframework.system.model.entity.SysUser
import com.zetaframework.system.model.enums.MenuTypeEnum
import com.zetaframework.system.model.enums.UserStateEnum
import com.zetaframework.system.model.param.ChangePasswordParam
import com.zetaframework.system.model.param.ResetPasswordParam
import com.zetaframework.system.model.param.SysUserQueryParam
import com.zetaframework.system.service.ISysRoleMenuService
import com.zetaframework.system.service.ISysRoleService
import com.zetaframework.system.service.ISysUserService
import com.zetaframework.utils.MapstructUtils
import com.zetaframework.utils.TreeUtil
import jakarta.servlet.http.HttpServletRequest
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

/**
 * 用户 前端控制器
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@PreAuth(replace = "sys:user")
@RestController
@RequestMapping("/api/system/user")
class SysUserController(
    private val roleService: ISysRoleService,
    private val roleMenuService: ISysRoleMenuService,
) : SuperNoQueryController<ISysUserService, SysUser, SysUserSaveDTO, SysUserUpdateDTO>(),
    NoPageQueryController<SysUser, SysUserQueryParam>,
    UpdateStateController<SysUser, Int>,
    ExistenceController<SysUser> {
    /**
     * 分页查询
     * @param param PageParam<QueryParam> 分页查询参数
     * @return ApiResult<PageResult<BaseEntity>>
     */
    @PreCheckPermission(value = ["{}:view"])
    @SysLog(response = false)
    @PostMapping("/page")
    fun page(
        @RequestBody param: PageParam<SysUserQueryParam>,
    ): ApiResult<Page<SysUserDTO>> {
        return success(service.customPage(param))
    }

    /**
     * 处理单体查询数据
     * @param entity 实体对象
     */
    override fun handlerGetData(entity: SysUser?) {
        entity?.id?.let { userId ->
            entity.roles = service.getUserRoles(userId)
        }
    }

    /**
     * 处理批量查询数据
     * @param list 实体列表
     */
    override fun handlerBatchData(list: MutableList<SysUser>) {
        if (list.isEmpty()) return
        val userIds: List<Long> = list.map { it.id!! }
        // 批量获取用户角色 Map<用户id, 用户角色列表>
        val userRoleMap: Map<Long, List<SysRoleDTO>> = service.getUserRoles(userIds)
        list.forEach { user ->
            user.roles = userRoleMap.getOrDefault(user.id, mutableListOf())
        }
    }

    /**
     * 自定义新增
     *
     * @param saveDTO 保存对象
     * @return ApiResult<BaseEntity>
     */
    override fun handlerSave(saveDTO: SysUserSaveDTO): ApiResult<Boolean> {
        // 判断是否存在
        if (ExistParam<SysUser, Long>("account", saveDTO.account).isExist(service)) {
            return fail("账号已存在")
        }
        return success(service.saveUser(saveDTO))
    }

    /**
     * 自定义修改
     *
     * @param updateDTO 修改对象
     * @return ApiResult<BaseEntity>
     */
    override fun handlerUpdate(updateDTO: SysUserUpdateDTO): ApiResult<Boolean> {
        return success(service.updateUser(updateDTO))
    }

    /**
     * 自定义修改状态
     *
     * @param param 修改状态参数
     * @return ApiResult<Boolean>
     */
    override fun handlerUpdateState(param: UpdateStateParam<Long, Int>): ApiResult<Boolean> {
        // 判断状态值是否正常
        Assert.notNull(param.id, "用户id不能为空")
        Assert.notNull(param.state, "状态不能为空")

        // 判断状态参数是否在定义的用户状态中
        if (!UserStateEnum.getAllCode().contains(param.state)) {
            return fail("参数异常")
        }

        // 判断用户是否允许修改
        val user = service.getById(param.id) ?: return fail("用户不存在")
        if (user.readonly != null && user.readonly == true) {
            throw com.zetaframework.exception.BusinessException("用户[${user.username}]禁止修改状态")
        }

        // 修改状态
        return super.handlerUpdateState(param)
    }

    /**
     * 自定义单体删除
     *
     * @param id 主键
     * @return ApiResult<Boolean>
     */
    override fun handlerDelete(id: Long): ApiResult<Boolean> {
        val user = service.getById(id) ?: return success(true)
        // 判断用户是否允许删除
        if (user.readonly != null && user.readonly == true) {
            throw com.zetaframework.exception.BusinessException("用户[${user.username}]禁止删除")
        }
        return super.handlerDelete(id)
    }

    /**
     * 自定义批量删除
     *
     * @param ids 主键列表
     * @return ApiResult<Boolean>
     */
    override fun handlerBatchDelete(ids: MutableList<Long>): ApiResult<Boolean> {
        val userList = service.listByIds(ids) ?: return success(true)
        // 判断是否存在不允许删除的用户
        userList.forEach { user ->
            if (user.readonly != null && user.readonly == true) {
                throw com.zetaframework.exception.BusinessException("用户[${user.username}]禁止删除")
            }
        }
        return super.handlerBatchDelete(ids)
    }

    /**
     * 修改自己的密码
     *
     * @param param 修改密码参数
     * @return ApiResult<Boolean>
     */
    @ResponseBody
    @PutMapping("/changePwd")
    fun changePwd(
        @RequestBody @Validated param: ChangePasswordParam,
        request: HttpServletRequest,
    ): ApiResult<Boolean> {
        val user = service.getById(LoginHelper.getUserId()) ?: throw com.zetaframework.exception.BusinessException("用户不存在")

        // 旧密码是否正确
        if (!service.comparePassword(param.oldPwd!!, user.password!!)) {
            return fail("旧密码不正确", false)
        }

        // 修改成新密码
        user.password = service.encodePassword(param.newPwd!!)
        if (!service.updateById(user)) {
            return fail("修改失败", false)
        }

        val userId = user.id

        // 下线
        StpUtil.kickout(userId)
        return success("修改成功", true)
    }

    /**
     * 重置密码
     *
     * @param param 重置密码参数
     * @return ApiResult<Boolean>
     */
    @PreCheckPermission(value = ["{}:update"])
    @SysLog(request = false)
    @PutMapping("/restPwd")
    fun updatePwd(
        @RequestBody @Validated param: ResetPasswordParam,
        request: HttpServletRequest,
    ): ApiResult<Boolean> {
        val user = service.getById(param.id) ?: return success(true)
        // 判断用户是否允许重置密码
        if (user.readonly != null && user.readonly == true) {
            throw com.zetaframework.exception.BusinessException("用户[${user.username}]禁止重置密码")
        }

        // 密码加密， 因为密码已经判空过了所以这里直接param.password!!
        user.password = service.encodePassword(param.password!!)

        // 修改密码
        if (!service.updateById(user)) {
            return fail("重置密码失败")
        }

        val userId = user.id
        // 让被修改密码的人下线
        StpUtil.kickout(userId)
        return success(true)
    }

    /**
     * 获取当前用户基本信息
     *
     * @return ApiResult<[UserInfoDTO]>
     */
    @GetMapping("/info")
    fun userInfo(): ApiResult<UserInfoDTO> {
        // 获取用户基本信息
        val user = service.getById(LoginHelper.getUserId()) ?: return fail("用户不存在")
        val userInfoDto = MapstructUtils.convert(user, UserInfoDTO::class.java)

        // 获取用户角色列表
        userInfoDto?.roleIds = StpUtil.getRoleList()
        // 获取用户权限列表
        userInfoDto?.permissions = StpUtil.getPermissionList()
        return success(userInfoDto!!)
    }

    /**
     * 获取当前用户菜单
     *
     * @return ApiResult<List<[FrontRoute]>>
     */
    @GetMapping("/menu")
    fun userMenu(): ApiResult<List<FrontRoute>> {
        // 查询用户对应的菜单
        val menuList = roleMenuService.listMenuByUserId(LoginHelper.getUserId()!!, MenuTypeEnum.MENU.name)

        // List<SysMenu> -> List<FrontRoute>
        val frontRouteList = menuList.map(FrontRoute::convert).toMutableList()
        return success(TreeUtil.buildTree(frontRouteList, false))
    }

    /**
     * 获取当前用户权限
     *
     * @return ApiResult<[List<String>]>
     */
    @GetMapping("/permissions")
    fun permissions(): ApiResult<List<String>> {
        return success(StpUtil.getPermissionList())
    }
}
