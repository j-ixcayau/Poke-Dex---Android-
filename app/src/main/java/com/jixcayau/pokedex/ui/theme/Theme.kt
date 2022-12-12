package com.jixcayau.pokedex.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val ColorPalette = lightColors(
    primary = Colors.PrimaryColor,
    primaryVariant = Colors.PrimaryColor,
    secondary = Colors.Secondary,
)

@Composable
fun PokeDexTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = ColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}