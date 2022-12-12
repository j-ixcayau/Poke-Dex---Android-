package com.jixcayau.pokedex.features.regions

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jixcayau.pokedex.data.repositories.region.GetRegionsRepositoryImpl
import com.jixcayau.pokedex.domain.entities.Region

class RegionsViewModel : ViewModel() {
    private val regionsRepository = GetRegionsRepositoryImpl()

    var regions by mutableStateOf<List<Region>>(listOf())

    init {
        loadRegions()
    }

    private fun loadRegions() {
        if (regions.isNotEmpty()) return

        regionsRepository.getRegions(
            {
                regions = it.results
            },
            {
                println("Error")
            },
        )
    }
}