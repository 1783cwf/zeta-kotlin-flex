plugins {
  kotlin("jvm")
}

val zetaVersion: String by project
val zetaGroup: String by project
group = zetaGroup
version = zetaVersion

dependencies {

  api(project(":zeta-common:zeta-common-core"))
  api(project(":zeta-common:zeta-common-json"))

  // oss相关
  api("com.aliyun.oss:aliyun-sdk-oss")
  api("io.minio:minio")
}

tasks.test {
  useJUnitPlatform()
}
