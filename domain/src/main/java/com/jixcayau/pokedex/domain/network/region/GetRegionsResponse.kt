package com.jixcayau.pokedex.domain.network.region

import com.jixcayau.pokedex.domain.entities.Region

data class GetRegionsResponse(
    val count: Int,
    val next: Int?,
    val previous: Int?,
    val results: List<Region>
)