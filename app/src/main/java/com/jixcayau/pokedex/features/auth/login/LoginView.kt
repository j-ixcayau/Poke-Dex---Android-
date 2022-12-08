package com.jixcayau.pokedex.features.auth.login

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jixcayau.pokedex.composables.BaseBody
import com.jixcayau.pokedex.domain.entities.Region

@Composable
fun LoginView(
    regions: List<Region>
) {
    BaseBody {
        regions.forEach {
            Text(
                text = it.name,
            )
        }
    }
}

@Preview
@Composable
private fun LoginViewPreview() {
    BaseBody {

    }
}