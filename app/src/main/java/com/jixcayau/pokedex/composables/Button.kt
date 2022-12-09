package com.jixcayau.pokedex.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.ui.theme.Shapes


@Composable
fun PokeButton(
    text: String,
    onTap: () -> Unit,
) {
    Button(
        onClick = onTap,
        shape = Shapes.medium,
        colors = ButtonDefaults.buttonColors(
            contentColor = Colors.White,
            backgroundColor = Colors.Accent,
            disabledContentColor = Colors.White,
            disabledBackgroundColor = Colors.AuthAccentGradient
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        contentPadding = ButtonDefaults.ContentPadding,
    ) {
        Text(
            text = text,
        )
    }
}