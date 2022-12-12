package com.jixcayau.pokedex.features.teams.list.composables

import com.jixcayau.pokedex.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jixcayau.pokedex.composables.HorizontalSpace
import com.jixcayau.pokedex.composables.Label
import com.jixcayau.pokedex.composables.LabelType
import com.jixcayau.pokedex.composables.VerticalSpace
import com.jixcayau.pokedex.domain.entities.Team
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.utils.AppSpaces
import com.jixcayau.pokedex.utils.toCapitalize

@Composable
fun TeamItem(
    team: Team,
    onTap: (Team) -> Unit,
) {
    Card(
        elevation = AppSpaces.xxs.dp,
        modifier = Modifier
            .padding(
                AppSpaces.xxs.dp,
            )
            .fillMaxWidth()
            .height(AppSpaces.xxl6.dp)
            .clickable {
                onTap(team)
            },
        backgroundColor = Colors.PrimaryColor,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(AppSpaces.xs.dp)
        ) {
            Column {
                Label(
                    value = team.name?.toCapitalize(),
                    type = LabelType.Subtitle,
                )

                VerticalSpace(
                    AppSpaces.xxs,
                )

                Label(
                    value = team.region?.name?.toCapitalize(),
                )
            }

            HorizontalSpace(
                AppSpaces.xxs,
                modifier = Modifier.weight(1F)
            )

            Label(
                value = "${team.pokemons?.size ?: 0}\n${stringResource(R.string.teams_teamPokemons)}",
                textAlign = TextAlign.Center,
            )
        }
    }
}