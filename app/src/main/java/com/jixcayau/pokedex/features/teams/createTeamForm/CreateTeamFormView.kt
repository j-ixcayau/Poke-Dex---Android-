package com.jixcayau.pokedex.features.teams.createTeamForm

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.jixcayau.pokedex.R
import com.jixcayau.pokedex.composables.*
import com.jixcayau.pokedex.domain.entities.Team
import com.jixcayau.pokedex.features.teams.detail.composables.PokemonDetail
import com.jixcayau.pokedex.utils.AppSpaces
import com.jixcayau.pokedex.utils.RoutesPath

@Composable
fun CreateTeamFormView(
    navController: NavHostController,
    team: Team?,
) {
    if (team == null) {
        navController.popBackStack()
        return
    }

    val viewModel = remember {
        CreateTeamFormViewModel()
    }

    if (viewModel.teamCreated) {
        viewModel.teamCreated = false
        navController.navigate(RoutesPath.Teams) {
            popUpTo(RoutesPath.Dashboard)
        }
    }

    val nameValue = remember { mutableStateOf("") }
    val numberValue = remember { mutableStateOf("") }
    val typeValue = remember { mutableStateOf("") }

    BaseScaffold {
        Scaffold(
            topBar = {
                Appbar(
                    onBackTap = {
                        navController.popBackStack()
                    },
                    title = stringResource(R.string.createTeamForm_appbar),
                )
            },
        ) {
            BaseBody(
                modifier = Modifier.padding(it),
                allowScroll = true,
                children = {
                    Label(
                        value = stringResource(R.string.createTeamForm_title),
                        type = LabelType.Subtitle,
                        textAlign = TextAlign.Center,
                    )


                    VerticalSpace(AppSpaces.xl)

                    Input(
                        value = nameValue,
                        title = R.string.createTeamForm_name,
                    )

                    VerticalSpace(AppSpaces.s)

                    Input(
                        value = numberValue,
                        title = R.string.createTeamForm_number,
                    )

                    VerticalSpace(AppSpaces.s)

                    Input(
                        value = typeValue,
                        title = R.string.createTeamForm_type,
                    )

                    VerticalSpace(AppSpaces.s)

                    team.pokemons?.let {
                        Label(
                            value = stringResource(R.string.teamDetail_pokemons),
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth(),
                        )

                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            items(
                                count = it.size,
                                itemContent = { index ->
                                    val pokemon = it[index]
                                    PokemonDetail(
                                        pokemon = pokemon,
                                    )
                                },
                            )
                        }
                    }

                    VerticalSpace(
                        AppSpaces.l,
                        modifier = Modifier.weight(1F)
                    )

                    PokeButton(
                        text = stringResource(R.string.createTeam_createButton),
                        onTap = {
                            viewModel.createTeam(
                                team,
                                nameValue.value,
                                numberValue.value,
                                typeValue.value,
                            )
                        },
                    )
                },
            )
        }
    }
}