package com.zetaframework.system.controller

import com.zetaframework.base.controller.SuperSimpleController
import com.zetaframework.base.controller.curd.DeleteController
import com.zetaframework.base.controller.curd.QueryController
import com.zetaframework.log.annotation.SysLog
import com.zetaframework.model.result.ApiResult
import com.zetaframework.satoken.annotation.PreAuth
import com.zetaframework.satoken.annotation.PreCheckPermission
import com.zetaframework.satoken.annotation.PreMode
import com.zetaframework.system.model.entity.SysFile
import com.zetaframework.system.model.param.SysFileQueryParam
import com.zetaframework.system.service.ISysFileService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

/**
 * 系统文件 前端控制器
 *
 * @author AutoGenerator
 * @date 2022-04-11 11:18:44
 */
@PreAuth(replace = "sys:file")
@RestController
@RequestMapping("/api/system/file")
class SysFileController :
    SuperSimpleController<
        ISysFileService,
        SysFile,
        >(),
    QueryController<SysFile, SysFileQueryParam>,
    DeleteController<SysFile> {
    /**
     * 上传文件
     *
     * 吐个槽：注解地狱
     * @param file 文件对象
     * @param bizType 业务类型 例如：order、user_avatar等 会影响文件url的值
     */
    @SysLog(request = false)
    @PreCheckPermission(value = ["{}:add", "{}:save"], mode = PreMode.OR)
    @PostMapping("/upload")
    fun upload(
        @RequestParam
        file: MultipartFile,
        @RequestParam(required = false)
        bizType: String? = null,
    ): ApiResult<SysFile> {
        return success(service.upload(file, bizType))
    }

    /**
     * 下载文件
     *
     * @param id 文件id
     * @param response
     */
    @SysLog(response = false)
    @PreCheckPermission(value = ["{}:export"])
    @GetMapping(value = ["/download"], produces = ["application/octet-stream"])
    fun download(
        @RequestParam id: Long,
        response: HttpServletResponse,
    ) {
        service.download(id, response)
    }

    /**
     * 自定义单体删除文件
     *
     * @param id 主键
     * @return ApiResult<Boolean>
     */
    override fun handlerDelete(id: Long): ApiResult<Boolean> {
        return success(service.delete(id))
    }

    /**
     * 自定义批量删除文件
     *
     * @param ids 主键列表
     * @return ApiResult<Boolean>
     */
    override fun handlerBatchDelete(ids: MutableList<Long>): ApiResult<Boolean> {
        return success(service.batchDelete(ids))
    }
}
