import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.6.10"
  id("org.jetbrains.compose") version "1.1.0"
}

group = "me.dmarchuk"
version = "1.0.0"

repositories {
  google()
  mavenCentral()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
  testImplementation(kotlin("test"))
  implementation(compose.desktop.currentOs)
  implementation("io.github.microutils:kotlin-logging-jvm:2.1.20")
}

tasks {
  test {
    useJUnitPlatform()
  }
  withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
  }
}

compose.desktop {
  application {
    mainClass = "MainKt"
    jvmArgs("-ea")
    nativeDistributions {
      targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
      packageName = rootProject.name
      packageVersion = version as String
    }
  }
}
