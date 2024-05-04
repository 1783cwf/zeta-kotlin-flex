package com.zetaframework.mybatisflex.adapter

import cn.hutool.core.util.StrUtil
import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.EnumValue
import com.mybatisflex.annotation.Id
import com.mybatisflex.annotation.KeyType
import com.mybatisflex.annotation.RelationManyToMany
import com.mybatisflex.annotation.RelationManyToOne
import com.mybatisflex.annotation.RelationOneToMany
import com.mybatisflex.annotation.RelationOneToOne
import com.mybatisflex.annotation.Table
import com.mybatisflex.core.FlexGlobalConfig
import com.mybatisflex.core.util.ClassUtil
import com.mybatisflex.spring.boot.MybatisFlexProperties
import com.tangzc.autotable.annotation.AutoTable
import com.tangzc.autotable.core.AutoTableOrmFrameAdapter
import com.zetaframework.mybatisflex.entity.BaseEntity
import org.apache.ibatis.type.UnknownTypeHandler
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.AnnotatedElementUtils
import java.lang.reflect.Field
import java.util.Objects

/**
 * @author <a href="mailto:weistuday@gmail.com">caoweifeng</a>
 * @date 2024年05月03日 08:24
 */

class MybatisFlexAutoTableAdapter(
    private val mybatisFlexProperties: MybatisFlexProperties,
) : AutoTableOrmFrameAdapter {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun isIgnoreField(
        field: Field,
        clazz: Class<*>?,
    ): Boolean {
        val tableField = AnnotatedElementUtils.findMergedAnnotation(field, Column::class.java)
        if (tableField != null && tableField.ignore) {
            return true
        }
        val relationOneToOne = AnnotatedElementUtils.findMergedAnnotation(field, RelationOneToOne::class.java)
        if (relationOneToOne != null) {
            return true
        }
        val relationOneToMany = AnnotatedElementUtils.findMergedAnnotation(field, RelationOneToMany::class.java)
        if (relationOneToMany != null) {
            return true
        }
        val relationManyToOne = AnnotatedElementUtils.findMergedAnnotation(field, RelationManyToOne::class.java)
        if (relationManyToOne != null) {
            return true
        }
        val relationManyToMany = AnnotatedElementUtils.findMergedAnnotation(field, RelationManyToMany::class.java)
        return relationManyToMany != null
    }

    override fun isPrimary(
        field: Field,
        clazz: Class<*>?,
    ): Boolean {
        if (AnnotatedElementUtils.hasMetaAnnotationTypes(field, Id::class.java)) {
            return true
        }

        return BaseEntity.FIELD_ID == field.name
    }

    override fun isAutoIncrement(
        field: Field,
        clazz: Class<*>?,
    ): Boolean {
        if (!isPrimary(field, clazz)) {
            return false
        }

        val tableId = AnnotatedElementUtils.findMergedAnnotation(field, Id::class.java)
        if (tableId == null || tableId.keyType == KeyType.None) {
            // 判断全局配置
            val keyType = FlexGlobalConfig.getDefaultConfig().keyConfig.keyType

            return keyType === KeyType.Auto
        } else {
            return tableId.keyType == KeyType.Auto
        }
    }

    override fun customFieldTypeHandler(
        clazz: Class<*>?,
        field: Field,
    ): Class<*> {
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

    override fun getEnumValues(enumType: Class<*>): List<String> {
        if (!enumType.isEnum) {
            throw IllegalArgumentException("Class: ${enumType.getName()} 非枚举类型")
        }

        val enumDbValueFields: List<Field> = ClassUtil.getAllFields(enumType) { f -> f.getAnnotation(EnumValue::class.java) != null }

        if (enumDbValueFields.isEmpty()) {
            return enumType.enumConstants.map { "$it" }.toList()
        }

        val valField = enumDbValueFields.first()
        // 设置私有字段可访问
        valField.isAccessible = true

        return enumType.getEnumConstants()
            .map { enumConstant ->
                try {
                    return@map valField[enumConstant]
                } catch (e: IllegalAccessException) {
                    logger.error("获取枚举值失败: $enumType", e)
                    throw RuntimeException(e)
                }
            }
            .map(Objects::toString)
            .toList()
    }

    override fun scannerAnnotations(): List<Class<out Annotation>> {
        return listOf(Table::class.java)
    }

    override fun getTableName(clazz: Class<*>): String {
        val table = AnnotatedElementUtils.findMergedAnnotation(clazz, Table::class.java)
        if (table != null && table.value.isNotBlank()) {
            return table.value
        }

        return smartConvert(table != null && table.camelToUnderline, clazz.simpleName)
    }

    override fun getTableSchema(clazz: Class<*>): String? {
        val table = AnnotatedElementUtils.findMergedAnnotation(clazz, Table::class.java)
        if (table != null && table.schema.isNotBlank()) {
            return table.schema
        }

        val autoTable = AnnotatedElementUtils.findMergedAnnotation(clazz, AutoTable::class.java)
        if (autoTable != null && autoTable.schema.isNotBlank()) {
            return autoTable.schema
        }

        return super.getTableSchema(clazz)
    }

    override fun getRealColumnName(
        clazz: Class<*>,
        field: Field,
    ): String {
        val column = AnnotatedElementUtils.findMergedAnnotation(field, Column::class.java)
        if (column != null && column.value.isNotBlank() && !column.ignore) {
            return column.value.replace("`", "")
        }
        val tableId = AnnotatedElementUtils.findMergedAnnotation(field, Id::class.java)
        if (tableId != null && tableId.value.isNotBlank()) {
            return tableId.value.replace("`", "")
        }

        val table = AnnotatedElementUtils.findMergedAnnotation(clazz, Table::class.java)
        val camelToUnderline = table != null && table.camelToUnderline

        return smartConvert(camelToUnderline, field.name)
    }

    private fun smartConvert(
        camelToUnderline: Boolean,
        column: String,
    ): String {
        // 表上单独开启字段下划线申明
        if (mybatisFlexProperties.configuration.mapUnderscoreToCamelCase || camelToUnderline) {
            return StrUtil.toUnderlineCase(column)
        }

        return column
    }
}
