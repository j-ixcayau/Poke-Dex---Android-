package com.jixcayau.pokedex.features.auth.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jixcayau.pokedex.composables.Clickable
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.utils.AppSpaces

@Composable
fun SocialButton(
    @DrawableRes iconId: Int,
    onTap: () -> Unit,
) {
    Clickable(
        radius = AppSpaces.xxs,
        onTap = onTap,
        child = {
            Image(
                painter = painterResource(iconId),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .border(
                        width = AppSpaces.xxs2.dp,
                        color = Colors.Accent,
                        shape = RoundedCornerShape(AppSpaces.xxs.dp)
                    )
                    .size(AppSpaces.xxl2.dp)
                    .padding(AppSpaces.xs.dp),
            )
        },
    )
}