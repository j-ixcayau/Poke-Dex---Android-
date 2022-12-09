package com.jixcayau.pokedex.features.auth.register


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jixcayau.pokedex.features.auth.composables.AuthBody

@Composable
fun RegisterView(
    navController: NavHostController,
) {
    AuthBody(
        onBackTap = {
            navController.popBackStack()
        },
        actionTitle = "Ya tienes cuenta?",
        actionButtonText = "Inicia sesión",
        actionOnTap = {
            navController.popBackStack()
        },
        content = {

        }
    )
}

@Composable
private fun Content() {
    RegisterView(
        navController = rememberNavController(),
    )
}


@Preview
@Composable
private fun ContentPreview() {
    Content()
}