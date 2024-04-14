package com.zetaframework.system.service.impl

import com.mybatisflex.spring.service.impl.ServiceImpl
import com.zetaframework.system.dao.SysMenuMapper
import com.zetaframework.system.model.entity.SysMenu
import com.zetaframework.system.service.ISysMenuService
import org.springframework.stereotype.Service

/**
 * 菜单 服务实现类
 *
 * @author AutoGenerator
 * @date 2021-12-30 15:24:03
 */
@Service
class SysMenuServiceImpl : ISysMenuService, ServiceImpl<SysMenuMapper, SysMenu>()
