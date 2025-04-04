package com.zetaframework.system.model.enums

/**
 * 授权类型
 * @author <a href="mailto:weistuday@gmail.com">caoweifeng</a>
 * @date 2024年03月31日 15:20
 */
enum class GrantTypeEnum(var serviceImpl: String) {
    /** 密码 */
    PASSWORD("passwordAuthStrategyImpl"),

    /** 短信 */
    SMS("smsAuthStrategyImpl"),

    /** 邮箱 */
    EMAIL("emailAuthStrategyImpl"),

    /** 三方授权 */
    SOCIAL("socialAuthStrategyImpl");

}
