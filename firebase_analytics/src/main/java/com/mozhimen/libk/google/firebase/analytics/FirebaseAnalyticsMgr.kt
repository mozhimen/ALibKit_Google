package com.mozhimen.libk.google.firebase.analytics

import com.mozhimen.kotlin.lintk.optins.OApiInit_InApplication
import com.mozhimen.libk.google.firebase.basic.FirebaseBasicMgr
import com.mozhimen.libk.google.firebase.basic.optins.OAppRootPath_GoogleServicesJson
import com.mozhimen.libk.google.firebase.basic.optins.OPlugin_ClassPath_GmsGoogleServices

/**
 * @ClassName FirebaseAnalyticsMgr
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/19
 * @Version 1.0
 */
object FirebaseAnalyticsMgr {
    @OAppRootPath_GoogleServicesJson
    @OPlugin_ClassPath_GmsGoogleServices
    @OApiInit_InApplication
    @JvmStatic
    fun init() {
        FirebaseBasicMgr.init()
//        if (BuildConfig.DEBUG)
//            FirebaseAnalytics.firebaseAnalytics.setAnalyticsCollectionEnabled(false)
    }
}