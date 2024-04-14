plugins {
  kotlin("jvm")
}

val zetaVersion: String by project
val zetaGroup: String by project
group = zetaGroup
version = zetaVersion

dependencies {
  api("org.springframework.boot:spring-boot-starter-aop")
  api(project(":zeta-common:zeta-common-core"))
  api(project(":zeta-common:zeta-common-json"))
  api(project(":zeta-common:zeta-common-satoken"))
}

tasks.test {
  useJUnitPlatform()
}
