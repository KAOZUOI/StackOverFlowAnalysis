subprojects {    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile) {        kotlinOptions.jvmTarget = &quot;17&quot;    }}