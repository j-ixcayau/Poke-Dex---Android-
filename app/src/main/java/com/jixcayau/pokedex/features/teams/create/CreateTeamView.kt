package com.jixcayau.pokedex.features.teams.create

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.jixcayau.pokedex.R
import com.jixcayau.pokedex.composables.*
import com.jixcayau.pokedex.domain.entities.Region
import com.jixcayau.pokedex.features.teams.create.composables.PokemonItemSelectable
import com.jixcayau.pokedex.utils.AppSpaces
import com.jixcayau.pokedex.utils.RoutesPath

@Composable
fun CreateTeamView(
    navController: NavHostController,
    region: Region?,
) {
    if (region == null) {
        navController.popBackStack()
        return
    }

    val viewModel = remember {
        CreateTeamViewModel()
    }

    if (viewModel.teamCreated) {
        viewModel.teamCreated = false
        navController.navigate(RoutesPath.Teams) {
            popUpTo(RoutesPath.Dashboard)
        }
    }

    BaseScaffold {
        Scaffold(
            topBar = {
                Appbar(
                    onBackTap = {
                        navController.popBackStack()
                    },
                    title = stringResource(R.string.createTeam_appbar),
                )
            },
        ) {
            BaseBody(
                modifier = Modifier.padding(it),
                allowScroll = false,
                children = {
                    Label(
                        value = stringResource(R.string.createTeam_title),
                        type = LabelType.Subtitle,
                        textAlign = TextAlign.Center,
                    )

                    VerticalSpace(AppSpaces.xxs)

                    Label(
                        value = stringResource(R.string.createTeam_subTitle),
                        textAlign = TextAlign.Center,
                    )

                    VerticalSpace(AppSpaces.m)

                    Label(
                        value = "${viewModel.pokemonsSelected.size} ${stringResource(R.string.createTeam_pokemonsSelected)}",
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth(),
                    )

                    LazyColumn(
                        modifier = Modifier.weight(1F),
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
                        text = stringResource(R.string.createTeam_createButton),
                        onTap = {
                            viewModel.createTeam(region)
                        },
                    )
                },
            )
        }
    }
}