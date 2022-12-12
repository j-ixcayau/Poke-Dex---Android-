package com.jixcayau.pokedex.features.dashboard

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.jixcayau.pokedex.R
import com.jixcayau.pokedex.composables.*
import com.jixcayau.pokedex.features.dashboard.composables.CategoriesCard
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.utils.RoutesPath

@Composable
fun DashboardView(
    navController: NavHostController,
) {
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
                },
            )
        }
    }
}