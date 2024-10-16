package com.zetaframework.system.service.impl

import cn.hutool.core.io.IoUtil
import com.mybatisflex.spring.service.impl.ServiceImpl
import com.zetaframework.exception.BusinessException
import com.zetaframework.file.model.FileDeleteParam
import com.zetaframework.file.model.FileInfo
import com.zetaframework.file.strategy.FileContext
import com.zetaframework.system.dao.SysFileMapper
import com.zetaframework.system.model.entity.SysFile
import com.zetaframework.system.service.ISysFileService
import com.zetaframework.utils.MapstructUtils
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.io.InputStream

/**
 * 系统文件 服务实现类
 *
 * @author AutoGenerator
 * @date 2022-04-11 11:18:44
 */
@Service
class SysFileServiceImpl(
    private val fileContext: FileContext,
) : ISysFileService, ServiceImpl<SysFileMapper, SysFile>() {
    private val logger = LoggerFactory.getLogger(this::class.java)

    /**
     * 上传文件
     *
     * @param file 文件对象
     * @param bizType 业务类型 例如：order、user_avatar等 会影响文件url的值
     * @return [SysFile]
     */
    override fun upload(
        file: MultipartFile,
        bizType: String?,
    ): SysFile {
        // 调用具体策略(配置文件里面配置的那个，没配置默认上传到本地)上传文件
        val fileInfo: FileInfo = fileContext.upload(file, bizType)

        val model = MapstructUtils.convert(fileInfo, SysFile::class.java)
        if (!this.save(model)) {
            throw BusinessException("文件保存失败")
        }
        return model!!
    }

    /**
     * 下载文件
     *
     * @param id 文件id
     */
    override fun download(
        id: Long,
        response: HttpServletResponse,
    ) {
        val sysFile = this.getById(id) ?: throw BusinessException("文件不存在或已被删除")

        // 获取文件输入流
        val inputStream: InputStream? = fileContext.getFileInputStream(sysFile.path!!)
        inputStream?.use {
            // 设置响应头
            response.contentType = "application/octet-stream; charset=utf-8"
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName=" + sysFile.uniqueFileName)

            // 将文件流写入到输出中去
            IoUtil.copy(inputStream, response.outputStream)
        }
    }

    /**
     * 删除文件
     *
     * @param id 文件id
     */
    override fun delete(id: Long): Boolean {
        val sysFile = this.getById(id) ?: return true
        // 先删除文件
        // fix: 删除文件失败不应该抛异常，因为会出现更换了文件存储策略（eg: 阿里云-> minio）导致文件无法删除的情况  --by gcc date: 2023-05-26
        fileContext.delete(FileDeleteParam(path = sysFile.path!!))

        // 再删除数据
        return this.removeById(id)
    }

    /**
     * 批量删除文件
     *
     * @param ids 文件id列表
     */
    @Transactional
    override fun batchDelete(ids: MutableList<Long>): Boolean {
        // 批量查询文件
        val listFile = this.listByIds(ids)
        if (listFile.isEmpty()) {
            return true
        }

        // 排除相对路径为空的文件，构造批量删除参数
        val params =
            listFile.filterNot { it.path.isNullOrBlank() }.map {
                FileDeleteParam(path = it.path)
            }
        // 批量删除， params不用判空
        fileContext.batchDelete(params)

        // 删除数据
        return this.removeByIds(ids)
    }
}
