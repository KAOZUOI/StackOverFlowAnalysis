buildscript {    repositories {        maven { url = repoUrl }    }    dependencies {        classpath(group: 'org.springframework.boot', name: 'spring-boot-gradle-plugin', version: '3.0.2')    }}apply plugin: 'org.springframework.boot'apply plugin: 'io.spring.dependency-management'dependencies {implementation(group: 'org.springframework.boot', name: 'spring-boot-starter-jetty')implementation(group: 'org.springframework.boot', name: 'spring-boot-starter-web')implementation(group: 'org.springframework.boot', name: 'spring-boot-starter-jdbc')implementation(group: 'org.springframework.boot', name: 'spring-boot-starter-actuator')implementation(group: 'org.springframework.cloud', name: 'spring-cloud-starter')implementation(group: 'org.springframework.boot', name: 'spring-boot-starter-data-redis') {        exclude group: 'io.lettuce', module: 'lettuce-core'    }    implementation(group: 'redis.clients', name: 'jedis')}