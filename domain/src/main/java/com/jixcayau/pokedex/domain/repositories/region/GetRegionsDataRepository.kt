package com.jixcayau.pokedex.domain.repositories.region

import com.jixcayau.pokedex.domain.network.region.GetRegionsResponse

interface GetRegionsDataRepository {
    fun getRegions(success: (response: GetRegionsResponse) -> Unit, failure: () -> Unit)
}