package com.zetaframework.system.service.impl

import com.mybatisflex.spring.service.impl.ServiceImpl
import com.zetaframework.system.dao.SysDictMapper
import com.zetaframework.system.model.entity.SysDict
import com.zetaframework.system.service.ISysDictService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 * 字典 服务实现类
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:12:09
 */
@Service
class SysDictServiceImpl : ISysDictService, ServiceImpl<SysDictMapper, SysDict>() {
    private val logger = LoggerFactory.getLogger(this::class.java)
}
