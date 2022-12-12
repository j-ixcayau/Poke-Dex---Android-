package com.jixcayau.pokedex.composables

import androidx.compose.runtime.Composable
import com.jixcayau.pokedex.ui.theme.PokeDexTheme

@Composable
fun BaseScaffold(
    isLoading: Boolean = false,
    child: @Composable () -> Unit,
) {
    PokeDexTheme {
        child()
    }
}