import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage
import com.bmuschko.gradle.docker.tasks.image.DockerPushImage

plugins {
  kotlin("jvm")
}

val zetaVersion: String by project
val zetaGroup: String by project
group = zetaGroup
version = zetaVersion

// 镜像仓库地址
val dockerRegistry: String by project
// 镜像命名空间
val dockerNamespace: String by project
// 镜像名称
val imageName = "$dockerRegistry/$dockerNamespace/${project.name}:${System.currentTimeMillis()}"

dependencies {
  implementation(project(":zeta-module:zeta-module-monitor"))
  implementation(project(":zeta-module:zeta-module-msg"))
  implementation(project(":zeta-module:zeta-module-system"))

  // 数据库相关
  implementation("org.apache.commons:commons-pool2")
  implementation("com.mysql:mysql-connector-j")
  implementation("com.zaxxer:HikariCP")
}

tasks {
  test {
    useJUnitPlatform()
  }

  docker {

    // 配置docker认证信息
    registryCredentials {
      url.set(dockerRegistry)
      // 从环境变量中取出认证信息
      username.set(System.getenv("DOCKER_USER"))
      password.set(System.getenv("DOCKER_PASSWORD"))
    }
  }

  register("buildDockerImage", DockerBuildImage::class) {
    group = "docker"
    dependsOn("build")

    images.set(listOf(imageName))
    inputDir.set(file("./"))
    buildArgs.set(mapOf("JAR_FILE" to "build/libs/${project.name}-${project.version}.jar"))
    dockerFile.set(file("Dockerfile"))
  }

  register("pushDockerImage", DockerPushImage::class) {
    group = "docker"
    dependsOn("buildDockerImage")
    images.set(listOf(imageName))
  }
}
