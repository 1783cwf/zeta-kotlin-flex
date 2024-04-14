plugins {
  kotlin("jvm")
}

val zetaVersion: String by project
val zetaGroup: String by project
group = zetaGroup
version = zetaVersion

dependencies {

  api(project(":zeta-common:zeta-common-core"))
  api(project(":zeta-common:zeta-common-log"))

  api("org.springframework.boot:spring-boot-starter-data-redis")
  api("org.springframework.boot:spring-boot-starter-cache")
}

tasks.test {
  useJUnitPlatform()
}
