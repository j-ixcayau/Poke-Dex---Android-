package com.jixcayau.pokedex.composables;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.utils.AppSpaces

@Composable
fun Appbar(
    onBackTap: (() -> Unit)?,
    title: String,
) {
    TopAppBar(
        backgroundColor = Color.Transparent,
        contentColor = Colors.White,
        elevation = AppSpaces.zero.dp,
        content = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                onBackTap.let {
                    if (it == null) {
                        VerticalSpace(AppSpaces.zero)
                    } else {
                        Clickable(
                            onTap = it,
                            child = {
                                Icon(
                                    Icons.Default.ArrowBack,
                                    contentDescription = "stringResource(id = R.string.shopping_cart_content_desc)",
                                )
                            },
                        )
                    }
                }

                Label(
                    value = title,
                    type = LabelType.Subtitle,
                    color = Colors.White,
                )

                VerticalSpace(AppSpaces.zero)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Colors.Accent,
                        Colors.AuthAccentGradient,
                    )
                )
            ),
    )
}