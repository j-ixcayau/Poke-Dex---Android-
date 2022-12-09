package com.jixcayau.pokedex.features.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jixcayau.pokedex.composables.BaseBody
import com.jixcayau.pokedex.composables.BaseScaffold
import com.jixcayau.pokedex.composables.Label
import com.jixcayau.pokedex.composables.LabelType

@Composable
fun DashboardView() {
    BaseScaffold {
        Scaffold {
            BaseBody(
                modifier = Modifier.padding(it),
                children = {
                    Label(
                        "Dashboard",
                        type = LabelType.Title,
                    )
                }
            )
        }
    }
}