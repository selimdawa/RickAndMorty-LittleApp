plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.navigation.safeargs.kotlin)
    alias(libs.plugins.daggerHiltAndroid)
    alias(libs.plugins.ksp.processor)
}

android {
    namespace = "com.littleapp.rickandmorty"
    compileSdk {
       version = release(37)
    }

    defaultConfig {
        applicationId = "com.littleapp.rickandmorty"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.preference.ktx)           //Shared Preference
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //Layout
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material)
    //Image
    implementation(libs.circleimageview)                //Circle image
    implementation(libs.glide)            //Glide image
    implementation(libs.glide.transformations)           //Glide Blur
    implementation(libs.coil)    //Coil
    //NavComponents
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    //OkHttp
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    //Lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    //LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)
    //Other's
    implementation(libs.timber) //Timber Log
    implementation(libs.viewbindingpropertydelegate.noreflection)
}