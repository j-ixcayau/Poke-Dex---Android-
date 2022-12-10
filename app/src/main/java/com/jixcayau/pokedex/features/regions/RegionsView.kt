package com.jixcayau.pokedex.features.regions

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jixcayau.pokedex.composables.*
import com.jixcayau.pokedex.features.regions.composables.RegionItem
import com.jixcayau.pokedex.utils.AppSpaces
import com.jixcayau.pokedex.utils.RoutesPath

@Composable
fun RegionsView(
    navController: NavHostController,
) {
    val viewModel = remember {
        RegionsViewModel()
    }
    viewModel.loadRegions()

    BaseScaffold {
        Scaffold(
            topBar = {
                Appbar(
                    onBackTap = {
                        navController.popBackStack()
                    },
                    title = "Regiones",
                )
            },
        ) {
            BaseBody(
                modifier = Modifier.padding(it),
                children = {

                    Label(
                        value = "Selecciona una región para crear un nuevo equipo",
                        type = LabelType.Subtitle,
                    )

                    VerticalSpace(AppSpaces.l)

                    for (region in viewModel.regions) {
                        RegionItem(
                            region = region,
                            onTap = {
                                navController.navigate("${RoutesPath.CreateTeamToNavigate}${region.id}")
                            },
                        )
                    }
                },
            )
        }
    }
}

