import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.6"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("com.bmuschko.docker-spring-boot-application") version "7.1.0"
	kotlin("jvm") version "1.5.31"
	kotlin("plugin.spring") version "1.5.31"
	kotlin("plugin.jpa") version "1.5.31"
}

group = "de.cku.sglh"
version = "0.0.3"
java.sourceCompatibility = JavaVersion.VERSION_16

fun imageTag(name: String, version: Any = "latest"): String {
	return "docker.bananamonster.de/$name:$version"
}

docker {
	springBootApplication {
		baseImage.set("openjdk:16-alpine")
		ports.set(listOf(8080))
		images.set(setOf(imageTag("corvin/eventplanner", project.version), imageTag("corvin/eventplanner", "latest")))
		jvmArgs.set(listOf("-Dspring.profiles.active=production", "-Xmx2048m"))
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// spring stuff
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.5.5")
	implementation("org.springframework.boot:spring-boot-starter-freemarker:2.5.5")
	implementation("org.springframework.boot:spring-boot-starter-web:2.5.5")
	//serialization
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
	//kt
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.21")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.21")
	//logging
	implementation("io.github.microutils:kotlin-logging-jvm:2.0.11")
	//database
	implementation("org.liquibase:liquibase-core:4.4.3")
	runtimeOnly("com.h2database:h2:1.4.200")
	//tests
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.5")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
