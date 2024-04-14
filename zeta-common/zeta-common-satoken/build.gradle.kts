plugins {
  kotlin("jvm")
}

val zetaVersion: String by project
val zetaGroup: String by project
group = zetaGroup
version = zetaVersion

dependencies {

  api(project(":zeta-common:zeta-common-core"))
  api(project(":zeta-common:zeta-common-json"))

  api("cn.dev33:sa-token-spring-boot3-starter")
  api("cn.dev33:sa-token-redis-jackson")
  api("cn.dev33:sa-token-spring-aop")
  api("cn.dev33:sa-token-jwt")
}

tasks.test {
  useJUnitPlatform()
}
