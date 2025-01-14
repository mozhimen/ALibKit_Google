package com.mozhimen.libk.google.firebase.crashlytics.optins

/**
 * @ClassName OBuildApp_NeedManifestPlaceholders
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/5
 * @Version 1.0
 */
@RequiresOptIn(
    """
buildTypes {
    release {
        minifyEnabled true
        shrinkResources true
        // Zipalign优化
        zipAlignEnabled true
        proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        // 设置是否要自动上传
        firebaseCrashlytics {
            mappingFileUploadEnabled true
        }
    }
 
    debug {
        proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        minifyEnabled false
        versionNameSuffix "_debug"
 
    }
""", RequiresOptIn.Level.WARNING
)
annotation class OBuildApp_NeedMappingFileConfig