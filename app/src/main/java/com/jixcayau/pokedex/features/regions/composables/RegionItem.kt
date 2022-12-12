package com.jixcayau.pokedex.features.regions.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jixcayau.pokedex.composables.Label
import com.jixcayau.pokedex.composables.LabelType
import com.jixcayau.pokedex.domain.entities.Region
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.utils.AppSpaces
import com.jixcayau.pokedex.utils.toCapitalize

@Composable
fun RegionItem(
    region: Region,
    onTap: (Region) -> Unit,
) {
    Card(
        elevation = AppSpaces.xxs.dp,
        modifier = Modifier
            .padding(
                AppSpaces.zero.dp,
                AppSpaces.xxs.dp,
            )
            .fillMaxWidth()
            .height(AppSpaces.xxl3.dp)
            .clickable {
                onTap(region)
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
            Label(
                value = region.name?.toCapitalize(),
                type = LabelType.Subtitle,
            )
        }
    }
}