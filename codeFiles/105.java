plugins {    id 'java'    id 'org.springframework.boot' version '3.0.1-SNAPSHOT'    id 'io.spring.dependency-management' version '1.1.0'    id &quot;org.springdoc.openapi-gradle-plugin&quot; version &quot;1.6.0&quot;}group = 'com.sampleproject'sourceCompatibility = '17'repositories {    mavenCentral()    maven { url 'https://repo.spring.io/milestone' }    maven { url 'https://repo.spring.io/snapshot' }}dependencies {    implementation 'org.springframework.boot:spring-boot-starter-web'    testImplementation 'org.springframework.boot:spring-boot-starter-test'}tasks.named('test') {    useJUnitPlatform()}