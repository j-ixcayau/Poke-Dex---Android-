package com.jixcayau.pokedex.extensions

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.jixcayau.pokedex.ui.theme.Colors

fun Modifier.splashBackground() =
    this.background(
        brush = Brush.horizontalGradient(
            colors = listOf(
                Colors.Accent,
                Colors.AuthAccentGradient,
            )
        )
    )