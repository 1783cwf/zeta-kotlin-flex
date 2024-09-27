
dependencies {

  api(project(":zeta-common:zeta-common-core"))
  api(project(":zeta-common:zeta-common-satoken"))

  api(libs.mybatisFlexStarter)
  api(libs.autoTableStarter)
  api(libs.mybatisFlexKotlin)
  annotationProcessor(libs.mybatisFlexProcessor)
}
