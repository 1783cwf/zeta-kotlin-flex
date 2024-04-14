plugins {
  kotlin("jvm")
}

val zetaVersion: String by project
val zetaGroup: String by project
group = zetaGroup
version = zetaVersion

dependencies {

  api(project(":zeta-common:zeta-common-core"))

  api("cn.hutool:hutool-crypto")
}

tasks.test {
  useJUnitPlatform()
}
