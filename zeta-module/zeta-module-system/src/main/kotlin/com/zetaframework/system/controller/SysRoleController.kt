package com.zetaframework.system.controller

import com.zetaframework.base.controller.SuperController
import com.zetaframework.base.param.ExistParam
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreAuth
import com.zetaframework.system.model.dto.sysRole.SysRoleSaveDTO
import com.zetaframework.system.model.dto.sysRole.SysRoleUpdateDTO
import com.zetaframework.system.model.entity.SysRole
import com.zetaframework.system.model.param.SysRoleQueryParam
import com.zetaframework.system.service.ISysRoleService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 角色 前端控制器
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@PreAuth(replace = "sys:role")
@RestController
@RequestMapping("/api/system/role")
class SysRoleController : SuperController<ISysRoleService, SysRole, SysRoleQueryParam, SysRoleSaveDTO, SysRoleUpdateDTO>() {
    /**
     * 自定义新增
     *
     * @param saveDTO 保存对象
     * @return ApiResult<BaseEntity>
     */
    override fun handlerSave(saveDTO: SysRoleSaveDTO): ApiResult<Boolean> {
        // 判断是否存在
        if (ExistParam<SysRole, Long>("name", saveDTO.name).isExist(service)) {
            return fail("角色名已存在")
        }
        if (ExistParam<SysRole, Long>("code", saveDTO.code).isExist(service)) {
            return fail("角色编码已存在")
        }

        return super.handlerSave(saveDTO)
    }

    /**
     * 自定义修改
     *
     * @param updateDTO 修改对象
     * @return ApiResult<BaseEntity>
     */
    override fun handlerUpdate(updateDTO: SysRoleUpdateDTO): ApiResult<Boolean> {
        // 判断是否存在
        if (ExistParam<SysRole, Long>("name", updateDTO.name, updateDTO.id).isExist(service)) {
            return fail("角色名已存在")
        }
        if (ExistParam<SysRole, Long>("code", updateDTO.code, updateDTO.id).isExist(service)) {
            return fail("角色编码已存在")
        }

        return super.handlerUpdate(updateDTO)
    }

    /**
     * 自定义单体删除
     *
     * @param id 主键
     * @return ApiResult<Boolean>
     */
    override fun handlerDelete(id: Long): ApiResult<Boolean> {
        val role = service.getById(id) ?: return success(true)
        // 判断角色是否允许删除
        if (role.readonly != null && role.readonly == true) {
            throw com.zetaframework.exception.BusinessException("角色[${role.name}]禁止删除")
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
        val roleList = service.listByIds(ids) ?: return success(true)
        // 判断是否存在不允许删除的角色
        roleList.forEach { role ->
            if (role.readonly != null && role.readonly == true) {
                throw com.zetaframework.exception.BusinessException("角色[${role.name}]禁止删除")
            }
        }
        return super.handlerBatchDelete(ids)
    }

    /**
     * 获取实体类型
     *
     * @return Class<BaseEntity>
     */
    override fun getEntityClass(): Class<SysRole> {
        return SysRole::class.java
    }
}
