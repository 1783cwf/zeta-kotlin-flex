plugins {
  kotlin("jvm") version "1.9.22"
}
val zetaVersion: String by project
val zetaGroup: String by project
group = zetaGroup
version = zetaVersion

/**
 * 打开指定类
 */

dependencies {
  api("org.springframework.boot:spring-boot-starter")
  api("org.springframework.boot:spring-boot-starter-undertow")
  api("org.springframework.boot:spring-boot-starter-validation")
  api("org.springframework.boot:spring-boot-starter-web")

  api("cn.hutool:hutool-core")
  api("cn.hutool:hutool-http")
  api("cn.hutool:hutool-extra")

  api("com.alibaba:transmittable-thread-local")

  api("org.lionsoul:ip2region")

  api("io.github.linpeilie:mapstruct-plus-spring-boot-starter")
}
