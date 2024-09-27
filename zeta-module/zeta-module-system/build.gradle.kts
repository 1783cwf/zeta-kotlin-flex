
dependencies {

  api(project(":zeta-common:zeta-common-base"))
  api(project(":zeta-common:zeta-common-log"))
  api(project(":zeta-common:zeta-common-websocket"))
  api(project(":zeta-common:zeta-common-crypto"))
  api(project(":zeta-common:zeta-common-desensitization"))
  api(project(":zeta-common:zeta-common-file"))

  api(libs.easyCaptcha)
}
