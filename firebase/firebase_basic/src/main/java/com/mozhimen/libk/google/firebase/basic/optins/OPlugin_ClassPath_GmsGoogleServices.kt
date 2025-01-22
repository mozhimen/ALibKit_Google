package com.mozhimen.libk.google.firebase.basic.optins

/**
 * @ClassName OPlugin_ClassPath_GmsGoogleServices
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/12
 * @Version 1.0
 */
@RequiresOptIn("""
为了确保 Firebase SDK 可以访问 google-services.json 配置文件中的值，您需要具有 Google 服务 Gradle 插件 (google-services)。
在您的根级（项目级）Gradle 文件（<project>/build.gradle.kts 或 <project>/build.gradle）中，将 Google 服务插件添加为依赖项：

```Groovy
plugins {
  id 'com.android.application' version '7.2.0' apply false
  // ...

  // Add the dependency for the Google services Gradle plugin
  id 'com.google.gms.google-services' version '4.3.15' apply false
}
```

在您的模块（应用级）Gradle 文件（通常是 <project>/<app-module>/build.gradle.kts 或 <project>/<app-module>/build.gradle）中，添加 Google 服务插件：

```Groovy
plugins {
  id 'com.android.application'
  // ...
  
  // Add the Google services Gradle plugin
  id 'com.google.gms.google-services'
}
```
""")
annotation class OPlugin_ClassPath_GmsGoogleServices
