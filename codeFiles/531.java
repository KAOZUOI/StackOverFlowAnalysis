plugins {    id 'com.android.application' version '8.0.0-alpha11' apply false    id 'com.android.library' version '8.0.0-alpha11' apply false    id 'org.jetbrains.kotlin.android' version '1.8.0' apply false    id 'com.google.dagger.hilt.android' version '2.44.2' apply false}task clean(type: Delete) {    delete rootProject.buildDir}