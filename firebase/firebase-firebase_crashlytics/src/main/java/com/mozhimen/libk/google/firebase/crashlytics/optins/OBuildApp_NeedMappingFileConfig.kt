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
            mappingFileUploadEnabled true//设置代理
        }
    }
 
     /**
    设置代理
    使用VPN后我们还需要去ide中配置代理
根据提示，在gradle.properties文件中加上代理设置即可
```
#代理的主机地址，如果是你自己电脑开的vpn软件，那么可以填写127.0.0.1
systemProp.https.proxyHost=127.0.0.1
#代理的端口地址，vpn软件中即可查看
systemProp.https.proxyPort=****
```
开启vpn后，再将代理配置好后即可打realse包而不再报错
    **/
    
    debug {
        minifyEnabled false
        proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        firebaseCrashlytics {
            mappingFileUploadEnabled false
        }
    }
""", RequiresOptIn.Level.WARNING
)
annotation class OBuildApp_NeedMappingFileConfig