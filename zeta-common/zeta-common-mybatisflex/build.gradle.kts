plugins {
  kotlin("jvm")
}

val zetaVersion: String by project
val zetaGroup: String by project
group = zetaGroup
version = zetaVersion

dependencies {

  api(project(":zeta-common:zeta-common-core"))
  api(project(":zeta-common:zeta-common-satoken"))

  api("com.mybatis-flex:mybatis-flex-spring-boot3-starter")
  api("com.mybatis-flex:mybatis-flex-kotlin-extensions")
  annotationProcessor("com.mybatis-flex:mybatis-flex-processor")
}

tasks.test {
  useJUnitPlatform()
}
