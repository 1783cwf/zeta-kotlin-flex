package com.zetaframework.mybatisflex.annotation

import com.tangzc.autotable.annotation.ColumnComment
import com.tangzc.autotable.annotation.ColumnDefault
import com.tangzc.autotable.annotation.ColumnNotNull
import com.tangzc.autotable.annotation.ColumnType
import com.tangzc.autotable.annotation.enums.DefaultValueEnum
import org.springframework.core.annotation.AliasFor

/**
 * 列聚合注解
 * @author caoweifeng
 * @date 2024年04月27日 20:17
 * @email weistuday@gmail.com
 */
@Target(AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@ColumnType
@ColumnNotNull
@ColumnDefault
@ColumnComment("")
annotation class ColumnDefine(
    /**
     * 字段类型：不填默认使用属性的数据类型进行转换，转换失败的字段不会添加
     *
     * @return 字段类型
     */
    @get:AliasFor(annotation = ColumnType::class, attribute = "value")
    val type: String = "",
    /**
     * 字段长度,默认是-1，小于0相当于null
     *
     * @return 默认字段长度
     */
    @get:AliasFor(annotation = ColumnType::class, attribute = "length")
    val length: Int = -1,
    /**
     * 小数点长度，默认是-1，小于0相当于null
     *
     * @return 小数点长度
     */
    @get:AliasFor(annotation = ColumnType::class, attribute = "decimalLength")
    val decimalLength: Int = -1,
    /**
     * 是否为可以为null，true是可以，false是不可以，默认为true
     *
     * @return 是否为可以为null，true是不可以，false是可以，默认为false
     */
    @get:AliasFor(annotation = ColumnNotNull::class, attribute = "value")
    val notNull: Boolean = false,
    /**
     * 默认值，默认为null
     *
     * @return 默认值
     */
    @get:AliasFor(
        annotation = ColumnDefault::class,
        attribute = "type",
    )
    val defaultValueType: DefaultValueEnum = DefaultValueEnum.UNDEFINED,
    /**
     * 默认值，默认为null
     *
     * @return 默认值
     */
    @get:AliasFor(annotation = ColumnDefault::class, attribute = "value")
    val defaultValue: String = "",
    /**
     * 数据表字段备注
     *
     * @return 默认值，默认为空
     */
    @get:AliasFor(annotation = ColumnComment::class, attribute = "value")
    val comment: String = "",
)
