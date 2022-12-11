package com.jixcayau.pokedex.features.teams.create

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jixcayau.pokedex.composables.*
import com.jixcayau.pokedex.features.teams.create.composables.PokemonItemSelectable
import com.jixcayau.pokedex.utils.AppSpaces

@Composable
fun CreateTeamView(
    navController: NavHostController,
    regionId: Int?,
) {
    if (regionId == null) {
        navController.popBackStack()
        return
    }

    val viewModel = remember {
        CreateTeamViewModel()
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
                allowScroll = false,
                children = {

                    Label(
                        value = "Selecciona los pokemones para crear tu equipo!",
                        type = LabelType.Subtitle,
                    )

                    VerticalSpace(AppSpaces.xxs)

                    Label(
                        value = "Puedes escoger de 3 a 6 pokemones para que te acompañen en tu aventura... Se sabio!",
                    )

                    VerticalSpace(AppSpaces.m)

                    LazyColumn(
                        modifier = Modifier
                            .weight(1F),
                    ) {
                        items(
                            count = viewModel.pokemons.size,
                            itemContent = { index ->
                                val pokemon = viewModel.pokemons[index]
                                PokemonItemSelectable(
                                    pokemon = pokemon,
                                    onTap = {
                                        viewModel.onPokemonTap(index)
                                    },
                                    isSelected = viewModel.isPokemonSelected(index),
                                )
                            },
                        )
                    }

                    PokeButton(
                        text = "Crear equipo",
                        onTap = {
                            viewModel.createTeam()
                        },
                    )
                },
            )
        }
    }
}