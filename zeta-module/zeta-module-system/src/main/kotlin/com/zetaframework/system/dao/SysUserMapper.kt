package com.zetaframework.system.dao

import com.mybatisflex.core.BaseMapper
import com.mybatisflex.kotlin.extensions.condition.allAnd
import com.mybatisflex.kotlin.extensions.db.queryOne
import com.mybatisflex.kotlin.extensions.kproperty.eq
import com.zetaframework.system.model.entity.SysUser
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 * 用户 Mapper 接口
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Repository
interface SysUserMapper : BaseMapper<SysUser> {
    /**
     * 通过账号查询用户
     *
     * @param account 账号
     * @return [SysUser] 用户
     */
    fun selectByAccount(
        @Param("account") account: String,
    ): SysUser? {
        return queryOne<SysUser> {
            select(
                SysUser::id,
                SysUser::account,
                SysUser::username,
                SysUser::mobile,
                SysUser::sex,
                SysUser::avatar,
                SysUser::birthday,
                SysUser::password,
                SysUser::readonly,
                SysUser::state,
                SysUser::email,
                SysUser::createTime,
                SysUser::createdBy,
                SysUser::updateTime,
                SysUser::updatedBy,
            )
            from(SysUser::class.java)
            allAnd(
                SysUser::account eq account,
                SysUser::deleted eq false,
            )
        }
    }
}
