

dependencies {

  constraints {
    rootProject.subprojects.filter { it.name != name && it.childProjects.isEmpty() }.forEach {
      api(project(it.path))
    }
    api(platform(rootProject.projectLibs.hutoolBom))
    api(platform(rootProject.projectLibs.saTokenBom))
    api(platform(rootProject.projectLibs.springBootDependencies))
    api(platform(rootProject.projectLibs.mybatisFlexBom))

    api(libs.mybatisFlexStarter)
    api(libs.mybatisFlexKotlin)
    api(libs.mybatisFlexProcessor)
    api(libs.autoTableStarter)
    api(libs.transmittableThreadLocal)
    api(libs.ip2region)
    api(libs.mapstructPlusSpringBootStarter)
    api(libs.aliyunSdkOss)
    api(libs.minio)
  }
}
