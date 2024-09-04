package com.mozhimen.libk.google.firebase.basic

import com.mozhimen.kotlin.lintk.optins.OApiInit_InApplication
import com.mozhimen.libk.google.firebase.basic.optins.OAppRootPath_GoogleServicesJson
import com.mozhimen.libk.google.firebase.basic.optins.OPlugin_ClassPath_GmsGoogleServices

/**
 * @ClassName FirebaseBasicMgr
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/12
 * @Version 1.0
 */
object FirebaseBasicMgr {
    @OAppRootPath_GoogleServicesJson
    @OPlugin_ClassPath_GmsGoogleServices
    @OApiInit_InApplication
    @JvmStatic
    fun init() {
    }
}