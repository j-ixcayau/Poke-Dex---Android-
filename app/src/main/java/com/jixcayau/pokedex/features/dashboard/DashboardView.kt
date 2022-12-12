package com.jixcayau.pokedex.features.dashboard

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.jixcayau.pokedex.R
import com.jixcayau.pokedex.composables.*
import com.jixcayau.pokedex.features.dashboard.composables.CategoriesCard
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.utils.AppSpaces
import com.jixcayau.pokedex.utils.RoutesPath
import com.jixcayau.pokedex.utils.auth.FacebookAuthManager
import com.jixcayau.pokedex.utils.auth.GoogleAuthManager

@Composable
fun DashboardView(
    navController: NavHostController,
) {
    val context = LocalContext.current
    val googleAuthManager by remember {
        mutableStateOf(GoogleAuthManager(context))
    }

    BaseScaffold {
        Scaffold(
            topBar = {
                Appbar(
                    onBackTap = null,
                    title = stringResource(R.string.dashboard_appbar),
                )
            },
        ) {
            BaseBody(
                modifier = Modifier.padding(it),
                children = {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        CategoriesCard(
                            title = stringResource(R.string.dashboard_regions),
                            onTap = {
                                navController.navigate(RoutesPath.Regions)
                            },
                            color = Colors.regionCard,
                        )

                        CategoriesCard(
                            title = stringResource(R.string.dashboard_teams),
                            onTap = {
                                navController.navigate(RoutesPath.Teams)
                            },
                            color = Colors.TeamCard,
                        )
                    }

                    VerticalSpace(
                        AppSpaces.s,
                        modifier = Modifier.weight(1F)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        HorizontalSpace(
                            AppSpaces.zero,
                            modifier = Modifier.weight(0.5F)
                        )

                        CategoriesCard(
                            title = stringResource(R.string.dashboard_logout),
                            onTap = {
                                FacebookAuthManager.logout()
                                googleAuthManager.logout()

                                navController.navigate(RoutesPath.Login) {
                                    popUpTo(RoutesPath.Dashboard) {
                                        inclusive = true
                                    }
                                }
                            },
                            color = Colors.logOutCard,
                        )

                        HorizontalSpace(
                            AppSpaces.zero,
                            modifier = Modifier.weight(0.5F)
                        )
                    }
                },
            )
        }
    }
}