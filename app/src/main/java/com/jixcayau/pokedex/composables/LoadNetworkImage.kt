package com.jixcayau.pokedex.composables

import com.jixcayau.pokedex.R
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.SubcomposeAsyncImage
import com.airbnb.lottie.compose.*
import com.jixcayau.pokedex.utils.Utils


@Composable
fun LoadNetworkImage(
    url: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = "Network Image",
    contentScale: ContentScale = ContentScale.Fit,
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.JsonString(Utils.splashLottie),
    )
    val logoAnimationState = animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )

    SubcomposeAsyncImage(
        model = url,
        loading = {
            LottieAnimation(
                composition = composition,
                progress = { logoAnimationState.progress },
                modifier = modifier
            )
        },
        error = {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = contentDescription,
                contentScale = contentScale,
                modifier = modifier,
            )
        },
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier,
    )
}