package com.zetaframework.system.service.impl

import com.mybatisflex.kotlin.extensions.db.query
import com.mybatisflex.kotlin.extensions.db.queryOne
import com.mybatisflex.kotlin.extensions.kproperty.eq
import com.mybatisflex.kotlin.extensions.kproperty.`in`
import com.mybatisflex.kotlin.extensions.kproperty.unaryMinus
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
        return queryOne<SysRole> {
            SysRole::name eq name
            orderBy(-SysRole::id)
        }
    }

    /**
     * 通过角色名查询角色
     *
     * @param names 角色名列表
     * @return List<[SysRole]> 角色名对应的角色
     */
    override fun getRolesByNames(names: List<String>): List<SysRole> {
        if (names.isEmpty()) return emptyList()

        return query<SysRole> {
            SysRole::name `in` names
        }
    }

    /**
     * 通过角色编码查询角色
     *
     * @param code 角色编码
     * @return [SysRole] 角色编码对应的角色
     */
    override fun getRoleByCode(code: String): SysRole? {
        return queryOne<SysRole> {
            SysRole::code eq code
            orderBy(-SysRole::id)
        }
    }

    /**
     * 通过角色编码查询角色
     *
     * @param codes 角色编码列表
     * @return List<[SysRole]> 角色编码对应的角色
     */
    override fun getRolesByCodes(codes: List<String>): List<SysRole> {
        return query<SysRole> {
            SysRole::code `in` codes
        }
    }
}
