package com.zetaframework.mybatisflex.constant

/**
 * @author <a href="mailto:weistuday@gmail.com">caoweifeng</a>
 * @date 2024年04月27日 20:17
 */
object DBTypeConstant {
    /**
     * 整数
     */
    const val INT: String = "int"
    const val TINYINT: String = "tinyint"
    const val SMALLINT: String = "smallint"
    const val MEDIUMINT: String = "mediumint"
    const val BIGINT: String = "bigint"

    /**
     * 小数
     */
    const val FLOAT: String = "float"
    const val DOUBLE: String = "double"
    const val DECIMAL: String = "decimal"

    /**
     * 字符串
     */
    const val CHAR: String = "char"
    const val VARCHAR: String = "varchar"
    const val TEXT: String = "text"
    const val TINYTEXT: String = "tinytext"
    const val MEDIUMTEXT: String = "mediumtext"
    const val LONGTEXT: String = "longtext"

    /**
     * 枚举
     */
    const val ENUM: String = "enum"
    const val SET: String = "set"

    /**
     * 日期
     */
    const val YEAR: String = "year"
    const val TIME: String = "time"
    const val DATE: String = "date"
    const val DATETIME: String = "datetime"
    const val TIMESTAMP: String = "timestamp"

    /**
     * 二进制
     */
    const val BIT: String = "bit"
    const val BINARY: String = "binary"
    const val VARBINARY: String = "varbinary"
    const val BLOB: String = "blob"
    const val TINYBLOB: String = "tinyblob"
    const val MEDIUMBLOB: String = "mediumblob"
    const val LONGBLOB: String = "longblob"

    /**
     * json
     */
    const val JSON: String = "json"
}
