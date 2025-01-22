package com.mozhimen.libk.google.firebase.config

import androidx.annotation.IntRange
import androidx.annotation.XmlRes
import com.google.android.gms.tasks.Task
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ConfigUpdate
import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.libk.google.firebase.basic.optins.OApiInit_InApplication_FirebaseBasicMgr

/**
 * @ClassName FirebaseConfigMgr
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/27
 * @Version 1.0
 */
object FirebaseConfigMgr : IUtilK {
    private val _firebaseConfig: FirebaseRemoteConfig by lazy {
        // [START shared_app_measurement]
        // Obtain the FirebaseAnalytics instance.
        Firebase.remoteConfig
        // [END shared_app_measurement]
    }
    val firebaseConfig get() = _firebaseConfig

    private val _onConfigUpdateListeners: MutableList<IA_Listener<ConfigUpdate>> = mutableListOf()

    //////////////////////////////////////////////////////////////////////

    /**
     * 默认10分钟刷新一次
     */
    @JvmStatic
    @OApiInit_InApplication_FirebaseBasicMgr
    fun init(@IntRange(from = 600L) minimumFetchIntervalInSeconds: Long = 600L) {
        val configSettings = remoteConfigSettings {
            setMinimumFetchIntervalInSeconds(minimumFetchIntervalInSeconds)
        }
        _firebaseConfig.setConfigSettingsAsync(configSettings)
    }

    //////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun setDefaultsAsync(@XmlRes intResXml: Int) {
        _firebaseConfig.setDefaultsAsync(intResXml)
    }

    @JvmStatic
    fun addOnConfigUpdateListener(listener: IA_Listener<ConfigUpdate>) {
        if (_onConfigUpdateListeners.isEmpty()) {
            _firebaseConfig.addOnConfigUpdateListener(object : ConfigUpdateListener {
                override fun onUpdate(configUpdate: ConfigUpdate) {
                    _onConfigUpdateListeners.forEach { it.invoke(configUpdate) }
                }

                override fun onError(error: FirebaseRemoteConfigException) {
                    UtilKLogWrapper.e(TAG, "onError: code ${error.code} cause ${error.cause} msg ${error.message}")
                }
            })
        }
        _onConfigUpdateListeners.add(listener)
    }

    @JvmStatic
    fun removeOnConfigUpdateListener(listener: IA_Listener<ConfigUpdate>) {
        _onConfigUpdateListeners.remove(listener)
    }

    @JvmStatic
    fun clearOnConfigUpdateListeners() {
        _onConfigUpdateListeners.clear()
    }

    //////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getFirebaseRemoteConfigValue(key: String): FirebaseRemoteConfigValue =
        _firebaseConfig[key]

    @JvmStatic
    fun getString(key: String): String =
        _firebaseConfig.getString(key)

    @JvmStatic
    fun getBoolean(key: String): Boolean =
        _firebaseConfig.getBoolean(key)

    @JvmStatic
    fun getLong(key: String): Long =
        _firebaseConfig.getLong(key)

    @JvmStatic
    fun getDouble(key: String): Double =
        _firebaseConfig.getDouble(key)

    //////////////////////////////////////////////////////////////////////

    /**
     * xxx.addOnCompleteListener(this) { task ->
     *         if (task.isSuccessful) {
     *             val updated = task.result
     *             Log.d(TAG, "Config params updated: $updated")
     *             Toast.makeText(this,"Fetch and activate succeeded",Toast.LENGTH_SHORT,).show()
     *         } else {
     *             Toast.makeText(this,"Fetch failed",Toast.LENGTH_SHORT,).show()
     *         }
     *         displayWelcomeMessage()
     * }
     */
    @JvmStatic
    fun fetchAndActivate(): Task<Boolean> =
        _firebaseConfig.fetchAndActivate()

    @JvmStatic
    fun activate(): Task<Boolean> =
        _firebaseConfig.activate()
}