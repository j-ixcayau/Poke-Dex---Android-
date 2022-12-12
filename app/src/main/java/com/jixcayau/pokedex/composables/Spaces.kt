package com.jixcayau.pokedex.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VerticalSpace(
    space: Int,
    modifier: Modifier = Modifier,
) {
    Spacer(
        modifier = modifier.height(
            space.dp,
        )
    )
}

@Composable
fun HorizontalSpace(
    space: Int,
    modifier: Modifier = Modifier,
) {
    Spacer(
        modifier = modifier.width(
            space.dp,
        )
    )
}