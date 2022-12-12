package com.jixcayau.pokedex.features.dashboard.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jixcayau.pokedex.composables.Clickable
import com.jixcayau.pokedex.composables.Label
import com.jixcayau.pokedex.composables.LabelType
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.utils.AppSpaces

@Composable
fun RowScope.CategoriesCard(
    title: String,
    onTap: () -> Unit,
    color: Color,
) {
    Clickable(
        onTap = onTap,
        radius = AppSpaces.zero,
        child = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Label(
                    value = title,
                    type = LabelType.Subtitle,
                    color = Colors.White,
                )
            }
        },
        modifier = Modifier
            .weight(1F)
            .padding(AppSpaces.xs.dp)
            .clip(RoundedCornerShape(AppSpaces.xs.dp))
            .background(color)
            .padding(AppSpaces.s.dp)
            .height(AppSpaces.xxl2.dp),
    )
}