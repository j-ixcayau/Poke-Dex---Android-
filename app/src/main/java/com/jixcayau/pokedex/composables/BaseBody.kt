package com.jixcayau.pokedex.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.ui.theme.PokeDexTheme

@Composable
fun BaseBody(
    modifier: Modifier = Modifier,
    allowScroll: Boolean = true,
    children: @Composable ColumnScope.() -> Unit,
    color: Color = Colors.PrimaryColor
) {
    PokeDexTheme {
        Surface(
            color = color,
            modifier = Modifier.fillMaxSize()
        ) {
            var newModifier = modifier
            if (allowScroll) {
                newModifier = modifier.verticalScroll(rememberScrollState())
            }

            Column(
                modifier = newModifier
                    .fillMaxSize()
                    .background(
                        color = color,
                    ),
            ) {
                children()
            }
        }
    }
}