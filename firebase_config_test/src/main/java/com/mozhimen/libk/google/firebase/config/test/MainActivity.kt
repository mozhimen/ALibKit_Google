package com.mozhimen.libk.google.firebase.config.test

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.mozhimen.bindk.bases.activity.viewbinding.BaseActivityVB
import com.mozhimen.kotlin.lintk.optins.OApiInit_InApplication
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.libk.google.firebase.basic.FirebaseBasicMgr
import com.mozhimen.libk.google.firebase.basic.optins.OApiInit_InApplication_FirebaseBasicMgr
import com.mozhimen.libk.google.firebase.basic.optins.OAppRootPath_GoogleServicesJson
import com.mozhimen.libk.google.firebase.basic.optins.OPlugin_ClassPath_GmsGoogleServices
import com.mozhimen.libk.google.firebase.config.FirebaseConfigMgr
import com.mozhimen.libk.google.firebase.config.test.databinding.ActivityMainBinding

class MainActivity : BaseActivityVB<ActivityMainBinding>() {

    companion object {
        private const val LOADING_PHRASE_CONFIG_KEY = "loading_phrase"
        private const val WELCOME_MESSAGE_KEY = "welcome_message"
        private const val WELCOME_MESSAGE_CAPS_KEY = "welcome_message_caps"
    }

    //////////////////////////////////////////////////////////////////////////

    @OptIn(OApiInit_InApplication_FirebaseBasicMgr::class, OPlugin_ClassPath_GmsGoogleServices::class, OAppRootPath_GoogleServicesJson::class, OApiInit_InApplication::class)
    override fun initView(savedInstanceState: Bundle?) {
        vb.fetchButton.setOnClickListener {
            fetchWelcome()
        }

        FirebaseBasicMgr.init()
        FirebaseConfigMgr.init()
        FirebaseConfigMgr.setDefaultsAsync(R.xml.remote_config_defaults)
        FirebaseConfigMgr.addOnConfigUpdateListener { configUpdate ->
            Log.d(TAG, "Updated keys: " + configUpdate.updatedKeys)
            if (configUpdate.updatedKeys.contains(WELCOME_MESSAGE_KEY)) {
                FirebaseConfigMgr.activate().addOnCompleteListener {
                    displayWelcomeMessage()
                }
            }
        }
        fetchWelcome()
    }

    private fun fetchWelcome() {
        displayWelcomeMessage()
        FirebaseConfigMgr.fetchAndActivate()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val updated = task.result
                    Log.d(TAG, "Config params updated: $updated")
                    "Fetch and activate succeeded".showToast()
                } else {
                    "Fetch failed".showToast()
                }
                displayWelcomeMessage()
            }
    }

    private fun displayWelcomeMessage() {
        vb.welcomeTextView.isAllCaps = FirebaseConfigMgr.firebaseConfig[WELCOME_MESSAGE_CAPS_KEY].asBoolean()
        vb.welcomeTextView.text = FirebaseConfigMgr.firebaseConfig[WELCOME_MESSAGE_KEY].asString()
    }
}
