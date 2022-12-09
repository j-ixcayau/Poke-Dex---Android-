package com.jixcayau.pokedex.features.auth.login

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.jixcayau.pokedex.composables.BaseBody
import com.jixcayau.pokedex.domain.entities.Region

@Composable
fun LoginView() {
    val viewModel = remember {
        LoginViewModel()
    }
    viewModel.loadRegions()

    Content(
        regions = viewModel.regions,
    )
}

@Composable
private fun Content(
    regions: List<Region>,
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
private fun ContentPreview() {
    Content(
        regions = listOf(
            Region(
                name = "Kanto",
                url = "",
            ),
            Region(
                name = "Johto",
                url = "",
            ),
            Region(
                name = "Hoenn",
                url = "",
            ),
        )
    )
}