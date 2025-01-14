package com.mozhimen.libk.google.firebase.crashlytics.optins

/**
 * @ClassName OPlugin_ClassPath_GmsGoogleServices
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/12
 * @Version 1.0
 */
@RequiresOptIn("""
    在您的根级（项目级）Gradle 文件 (<project>/build.gradle) 中，将 Crashlytics Gradle 插件添加为 buildscript 依赖项：
    
    dependencies {
        ...
        // Make sure that you have the Google services Gradle plugin dependency
        classpath 'com.google.gms:google-services:4.3.15'

        // Add the dependency for the Crashlytics Gradle plugin
        classpath 'com.google.firebase:firebase-crashlytics-gradle:2.9.5'
    }
    
    在您的模块（应用级）Gradle 文件（通常是 <project>/<app-module>/build.gradle）中，添加 Crashlytics Gradle 插件：

    plugins {
        id 'com.android.application'
    
        // Make sure that you have the Google services Gradle plugin
        id 'com.google.gms.google-services'
    
        // Add the Crashlytics Gradle plugin
        id 'com.google.firebase.crashlytics'
        ...
    }
""")
annotation class OPlugin_ClassPath_FirebaseCrashlytics
