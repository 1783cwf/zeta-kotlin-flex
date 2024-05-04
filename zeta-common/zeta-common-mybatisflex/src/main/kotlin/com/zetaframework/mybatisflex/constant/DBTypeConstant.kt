package com.zetaframework.mybatisflex.constant

/**
 * 通用数据库类型
 * @author <a href="mailto:weistuday@gmail.com">caoweifeng</a>
 * @date 2024年04月27日 20:17
 */
object DBTypeConstant {
    /**
     * 整数
     */
    const val INT: String = "int"
    const val BIGINT: String = "bigint"

    /**
     * 小数
     */
    const val DOUBLE: String = "double"
    const val DECIMAL: String = "decimal"

    /**
     * 字符串
     */
    const val CHAR: String = "char"
    const val VARCHAR: String = "varchar"
    const val TEXT: String = "text"

    /**
     * 日期
     */
    const val DATE: String = "date"
    const val DATETIME: String = "datetime"
    const val TIMESTAMP: String = "timestamp"

    /**
     * 二进制
     */
    const val BIT: String = "bit"
    const val BLOB: String = "blob"

    /**
     * 布尔值
     */
    const val BOOLEAN: String = "boolean"
    const val BOOL: String = "bool"

    /**
     * json
     */
    const val JSON: String = "json"

    /**
     * mysql 数据库类型
     */
    const val TINYINT: String = "tinyint"
}
