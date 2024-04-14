package com.zetaframework.system.controller

import cn.hutool.core.lang.Assert
import com.zetaframework.base.controller.SuperController
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreAuth
import com.zetaframework.satoken.annotation.PreCheckPermission
import com.zetaframework.system.model.dto.sysDictItem.SysDictItemDTO
import com.zetaframework.system.model.dto.sysDictItem.SysDictItemSaveDTO
import com.zetaframework.system.model.dto.sysDictItem.SysDictItemUpdateDTO
import com.zetaframework.system.model.entity.SysDictItem
import com.zetaframework.system.model.param.SysDictItemQueryParam
import com.zetaframework.system.service.ISysDictItemService
import com.zetaframework.system.service.ISysDictService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 字典项 前端控制器
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:12:10
 */
@PreAuth(replace = "sys:dictItem")
@RestController
@RequestMapping("/api/system/dictItem")
class SysDictItemController(
    private val dictService: ISysDictService,
) : SuperController<
        ISysDictItemService,
        SysDictItem,
        SysDictItemQueryParam,
        SysDictItemSaveDTO,
        SysDictItemUpdateDTO,
        >() {
    /**
     * 根据字典编码查询字典项
     *
     * @param codes 字典编码
     */
    @PreCheckPermission(value = ["{}:view"])
    @PostMapping("/codeList")
    fun codeList(
        @RequestBody codes: List<String>,
    ): ApiResult<Map<String, List<SysDictItemDTO>>> {
        Assert.notEmpty(codes, "字典code不能为空")
        return success(service.listByCodes(codes))
    }
}
