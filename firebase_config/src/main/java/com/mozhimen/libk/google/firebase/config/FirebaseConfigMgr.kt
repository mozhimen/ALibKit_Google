package com.mozhimen.libk.google.firebase.config

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.mozhimen.libk.google.firebase.basic.optins.OApiInit_InApplication_FirebaseBasicMgr

/**
 * @ClassName FirebaseConfigMgr
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/27
 * @Version 1.0
 */
object FirebaseConfigMgr {
    /**
     * 默认10分钟刷新一次
     */
    @JvmStatic
    @OApiInit_InApplication_FirebaseBasicMgr
    fun init(minimumFetchIntervalInSeconds: Long = 600L) {
        // Get Remote Config instance.
        // [START get_remote_config_instance]
        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        // [END get_remote_config_instance]

        // Create a Remote Config Setting to enable developer mode, which you can use to increase
        // the number of fetches available per hour during development. Also use Remote Config
        // Setting to set the minimum fetch interval.
        // [START enable_dev_mode]
        val configSettings = remoteConfigSettings {
            setMinimumFetchIntervalInSeconds(minimumFetchIntervalInSeconds)
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        // [END enable_dev_mode]
    }
}