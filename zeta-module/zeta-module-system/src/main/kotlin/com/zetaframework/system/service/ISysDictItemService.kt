package com.zetaframework.system.service

import com.mybatisflex.core.service.IService
import com.zetaframework.system.model.dto.sysDictItem.SysDictItemDTO
import com.zetaframework.system.model.entity.SysDictItem

/**
 * 字典项 服务类
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:12:10
 */
interface ISysDictItemService : IService<SysDictItem> {
    /**
     * 根据字典编码查询字典项
     *
     * @param codes 字典编码
     * @return { "字典编码1" : ["字典项", "字典项"], "字典编码2" : ["字典项"] }
     */
    fun listByCodes(codes: List<String>): Map<String, List<SysDictItemDTO>>

    /**
     * 根据字典id查询字典项
     *
     * @param dictIds 字典id
     * @param { 字典id1 : ["字典项", "字典项"], 字典id2: ["字典项"] }
     */
    fun listByDictIds(dictIds: List<Long>): Map<Long, List<SysDictItem>>
}
