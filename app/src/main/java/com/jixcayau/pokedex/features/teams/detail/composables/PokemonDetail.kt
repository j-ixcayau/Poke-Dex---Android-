package com.jixcayau.pokedex.features.teams.detail.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jixcayau.pokedex.composables.HorizontalSpace
import com.jixcayau.pokedex.composables.Label
import com.jixcayau.pokedex.composables.LabelType
import com.jixcayau.pokedex.composables.LoadNetworkImage
import com.jixcayau.pokedex.domain.entities.Pokemon
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.utils.AppSpaces
import com.jixcayau.pokedex.utils.toCapitalize

@Composable
fun PokemonDetail(
    pokemon: Pokemon,
) {
    Card(
        elevation = AppSpaces.xxs.dp,
        modifier = Modifier
            .padding(
                AppSpaces.xxs.dp,
            )
            .height(AppSpaces.xxl7c.dp),
        backgroundColor = Colors.PrimaryColor,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    AppSpaces.xxs.dp,
                )
        ) {
            LoadNetworkImage(
                url = pokemon.imageUrl,
                modifier = Modifier.size(AppSpaces.xxl64.dp),
            )

            HorizontalSpace(AppSpaces.s)

            Label(
                value = pokemon.name?.toCapitalize(),
                type = LabelType.Subtitle,
            )
        }
    }
}