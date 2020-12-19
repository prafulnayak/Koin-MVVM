# Koin-MVVM
KOIN Dependency Injection over MVVM architecture  

# Add Dependency app level gradle
    //Room
    implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    implementation "androidx.room:room-ktx:$room_version"
    //Retrofit
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    // Koin AndroidX Scope features
    implementation "org.koin:koin-androidx-scope:$koin_version"
    // Koin AndroidX ViewModel features
    implementation "org.koin:koin-androidx-viewmodel:$koin_version"
    // Koin AndroidX Fragment features
    implementation "org.koin:koin-androidx-fragment:$koin_version"
    // Koin AndroidX WorkManager
    implementation "org.koin:koin-androidx-workmanager:$koin_version"
    // Koin AndroidX Jetpack Compose
    implementation "org.koin:koin-androidx-compose:$koin_version"
    // Koin AndroidX Experimental features
    implementation "org.koin:koin-androidx-ext:$koin_version"
    
    
# Project level gradle dependecy:
    ext.kotlin_version = "1.3.72"
    ext.koin_version = "2.2.1"
    ext.retrofit_version = "2.9.0"
    ext.room_version ="2.2.6"
dependencies {
        classpath "com.android.tools.build:gradle:4.1.1"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        classpath "org.koin:koin-gradle-plugin:$koin_version"
    }

# Plugings:
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'koin'
    id 'kotlin-kapt'
}
    
