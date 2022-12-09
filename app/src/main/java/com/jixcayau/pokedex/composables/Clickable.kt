package com.jixcayau.pokedex.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jixcayau.pokedex.utils.AppSpaces

@Composable
fun Clickable(
    radius: Int = AppSpaces.xxl,
    onTap: () -> Unit,
    child: @Composable () -> Unit,
) {
    val shape = RoundedCornerShape(radius.dp)

    Card(
        shape = shape,
        modifier = Modifier
            .clip(shape)
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = rememberRipple(bounded = false),
                onClick = {
                    onTap()
                },
            ),
        backgroundColor = Color.Transparent,
        elevation = AppSpaces.zero.dp,
    ) {
        child()
    }
}