plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"
val botClass = "bot.MyFirstBot"

repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.robocode.tankroyale:robocode-tankroyale-bot-api:0.14.0")
}

tasks.withType(Jar::class) {
    manifest {
        attributes["Manifest-Version"] = "1.0"
        attributes["Main-Class"] = botClass
    }
}

application {
    mainClass.set(botClass)
}

tasks.test {
    useJUnitPlatform()
}
