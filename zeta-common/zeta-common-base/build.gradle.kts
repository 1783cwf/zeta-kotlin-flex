plugins {
  kotlin("jvm")
}

val zetaVersion: String by project
val zetaGroup: String by project
group = zetaGroup
version = zetaVersion

dependencies {
  api(project(":zeta-common:zeta-common-core"))
  api(project(":zeta-common:zeta-common-mybatisflex"))
  api(project(":zeta-common:zeta-common-redis"))
}

tasks.test {
  useJUnitPlatform()
}
