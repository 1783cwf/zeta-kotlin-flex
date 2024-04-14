package com.zetaframework

import org.mybatis.spring.annotation.MapperScan
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Repository

@MapperScan(value = ["com.zetaframework.**.dao"], annotationClass = Repository::class)
@SpringBootApplication
class ZetaKotlinFlexApplication

private val log: Logger = LoggerFactory.getLogger(ZetaKotlinFlexApplication::class.java)

fun main(args: Array<String>) {
    val context = runApplication<ZetaKotlinFlexApplication>(*args)
    val env = context.environment
    log.info(
        """
----------------------------------------------------------
	项目 '${env.getProperty("spring.application.name")}' 启动成功!
----------------------------------------------------------
    """,
    )
}
