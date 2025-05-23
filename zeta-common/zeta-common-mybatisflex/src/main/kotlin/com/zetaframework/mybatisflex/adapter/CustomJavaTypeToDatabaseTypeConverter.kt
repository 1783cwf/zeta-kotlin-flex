package com.zetaframework.mybatisflex.adapter

import com.mybatisflex.annotation.Column
import org.apache.ibatis.type.UnknownTypeHandler
import org.dromara.autotable.core.converter.JavaTypeToDatabaseTypeConverter
import org.springframework.core.annotation.AnnotatedElementUtils
import java.lang.reflect.Field

/**
 * @author <a href="mailto:caowf@mochasoft.com.cn">caoweifeng</a>
 */
class CustomJavaTypeToDatabaseTypeConverter : JavaTypeToDatabaseTypeConverter {
    /**
     * 获取字段类型
     * 如果存在复杂的类型，可以重写该方法
     *
     * @param clazz 实体类
     * @param field 字段
     * @return 字段类型
     */
    override fun getFieldType(
        clazz: Class<*>?,
        field: Field,
    ): Class<*>? {
        // 枚举，按照字符串处理
        if (field.type.isEnum) {
            return String::class.java
        }
        val column = AnnotatedElementUtils.findMergedAnnotation(field, Column::class.java)

        // json数据，按照字符串处理
        if (column != null && column.typeHandler != UnknownTypeHandler::class.java) {
            return String::class.java
        }

        return field.type
    }
}
