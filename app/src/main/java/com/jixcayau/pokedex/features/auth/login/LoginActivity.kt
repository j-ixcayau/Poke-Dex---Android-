package com.jixcayau.pokedex.features.auth.login

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

class LoginActivity : ComponentActivity() {

    private val viewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadRegions()

        setContent {
            View()
        }
    }

    @Composable
    private fun View() {
        LoginView(
            regions = viewModel.regions
        )
    }
}