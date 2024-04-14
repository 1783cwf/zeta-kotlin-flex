pluginManagement {

  val springBootVersion: String by settings
  val dependencyManagementVersion: String by settings
  val kotlinJvmVersion: String by settings
  val ktLintVersion: String by settings
  val bmuschkoDockerVersion: String by settings

  plugins {
    java

    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version dependencyManagementVersion
    id("org.jlleitschuh.gradle.ktlint") version ktLintVersion
    id("com.bmuschko.docker-remote-api") version bmuschkoDockerVersion
    kotlin("jvm") version kotlinJvmVersion
    kotlin("plugin.spring") version kotlinJvmVersion
    kotlin("kapt") version kotlinJvmVersion
  }

  repositories {
    maven("https://maven.aliyun.com/repository/gradle-plugin")
    maven("https://plugins.gradle.org/m2/")
    gradlePluginPortal()
  }
}

rootProject.name = "zeta-kotlin-flex"

include("zeta-admin")
include("zeta-module:zeta-module-system")
include("zeta-module:zeta-module-msg")
include("zeta-module:zeta-module-monitor")
include("zeta-common:zeta-common-core")
include("zeta-common:zeta-common-base")
include("zeta-common:zeta-common-log")
include("zeta-common:zeta-common-json")
include("zeta-common:zeta-common-mybatisflex")
include("zeta-common:zeta-common-redis")
include("zeta-common:zeta-common-satoken")
include("zeta-common:zeta-common-xss")
include("zeta-common:zeta-common-crypto")
include("zeta-common:zeta-common-desensitization")
include("zeta-common:zeta-common-file")
include("zeta-common:zeta-common-websocket")
