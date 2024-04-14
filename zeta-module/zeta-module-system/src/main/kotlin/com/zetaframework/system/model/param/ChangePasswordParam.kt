package com.zetaframework.system.model.param

import jakarta.validation.constraints.NotBlank

/**
 * 修改密码参数
 * @author gcc
 */

data class ChangePasswordParam(
    /** 旧密码 */

    @get:NotBlank(message = "旧密码不能为空")
    var oldPwd: String? = null,
    /** 新密码 */

    @get:NotBlank(message = "新密码不能为空")
    var newPwd: String? = null,
)
