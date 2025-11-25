plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.tech.instafun"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.tech.instafun"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        buildFeatures.buildConfig = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "API_KEY", "\"${project.properties["API_KEY"]}\"")
        buildConfigField("String", "BASE_URL", "\"${project.properties["BASE_URL"]}\"")
    }

    buildTypes {
        release {
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
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
        //buildConfig = true
    }
}

dependencies {

//    implementation "com.google.dagger:hilt-android:2.51.1"
//    kapt "com.google.dagger:hilt-compiler:2.51.1"
    implementation(libs.hilt.android)
    implementation(libs.material3)
    implementation(libs.ads.mobile.sdk)
    implementation(libs.androidx.constraintlayout)

    implementation("com.squareup.retrofit2:retrofit:3.0.0")
    implementation("com.squareup.retrofit2:converter-gson:3.0.0")
    implementation("com.google.code.gson:gson:2.13.2")
    implementation("com.squareup.okhttp3:okhttp:5.3.2")
    implementation("com.squareup.okhttp3:logging-interceptor:5.3.2")

    implementation("androidx.hilt:hilt-navigation-compose:1.3.0")

    // ExoPlayer
    //caching
    // implementation("androidx.media3:media3-exoplayer-cache:1.8.0")
    implementation("androidx.media3:media3-exoplayer-dash:1.8.0")
    //implementation("androidx.media3:media3-exoplayer-hls:1.8.0")

// Accompanist Pager
    implementation("com.google.accompanist:accompanist-pager:0.36.0")

    //glide
    implementation("com.github.bumptech.glide:glide:5.0.5")

    implementation("com.github.skydoves:landscapist-glide:2.1.11")

    //constaints
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.1")
    implementation("androidx.compose.foundation:foundation:1.9.5")



    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    // ExoPlayer
    implementation(libs.androidx.media3.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}