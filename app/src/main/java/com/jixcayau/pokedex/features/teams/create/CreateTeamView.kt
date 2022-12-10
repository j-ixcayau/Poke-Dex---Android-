package com.jixcayau.pokedex.features.teams.create

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jixcayau.pokedex.composables.*

@Composable
fun CreateTeamView(
    navController: NavHostController,
    regionId: Int?,
) {

    if (regionId == null) {
        navController.popBackStack()
    }

    BaseScaffold {
        Scaffold(
            topBar = {
                Appbar(
                    onBackTap = {
                        navController.popBackStack()
                    },
                    title = "Crear Equipo",
                )
            },
        ) {
            BaseBody(
                modifier = Modifier.padding(it),
                children = {

                    Label(
                        value = "Equipo: ${regionId.toString()}",
                        type = LabelType.Title,
                    )
                },
            )
        }
    }
}