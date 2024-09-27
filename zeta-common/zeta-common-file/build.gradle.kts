
dependencies {

  api(project(":zeta-common:zeta-common-core"))
  api(project(":zeta-common:zeta-common-json"))

  // oss相关
  api(libs.aliyunSdkOss)
  api(libs.minio)
}
