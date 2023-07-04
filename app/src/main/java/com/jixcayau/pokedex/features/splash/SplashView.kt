package com.jixcayau.pokedex.features.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import com.jixcayau.pokedex.extensions.splashBackground
import com.jixcayau.pokedex.ui.theme.Colors
import com.jixcayau.pokedex.ui.theme.PokeDexTheme
import com.jixcayau.pokedex.utils.Utils

@Composable
fun SplashView(
    onComplete: () -> Unit,
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.JsonString(Utils.splashLottie),
    )
    val logoAnimationState = animateLottieCompositionAsState(
        composition = composition,
    )

    PokeDexTheme {
        Surface(
            color = Colors.PrimaryColor,
            modifier = Modifier.fillMaxSize(),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .splashBackground(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                LottieAnimation(
                    composition = composition,
                    progress = { logoAnimationState.progress },
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp),
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
        onComplete = {},
    )
}