package com.zetaframework.mybatisflex.extensions

import com.mybatisflex.core.query.QueryCondition
import com.mybatisflex.kotlin.extensions.kproperty.column
import kotlin.reflect.KProperty

/**
 * @author <a href="mailto:weistuday@gmail.com">caoweifeng</a>
 * @date 2024年08月22日 16:45
 */

infix fun KProperty<String?>.like(other: Any?): QueryCondition = column.like(other)
