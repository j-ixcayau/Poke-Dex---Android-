package com.jixcayau.pokedex.features.regions

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jixcayau.pokedex.data.repositories.region.GetRegionsRepository
import com.jixcayau.pokedex.domain.entities.Region

class RegionsViewModel : ViewModel() {
    var regions by mutableStateOf<List<Region>>(listOf())

    init {
        loadRegions()
    }

    private fun loadRegions() {
        if (regions.isNotEmpty()) return

        GetRegionsRepository().getRegions(
            {
                regions = it.results
            },
            {
                println("Error")
            },
        )
    }
}