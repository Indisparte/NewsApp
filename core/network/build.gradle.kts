plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("nowinandroid.android.hilt")
    id("kotlinx-serialization")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies{
    implementation(project(":core:common"))
    implementation(project(":core:model"))
}