package com.jixcayau.pokedex.features.teams.detail.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.jixcayau.pokedex.composables.HorizontalSpace
import com.jixcayau.pokedex.composables.Label
import com.jixcayau.pokedex.utils.AppSpaces

@Composable
fun DetailInfoLabel(
    @StringRes title: Int,
    value: String?,
) {
    value?.let {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Label(
                value = stringResource(title),
                fontWeight = FontWeight.Bold,
            )

            HorizontalSpace(AppSpaces.xxs)

            Label(
                value = value,
            )
        }
    }
}