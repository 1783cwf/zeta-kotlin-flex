package com.zetaframework.system.dao

import com.mybatisflex.core.BaseMapper
import com.zetaframework.system.model.dto.sysDictItem.SysDictItemDTO
import com.zetaframework.system.model.entity.SysDictItem
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 * 字典项 Mapper 接口
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:12:10
 */
@Repository
interface SysDictItemMapper : BaseMapper<SysDictItem> {
    /**
     * 根据字典编码查询字典项
     *
     * @param codes 字典编码
     */
    fun selectByDictCodes(
        @Param("codes") codes: List<String>,
    ): MutableList<SysDictItemDTO>
}
