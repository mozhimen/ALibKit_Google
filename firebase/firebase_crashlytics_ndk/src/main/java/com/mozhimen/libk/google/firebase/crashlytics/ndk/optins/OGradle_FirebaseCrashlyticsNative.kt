package com.mozhimen.libk.google.firebase.crashlytics.ndk.optins

/**
 * @ClassName OPlugin_ClassPath_GmsGoogleServices
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/12
 * @Version 1.0
 */
@RequiresOptIn("""
    在模块（应用级）Gradle 文件（通常为 app/build.gradle）中，添加 firebaseCrashlytics 扩展程序。

    android {
    // ...
        buildTypes {
            release {
                // Add this extension
                firebaseCrashlytics {
                    // Enable processing and uploading of native symbols to Firebase servers.
                    // By default, this is disabled to improve build speeds.
                    // This flag must be enabled to see properly-symbolicated native
                    // stack traces in the Crashlytics dashboard.
                    nativeSymbolUploadEnabled true
             }  
            }
        }
    }
""")
annotation class OGradle_FirebaseCrashlyticsNative
