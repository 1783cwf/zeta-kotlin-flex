package com.zetaframework.mybatisflex.adapter

import com.mybatisflex.annotation.Table
import org.dromara.autotable.core.AutoTableClassScanner

/**
 * 基于注解扫描java类
 * @author <a href="mailto:caowf@mochasoft.com.cn">caoweifeng</a>
 */
class CustomAutoTableClassScanner : AutoTableClassScanner() {
    override fun getIncludeAnnotations(): Set<Class<out Annotation>> = setOf(Table::class.java)
}
