plugins {
  alias(libs.plugins.kotlin)
}

/**
 * 打开指定类
 */

dependencies {

  api("org.springframework.boot:spring-boot-starter")
  api("org.springframework.boot:spring-boot-starter-undertow")
  api("org.springframework.boot:spring-boot-starter-validation")
  api("org.springframework.boot:spring-boot-starter-web") {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
  }

  api("cn.hutool:hutool-core")
  api("cn.hutool:hutool-http")
  api("cn.hutool:hutool-extra")

  api(libs.transmittableThreadLocal)
  api(libs.ip2region)
  api(libs.mapstructPlusSpringBootStarter)
}
