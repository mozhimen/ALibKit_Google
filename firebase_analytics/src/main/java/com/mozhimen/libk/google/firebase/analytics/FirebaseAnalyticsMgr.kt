package com.mozhimen.libk.google.firebase.analytics

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.mozhimen.libk.google.firebase.analytics.helpers.LogEventProvider
import com.mozhimen.libk.google.firebase.basic.optins.OApiInit_InApplication_FirebaseBasicMgr

/**
 * @ClassName FirebaseAnalyticsProxy
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/12
 * @Version 1.0
 */
@OApiInit_InApplication_FirebaseBasicMgr
object FirebaseAnalyticsMgr {
    /**
     * The `FirebaseAnalytics` used to record screen views.
     */
    // [START declare_analytics]
    private val _firebaseAnalytics: FirebaseAnalytics by lazy {
        // [START shared_app_measurement]
        // Obtain the FirebaseAnalytics instance.
        Firebase.analytics
        // [END shared_app_measurement]
    }
    val firebaseAnalytics get() = _firebaseAnalytics
    // [END declare_analytics]

    private val _logEventProvider: LogEventProvider by lazy { LogEventProvider(_firebaseAnalytics) }

    //////////////////////////////////////////////////////////////////////

    //设置用户ID
    fun setUserId(userId: String) {
        _firebaseAnalytics.setUserId(userId)
    }

    //设置用户偏好
    fun setUserProperty(name: String, value: String) {
        _firebaseAnalytics.setUserProperty(name, value)
    }

    //自定义事件
    fun logEventProvider(): LogEventProvider =
        _logEventProvider

    //设置默认事件参数
    fun setDefaultEventParameters(parameters: Bundle) {
        _firebaseAnalytics.setDefaultEventParameters(parameters)
    }
}