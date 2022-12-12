package com.jixcayau.pokedex.features.teams.list


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
import com.jixcayau.pokedex.domain.entities.toJson
import com.jixcayau.pokedex.features.teams.list.composables.TeamItem
import com.jixcayau.pokedex.utils.RoutesPath

@Composable
fun TeamsView(
    navController: NavHostController,
) {
    val viewModel = remember {
        TeamsViewModel()
    }

    BaseScaffold {
        Scaffold(
            topBar = {
                Appbar(
                    onBackTap = {
                        navController.popBackStack()
                    },
                    title = stringResource(R.string.teams_appbar),
                )
            },
        ) {
            BaseBody(
                modifier = Modifier.padding(it),
                children = {
                    Label(
                        value = stringResource(R.string.teams_title),
                        type = LabelType.Subtitle,
                        textAlign = TextAlign.Center,
                    )

                    LazyColumn(
                        modifier = Modifier.weight(1F),
                    ) {
                        items(
                            count = viewModel.teams.size,
                            itemContent = { index ->
                                val team = viewModel.teams[index]
                                TeamItem(
                                    team = team,
                                    onTap = {
                                        navController.navigate("${RoutesPath.TeamDetailToNavigate}${team.toJson()}")
                                    }
                                )
                            },
                        )
                    }
                },
            )
        }
    }
}