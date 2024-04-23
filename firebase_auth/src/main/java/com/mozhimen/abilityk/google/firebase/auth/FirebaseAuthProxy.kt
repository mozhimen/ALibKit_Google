package com.mozhimen.abilityk.google.firebase.auth

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentSender
import android.util.Log
import com.mozhimen.basick.utilk.android.util.UtilKLogWrapper
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.LifecycleOwner
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mozhimen.basick.elemk.androidx.lifecycle.bases.BaseWakeBefDestroyLifecycleObserver
import com.mozhimen.basick.elemk.commons.IA_Listener
import com.mozhimen.basick.lintk.optins.OApiCall_BindLifecycle
import com.mozhimen.basick.lintk.optins.OApiCall_BindViewLifecycle
import com.mozhimen.basick.lintk.optins.OApiInit_ByLazy

/**
 * @ClassName FirebaseAuthProxy
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/10
 * @Version 1.0
 */
@OApiInit_ByLazy
@OApiCall_BindViewLifecycle
@OApiCall_BindLifecycle
class FirebaseAuthProxy(private var _componentActivity: ComponentActivity?, private val _serverClientId: String) : BaseWakeBefDestroyLifecycleObserver() {
    private lateinit var _auth: FirebaseAuth
    private lateinit var _signInClient: SignInClient
    private var _onUpdateUI: IA_Listener<FirebaseUser?>? = null
    private var _isOneTapSignIn: Boolean = false
    private var _signInLauncher: ActivityResultLauncher<IntentSenderRequest>? = _componentActivity!!.registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
        handleSignInResult(result.data)
    }

    //////////////////////////////////////////////////////////////////////////////////////

    fun isOneTapSignIn(boolean: Boolean) {
        _isOneTapSignIn = boolean
        UtilKLogWrapper.d(TAG, "isOneTapSignIn: $boolean")
    }

    fun setOnUpdateUI(block: IA_Listener<FirebaseUser?>) {
        _onUpdateUI = block
    }

    fun signIn() {
        val signInRequest = GetSignInIntentRequest.builder()
            .setServerClientId(_serverClientId)
            .build()

        _signInClient.getSignInIntent(signInRequest)
            .addOnSuccessListener { pendingIntent ->
                launchSignIn(pendingIntent)
            }
            .addOnFailureListener { e ->
                UtilKLogWrapper.e(TAG, "Google Sign-in failed", e)
            }
    }

    fun signOut() {
        // Firebase sign out
        _auth.signOut()

        // Google sign out
        _signInClient.signOut().addOnCompleteListener(_componentActivity!!) {
            updateUI(null)
        }
    }

    /*    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            when (requestCode) {
                CFirebaseAuth.REQUEST_ONE_TAP -> {
                    try {
                        val credential = signInClient.getSignInCredentialFromIntent(data)
                        val idToken = credential.googleIdToken
                        when {
                            idToken != null -> {
                                // Got an ID token from Google. Use it to authenticate
                                // with Firebase.
                                UtilKLogWrapper.d(TAG, "Got ID token.")

                                val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
                                auth.signInWithCredential(firebaseCredential)
                                    .addOnCompleteListener(_componentActivity) { task ->
                                        if (task.isSuccessful) {
                                            // Sign in success, update UI with the signed-in user's information
                                            UtilKLogWrapper.d(TAG, "signInWithCredential:success")
                                            val user = auth.currentUser
                                            updateUI(user)
                                        } else {
                                            // If sign in fails, display a message to the user.
                                            UtilKLogWrapper.w(TAG, "signInWithCredential:failure", task.exception)
                                            updateUI(null)
                                        }
                                    }
                            }

                            else -> {
                                // Shouldn't happen.
                                UtilKLogWrapper.d(TAG, "No ID token!")
                            }
                        }
                    } catch (e: ApiException) {
                        // ...
                    }
                }
            }
        }*/

    //////////////////////////////////////////////////////////////////////////////////////

    override fun onCreate(owner: LifecycleOwner) {
        // [START config_signin]
        // Configure Google Sign In
        _signInClient = Identity.getSignInClient(_componentActivity!!)

        // Initialize Firebase Auth
        _auth = Firebase.auth

        // Display One-Tap Sign In if user isn't logged in
        if (_isOneTapSignIn) {
            val currentUser = _auth.currentUser
            if (currentUser == null) {
                oneTapSignIn(_serverClientId)
            }
        }
    }

//    override fun onStart(owner: LifecycleOwner) {
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = _auth.currentUser
//        updateUI(currentUser)
//    }

    override fun onDestroy(owner: LifecycleOwner) {
        _onUpdateUI = null
        _signInLauncher = null
        _componentActivity = null
        super.onDestroy(owner)
    }

    //////////////////////////////////////////////////////////////////////////////////////

    private fun firebaseAuthWithGoogle(idToken: String) {
//        showProgressBar()
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        _auth.signInWithCredential(credential)
            .addOnCompleteListener(_componentActivity!!) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    UtilKLogWrapper.d(TAG, "signInWithCredential:success")
                    val user: FirebaseUser? = _auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    UtilKLogWrapper.w(TAG, "signInWithCredential:failure", task.exception)
//                    val view = binding.mainLayout
//                    Snackbar.make(view, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
                    updateUI(null)
                }

//                hideProgressBar()
            }
    }

    private fun handleSignInResult(data: Intent?) {
        // Result returned from launching the Sign In PendingIntent
        try {
            // Google Sign In was successful, authenticate with Firebase
            val credential = _signInClient.getSignInCredentialFromIntent(data)
            val idToken = credential.googleIdToken
            if (idToken != null) {
                UtilKLogWrapper.d(TAG, "firebaseAuthWithGoogle: ${credential.id}")
                firebaseAuthWithGoogle(idToken)
            } else {
                // Shouldn't happen.
                UtilKLogWrapper.d(TAG, "No ID token!")
            }
        } catch (e: ApiException) {
            // Google Sign In failed, update UI appropriately
            UtilKLogWrapper.w(TAG, "Google sign in failed", e)
            updateUI(null)
        }
    }

    private fun oneTapSignIn(serverClientId: String) {
        // Configure One Tap UI
        val oneTapRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(serverClientId)
                    .setFilterByAuthorizedAccounts(true)
                    .build(),
            )
            .build()

        // Display the One Tap UI
        _signInClient.beginSignIn(oneTapRequest)
            .addOnSuccessListener { result ->
                launchSignIn(result.pendingIntent)
            }
            .addOnFailureListener { e ->
                // No saved credentials found. Launch the One Tap sign-up flow, or
                // do nothing and continue presenting the signed-out UI.
            }
    }

    private fun updateUI(firebaseUser: FirebaseUser?) {
        _onUpdateUI?.invoke(firebaseUser)
    }

    private fun launchSignIn(pendingIntent: PendingIntent) {
        try {
            val intentSenderRequest = IntentSenderRequest.Builder(pendingIntent)
                .build()
            _signInLauncher?.launch(intentSenderRequest)
        } catch (e: IntentSender.SendIntentException) {
            UtilKLogWrapper.e(TAG, "Couldn't start Sign In: ${e.localizedMessage}")
        }
    }
}