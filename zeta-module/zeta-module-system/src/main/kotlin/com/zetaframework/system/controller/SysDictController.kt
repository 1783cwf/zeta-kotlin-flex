package com.zetaframework.system.controller

import com.zetaframework.base.controller.SuperController
import com.zetaframework.base.param.ExistParam
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreAuth
import com.zetaframework.system.model.dto.sysDict.SysDictSaveDTO
import com.zetaframework.system.model.dto.sysDict.SysDictUpdateDTO
import com.zetaframework.system.model.entity.SysDict
import com.zetaframework.system.model.param.SysDictQueryParam
import com.zetaframework.system.service.ISysDictService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 字典 前端控制器
 *
 * @author AutoGenerator
 * @date 2022-04-15 10:12:09
 */
@PreAuth(replace = "sys:dict")
@RestController
@RequestMapping("/api/system/dict")
class SysDictController : SuperController<
    ISysDictService,
    SysDict,
    SysDictQueryParam,
    SysDictSaveDTO,
    SysDictUpdateDTO,
    >() {
    /**
     * 自定义新增
     *
     * @param saveDTO 保存对象
     * @return ApiResult<Boolean>
     */
    override fun handlerSave(saveDTO: SysDictSaveDTO): ApiResult<Boolean> {
        // 判断是否存在
        if (ExistParam<SysDict, Long>(SysDict::code, saveDTO.code).isExist(service)) {
            return fail("编码已存在")
        }
        return super.handlerSave(saveDTO)
    }

    /**
     * 自定义修改
     *
     * @param updateDTO UpdateDTO 修改对象
     * @return ApiResult<Boolean>
     */
    override fun handlerUpdate(updateDTO: SysDictUpdateDTO): ApiResult<Boolean> {
        // 判断是否存在
        if (ExistParam<SysDict, Long>(SysDict::code, updateDTO.code, updateDTO.id).isExist(service)) {
            return fail("编码已存在")
        }
        return super.handlerUpdate(updateDTO)
    }
}
