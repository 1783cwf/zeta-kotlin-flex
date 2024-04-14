package com.zetaframework.system.service.impl

import com.mybatisflex.core.query.QueryWrapper
import com.mybatisflex.spring.service.impl.ServiceImpl
import com.zetaframework.system.dao.SysRoleMapper
import com.zetaframework.system.model.entity.SysRole
import com.zetaframework.system.service.ISysRoleService
import org.springframework.stereotype.Service

/**
 * 角色 服务实现类
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Service
class SysRoleServiceImpl : ISysRoleService, ServiceImpl<SysRoleMapper, SysRole>() {
    /**
     * 通过角色名查询角色
     *
     * @param name 角色名
     * @return [SysRole] 角色名对应的角色
     */
    override fun getRoleByName(name: String): SysRole? {
        return this.getOne(
            QueryWrapper.create(SysRole())
                .eq(SysRole::name, name)
                .orderBy(SysRole::id, false),
        )
    }

    /**
     * 通过角色名查询角色
     *
     * @param names 角色名列表
     * @return List<[SysRole]> 角色名对应的角色
     */
    override fun getRolesByNames(names: List<String>): List<SysRole> {
        if (names.isEmpty()) return emptyList()

        return this.list(QueryWrapper.create(SysRole()).`in`(SysRole::name, names))
    }

    /**
     * 通过角色编码查询角色
     *
     * @param code 角色编码
     * @return [SysRole] 角色编码对应的角色
     */
    override fun getRoleByCode(code: String): SysRole? {
        return this.getOne(
            QueryWrapper.create(SysRole())
                .eq(SysRole::code, code)
                .orderBy(SysRole::id, false),
        )
    }

    /**
     * 通过角色编码查询角色
     *
     * @param codes 角色编码列表
     * @return List<[SysRole]> 角色编码对应的角色
     */
    override fun getRolesByCodes(codes: List<String>): List<SysRole> {
        return this.list(QueryWrapper.create(SysRole()).`in`(SysRole::code, codes))
    }
}
