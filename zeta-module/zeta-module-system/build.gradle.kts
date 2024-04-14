plugins {
  kotlin("jvm")
}

val zetaVersion: String by project
val zetaGroup: String by project
group = zetaGroup
version = zetaVersion

dependencies {

  api(project(":zeta-common:zeta-common-base"))
  api(project(":zeta-common:zeta-common-log"))
  api(project(":zeta-common:zeta-common-websocket"))
  api(project(":zeta-common:zeta-common-crypto"))
  api(project(":zeta-common:zeta-common-desensitization"))
  api(project(":zeta-common:zeta-common-file"))

  api("com.github.whvcse:easy-captcha")
}

tasks.test {
  useJUnitPlatform()
}
