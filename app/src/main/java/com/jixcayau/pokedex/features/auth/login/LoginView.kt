package com.jixcayau.pokedex.features.auth.login

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.facebook.CallbackManager
import com.jixcayau.pokedex.R
import com.jixcayau.pokedex.composables.*
import com.jixcayau.pokedex.features.auth.composables.AuthBody
import com.jixcayau.pokedex.features.auth.composables.SocialButton
import com.jixcayau.pokedex.utils.AppSpaces
import com.jixcayau.pokedex.utils.RoutesPath
import com.jixcayau.pokedex.utils.auth.FacebookAuthManager
import com.jixcayau.pokedex.utils.auth.GoogleAuthManager

@Composable
fun LoginView(
    navController: NavHostController,
    activity: Activity,
    callbackManager: CallbackManager,
) {
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    val context = LocalContext.current

    // Google Auth
    val googleAuthManager by remember {
        mutableStateOf(GoogleAuthManager(context))
    }
    val googleLauncher = googleAuthManager.rememberFirebaseAuthLauncher(
        onAuthComplete = {
            navigateToDashboard(navController)
        },
        onAuthError = {
            Log.d("error", "error")
        },
    )

    // Facebook Auth
    val facebookAuthManager by remember {
        mutableStateOf(FacebookAuthManager(activity, callbackManager))
    }
    val facebookScope = rememberCoroutineScope()

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
                text = stringResource(R.string.login_button),
                onTap = {

                },
            )

            VerticalSpace(AppSpaces.m)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                SocialButton(
                    iconId = R.drawable.ic_facebook_logo,
                    onTap = {
                        facebookAuthManager.launch(
                            onAuthComplete = {
                                navigateToDashboard(navController)
                            },
                            onAuthError = {

                            },
                            scope = facebookScope
                        )
                    },
                )

                HorizontalSpace(AppSpaces.m)

                SocialButton(
                    iconId = R.drawable.ic_google_logo,
                    onTap = {
                        googleLauncher.launch(googleAuthManager.getIntent())
                    },
                )
            }

            VerticalSpace(AppSpaces.m)
        },
    )
}

private fun navigateToDashboard(navController: NavHostController) {
    navController.navigate(RoutesPath.Dashboard) {
        popUpTo(RoutesPath.Login) {
            inclusive = true
        }
    }
}