plugins {
  alias(libs.plugins.kotlin)
}

dependencies {
  api(project(":zeta-common:zeta-common-core"))
  api(project(":zeta-common:zeta-common-mybatisflex"))
  api(project(":zeta-common:zeta-common-redis"))
}

tasks.test {
  useJUnitPlatform()
}
