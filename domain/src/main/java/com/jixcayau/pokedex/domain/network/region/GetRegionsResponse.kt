package com.jixcayau.pokedex.domain.network.region

import com.jixcayau.pokedex.domain.entities.Region

data class GetRegionsResponse(
    val results: List<Region>
)