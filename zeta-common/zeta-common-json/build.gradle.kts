plugins {
  kotlin("jvm")
}

val zetaVersion: String by project
val zetaGroup: String by project
group = zetaGroup
version = zetaVersion

dependencies {
  api(project(":zeta-common:zeta-common-core"))
  // json相关
  api("com.fasterxml.jackson.module:jackson-module-kotlin")
  api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
  api("com.fasterxml.jackson.core:jackson-databind")
}

tasks.test {
  useJUnitPlatform()
}
