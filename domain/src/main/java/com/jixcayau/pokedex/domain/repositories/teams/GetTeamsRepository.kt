package com.jixcayau.pokedex.domain.repositories.teams

import com.jixcayau.pokedex.domain.network.teams.list.GetTeamsRequest
import com.jixcayau.pokedex.domain.network.teams.list.GetTeamsResponse

interface GetTeamsRepository {
    fun getTeams(
        request: GetTeamsRequest,
        success: (response: GetTeamsResponse) -> Unit,
        failure: () -> Unit,
    )
}