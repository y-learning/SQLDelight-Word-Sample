plugins {
    id("com.android.application")
    kotlin("android")
}

sqldelight {
    database("WordsDb") {
        packageName = "com.why.compose.sqldelight.words"
        sourceFolders = listOf("sql")
        schemaOutputDirectory = file("src/main/sqldelight/databases")
        dialect = "sqlite:3.25"
    }
}

dependencies {
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.lifecycle)
    implementation(Libs.AndroidX.vmLifecycle)

    implementation(Libs.AndroidMaterial.material)

    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.uiTooling)
    implementation(Libs.Compose.foundation)
    implementation(Libs.Compose.iconsCore)
    implementation(Libs.Compose.iconsExt)
    implementation(Libs.Compose.material)

    implementation(Libs.Y.core)
    implementation(Libs.Y.collections)

    implementation(Libs.Kotlinx.coroutines)

    implementation(Libs.SQLDelight.driver)

    implementation(Libs.SQLDelight.coroutineExt)

    testImplementation(Libs.Kotest.runner)
    testImplementation(Libs.Kotest.assertions)
    testImplementation(Libs.Kotest.property)

    testImplementation(Libs.Kotlinx.coroutinesTest)

    testImplementation(Libs.Compose.uiTestJUnit)
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        applicationId = "com.why.compose.sqldelight"
        minSdkVersion(22)
        targetSdkVersion(30)
        versionCode = 1
        versionName = Ci.publishVersion
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = Libs.jvmTarget
        useIR = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Compose.version
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
