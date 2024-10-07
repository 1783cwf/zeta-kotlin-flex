pluginManagement {

  repositories {
    maven("https://maven.aliyun.com/repository/gradle-plugin")
    mavenCentral()
  }
}
dependencyResolutionManagement{

  versionCatalogs {
    create("projectLibs") {
      from(files("gradle/libs.versions.toml"))
    }
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
include("zeta-common:zeta-common-autotable")
include("zeta-common:zeta-common-redis")
include("zeta-common:zeta-common-satoken")
include("zeta-common:zeta-common-xss")
include("zeta-common:zeta-common-crypto")
include("zeta-common:zeta-common-desensitization")
include("zeta-common:zeta-common-file")
include("zeta-common:zeta-common-websocket")
include("zeta-common:zeta-dependencies")
