package com.jixcayau.pokedex.features.teams.create.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jixcayau.pokedex.composables.*
import com.jixcayau.pokedex.domain.entities.Pokemon
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.utils.AppSpaces
import com.jixcayau.pokedex.utils.gesturesDisabled
import com.jixcayau.pokedex.utils.toCapitalize

@Composable
fun PokemonItemSelectable(
    pokemon: Pokemon,
    onTap: (Pokemon) -> Unit,
    isSelected: Boolean,
) {
    Card(
        elevation = AppSpaces.xxs.dp,
        modifier = Modifier
            .padding(
                AppSpaces.zero.dp,
                AppSpaces.xxs.dp,
            )
            .fillMaxWidth()
            .height(AppSpaces.xxl4.dp)
            .clickable {
                onTap(pokemon)
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
            LoadNetworkImage(
                url = pokemon.imageUrl,
                modifier = Modifier
                    .size(AppSpaces.xxl4.dp)
            )

            HorizontalSpace(AppSpaces.s)

            Label(
                value = pokemon.name.toCapitalize(),
                type = LabelType.Subtitle,
            )

            HorizontalSpace(
                AppSpaces.s,
                modifier = Modifier.weight(1F)
            )

            Checkbox(
                checked = isSelected,
                onCheckedChange = {
                    onTap(pokemon)
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Colors.Accent,
                )
            )
        }
    }
}