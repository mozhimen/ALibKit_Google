package com.mozhimen.libk.google.firebase.basic.optins

import com.mozhimen.libk.google.firebase.basic.FirebaseBasicMgr

/**
 * @ClassName OApiInit_InApplication_FirebaseBasicMgr
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/12
 * @Version 1.0
 */
/**
 * @see FirebaseBasicMgr
 */
@RequiresOptIn("The api need init FirebaseBasicMgr in application. 需要在Application初始化的API", RequiresOptIn.Level.WARNING)
annotation class OApiInit_InApplication_FirebaseBasicMgr
