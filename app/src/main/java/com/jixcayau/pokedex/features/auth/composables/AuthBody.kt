package com.jixcayau.pokedex.features.auth.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jixcayau.pokedex.composables.BaseBody
import com.jixcayau.pokedex.composables.Clickable
import com.jixcayau.pokedex.composables.HorizontalSpace
import com.jixcayau.pokedex.composables.VerticalSpace
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.utils.AppSpaces

@Composable
fun AuthBody(
    onBackTap: (() -> Unit)?,
    actionTitle: String,
    actionButtonText: String,
    actionOnTap: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {
    Scaffold(
        backgroundColor = Color.Transparent,
        modifier = Modifier.background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Colors.Accent,
                    Colors.AuthAccentGradient,
                )
            )
        ),
        topBar = {
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

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {


                            TextButton(
                                onClick = actionOnTap,
                                content = {
                                    Text(
                                        actionTitle,
                                        color = Colors.White,
                                        fontWeight = FontWeight.Normal,

                                        )

                                    HorizontalSpace(AppSpaces.xxs2)

                                    Text(
                                        actionButtonText,
                                    )
                                },
                            )
                        }
                    }
                },
            )
        },
    ) {
        Column(
            Modifier.padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            VerticalSpace(AppSpaces.xl)

            Text(
                text = "Poke Dex by Jony",
                color = Colors.White,
                fontWeight = FontWeight.Bold,
                fontSize = AppSpaces.xl.sp,
            )

            VerticalSpace(AppSpaces.xxl4)

            BaseBody(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topEnd = AppSpaces.l.dp,
                            topStart = AppSpaces.l.dp
                        )
                    )
                    .background(Colors.PrimaryColor),
                color = Color.Transparent,
                children = content,
            )
        }
    }
}