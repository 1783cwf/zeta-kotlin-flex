plugins {
  kotlin("jvm")
}

val zetaVersion: String by project
val zetaGroup: String by project
group = zetaGroup
version = zetaVersion

dependencies {

  api(project(":zeta-common:zeta-common-core"))

  api("org.springframework.boot:spring-boot-starter-websocket")
}

tasks.test {
  useJUnitPlatform()
}
