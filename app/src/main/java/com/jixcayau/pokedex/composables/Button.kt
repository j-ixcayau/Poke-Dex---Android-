package com.jixcayau.pokedex.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.ui.theme.Shapes


@Composable
fun PokeButton(
    text: String,
    onTap: () -> Unit,
    color: Color = Colors.Accent,
) {
    Button(
        onClick = onTap,
        shape = Shapes.medium,
        colors = ButtonDefaults.buttonColors(
            contentColor = Colors.White,
            backgroundColor = color,
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