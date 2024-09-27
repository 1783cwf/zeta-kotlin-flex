import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {

  idea
  `java-library`
  alias(projectLibs.plugins.springBoot)
  alias(projectLibs.plugins.ktlint)
  alias(projectLibs.plugins.dependencyManagement)
  alias(projectLibs.plugins.bmuschkoDocker)
  alias(projectLibs.plugins.kotlin)
  alias(projectLibs.plugins.kotlinSpring)
  alias(projectLibs.plugins.kotlinkapt)
}

tasks {
  bootJar { enabled = false }
  jar { enabled = false }
}

java {
  /**
   * 源码JDK版本
   */
  sourceCompatibility = JavaVersion.VERSION_21
  /**
   * 编译后字节码可运行环境的版本
   */
  targetCompatibility = JavaVersion.VERSION_21
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(21))
  }

  withSourcesJar()
  withJavadocJar()
}

kotlin {
  compilerOptions {
    apiVersion.set(KotlinVersion.KOTLIN_2_0)
    jvmTarget.set(JvmTarget.JVM_21)
    freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=all-compatibility")
  }

}

/**
 * 总体项目配置(包括最外层build配置)
 */
allprojects {

  if (childProjects.isNotEmpty()) return@allprojects

  apply(plugin = "idea")

  repositories {
    maven("https://repo.huaweicloud.com/repository/maven")
    mavenCentral()
  }

  if (project.name.contains("dependencies")) {
    apply(plugin = "java-platform")
  } else {
    apply(plugin = "java-library")
  }

}

/**
 * 子模块配置(不包括最外层build配置)
 */
subprojects{

  // dependencies 单独配置
  if (project.name.contains("dependencies") || childProjects.isNotEmpty()) return@subprojects

  apply(plugin = rootProject.projectLibs.plugins.springBoot.get().pluginId)
  apply(plugin = rootProject.projectLibs.plugins.dependencyManagement.get().pluginId)
  apply(plugin = rootProject.projectLibs.plugins.ktlint.get().pluginId)
  apply(plugin = rootProject.projectLibs.plugins.kotlin.get().pluginId)
  apply(plugin = rootProject.projectLibs.plugins.kotlinkapt.get().pluginId)
  apply(plugin = rootProject.projectLibs.plugins.kotlinSpring.get().pluginId)

  tasks {
    bootJar {
      enabled = false
      archiveClassifier = ""
    }

    jar {
      enabled = true
      archiveClassifier = ""
      manifest {
        attributes["Implementation-Title"] = project.name
        attributes["Implementation-Version"] = project.version
        attributes["Implementation-Vendor-Id"] = project.group
        attributes["Implementation-Vendor"] = "zeta kotlin flex"
      }
      doFirst {
        println("当前制品: [${project.group}:${project.name}:${project.version}]")
      }
    }

    test {
      useJUnitPlatform()
    }

    withType<JavaCompile> {
      options.compilerArgs.add("-Xlint:deprecation")
      options.compilerArgs.add("-Xlint:unchecked")
    }

  }

  dependencies{
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))
    kapt("com.mybatis-flex:mybatis-flex-processor")
    kapt(rootProject.projectLibs.mapstructPlusProcessor)
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
  }

  dependencyManagement{
    imports {
      mavenBom(rootProject.projectLibs.springBootDependencies.get().toString())
      mavenBom(rootProject.projectLibs.saTokenBom.get().toString())
      mavenBom(rootProject.projectLibs.hutoolBom.get().toString())
      mavenBom(rootProject.projectLibs.mybatisFlexBom.get().toString())
    }
  }
}
