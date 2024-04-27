plugins {

  idea
  id("org.springframework.boot")
  id("org.jlleitschuh.gradle.ktlint")
  id("io.spring.dependency-management")
  id("com.bmuschko.docker-remote-api")
  kotlin("jvm")
  kotlin("plugin.spring")
  kotlin("kapt")
}

val zetaGroup: String by project
val zetaVersion: String by project
group = zetaGroup
version = zetaVersion

val jvmVersion = JavaVersion.VERSION_21

val springBootVersion: String by project
val saTokenBomVersion: String by project
val hutoolBomVersion: String by project
val mybatisFlexVersion: String by project
val mybatisFlexKotlinVersion: String by project
val aliyunSdkOssVersion: String by project
val minioVersion: String by project
val poiVersion: String by project
val easyExcelVersion: String by project
val easyCaptchaVersion: String by project
val transmittableThreadLocalVersion: String by project
val ip2regionVersion: String by project
val aizudaMonitorVersion: String by project
val mapstructPlusVersion: String by project

allprojects {
  repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
  }
}

/**
 * 子模块配置，不包括最外层build
 */
subprojects {

  apply(plugin = "org.springframework.boot")
  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "kotlin")
  apply(plugin = "org.jetbrains.kotlin.plugin.spring")
  apply(plugin = "org.jetbrains.kotlin.jvm")
  apply(plugin = "org.jetbrains.kotlin.kapt")
  apply(plugin = "org.jlleitschuh.gradle.ktlint")
  apply(plugin = "com.bmuschko.docker-remote-api")

  java {
    withSourcesJar()
    withJavadocJar()
    /**
     * 源码JDK版本
     */
    java.sourceCompatibility = jvmVersion
    /**
     * 编译后字节码可运行环境的版本
     */
    java.targetCompatibility = jvmVersion
  }

  /**
   * 子模块标准依赖
   * 所有子模块都会拥有此处配置的依赖
   */
  dependencies {
    kapt("io.github.linpeilie:mapstruct-plus-processor:$mapstructPlusVersion")
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
      exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
  }

  dependencyManagement {
    imports {
      mavenBom("cn.dev33:sa-token-bom:$saTokenBomVersion")
      mavenBom("cn.hutool:hutool-bom:$hutoolBomVersion")
    }

    dependencies {
      dependency("org.springframework.boot:spring-boot-starter-web:$springBootVersion") {
        exclude("org.springframework.boot:spring-boot-starter-tomcat")
      }

      // orm
      dependency("com.mybatis-flex:mybatis-flex-spring-boot3-starter:$mybatisFlexVersion")
      dependency("com.mybatis-flex:mybatis-flex-kotlin-extensions:$mybatisFlexKotlinVersion")

      // oss
      dependency("com.aliyun.oss:aliyun-sdk-oss:$aliyunSdkOssVersion")
      dependency("io.minio:minio:$minioVersion")

      // 监控
      dependency("com.aizuda:aizuda-monitor:$aizudaMonitorVersion")

      // utils
      dependency("org.lionsoul:ip2region:$ip2regionVersion")
      dependency("com.alibaba:transmittable-thread-local:$transmittableThreadLocalVersion")
      dependency("com.github.whvcse:easy-captcha:$easyCaptchaVersion")
      dependency("io.github.linpeilie:mapstruct-plus-spring-boot-starter:$mapstructPlusVersion")
      dependency("io.github.linpeilie:mapstruct-plus-processor:$mapstructPlusVersion")

      // excel相关
      dependency("org.apache.poi:poi:$poiVersion")
      dependency("org.apache.poi:poi-ooxml:$poiVersion")
      dependency("com.alibaba:easyexcel:$easyExcelVersion") {
        exclude("org.apache.poi:poi-ooxml-schemas")
      }
    }
  }

  tasks {

    /**
     * kotlin编译
     */
    compileKotlin {
      kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = jvmVersion.majorVersion
      }
    }

    compileJava{
      /*
       * https://www.mapstruct.plus/guide/configuration.html mapstruct-plus编译器配置项
       *
       * 1. unmappedSourcePolicy: 当来源类中没有对应属性时的策略，默认忽略
       * 2. unmappedTargetPolicy: 当目标类中没有对应属性时的策略，默认忽略
       */
      options.compilerArgs.add("-Amapstruct.plus.unmappedSourcePolicy=IGNORE")
      options.compilerArgs.add("-Amapstruct.plus.unmappedTargetPolicy=IGNORE")
    }

    test {
      useJUnitPlatform()
    }

    /**
     * 通用服务包只打包成Jar不通过SpringBootJar特殊处理
     */
    if (
      project.name.startsWith("zeta-common") ||
      project.name.startsWith("zeta-module") ||
      Regex("(api|service|web|sdk)\$").containsMatchIn(project.name)
    ) {
      bootJar {
        enabled = false
        archiveBaseName.set(project.name)
      }
      jar {
        enabled = true
        archiveBaseName.set(project.name)
      }
    }

    if (project.name == "zeta-admin") {
      bootJar {
        enabled = true
        archiveBaseName.set(project.name)
        layered {
          enabled = true
        }
      }
    }
  }
}
