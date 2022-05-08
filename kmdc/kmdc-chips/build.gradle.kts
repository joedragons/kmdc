plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/chips"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(compose.web.svg)
        api(kmdc("core"))
        api(kmdc("touch-target"))
        api(mdc("chips"))
      }
    }
  }
}
