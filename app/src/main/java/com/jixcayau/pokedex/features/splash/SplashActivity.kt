package com.jixcayau.pokedex.features.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.jixcayau.pokedex.features.auth.login.LoginActivity

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            View()
        }
    }

    @Composable
    private fun View() {
        SplashView(
            onComplete = { configNavigation() }
        )
    }

    private fun configNavigation() {
        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        finish()
    }
}