package com.jixcayau.pokedex.utils.auth

import android.app.Activity
import android.util.Log
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class FacebookAuthManager(
    private val activity: Activity,
    private val callbackManager: CallbackManager,
) {
    private val emailPermission = "email"
    private val publicProfilePermission = "public_profile"

    private var manager: LoginManager = LoginManager.getInstance()

    fun launch(
        onAuthComplete: (AuthResult) -> Unit,
        onAuthError: (Exception) -> Unit,
        scope: CoroutineScope,
    ) {
        manager.logInWithReadPermissions(
            this.activity,
            listOf(
                emailPermission,
                publicProfilePermission,
            ),
        )

        manager.registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(result: LoginResult) {
                    try {
                        val credential =
                            FacebookAuthProvider.getCredential(result.accessToken.token)
                        scope.launch {
                            val authResult = Firebase.auth.signInWithCredential(credential).await()
                            onAuthComplete(authResult)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        onAuthError(e)
                    }
                }

                override fun onCancel() {
                    Log.d("FacebookAuth", "Cancel Login")
                }

                override fun onError(error: FacebookException) {
                    error.printStackTrace()

                    onAuthError(error)
                }
            },
        )
    }

    companion object {
        fun logout() {
            try {
                LoginManager.getInstance().logOut()
                Firebase.auth.signOut()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
