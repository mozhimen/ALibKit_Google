package com.mozhimen.libk.google.firebase.config

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
import com.mozhimen.basick.elemk.commons.I_Listener
import com.mozhimen.basick.utilk.android.util.UtilKLogWrapper
import com.mozhimen.basick.utilk.commons.IUtilK

/**
 * @ClassName FirebaseConfig
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/27
 * @Version 1.0
 */
object FirebaseConfig : IUtilK {
    private val _firebaseConfig: FirebaseRemoteConfig by lazy {
        // [START shared_app_measurement]
        // Obtain the FirebaseAnalytics instance.
        Firebase.remoteConfig
        // [END shared_app_measurement]
    }
    val firebaseConfig get() = _firebaseConfig

    private val _onConfigUpdateListeners: MutableList<I_Listener> = mutableListOf()

    //////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun setDefaultsAsync(@XmlRes intResXml: Int) {
        // Set default Remote Config parameter values. An app uses the in-app default values, and
        // when you need to adjust those defaults, you set an updated value for only the values you
        // want to change in the Firebase console. See Best Practices in the README for more
        // information.
        // [START set_default_values]
        _firebaseConfig.setDefaultsAsync(intResXml)
        // [END set_default_values]
    }

    @JvmStatic
    fun addOnConfigUpdateListener(listener: I_Listener) {
        if (_onConfigUpdateListeners.isEmpty()) {
            _firebaseConfig.addOnConfigUpdateListener(object : ConfigUpdateListener {
                override fun onUpdate(configUpdate: ConfigUpdate) {
                    _onConfigUpdateListeners.forEach { it.invoke() }
                }

                override fun onError(error: FirebaseRemoteConfigException) {
                    UtilKLogWrapper.e(TAG, "onError: code ${error.code} cause ${error.cause} msg ${error.message}")
                }
            })
        }
        _onConfigUpdateListeners.add(listener)
    }

    @JvmStatic
    fun removeOnConfigUpdateListener(listener: I_Listener) {
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

}