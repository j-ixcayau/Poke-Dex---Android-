package com.jixcayau.pokedex.features.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jixcayau.pokedex.features.auth.login.LoginView
import com.jixcayau.pokedex.utils.RoutesPath

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            View()
        }
    }

    @Composable
    private fun View() {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = RoutesPath.Login,
        ) {
            composable(RoutesPath.Login) {
                LoginView()
            }
        }
    }
}