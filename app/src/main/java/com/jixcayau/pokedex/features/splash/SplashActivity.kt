package com.jixcayau.pokedex.features.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jixcayau.pokedex.features.main.MainActivity

class SplashActivity : ComponentActivity() {

    private var user: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        user = Firebase.auth.currentUser

        setContent {
            View()
        }
    }

    @Composable
    private fun View() {
        SplashView(
            onComplete = {
                configNavigation()
            },
        )
    }

    private fun configNavigation() {
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        intent.putExtra(MainActivity.IsUserLogged, user != null)
        startActivity(intent)

        finish()
    }
}