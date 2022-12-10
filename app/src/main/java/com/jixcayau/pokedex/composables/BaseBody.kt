package com.jixcayau.pokedex.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.utils.AppSpaces

@Composable
fun BaseBody(
    modifier: Modifier = Modifier,
    allowScroll: Boolean = true,
    children: @Composable ColumnScope.() -> Unit,
    color: Color = Colors.PrimaryColor
) {
    Surface(
        color = color,
        modifier = modifier
            .fillMaxSize()
            .background(
                color = color,
            ),
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(
                    state = rememberScrollState(),
                    enabled = allowScroll,
                )
                .fillMaxSize()
                .padding(
                    AppSpaces.xs.dp,
                    AppSpaces.xxs.dp,
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            children()
        }
    }
}