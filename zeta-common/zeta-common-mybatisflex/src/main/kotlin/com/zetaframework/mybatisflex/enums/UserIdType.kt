package com.zetaframework.mybatisflex.enums

/**
 * 用户id类型
 *
 * 说明：
 * 关系到数据库表中的create_by和update_by类型。
 * @author gcc
 */
enum class UserIdType {
    /** int类型的id */
    Int,

    /** long类型的id */
    Long,

    /** String类型的id */
    String,
}
