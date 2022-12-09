package com.jixcayau.pokedex.features.auth.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jixcayau.pokedex.R
import com.jixcayau.pokedex.composables.*
import com.jixcayau.pokedex.features.auth.composables.AuthBody
import com.jixcayau.pokedex.utils.AppSpaces
import com.jixcayau.pokedex.utils.RoutesPath

@Composable
fun LoginView(
    navController: NavHostController,
) {
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    AuthBody(
        isLoading = false,
        onBackTap = null,
        actionTitle = stringResource(R.string.dont_have_account_yet),
        actionButtonText = stringResource(R.string.sign_in),
        actionOnTap = {
            navController.navigate(RoutesPath.Register)
        },
        content = {
            VerticalSpace(AppSpaces.l)

            Label(
                value = stringResource(R.string.login_title),
                type = LabelType.Title,
            )

            VerticalSpace(AppSpaces.s)

            Label(
                value = stringResource(R.string.login_subtitle),
                type = LabelType.Subtitle,
            )

            VerticalSpace(AppSpaces.xl)

            Input(
                value = emailValue,
                title = R.string.email,
                type = InputType.Email,
            )

            VerticalSpace(AppSpaces.s)

            Input(
                value = passwordValue,
                title = R.string.password,
                type = InputType.Password,
            )

            VerticalSpace(AppSpaces.m)

            PokeButton(
                text = "Iniciar sesión",
                onTap = {
                    navController.navigate(RoutesPath.Dashboard) {
                        popUpTo(RoutesPath.Login) {
                            inclusive = true
                        }
                    }
                }
            )
        },
    )
}

@Preview
@Composable
private fun ContentPreview() {
    LoginView(
        navController = rememberNavController(),
    )
}