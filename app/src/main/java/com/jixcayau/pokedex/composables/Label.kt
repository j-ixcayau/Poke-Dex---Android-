package com.jixcayau.pokedex.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.jixcayau.pokedex.utils.AppSpaces

@Composable
fun Label(
    value: String,
    type: LabelType = LabelType.Normal,
    color: Color = Color.Unspecified,
) {
    Text(
        text = value,
        fontWeight = type.fontWeight(),
        fontSize = type.fontSize(),
        color = color,
    )
}


enum class LabelType {
    Title,
    Subtitle,
    Normal,
}


fun LabelType.fontWeight(): FontWeight {
    return when (this) {
        LabelType.Title -> FontWeight.Bold
        LabelType.Subtitle -> FontWeight.SemiBold
        LabelType.Normal -> FontWeight.Normal
    }
}

fun LabelType.fontSize(): TextUnit {
    return when (this) {
        LabelType.Title -> AppSpaces.xl.sp
        LabelType.Subtitle -> AppSpaces.l.sp
        LabelType.Normal -> AppSpaces.s.sp
    }
}