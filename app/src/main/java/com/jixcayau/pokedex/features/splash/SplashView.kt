package com.jixcayau.pokedex.features.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.jixcayau.pokedex.ui.theme.PokeDexTheme
import com.jixcayau.pokedex.ui.theme.PrimaryColor
import com.jixcayau.pokedex.utils.Utils

@Composable
fun SplashView(
    onComplete: () -> Unit,
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.JsonString(Utils.lottieJson)
    )
    val logoAnimationState = animateLottieCompositionAsState(
        composition = composition,
    )

    PokeDexTheme {
        Surface(
            color = PrimaryColor,
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = PrimaryColor
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                LottieAnimation(
                    composition = composition,
                    progress = { logoAnimationState.progress },
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)

                )

                if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
                    onComplete()
                }
            }
        }
    }
}

@Preview
@Composable
private fun SplashViewPreview() {
    SplashView(
        onComplete = {
        }
    )
}