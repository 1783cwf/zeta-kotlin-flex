plugins {
  kotlin("jvm")
}

val zetaVersion: String by project
val zetaGroup: String by project
group = zetaGroup
version = zetaVersion

dependencies {

  api(project(":zeta-common:zeta-common-base"))
  api("com.aizuda:aizuda-monitor")
}

tasks.test {
  useJUnitPlatform()
}
