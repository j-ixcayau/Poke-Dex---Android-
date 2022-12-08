package com.jixcayau.pokedex.features.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jixcayau.pokedex.data.repositories.region.GetRegionsRepository
import com.jixcayau.pokedex.domain.entities.Region

class LoginViewModel : ViewModel() {

    var regions: List<Region> by mutableStateOf(listOf())

    fun loadRegions() {
        GetRegionsRepository().getRegions(
            {
                regions = it.results
            },
            {
                println("Error")
            }
        )
    }
}