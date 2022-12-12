package com.jixcayau.pokedex.features.teams.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.jixcayau.pokedex.R
import com.jixcayau.pokedex.composables.*
import com.jixcayau.pokedex.domain.entities.Team
import com.jixcayau.pokedex.features.teams.detail.composables.DetailInfoLabel
import com.jixcayau.pokedex.features.teams.detail.composables.PokemonDetail
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.utils.AppSpaces
import com.jixcayau.pokedex.utils.RoutesPath

@Composable
fun TeamDetailView(
    navController: NavHostController,
    team: Team?,
) {
    if (team == null) {
        navController.popBackStack()
        return
    }

    val viewModel = remember {
        TeamDetailViewModel()
    }

    if (viewModel.teamDeleted) {
        viewModel.teamDeleted = false
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
                    title = stringResource(R.string.teamDetail_appbar),
                )
            },
        ) {
            BaseBody(
                modifier = Modifier.padding(it),
                children = {
                    Label(
                        value = team.name,
                        type = LabelType.Title,
                    )

                    VerticalSpace(AppSpaces.xs)

                    DetailInfoLabel(
                        title = R.string.teamDetail_name,
                        value = team.name,
                    )

                    VerticalSpace(AppSpaces.xs)

                    DetailInfoLabel(
                        title = R.string.teamDetail_number,
                        value = team.number,
                    )

                    VerticalSpace(AppSpaces.xs)

                    DetailInfoLabel(
                        title = R.string.teamDetail_type,
                        value = team.type,
                    )

                    VerticalSpace(AppSpaces.xs)

                    DetailInfoLabel(
                        title = R.string.teamDetail_region,
                        value = team.region?.name,
                    )

                    VerticalSpace(AppSpaces.xs)

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
                        AppSpaces.xs,
                        modifier = Modifier.weight(1F)
                    )

                    PokeButton(
                        text = stringResource(R.string.teamDetail_edit),
                        onTap = {

                        },
                    )

                    VerticalSpace(AppSpaces.xs)

                    PokeButton(
                        text = stringResource(R.string.teamDetail_delete),
                        onTap = {
                            viewModel.deleteTeam(team)
                        },
                        color = Colors.AuthAccentGradient,
                    )
                },
            )
        }
    }
}